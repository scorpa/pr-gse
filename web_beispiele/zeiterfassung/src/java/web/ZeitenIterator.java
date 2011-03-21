package web;

import fachlogik.ZeitStempel;
import fachlogik.ZeiterfassungException;
import java.io.IOException;
import java.util.Iterator;
import javax.servlet.jsp.JspException;

/**
 * implementiert eine Schleife über die Zeitstempel der aktuellen Woche
 * und hängt jeweils den nächsten Zeitstempel an den pageContext
 * @author Rudolf Radlbauer
 */
public class ZeitenIterator extends BasisTag
{
    @Override
    public int startTag() throws ZeiterfassungException, IOException
    {
        // Iterator für die Liste der Zeitstempel der aktuellen Woche
        Iterator<ZeitStempel> iterator = getZeiterfassung().aktuelleZeiten(getMitarbeiter()).iterator();
        // Iterator an pageContext anhängen
        pageContext.setAttribute("iterator", iterator);
        if (iterator.hasNext())
        {
            // falls mindestens ein Zeitstempel existiert, wird der erste
            // an den pageContext gehängt und der Tag-Body ausgewertet
            pageContext.setAttribute("zeitstempel", iterator.next());
            return EVAL_BODY_INCLUDE;
        }
        else  // ansonsten wird der Tag-Body übersprungen
            return SKIP_BODY;
    }

    @Override
    public int doAfterBody() throws JspException
    {
        // iterator vom pageContext holen
        Iterator<ZeitStempel> iterator = (Iterator<ZeitStempel>) pageContext.getAttribute("iterator");
        if (iterator.hasNext())
        {
            // falls ein weiterer Zeitstempel existiert, wird er an den
            // pageContext gehängt und der Tag-Body nochmals ausgewertet
            pageContext.setAttribute("zeitstempel", iterator.next());
            return EVAL_BODY_AGAIN;
        }
        else  // andernfalls sind wir fertig
            return SKIP_BODY;
    }



}
