package bank.persistenz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import bank.fachlogik.Konto;
import bank.fachlogik.KontoVerwaltungException;
import bank.fachlogik.SpeicherKontoVerwaltung;

/**
 * Implementierung der KontoVerwaltung, in welcher die Daten in einer Datei gespeichert
 * werden. Beim Anlegen einer Instanz werden alle Konten eingelesen, beim schließen
 * werden alle Daten in die Datei geschrieben.
 * Dazwischen findet kein echtes Speichern statt.
 * @author Rudolf Radlbauer
 *
 */
public class DateiKontoVerwaltung extends SpeicherKontoVerwaltung
{
	private File datei;  // Datei, in welcher Kontodaten gespeichert sind
	
	/**
	 * Falls die angegebene Datei existiert, werden die Konten eingelesen.
	 * Ansonsten passiert nichts.
	 * @param dateiName Pfad zur Datei, in welcher die Kontodaten stehen
	 * @throws KontoVerwaltungException bei Lesefehlern
	 */
	public DateiKontoVerwaltung(String dateiName) throws KontoVerwaltungException
	{
		datei = new File(dateiName);
		if (datei.exists())
		{
			try
			{
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(datei));
				List<Konto> liste = (List<Konto>)in.readObject();
				for (Konto k : liste)
					speichern(k);
				in.close();
					
			} catch (IOException e)
			{
				e.printStackTrace();
				throw new KontoVerwaltungException("Datei konnte nicht geöffnet werden: " + dateiName);
			} catch(ClassNotFoundException e)
			{
				e.printStackTrace();
				throw new KontoVerwaltungException("Fehler beim Einlesen der Daten");
			}
		}					
	}

	/**
	 * Schreibt die Kontodaten in die Datei, welche beim Instanziieren angegeben wurde
	 * @throws KontoVerwaltungException bei Schreibfehlern
	 */
	@Override
	public void close() throws KontoVerwaltungException
	{
		try
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(datei));
			out.writeObject(getListe());
			out.close();
		} catch (IOException e)
		{
			e.printStackTrace();
			throw new KontoVerwaltungException("Fehler beim Öffnen der Datei " + datei.getAbsolutePath());
		}
		
	}

}
