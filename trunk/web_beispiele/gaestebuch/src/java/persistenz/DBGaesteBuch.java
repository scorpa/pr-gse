package persistenz;

import fachlogik.Eintrag;
import fachlogik.GaesteBuch;
import fachlogik.GaesteBuchException;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rudolf Radlbauer
 */
public class DBGaesteBuch implements GaesteBuch
{
    private String treiber;
    private String url;
    private String user;
    private String pwd;
    private Connection con;

    public DBGaesteBuch(String treiber, String url, String user, String pwd) throws GaesteBuchException
    {
        this.treiber = treiber;
        this.url = url;
        this.user = user;
        this.pwd = pwd;
        connect();
    }

    private void connect() throws GaesteBuchException
    {
        try
        {
            if (con == null || con.isClosed())
            {
                Class.forName(treiber);
                con = DriverManager.getConnection(url, user, pwd);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(DBGaesteBuch.class.getName()).log(Level.SEVERE, null, ex);
            throw new GaesteBuchException("Datenbanktreiber nicht gefunden");
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(DBGaesteBuch.class.getName()).log(Level.SEVERE, null, ex);
            throw new GaesteBuchException("kann Datenbank nicht oeffnen");
        }
    }

    public void neu(Eintrag e) throws GaesteBuchException
    {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            pstmt = con.prepareStatement("INSERT INTO eintraege (e_text, e_ersteller, e_datum) " + "VALUES(?,?,?)");
            pstmt.setString(1, e.getText());
            pstmt.setString(2, e.getErsteller());
            pstmt.setTimestamp(3, new Timestamp(e.getDatum().getTime()));
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            rs.next();
            e.setId(rs.getInt(1));
        } catch (SQLException ex)
        {
            Logger.getLogger(DBGaesteBuch.class.getName()).log(Level.SEVERE, null, ex);
            throw new GaesteBuchException("Datenbankfehler beim Speichern eines Eintrags");
        }
        finally
        {
            try
            {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException ex)
            {
                Logger.getLogger(DBGaesteBuch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Eintrag> liste() throws GaesteBuchException
    {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            List<Eintrag> liste = new ArrayList<Eintrag>();
            pstmt = con.prepareStatement("SELECT e_id, e_text, e_ersteller, e_datum " +
                    "FROM eintraege");
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                Eintrag e = new Eintrag();
                e.setId(rs.getInt("e_id"));
                e.setText(rs.getString("e_text"));
                e.setErsteller(rs.getString("e_ersteller"));
                e.setDatum(rs.getTimestamp("e_datum"));
                liste.add(e);
            }
            return liste;
        } catch (SQLException ex)
        {
            Logger.getLogger(DBGaesteBuch.class.getName()).log(Level.SEVERE, null, ex);
            throw new GaesteBuchException("Datenbankfehler beim Auslesen der Eintraege");
        }
        finally
        {
            try
            {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException ex)
            {
                Logger.getLogger(DBGaesteBuch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public List<Eintrag> liste(String ersteller) throws GaesteBuchException
    {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            List<Eintrag> liste = new ArrayList<Eintrag>();
            pstmt = con.prepareStatement("SELECT e_id, e_text, e_ersteller, e_datum " +
                    "FROM eintraege " +
                    "WHERE e_ersteller = ?");

            pstmt.setString(1, ersteller);

            rs = pstmt.executeQuery();
            while(rs.next())
            {
                Eintrag e = new Eintrag();
                e.setId(rs.getInt("e_id"));
                e.setText(rs.getString("e_text"));
                e.setErsteller(rs.getString("e_ersteller"));
                e.setDatum(rs.getTimestamp("e_datum"));
                liste.add(e);
            }
            return liste;
        } catch (SQLException ex)
        {
            Logger.getLogger(DBGaesteBuch.class.getName()).log(Level.SEVERE, null, ex);
            throw new GaesteBuchException("Datenbankfehler beim Auslesen der Eintraege");
        }
        finally
        {
            try
            {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException ex)
            {
                Logger.getLogger(DBGaesteBuch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public void close()
    {
        try
        {
            if (con != null && !con.isClosed())
            {
                con.close();
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(DBGaesteBuch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    // nur zum Testen
    public static void main(String[] args)
    {
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            DBGaesteBuch dgb = new DBGaesteBuch("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/akdvk", "pr", "pr");
            
            Eintrag eintrag = new Eintrag();
            eintrag.setErsteller("Fritz");
            eintrag.setText("Mein Name ist Fritz, und das ist mein erster Eintrag");
            eintrag.setDatum(sdf.parse("20.5.2011 09:10"));
            dgb.neu(eintrag);

            eintrag = new Eintrag();
            eintrag.setErsteller("Susi");
            eintrag.setText("Meine Meinung zum Theman Schoko-Eis: super");
            eintrag.setDatum(sdf.parse("20.5.2011 10:20"));
            dgb.neu(eintrag);

            eintrag = new Eintrag();
            eintrag.setErsteller("Fritz");
            eintrag.setText("Ich finde Schoko-Eis auch super");
            eintrag.setDatum(sdf.parse("20.5.2011 12:10"));
            dgb.neu(eintrag);

            eintrag = new Eintrag();
            eintrag.setErsteller("Susi");
            eintrag.setText("Aber auch Vanille ist ganz gut");
            eintrag.setDatum(sdf.parse("20.5.2011 14:30"));
            dgb.neu(eintrag);

            System.out.println("=============== alle Eintraege ===============");
            for (Eintrag e : dgb.liste())
                System.out.println(e);
            System.out.println("=============== Eintraege von Susi ===============");
            for (Eintrag e : dgb.liste("Susi"))
                System.out.println(e);


            dgb.close();

            

        } catch (Exception ex)
        {
            Logger.getLogger(DBGaesteBuch.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
