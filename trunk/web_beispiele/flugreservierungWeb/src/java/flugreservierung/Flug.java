package flugreservierung;

import java.util.Date;

public class Flug {
    private int nummer;
    private String von;
    private String nach;
    private Date Start;
    private Date ankunft;
    private int sitzPlaetze;

    public Date getStart()
    {
        return Start;
    }

    public void setStart(Date Start)
    {
        this.Start = Start;
    }

    public Date getAnkunft()
    {
        return ankunft;
    }

    public void setAnkunft(Date ankunft)
    {
        this.ankunft = ankunft;
    }

    public String getNach()
    {
        return nach;
    }

    public void setNach(String nach)
    {
        this.nach = nach;
    }

    public int getNummer()
    {
        return nummer;
    }

    public void setNummer(int nummer)
    {
        this.nummer = nummer;
    }

    public String getVon()
    {
        return von;
    }

    public void setVon(String von)
    {
        this.von = von;
    }

    public int getSitzPlaetze()
    {
        return sitzPlaetze;
    }

    public void setSitzPlaetze(int sitzPlaetze)
    {
        this.sitzPlaetze = sitzPlaetze;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append("nummer=").append(nummer);
        str.append("nummer=").append(nummer);
        str.append(" von=").append(von);
        str.append(" nach=").append(nach);
        str.append(" start=").append(Start);
        str.append(" ankunft=").append(ankunft);
        str.append(" sitzplaetze=").append(sitzPlaetze);


       return str.toString();
    }

    
}
