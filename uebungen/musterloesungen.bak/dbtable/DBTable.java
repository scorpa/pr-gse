
package dbtable;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rudolf Radlbauer
 */
public class DBTable extends JTable
{
    // jede JTable arbeitet mit einem TableModel,
    // hier verwenden wir ein DefaultTableModel
    private DefaultTableModel model;

    public DBTable(Connection con, String tabelle)
    {

        try
        {
            model = new DefaultTableModel();
            super.setModel(model); // setze model as Tablemodel
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM " + tabelle);
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            // Achtung: Spalten werden von 1 weg nummeriert !!!
            for (int i = 1; i <= columnCount; i++)
                model.addColumn(rsmd.getColumnName(i));
            while (rs.next())
            {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++)
                    row[i-1] = rs.getObject(i);
                model.addRow(row);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Fehler bei Datenbankzugriff: "
                    + ex.getMessage());
        }
    }

    public static void main(String[] args)
    {
        Connection con = null;
        try
        {
            if (args.length < 3 || args.length > 5)
            {
                System.err.println("usage: DBTable <Tabellenname> <Treiberklasse>" +
                        " <Datenbank-URL> [<Benutzer>] [<Passwort>]");
                System.exit(-1);
            }
            Class.forName(args[1]); // Treiber laden
            String url = args[2];
            String user = (args.length >= 4) ? args[3] : "";
            String pwd = (args.length == 5) ? args[4] : "";
            con = DriverManager.getConnection(url, user, pwd);

            JFrame frame = new JFrame("Tabelle " + args[0]);
            frame.setLayout(new BorderLayout());
            DBTable dbtable = new DBTable(con, args[0]);
            frame.add(new JScrollPane(dbtable), BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fehler beim ÖPffnen der Datenbank: " + ex.getMessage());
            System.exit(-1);
        } catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Treiberklasse nicht gefunden: " + ex.getMessage());
            System.exit(-1);
        }
        finally
        {
            if (con != null)
            {
                try
                {
                    con.close();
                } catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }

    }
}
