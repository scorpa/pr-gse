
package einkaufsliste.fachlogik;

import java.io.Serializable;
import java.util.List;

/**
 * Definiert die Funktionalität der Einkaufsliste
 * @author Rudolf Radlbauer
 */
public interface EinkaufsListe extends Serializable
{
    public enum KRITERIUM   // Sortierkriterien
    {
        BEZEICHNUNG, PREIS, HERKUNFT, BIO, ANZAHL
    }

    /**
     * nimmt ein Produkt in die Einkaufsliste auf
     * @param p Referenz auf das Produkt
     * @param anzahl in dieser Anzahl wird das Produkt übernommen
     */
    public void aufnehmen(Produkt p, int anzahl) throws EinkaufsListeException;

    /**
     * entfernt ein Produkt aus der Einkaufsliste
     * @param p Referenz auf das zu entfernende Produkt
     */
    public void entfernen(Produkt p) throws EinkaufsListeException;

    /**
     * gibt eine Referenz auf die Liste aller Produkte
     * in der Einkaufsliste zurück
     * @return Referenz auf Produktliste
     */
    public List<Produkt> liste() throws EinkaufsListeException;

    /**
     * gibt an, in welcher Anzahl dieses Produkt in der
     * Einkaufsliste ist
     * @param p Referenz auf das Produkt
     * @return Anzahl
     */
    public int getAnzahl(Produkt p) throws EinkaufsListeException;


    /**
     * Setzt die Anzahl des Produkts
     * @param p Referenz auf das Produkt
     * @param anzahl neue Anzahl
     * @throws EinkaufsListeException
     */
    public void setAnzahl(Produkt p, int anzahl) throws EinkaufsListeException;

    /**
     * sortiert die Liste
     * @param k Kriterium, nach welchem sortiert wird
     */
    public void sortieren(KRITERIUM k) throws EinkaufsListeException;

    /**
     * berechnet den Gesamtpreis aller Artikel in
     * der Einkaufsliste
     * @return Gesamtpreis
     */
    public float gesamtPreis() throws EinkaufsListeException;

    /**
     * berechnet die CO2-Belastung
     * @return CO2-Belastung in Gramm
     */
    public float co2() throws EinkaufsListeException;

    /**
     * berechnet die Anzahl der Bioprodukte
     * in der Einkaufsliste
     * @return Anzahl der Bioprodukte
     */
    public int anzahlBio() throws EinkaufsListeException;

    /**
     * berechnet die Gesamtzahl der Produkte
     * in der Einkausliste
     * @return Gesamtzahl der Produkte
     */
    public int anzahlProdukte() throws EinkaufsListeException;
}
