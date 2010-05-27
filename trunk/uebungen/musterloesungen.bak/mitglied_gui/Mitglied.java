/*
 * Created on 19.05.2009
 *
 */
package mitglied_gui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Rudolf Radlbauer
 * Datenhaltungsklasse für Prüfungsbeispiel zum Thema Swing
 *
 */
public class Mitglied
{
    private String name;
    private Date eintrittsDatum;
    private List<String> hobbies;
    
    /**
     * Im Konstruktor werden Standardwerte gesetzt
     */
    public Mitglied()
    {
        name = "";
        eintrittsDatum = new Date();
        hobbies = new ArrayList<String>();
    }

    /**
     * liefert das Eintrittsdatum
     * @return Eintrittsdatum
     */
    public Date getEintrittsDatum()
    {
        return eintrittsDatum;
    }

    /**
     * setzt das Eintrittsdatum
     * @param eintrittsDatum Eintrittsdatum
     * @throws IllegalArgumentException falls das Eintrittsdatum nicht in der Vergangenheit liegt
     */
    public void setEintrittsDatum(Date eintrittsDatum)
    {
    	// muss in der Vergangenheit liegen
    	if (eintrittsDatum != null && eintrittsDatum.compareTo(new Date()) < 0)
    		this.eintrittsDatum = eintrittsDatum;
    	else
    		throw new IllegalArgumentException("ungültiges Eintrittsdatum");
    }
    
    
    /**
     * setzt den Namen
     * @param name Name
     * @throws IllegalArgumentException falls der Name leer ist
     */
    public void setName(String name)
    {
    	if (name != null && name.trim().length() > 0)
    		this.name = name;
    	else
    		throw new IllegalArgumentException("ungültiger Name");
    }

    
    /**
     * liefert den Namen
     * @return Name
     */
    public String getName()
    {
        return name;
    }

    

    /**
     * liefert die Liste der Hobbies.
     * Achtung: diese Liste kann bearbeitet werden, wodurch sich die Hobbies verändern.
     * @return Referenz auf die Liste der Hobbies
     */
	public List<String> getHobbies()
    {
        return hobbies;
    }

	/**
	 * liefert eine String-Repräsentation des Mitglieds
	 * (Name, Eintrittsdatum, Hobbies)
	 */
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append("Name: ").append(name);
        str.append("\tEintrittsdatum:");
        str.append(new SimpleDateFormat("dd.MM.yyyy").format(eintrittsDatum));
        str.append("\tHobbies:");
        for (String h : hobbies)
            str.append(" ").append(h);
        return str.toString();
    }
    
    

}
