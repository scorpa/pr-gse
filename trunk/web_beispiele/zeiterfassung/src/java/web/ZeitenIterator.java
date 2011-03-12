package web;

import fachlogik.ZeitStempel;
import fachlogik.ZeiterfassungException;
import java.io.IOException;
import java.util.Iterator;
import javax.servlet.jsp.JspException;

/**
 *
 * @author Rudolf Radlbauer
 */
public class ZeitenIterator extends BasisTag
{
    @Override
    public int startTag() throws ZeiterfassungException, IOException
    {
        Iterator<ZeitStempel> iterator = getZeiterfassung().aktuelleZeiten(getMitarbeiter()).iterator();
        pageContext.setAttribute("iterator", iterator);
        if (iterator.hasNext())
        {
            pageContext.setAttribute("zeitstempel", iterator.next());
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
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
