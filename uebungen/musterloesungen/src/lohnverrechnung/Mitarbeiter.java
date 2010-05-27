/*
 * Created on 22.02.2009
 *
 */
package lohnverrechnung;

import java.util.Calendar;

/**
 * Basisklasse für alle Mitarbeiter
 * @author Rudolf Radlbauer
 *
 */
public class Mitarbeiter
{
    private int nr;  // Mitarbeiternummer
    private String name;
    private int eintritt;  // Eintrittsjahr
    
    /**
     * Konstruktor.
     * Die Mitarbeiternummer wird übergeben, da diese als eindeutige ID fungiert
     * @param nr Mitarbeiternummer
     */
    public Mitarbeiter(int nr)
    {
        setNr(nr);
        // wenn der Mitarbeiter neu angelegt wird ist er vielleicht eben eingetreten.
        eintritt = aktuellesJahr();
        name = "unbekannt";
        
    }

    /**
     * liefert das Eintrittsjahr
     * @return Eintrittsjahr
     */
    public int getEintritt()
    {
        return eintritt;
    }

    /**
     * Setzt das Eintrittsjahr
     * @param eintritt Eintrittsjahr
     */
    public void setEintritt(int eintritt)
    {
        if (eintritt >= 1900 && eintritt <= aktuellesJahr())
            this.eintritt = eintritt;
        else
            System.out.println("ungültiges Eintrittsjahr");
    }

    /**
     * 
     * @return Name des Mitarbeiters
     */
    public String getName()
    {
        return name;
    }

    /**
     * 
     * @param name Name des Mitarbeiters
     */
    public void setName(String name)
    {
        if (name != null && name.length() > 0)
            this.name = name;
        else
            System.out.println("ungültiger Name");
    }

    /**
     * 
     * @return Mitarbeiternummer
     */
    public int getNr()
    {
        return nr;
    }

    // sollte nur im Konstruktor gesetzt werden -> privat
    private void setNr(int nr)
    {
        if (nr > 0)
            this.nr = nr;
        else
            System.out.println("ungültige Mitarbeiternummer");
    }
    
    /**
     * liefert den Lohn des Mitarbeiters.
     * Diese Methode soll in den abgeleiteten Klassen sinnvoll überschrieben werden.
     * In der Basisklasse kann kein sinnvoller Lohn berechnet werden,
     * daher wird 0 zurückgeliefert.
     * @return 0
     */
    public double berechneLohn()
    {
        return 0;
    }
    
    /**
     * liest die Daten des Mitarbeiters (Name und Eintrittsjahr) von der Konsole ein
     *
     */
    public void einlesen()
    {
        name = Input.readText("Name: ");
        int jahr;
        do
        {
            jahr = Input.readInt("Eintrittsjahr: ");
            setEintritt(jahr);
        } while (jahr != eintritt); // wurde in set-Methode übernommen?
        
    }
    
    /**
     * gibt die Daten des Mitarbeiters (Mitarbeiternummer, Name, Eintrittsjahr)
     * auf die Konsole aus
     *
     */
    public void ausgeben()
    {
        System.out.println("Mitarbeiternummer:\t" + nr);
        System.out.println("Name:\t" + name);
        System.out.println("Eintrittsjahr:\t" + eintritt);
    }
    
    /**
     * Hilfsmethode: liefert das aktuelle Jahr zurück
     * @return aktuelles Jahr
     */
    public static int aktuellesJahr()
    {
        Calendar heute = Calendar.getInstance();
        return heute.get(Calendar.YEAR);
    }
    
    
    
    
    
}
