package fachlogik;

import java.util.Date;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Eintrag
{
    private int id;
    private String text;
    private String ersteller;
    private Date datum;

    public Date getDatum()
    {
        return datum;
    }

    public void setDatum(Date datum)
    {
        this.datum = datum;
    }

    public String getErsteller()
    {
        return ersteller;
    }

    public void setErsteller(String ersteller)
    {
        this.ersteller = ersteller;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return id + "\t" + datum + "\t" + ersteller + "\t" + text;
    }

    

}
