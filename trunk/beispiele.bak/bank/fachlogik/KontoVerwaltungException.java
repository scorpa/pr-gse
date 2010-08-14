/*
 * Created on 19.12.2005
 *
 */
package bank.fachlogik;


/**
 * @author Rudolf Radlbauer
 *
 */
public class KontoVerwaltungException extends Exception
{
    /**
     * erzeugt Instanz von KontoVerwaltungException
     * @param message Fehlermeldung wird an Konstruktor von Exception übergeben
     */
    public KontoVerwaltungException(String message)
    {
        super(message);
        
    }
}
