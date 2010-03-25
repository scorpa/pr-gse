package web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Rudolf Radlbauer
 */
public class AttributTag extends TagSupport
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }



    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            pageContext.getOut().print(pageContext.getRequest().getAttribute(name));
            return SKIP_BODY;
        } catch (IOException ex)
        {
            throw new JspException(ex);
        }
    }

}
