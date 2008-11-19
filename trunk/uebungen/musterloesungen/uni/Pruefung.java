package uni;

/**
 * 
 * @author Rudolf Radlbauer
 *
 */

public class Pruefung
{
    private String fach;
    private int note;
    
    
    public Pruefung(String fach)
    {
        // im Fach soll wirklich was drinstehen
        if (fach != null && fach.length() > 0)
            this.fach = fach;
        else
        {
            System.out.println("ungültiges Fach");
            this.fach = "unbekannt";
        }
    }
    
    public String getFach()
    {
        return fach;
    }

    public int getNote()
    {
        return note;
    }

    // Note liegt zwischen 1 und 5
    public void setNote(int note)
    {
        if (note >= 1 && note <= 5)
            this.note = note;
        else
            System.out.println("ungültige Note");
    }
    
    
}
