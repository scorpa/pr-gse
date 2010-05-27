package anrufe;

import java.util.Date;

/**
 * Datenhaltungsklasse für einen Anruf
 * @author Rudolf Radlbauer
 *
 */
public class Anruf
{
	private String nr;  // angerufene Telefonnummer
	private int dauer;  // Dauer des Anrufs in Sekunden
	private Date zeit;  // Datum und Uhrzeit des Anrufs
	
	public Anruf(String nr) throws IllegalArgumentException
	{
		if (nr.matches("[+0-9][0-9]*"))
			this.nr = nr;
		else
			throw new IllegalArgumentException("ungueltige Nummer");
	}
	
	

	public String getNr()
	{
		return nr;
	}

	public int getDauer()
	{
		return dauer;
	}

	public void setDauer(int dauer) throws IllegalArgumentException
	{
		if (dauer > 0)
			this.dauer = dauer;
		else
			throw new IllegalArgumentException("ungueltige Dauer");
	}

	public Date getZeit()
	{
		return zeit;
	}

	public void setZeit(Date zeit)
	{
		this.zeit = zeit;
	}



	@Override
	public String toString()
	{
		return nr + "\t" + zeit + "\t" + dauer;
	}
	
	
}
