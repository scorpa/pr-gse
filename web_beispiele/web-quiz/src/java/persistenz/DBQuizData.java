package persistenz;

import fachlogik.Frage;
import fachlogik.QuizData;
import fachlogik.QuizException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rudolf Radlbauer
 */
public class DBQuizData implements QuizData
{
    private Connection con;
    private Random rnd = new Random();

    public DBQuizData() throws QuizException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/quiz", "pr", "pr");
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new QuizException("keine Verbindung zur Datenbank");
        } catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
            throw new QuizException("Treiber nicht gefunden");
        }
    }

    public Frage random() throws QuizException
    {
        try
        {
            List<Frage> fragen = new ArrayList<Frage>();
            String sql = "SELECT id, frage, antwort0, antwort1, antwort2, antwort3, richtig FROM fragen";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                Frage f = new Frage(rs.getInt("id"));
                f.setFrage(rs.getString("frage"));
                f.setAntwort(0, rs.getString("antwort0"));
                f.setAntwort(1, rs.getString("antwort1"));
                f.setAntwort(2, rs.getString("antwort2"));
                f.setAntwort(3, rs.getString("antwort3"));
                f.setRichtig(rs.getInt("richtig"));
                fragen.add(f);
            }
            rs.close();
            pstmt.close();
            return fragen.get(rnd.nextInt(fragen.size()));
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new QuizException("Fehler bei DB-Zugriff");
        }
    }

    public void close() throws QuizException
    {
        if (con != null)
            try
        {
            con.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new QuizException("kann DB-Verbindung nicht schließen");
        }
    }

    public List<Frage> fragen() throws QuizException
    {
        try
        {
            List<Frage> fragen = new ArrayList<Frage>();
            String sql = "SELECT id, frage, antwort0, antwort1, antwort2, antwort3, richtig FROM fragen";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                Frage f = new Frage(rs.getInt("id"));
                f.setFrage(rs.getString("frage"));
                f.setAntwort(0, rs.getString("antwort0"));
                f.setAntwort(1, rs.getString("antwort1"));
                f.setAntwort(2, rs.getString("antwort2"));
                f.setAntwort(3, rs.getString("antwort3"));
                f.setRichtig(rs.getInt("richtig"));
                fragen.add(f);
            }
            rs.close();
            pstmt.close();
            return fragen;
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new QuizException("Fehler bei DB-Zugriff");
        }
    }

}
