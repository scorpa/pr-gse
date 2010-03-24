
package web;

import flugreservierung.DBDataAccess;
import flugreservierung.DataAccess;
import flugreservierung.FlugReservierungsException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Startup implements ServletContextListener
{

    public void contextInitialized(ServletContextEvent sce)
    {
        try
        {
            sce.getServletContext().setAttribute("data.access", new DBDataAccess());
        } catch (FlugReservierungsException ex)
        {
            Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void contextDestroyed(ServletContextEvent sce)
    {
        try
        {
            DataAccess da = (DataAccess) sce.getServletContext().getAttribute("data.access");
            if (da != null)
            {
                da.close();
            }
        } catch (FlugReservierungsException ex)
        {
            Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
