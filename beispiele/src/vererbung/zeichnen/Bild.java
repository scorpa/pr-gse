package vererbung.zeichnen;
import java.util.ArrayList;


public class Bild
{
    private ArrayList<Figur> figuren;
    
    public Bild()
    {
        figuren = new ArrayList<Figur>();
    }
    
    public void einfuegen(Figur f)
    {
        figuren.add(f);
    }
    
    public double berechneGesamtFlaeche()
    {
        double summe = 0;
        for (Figur f : figuren)
            summe += f.berechneFlaeche();
        
        return summe;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder(super.toString());
        for (Figur f : figuren)
        {
            str.append("\n");
            str.append(f.toString());
        }
        return str.toString();
    }

    
}
