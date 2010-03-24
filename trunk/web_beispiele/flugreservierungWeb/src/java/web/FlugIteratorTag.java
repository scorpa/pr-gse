
package web;

import flugreservierung.DataAccess;
import flugreservierung.Flug;
import flugreservierung.FlugReservierungsException;
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
public class FlugIteratorTag extends TagSupport
{
    DataAccess data;

    @Override
    public int doAfterBody() throws JspException
    {
        Iterator<Flug> iterator = (Iterator<Flug>) pageContext.getAttribute("iterator");
        if (iterator.hasNext())
        {
            pageContext.setAttribute("flug", iterator.next());
            return EVAL_BODY_AGAIN;
        }
        return SKIP_BODY;
    }

    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            if (data == null)
            {
                data = (DataAccess) pageContext.getServletContext().getAttribute("data.access");
            }
            List<Flug> fluege = data.findeFluege();
            if (fluege.size() > 0)
            {
                Iterator<Flug> iterator = fluege.iterator();
                pageContext.setAttribute("iterator", iterator);
                pageContext.setAttribute("flug", iterator.next());
                return EVAL_BODY_INCLUDE;
            }
            return SKIP_BODY;
        } catch (FlugReservierungsException ex)
        {
            throw new JspException(ex);
        }
    }


}
