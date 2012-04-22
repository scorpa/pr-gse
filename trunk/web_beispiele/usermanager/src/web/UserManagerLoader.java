package web;

import bl.UserManager;
import bl.UserManagerException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author Rudolf Radlbauer
 */
@WebListener()
public class UserManagerLoader implements ServletContextListener
{
	public final static String USER_MANAGER_NAME = "manager";
	
    private UserManager manager;

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        try
        {
            String managerClass = sce.getServletContext().getInitParameter("usermanager.class");
            manager = (UserManager) Class.forName(managerClass).newInstance();
            sce.getServletContext().setAttribute(USER_MANAGER_NAME, manager);
        } catch (Exception ex)
        {
            Logger.getLogger(UserManagerLoader.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
        try
        {
            if (manager != null)
                manager.close();
        } catch (UserManagerException ex)
        {
            Logger.getLogger(UserManagerLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
