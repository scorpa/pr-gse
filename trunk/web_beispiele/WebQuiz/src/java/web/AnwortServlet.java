package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import quiz.Frage;
import quiz.Quiz;

/**
 * Auswerten der ausgewaehlten Antwort und weiterschalten auf die 
 * naechste Frage
 *
 * @author Rudolf Radlbauer
 */
public class AnwortServlet extends HttpServlet {
   
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
        HttpSession session = request.getSession();
        // Quiz-Instanz aus der Session holen
        // (wird in FrageAusgabe.java gesetzt)
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        if (quiz != null)
        {
            // Was hat der Benutzer ausgewaehlt?
            int antwort = Integer.parseInt(request.getParameter("antwort"));
            // aktuelle Frage aus der Session holen
            // (wird in FrageAusgabe.java zu Beginn gesetzt, fuer das naechste Mal weiter unten)
            Frage frage = (Frage) session.getAttribute("frage");
            if (frage.getRichtig() == antwort)
            {   // Benutzer hat richtig gewaehlt
                request.setAttribute("status", "Richtig - und weiter gehts");
                // auf naechste Frage schalten
                Frage neu = quiz.next();
                if (neu == null)
                {   // in diesem Fall sind wir am Ende angelangt
                    session.removeAttribute("quiz");
                    request.getRequestDispatcher("fertig.html").forward(request, response);
                    return;
                }
                // naechste Frage an die Session haengen
                session.setAttribute("frage", neu);
            }
            else
            {
                // wird im TagHandler Status.java ausgegeben
                request.setAttribute("status", "Leider falsch - probiere noch einmal!");
            }
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
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
