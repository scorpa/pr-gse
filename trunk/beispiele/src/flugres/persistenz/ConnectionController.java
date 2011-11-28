package flugres.persistenz;

import flugres.fachlogik.ReservierungsException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rudi
 */
public class ConnectionController
{
    private static Connection connection;
    
    public static Connection getConnection() throws ReservierungsException
    {       
        try
        {
            if (connection == null || connection.isClosed())
            {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "pr", "pr");
            }
            
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            throw new ReservierungsException("Treiber nicht gefunden");
        } catch (SQLException ex)
        {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            throw new ReservierungsException("konnte keine DB-Verbindung herstellen");
        }
        return connection;
    }
    
    public static void close()
    {
        if (connection != null)
            try
        {
            connection.close();
        } catch (SQLException ex)
        {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
