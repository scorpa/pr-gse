package termine;

import java.util.List;
/**
 * Schnittstelle f�r einen Terminplaner, 
 * welcher Instanzen der Klasse Termin verwaltet
 * 
 * @author Rudolf Radlbauer
 *
 */
public interface TerminPlaner
{
	/**
	 * F�gt einen Termin in den Terminplaner ein.
	 * Der Termin darf allerdings nur dann eingef�gt werden, 
	 * wenn noch kein Termin mit dieser Bezeichnung existiert, 
	 * und wenn der Termin mit keinem anderen Termin �berlappt.
	 * @param t Referenz auf den einzuf�genden Termin
	 * @return true: Termin wurde eingef�gt, 
	 *         false: Termin wurde nicht eingef�gt
	 */
	public boolean einfuegen(Termin t);
	
	/**
	 * gibt eine Referenz auf die Liste aller Termine zur�ck.
	 * @return Referenz auf die Liste aller Termine
	 */
	public List<Termin> liste();
	
	/**
	 * l�scht den Termin mit der �bergebenen Bezeichnung
	 * @param bezeichnung Bezeichnung des Termins
	 * @return true: Termin war vorhanden und wurde gel�scht
	 *         false: Termin war nicht vorhanden
	 */
	public boolean loeschen(String bezeichnung); 
	
	
	/**
	 * sortiert die Termine aufsteigend nach Datum
	 */
	public void sortieren();

}
