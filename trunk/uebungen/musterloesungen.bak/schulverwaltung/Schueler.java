/*
 * Created on 11.02.2009
 *
 */
package schulverwaltung;

/**
 * Sch�ler-Klasse f�r Schulverwaltung
 * @author Rudolf Radlbauer
 *
 */
public class Schueler extends Person
{
    private int schuelerNummer;
    private String klasse;
    
    
    
    public Schueler(int schuelerNummer)
    {
        super();
        setSchuelerNummer(schuelerNummer);
        klasse = "00000";
    }
    
    
    public String getKlasse()
    {
        return klasse;
    }
    
    public void setKlasse(String klasse)
    {
        if (Schueler.checkKlasse(klasse))
            this.klasse = klasse;
    }
    
    public int getSchuelerNummer()
    {
        return schuelerNummer;
    }
    
    public void setSchuelerNummer(int schuelerNummer)
    {
        if (schuelerNummer > 0)
            this.schuelerNummer = schuelerNummer;
    }
    
    /**
     * Hilfsmethode zum �berpr�fen eines Strings f�r Klasse
     * @param klasse zu �berpr�fender String
     * @return true, wenn String ok
     */
    public static boolean checkKlasse(String klasse)
    {
        if (klasse == null) return false;  // null-String nicht erlaubt
        if (klasse.length() >= 5 && klasse.length() <= 6)  // L�nge 5 oder 6
        {
            for (int i = 0; i < klasse.length(); i++)
                if (!Character.isLetterOrDigit(klasse.charAt(i)))  // keine Ziffer oder Buchstabe
                    return false;
            return true;  // ok
        }
        return false;  // falsche L�nge
    }


    @Override
    public void ausgeben()
    {
        super.ausgeben();
        System.out.print("\t" + schuelerNummer);
    }
}
