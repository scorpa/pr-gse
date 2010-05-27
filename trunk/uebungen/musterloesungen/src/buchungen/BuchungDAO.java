package buchungen;

import java.util.List;

public interface BuchungDAO
{
	/**
	 * liest aus der Datenbank alle Buchungen und liefert diese in einer Liste zur�ck
	 * @return Liste mit allen Buchungen
	 * @throws DBException
	 */
	public List<Buchung> load() throws DBException;
	
	/**
	 * synchronisiert alle in der Liste enthaltenen Buchungen mit der Datenbank;
	 * d.h. es wird ein UPDATE auf den jeweiligen Datensatz durchgef�hrt.
	 * @param liste Liste der Buchungen
	 * @return Liste aller Buchungen, f�r welche erfolgreich ein UPDATE durchgef�hrt wurde
	 * @throws DBException
	 */
	public List<Buchung> update(List<Buchung> liste) throws DBException;
	
	
	/**
	 * schlie�t die Datenbankverbindung
	 * @throws DBException
	 */
	public void close() throws DBException;
	

}
