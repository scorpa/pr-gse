package transport;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Container
{
    private ArrayList<Platte> platten;
    private double maximalesLadegewicht; // kg
    private double laenge; // Meter
    private double breite; 
    private Kunde kunde;
    private GregorianCalendar lieferDatum;
    
    
    public Container(double laenge, double breite)
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
        
        platten = new ArrayList<Platte>();
    }
    
    
    public boolean aufladen(Platte platte)
    {
        double gewicht = 0;
        for (Platte p : platten)
            gewicht += p.berechneGewicht();
        if (gewicht + platte.berechneGewicht() > maximalesLadegewicht)
            return false;
        if (platte.getBreite() > this.breite || platte.getLaenge() > this.laenge)
            return false;
        return platten.add(platte);
    }


    public Kunde getKunde()
    {
        return kunde;
    }


    public void setKunde(Kunde kunde)
    {
        if (kunde != null)
            this.kunde = kunde;
    }


    public GregorianCalendar getLieferDatum()
    {
        return lieferDatum;
    }


    public void setLieferDatum(GregorianCalendar lieferDatum)
    {
        if (lieferDatum != null)
            this.lieferDatum = lieferDatum;
    }


    public double getMaximalesLadegewicht()
    {
        return maximalesLadegewicht;
    }


    public void setMaximalesLadegewicht(double maximalesLadegewicht)
    {
        if (maximalesLadegewicht > 0)
            this.maximalesLadegewicht = maximalesLadegewicht;
    }
    
    
    
    

}
