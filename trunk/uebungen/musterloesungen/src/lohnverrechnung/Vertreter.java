/*
 * Created on 22.02.2009
 *
 */
package lohnverrechnung;
/**
 * Vertreter abgeleitet von Mitarbeiter
 * @author Rudolf Radlbauer
 *
 */
public class Vertreter extends Mitarbeiter
{
    private final static double UMSATZBETEILIGUNG = 0.03; // 3%
    
    private double grundgehalt;
    private double umsatz;

    /**
     * Konstruktor, �bernimmt die Mitarbeiternummer als Parameter und gibt diese an den
     * Konstruktor der Basisklasse (Mitarbeiter) weiter
     * @param nr Mitarbeiternummer
     */
    public Vertreter(int nr)
    {
        super(nr);
    }

    /**
     * 
     * @return Grundgehalt
     */
    public double getGrundgehalt()
    {
        return grundgehalt;
    }

    /**
     * 
     * @param grundgehalt Grundgehalt
     */
    public void setGrundgehalt(double grundgehalt)
    {
        if (grundgehalt > 0)
            this.grundgehalt = grundgehalt;
        else
            System.out.println("ung�ltiges Grundgehalt");
    }

    /**
     * 
     * @return aktueller Umsatz
     */
    public double getUmsatz()
    {
        return umsatz;
    }

    /**
     * 
     * @param umsatz aktueller Umsatz
     */
    public void setUmsatz(double umsatz)
    {
        if (umsatz > 0)
            this.umsatz = umsatz;
        else
            System.out.println("ung�ltiger Umsatz");
    }

    /**
     * gibt die Vertreter-spezifischen Daten aus
     */
    @Override
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Grundgehalt:\t" + grundgehalt);
        System.out.println("Umsatz:\t" + umsatz);
    }

    /**
     * berechnet den Lohn des Vertreters
     * @return Lohn
     */
    @Override
    public double berechneLohn()
    {
        return grundgehalt + umsatz * UMSATZBETEILIGUNG;
    }

    /**
     * liest die Vertreter-spezifischen Daten ein und ruft die Methode der 
     * Basisklasse (Mitarbeiter) auf
     */    
    @Override
    public void einlesen()
    {
        super.einlesen();
        double grundgehalt;
        double umsatz;
        do
        {
            grundgehalt = Input.readDouble("Grundgehalt: ");
            setGrundgehalt(grundgehalt);
        } while (this.grundgehalt != grundgehalt); // bei set-Methode �bernommen?
        
        do
        {
            umsatz = Input.readDouble("Umsatz: ");
            setUmsatz(umsatz);
        } while (this.umsatz != umsatz); // bei set-Methode �bernommen?
        
    }
    
    

}
