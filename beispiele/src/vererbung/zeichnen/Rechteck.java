package vererbung.zeichnen;

public class Rechteck implements Figur
{
    private double laenge;
    private double breite;

    public Rechteck(double laenge, double breite)
    {
        super();
        this.laenge = laenge;
        this.breite = breite;
    }

    @Override
    public String toString()
    {
        return super.toString()
            + "\tLänge: " + laenge
            + "\tBreite: " + breite;
    }


    public double berechneFlaeche()
    {
        return laenge * breite;
    }

}
