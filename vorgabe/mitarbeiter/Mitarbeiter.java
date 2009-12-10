package mitarbeiter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * einfache Datenhaltungsklasse für einen Mitarbeiter
 * @author Rudolf Radlbauer
 *
 */
public class Mitarbeiter implements Serializable
{

	private static final long serialVersionUID = -1564930052667554546L;
	public final static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd.MM.yyyy");
	
	private int nr;
	private String vorname;
	private String nachname;
	private Date geburtsDatum;
	private char geschlecht;

	public Mitarbeiter()
	{
		nr = 0;
		vorname = "N";
		nachname = "N";
		geburtsDatum = new Date();
		geschlecht = '?';
	}
	
	
	public Mitarbeiter(int nr)
	{
		this();
		setNr(nr);
	}


	public int getNr()
	{
		return nr;
	}


	public void setNr(int nr) throws IllegalArgumentException
	{
		if (nr > 0)
			this.nr = nr;
		else
			throw new IllegalArgumentException("ungültige Mitarbeiternummer: " + nr);
	}


	public String getVorname()
	{
		return vorname;
	}


	public void setVorname(String vorname) throws IllegalArgumentException
	{
		vorname = vorname.trim();  // führende und abschließende Leerzeichen entfernen
		if (vorname != null && vorname.length() > 0)
			this.vorname = vorname;
		else
			throw new IllegalArgumentException("ungültiger Vorname: " + vorname);
	}


	public String getNachname()
	{
		return nachname;
	}


	public void setNachname(String nachname) throws IllegalArgumentException
	{
		nachname = nachname.trim();
		if (nachname != null && nachname.length() > 0)
			this.nachname = nachname;
		else
			throw new IllegalArgumentException("ungültiger Nachname: " + nachname);
	}


	public Date getGeburtsDatum()
	{
		return geburtsDatum;
	}


	public void setGeburtsDatum(Date geburtsDatum) throws IllegalArgumentException
	{
		if (geburtsDatum != null && geburtsDatum.compareTo(new Date()) <= 0)
			this.geburtsDatum = geburtsDatum;
		else
			throw new IllegalArgumentException("Geburtsdatum in der Zukunft");
	}


	public char getGeschlecht()
	{
		return geschlecht;
	}


	public void setGeschlecht(char geschlecht)
	{
		if (geschlecht == 'm' || geschlecht == 'w')
			this.geschlecht = geschlecht;
		else
			throw new IllegalArgumentException("Geschlecht darf nur m oder w sein");
	}


	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder(super.toString());
		str.append("\tnr=").append(nr);
		str.append("\tvorname=").append(vorname);
		str.append("\tachname=").append(nachname);
		str.append("\tgeburtsDatum=").append(DATE_FORMATTER.format(geburtsDatum));		
		return str.toString();
	}
	
	
	

}
