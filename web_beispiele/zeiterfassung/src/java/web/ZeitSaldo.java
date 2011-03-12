package web;

import fachlogik.Mitarbeiter;
import fachlogik.Zeiterfassung;
import fachlogik.ZeiterfassungException;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Rudolf Radlbauer
 */
public class ZeitSaldo extends BasisTag
{
    @Override
    public int startTag() throws ZeiterfassungException, IOException
    {
        float saldo = getZeiterfassung().zeitSaldo(getMitarbeiter());
        if (saldo < 0)
        {
            pageContext.getOut().print(" - ");
            saldo = -saldo;
        }
        else
            pageContext.getOut().print(" + ");
        int std = (int)saldo;
        int min = (int)((saldo - std) * 60);
        pageContext.getOut().print(std + " Stunden / " + min + " Minuten");
        return SKIP_BODY;
    }
}
