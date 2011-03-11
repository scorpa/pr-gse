package persistenz;

import java.sql.PreparedStatement;
import fachlogik.Mitarbeiter;
import fachlogik.ZeitStempel;
import fachlogik.Zeiterfassung;
import fachlogik.ZeiterfassungException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rudolf Radlbauer
 */
public class DBZeiterfassung implements Zeiterfassung
{
    private Connection con;

    public DBZeiterfassung() throws ZeiterfassungException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/zeiterfassung", "pr", "pr");
        } catch (SQLException ex)
        {
            Logger.getLogger(DBZeiterfassung.class.getName()).log(Level.SEVERE, null, ex);
            throw new ZeiterfassungException("keine Verbindung zur Datenbank");
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(DBZeiterfassung.class.getName()).log(Level.SEVERE, null, ex);
            throw new ZeiterfassungException("DB-Treiber nicht gefunden");
        }
    }

    public boolean login(Mitarbeiter m) throws ZeiterfassungException
    {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            pstmt = con.prepareStatement("SELECT m_name, m_stunden FROM mitarbeiter " +
                    "WHERE m_nr = ? AND m_pwd = ?");
            pstmt.setInt(1, m.getNr());
            pstmt.setString(2, m.getPwd());
            rs = pstmt.executeQuery();
            if (rs.next())
            {
                m.setName(rs.getString("m_name"));
                m.setStunden(rs.getInt("m_stunden"));
                return true;
            }
            else
                return false;
        } catch (SQLException ex)
        {
            Logger.getLogger(DBZeiterfassung.class.getName()).log(Level.SEVERE, null, ex);
            throw new ZeiterfassungException("Datenbankfehler");
        }
        finally
        {
            try
            {
                if (pstmt != null)
                    pstmt.close();
                if (rs != null)
                    rs.close();
            } catch(SQLException ex)
            {
                Logger.getLogger(DBZeiterfassung.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<ZeitStempel> aktuelleZeiten(Mitarbeiter m) throws ZeiterfassungException
    {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            List<ZeitStempel> liste = new ArrayList<ZeitStempel>();
            pstmt = con.prepareStatement("SELECT z_id, z_kommen, z_timestamp " +
                    "FROM zeitstempel " +
                    "WHERE fk_m_id = ? AND z_timestamp BETWEEN ? AND ? " +
                    "ORDER BY z_id");
            pstmt.setInt(1, m.getNr());
            pstmt.setTimestamp(2, new Timestamp(ersterTag().getTime()));
            pstmt.setTimestamp(3, new Timestamp(letzterTag().getTime()));
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                ZeitStempel z = new ZeitStempel();
                z.setId(rs.getInt("z_id"));
                z.setKommen(rs.getBoolean("z_kommen"));
                z.setTimestamp(rs.getTimestamp("z_timestamp"));
                liste.add(z);
            }

            return liste;
        } catch (SQLException ex)
        {
            Logger.getLogger(DBZeiterfassung.class.getName()).log(Level.SEVERE, null, ex);
            throw new ZeiterfassungException("Datenbankfehler");
        }
        finally
        {
            try
            {
                if (pstmt != null)
                    pstmt.close();
                if (rs != null)
                    rs.close();
            } catch(SQLException ex)
            {
                Logger.getLogger(DBZeiterfassung.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public float zeitSaldo(Mitarbeiter m) throws ZeiterfassungException
    {
        float summe = 0;
        ZeitStempel kommen = null;
        for (ZeitStempel z : aktuelleZeiten(m))
        {
            if (z.isKommen())
                kommen = z;
            else
                summe += (z.getTimestamp().getTime() - kommen.getTimestamp().getTime()) / 3600000f;
        }
        return summe;
    }

    public ZeitStempel letzterEintrag(Mitarbeiter m) throws ZeiterfassungException
    {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            pstmt = con.prepareStatement("SELECT z_id, z_kommen, z_timestamp " +
                    "FROM zeitstempel " +
                    "WHERE z_id = (SELECT MAX(z_id) FROM zeitstempel)");
            rs = pstmt.executeQuery();
            if (rs.next())
            {
                ZeitStempel z = new ZeitStempel();
                z.setId(rs.getInt("z_id"));
                z.setKommen(rs.getBoolean("z_kommen"));
                z.setTimestamp(rs.getTimestamp("z_timestamp"));
                return z;
            }
            else
                return null;

        } catch (SQLException ex)
        {
            Logger.getLogger(DBZeiterfassung.class.getName()).log(Level.SEVERE, null, ex);
            throw new ZeiterfassungException("Datenbankfehler");
        }
        finally
        {
            try
            {
                if (pstmt != null)
                    pstmt.close();
                if (rs != null)
                    rs.close();
            } catch(SQLException ex)
            {
                Logger.getLogger(DBZeiterfassung.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void eintrag(ZeitStempel z, Mitarbeiter m) throws ZeiterfassungException
    {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            pstmt = con.prepareStatement("INSERT INTO zeitstempel (fk_m_id, z_kommen, z_timestamp) " +
                    "VALUES (?, ?, ?)");
            pstmt.setInt(1, m.getNr());
            pstmt.setBoolean(2, z.isKommen());
            pstmt.setTimestamp(3, new Timestamp(z.getTimestamp().getTime()));
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            rs.next();
            z.setId(rs.getInt(1));

        } catch (SQLException ex)
        {
            Logger.getLogger(DBZeiterfassung.class.getName()).log(Level.SEVERE, null, ex);
            throw new ZeiterfassungException("Datenbankfehler");
        }
        finally
        {
            try
            {
                if (pstmt != null)
                    pstmt.close();
                if (rs != null)
                    rs.close();
            } catch(SQLException ex)
            {
                Logger.getLogger(DBZeiterfassung.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void speichern(Mitarbeiter m) throws ZeiterfassungException
    {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            pstmt = con.prepareStatement("INSERT INTO mitarbeiter (m_name, m_pwd, m_stunden) " +
                    "VALUES (?, ?, ?)");
            pstmt.setString(1, m.getName());
            pstmt.setString(2, m.getPwd());
            pstmt.setInt(3, m.getStunden());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            rs.next();
            m.setNr(rs.getInt(1));
        } catch (SQLException ex)
        {
            Logger.getLogger(DBZeiterfassung.class.getName()).log(Level.SEVERE, null, ex);
            throw new ZeiterfassungException("Datenbankfehler");
        }
        finally
        {
            try
            {
                if (pstmt != null)
                    pstmt.close();
                if (rs != null)
                    rs.close();
            } catch(SQLException ex)
            {
                Logger.getLogger(DBZeiterfassung.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Mitarbeiter> mitarbeiterListe() throws ZeiterfassungException
    {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            List<Mitarbeiter> liste = new ArrayList<Mitarbeiter>();
            pstmt = con.prepareStatement("SELECT m_nr, m_name, m_pwd, m_stunden " +
                    "FROM mitarbeiter");
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                Mitarbeiter m = new Mitarbeiter();
                m.setNr(rs.getInt("m_nr"));
                m.setName(rs.getString("m_name"));
                m.setPwd(rs.getString("m_pwd"));
                m.setStunden(rs.getInt("m_stunden"));
                liste.add(m);
            }
            return liste;
        } catch (SQLException ex)
        {
            Logger.getLogger(DBZeiterfassung.class.getName()).log(Level.SEVERE, null, ex);
            throw new ZeiterfassungException("Datenbankfehler");
        }
        finally
        {
            try
            {
                if (pstmt != null)
                    pstmt.close();
                if (rs != null)
                    rs.close();
            } catch(SQLException ex)
            {
                Logger.getLogger(DBZeiterfassung.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void close() throws ZeiterfassungException
    {
        try
        {
            if (con != null)
                con.close();
        } catch (SQLException ex)
        {
            Logger.getLogger(DBZeiterfassung.class.getName()).log(Level.SEVERE, null, ex);
            throw new ZeiterfassungException("Fehler beim Schlieﬂen der Datenbankverbindung");
        }
    }

    private static Date ersterTag()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }


    private static Date letzterTag()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 23);
        cal.set(Calendar.SECOND, 23);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }



}
