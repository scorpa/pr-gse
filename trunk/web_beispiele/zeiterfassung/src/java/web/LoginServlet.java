
package web;

import fachlogik.Mitarbeiter;
import fachlogik.Zeiterfassung;
import fachlogik.ZeiterfassungException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * nimmt die Anmeldung entgegen
 * @author Rudolf Radlbauer
 */
public class LoginServlet extends HttpServlet
{
   


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        try
        {
            // Mitarbeiternummer und Passwort auslesen
            int id = Integer.parseInt(request.getParameter("nr"));
            String pwd = request.getParameter("pwd");
            // daraus wird eine Mitarbeiter-Instanz erstellt
            Mitarbeiter m = new Mitarbeiter();
            m.setNr(id);
            m.setPwd(pwd);
            // Zeiterfassung-Instanz aus dem ServletContext holen
            Zeiterfassung z = (Zeiterfassung) request.getSession().getServletContext().
                    getAttribute("zeiterfassung");
            if (z != null)
            {
                if (z.login(m))  // login durchführen
                {
                    // Mitarbeiter-Instanz an Session anhängen
                    request.getSession().setAttribute("mitarbeiter", m);
                    // Weiterleitung an die Hauptseite
                    request.getRequestDispatcher("liste.jsp").forward(request, response);
                }
                else
                {
                    // Fehlermeldung setzen
                    request.setAttribute("error", "ungültige Daten");
                    // Weiterleiten an die Login-Seite
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
            else
                throw new Exception("Datenbankfehler");
        } catch(NumberFormatException e)
        {
            request.setAttribute("error", "Mitarbeiternummer muss eine Zahl sein");
        } catch(Exception e)
        {
            request.setAttribute("error", e.getMessage());
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Behandelt Login";
    }

}
