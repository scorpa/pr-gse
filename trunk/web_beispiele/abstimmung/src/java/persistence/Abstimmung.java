package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Abstimmung
{
    private Connection con;

    public Abstimmung() throws AbstimmungException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/test", "pr", "pr");
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new AbstimmungException("Treiber nicht gefunden");
        } catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
            throw new AbstimmungException("kann Datenbank nicht öffnen");
        }
    }

    public void abstimmen(boolean zustimmung) throws AbstimmungException
    {
        try
        {
            String sql = "INSERT INTO stimmen (zeit, zustimmung) VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setDate(1, new Date(System.currentTimeMillis()));
            pstmt.setBoolean(2, zustimmung);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new AbstimmungException("Datenbankfehler");
        }
    }

    public Statistik statistik() throws AbstimmungException
    {
        try
        {
            int ja = 0;
            int nein = 0;
            String sql = "SELECT COUNT(*) FROM stimmen WHERE zustimmung = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setBoolean(1, true);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            ja = rs.getInt(1);
            pstmt.setBoolean(1, false);
            rs = pstmt.executeQuery();
            rs.next();
            nein = rs.getInt(1);
            rs.close();
            pstmt.close();

            return new Statistik(ja, nein);
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new AbstimmungException("Datenbankfehler");
        }
    }

    public static void main(String[] args)
    {
        try
        {
            Abstimmung abstimmung = new Abstimmung();
            abstimmung.abstimmen(true);
            abstimmung.abstimmen(false);
            System.out.println(abstimmung.statistik().zustimmungProzent());
        } catch (AbstimmungException ex)
        {
            Logger.getLogger(Abstimmung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
