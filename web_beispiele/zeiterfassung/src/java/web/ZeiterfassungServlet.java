package web;

import fachlogik.Mitarbeiter;
import fachlogik.ZeitStempel;
import fachlogik.Zeiterfassung;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Erfassung eines neuen Zeitstempels
 * @author Rudolf Radlbauer
 */
public class ZeiterfassungServlet extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        try
        {
            // kommen oder gehen
            boolean kommen = false;
            if (request.getParameter("kommen") != null)
                kommen = true;
            else if (request.getParameter("gehen") == null)
                throw new Exception("inkonsistenter Status");

            // angemeldeter Mitarbeiter
            Mitarbeiter m = (Mitarbeiter) request.getSession().getAttribute("mitarbeiter");
            if (m == null)
                throw new Exception("kein Mitarbeiter ist angemeldet");

            ZeitStempel s = new ZeitStempel();
            s.setKommen(kommen);
            s.setTimestamp(new Date());

            // Zeiterfassung-Instanz aus dem ServletContext holen
            Zeiterfassung z = (Zeiterfassung) request.getSession().getServletContext().
                    getAttribute("zeiterfassung");

            if (z != null)
            {
                // neuen Eintrag abspeichern
                z.eintrag(s, m);
            }
            else
                throw new Exception("Datenbankfehler");
            request.getRequestDispatcher("liste.jsp").forward(request, response);
        } catch(Exception e)
        {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "erfasst einen Zeitstempel";
    }

}
