package web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Ausgabe ob die letzte Antwort richtig war oder nicht
 *
 * @author Rudolf Radlbauer
 */
public class Status extends TagSupport
{

    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            // status wird in AntwortServlet gesetzt
            String status = (String) pageContext.getRequest().getAttribute("status");
            if (status != null)
            {
                pageContext.getOut().print(status);
            }
            return SKIP_BODY;
        } catch (IOException ex)
        {
            Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
            throw new JspException(ex);
        }
    }

}
