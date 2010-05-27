/*
 * Created on 22.02.2009
 *
 */
package lohnverrechnung;

import java.util.ArrayList;

/**
 * verwaltet alle Mitarbeiter und stellt Methoden zur Berechnung der Lohnkosten, etc.
 * zur Verfügung
 * @author Rudolf Radlbauer
 *
 */
public class LohnVerrechnung
{
    private ArrayList<Mitarbeiter> liste;  // Mitarbeiterliste
    
    /**
     * Konstruktor instanziiert die Liste
     *
     */
    public LohnVerrechnung()
    {
        liste = new ArrayList<Mitarbeiter>();
    }
    
    /**
     * neuer Mitarbeiter wird in Verwaltung aufgenommen;
     * das kann ein Angestellter, ein Arbeiter, ein Vertreter oder vielleicht
     * auch einmal ein anderer Mitarbeitertyp sein.
     * @param m neuer Mitarbeiter
     */
    public void einstellen(Mitarbeiter m)
    {
        if (m != null)
            liste.add(m);
    }
    
    /**
     * sucht einen Mitarbeiter anhand der Mitarbeiternummer
     * @param nr Mitarbeiternummer
     * @return Referenz auf gefundenen Mitarbeiter oder null, falls nicht gefunden
     */
    public Mitarbeiter suchen(int nr)
    {
        for (Mitarbeiter m : liste)
        {
            if (m.getNr() == nr)
                return m;
        }
        return null;
    }
    
    /**
     * gibt eine Mitarbeiterliste (Mitarbeiternummer, Name) auf die Konsole aus
     *
     */
    public void liste()
    {
        for (Mitarbeiter m : liste)
            System.out.println(m.getNr() + "\t" + m.getName());
    }
    
    /**
     * gibt eine Gehaltstabelle auf die Konsole aus
     *
     */
    public void gehaltsTabelle()
    {
        for (Mitarbeiter m : liste)
            System.out.println(m.getNr() + "\t" + m.getName() + "\t" + m.berechneLohn());
        
    }
    
    /**
     * berechnet die gesamten Lohnkosten aller Mitarbeiter
     * @return Lohnkosten
     */
    public double lohnkosten()
    {
        double kosten = 0;
        for (Mitarbeiter m : liste)
            kosten += m.berechneLohn();
        return kosten;
    }

}
