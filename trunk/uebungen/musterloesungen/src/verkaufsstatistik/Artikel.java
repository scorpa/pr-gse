package verkaufsstatistik;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Artikel implements Serializable
{
    private String bezeichnung;
    private int anzahl;
    private float preis;
    private Date verkaufsBeginn;

    public int getAnzahl()
    {
        return anzahl;
    }

    public void setAnzahl(int anzahl)
    {
        if (anzahl >= 0)
            this.anzahl = anzahl;
        else
            throw new IllegalArgumentException("ungueltige Anzahl");
    }

    public String getBezeichnung()
    {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung)
    {
        if (bezeichnung.trim().length() > 0)
            this.bezeichnung = bezeichnung;
        else
            throw new IllegalArgumentException("leere Bezeichnung nicht erlaubt");
    }

    public float getPreis()
    {
        return preis;
    }

    public void setPreis(float preis)
    {
        if (preis > 0)
            this.preis = preis;
        else
            throw new IllegalArgumentException("ungueltiger Preis");
    }

    public Date getVerkaufsBeginn()
    {
        return verkaufsBeginn;
    }

    public void setVerkaufsBeginn(Date verkaufsBeginn)
    {
        if (verkaufsBeginn.before(new Date()))
            this.verkaufsBeginn = verkaufsBeginn;
        else
            throw new IllegalArgumentException("ungueltiges Datum fuer Verkaufsbeginn");
    }

    @Override
    public String toString()
    {
        return bezeichnung + "\t" + anzahl + "\t" + preis + "\t" + verkaufsBeginn;
    }



}
