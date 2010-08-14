/*
 * Created on 24.11.2008
 *
 */
package arrays.bibliothek;

/**
 * Buch-Klasse für Buchverwaltungs-Beispiel.
 * Eine einfache Datenhaltungsklasse mit gettern und settern
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Buch
{
    private String autor;
    private String titel;
    private int seiten;
    
    public Buch()
    {
        setTitel("unbekannt");
        setAutor("unbekannt");
        setSeiten(0);
    }
    
    public String getAutor()
    {
        return autor;
    }
    
    public void setAutor(String autor)
    {
        if (autor != null && autor.length() > 0)
            this.autor = autor;
    }
    
    public int getSeiten()
    {
        return seiten;
    }
    
    public void setSeiten(int seiten)
    {
        if (seiten >= 0)
            this.seiten = seiten;
    }
    
    public String getTitel()
    {
        return titel;
    }
    
    public void setTitel(String titel)
    {
        if (titel != null && titel.length() > 0)
            this.titel = titel;
    }
    
    

}
