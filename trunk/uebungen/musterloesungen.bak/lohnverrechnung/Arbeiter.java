/*
 * Created on 22.02.2009
 *
 */
package lohnverrechnung;

/**
 * Arbeiter abgeleitet von Mitarbeiter
 * @author Rudolf Radlbauer
 *
 */
public class Arbeiter extends Mitarbeiter
{
    private final static double BASISLOHN = 40;  // Basis-Stundenlohn
    private final static double JAHRESSTEIGERUNG = 1.03; // Erhöhung pro Dienstjahr: +3%
    
    private int stunden;  // gearbeitete Stunden

    /**
     * Konstruktor, übernimmt die Mitarbeiternummer als Parameter und gibt diese an den
     * Konstruktor der Basisklasse (Mitarbeiter) weiter
     * @param nr Mitarbeiternummer
     */
    public Arbeiter(int nr)
    {
        super(nr);
    }

    /**
     * 
     * @return gearbeitete Stunden
     */
    public int getStunden()
    {
        return stunden;
    }

    /**
     * 
     * @param stunden gearbeitete Stunden
     */
    public void setStunden(int stunden)
    {
        if (stunden >= 0)
            this.stunden = stunden;
        else
            System.out.println("ungültige Stundenanzahl");
    }

    /**
     * gibt die Arbeiter-spezifischen Daten aus
     */
    @Override
    public void ausgeben()
    {
        super.ausgeben();  // Mitarbeiterdaten
        System.out.println("Aktuelle Stunden:\t" + stunden);
    }

    /**
     * berechnet den Lohn des Arbeiters
     * @return Lohn
     */
    @Override
    public double berechneLohn()
    {
        double lohn = stunden * BASISLOHN;
        lohn *= Math.pow(JAHRESSTEIGERUNG, aktuellesJahr() - getEintritt());
        return lohn;
    }

    /**
     * liest die Arbeiter-spezifischen Daten ein und ruft die Methode der 
     * Basisklasse (Mitarbeiter) auf
     */
    @Override
    public void einlesen()
    {
        super.einlesen();  // Mitarbeiterdaten
        int stunden;
        do
        {
            stunden = Input.readInt("aktuelle Stunden: ");
            setStunden(stunden);
        } while (this.stunden != stunden);  // von set-Methode übernommen?
        
    }

    
}
