package flugreservierung;

public class Reservierung {
    private int nummer;
    private Flug flug;
    private String name;

    public Flug getFlug()
    {
        return flug;
    }

    public void setFlug(Flug flug)
    {
        this.flug = flug;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getNummer()
    {
        return nummer;
    }

    public void setNummer(int nummer)
    {
        this.nummer = nummer;
    }

    
}
