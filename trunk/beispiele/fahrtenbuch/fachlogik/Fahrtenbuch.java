package fahrtenbuch.fachlogik;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// TODO: fertig implementieren
public class Fahrtenbuch implements Serializable
{
	private List<Fahrt> fahrten;
	private List<Kostenpunkt> kosten;
	private List<Fahrer> fahrer;
	
	public Fahrtenbuch()
	{
		fahrten = new ArrayList<Fahrt>();
		kosten = new ArrayList<Kostenpunkt>();
		fahrer = new ArrayList<Fahrer>();
		
		// vorerst zu Testzwecken
		try
		{
			fahrer.add(new Fahrer("Susi"));
			fahrer.add(new Fahrer("Fritz"));
			fahrer.add(new Fahrer("Erika"));
			fahrer.add(new Fahrer("Hans"));
		} catch(FahrtenbuchException e)
		{
			// sollte eigentlich nicht auftreten
			e.printStackTrace();
		}
	}
    
    public void add(Fahrt fahrt)
    {
        fahrten.add(fahrt);
    }
    
    public void remove(Fahrt fahrt)
    {
        fahrten.remove(fahrt);
    }
    
    public void add(Kostenpunkt kp)
    {
        kosten.add(kp);
    }
    
    public void remove(Kostenpunkt kp)
    {
        kosten.remove(kp);
    }
	
    public Iterator<Kostenpunkt> kostenIterator()
    {
        return kosten.iterator();
    }
	
	public Iterator<Fahrt> fahrtenIterator()
    {
        return fahrten.iterator();
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
