package usermanager;


/**
 *
 * @author Rudolf Radlbauer
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            DBUserManager umgr = new DBUserManager("org.hsqldb.jdbcDriver", "jdbc:hsqldb:hsql://localhost/test", "SA", "");

            LoginDialog login = new LoginDialog(null, umgr);
            User user = login.anzeigen();
            System.out.println(user);

            umgr.close();
            System.exit(0);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
