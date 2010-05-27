/*
 * Created on 22.02.2009
 *
 */
package lohnverrechnung;

/**
 * Angestellter abgeleitet von Mitarbeiter
 * @author Rudolf Radlbauer
 *
 */
public class Angestellter extends Mitarbeiter
{
    private int gehaltsStufe;
    
    private final static double BASISGEHALT = 1500;   // 1. Dienstjahr, 1. Gehaltsstufe
    private final static double GEHALTSSPRUNG = 1.1;  // Steigerung pro Gehaltsstufe: +10%
    private final static double JAHRESSTEIGERUNG = 30;  // Steigerung pro Dienstjahr
    
    /**
     * Konstruktor, übernimmt die Mitarbeiternummer als Parameter und gibt diese an den
     * Konstruktor der Basisklasse (Mitarbeiter) weiter
     * @param nr Mitarbeiternummer
     */
    public Angestellter(int nr)
    {
        super(nr);
        gehaltsStufe = 1;  // neuer Mitarbeiter
    }

    /**
     * 
     * @return Gehaltsstufe
     */
    public int getGehaltsStufe()
    {
        return gehaltsStufe;
    }

    /**
     * Gehaltsstufe muss zwischen 1 und 5 (inklusive) liegen
     * @param gehaltsStufe Gehaltsstufe
     */
    public void setGehaltsStufe(int gehaltsStufe)
    {
        if (gehaltsStufe >= 1 && gehaltsStufe <= 5)
            this.gehaltsStufe = gehaltsStufe;
        else
            System.out.println("ungültige Gehaltsstufe");
    }

    /**
     * liest die Angestellten-spezifischen Daten ein und ruft die Methode der 
     * Basisklasse (Mitarbeiter) auf
     */
    @Override
    public void einlesen()
    {
        super.einlesen();  // zuerst werden Name und Eintrittsjahr eingelesen
        int stufe;
        do
        {
            stufe = Input.readInt("Gehaltsstufe: ");
            setGehaltsStufe(stufe);
        } while (stufe != gehaltsStufe);  // wurde bei set-Methode übernommen?
    }

    /**
     * gibt die Angestellten-spezifischen Daten aus
     */
    @Override
    public void ausgeben()
    {
        super.ausgeben();  // zuerst Mitarbeiternummer, Name, Eintrittsjahr
        System.out.println("Gehaltsstufe:\t" + gehaltsStufe);
    }

    /**
     * berechnet den Lohn des Angestellten
     * @return Lohn
     */
    @Override
    public double berechneLohn()
    {
        double gehalt = BASISGEHALT;
        gehalt *= Math.pow(GEHALTSSPRUNG, gehaltsStufe-1);
        gehalt += (aktuellesJahr()- getEintritt()) * JAHRESSTEIGERUNG;
        return gehalt;
    }

    
    

}
