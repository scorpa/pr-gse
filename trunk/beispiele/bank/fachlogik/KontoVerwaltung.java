/*
 * Created on 19.12.2005
 *
 */
package bank.fachlogik;

import java.util.List;

/**
 * Schnittstelle f�r ein Objekt, welches Konten verwalten kann. <br/> Folgende
 * Varianten sind denkbar:<br/> Verwaltung im Speicher <br/> Verwaltung in
 * einer Datei <br/> Verwaltung in einer Datenbank <br/> Eventuell auch andere
 * Varianten (?)
 * 
 * @author Rudolf Radlbauer
 * @uml.dependency supplier="fachlogik.Konto"
 */
public interface KontoVerwaltung
{
    /**
     * nimmt ein Konto in der Verwaltung auf oder speichert �nderungen
     * 
     * @param k Referenz auf das zu speichernde Konto
     *            
     * @throws IllegalStateException
     *             wenn kein Konto mehr aufgenommen werden kann
     * @throws IllegalArgumentException
     *             wenn k null ist
     * @throws KontoVerwaltungException
     *             bei internen Fehlern der Verwaltung
     */
    public void speichern(Konto k) throws KontoVerwaltungException,
            IllegalStateException, IllegalArgumentException;

    /**
     * entfernt ein Konto aus der Verwaltung
     * 
     * @param k
     *            Konto, welches entfernt wird
     * @throws IllegalArgumentException
     *             wenn das Konto in der Verwaltung nicht existiert
     * @throws KontoVerwaltungException
     *             bei internen Fehlern der Verwaltung
     */
    public void entfernen(Konto k) throws KontoVerwaltungException,
            IllegalArgumentException;

    /**
     * gibt in einer Liste alle Konten zur�ck
     * 
     * @return Liste mit Konto-Objekten (alle in der Verwaltung enthaltenen Konten)
     * @throws KontoVerwaltungException
     *             bei internen Fehlern der Verwaltung
     */
    public List<Konto> getListe() throws KontoVerwaltungException;

    /**
     * gibt in einer Liste Konten zur�ck, deren Besitzer (Name) mit dem
     * �bergebenen String beginnen (Gro�- und Kleinschreibung wird ignoriert).
     * 
     * @param besitzerAnfang
     *            Wortteil, mit dem der Name des Besitzers beginnt
     * @return Array, welches genau die Gr��e hat, um alle Konten, die zum
     *         �bergebenen Parameter passen, zu enthalten. <br/> Falls kein
     *         passendes Konto gefunden wird, hat das Array die L�nge 0.
     * @throws KontoVerwaltungException
     *             bei internen Fehlern der Verwaltung
     */
    public List<Konto> get(String besitzerAnfang) throws KontoVerwaltungException;

    /**
     * liefert das Konto-Objekt zur �bergebenen Kontonummer
     * 
     * @param nummer
     *            Kontonummer
     * @return Konto-Objekt zur �bergebenen Nummer
     * @throws IllegalArgumentException
     *             falls kein Konto zu dieser Nummer existiert.
     * @throws KontoVerwaltungException
     *             bei internen Fehlern der Verwaltung
     */
    public Konto get(int nummer) throws KontoVerwaltungException,
            IllegalArgumentException;

    /**
     * liefert eine neue Nummer f�r ein Konto. <br/> Es muss garantiert sein,
     * dass diese Nummer noch f�r kein anderes Konto vergeben wurde.
     * 
     * @return neue Kontonummer
     * @throws KontoVerwaltungException
     *             bei internen Fehlern der Verwaltung
     */
    public int erzeugeNummer() throws KontoVerwaltungException;

    /**
     * wird aufgerufen, wenn die Kontoverwaltung nicht mehr ben�tigt wird
     * (Aufr�umarbeiten)
     * 
     * @throws KontoVerwaltungException
     *             bei internen Fehlern der Verwaltung
     */
    public void close() throws KontoVerwaltungException;

    /**
     * startet eine Transaktion
     * 
     * @throws KontoVerwaltungException
     *             bei internen Fehlern der Verwaltung
     */
    public void beginTransaktion() throws KontoVerwaltungException;

    /**
     * schlie�t eine Transaktion ab
     * 
     * @throws KontoVerwaltungException
     *             bei internen Fehlern der Verwaltung
     */
    public void endTransaktion() throws KontoVerwaltungException;

    /**
     * verwirft eine Transaktion
     * 
     * @throws KontoVerwaltungException
     *             bei internen Fehlern der Verwaltung
     */
    public void cancelTransaktion() throws KontoVerwaltungException;


}
