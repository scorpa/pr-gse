package uhrzeit;
/*
 * Created on 07.10.2008
 *
 */

/**
 * @author Rudolf Radlbauer
 * 
 * Die Klasse Zaehler repräsentiert einen elektronischen Zähler repräsentiert, wie er
 * z.B. in Ämtern verwendet wird:
 * Nach der Instanziierung hat der Zähler den Wert 0.
 * Bei jedem Aufruf der Methode weiter() wird er um 1 erhöht; wenn er allerdings dabei eine
 * Obergrenze überschreiten würde (z.B. 25), dann wird er auf 0 zurückgesetzt.
 * 
 */
public class Zaehler
{
    private int wert;
    private int limit;
    
    public Zaehler(int lim)
    {
        if (lim > 0)
            limit = lim;
        else
        {
            System.out.println("ungültiges Limit - nehme Standardwert 10");
            limit = 10;
        }
    }
    
    public void setWert(int w)
    {
        if (w >= 0 && w < limit)
            wert = w;
        else
            System.out.println("ungültiger Wert");
    }
    
    public int getWert()
    {
        return wert;
    }
    
    
    public void weiter()
    {
        // wenn limit erreicht ist, ergibt die Restdivision 0
        wert = (wert + 1) % limit;
    }
    
    /**
     * wirkt sich so aus, als ob n Mal weiter() aufgerufen würde
     */
    public void weiter(int n)
    {
        wert = (wert + n) % limit;
    }
    
    
    /*
     * diese Methode wurde hinzugefügt, um das Uhrzeitbeispiel einfacher zu lösen.
     */
    public String wertAlsString()
    {
        if (wert < 10)
            return "0" + wert;
        else
            return "" + wert;
    }
    
}
