package einkaufsliste.fachlogik;

import java.io.Serializable;

/**
 * Datenhaltungsklasse für Produkte
 * @author Rudolf Radlbauer
 */
public class Produkt implements Serializable
{
	private static final long serialVersionUID = -7610637044759262553L;
	
	
	private String bezeichnung;
    private GESCHAEFT geschaeft;
    private float preis;
    private LAND herkunft;
    private boolean bio;

    public Produkt()
    {
        bezeichnung = "";
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produkt other = (Produkt) obj;
		if (bezeichnung == null)
		{
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		return true;
	}

    

}
