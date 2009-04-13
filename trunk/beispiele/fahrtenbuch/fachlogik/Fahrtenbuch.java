package fahrtenbuch.fachlogik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Projekt Fahrtenbuch
 * 
 * Diese Klasse repräsentiert das Fahrtenbuch.
 * Es werden alle Fahrten und Kosten abgespeichert.
 * Die Fahrer werden aus einer Konfigurationsdatei geladen.
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Fahrtenbuch implements Serializable
{
    /**
     * serialVersionUID für Serialisierung
     */
    private static final long serialVersionUID = -2802776237750603782L;
    private List<Fahrt> fahrten;
	private List<Kostenpunkt> kosten;
	private List<Fahrer> fahrer;
	
    /**
     * Der Konstruktor instanziiert die Listen und lädt die Fahrer aus der ini-Datei.
     * Die ini-Datei muss "fahrtenbuch.ini" heißen und Im Klassenpfad liegen.
     * @throws FahrtenbuchException falls keine ini-Datei gefunden wird
     */
	public Fahrtenbuch() throws FahrtenbuchException
	{
		fahrten = new ArrayList<Fahrt>();
		kosten = new ArrayList<Kostenpunkt>();
		fahrer = new ArrayList<Fahrer>();
		
        try
        {
            InputStream iniStream = getClass().getResourceAsStream("/fahrtenbuch.ini");
            if (iniStream != null)
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(iniStream));
                String name = reader.readLine();
                while (name != null)
                {
                    fahrer.add(new Fahrer(name));
                    name = reader.readLine();
                }
                    
            }
        
        } catch(IOException ioe)
        {
            ioe.printStackTrace();
            throw new FahrtenbuchException("kann Konfigurationsdatei nicht lesen");
        }
	}
    
    /**
     * fügt eine Fahrt in die Liste
     * @param fahrt einzufügende Fahrt
     */
    public void add(Fahrt fahrt)
    {
        fahrten.add(fahrt);
    }
    
    /**
     * entfernt eine Fahrt aus der Liste
     * @param fahrt zu entfernende Fahrt
     */
    public void remove(Fahrt fahrt)
    {
        fahrten.remove(fahrt);
    }
    
    /**
     * fügt einen neuen Kostenpunkt in die Liste ein
     * @param kp einzufügender Kostenpunkt
     */
    public void add(Kostenpunkt kp)
    {
        kosten.add(kp);
    }
    
    /**
     * entfernt einen Kostenpunkt aus der Liste
     * @param kp zu entfernender Kostenpunkt
     */
    public void remove(Kostenpunkt kp)
    {
        kosten.remove(kp);
    }
	
    /**
     * liefert einen Iterator für die Kostenpunkte
     * @return Iterator
     */
    public Iterator<Kostenpunkt> kostenIterator()
    {
        return kosten.iterator();
    }
	
    /**
     * liefert einen Iterator for die Fahrten
     * @return Iterator
     */
	public Iterator<Fahrt> fahrtenIterator()
    {
        return fahrten.iterator();
    }
    
    /**
     * sortiert die Fahrten nach ihrer "natürlichen Ordnung"
     * (aufsteigend nach Abfahrtsdatum)
     */
    public void sortFahrten()
    {
        Collections.sort(fahrten);
    }
    
    /**
     * sortiert die Kosten nach ihrer "natürlichen Ordnung"
     * (aufsteigend nach Datum)
     *
     */
    public void sortKosten()
    {
        Collections.sort(kosten);
    }

    /**
	 * gibt die Liste der Fahrer als Array zurück
	 * @return Array mit allen Fahrern
	 */
	public Fahrer[] alleFahrer()
	{
		// Diese Version der Methode toArray() braucht
		// einen Parameter vom gleichen Array-Typ.
		// Dieses kann aber auch die Größe 0 haben.
		return fahrer.toArray(new Fahrer[0]);
	}

}
