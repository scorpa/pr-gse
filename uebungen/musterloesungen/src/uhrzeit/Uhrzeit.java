package uhrzeit;
/**
 * 
 * @author Rudolf Radlbauer
 *
 * Uhrzeit-Klasse mit Zaehler für Stunden, Minuten und Sekunden
 */
public class Uhrzeit
{
    private Zaehler stunden;
    private Zaehler minuten;
    private Zaehler sekunden;
    
    
    public Uhrzeit(int std, int min, int sek)
    {
        stunden = new Zaehler(24);  // 24 Stunden
        minuten = new Zaehler(60);  // 60 Minuten
        sekunden = new Zaehler(60); // 60 Sekunden
        stunden.setWert(std);
        minuten.setWert(min);
        sekunden.setWert(sek);
        // falls irgend ein Wert falsch war, wird Standardzeit gesetzt: 00:00:00
        if (sekunden.getWert() != sek || minuten.getWert() != min || stunden.getWert() != std)
        {
            stunden.setWert(0);
            minuten.setWert(0);
            sekunden.setWert(0);
        }
    }
    
    public int getStunden()
    {
        return stunden.getWert();
    }

    public int getMinuten()
    {
        return minuten.getWert();
    }

    public int getSekunden()
    {
        return sekunden.getWert();
    }
    
    public void setStunden(int std)
    {
        stunden.setWert(std);
    }

    public void setMinuten(int min)
    {
        minuten.setWert(min);
    }

    public void setSekunden(int sek)
    {
        sekunden.setWert(sek);
    }
    
    public void print()
    {
        System.out.println(stunden.wertAlsString() + ":" + minuten.wertAlsString() + ":" + sekunden.wertAlsString());       
    }
    
    public void tickSekunden()
    {
        sekunden.weiter();
        if (sekunden.getWert() == 0)
            tickMinuten();
    }
    
    public void tickMinuten()
    {
        minuten.weiter();
        if (minuten.getWert() == 0)
            tickStunden();
        
    }

    public void tickStunden()
    {
        stunden.weiter();
    }
    
}
