/*
 * Created on 11.02.2009
 *
 */
package schulverwaltung;

import java.util.ArrayList;

/**
 * Lehrer-Klasse f�r Schulverwaltung
 * @author Rudolf Radlbauer
 *
 */
public class Lehrer extends Person
{
    private String kuerzel;
    private ArrayList<String> klassen;
    
    
    public Lehrer(String kuerzel)
    {
        super();
        this.kuerzel = "XX"; // f�r den Fall, dass was Ung�ltiges �bergeben wurde
        setKuerzel(kuerzel);
        klassen = new ArrayList<String>();
    }


    public String getKuerzel()
    {
        return kuerzel;
    }


    public void setKuerzel(String kuerzel)
    {
        if (checkKuerzel(kuerzel))
            this.kuerzel = kuerzel;
    }
    
    
    // set-Methode f�r die ganze Liste ist nicht sehr sinnvoll
    public void addKlasse(String klasse)
    {
        // hier wird die �berpr�fungsmethode aus der Klasse Schueler verwendet
        if (Schueler.checkKlasse(klasse))
            klassen.add(klasse);
    }
    
    public ArrayList<String> getKlassen()
    {
        return klassen;
    }
    
    public void removeKlasse(String klasse)
    {
        klassen.remove(klasse);
    }
    
    
    /**
     * Hilfsmethode zum �berpr�fen des K�rzels
     * @param kuerzel String zum �berpr�fen
     * @return true, wenn K�rzel ok ist
     */
    private static boolean checkKuerzel(String kuerzel)
    {
        if (kuerzel == null) return false;  // null-String nicht erlaubt
        if (kuerzel.length() >= 2 && kuerzel.length() <= 3)  // L�nge 2 oder 3
        {
            for (int i = 0; i < kuerzel.length(); i++)
                if (!Character.isLetter(kuerzel.charAt(i)))  // kein Buchstabe
                    return false;
            return true;  // ok
        }
        return false;  // falsche L�nge
    }


    @Override
    public void ausgeben()
    {
        super.ausgeben();
        System.out.print("\t" + kuerzel);
        
    }
    
}
