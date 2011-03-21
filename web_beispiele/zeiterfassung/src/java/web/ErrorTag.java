
package web;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Liest ein Attribut mit dem Namen "error" aus dem Request
 * und gibt diesen (falls vorhanden) aus.
 * @author Rudolf Radlbauer
 */
public class ErrorTag extends TagSupport
{

    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            Object error = pageContext.getRequest().getAttribute("error");
            if (error != null)
            {
                pageContext.getOut().print(error);
            }
            return SKIP_BODY;
        } catch (IOException ex)
        {
            throw new JspException(ex);
        }
    }

}
