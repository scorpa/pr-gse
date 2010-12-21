package theater;

 

/**
 *
 * @author Rudolf Radlbauer
 */
public class Reservierung
{
    private int id;
    private Vorstellung vorstellung;
    private int sitzplatz;
    private String name;

    public Reservierung(Vorstellung vorstellung)
    {
        this.vorstellung = vorstellung;
        sitzplatz = 0;
        name = "unbekannt";
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

    public int getSitzplatz()
    {
        return sitzplatz;
    }

    public void setSitzplatz(int sitzplatz)
    {
        if (sitzplatz > 0 && sitzplatz <= 100)
            this.sitzplatz = sitzplatz;
        else
            throw new IllegalArgumentException("ungültige Sitzplatznummer");
    }

    public Vorstellung getVorstellung()
    {
        return vorstellung;
    }

    public void setVorstellung(Vorstellung vorstellung)
    {
        this.vorstellung = vorstellung;
    }

    @Override
    public String toString()
    {
        return new StringBuilder()
                .append(id)
                .append("\t").append(sitzplatz)
                .append("\t").append(name)
                .toString();
    }



}
