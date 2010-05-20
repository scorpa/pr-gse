package persistence;

public class Statistik
{
    private int ja;
    private int nein;

    public Statistik(int ja, int nein)
    {
        this.ja = ja;
        this.nein = nein;
    }

    public int getJa()
    {
        return ja;
    }

    public int getNein()
    {
        return nein;
    }

    public int zustimmungProzent()
    {
        int summe = ja + nein;
        if (summe > 0)
            return ja * 100 / summe;
        else
            return 0;
    }

}
