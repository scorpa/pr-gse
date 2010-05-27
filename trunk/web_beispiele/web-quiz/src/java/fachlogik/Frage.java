package fachlogik;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Frage
{
    private int id;
    private String frage;
    private String[] antworten = new String[4];
    private int richtig;

    public Frage(int id)
    {
        this.id = id;
    }

    public void setAntwort(int index, String antwort)
    {
        antworten[index] = antwort;
    }

    public String getAntwort(int index)
    {
        return antworten[index];
    }

    public String getFrage()
    {
        return frage;
    }

    public void setFrage(String frage)
    {
        this.frage = frage;
    }

    public int getRichtig()
    {
        return richtig;
    }

    public void setRichtig(int richtig)
    {
        this.richtig = richtig;
    }



}
