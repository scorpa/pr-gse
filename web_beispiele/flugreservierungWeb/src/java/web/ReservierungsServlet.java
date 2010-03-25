package web;

import flugreservierung.DataAccess;
import flugreservierung.Flug;
import flugreservierung.FlugReservierungsException;
import flugreservierung.Reservierung;
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
public class ReservierungsServlet extends HttpServlet
{
   private DataAccess data;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        try
        {
            if (data == null)
            {
                data = (DataAccess) request.getSession().getServletContext().getAttribute("data.access");
            }
            String name = request.getParameter("name");
            String flNr = request.getParameter("auswahl");
            if (flNr != null && name != null & name.trim().length() > 0)
            {
                int flugnummer = Integer.parseInt(flNr);
                Flug flug = data.finde(flugnummer);
                Reservierung reservierung = new Reservierung();
                reservierung.setFlug(flug);
                reservierung.setName(name);
                data.speichern(reservierung);
                request.setAttribute("reservierungsnummer", reservierung.getNummer());
                request.setAttribute("passagiername", reservierung.getName());
                request.setAttribute("flugnummer", flugnummer);
                request.getRequestDispatcher("reserviert.jsp").forward(request, response);
            } else
            {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch(FlugReservierungsException ex)
        {
            request.setAttribute("fehler", ex);
            request.getRequestDispatcher("fehler.jsp").forward(request, response);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
