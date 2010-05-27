package usermanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Rudolf Radlbauer
 */
public class DBUserManager implements UserManager
{
    private Connection connection;

    public DBUserManager(String driver, String url, String user, String pwd) throws UserManagerException
    {
        try
        {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new UserManagerException("kann Datenbanktreiber nicht laden");
        } catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
            throw new UserManagerException("kann Datenbankverbindung nicht aufbauen");
        }
    }

    @Override
    public boolean login(User user) throws UserManagerException
    {
        boolean ok = false;
        try
        {
            String select = "SELECT u_nr, u_name "
                    + "FROM user "
                    + "WHERE u_username = ? "
                    + "AND u_password = ?";
            PreparedStatement pstmt = connection.prepareStatement(select);
            pstmt.setString(1, user.getUserName().toLowerCase());
            pstmt.setString(2, user.getPassword());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                user.setId(rs.getInt("u_nr"));
                user.setName(rs.getString("u_name"));
                ok = true;
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new UserManagerException("Fehler beim Datenbankzugriff");
        }
        return ok;
    }

    @Override
    public void register(User user) throws UserManagerException
    {
        try
        {
            String selectName = "SELECT u_nr FROM user WHERE u_username = ?";
            PreparedStatement pstmt = connection.prepareStatement(selectName);
            pstmt.setString(1, user.getUserName().toLowerCase());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                throw new UserManagerException("Kennung existiert bereits");
            rs.close();
            pstmt.close();

            String selectMaxNr = "SELECT MAX(u_nr) FROM user";
            pstmt = connection.prepareStatement(selectMaxNr);
            rs = pstmt.executeQuery();
            if (rs.next())
                user.setId(rs.getInt(1)+1);
            else
                throw new UserManagerException("Fehler bei Datenbankzugriff");
            rs.close();
            pstmt.close();

            String insert = "INSERT INTO user (u_nr, u_name, u_username, u_password) " +
                    "VALUES (?, ?, ?, ?)";
            pstmt = connection.prepareStatement(insert);
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getUserName().toLowerCase());
            pstmt.setString(4, user.getPassword());
            if (pstmt.executeUpdate() != 1)
                throw new UserManagerException("Fehler bei Datenbankzugriff");
            pstmt.close();

        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new UserManagerException("Fehler bei Datenbankzugriff");
        }

    }

    @Override
    public void update(User user) throws UserManagerException
    {
        try
        {
            String update = "UPDATE user SET "
                    + "u_name = ? "
                    + "u_username = ? "
                    + "u_password = ? "
                    + "WHERE u_nr = ?";
            PreparedStatement pstmt = connection.prepareStatement(update);
            if (pstmt.executeUpdate() != 1)
                throw new UserManagerException("Fehler bei Datenbankzugriff");
            pstmt.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new UserManagerException("Fehler bei Datenbankzugriff");
        }

    }

    @Override
    public void close() throws UserManagerException
    {
        if (connection != null)
            try
        {
            connection.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new UserManagerException("Fehler beim Schließen der Verbindung");
        }
    }

}
