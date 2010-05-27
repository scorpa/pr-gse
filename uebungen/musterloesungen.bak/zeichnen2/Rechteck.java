/*
 * Created on 28.10.2008
 *
 */
package zeichnen2;

public class Rechteck
{
    private Punkt rechtsUnten;
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
        rechtsUnten = new Punkt(100,100);
    }

    public void setRechtsUnten(Punkt rechtsUnten)
    {
        if (rechtsUnten != null)
            this.rechtsUnten = rechtsUnten;
    }


    
    public int berechneFlaeche()
    {
        return laenge * breite;
    }
    
    public void verschieben(int horizontal, int vertikal)
    {
        rechtsUnten.horizontalVerschieben(horizontal);
        rechtsUnten.vertikalVerschieben(vertikal);
    }
    
    
    public boolean enthaelt(Punkt p)
    {
        return (rechtsUnten.getX() > p.getX() 
                && rechtsUnten.getY() > p.getY()
                && p.getX() > rechtsUnten.getX() - laenge
                && p.getY() > rechtsUnten.getY() - breite);
        
    }
    
    
    

}
