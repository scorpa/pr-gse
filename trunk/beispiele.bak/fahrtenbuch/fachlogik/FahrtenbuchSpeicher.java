/*
 * Created on 09.04.2009
 *
 */
package fahrtenbuch.fachlogik;

/**
 * Projekt Fahrtenbuch
 * 
 * Definiert die Schnittstelle f�r das Abspeichern und Laden des Fahrtenbuchs
 * 
 * @author Rudolf Radlbauer
 *
 */
public interface FahrtenbuchSpeicher
{
    /**
     * l�dt das Fahrtenbuch
     * @return Referenz auf das geladene Fahrtenbuch
     * @throws FahrtenbuchException falls das Laden nicht funktioniert
     */
    public Fahrtenbuch laden()  throws FahrtenbuchException;
    
    /**
     * speichert das Fahrtenbuch
     * @param fahrtenbuch das zu speichernde Fahrtenbuch
     * @throws FahrtenbuchException falls das Speichern nicht funktioniert
     */
    public void speichern(Fahrtenbuch fahrtenbuch) throws FahrtenbuchException;

}
