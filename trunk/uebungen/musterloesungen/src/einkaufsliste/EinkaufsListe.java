/*
 * Created on 13.01.2009
 *
 */
package einkaufsliste;

import java.util.ArrayList;

public class EinkaufsListe
{
    private ArrayList<Artikel> liste;
    
    public EinkaufsListe()
    {
        liste = new ArrayList<Artikel>();
    }
    
    public void dazu(Artikel a)
    {
        liste.add(a);
    }
    
    public void weg(int position)
    {
        if (position > 0 && position <= liste.size())
            liste.remove(position-1);
        else
            System.out.println("ungültige Position");
    }
    
    public Artikel getArtikel(int position)
    {
        if (position > 0 && position <= liste.size())
            return liste.get(position-1);
        else
            return null;
    }
    
    public void liste()
    {
        System.out.println("Position\tBezeichnung\tPreis\tAnzahl");
        System.out.println("---------------------------------------------------------------");
        float summe = 0;
        for (int i = 0; i < liste.size(); i++)
        {
            Artikel a = liste.get(i);
            System.out.println((i+1) 
                    + "\t" + a.getBezeichnung() 
                    + "\t" + a.getPreis() 
                    + "\t" + a.getAnzahl());
            summe += a.getPreis() * a.getAnzahl();
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Gesamtpreis:\t" + summe);
        
    }

}
