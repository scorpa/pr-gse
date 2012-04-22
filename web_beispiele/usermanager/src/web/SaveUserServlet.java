package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bl.User;
import bl.UserManager;
import bl.UserManagerException;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/save_user")
public class SaveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		User loggedIn = (User) request.getSession().getAttribute("user");
		if (loggedIn == null || !loggedIn.isAdmin())
			throw new ServletException("You must have admin rights to add a new user");
		
		String name = request.getParameter("name");
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String pwd2 = request.getParameter("pwd2");
		String id = request.getParameter("id");
		String admin = request.getParameter("admin");
		if (!pwd.equals(pwd2))
			throw new ServletException("passwords are not equal");
		User u = new User();
		u.setName(name);
		u.setUname(uname);
		u.setPwd(pwd);
		if (id != null)
			u.setId(Integer.parseInt(id));
		if ("true".equals(admin))
			u.setAdmin(true);
		
		UserManager manager = (UserManager) request.getServletContext().getAttribute(UserManagerLoader.USER_MANAGER_NAME);
		if (manager == null)
			throw new ServletException("configuration error: no user manager loaded");
		
		try
		{
			manager.save(u);
		} catch (UserManagerException e)
		{
			throw new ServletException(e);
		}

		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}

}
