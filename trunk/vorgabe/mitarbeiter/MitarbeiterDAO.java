package mitarbeiter;

import java.util.Date;
import java.util.List;

public interface MitarbeiterDAO
{
	/**
	 * speichert eine Mitarbeiter-Instanz.
	 * Wenn die Mitarbeiternummer 0 ist, wird ein neuer Datensatz angelegt 
	 * und eine neue Mitarbeiternummer generiert.
	 * Wenn die Mitarbeiternummer ungleich 0 ist, existiert schon ein Datensatz
	 * mit dieser Nummer. Dieser wird aktualisiert.
	 * @param ma Referenz auf Mitarbeiter-Instanz
	 * @throws PersistenzException
	 */
	public void speichern(Mitarbeiter ma) throws PersistenzException;
	
	/**
	 * findet einen Mitarbeiter anhand der Mitarbeiternummer
	 * @param nr Mitarbeiternummer
	 * @return Referenz auf gefundene Mitarbeiter-Instanz oder null, wenn nicht gefunden
	 * @throws PersistenzException
	 */
	public Mitarbeiter finden(int nr) throws PersistenzException;
	
	
	/**
	 * findet alle Mitarbeter, deren Nachname mit dem übergebenen String beginnen
	 * @param nachname Beginn des Nachnamens
	 * @return Liste der Mitarbeiter, deren Nachname mit dem übergebenen String beginnt - kann auch leer sein
	 * @throws PersistenzException
	 */
	public List<Mitarbeiter> finden(String nachname) throws PersistenzException;
	
	/**
	 * findet alle Mitarbeiter, deren Geburtdatum zwischen den beiden übergebenen Daten liegt.
	 * @param von ab diesem Datum
	 * @param bis bis zu diesem Dateum
	 * @return Liste der Mitarbeiter, deren Geburtsdatum zwischen den beiden übergebenen Daten liegt.
	 * @throws PersistenzException
	 */
	public List<Mitarbeiter> finden(Date von, Date bis) throws PersistenzException;
	
	
	/**
	 * löscht den übergebenen Mitarbeiter
	 * @param ma Referenz auf den zu löschenden Mitarbeiter
	 * @throws PersistenzException
	 */
	public void loeschen(Mitarbeiter ma) throws PersistenzException;
	

}
