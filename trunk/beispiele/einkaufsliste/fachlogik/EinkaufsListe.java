
package einkaufsliste.fachlogik;

import java.util.List;

/**
 * Definiert die Funktionalität der Einkaufsliste
 * @author Rudolf Radlbauer
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

    /**
     * entfernt ein Produkt aus der Einkaufsliste
     * @param p Referenz auf das zu entfernende Produkt
     */
    public void entfernen(Produkt p);

    /**
     * gibt eine Referenz auf die Liste aller Produkte
     * in der Einkaufsliste zurück
     * @return Referenz auf Produktliste
     */
    public List<Produkt> liste();

    /**
     * gibt an, in welcher Anzahl dieses Produkt in der
     * Einkaufsliste ist
     * @param p Referenz auf das Produkt
     * @return Anzahl
     */
    public int getAnzahl(Produkt p);

    /**
     * sortiert die Liste
     * @param k Kriterium, nach welchem sortiert wird
     */
    public void sortieren(KRITERIUM k);

    /**
     * berechnet den Gesamtpreis aller Artikel in
     * der Einkaufsliste
     * @return Gesamtpreis
     */
    public float gesamtPreis();

    /**
     * berechnet die CO2-Belastung
     * @return CO2-Belastung in Gramm
     */
    public float co2();

    /**
     * berechnet die Anzahl der Bioprodukte
     * in der Einkaufsliste
     * @return Anzahl der Bioprodukte
     */
    public int anzahlBio();

    /**
     * berechnet die Gesamtzahl der Produkte
     * in der Einkausliste
     * @return Gesamtzahl der Produkte
     */
    public int anzahlProdukte();
}
