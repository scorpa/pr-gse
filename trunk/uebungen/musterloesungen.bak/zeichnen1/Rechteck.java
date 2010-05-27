/*
 * Created on 28.10.2008
 *
 */
package zeichnen1;

public class Rechteck
{
    private Punkt linksOben;
    private int laenge;
    private int breite;
    
    public Rechteck(int laenge, int breite)
    {
        if (laenge > 0)
            this.laenge = laenge;
        else
        {
            System.out.println("ungültige Länge");
            laenge = 100; 
        }
             
        if (breite > 0)
            this.breite = breite;
        else
        {
            System.out.println("ungültige Breite");
            breite = 100;
        }
        linksOben = new Punkt(0,0);
    }

    public void setLinksOben(Punkt linksOben)
    {
        if (linksOben != null)
            this.linksOben = linksOben;
    }
    
    public int berechneUmfang()
    {
        return 2 * (laenge + breite);
    }
    
    public void verschiebeHorizontal(int pix)
    {
        linksOben.verschieben(pix, 0);
    }
    
    public void verschiebeVertikal(int pix)
    {
        linksOben.verschieben(0, pix);
    }
    
    public boolean enthaelt(Punkt p)
    {
        return (linksOben.getX() < p.getX() 
                && linksOben.getY() < p.getY()
                && p.getX() < linksOben.getX() + laenge
                && p.getY() < linksOben.getY() + breite);
        
    }
    
    
    

}
