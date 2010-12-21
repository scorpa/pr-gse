package theater;

 


import java.util.Date;
import java.util.List;

/**
 *
 * @author Rudolf Radlbauer
 */
public interface ReservierungsTool
{
    /**
     * liefert eine Liste der Vorstellungen an dem übergebenen Datum
     *
     * @param datum Datum der Vorstellungen
     * @return Liste der Vorstellungen
     * @throws ReservierungException bei Datenbankzugriffsfehlern
     */
    public List<Vorstellung> vorstellungsListe(Date datum) throws ReservierungException;

    /**
     * Speichert eine Reservierung. Dabei muss darauf geachtet werden,
     * dass kein Sitzplatz für die selbe Vorstellung doppelt vergeben wird.
     * Nach erfolgreichem Speichern der Reservierung soll die neu erzeugte
     * Reservierungsnummer (r_id) mit dem Wert im Attribut id übereinstimmen.
     *
     * @param r Referenz auf die zu speichernde Reservierung
     * @return true wenn das Speichern gut geht,
     *         false wenn der Sitzplatz bereits vergeben ist
     * @throws ReservierungException bei Datenbankzugriffsfehlern
     */
    public boolean speichern(Reservierung r) throws ReservierungException;

    /**
     * gibt an, wie viele Plätze für die übergebene Vorstellung frei sind.
     * (es gibt im Theatersaal die Plätze 1 bis 100)
     *
     * @param v Vorstellung
     * @return Anzahl der freien Plätze
     * @throws ReservierungException bei Datenbankzugriffsfehlern
     */
    public int freiePlaetze(Vorstellung v) throws ReservierungException;


    /**
     * liefert eine Liste aller Reservierungen für eine bestimmte Vorstellung
     *
     * @param v Vorstellung
     * @return Liste der Reservierungen
     * @throws ReservierungException bei Datenbankzugriffsfehlern
     */
    public List<Reservierung> reservierungsListe(Vorstellung v) throws ReservierungException;

}
