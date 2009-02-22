/*
 * Created on 22.02.2009
 *
 */
package lohnverrechnung;

import java.util.ArrayList;

public class LohnVerrechnung
{
    private ArrayList<Mitarbeiter> liste;
    
    public LohnVerrechnung()
    {
        liste = new ArrayList<Mitarbeiter>();
    }
    
    public void einstellen(Mitarbeiter m)
    {
        if (m != null)
            liste.add(m);
    }
    
    public Mitarbeiter suchen(int nr)
    {
        for (Mitarbeiter m : liste)
        {
            if (m.getNr() == nr)
                return m;
        }
        return null;
    }
    
    public void liste()
    {
        for (Mitarbeiter m : liste)
            System.out.println(m.getNr() + "\t" + m.getName());
    }
    
    public void gehaltsTabelle()
    {
        for (Mitarbeiter m : liste)
            System.out.println(m.getNr() + "\t" + m.getName() + "\t" + m.berechneLohn());
        
    }
    
    public double lohnkosten()
    {
        double kosten = 0;
        for (Mitarbeiter m : liste)
            kosten += m.berechneLohn();
        return kosten;
    }

}
