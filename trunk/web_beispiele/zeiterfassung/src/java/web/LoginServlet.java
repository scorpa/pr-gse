
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
 *
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
            int id = Integer.parseInt(request.getParameter("nr"));
            String pwd = request.getParameter("pwd");
            Mitarbeiter m = new Mitarbeiter();
            m.setNr(id);
            m.setPwd(pwd);
            Zeiterfassung z = (Zeiterfassung) request.getSession().getServletContext().
                    getAttribute("zeiterfassung");
            if (z != null)
            {
                if (z.login(m))
                {
                    request.getSession().setAttribute("mitarbeiter", m);
                    request.getRequestDispatcher("liste.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("error", "ungültige Daten");
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
