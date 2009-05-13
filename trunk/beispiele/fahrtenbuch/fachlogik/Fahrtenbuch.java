package fahrtenbuch.fachlogik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Projekt Fahrtenbuch
 * 
 * Diese Klasse repr�sentiert das Fahrtenbuch.
 * Es werden alle Fahrten und Kosten abgespeichert.
 * Die Fahrer werden aus einer Konfigurationsdatei geladen.
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Fahrtenbuch implements Serializable
{
    /**
     * serialVersionUID f�r Serialisierung
     */
    private static final long serialVersionUID = -2802776237750603782L;
    private List<Fahrt> fahrten;
	private List<Kostenpunkt> kosten;
	private List<Fahrer> fahrer;
	
    /**
     * Der Konstruktor instanziiert die Listen und l�dt die Fahrer aus der ini-Datei.
     * Die ini-Datei muss "fahrtenbuch.ini" hei�en und Im Klassenpfad liegen.
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
     * f�gt eine Fahrt in die Liste
     * @param fahrt einzuf�gende Fahrt
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
     * f�gt einen neuen Kostenpunkt in die Liste ein
     * @param kp einzuf�gender Kostenpunkt
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
     * Erstellt eine Liste von Abrechnungen f�r alle Fahrer 
     * f�r den abgefragten Zeitraum
     * 
     * @param von Beginn des gefragten Zeitraums
     * @param bis Ende des gefragten Zeitraums
     * @return Liste von Abrechnungen
     */
    public List<Abrechnung> abrechnen (Date von, Date bis)
    {
    	Abrechnung.clear();
    	Map<Fahrer, Abrechnung> abrechnungen = new HashMap<Fahrer, Abrechnung>();
    	
    	for (Fahrer f : fahrer)
    		abrechnungen.put(f, new Abrechnung(f));
    	
    	for (Fahrt f : fahrten)
    	{
    		// Fahrt �berschneidet sich zumindest teilweise mit abgefragtem Intervall
    		if (f.getAbfahrt().compareTo(bis) < 0 && f.getAnkunft().compareTo(von) > 0)
    			abrechnungen.get(f.getFahrer()).addFahrt(f);
    	}

    	for (Kostenpunkt k : kosten)
    	{
    		if (k.getDatum().compareTo(von) > 0 && k.getDatum().compareTo(bis) > 0)
    			abrechnungen.get(k.getFahrer()).addKostenpunkt(k);
    	}
    	
    	List<Abrechnung> liste = new ArrayList<Abrechnung>();
    	liste.addAll(abrechnungen.values());
    	Collections.sort(liste);
    	return liste;
    }
	
    /**
     * liefert einen Iterator f�r die Kostenpunkte
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
     * sortiert die Fahrten nach ihrer "nat�rlichen Ordnung"
     * (aufsteigend nach Abfahrtsdatum)
     */
    public void sortFahrten()
    {
        Collections.sort(fahrten);
    }
    
    /**
     * sortiert die Kosten nach ihrer "nat�rlichen Ordnung"
     * (aufsteigend nach Datum)
     *
     */
    public void sortKosten()
    {
        Collections.sort(kosten);
    }

    /**
	 * gibt die Liste der Fahrer als Array zur�ck
	 * @return Array mit allen Fahrern
	 */
	public Fahrer[] alleFahrer()
	{
		// Diese Version der Methode toArray() braucht
		// einen Parameter vom gleichen Array-Typ.
		// Dieses kann aber auch die Gr��e 0 haben.
		return fahrer.toArray(new Fahrer[0]);
	}

}
