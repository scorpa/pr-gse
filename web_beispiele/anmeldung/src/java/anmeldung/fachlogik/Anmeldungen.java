
package anmeldung.fachlogik;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Anmeldungen
{
    private static Anmeldungen instance = new Anmeldungen();
    private List<Eintrag> eintraege = new ArrayList<Eintrag>();

    public static Anmeldungen getInstance()
    {
        return instance;
    }


    public void eintragen(String email, boolean zusage) throws AnmeldeException
    {
        if (finden(email) != null)
            throw new AnmeldeException("Email-Adresse bereits eingetragen");
        eintraege.add(new Eintrag(email, zusage));
    }


    private Eintrag finden(String email)
    {
        for (Eintrag e : eintraege)
            if (e.getEmail().equals(email))
                return e;
        return null;
    }

    public List<Eintrag> eintraege()
    {
        return eintraege;
    }


}
