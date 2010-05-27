package windkraft_v2;

import java.util.ArrayList;

public class WindkraftAnlage
{
    private ArrayList<Windrad> windraeder;
    private int windStaerke;
    
    public WindkraftAnlage()
    {
        windraeder = new ArrayList<Windrad>();
    }
    
    public void aufnehmen(Windrad w)
    {
        windraeder.add(w);
        w.setAnlage(this);
    }
    
    public void entfernen(Windrad w)
    {
        windraeder.remove(w);
    }
    
    public double getGesamtLeistung()
    {
        double leistung = 0;
        for (Windrad w : windraeder)
            leistung += w.berechneLeistung();
        return leistung;
    }

    public int getWindStaerke()
    {
        return windStaerke;
    }

    public void setWindStaerke(int windStaerke)
    {
        if (windStaerke >= 0)
            this.windStaerke = windStaerke;
    }
    
    
    
    

}
