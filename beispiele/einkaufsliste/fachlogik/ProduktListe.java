
package einkaufsliste.fachlogik;

import java.util.ArrayList;

/**
 *
 * @author Rudi
 */
public interface ProduktListe
{
    public void aufnehmen(Produkt p);
    public void entfernen(Produkt p);
    public Produkt suchen(String bezeichnung);
    public ArrayList<Produkt> suchen(boolean bio);
    public ArrayList<Produkt> suchen(LAND herkunft);
}
