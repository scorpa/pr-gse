package fahrtenbuch.fachlogik;

import java.io.Serializable;

public class Fahrer implements Serializable
{
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
