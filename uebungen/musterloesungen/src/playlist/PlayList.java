package playlist;

import java.util.ArrayList;

public class PlayList
{
	private final static long MAX_GROESSE = 750;
	private String bezeichnung;
	private ArrayList<Song> liste;
	
	public PlayList(String bezeichnung)
	{
		liste = new ArrayList<Song>();
		if (bezeichnung != null && bezeichnung.length() > 0)
			this.bezeichnung = bezeichnung;
		else
		{
			this.bezeichnung = "unbekannt";
			System.out.println("leere Bezeichnung ist nicht erlaubt");
		}
	}

	public String getBezeichnung()
	{
		return bezeichnung;
	}
	
	public void einfuegen(Song song)
	{
		if (gesamtGroesse() + song.getGroesse() <= MAX_GROESSE)
		{
			if(suchen(song.getTitel()) == null)
				liste.add(song);
			else
				System.out.println("Titel ist schon vorhanden: " + song.getTitel());
		}
		else
			System.out.println("Speicherkapazität überschritten");
		
	}
	
	private int gesamtGroesse()
	{
		int summe = 0;
		for (Song song : liste)
			summe += song.getGroesse();
		return summe;
	}
	
	public void loeschen(int index)
	{
		if (index >= 0 && index < liste.size())
			liste.remove(index);
		else
			System.out.println("ungültiger Index");
	}
	
	public int gesamtDauer()
	{
		int summe = 0;
		for (Song song : liste)
			summe += song.getDauer();
		return summe;
	}
	
	
	public void liste()
	{
		for (int i = 0; i < liste.size(); i++)
		{
			Song m = liste.get(i);
			System.out.println(i + "\t" + m.getGroesse() + "\t" + m.getDauer() + "\t" + m.getTitel());
		}
	}
	
	public Song suchen(String titel)
	{
		Song song = null;
		for (Song m : liste)
		{
			if (titel.equals(m.getTitel()))
			{
				song = m;
				break;
			}
		}		
		return song;
	}
	
	public int laengerAls(long dauer)
	{
		int anzahl = 0;
		for (Song song : liste)
		{
			if (song.getDauer() > dauer)
				anzahl++;
		}		
		return anzahl;
	}

}
