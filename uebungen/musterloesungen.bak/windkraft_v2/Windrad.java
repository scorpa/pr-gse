package windkraft_v2;

public class Windrad
{
    private double kwProKmh;
    private WindkraftAnlage anlage;
    
    
    public Windrad(double kwProKmh)
    {
        if (kwProKmh > 0)
            this.kwProKmh = kwProKmh;
        else
        {
            System.out.println("ungültige Leistung");
            this.kwProKmh = 100;
        }
    }


    public void setAnlage(WindkraftAnlage anlage)
    {
        this.anlage = anlage;
    }
    
    public double berechneLeistung()
    {
        if (anlage != null)
            return anlage.getWindStaerke() * kwProKmh;
        else
            return 0;
    }
    
    
    

}
