package collections.transport;

import java.util.ArrayList;
import java.util.Collections;
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
    
    public void sortiereNachGewicht()
    {
    	// hier können wir die "Natürliche Ordnung" verwenden
    	// siehe Klasse Platte
    	Collections.sort(platten);
    }
    
    public void sortiereNachLaenge()
    {
    	// hier benötigen wir einen Comparator
    	Collections.sort(platten, new PlattenComparator('l'));
    }

    public void sortiereNachBreite()
    {
    	// hier benötigen wir einen Comparator
    	Collections.sort(platten, new PlattenComparator('b'));
    }


	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder(super.toString());
		str.append(" Länge=").append(laenge);
		str.append(" Breite=").append(breite);
		str.append(" Max.Ladegewicht=").append(maximalesLadegewicht);
		str.append("\n").append(kunde);
		str.append("\n=============== Platten ==============");
		for (Platte p : platten)
			str.append("\n").append(p);
		return str.toString();
	}
    
    
    
    

}
