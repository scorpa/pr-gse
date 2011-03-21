package web;

import fachlogik.Mitarbeiter;
import fachlogik.Zeiterfassung;
import fachlogik.ZeiterfassungException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Basisklasse für verschiedene andere Taghandler.
 * Implementiert einige Teile, die bei allen diesen Taghandlern gleich sind:
 * Zeiterfassung- und Mitarbeiter-Instanz abrufen
 * Fehlerbehandlung
 * @author Rudolf Radlbauer
 */
public abstract class BasisTag extends TagSupport
{
    private Zeiterfassung zeiterfassung;
    private Mitarbeiter mitarbeiter;

    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            zeiterfassung = (Zeiterfassung) pageContext.getServletContext().getAttribute("zeiterfassung");
            if (zeiterfassung == null)
                throw new ZeiterfassungException("Applikation nicht richtig initialisiert");
            mitarbeiter = (Mitarbeiter) pageContext.getSession().getAttribute("mitarbeiter");
            if (mitarbeiter == null)
                throw new ZeiterfassungException("kein Mitarbeiter angemeldet");
            return startTag();
        } catch (Exception ex)
        {
            Logger.getLogger(BasisTag.class.getName()).log(Level.SEVERE, null, ex);
            throw new JspException(ex);
        }

    }

    protected abstract int startTag() throws ZeiterfassungException, IOException;

    public Mitarbeiter getMitarbeiter()
    {
        return mitarbeiter;
    }

    public Zeiterfassung getZeiterfassung()
    {
        return zeiterfassung;
    }

    

}
