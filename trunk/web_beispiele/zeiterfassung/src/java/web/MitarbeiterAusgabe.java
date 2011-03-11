package web;

import fachlogik.Mitarbeiter;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Rudolf Radlbauer
 */
public class MitarbeiterAusgabe extends TagSupport
{
    private String feld;

    @Override
    public int doStartTag() throws JspException
    {
        Mitarbeiter m = (Mitarbeiter) pageContext.getSession().getAttribute("mitarbeiter");
        if (m != null)
        {
            try
            {
                if ("nr".equals(feld))
                    pageContext.getOut().print(m.getNr());
                else if ("name".equals(feld))
                    pageContext.getOut().print(m.getName());
                else if ("stunden".equals(feld))
                    pageContext.getOut().print(m.getStunden());

            } catch(IOException ex)
            {
                throw new JspException(ex);
            }
        }
        return SKIP_BODY;
    }

    public String getFeld()
    {
        return feld;
    }

    public void setFeld(String feld)
    {
        this.feld = feld;
    }



}
