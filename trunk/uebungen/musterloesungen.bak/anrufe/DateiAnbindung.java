package anrufe;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * definiert die Methoden für das Einlesen und Ausgeben in eine CSV-Datei
 * @author Rudolf Radlbauer
 *
 */
public interface DateiAnbindung
{
	// Konstante für das Formattieren und Parsen des Datums entsprechend dem CSV-Format
	public final static SimpleDateFormat DATUMSFORMAT = new SimpleDateFormat("dd.MM.yyyy/HH:mm:ss");
	
	/**
	 * liest die Anrufe aus der CSV-Datei und liefert diese in einer Liste
	 * @param datei CSV-Datei
	 * @return Referenz auf eine Liste mit den gelesenen Anrufen
	 * @throws IOException falls beim Einlesen ein Fehler auftritt (auch bei Parser-Fehlern)
	 */
	public List<Anruf> lesen(String datei) throws IOException;
	
	/**
	 * schreibt die Anrufe in eine CSV-Datei (entsprechend dem spezifizierten Format); 
	 * die Datei kann dann mit lesen(...) eingelesen werden.
	 * @param datei CSV-Datei
	 * @param liste Anruf-Liste, die geschrieben werden soll
	 * @throws IOException bei Ausgabe-Fehlern
	 */
	public void schreiben(String datei, List<Anruf> liste) throws IOException;
}
