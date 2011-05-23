/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import fachlogik.GaesteBuch;
import fachlogik.GaesteBuchException;
import java.util.Date;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rudi
 */
public class ListenAuswahl
{
    public enum TYP{ALLE, EIGENE, ZEIT}

    public static void auswahl(HttpSession session) throws GaesteBuchException
    {
        GaesteBuch buch = (GaesteBuch) session.getServletContext().getAttribute("gaestebuch");
        if (buch == null)
            throw new GaesteBuchException("keine GaesteBuch-Instanz");

        boolean alle = (Boolean)session.getAttribute("alle");

        String name = (String) session.getAttribute("name");

        if (alle)
            session.setAttribute("eintraege", buch.liste());
        else
            session.setAttribute("eintraege", buch.liste(name));
    }

}
