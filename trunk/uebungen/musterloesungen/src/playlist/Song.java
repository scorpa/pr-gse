package playlist;

public class Song
{
	private String titel;
	private int dauer;
	private int groesse;
	
	public Song(String titel)
	{
		if (titel != null && titel.length() > 0)
			this.titel = titel;
		else
		{
			System.out.println("leerer Titel nicht erlaubt");
			this.titel = "unbekannt";
		}
		dauer = 600;
		groesse = 100;
	}

	public int getDauer()
	{
		return dauer;
	}

	public void setDauer(int dauer)
	{
		if (dauer > 0)
			this.dauer = dauer;
		else
			System.out.println("Dauer muss größer als 0 sein");
	}

	public int getGroesse()
	{
		return groesse;
	}

	public void setGroesse(int groesse)
	{
		if (groesse > 0)
			this.groesse = groesse;
		else
			System.out.println("Größe muss größer als 0 sein");
	}

	public String getTitel()
	{
		return titel;
	}
	
	
	

}
