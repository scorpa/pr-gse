package fachlogik;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Mitarbeiter
{
    private int nr;
    private String name;
    private String pwd;
    private int stunden;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getNr()
    {
        return nr;
    }

    public void setNr(int nr)
    {
        this.nr = nr;
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    public int getStunden()
    {
        return stunden;
    }

    public void setStunden(int stunden)
    {
        this.stunden = stunden;
    }

    @Override
    public String toString()
    {
        return nr + " " + name;
    }

    

}
