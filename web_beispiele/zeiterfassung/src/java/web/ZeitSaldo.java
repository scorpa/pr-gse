package web;

import fachlogik.Mitarbeiter;
import fachlogik.Zeiterfassung;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Rudolf Radlbauer
 */
public class ZeitSaldo extends TagSupport
{
    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            Zeiterfassung z = (Zeiterfassung) pageContext.getServletContext().getAttribute("zeiterfassung");
            if (z != null)
            {
                Mitarbeiter m = (Mitarbeiter) pageContext.getSession().getAttribute("mitarbeiter");
                if (m != null)
                {
                    float saldo = z.zeitSaldo(m);
                    int std = (int)saldo;
                    int min = (int)((saldo - std) * 60);


                    pageContext.getOut().print(std + " Stunden / " + min + " Minuten");
                }
                else
                    throw new Exception("kein Mitarbeiter angemeldet");
            }
            else
                throw new Exception("Datenbankfehler");
            return SKIP_BODY;
        } catch(Exception e)
        {
            throw new JspException(e);
        }
    }
}
