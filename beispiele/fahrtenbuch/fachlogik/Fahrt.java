package fahrtenbuch.fachlogik;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Projekt Fahrtenbuch
 * @author Rudolf Radlbauer
 *
 */
public class Fahrt implements Comparable<Fahrt>
{
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yy/hh:mm     ");
    
	private String von;
	private String nach;
	private int kmAbfahrt;
	private int kmAnkunft;
	private Date abfahrt;
	private Date ankunft;
	private String bemerkung;
	private Fahrer fahrer;
	
	/**
	 * setzt Standardwerte
	 */
	public Fahrt()
	{
		von = "";
		nach = "";
		kmAbfahrt = 0;
		kmAnkunft = 0;
		abfahrt = new Date();
		ankunft = new Date();
		bemerkung = "";
		fahrer = null;
	}

	/**
	 * 
	 * @return Abfahrtsort
	 */
	public String getVon()
	{
		return von;
	}

	/**
	 * 
	 * @param von Abfahrtsort
	 * @throws FahrtenbuchException falls Abfahrtsort null oder Leerstring
	 */
	public void setVon(String von) throws FahrtenbuchException
	{
		if (von != null && von.trim().length() > 0)
			this.von = von;
		else
			throw new FahrtenbuchException("ungültiger Abfahrtsort");
	}

	/**
	 * 
	 * @return Ankunftsort
	 */
	public String getNach()
	{
		return nach;
	}

	/**
	 * 
	 * @param nach Ankunftsort
	 * @throws FahrtenbuchException falls Ankunftsort null oder Leerstring
	 */
	public void setNach(String nach) throws FahrtenbuchException
	{
		if (nach != null && nach.trim().length() > 0)
			this.nach = nach;
		else
			throw new FahrtenbuchException("ungültiger Ankunftssort");
	}

	/**
	 * 
	 * @return
	 */
	public int getKmAbfahrt()
	{
		return kmAbfahrt;
	}

	
	/**
	 * Setzt den Kilometerstand bei der Abfahrt.
	 * Dieser muss kleiner sein als der Kilometerstand bei der Ankunft.
	 * Daher wird es im Normalfall notwendig sein, vorher den Kilometerstand 
	 * bei der Ankunft zu setzen (auf Reihenfolge achten!!!)
	 * @param kmAbfahrt KM-Stand bei der Abfahrt
	 * @throws FahrtenbuchException - falls größer als KM-Stand bei Ankunft oder negativ
	 */
	public void setKmAbfahrt(int kmAbfahrt) throws FahrtenbuchException
	{
		if (kmAbfahrt >= 0 && kmAbfahrt <= this.kmAnkunft)
			this.kmAbfahrt = kmAbfahrt;
		else
			throw new FahrtenbuchException("KM-Stand bei Abfahrt ist ungültig");
	}

	/**
	 * 
	 * @return KM-Stand bei Ankunft
	 */
	public int getKmAnkunft()
	{
		return kmAnkunft;
	}

	/**
	 * Setzt den Kilometerstand bei der Ankunft.
	 * Dieser muss größer sein als der KM-Stand bei der Abfahrt.
	 * Diese Methode muss also normalerweise zuerst aufgerufen werden
	 * (auf Reihenfolge achten!!!)
	 * @param kmAnkunft KM-Stand bei Ankunft
	 * @throws FahrtenbuchException  - falls kleiner als KM-Stand bei Abfahrt oder negativ
	 */
	public void setKmAnkunft(int kmAnkunft) throws FahrtenbuchException
	{
		if (kmAnkunft >= 0 && this.kmAbfahrt <= kmAnkunft)
			this.kmAnkunft = kmAnkunft;
		else
			throw new FahrtenbuchException("KM-Stand bei Ankunft ist ungültig");
	}

	/**
	 * 
	 * @return Datum bei Abfahrt
	 */
	public Date getAbfahrt()
	{
		return abfahrt;
	}

	/**
	 * 
	 * @param abfahrt Abfahrtsdatum
	 * @throws FahrtenbuchException falls Abfahrtsdatum null oder in Zukunft oder > Ankunftsdatum
	 */
	public void setAbfahrt(Date abfahrt) throws FahrtenbuchException
	{
		Date heute = new Date();
		if (abfahrt != null)
        {
		    if (heute.compareTo(abfahrt) < 0)
                throw new FahrtenbuchException("Abfahrtszeit darf nicht in der Zukunft liegen");
		    if (this.ankunft == null || abfahrt.compareTo(this.ankunft) < 0)
			    this.abfahrt = abfahrt;
            else
                throw new FahrtenbuchException("Abfahrtszeit muss vor der Ankunftszeit liegen");
                
        }
		else
			throw new FahrtenbuchException("ungültiges Abfahrtsdatum");
	}

	/**
	 * 
	 * @return Datum bei Ankunft
	 */
	public Date getAnkunft()
	{
		return ankunft;
	}

	/**
	 * 
	 * @param ankunft Ankunftsdatum
	 * @throws FahrtenbuchException falls Ankunftsdatum null oder in Zukunft oder < Abfahrtsdatum
	 */
	public void setAnkunft(Date ankunft) throws FahrtenbuchException
	{
		Date heute = new Date();
		if (ankunft != null)
        {
		    if (heute.compareTo(ankunft) < 0)
                throw new FahrtenbuchException("Ankunftszeit darf nicht in der Zukunft liegen");
			if (this.abfahrt == null || this.abfahrt.compareTo(ankunft) < 0)
			    this.ankunft = ankunft;
            else
                throw new FahrtenbuchException("Abfahrtszeit muss vor der Ankunftszeit liegen");
        }
		else
			throw new FahrtenbuchException("ungültiges Ankunftsdatum");
	}

	/**
	 * 
	 * @return Bemerkung zur Fahrt
	 */
	public String getBemerkung()
	{
		return bemerkung;
	}

	
	/**
	 * 
	 * @param bemerkung Bemerkung zur Fahrt
	 * @throws FahrtenbuchException falls Parameter null ist
	 */
	public void setBemerkung(String bemerkung) throws FahrtenbuchException
	{
		if (bemerkung != null)
			this.bemerkung = bemerkung;
		else
			throw new FahrtenbuchException("Bemerkung darf nicht null sein");
	}

	/**
	 * 
	 * @return Fahrer
	 */
	public Fahrer getFahrer()
	{
		return fahrer;
	}

	/**
	 * 
	 * @param fahrer Fahrer für diese Fahrt
	 * @throws FahrtenbuchException falls Parameter null ist
	 */
	public void setFahrer(Fahrer fahrer) throws FahrtenbuchException
	{
		if (fahrer != null)
			this.fahrer = fahrer;
		else
			throw new FahrtenbuchException("Fahrer darf nicht null sein");
	}

    @Override
    public String toString()
    {
        return DATE_FORMAT.format(abfahrt) + von + " --> " + nach;
    }

    public int compareTo(Fahrt f)
    {
        return this.abfahrt.compareTo(f.getAbfahrt());
    }
	
	

}
