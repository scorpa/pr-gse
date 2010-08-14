package ui.transport;

import java.util.ArrayList;
import java.util.Calendar;
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
    
    public void ausgeben()
    {
        System.out.println("Container für Kunde:");
        if (kunde != null)
            kunde.ausgeben();
        else
            System.out.println("noch kein Kunde eingetragen");
        System.out.println("Maximales Ladegewicht: " + maximalesLadegewicht);
        if (lieferDatum != null)
        {
            System.out.println("Lieferdatum: " 
                    + lieferDatum.get(Calendar.DAY_OF_MONTH) + "."
                    + (lieferDatum.get(Calendar.MONTH)+1) + "."  // Monat geht von 0 bis 11
                    + lieferDatum.get(Calendar.YEAR));
        }
        else
            System.out.println("kein Lieferdatum");
        if (platten.size() > 0)
        {
            System.out.println("----------------- Ladung -------------------");
            for (Platte p : platten)
                System.out.println(p.getLaenge() + " x " + p.getBreite() + "\tGewicht: " + p.berechneGewicht());
            System.out.println("--------------------------------------------");
        }
        else
            System.out.println("keine Platten aufgeladen");
        
    }
    
    

}
