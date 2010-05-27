/*
 * Created on 19.10.2008
 *
 */
package windkraft;


/**
 * 
 * @author Rudolf Radlbauer
 * Aufgabe 09
 */
public class Windrad
{
    private int windStaerke;
    private double kwProKmh;

    
    public Windrad(double kwProKmh)
    {
        if (kwProKmh > 0)
        {
            this.kwProKmh = kwProKmh;
        }
        else
        {
            System.out.println("ung�ltiger Wert f�r Leistung");
            this.kwProKmh = 100;
        }
    }

    public void setWindStaerke(int kmh)
    {
        if (kmh >= 0)
        {
            this.windStaerke = kmh;
        }
        else
            System.out.println("ung�ltige Windst�rke");
    }
    
    public double berechneLeistung()
    {
        return this.windStaerke * this.kwProKmh;
    }

    
}
