/*
 * Created on 08.04.2009
 *
 */
package fahrtenbuch.fachlogik;

/**
 * Projekt Fahrtenbuch
 * 
 * Datenhaltungsklasse.
 * Die Klasse Ausgabe repr�sentiert eine andere Ausgabe als einen Tankstop.
 * Als Erweiterung zur Klasse Kostenpunkt kommt die Bezeichnung dazu,
 * welche nicht leer sein darf.
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Ausgabe extends Kostenpunkt
{
    /**
     * serialVersionUID f�r Serialisierung
     */
    private static final long serialVersionUID = -8764486778160354304L;
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

    /**
     * Die Methode toString() auf f�r die Darstellung der Liste in der Oberfl�che hingetrimmt.
     */
    @Override
    public String toString()
    {
        return super.toString() + "  " + bezeichnung;
    }
    
    
    
}
