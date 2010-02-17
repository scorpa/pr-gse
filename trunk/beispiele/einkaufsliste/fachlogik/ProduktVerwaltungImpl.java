package einkaufsliste.fachlogik;

import java.util.ArrayList;

/**
 *
 * @author Rudi
 */
public class ProduktVerwaltungImpl implements ProduktVerwaltung
{
    ArrayList<Produkt> produkte;

    public ProduktVerwaltungImpl()
    {
        produkte = new ArrayList<Produkt>();
    }

    public void anlegen(Produkt p)
    {
        for (Produkt p1 : produkte)
        {
            if (p1.getBezeichnung().equals(p.getBezeichnung()))
                return;
        }
        produkte.add(p);
    }

    public void entfernen(String bezeichnung)
    {
        for (Produkt p : produkte)
        {
            if (p.getBezeichnung().equals(bezeichnung))
                produkte.remove(p);
        }
    }

    public ArrayList<Produkt> liste()
    {
        return produkte;
    }

}
