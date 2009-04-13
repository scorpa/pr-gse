/*
 * Created on 08.04.2009
 *
 */
package fahrtenbuch.fachlogik;

/**
 * Projekt Fahrtenbuch
 * 
 * Datenhaltungsklasse.
 * Speichert die relevanten Daten für einen Tankstop.
 * Erweitert die Klasse Kostenpunkt um das Attribut liter.
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Tankstop extends Kostenpunkt
{
    /**
     * serialVersionUID für Serialisierung
     */
    private static final long serialVersionUID = 4112859269560145144L;
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
