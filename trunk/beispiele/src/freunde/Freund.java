package freunde;

import java.util.Date;

public class Freund
{
    private String name;
    private Date geburtsTag;
    private int groesse; // cm

    public Freund()
    {
        name = "";
        geburtsTag = new Date();
        groesse = 0;
    }

    public Date getGeburtsTag()
    {
        return geburtsTag;
    }

    public void setGeburtsTag(Date geburtsTag)
    {
        if (new Date().after(geburtsTag))
            this.geburtsTag = geburtsTag;
        else
            throw new IllegalArgumentException("Geburtstag in der Zukunft!");
    }

    public int getGroesse()
    {
        return groesse;
    }

    public void setGroesse(int groesse)
    {
        this.groesse = groesse;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }



}
