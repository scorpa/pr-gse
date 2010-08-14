package bank.persistenz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton f¸r die Verwaltung einer Datenbankverbindung. Die
 * Verbindungsinformationen werden aus den Properties gelesen: <br/>
 * bank.db.driver <br/> bank.db.url <br/> bank.db.user <br/> bank.db.pwd <br/>
 * 
 * @author Rudolf Radlbauer
 */
public class ConnectionController
{
    private static ConnectionController instance = new ConnectionController();
    private Connection connection = null;
    private String driver;
    private String db;
    private String user;
    private String pwd;

    /**
     * privater Konstruktor liest die Verbindungsinformationen aus den
     * Properties
     * 
     */
    private ConnectionController()
    {
        driver = System.getProperty("bank.db.driver", "org.hsqldb.jdbcDriver");
        db = System.getProperty("bank.db.url",
                "jdbc:hsqldb:hsql://localhost/bank");
        user = System.getProperty("bank.db.user", "sa");
        pwd = System.getProperty("bank.db.pwd", "");

    }

    /**
     * liefert Referenz auf die einzige Instanz des ConnectionControllers
     * 
     * @return
     * @uml.property name="instance"
     */
    public static ConnectionController getInstance()
    {
        return instance;
    }

    /**
     * liefert Referenz auf die verwaltete Datenbankverbindung. Bei Bedarf wird
     * die Verbindung angelegt.
     * 
     * @return Datenbankverbindung
     * @throws PersistenzException
     *             falls beim Aufbau der Verbindung ein Fehler auftritt
     * @uml.property name="connection"
     */
    public Connection getConnection() throws PersistenzException
    {
        try
        {
            if (connection == null || connection.isClosed())
            {
                try
                {
                    Class.forName(driver);
                } catch (ClassNotFoundException e)
                {
                    throw new PersistenzException(
                            "Datenbanktreiber nicht gefunden: " + driver);
                }
                try
                {
                    connection = DriverManager.getConnection(db, user, pwd);
                } catch (SQLException e)
                {
                	e.printStackTrace();
                    throw new PersistenzException(
                            "keine Verbindung zu Datenbank: " + db);
                }
            }
        } catch (SQLException e)
        {
            throw new PersistenzException("unbekannter Datenbankfehler: "
                    + e.getMessage());
        }
        return connection;
    }

    /**
     * schlieﬂt die Datenbankverbindung
     * 
     * @throws PersistenzException
     *             falls beim Schlieﬂen ein Fehler auftritt
     */
    public void closeConnection() throws PersistenzException
    {
        try
        {
            if (connection != null && !connection.isClosed())
            {
                connection.close();
            }
        } catch (SQLException e)
        {
            throw new PersistenzException(
                    "Fehler beim Schlieﬂen der DB-Verbindung: "
                            + e.getMessage());
        }
    }

}
