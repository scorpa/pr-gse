package web;

import flugreservierung.Flug;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Rudolf Radlbauer
 */
public class FlugAusgabeTag extends TagSupport
{
    private final static SimpleDateFormat FORMATTER = new SimpleDateFormat("dd.MM.yyyy / HH:mm");
    private String feld;

    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            Flug flug = (Flug) pageContext.getAttribute("flug");
            if ("nummer".equals(feld))
                pageContext.getOut().print(flug.getNummer());
            else if ("von".equals(feld))
                pageContext.getOut().print(flug.getVon());
            else if ("nach".equals(feld))
                pageContext.getOut().print(flug.getNach());
            else if ("abflug".equals(feld))
                pageContext.getOut().print(FORMATTER.format(flug.getStart()));
            else if ("ankunft".equals(feld))
                pageContext.getOut().print(FORMATTER.format(flug.getAnkunft()));
            else if ("sitzplaetze".equals(feld))
                pageContext.getOut().print(flug.getSitzPlaetze());
            return SKIP_BODY;
        } catch (IOException ex)
        {
            throw new JspException(ex);
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


}
