package videothek;

import java.io.Serializable;

/**
 * Prüfungsaufgabe Videothek
 * Datenhaltungsklasse für ein Video
 * @author Rudolf Radlbauer
 *
 */
public class Video implements Serializable
{
    // zwecks Kompatibilität der Daten
    private static final long serialVersionUID = 2860406937537051190L;

    // Enum-Typ für die Art des Mediums
    public enum MEDIUM {DVD, VCD, VHS};
	
	private String titel;
	private String genre;
	private int dauer;
	private MEDIUM medium;
	private boolean gesehen;
	
	/**
	 * Standardwerte werden gesetzt
	 */
	public Video()
	{
		titel="";
		genre="";
		dauer = 0;
		medium = MEDIUM.DVD;
		gesehen = false;
	}

	
	public String getTitel()
	{
		return titel;
	}

	/**
	 * Titel darf nicht leer sein
	 * @param titel
	 */
	public void setTitel(String titel)
	{
		if (titel != null && titel.trim().length() > 0)
			this.titel = titel;
		else
			throw new IllegalArgumentException("ungültiger Titel");
	}

	public String getGenre()
	{
		return genre;
	}

	/**
	 * Genre darf nicht leer sein
	 * @param genre
	 */
	public void setGenre(String genre)
	{
		if (genre != null && genre.trim().length() > 0)
			this.genre = genre;
		else
			throw new IllegalArgumentException("ungültiges Genre");
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
			throw new IllegalArgumentException("ungültige Spieldauer");
	}

	public MEDIUM getMedium()
	{
		return medium;
	}

	public void setMedium(MEDIUM medium)
	{
		this.medium = medium;
	}

	public boolean isGesehen()
	{
		return gesehen;
	}

	public void setGesehen(boolean gesehen)
	{
		this.gesehen = gesehen;
	}
	
	
	
}
