package theater;


 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class ReservierungsToolImpl implements ReservierungsTool
{
    private Connection con;

    public ReservierungsToolImpl() throws ReservierungException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/theater", "pr", "pr");
        } catch (SQLException ex)
        {
            Logger.getLogger(ReservierungsToolImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ReservierungException("kann Datenbank nicht öffnen");
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ReservierungsToolImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ReservierungException("kann Treiber nicht laden");
        }
    }

    public List<Vorstellung> vorstellungsListe(Date datum) throws ReservierungException
    {
        // berechne Datum mit Zeit 00:00:00.000 bzw. 23:59:59.999
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datum);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date beginn = calendar.getTime();
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date ende = calendar.getTime();

        List<Vorstellung> liste = new ArrayList<Vorstellung>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            pstmt = con.prepareStatement("SELECT v_id, v_name, v_datum " +
                    "FROM vorstellungen " +
                    "WHERE v_datum BETWEEN ? AND ? " +
                    "ORDer BY v_datum");
            pstmt.setTimestamp(1, new Timestamp(beginn.getTime()));
            pstmt.setTimestamp(2, new Timestamp(ende.getTime()));
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                Vorstellung v = new Vorstellung();
                v.setDatum(rs.getTimestamp("v_datum"));
                v.setId(rs.getInt("v_id"));
                v.setName(rs.getString("v_name"));
                liste.add(v);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(ReservierungsToolImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ReservierungException("Datenbankfehler");
        }
        finally
        {
            try
            {
                if (rs != null)
                    rs.close();
                if (pstmt !=  null)
                    pstmt.close();
            } catch (SQLException ex)
            {
                Logger.getLogger(ReservierungsToolImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return liste;
    }

    public boolean speichern(Reservierung r) throws ReservierungException
    {
// einfache Loesung - aber nicht sehr effizient
//        for (Reservierung r1 : reservierungsListe(r.getVorstellung()))
//            if (r1.getSitzplatz() == r.getSitzplatz())
//                return false;

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            pstmt = con.prepareStatement("SELECT r_id FROM reservierungen " +
                    "WHERE fk_v_id = ? and r_sitzplatz = ?");
            pstmt.setInt(1, r.getVorstellung().getId());
            pstmt.setInt(2, r.getSitzplatz());
            rs = pstmt.executeQuery();
            boolean besetzt = rs.next();
            rs.close();
            pstmt.close();
            if (besetzt)
                return false;

            pstmt = con.prepareStatement("INSERT INTO reservierungen (fk_v_id, r_sitzplatz, r_name) " +
                    "VALUES (?, ?, ?)");
            pstmt.setInt(1, r.getVorstellung().getId());
            pstmt.setInt(2, r.getSitzplatz());
            pstmt.setString(3, r.getName());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs.next())
               r.setId(rs.getInt(1));
            else
                throw new ReservierungException("Fehler beim Auslesen der Reservierungsnummer");

            return true;
        } catch (SQLException ex)
        {
            Logger.getLogger(ReservierungsToolImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ReservierungException("Datenbankfehler beim Speichern");
        }
        finally
        {
            try
            {
                if (rs != null)
                    rs.close();
                if (pstmt !=  null)
                    pstmt.close();
            } catch (SQLException ex)
            {
                Logger.getLogger(ReservierungsToolImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public int freiePlaetze(Vorstellung v) throws ReservierungException
    {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            pstmt = con.prepareStatement("SELECT COUNT(*) AS anzahl FROM reservierungen " +
                    "WHERE fk_v_id = ?");
            pstmt.setInt(1, v.getId());
            rs = pstmt.executeQuery();
            if (rs.next())
                return 100 - rs.getInt("anzahl");
            else
                throw new ReservierungException("Datenbankfehler");

        } catch (SQLException ex)
        {
            Logger.getLogger(ReservierungsToolImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ReservierungException("Datenbankfehler");
        }
        finally
        {
            try
            {
                if (rs != null)
                    rs.close();
                if (pstmt !=  null)
                    pstmt.close();
            } catch (SQLException ex)
            {
                Logger.getLogger(ReservierungsToolImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Reservierung> reservierungsListe(Vorstellung v) throws ReservierungException
    {
        List<Reservierung> liste = new ArrayList<Reservierung>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            pstmt = con.prepareStatement("SELECT r_id, r_sitzplatz, r_name " +
                    "FROM reservierungen " +
                    "WHERE fk_v_id = ?");
            pstmt.setInt(1, v.getId());
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                Reservierung r = new Reservierung(v);
                r.setId(rs.getInt("r_id"));
                r.setName(rs.getString("r_name"));
                r.setSitzplatz(rs.getInt("r_sitzplatz"));
                r.setVorstellung(v);
                liste.add(r);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(ReservierungsToolImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ReservierungException("Datenbankfehler");
        }
        finally
        {
            try
            {
                if (rs != null)
                    rs.close();
                if (pstmt !=  null)
                    pstmt.close();
            } catch (SQLException ex)
            {
                Logger.getLogger(ReservierungsToolImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return liste;
    }

}
