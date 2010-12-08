package warenkorb;

/**
 * Einfache Datenhaltungsklasse mit get- und set-Methoden
 * @author Rudolf Radlbauer
 *
 */
public class Artikel
{
	private int id;
	private String bezeichnung;
	private float preis;
	private int anzahl;
	
	public Artikel()
	{
		id = 0;
		bezeichnung = "unbekannt";
		preis = 0;
		anzahl = 1;
	}
	
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id) throws WarenkorbException
	{
		if (id >= 0)
			this.id = id;
		else
			throw new WarenkorbException("negative Artikel-ID nicht erlaubt");
	}
	
	public String getBezeichnung()
	{
		return bezeichnung;
	}
	
	public void setBezeichnung(String bezeichnung) throws WarenkorbException
	{
		if (bezeichnung != null && bezeichnung.trim().length() > 0)
			this.bezeichnung = bezeichnung;
		else
			throw new WarenkorbException("leere Artikel-Bezeichnung nicht erlaubt");
	}
	
	public float getPreis()
	{
		return preis;
	}
	
	public void setPreis(float preis) throws WarenkorbException
	{
		if (preis > 0)
			this.preis = preis;
		else
			throw new WarenkorbException("negativer Preis nicht erlaubt");
	}
	
	public int getAnzahl()
	{
		return anzahl;
	}
	
	
	public void setAnzahl(int anzahl) throws WarenkorbException
	{
		if (anzahl > 0)
			this.anzahl = anzahl;
		else
			throw new WarenkorbException("negative Anzahl nicht erlaubt");
	}



	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder(super.toString());
		str.append("\tid=").append(id);
		str.append("\tbezeichnung=").append(bezeichnung);
		str.append("\tpreis=").append(preis);
		str.append("\tanzahl=").append(anzahl);
		
		return str.toString();
	}
	
	

}
