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
     * @return Bezeichnung für die Ausgabe
     */
    public String getBezeichnung()
    {
        return bezeichnung;
    }

    /**
     * 
     * @param bezeichnung Bezeichnung für die Ausgabe
     * @throws FahrtenbuchException wenn null oder Leerstring übergeben wird
     */
    public void setBezeichnung(String bezeichnung) throws FahrtenbuchException
    {
        if (bezeichnung != null && bezeichnung.trim().length() > 0)
            this.bezeichnung = bezeichnung;
        else
            throw new FahrtenbuchException("Bezeichnung für Ausgabe darf nicht leer sein");
    }

    @Override
    public String toString()
    {
        return super.toString() + "  " + bezeichnung;
    }
    
    
    
}
