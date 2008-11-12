package millionenshow;
/**
 * 
 * @author (Rudolf Radlbauer) 
 */

import java.util.ArrayList;
import java.util.Random;


public class Quiz
{
    private ArrayList<Frage> fragen;
    private Random zufall;
    
    public Quiz()
    {
        fragen = new ArrayList<Frage>();
        zufall = new Random();
    }
    
    public void add(Frage f)
    {
        fragen.add(f);
    }
    
    public Frage zufallsFrage()
    {
        int index = zufall.nextInt(fragen.size());
        return fragen.get(index);
    }
    
    
    public void interaktiv()
    {
        int weiter = 1;
        
        while (weiter > 0)
        {
            System.out.println("========================================================");
            Frage f = zufallsFrage();
            f.ausgeben();
            int antwort = Input.readInt("Ihre Antwort (1 bis " + f.getSize() + "):");
            if (antwort == f.getRichtig())
                System.out.println("Ihre Antwort ist richtig!");
            else
            {
                System.out.println("Ihre Antwort ist leider falsch. Die richtige Antwort lautet:");
                System.out.println(f.getRichtig() + " " + f.richtigeAntwort());
            }
            weiter = Input.readInt("Weitermachen (1=ja, 0=nein)?");
            
        }
        
        System.out.println("Danke fürs Mitmachen");
        
        
    }
    
}
