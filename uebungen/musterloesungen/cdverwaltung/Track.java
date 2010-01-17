package cdverwaltung;

public class Track
{
	private String titel;
	private int dauer; // Sekunden
	
	public Track()
	{
		titel = "unbekannt";
		dauer = 100;
	}
	
	public Track(String titel, int dauer)
	{
		if (titel != null && titel.trim().length() > 0)
			this.titel = titel;
		else
		{
			System.out.println("unbekannter Titel");
			this.titel = "unbekannt";
		}
		if (dauer > 0)
			this.dauer = dauer;
		else
		{
			System.out.println("unbekannte Dauer -> 100");
			this.dauer = 100;
		}
	}
	
	public String getTitel()
	{
		return titel;
	}
	
	public int getDauer()
	{
		return dauer;
	}

	
	
	

}
