package termine;

import java.util.Date;

/**
 * Datenhaltungsklasse für Termine, 
 * welche in einem Terminplaner verwaltet werden. 
 * @author Rudolf Radlbauer
 *
 */
public class Termin
{
	private Date beginn;
	private Date ende;
	private String bezeichnung;
	
	
	public Termin(String bezeichnung)
	{
		if (bezeichnung != null && bezeichnung.trim().length() > 0)
			this.bezeichnung = bezeichnung;
		else
			bezeichnung = "unbekannt";
	}


	public Date getBeginn()
	{
		return beginn;
	}


	public void setBeginn(Date beginn)
	{
		this.beginn = beginn;
	}


	public Date getEnde()
	{
		return ende;
	}


	public void setEnde(Date ende)
	{
		this.ende = ende;
	}


	public String getBezeichnung()
	{
		return bezeichnung;
	}
	
	
	
	

}
