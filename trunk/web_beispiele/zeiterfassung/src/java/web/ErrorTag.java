
package web;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Rudolf Radlbauer
 */
public class ErrorTag extends TagSupport
{

    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            String error = (String) pageContext.getRequest().getAttribute("error");
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
