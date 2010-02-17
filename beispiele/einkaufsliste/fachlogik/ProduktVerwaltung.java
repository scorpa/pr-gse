package einkaufsliste.fachlogik;

import java.util.ArrayList;

/**
 * Verwaltung der Produkte, die ich für meine
 * Einkaufsliste auswählen kann
 * 
 * @author Rudi
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
     * Produkt wird aus der Verwaltung entfernt, falls es
     * vorhanden ist.
     * @param bezeichnung Bezeichnung des Produkts
     */
    public void entfernen(String bezeichnung);

    /**
     * liefert eine Referenz auf die Liste aller Produkte
     * in der Verwaltung
     * @return Referenz auf die Produkteliste
     */
    public ArrayList<Produkt> liste();

}
