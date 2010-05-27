package fertigteilhaus;

/**
 * 
 * Fertigteilhaus
 * @author Rudolf Radlbauer
 * @version 4.11.2009
 *
 */
public class Haus
{
	// die Wände des Hauses
	private Wand vorne;
	private Wand hinten;
	private Wand links;
	private Wand rechts;
	
	public Haus()
	{
		// 4 Standardwände, vorne wird eine Tür eingebaut
		vorne = new Wand();
		hinten = new Wand();
		links = new Wand();
		rechts = new Wand();
		vorne.setTueren(1);
	}

	// get- und set-Methoden sehen genauso aus wie bei Attributen mit Basisdatentypen
	public Wand getVorne()
	{
		return vorne;
	}

	public void setVorne(Wand vorne)
	{
		this.vorne = vorne;
	}

	public Wand getHinten()
	{
		return hinten;
	}

	public void setHinten(Wand hinten)
	{
		this.hinten = hinten;
	}

	public Wand getLinks()
	{
		return links;
	}

	public void setLinks(Wand links)
	{
		this.links = links;
	}

	public Wand getRechts()
	{
		return rechts;
	}

	public void setRechts(Wand rechts)
	{
		this.rechts = rechts;
	}
	
	public boolean konstruktionOK()
	{
		return (hinten.getBreite() == vorne.getBreite()) 
			&& (links.getBreite() == rechts.getBreite());
	}
	
	public int berechneGrundFlaeche()
	{
		if (konstruktionOK())
			return vorne.getBreite() * links.getBreite() / 10000; // Nachkommastellen automatisch abgeschnitten
		else
			return -1;
	}
	
	public int berechnePreis()
	{
		if (konstruktionOK())
		{
			return vorne.berechnePreis() 
				+ hinten.berechnePreis() 
				+ links.berechnePreis() 
				+ rechts.berechnePreis()
				+ berechneGrundFlaeche() * 500;
		}
		else
			return -1;
	}

}
