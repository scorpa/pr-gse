package personenVerwaltungSwing;

import java.util.Date;

public class Person
{
    private String name;
    private Date geburtsDatum;
    private int gewicht;   // kg

    public Person()
    {
        name = "unbekannt";
        geburtsDatum = new Date();
        gewicht = 0;
    }

    public Date getGeburtsDatum()
    {
        return geburtsDatum;
    }

    public void setGeburtsDatum(Date geburtsDatum) throws PersonenVerwaltungsException
    {
        if (geburtsDatum.before(new Date()))
            this.geburtsDatum = geburtsDatum;
        else
            throw new PersonenVerwaltungsException("Geburtsdatum in der Zukunft nicht erlaubt");
    }

    public int getGewicht()
    {
        return gewicht;
    }

    public void setGewicht(int gewicht) throws PersonenVerwaltungsException
    {
        if (gewicht > 0)
            this.gewicht = gewicht;
        else
            throw new PersonenVerwaltungsException("Gewicht kleiner 0 nicht erlaubt");
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) throws PersonenVerwaltungsException
    {
        if (name != null && name.trim().length() > 0)
            this.name = name;
        else
            throw new PersonenVerwaltungsException("leerer Name nicht erlaubt");
    }

    
}
