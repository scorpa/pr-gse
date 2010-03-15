package einkaufsliste.fachlogik;

import java.util.ArrayList;

/**
 * Verwaltung der Produkte, die ich für meine
 * Einkaufsliste auswählen kann
 * 
 * @author Rudolf Radlbauer
 */
public interface ProduktVerwaltung
{
    /**
     * Ein neues Produkt wird in die Verwaltung aufgenommen,
     * jedoch nur, wenn noch kein Produkt mit dieser Bezeichnung
     * vorhanden ist.
     * @param p Referenz auf das neue Produkt
     */
    public void anlegen(Produkt p);

    /**
     * entfernt alle Produkte mit der
     * übergebenen Bezeichnung
     * @param bezeichnung Bezeichnung des zu entfernenden Produkts
     */
    public void entfernen(String bezeichnung);

    /**
     * Produkt wird aus der Verwaltung entfernt, falls es
     * vorhanden ist.
     * @param p Referenz auf das zu entfernende Produkt
     */
    public void entfernen(Produkt p);

    /**
     * liefert eine Referenz auf die Liste aller Produkte
     * in der Verwaltung
     * @return Referenz auf die Produkteliste
     */
    public ArrayList<Produkt> liste();

}
