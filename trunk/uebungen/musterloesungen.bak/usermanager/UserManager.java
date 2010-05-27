package usermanager;


public interface UserManager
{
	
	/**
	 * Anmeldung des Benutzers:
	 * Die �bergebene User-Instanz hat userName und passwort gesetzt.
	 * Es wird �berpr�ft, ob ein User mit diesem userNamen und diesem Passwort
	 * in der Datenbank existiert. 
	 * Wenn ja, werden in der User-Instanz die zugeh�rige ID und der zugeh�rige Name 
	 * mit den Werten aus der Datenbank gesetzt und es wird true geliefert.
	 * Falls nein wird false geliefert.
	 * @param user User-Instanz mit ausgef�lltem userName und password
	 * @return true, falls Anmeldung erfolgreich
	 * @throws UserManagerException bei Datenbankzugriffsfehlern
	 */
	public boolean login(User user) throws UserManagerException;
	
	/**
	 * Benutzer wird registriert:
	 * In der �bergebenen User-Instanz sind alle Attribute gesetzt.
	 * Der User wird als neuer Datensatz in die Tabelle eingef�gt,
	 * falls noch kein User mit diesem userName existiert.
	 * Andernfalls wird eine UserManagerException geworfen.
	 * @param user vollst�ndig ausgef�llte User-Instanz
	 * @throws UserManagerException bei Datenbankzugriffsfehlern oder falls userName bereits existiert
	 */
	public void register(User user) throws UserManagerException;
	
	/**
	 * Daten des Users werden aktualisiert:
	 * In der �bergebenen User-Instanz sind alle Attribute gesetzt.
	 * Es wird ein Update auf den Datensatz mit der gleichen ID durchgef�hrt.
	 * Falls kein Datensatz mit dieser ID existiert, wird eine UserManagerException geworfen.
	 * @param user vollst�ndig ausgef�llte User-Instanz mit existierender ID
	 * @throws UserManagerException bei Datenbankzugriffsfehlern oder falls ID nicht existiert
	 */
	public void update(User user) throws UserManagerException;
	
	/**
	 * schlie�t die Datenbankverbindung
	 * @throws UserManagerException bei Datenbankzugriffsfehlern
	 */
	public void close() throws UserManagerException;

}
