/*
 * Created on 19.12.2005
 *
 */
package bank.fachlogik;


/**
 * Für Fehler, welche bei Einzahlungen und Auszahlungen und Überweisungen auftreten
 * @author Rudolf Radlbauer
 *
 */
public class UeberweisungException extends Exception
{

    /**
     * erzeugt eine Instanz von UeberweisungException
     * @param message Fehlermeldung (wird an Konstruktor von Exception übergeben)
     */
    public UeberweisungException(String message)
    {
        super(message);

    }
}
