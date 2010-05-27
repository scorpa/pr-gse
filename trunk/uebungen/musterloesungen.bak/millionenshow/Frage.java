package millionenshow;
/**
 * 
 * @author (Rudolf Radlbauer) 
 */
import java.util.ArrayList;

public class Frage
{
    private String text;
    private ArrayList<String> antworten;
    private int richtig;
    
    public Frage(String text)
    {
        this.text = text;
        antworten = new ArrayList<String>();
    }
    
    public void addAntwort(String antwort)
    {
        antworten.add(antwort);
    }
    
    public void setRichtig(int richtig)
    {
        if (richtig >= 1 && 
            richtig <= antworten.size())
            this.richtig = richtig-1;
        else
            System.out.println("ungültiger Index");
    }
    
    public int getRichtig()
    {
        return richtig + 1;
    }
    
    public String richtigeAntwort()
    {
        return antworten.get(richtig);
    }
    
    public int getSize()
    {
        return antworten.size();
    }
    
    public void ausgeben()
    {
        System.out.println(text);
        for(int i = 0; i < antworten.size(); i++)
        {
            System.out.println("\t" + (i+1) + " " +
                antworten.get(i));
        }
    }
    
}
