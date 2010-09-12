package termine;

import java.util.List;
/**
 * Schnittstelle für einen Terminplaner, 
 * welcher Instanzen der Klasse Termin verwaltet
 * 
 * @author Rudolf Radlbauer
 *
 */
public interface TerminPlaner
{
	/**
	 * Fügt einen Termin in den Terminplaner ein.
	 * Der Termin darf allerdings nur dann eingefügt werden, 
	 * wenn noch kein Termin mit dieser Bezeichnung existiert, 
	 * und wenn der Termin mit keinem anderen Termin überlappt.
	 * @param t Referenz auf den einzufügenden Termin
	 * @return true: Termin wurde eingefügt, 
	 *         false: Termin wurde nicht eingefügt
	 */
	public boolean einfuegen(Termin t);
	
	/**
	 * gibt eine Referenz auf die Liste aller Termine zurück.
	 * @return Referenz auf die Liste aller Termine
	 */
	public List<Termin> liste();
	
	/**
	 * löscht den Termin mit der übergebenen Bezeichnung
	 * @param bezeichnung Bezeichnung des Termins
	 * @return true: Termin war vorhanden und wurde gelöscht
	 *         false: Termin war nicht vorhanden
	 */
	public boolean loeschen(String bezeichnung); 
	
	
	/**
	 * sortiert die Termine aufsteigend nach Datum
	 */
	public void sortieren();

}
