package web;

import fachlogik.Mitarbeiter;
import fachlogik.ZeitStempel;
import fachlogik.Zeiterfassung;
import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Rudolf Radlbauer
 */
public class ZeitenIterator extends TagSupport
{
    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            Zeiterfassung z = (Zeiterfassung) pageContext.getServletContext().getAttribute("zeiterfassung");
            Mitarbeiter m = (Mitarbeiter) pageContext.getSession().getAttribute("mitarbeiter");
            if (z != null)
            {
                if (m != null)
                {
                    Iterator<ZeitStempel> iterator = z.aktuelleZeiten(m).iterator();
                    pageContext.setAttribute("iterator", iterator);
                    if (iterator.hasNext())
                    {
                        pageContext.setAttribute("zeitstempel", iterator.next());
                        return EVAL_BODY_INCLUDE;
                    }
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

    @Override
    public int doAfterBody() throws JspException
    {
        Iterator<ZeitStempel> iterator = (Iterator<ZeitStempel>) pageContext.getAttribute("iterator");
        if (iterator.hasNext())
        {
            pageContext.setAttribute("zeitstempel", iterator.next());
            return EVAL_BODY_AGAIN;
        }
        else
            return SKIP_BODY;
    }



}
