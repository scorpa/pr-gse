/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import fachlogik.GaesteBuch;
import fachlogik.GaesteBuchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import persistenz.DBGaesteBuch;

/**
 * Web application lifecycle listener.
 * @author Rudi
 */

public class Startup implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)
    {
        try
        {
            sce.getServletContext().setAttribute("gaestebuch", new DBGaesteBuch("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/akdvk", "pr", "pr"));
        } catch (GaesteBuchException ex)
        {
            Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException("keine Verbindung zur Datenbank");
        }
    }

    public void contextDestroyed(ServletContextEvent sce)
    {
        ((GaesteBuch)sce.getServletContext().getAttribute("gaestebuch")).close();
    }
}