package web;

import fachlogik.ZeitStempel;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * gibt ein Feld der Zeitausgabe-Instanz aus, welche gerade am
 * pageContext hängt.
 * @author Rudolf Radlbauer
 */
public class ZeitAusgabe extends TagSupport
{
    private String format;
    private String feld;

    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            ZeitStempel z = (ZeitStempel) pageContext.getAttribute("zeitstempel");
            if (z != null)
            {
                if ("kommen".equals(feld))
                    pageContext.getOut().print(z.isKommen() ? "kommen" : "gehen");
                if ("zeit".equals(feld))
                {
                    SimpleDateFormat fmt = null;
                    if (format == null)
                        fmt = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                    else
                        fmt = new SimpleDateFormat(format);
                    pageContext.getOut().print(fmt.format(z.getTimestamp()));

                }
            }
            return SKIP_BODY;
        } catch(IOException e)
        {
            throw new JspException(e);
        }
    }

    public String getFeld()
    {
        return feld;
    }

    public void setFeld(String feld)
    {
        this.feld = feld;
    }

    public String getFormat()
    {
        return format;
    }

    public void setFormat(String format)
    {
        this.format = format;
    }

    

}
