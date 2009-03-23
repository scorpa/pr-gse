package collections.transport;

/**
 * Transport-Beispiel V2
 * erweitert um Sortier-Methoden
 * @author Rudolf Radlbauer
 *
 */
public class Platte implements Comparable<Platte>
{
    private double laenge;  // Meter
    private double breite;
    
    public Platte(double laenge, double breite)
    {
        if (laenge > 0)
            this.laenge = laenge;
        else
        {
            System.out.println("ungültige Länge");
            this.laenge = 1;
        }
        if (breite > 0)
            this.breite = breite;
        else
        {
            System.out.println("ungültige Breite");
            this.breite = 1;
        }
    }

    public double getBreite()
    {
        return breite;
    }

    public double getLaenge()
    {
        return laenge;
    }
    
    public double berechneGewicht()
    {
        return laenge * breite * 1.5;
    }

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder(super.toString());
		str.append(" Länge=").append(laenge);
		str.append(" Breite=").append(breite);
		str.append(" Gewicht=").append(berechneGewicht());
		return str.toString();
	}

	/**
	 * vergleicht Gewicht
	 */
	@Override
	public int compareTo(Platte p2)
	{
		return (int) (this.berechneGewicht() - p2.berechneGewicht());
	}
    
    
    
}
