
package einkaufsliste.fachlogik;

import java.util.ArrayList;

/**
 *
 * @author Rudi
 */
public class EinkaufsListeImplement implements EinkaufsListe
{
    private ArrayList<Produkt> produkte;

    public EinkaufsListeImplement()
    {
        produkte = new ArrayList<Produkt>();
    }

    public void aufnehmen(Produkt p, int anzahl)
    {
        produkte.add(p);
    }

    public void entfernen(Produkt p)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Produkt> liste()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getAnzahl(Produkt p)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void sortieren(KRITERIUM k)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public float gesamtPreis()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public float co2()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int anzahlBio()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int anzahlProdukte()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
