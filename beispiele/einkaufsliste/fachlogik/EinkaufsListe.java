
package einkaufsliste.fachlogik;

import java.util.ArrayList;

/**
 *
 * @author Rudi
 */
public interface EinkaufsListe
{
    public enum KRITERIUM   // Sortierkriterien
    {
        BEZEICHNUNG, PREIS, HERKUNFT, BIO
    }

    /**
     * nimmt ein Produkt in die Einkaufsliste auf
     * @param p Referenz auf das Produkt
     * @param anzahl in dieser Anzahl wird das Produkt übernommen
     */
    public void aufnehmen(Produkt p, int anzahl);
    public void entfernen(Produkt p);
    public ArrayList<Produkt> liste();
    public int getAnzahl(Produkt p);
    public void sortieren(KRITERIUM k);
    public float gesamtPreis();
    public float co2();
    public int anzahlBio();
    public int anzahlProdukte();
}
