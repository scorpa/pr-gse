package zeugnis;


import java.util.Random;


/**
 *
 * @author Rudolf Radlbauer
 */
public class Zeugnis
{
    private String name;
    private Fach[] faecher;
    
    public Zeugnis(String name)
    {
        this.name = name;
        faecher = new Fach[]{
            new Fach("M"),
            new Fach("E"),
            new Fach("D"),
            new Fach("GWK"),
            new Fach("BIO"),
            new Fach("BSP")
        };
    }
    
    public void note(String kuerzel, int wert)
    {
        boolean gefunden = false;
        for (Fach f : faecher)
        {
            if (f.getKuerzel().equals(kuerzel))
            {
                f.setNote(wert);
                gefunden = true;
            }
        }
        if (!gefunden)
            System.out.println("Fach " + kuerzel + " gibt es nicht!");
    }
    
    public void zufall()
    {
        Random rand = new Random();
        for (Fach f : faecher)
            f.setNote(rand.nextInt(5)+1);          
    }
    
    public void ausgeben()
    {
        System.out.println("======== " + name + " =========");
        for (Fach f : faecher)
            f.ausgeben();
    }
    
    public float notenSchnitt()
    {
        float summe = 0;
        for (Fach f : faecher)
            summe += f.getNote();
        return summe / faecher.length;
    }
    
    public Fach bestesFach()
    {
        Fach bestes = faecher[0];
        for (Fach f : faecher)
        {
            if (f.getNote() < bestes.getNote())
                bestes = f;
        }
        return bestes;
    }
    
    public boolean bestanden()
    {
        boolean b = true;
        for (Fach f : faecher)
        {
            if (f.getNote() == 5)
                b = false;
        }
        return b;
    }
}
