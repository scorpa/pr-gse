
/**
 * Mitarbeiter-Klasse für Lohnabrechnung
 * 
 * @author Rudolf Radlbauer 
 * @version 1.10.2010
 */
public class Mitarbeiter
{
    // Attribute
    private String name;
    private int personalNr;
    private int eintrittsJahr;
    private int gehaltsStufe; // von 1 bis 5
    private boolean karenz; // ist der Mitarbeiter derzeit in Karenz?
    
    /**
     * Konstruktor
     * dient zur Initialisierung aller Attribute auf Standardwerte
     * @param persNr die Personalnummer des neuen Mitarbeiters
     */
    public Mitarbeiter(int persNr)
    {
        personalNr = persNr; // die Personalnummer wird mit einem Parameter übernommen
        name = "N.N.";
        eintrittsJahr = 2010;
        gehaltsStufe = 1;
        karenz = false;
    }
    
    // ============ set- und get-Methoden ====================
    public void setName(String neuerName)
    {
        name = neuerName;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setPersonalNr(int nr)
    {
        personalNr = nr;
    }
    
    public int getPersonalNr()
    {
       return personalNr;
    }
    
    /**
     * set-Methode für das Eintrittsjahr.
     * Dieses darf nicht in der Zukunft liegen.
     * @param jahr neuer Wert fürs Eintrittsjahr
     */
    public void setEintrittsJahr(int jahr)
    {
        if (jahr <= 2010)  // liegt nicht in der Zukunft (aktuelles Jahr hard-coded)
        {
            eintrittsJahr = jahr;
        }
        else
        {
            System.out.println("Das Eintrittsjahr darf nicht in der Zukunft liegen!");
        }            
    }
    
    public int getEintrittsJahr()
    {
        return eintrittsJahr;
    }
    
    /**
     * set-Methode für die Gehaltsstufe.
     * Diese darf nur die Werte 1 bis 5 annehmen
     * @param stufe neuer Wert für die Gehaltsstufe
     */
    public void setGehaltsStufe(int stufe)
    {
        if (stufe >= 1 && stufe <=5)
        {
            gehaltsStufe = stufe;
        }
        else
        {
            System.out.println("ungültige Gehaltsstufe!");
        }
    }
    
    public int getGehaltsStufe()
    {
        return gehaltsStufe;
    }
    
    public void setKarenz(boolean krnz)
    {
        karenz = krnz;
    }
    
    /**
     * die get-Methode für eine boolean-Wert wird laut Coding-Konvention so geschrieben:
     */
    public boolean isKarenz()
    {
        return karenz;
    }
    
    
    //======================= sonstige Methoden =========================
    public int berechneDienstAlter()
    {
        // der Einfachheit halber ist das aktuelle Jahr hard-coded
        // (das würde natürlich nächstes Jahr nicht mehr funktionieren)
        return 2010 - eintrittsJahr;   
    }
    
    public double berechneGehalt()
    {
	    if (karenz) return 0;  // während der Karenz gibts kein Geld
        double gehalt = 1200;  // Grundgehalt der 1. Gehaltsstufe
        gehalt = gehalt + (gehaltsStufe - 1) * 100;  // um 100€ mehr pro höherer Stufe
        gehalt = gehalt * (1 + berechneDienstAlter() * 0.02);  // 2% Erhöhung pro Dienstjahr
        return gehalt;
    }
    
    public void gehaltsErhoehung()
    {
        if (gehaltsStufe < 5)
        {
            gehaltsStufe = gehaltsStufe + 1;
        }
        else
        {
            System.out.println("Mitarbeiter/in ist bereits in höchster Gehaltsstufe!");
        }
    }

}
