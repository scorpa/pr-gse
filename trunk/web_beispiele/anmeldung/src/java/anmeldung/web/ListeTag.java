
package anmeldung.web;

import anmeldung.fachlogik.Anmeldungen;
import anmeldung.fachlogik.Eintrag;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Rudolf Radlbauer
 */
public class ListeTag extends TagSupport
{

    private String zusage;

    /**
     * Get the value of zusage
     *
     * @return the value of zusage
     */
    public String getZusage()
    {
        return zusage;
    }

    /**
     * Set the value of zusage
     *
     * @param zusage new value of zusage
     */
    public void setZusage(String zusage)
    {
        this.zusage = zusage;
    }


    @Override
    public int doStartTag() throws JspException
    {
        System.out.println("doStartTag");
        List<Eintrag> liste = Anmeldungen.getInstance().eintraege();
        if (liste.size() > 0)
        {
            Iterator<Eintrag> iterator = liste.iterator();
            pageContext.setAttribute("iterator", iterator);
            pageContext.setAttribute("eintrag", iterator.next());
            return EVAL_BODY_INCLUDE;
        }
        else
            return SKIP_BODY;
    }

    @Override
    public int doAfterBody() throws JspException
    {
        Iterator<Eintrag> iterator = (Iterator<Eintrag>) pageContext.getAttribute("iterator");
        if (iterator.hasNext())
        {
            pageContext.setAttribute("eintrag", iterator.next());
            return EVAL_BODY_AGAIN;
        }
        else
            return SKIP_BODY;
    }

}
