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
public class WindkraftAnlage
{
    private Windrad windrad1;
    private Windrad windrad2;
    private Windrad windrad3;

    public WindkraftAnlage()
    {
        // nichts zu tun
    }
    
    public void setWindrad(int nr, Windrad w)
    {
        if (nr == 1)
            windrad1 = w;
        else if (nr == 2)
            windrad2 = w;
        else if (nr == 3)
            windrad3 = w;
        else
            System.out.println("ungültige Windrad-Nummer");
    }
    
    /*
     * setzt die Windstärke für alle existierenden Windräder
     */
    public void setWindstaerke(int kmh)
    {
        if (kmh >= 0)
        {
            if (windrad1 != null)
                windrad1.setWindStaerke(kmh);
            if (windrad2 != null)
                windrad2.setWindStaerke(kmh);
            if (windrad3 != null)
                windrad3.setWindStaerke(kmh);
        }
    }
    
    /*
     * addiert die Leistung aller existierenden Windräder
     */
    public double getGesamtLeistung()
    {
        double leistung = 0;
        if (windrad1 != null)
            leistung += windrad1.berechneLeistung();
        if (windrad2 != null)
            leistung += windrad2.berechneLeistung();
        if (windrad3 != null)
            leistung += windrad3.berechneLeistung();
        
        return leistung;
    }
    
}
