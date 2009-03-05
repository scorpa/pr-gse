package vererbung.zeichnen;

public class Kreis implements Figur
{
    private double radius;
    
    

    public Kreis(double radius)
    {
        super();
        this.radius = radius;
    }



    @Override
    public String toString()
    {
        return super.toString()
            + "\tRadius: " + radius;
    }




    public double berechneFlaeche()
    {
        return radius * radius * Math.PI;
    }

}
