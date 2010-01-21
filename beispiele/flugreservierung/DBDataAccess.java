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
            con = DriverManager.getConnection("jdbc:mysql://localhost/flugreservierung", "root", "asterix");
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
            String query = "SELECT flugnummer, von, nach, start, ankunft, sitzplaetze " + "FROM fluege";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                Flug f = new Flug();
                f.setNummer(rs.getInt("flugnummer"));
                f.setVon(rs.getString("von"));
                f.setNach(rs.getString("nach"));
                f.setStart(rs.getDate("start"));
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

    public void speichern(Reservierung r) throws FlugReservierungsException
    {
        throw new UnsupportedOperationException("Not supported yet.");
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

}
