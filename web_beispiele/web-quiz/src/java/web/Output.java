package web;

import fachlogik.Frage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Output extends TagSupport
{
    private String feld;
    private int index;

    public void setIndex(int index)
    {
        this.index = index;
    }



    public void setFeld(String feld)
    {
        this.feld = feld;
    }

    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            Frage frage = (Frage) pageContext.getSession().getAttribute("frage");
            if (frage == null)
            {
                if ("frage".equals(feld))
                    pageContext.getOut().print("Auf Wiedersehen");
            }
            else
            {
                if ("frage".equals(feld))
                    pageContext.getOut().print(frage.getFrage());
                else if ("antwort".equals(feld))
                    pageContext.getOut().print(frage.getAntwort(index));
                else if ("richtig".equals(feld))
                    pageContext.getOut().print(frage.getAntwort(frage.getRichtig()));
            }

            return SKIP_BODY;
        } catch (IOException ex)
        {
            ex.printStackTrace();
            throw new JspException(ex);
        }
    }

    @Override
    public int doEndTag() throws JspException
    {
        if (pageContext.getSession().getAttribute("frage") == null)
            return SKIP_PAGE;
        else
            return super.doEndTag();
    }



}
