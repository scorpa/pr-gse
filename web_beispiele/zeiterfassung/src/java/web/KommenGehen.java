
package web;

import fachlogik.ZeitStempel;
import fachlogik.ZeiterfassungException;
import java.io.IOException;

/**
 *
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
        if (s == null || !s.isKommen())
        {
            if ("gehen".equals(typ))
                pageContext.getOut().print("disabled=\"disabled\"");
        }
        else
        {
            if ("kommen".equals(typ))
                pageContext.getOut().print("disabled=\"disabled\"");
        }
        return SKIP_BODY;
    }



}
