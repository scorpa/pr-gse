package fahrtenbuch.fachlogik;

/**
 * Eine Abrechnung wird pro Fahrer erstellt.
 * zusätzlich sind statische Attribute für 
 * Gesamtkosten und Gesamtkilometer vorhanden.
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Abrechnung implements Comparable<Abrechnung>
{
	private Fahrer fahrer;
	private int km;
	private float bezahlt;
	
	private static int gesamtKM;
	private static float gesamtAusgaben;
	
	/**
	 * Konstruktor übernimmt den Fahrer als Parameter
	 * @param fahrer
	 */
	public Abrechnung(Fahrer fahrer)
	{
		this.fahrer = fahrer;
	}
	
	/**
	 * übernimmt eine Fahrt zur Abrechnung
	 * @param fahrt Fahrt
	 */
	public void addFahrt(Fahrt fahrt)
	{
		int kilometer = fahrt.getKmAnkunft() - fahrt.getKmAbfahrt();
		km += kilometer;
		gesamtKM += kilometer;
	}
	
	/**
	 * übernimmt einen Kostenpunkt zur Abrechnung
	 * @param kosten Kostenpunkt
	 */
	public void addKostenpunkt(Kostenpunkt kosten)
	{
		bezahlt += kosten.getBetrag();
		gesamtAusgaben += kosten.getBetrag();
	}
	
	/**
	 * berechnet, wie viel der Fahrer aus der Gemeinschaftskasse
	 * bekommt oder bezahlen muss (negativer Betrag)
	 * @return
	 */
	public float berechneGuthaben()
	{
		if (gesamtKM > 0)
		{
			float kostenProKm = gesamtAusgaben / gesamtKM;
			return bezahlt - (kostenProKm * km);
		}
		else
			return bezahlt;
			
	}
	
	public static void clear()
	{
		gesamtAusgaben = 0;
		gesamtKM = 0;
	}

	public Fahrer getFahrer()
	{
		return fahrer;
	}

	public int getKm()
	{
		return km;
	}

	public float getBezahlt()
	{
		return bezahlt;
	}

	public static int getGesamtKM()
	{
		return gesamtKM;
	}

	public static float getGesamtAusgaben()
	{
		return gesamtAusgaben;
	}

	public int compareTo(Abrechnung a)
	{
		return this.getFahrer().getName().compareTo(a.getFahrer().getName());
	}
	
	
	
	

}
