/*
 * Created on 08.04.2009
 *
 */
package fahrtenbuch.fachlogik;

/**
 * Projekt Fahrtenbuch
 * 
 * Datenhaltungsklasse.
 * Die Klasse Ausgabe repräsentiert eine andere Ausgabe als einen Tankstop.
 * Als Erweiterung zur Klasse Kostenpunkt kommt die Bezeichnung dazu,
 * welche nicht leer sein darf.
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Ausgabe extends Kostenpunkt
{
    /**
     * serialVersionUID für Serialisierung
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

    /**
     * Die Methode toString() auf für die Darstellung der Liste in der Oberfläche hingetrimmt.
     */
    @Override
    public String toString()
    {
        return super.toString() + "  " + bezeichnung;
    }
    
    
    
}
