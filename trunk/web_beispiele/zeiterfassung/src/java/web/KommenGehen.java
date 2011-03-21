
package web;

import fachlogik.ZeitStempel;
import fachlogik.ZeiterfassungException;
import java.io.IOException;

/**
 * Dient zum Steuern der Aktivierung eines Buttons
 * Je nach typ und letztem Zeitstempel wird der String
 * disabled="disabled" ausgegeben oder nicht
 * @author Rudolf Radlbauer
 */
public class KommenGehen extends BasisTag
{
    private String typ;


    public String getTyp()
    {
        return typ;
    }

    public void setTyp(String typ)
    {
        this.typ = typ;
    }

    @Override
    protected int startTag() throws ZeiterfassungException, IOException
    {
        ZeitStempel s = getZeiterfassung().letzterEintrag(getMitarbeiter());
        // wenn es noch keinen Zeitstempel gibt oder der letzte Zeitstempel
        // nicht "Kommen" ist, dann soll der Kommen-Button aktiv sein
        if (s == null || !s.isKommen())
        {
            if ("gehen".equals(typ))
                pageContext.getOut().print("disabled=\"disabled\"");
        }
        else  // sonst der Gehen-Button
        {
            if ("kommen".equals(typ))
                pageContext.getOut().print("disabled=\"disabled\"");
        }
        return SKIP_BODY;
    }



}
