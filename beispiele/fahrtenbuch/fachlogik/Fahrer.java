package fahrtenbuch.fachlogik;

import java.io.Serializable;

/**
 * Projekt Fahrtenbuch
 * 
 * Datenhaltungsklasse.
 * Speichert im Wesentlichen den Namen der/des Fahrers/in ab.
 * 
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Fahrer implements Serializable
{
    /**
     * serialVersionUID für Serialisierung
     */
    private static final long serialVersionUID = -5768946559192668497L;
    private String name;

	/**
	 * 
	 * @param name Name des Fahrers
	 * @throws FahrtenbuchException wenn name null oder Leerstring ist
	 */
	public Fahrer(String name) throws FahrtenbuchException
	{
		if (name != null && name.trim().length() > 0)
			this.name = name;
		else
			throw new FahrtenbuchException("ungültiger Name");
	}

    @Override
    public String toString()
    {
        return name;
    }
	
	

}
