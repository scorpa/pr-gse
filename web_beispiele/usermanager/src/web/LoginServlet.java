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
@WebServlet(name = "LoginServlet", urlPatterns =
{
    "/login"
})
public class LoginServlet extends HttpServlet
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
        try
        {
            String userName = request.getParameter("user");
            String pwd = request.getParameter("pwd");
            UserManager manager = (UserManager) request.getServletContext().getAttribute(UserManagerLoader.USER_MANAGER_NAME);
            if (manager == null)
                throw new ServletException("configuration error: no user manager loaded");
            User user = manager.login(userName, pwd);
            if (user == null)
            {
                request.setAttribute("error", "wrong user name or password - please try again");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            else
            {
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("main.jsp").forward(request, response);
            }
        } catch (UserManagerException ex)
        {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex);
        }
    }

 
}
