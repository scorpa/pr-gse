package einkaufsliste.fachlogik;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rudi
 */
public class ProduktVerwaltungImpl implements ProduktVerwaltung
{
    private List<Produkt> produkte;

    public ProduktVerwaltungImpl()
    {
        produkte = new ArrayList<Produkt>();
    }

    public void anlegen(Produkt p) throws EinkaufsListeException
    {
        for (Produkt p1 : produkte)
        {
            if (p1.getBezeichnung().equals(p.getBezeichnung()))
                throw new EinkaufsListeException("Produkt bereits vorhanden");
        }
        produkte.add(p);
    }

    public void entfernen(Produkt p) throws EinkaufsListeException
    {
        if (!produkte.remove(p))
            throw new EinkaufsListeException("dieses Produkt existiert nicht");
    }



    public List<Produkt> liste()
    {
        return produkte;
    }

    public void entfernen(String bezeichnung) throws EinkaufsListeException
    {
        for (Produkt p : produkte)
        {
            if (p.getBezeichnung().equals(bezeichnung))
                entfernen(p);
            break;
        }
    }

}
