package web;

import fachlogik.Mitarbeiter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Überprüft, ob der Mitarbeiter angemeldet ist (Mitarbeiter-Instanz
 * als Attribut an Session angehängt).
 * Andernfalls wird auf die Login-Seite umgelenkt.
 * @author Rudolf Radlbauer
 */
public class LoginFilter implements Filter
{

    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        Mitarbeiter m = (Mitarbeiter) req.getSession().getAttribute("mitarbeiter");
        // falls noch kein Mitarbeiter an die Session angehängt ist,#
        // wird auf die Login-Seite umgelenkt, außer wenn wir uns gerade
        // im Login-Vorgang befinden (Aufruf des Login-Servlets)
        if (m == null && !"/login".equals(req.getServletPath()))
            req.getRequestDispatcher("login.jsp").forward(request, response);
        else
            chain.doFilter(request, response);
    }

    public void destroy()
    {

    }
}
