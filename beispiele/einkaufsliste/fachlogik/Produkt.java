package einkaufsliste.fachlogik;

/**
 * Datenhaltungsklasse für Produkte
 * @author Rudolf Radlbauer
 */
public class Produkt
{
    private String bezeichnung;
    private GESCHAEFT geschaeft;
    private float preis;
    private LAND herkunft;
    private boolean bio;

    public Produkt()
    {
        bezeichnung = "unbekannt";
        preis = 0;
        bio = true;
        herkunft = LAND.SONSTIGE;
        geschaeft = GESCHAEFT.SONSTIGES;
    }

    public String getBezeichnung()
    {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) throws EinkaufsListeException
    {
        if (bezeichnung != null && bezeichnung.trim().length() > 0)
            this.bezeichnung = bezeichnung;
        else
            throw new EinkaufsListeException("leere Produktbezeichnung");
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

    public void setPreis(float preis) throws EinkaufsListeException
    {
        if (preis > 0)
            this.preis = preis;
        else
            throw new EinkaufsListeException("nur positiver Preis erlaubt");
    }

    @Override
    public String toString()
    {
        return bezeichnung;
    }

    

}
