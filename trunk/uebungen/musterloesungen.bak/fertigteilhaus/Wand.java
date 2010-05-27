package fertigteilhaus;

/**
 * Wand für ein Fertigteilhaus
 * @author Rudolf Radlbauer
 * @version 4.11.2009
 *
 */
public class Wand
{
	private int breite;
	private int hoehe;
	private int fenster;
	private int tueren;
	
	// Standardkonstruktor
	public Wand()
	{
		breite = 800;
		hoehe = 600;
		fenster = 4;
		tueren = 0;
	}
	
	// weiterer Konstruktor
	public Wand(int b, int h)
	{
		// Aufruf an den anderen Konstruktor.
		// Dieser setzt die Standardwerte, 
		// rufe dann set-Methoden auf
		// falls diese Fehler feststellen, bleiben die Standardwerte.
		this();
		setBreite(b);
		setHoehe(h);
	}

	public int getBreite()
	{
		return breite;
	}

	public void setBreite(int b)
	{
		if (b >= 200 && b <= 1500)
			breite = b;
		else
			System.out.println("ungültige Breite: " + b);
	}

	public int getHoehe()
	{
		return hoehe;
	}

	public void setHoehe(int h)
	{
		if (h >= 300 && h <= 800)
			hoehe = h;
		else
			System.out.println("ungültige Höhe: " + h);
	}

	public int getFenster()
	{
		return fenster;
	}

	public void setFenster(int f)
	{
		if (f + tueren <= 8)
			fenster = f;
		else
			System.out.println("zu viele Fenster und Türen");
	}

	public int getTueren()
	{
		return tueren;
	}

	public void setTueren(int t)
	{
		if (t + fenster <= 8)
			tueren = t;
		else
			System.out.println("zu viele Fenster und Türen");
	}
	
	public int berechneFlaeche()
	{
		return breite * hoehe / 10000;  // hier werden automatisch Nachkommastellen abgeschnitten.
	}
	
	public int berechnePreis()
	{
		return berechneFlaeche() * 500 + fenster * 3000 + tueren * 5000;
	}

}
