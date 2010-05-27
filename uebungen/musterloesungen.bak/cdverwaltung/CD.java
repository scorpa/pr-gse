package cdverwaltung;

public class CD
{
	private String interpret;
	private String titel;
	private Track[] tracks;

	public CD(int anzahlTitel)
	{
		interpret = "unbekannt";
		titel = "unbekannt";
		tracks = new Track[anzahlTitel];
		int index = 0;
		while (index < anzahlTitel)
		{
			tracks[index] = new Track();
			index++;
		}
	}
	
	public void setTrack(int index, Track track)
	{
		if (index >= 0 && index < tracks.length)
			tracks[index] = track;
		else
			System.out.println("ungültiger Index");
	}
	
	public Track get(int index)
	{
		if (index >= 0 && index < tracks.length)
			return tracks[index];
		else
			return null;
	}
	
	public void print()
	{
		System.out.println(interpret + ": " + titel);
		int index = 0;
		while (index < tracks.length)
		{
			Track track = tracks[index];
			System.out.println(track.getTitel() + " (" + track.getDauer() + " sec)");
			index++;
		}
	}

	public String getInterpret()
	{
		return interpret;
	}

	public void setInterpret(String interpret)
	{
		if (interpret != null && interpret.trim().length() > 0)
			this.interpret = interpret;
		else
		{
			System.out.println("unbekannter Interpret");
			this.interpret = "unbekannt";
		}
	}

	public String getTitel()
	{
		return titel;
	}

	public void setTitel(String titel)
	{
		if (titel != null && titel.trim().length() > 0)
			this.titel = titel;
		else
		{
			System.out.println("unbekannter Titel");
			this.titel = "unbekannt";
		}
	}
	
	// Minuten
	public int gesamtDauer()
	{
		int dauer = 0;
		int index = 0;
		while (index < tracks.length)
		{
			dauer += tracks[index].getDauer();
			index++;
		}
		return dauer / 60;
	}
	
}
