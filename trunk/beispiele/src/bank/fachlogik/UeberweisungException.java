/*
 * Created on 19.12.2005
 *
 */
package bank.fachlogik;


/**
 * F�r Fehler, welche bei Einzahlungen und Auszahlungen und �berweisungen auftreten
 * @author Rudolf Radlbauer
 *
 */
public class UeberweisungException extends Exception
{

    /**
     * erzeugt eine Instanz von UeberweisungException
     * @param message Fehlermeldung (wird an Konstruktor von Exception �bergeben)
     */
    public UeberweisungException(String message)
    {
        super(message);

    }
}
