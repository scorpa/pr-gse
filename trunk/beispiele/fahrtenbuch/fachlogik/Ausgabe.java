/*
 * Created on 08.04.2009
 *
 */
package fahrtenbuch.fachlogik;


public class Ausgabe extends Kostenpunkt
{
    private String bezeichnung;
    
    /**
     * Setzt Standardwerte
     *
     */
    public Ausgabe()
    {
        bezeichnung = "";
    }

    /**
     * 
     * @return Bezeichnung f�r die Ausgabe
     */
    public String getBezeichnung()
    {
        return bezeichnung;
    }

    /**
     * 
     * @param bezeichnung Bezeichnung f�r die Ausgabe
     * @throws FahrtenbuchException wenn null oder Leerstring �bergeben wird
     */
    public void setBezeichnung(String bezeichnung) throws FahrtenbuchException
    {
        if (bezeichnung != null && bezeichnung.trim().length() > 0)
            this.bezeichnung = bezeichnung;
        else
            throw new FahrtenbuchException("Bezeichnung f�r Ausgabe darf nicht leer sein");
    }

    @Override
    public String toString()
    {
        return super.toString() + "  " + bezeichnung;
    }
    
    
    
}
