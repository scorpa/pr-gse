package theater;

 


import java.util.Date;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Vorstellung
{
    private int id;
    private Date datum;
    private String name;

    public Vorstellung()
    {
        id = 0;
        datum = new Date();
        name = "unbekannt";
    }

    public Date getDatum()
    {
        return datum;
    }

    public void setDatum(Date datum)
    {
        this.datum = datum;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
        return new StringBuilder()
                .append(id)
                .append("\t").append(name)
                .append("\t").append(datum)
                .toString();
    }




}
