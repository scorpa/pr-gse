package zeugnis;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Fach
{
    private String kuerzel;
    private int note;
    
    public Fach(String kuerzel)
    {
        this.kuerzel = kuerzel;
    }

    public String getKuerzel()
    {
        return kuerzel;
    }

    public int getNote()
    {
        return note;
    }

    public void setNote(int note)
    {
        if (note >= 1 && note <= 5)
            this.note = note;
        else
            System.out.println("ungültige Note");
    }
    
    
    public void ausgeben()
    {
        System.out.println(kuerzel + "\t" + note);
    }
}
