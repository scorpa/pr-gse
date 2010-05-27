/*
 * Created on 13.01.2009
 *
 */
package einkaufsliste;

public class Artikel
{
    private String bezeichnung;
    private float preis;
    private int anzahl;
    
    
    public Artikel(String bezeichnung)
    {
        this.bezeichnung = bezeichnung;
    }


    public int getAnzahl()
    {
        return anzahl;
    }


    public void setAnzahl(int anzahl)
    {
        if (anzahl > 0)
            this.anzahl = anzahl;
        else
            System.out.println("Anzahl muss > 0 sein");
    }


    public float getPreis()
    {
        return preis;
    }


    public void setPreis(float preis)
    {
        if (preis > 0)
            this.preis = preis;
        else
            System.out.println("Preis muss > 0 sein");
    }


    public String getBezeichnung()
    {
        return bezeichnung;
    }
    
    

}
