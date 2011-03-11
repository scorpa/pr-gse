
package web;

import fachlogik.Mitarbeiter;
import fachlogik.ZeitStempel;
import fachlogik.Zeiterfassung;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Rudolf Radlbauer
 */
public class KommenGehen extends TagSupport
{
    private String typ;

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
                    ZeitStempel s = z.letzterEintrag(m);
                    if (s == null || !s.isKommen())
                    {
                        if ("gehen".equals(typ))
                            pageContext.getOut().print("disabled=\"disabled\"");
                    }
                    else
                    {
                        if ("kommen".equals(typ))
                            pageContext.getOut().print("disabled=\"disabled\"");
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

    public String getTyp()
    {
        return typ;
    }

    public void setTyp(String typ)
    {
        this.typ = typ;
    }



}
