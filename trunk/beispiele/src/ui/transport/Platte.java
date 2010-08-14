package ui.transport;

/**
 * Transport-Beispiel V2
 * @author Rudolf Radlbauer
 *
 */
public class Platte
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
    
}
