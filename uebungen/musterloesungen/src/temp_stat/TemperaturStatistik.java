package temp_stat;


public class TemperaturStatistik
{
    private double[] temperatur;
    private int anzahl;
    
    public TemperaturStatistik(int tage)
    {
        if (tage > 0)
            temperatur = new double[tage];
        else
        {
            System.out.println("ungültige Anzahl von Tagen - nehme 365");
            temperatur = new double[365];
        }
        anzahl = 0;
    }
    
    public void aufnehmen(double temp)
    {
        if (anzahl < temperatur.length)
        {
            temperatur[anzahl] = temp;
            anzahl++;
        }
        else
            System.out.println("bereits alle Werte eingegeben");
    }
    
    public int getAnzahl()
    {
        return anzahl;
    }
    
    public double getTemperatur(int tag)
    {
        if (tag >= 0 && tag < anzahl)
            return temperatur[tag];
        else
        {
            System.out.println("ungültiger Tag");
            return 0;
        }
    }
    
    public double durchschnitt()
    {
        if (anzahl > 0)
        {
            double summe = 0;
            for (int i = 0; i < anzahl; i++)
                summe += temperatur[i];
            return summe / anzahl;
        }
        else
        {
            System.out.println("keine Werte vorhanden");
            return 0;
        }
    }
    
    public double max()
    {
        if (anzahl > 0)
        {
            double mx = temperatur[0];
            for (int i = 1; i < anzahl; i++)
            {
                if (temperatur[i] > mx)
                    mx = temperatur[i];
            }
            return mx;
        }
        else
        {
            System.out.println("keine Werte vorhanden");
            return 0;
        }
    }
    
    public int maxTag()
    {
        if (anzahl > 0)
        {
            double mx = temperatur[0];
            int tag = 0;
            for (int i = 1; i < anzahl; i++)
            {
                if (temperatur[i] > mx)
                {
                    mx = temperatur[i];
                    tag = i;
                }
            }
            return tag;
        }
        else
        {
            System.out.println("keine Werte vorhanden");
            return 0;
        }        
    }
    
    public double maxDiff()
    {
        if (anzahl > 1)
        {
            double diff = temperatur[1] - temperatur[0];
            if (diff < 0)
                diff = -diff;
                
            for (int i = 2; i < anzahl; i++)
            {
                double df = temperatur[i] - temperatur[i-1];
                if (df < 0)
                    df = -df;
                if (df > diff)
                    diff = df;
            }
            return diff;
        }
        else
        {
            System.out.println("nicht mehr als 1 Wert vorhanden");
            return 0;
        }
    }
    
    
    public void uebernehmen(TemperaturStatistik ts)
    {
        if (anzahl + ts.getAnzahl() <= temperatur.length)
        {
            for (int i = 0; i < ts.getAnzahl(); i++)
                aufnehmen(ts.getTemperatur(i));
        }
        else
            System.out.println("zu viele Werte");
    }
    
    
    
    public void ausgeben()
    {
        for (int i = 0; i < anzahl; i++)
        {
            System.out.printf("%10.1f", temperatur[i]);
            System.out.println();
        }
    }
    
    

}
