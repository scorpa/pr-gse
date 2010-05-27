package anrufe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Implementierung des Interfaces DateiAnbindung laut Aufgabenstellung
 * 
 * @author Rudolf Radlbauer
 *
 */
public class DateiImplementierung implements DateiAnbindung
{
	/**
	 * siehe Aufgabenstellung
	 */
	public List<Anruf> lesen(String datei) throws IOException
	{
		List<Anruf> liste = new ArrayList<Anruf>();
		// BufferedReader erlaubt zeilenweises einlesen
		BufferedReader reader = new BufferedReader(new FileReader(datei));
		String line;  // Variable für Zeilen
		while ((line = reader.readLine()) != null)  // solange es noch eine Zeile gibt
		{
			try
			{
				Anruf a = parse(line);
				if (a != null)
					liste.add(a);
			} catch (Exception e)
			{
				e.printStackTrace();
				throw new IOException("Fehler beim Lesen einer Zeile");
			}
		}
		reader.close();
		return liste;
	}
	
	/**
	 * erzeugt aus einer eingelesenen Zeile eine Anruf-Instanz
	 * @param line  Zeile
	 * @return Anruf-Instanz
	 * @throws ParseException wenn das Format nicht stimmt
	 */
	private Anruf parse(String line) throws ParseException
	{
		if (!line.trim().isEmpty())
		{
			// Zeile zerteilen
			StringTokenizer tokenizer = new StringTokenizer(line, "|");
			Anruf anruf = new Anruf(tokenizer.nextToken());  // Nummer
			anruf.setZeit(DATUMSFORMAT.parse(tokenizer.nextToken()));  // Datum
			anruf.setDauer(Integer.parseInt(tokenizer.nextToken()));  // Dauer
			return anruf;
		}
		return null; // wenn Zeile leer ist
	}

	/**
	 * siehe Aufgabenstellung
	 */
	public void schreiben(String datei, List<Anruf> liste) throws IOException
	{
		// ein PrintWriter ist wie System.out zu verwenden, schreibt allerdings in diesem 
		// Fall in eine Datei
		PrintWriter writer = new PrintWriter(datei);
		for (Anruf anruf : liste)
		{  // jeder Anruf wird im richtigen Format ausgegeben.
			writer.println(anruf.getNr() + "|" 
					+ DATUMSFORMAT.format(anruf.getZeit())
					+ "|" + anruf.getDauer());
		}
		writer.close();
	}
	
	// nur zum Testen
	public static void main(String[] args)
	{
		try
		{
			DateiAnbindung io = new DateiImplementierung();
			List<Anruf> liste = io.lesen("anrufe/anrufe.csv");
			for (Anruf a : liste)
				System.out.println(a);
			io.schreiben("anrufe/anrufe.csv", liste);
			// noch einmal einlesen
			io.lesen("anrufe/anrufe.csv");			
			System.out.println("OK");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
