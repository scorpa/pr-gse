package fahrtenbuch.fachlogik;

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: implementieren
public class Kostenpunkt
{
    private final static SimpleDateFormat DATUMS_FORMAT = new SimpleDateFormat("dd.MM.yy  ");
    
    private Date datum;
    private int km;
    private float betrag;
    private String bemerkung;
    private Fahrer fahrer;
    private boolean fixkosten;
    
    /**
     * setzt Standardwerte
     *
     */
    public Kostenpunkt()
    {
        datum = new Date();
        km = 0;
        betrag = 0;
        bemerkung = "";
        fahrer = null;
        fixkosten = false;
    }
    
    /**
     * 
     * @return Bemerkung zum Kostenpunkt
     */
    public String getBemerkung()
    {
        return bemerkung;
    }
    
    /**
     * 
     * @param bemerkung Bemerkung zum Kostenpunkt
     * @throws FahrtenbuchException falls null übergeben wird
     */
    public void setBemerkung(String bemerkung) throws FahrtenbuchException
    {
        if (bemerkung != null)
            this.bemerkung = bemerkung;
        else 
            throw new FahrtenbuchException("ungültige Bemerkung");
    }
    
    /**
     * 
     * @return Betrag des Kostenpunktes
     */
    public float getBetrag()
    {
        return betrag;
    }
    
    /**
     * Setzt den Betrag des Kostenpunktes
     * Hier ist auch ein negativer Wert gültig, 
     * um eventuelle Gutschriften (z.B. Verschrottungsprämie)
     * zu berücksichtigen
     * 
     * @param betrag Betrag des Kostenpunktes
     */
    public void setBetrag(float betrag)
    {
        this.betrag = betrag;
    }
    
    /**
     * 
     * @return Datum der Ausgabe
     */
    public Date getDatum()
    {
        return datum;
    }
    
    /**
     * 
     * @param datum Datum der Ausgabe
     * @throws FahrtenbuchException falls das Datum in der Zukunft liegt
     */
    public void setDatum(Date datum) throws FahrtenbuchException
    {
        if (new Date().compareTo(datum) > 0)
            this.datum = datum;
        else
            throw new FahrtenbuchException("Es werden keine zukünftigen Ausgaben erfasst");
    }
    
    /**
     * 
     * @return Fahrer, welcher die Ausgabe bezahlt hat
     */
    public Fahrer getFahrer()
    {
        return fahrer;
    }
    
    /**
     * 
     * @param fahrer Fahrer, welcher die Ausgabe bezahlt hat
     * @throws FahrtenbuchException falls null übergeben wird
     */
    public void setFahrer(Fahrer fahrer) throws FahrtenbuchException
    {
        if (fahrer != null)
            this.fahrer = fahrer;
        else
            throw new FahrtenbuchException("ungültiger Fahrer");
    }
    
    /**
     * 
     * @return true: Fixkosten, false: km-abhängige Kosten
     */
    public boolean isFixkosten()
    {
        return fixkosten;
    }
    
    /**
     * 
     * @param fixkosten true: Fixkosten, false: km-abhängige Kosten
     */
    public void setFixkosten(boolean fixkosten)
    {
        this.fixkosten = fixkosten;
    }
    
    /**
     * 
     * @return KM-Stand bei der Ausgabe
     */
    public int getKm()
    {
        return km;
    }
    
    /**
     * 
     * @param km KM-Stand bei der Ausgabe
     * @throws FahrtenbuchException falls eine negative Zahl üergeben wird
     */
    public void setKm(int km) throws FahrtenbuchException
    {
        if (km >= 0)
            this.km = km;
        else
            throw new FahrtenbuchException("negative KM-Angaben sind nicht erlaubt");
    }

    @Override
    public String toString()
    {
        return DATUMS_FORMAT.format(datum) + fahrer;
    }
    
    
}
