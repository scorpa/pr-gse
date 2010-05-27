/*
 * Created on 10.03.2009
 *
 */
package rechenquiz;

import java.util.ArrayList;

public class RechenQuiz
{
    private ArrayList<Rechnung> rechnungen;
    private int next;
    
    public RechenQuiz()
    {
        rechnungen = new ArrayList<Rechnung>();
        next = 0;
    }
    
    public void add(Rechnung r)
    {
        rechnungen.add(r);
    }
    
    public Rechnung naechste()
    {
        Rechnung r = null;
        if (next < rechnungen.size())
        {
            r = rechnungen.get(next);
            next++;
        }
        return r;
    }
    
    public int gesamtPunkte()
    {
        int summe = 0;
        for (Rechnung r : rechnungen)
            summe += r.berechnePunkte();
        return summe;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Rechnung\tErgebnis\tTipp\tPunkte\n");
        sb.append("===================================================\n");
        for (Rechnung r : rechnungen)
        {
            sb.append(r.toString());
            sb.append("\t").append(r.getErgebnis());
            sb.append("\t\t").append(r.getTipp());
            sb.append("\t").append(r.berechnePunkte());
            sb.append("\n");
        }
        sb.append("===================================================");
        
        
        return sb.toString();
    }
    
    

}
