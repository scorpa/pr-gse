package uhrzeit;
/*
 * Created on 07.10.2008
 *
 */

/**
 * @author Rudolf Radlbauer
 * 
 * Die Klasse Zaehler repr�sentiert einen elektronischen Z�hler repr�sentiert, wie er
 * z.B. in �mtern verwendet wird:
 * Nach der Instanziierung hat der Z�hler den Wert 0.
 * Bei jedem Aufruf der Methode weiter() wird er um 1 erh�ht; wenn er allerdings dabei eine
 * Obergrenze �berschreiten w�rde (z.B. 25), dann wird er auf 0 zur�ckgesetzt.
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
            System.out.println("ung�ltiges Limit - nehme Standardwert 10");
            limit = 10;
        }
    }
    
    public void setWert(int w)
    {
        if (w >= 0 && w < limit)
            wert = w;
        else
            System.out.println("ung�ltiger Wert");
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
     * wirkt sich so aus, als ob n Mal weiter() aufgerufen w�rde
     */
    public void weiter(int n)
    {
        wert = (wert + n) % limit;
    }
    
    
    /*
     * diese Methode wurde hinzugef�gt, um das Uhrzeitbeispiel einfacher zu l�sen.
     */
    public String wertAlsString()
    {
        if (wert < 10)
            return "0" + wert;
        else
            return "" + wert;
    }
    
}
