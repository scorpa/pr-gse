package flugreservierung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBDataAccess implements DataAccess{
    private Connection con;

    public DBDataAccess() throws FlugReservierungsException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/flugreservierung", "pr", "pr");
        } catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
            throw new FlugReservierungsException("kann Treiber nicht laden");
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new FlugReservierungsException("Datenbank nicht gefunden");
        }
    }
    public List<Flug> findeFluege() throws FlugReservierungsException
    {
        try
        {
            ArrayList<Flug> liste = new ArrayList<Flug>();
            String query = "SELECT flugnummer, von, nach, abflug, ankunft, sitzplaetze " + "FROM fluege";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                Flug f = new Flug();
                f.setNummer(rs.getInt("flugnummer"));
                f.setVon(rs.getString("von"));
                f.setNach(rs.getString("nach"));
                f.setStart(rs.getDate("abflug"));
                f.setAnkunft(rs.getDate("ankunft"));
                f.setSitzPlaetze(rs.getInt("sitzplaetze"));
                liste.add(f);
            }
            rs.close();
            pstmt.close();
            return liste;
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new FlugReservierungsException("Datenbankzugriffsfehler");
        }
    }

    public void speichern(Reservierung reservierung) throws FlugReservierungsException
    {
        try
        {
            Flug flug = reservierung.getFlug();
            int reserviert = 0;
            String sql = "SELECT COUNT(*) AS reserviert "
                    + "FROM reservierungen "
                    + "WHERE flugnummer = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, flug.getNummer());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                reserviert = rs.getInt("reserviert");
            else
                throw new FlugReservierungsException("kann Reservierungen nicht selektieren");
            rs.close();
            pstmt.close();
            if (reserviert >= flug.getSitzPlaetze())
                throw new FlugReservierungsException("keine Sitzplätze verfügbar");
            sql = "INSERT INTO reservierungen " +
                    "(flugnummer, passagier_name) " +
                    "VALUES (?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, flug.getNummer());
            pstmt.setString(2, reservierung.getName());
            if (pstmt.executeUpdate() != 1)
                throw new FlugReservierungsException("Fehler beim Einfügen eines Datensatzes");
            rs = pstmt.getGeneratedKeys();
            if (rs.next())
                reservierung.setNummer(rs.getInt(1));
            else
                throw new FlugReservierungsException("kann Reservierungsnummer nicht feststellen");
            rs.close();
            pstmt.close();


        } catch (SQLException ex)
        {
            throw new FlugReservierungsException("Fehler beim Speichern einer Reservierung: " + ex.getMessage());
        }

    }

    public void close() throws FlugReservierungsException
    {
        if (con != null)
            try
        {
            con.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new FlugReservierungsException("Fehler beim Schließen der Datenbank");
        }
    }

    public Flug finde(int flugNummer) throws FlugReservierungsException
    {
        Flug flug = null;
        try
        {
            String sql = "SELECT flugnummer, von, nach, abflug, ankunft, sitzplaetze " 
                    + "FROM fluege "
                    + "WHERE flugnummer = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, flugNummer);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                flug = new Flug();
                flug.setNummer(flugNummer);
                flug.setVon(rs.getString("von"));
                flug.setNach(rs.getString("nach"));
                flug.setStart(rs.getDate("abflug"));
                flug.setAnkunft(rs.getDate("ankunft"));
                flug.setSitzPlaetze(rs.getInt("sitzplaetze"));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex)
        {
            throw new FlugReservierungsException("Fehler beim finden eines Fluges: " + ex.getMessage());
        }

        return flug;
    }




}
