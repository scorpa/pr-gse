package flugres.persistenz;

import flugres.fachlogik.Flug;
import flugres.fachlogik.FlugReservierungsDAO;
import flugres.fachlogik.Reservierung;
import flugres.fachlogik.ReservierungsException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBFlugReservierungsDAO implements FlugReservierungsDAO
{
    // caching der bereits im Speicher befindlichen Objekte
    private Map<Integer, Flug> flugCache = new HashMap<Integer, Flug>();
    private Map<Integer, Reservierung> reservierungCache = new HashMap<Integer, Reservierung>();
    

    @Override
    public void speichern(Flug f) throws ReservierungsException
    {
        if (f.isChanged())  // gibt es überhaupt etwas zu speichern
        {
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try
            {
                if (f.getId() > 0)  
                {   // diese Instanz stammt schon aus der Datenbank --> update
                    
                    // update nur dann, wenn letztes_update gleich geblieben ist
                    // andernfalls wurde der Datensatz von jemand anderem geändert
                    // (lost update verhindern)
                    pstmt = ConnectionController.getConnection().prepareStatement
                            ("UPDATE fluege SET von = ?, nach = ?, datum = ?, letztes_update = ? "
                            + "WHERE id = ? AND letztes_update = ?");
                    pstmt.setString(1, f.getVon());
                    pstmt.setString(2, f.getNach());
                    pstmt.setDate(3, new java.sql.Date(f.getTag().getTime()));
                    Date now = new Date();  // neuer Timestamp für letztes_update
                    pstmt.setTimestamp(4, new java.sql.Timestamp(now.getTime()));
                    pstmt.setInt(5, f.getId());
                    pstmt.setTimestamp(6, new Timestamp(f.getLetztesUpdate().getTime()));
                    if (pstmt.executeUpdate() != 1)
                        throw new ReservierungsException("Flug-Instanz nicht mehr aktuell");
                    f.setLetztesUpdate(now);
                }
                else
                {   // diese Instanz ist neu und noch nicht in der Datenbank
                                      
                    pstmt = ConnectionController.getConnection().prepareStatement
                            ("INSERT INTO fluege (von, nach, datum, letztes_update) "
                            + "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                    // RETURN_GENERATED_KEYS, damit getGeneratedKeys() funktioniert
                    pstmt.setString(1, f.getVon());
                    pstmt.setString(2, f.getNach());
                    pstmt.setDate(3, new java.sql.Date(f.getTag().getTime()));
                    Date now = new Date();   // neuer Timestamp für letztes_update
                    pstmt.setTimestamp(4, new java.sql.Timestamp(now.getTime()));
                    pstmt.executeUpdate();
                    rs = pstmt.getGeneratedKeys();
                    if (rs.next())
                        f.setId(rs.getInt(1));
                    else
                        throw new ReservierungsException("kann neu generierten DB-Schlüssel nicht auslesen");
                    f.setLetztesUpdate(now);
                    flugCache.put(f.getId(), f);  // neue Instanz --> cache
                }

 
            } catch(SQLException e)
            {
                throw new ReservierungsException("Fehler beim Speichern", e);
            }
            finally
            {
                try
                {
                    if (rs != null) rs.close();
                    if (pstmt != null) pstmt.close();
                } catch(SQLException e)
                {
                    Logger.getLogger(DBFlugReservierungsDAO.class.getName())
                            .warning("Fehler beim Schließen von ResultSet oder PreparedStatement");
                }
            }
        }
        
        // speichere nun alle Reservierungen des Fluges
        for (Reservierung r : f.getReservierungen())
        {
            if (r.isChanged())        
                speichern(r, f);
        }
    }

    @Override
    public List<Flug> finden(Date tag) throws ReservierungsException
    {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try
        {
            List<Flug> liste = new ArrayList<Flug>();
            pstmt = ConnectionController.getConnection().prepareStatement
                    ("SELECT id, von, nach, datum, letztes_update FROM fluege "
                    + "WHERE datum = ?"); 
            pstmt.setDate(1, new java.sql.Date(tag.getTime()));
            rs = pstmt.executeQuery();
            while(rs.next())
            {       
                // überprüfe, ob Instanz bereits im cache
                int id = rs.getInt("id");
                Flug f = flugCache.get(id);
                if (f == null)
                {
                    f = new Flug();
                    f.setId(id);
                    flugCache.put(id, f);
                }
                f.setVon(rs.getString("von"));
                f.setNach(rs.getString("nach"));
                f.setTag(rs.getDate("datum"));
                f.setLetztesUpdate(rs.getTimestamp("letztes_update"));
                
                // füge nun alle Reservierungen ein (eager initialization)
                f.getReservierungen().clear();
                for (Reservierung r : finden(f))
                    f.neueReservierung(r);
                
                liste.add(f);
            }
            return liste;
        } catch (SQLException ex)
        {
            throw new ReservierungsException("Fehler beim Laden der Flüge", ex);
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch(SQLException e)
            {
                Logger.getLogger(DBFlugReservierungsDAO.class.getName())
                        .warning("Fehler beim Schließen von ResultSet oder PreparedStatement");
            }
        }
    }

    @Override
    public Flug finden(int id) throws ReservierungsException
    {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try
        {
            pstmt = ConnectionController.getConnection().prepareStatement
                    ("SELECT von, nach, datum, letztes_update FROM fluege "
                    + "WHERE id = ?"); 
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.next())
            {                
                Flug f = flugCache.get(id);
                if (f == null)
                {
                    f = new Flug();
                    f.setId(id);
                    flugCache.put(id, f);
                }
                f.setVon(rs.getString("von"));
                f.setNach(rs.getString("nach"));
                f.setTag(rs.getDate("datum"));
                f.setLetztesUpdate(rs.getTimestamp("letztes_update"));
                
                // füge alle Reservierungen ein (eager initialization)
                f.getReservierungen().clear();
                for (Reservierung r : finden(f))
                    f.neueReservierung(r);

                return f;
            }
            else
                return null;
        } catch (SQLException ex)
        {
            throw new ReservierungsException("Fehler beim Laden der Flüge", ex);
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch(SQLException e)
            {
                Logger.getLogger(DBFlugReservierungsDAO.class.getName())
                        .warning("Fehler beim Schließen von ResultSet oder PreparedStatement");
            }
        }
    }

    @Override
    public List<Reservierung> finden(Flug f) throws ReservierungsException
    {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try
        {
            List<Reservierung> liste = new ArrayList<Reservierung>();
            pstmt = ConnectionController.getConnection().prepareStatement
                    ("SELECT id, name, letztes_update FROM reservierungen "
                    + "WHERE fk_f_id = ?"); 
            pstmt.setInt(1, f.getId());
            rs = pstmt.executeQuery();
            while(rs.next())
            {            
                int id = rs.getInt("id");
                // Überprüfung, ob bereits im cache
                Reservierung r = reservierungCache.get(id);
                if (r == null)
                {
                    r = new Reservierung();
                    r.setNr(id);
                    reservierungCache.put(id, r);
                }
                r.setName(rs.getString("name"));
                r.setLetztesUpdate(rs.getTimestamp("letztes_update"));
                liste.add(r);
            }
            return liste;
        } catch (SQLException ex)
        {
            throw new ReservierungsException("Fehler beim Laden der Flüge", ex);
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch(SQLException e)
            {
                Logger.getLogger(DBFlugReservierungsDAO.class.getName())
                        .warning("Fehler beim Schließen von ResultSet oder PreparedStatement");
            }
        }
    }



    @Override
    public void speichern(Reservierung r, Flug f) throws ReservierungsException
    {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        if (r.isChanged())  // gibt es überhaupt etwas zu speichern
        {
            try
            {
                if (r.getNr() > 0)
                {
                    // bereits in Datenbank vorhanden

                    pstmt = ConnectionController.getConnection().prepareStatement
                            ("UPDATE reservierungen SET fk_f_id = ?, name = ?, letztes_update = ? "
                            + "WHERE id = ? AND letztes_update = ?");
                    pstmt.setInt(1, f.getId());
                    pstmt.setString(2, r.getName());
                    Date now = new Date();   // neuer Timestamp für letztes_update
                    pstmt.setTimestamp(3, new Timestamp(now.getTime()));
                    pstmt.setInt(4, r.getNr());
                    pstmt.setTimestamp(5, new Timestamp(r.getLetztesUpdate().getTime()));
                    if (pstmt.executeUpdate() != 1)
                        throw new ReservierungsException("Reservierungs-Instanz nicht mehr aktuell");
                    r.setLetztesUpdate(now);
                }
                else
                {
                    pstmt = ConnectionController.getConnection().prepareStatement
                            ("INSERT INTO reservierungen (fk_f_id, name, letztes_update) "
                            + "VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                    pstmt.setInt(1, f.getId());
                    pstmt.setString(2, r.getName());
                    Date now = new Date();             
                    pstmt.setTimestamp(3, new java.sql.Timestamp(now.getTime()));
                    pstmt.executeUpdate();
                    rs = pstmt.getGeneratedKeys();
                    if (rs.next())
                        r.setNr(rs.getInt(1));
                    else
                        throw new ReservierungsException("kann neu generierten DB-Schlüssel nicht auslesen");
                    r.setLetztesUpdate(new Date());
                }

                reservierungCache.put(r.getNr(), r);
            } catch(SQLException e)
            {
                throw new ReservierungsException("Fehler beim Speichern", e);
            }
            finally
            {
                try
                {
                    if (rs != null) rs.close();
                    if (pstmt != null) pstmt.close();
                } catch(SQLException e)
                {
                    Logger.getLogger(DBFlugReservierungsDAO.class.getName())
                            .warning("Fehler beim Schließen von ResultSet oder PreparedStatement");
                }
            }
        }        
    }
    
    
    @Override
    public void close()
    {
        ConnectionController.close();
    }
    
}
