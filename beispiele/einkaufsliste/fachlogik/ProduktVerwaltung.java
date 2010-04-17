package einkaufsliste.fachlogik;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Verwaltung der Produkte, die ich für meine
 * Einkaufsliste auswählen kann
 * 
 * @author Rudolf Radlbauer
 */
public interface ProduktVerwaltung extends Serializable
{
    /**
     * Ein neues Produkt wird in die Verwaltung aufgenommen,
     * jedoch nur, wenn noch kein Produkt mit dieser Bezeichnung
     * vorhanden ist.
     * @param p Referenz auf das neue Produkt
     */
    public void anlegen(Produkt p) throws EinkaufsListeException;

    /**
     * entfernt alle Produkte mit der
     * übergebenen Bezeichnung
     * @param bezeichnung Bezeichnung des zu entfernenden Produkts
     */
    public void entfernen(String bezeichnung) throws EinkaufsListeException;

    /**
     * Produkt wird aus der Verwaltung entfernt, falls es
     * vorhanden ist.
     * @param p Referenz auf das zu entfernende Produkt
     */
    public void entfernen(Produkt p) throws EinkaufsListeException;

    /**
     * liefert eine Referenz auf die Liste aller Produkte
     * in der Verwaltung
     * @return Referenz auf die Produkteliste
     */
    public List<Produkt> liste() throws EinkaufsListeException;

}
