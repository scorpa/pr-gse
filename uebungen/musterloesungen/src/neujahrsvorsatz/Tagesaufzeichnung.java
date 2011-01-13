package neujahrsvorsatz;

public class Tagesaufzeichnung
{
    private int tag;
    private int monat;
    private double kalorienanzahl;
    private double gelaufeneKilometer;

    public Tagesaufzeichnung(int tag, int monat, double kalorienanzahl, double gelaufeneKilometer)
    {
        this.tag = tag;
        this.monat = monat;
        this.kalorienanzahl = kalorienanzahl;
        this.gelaufeneKilometer = gelaufeneKilometer;
    }
    
    public int getTag()
    {
        return tag;
    }

    public int getMonat()
    {
        return monat;
    }

    public double getKalorienanzahl()
    {
        return kalorienanzahl;
    }
    
    public double getGelaufeneKilometer()
    {
        return gelaufeneKilometer;
    }
}
