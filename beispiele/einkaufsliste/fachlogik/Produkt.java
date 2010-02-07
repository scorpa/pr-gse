package einkaufsliste.fachlogik;

/**
 *
 * @author Rudi
 */
public class Produkt
{
    private String bezeichnung;
    private GESCHAEFT geschaeft;
    private float preis;
    private LAND herkunft;
    private boolean bio;

    public String getBezeichnung()
    {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung)
    {
        this.bezeichnung = bezeichnung;
    }

    public boolean isBio()
    {
        return bio;
    }

    public void setBio(boolean bio)
    {
        this.bio = bio;
    }

    public GESCHAEFT getGeschaeft()
    {
        return geschaeft;
    }

    public void setGeschaeft(GESCHAEFT geschaeft)
    {
        this.geschaeft = geschaeft;
    }

    public LAND getHerkunft()
    {
        return herkunft;
    }

    public void setHerkunft(LAND herkunft)
    {
        this.herkunft = herkunft;
    }

    public float getPreis()
    {
        return preis;
    }

    public void setPreis(float preis)
    {
        this.preis = preis;
    }

    

}
