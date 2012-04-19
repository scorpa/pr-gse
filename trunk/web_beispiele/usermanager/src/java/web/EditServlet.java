package web;

import bl.User;
import bl.UserManager;
import bl.UserManagerException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rudolf Radlbauer
 */
@WebServlet(name = "EditServlet", urlPatterns =
{
    "/edit_user"
})
public class EditServlet extends HttpServlet
{
    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null)
        {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        if (!user.isAdmin())
            throw new ServletException("no privileges for editing users");
        
        UserManager manager = (UserManager) request.getServletContext().getAttribute("manager");
        if (manager == null)
            throw new ServletException("configuration error: no user manager loaded");
        String id = request.getParameter("id");
        if (id == null)
        {
            request.setAttribute("error", "please select a user");
            request.getRequestDispatcher("main.jsp").forward(request, response);
            return;
        }
        try
        {
            User edit = manager.find(Integer.parseInt(id));
            request.setAttribute("edit", edit);
            request.getRequestDispatcher("user_editor.jsp").forward(request, response);
        } catch (UserManagerException ex)
        {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex);
        }
    }

}
