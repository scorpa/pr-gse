/*
 * Created on 08.04.2009
 *
 */
package fahrtenbuch.fachlogik;

public class Tankstop extends Kostenpunkt
{
    private float liter;
    
    
    public Tankstop()
    {
        liter = 0;
        setFixkosten(false);
    }

    /**
     * 
     * @return getankte Menge
     */
    public float getLiter()
    {
        return liter;
    }

    /**
     * 
     * @param liter getankte Menge
     * @throws FahrtenbuchException falls liter nicht positiv ist
     */
    public void setLiter(float liter) throws FahrtenbuchException
    {
        if (liter > 0)
            this.liter = liter;
        else
            throw new FahrtenbuchException("getankte Menge muss größer als 0 sein");
    }

    @Override
    public String toString()
    {
        return super.toString() + "   " + liter + " Liter";
    }

    
    
}
