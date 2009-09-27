/*
 * Created on 07.10.2008
 * 
 */

package datum;

/**
 * Musterlösung für Aufgabe http://code.google.com/p/pr-gse/wiki/uebung_objekte_und_klassen_datum
 * 
 * @author Rudolf Radlbauer
 * 
 * In den Attributen wird der Tag, das Monat und das Jahr eines Datums gespeichert.
 * Es gibt einen Konstruktor, welcher das Standarddatum 1.1.1970 setzt.
 * Der andere Konstruktor übernimmt Tag, Monat und Jahr als Parameter.
 * Es gibt get- und set-Methoden für Tag, Monat und Jahr.
 * Die print()-Methode gibt das Datum aus.
 * Die Methode morgen() schaltet das Datum um 1 Tag weiter.
 * Die Methode gestern() schaltet das Datum um 1 Tag zurück.
 */
public class Datum
{
    private int tag;
    private int monat;
    private int jahr;
    
    /**
     * Standard-Konstruktor --> 1.1.1970
     *
     */
    public Datum()
    {
        tag = 1;
        monat = 1;
        jahr = 1970;
    }
    
    public Datum(int t, int m, int j)
    {
        if (test(t, m, j))
        {
            tag = t;
            monat = m;
            jahr = j;
        }
    }

    public int getJahr()
    {
        return jahr;
    }

    public void setJahr(int j)
    {
        if (test(tag, monat, j))
            jahr = j;
    }

    public int getMonat()
    {
        return monat;
    }

    public void setMonat(int m)
    {
        if (test(tag, m, jahr))
            monat = m;
    }

    public int getTag()
    {
        return tag;
    }

    public void setTag(int t)
    {
        if (test(t, monat, jahr))
        tag = t;
    }
    
    /**
     * Ausgabe im Format tt.mm.jjjj
     *
     */
    public void print()
    {
        String t = "" + tag;
        if (tag < 10)
            t = "0" + tag;
        String m = "" + monat;
        if (monat < 10)
            m = "0" + monat;
        System.out.println(t + "." + m + "." + jahr);
    }
    
    public void morgen()
    {
        if (test(tag+1, monat, jahr)) // ist morgen noch im selben Monat?
            tag++;
        else if (monat < 12)
        {
            tag = 1;
            monat++;
        }
        else
        {
            tag = 1;
            monat = 1;
            jahr++;
        }
    }
    
    public void gestern()
    {
        if (tag > 1)    // war gestern schon selber Monat?
            tag--;
        else if (monat == 1) 
        {
            tag = 31;
            monat = 12;
            jahr--;
        }
        else
        {
            monat--;
            // hier suche ich beginnend bei 31 abwärts den ersten gültigen Tag für diesen Monat
            if (test(31, monat, jahr))
                tag = 31;
            else if (test(30, monat, jahr))
                tag = 30;
            else if (test(29, monat, jahr))
                tag = 29;
            else
                tag = 28;
        }
    }
    
    /**
     * Hilfsmethode, welche überprüft, ob ein Datum gültig ist
     */
    private boolean test(int tag, int monat, int jahr)
    {
        if (jahr < 0)   // ungültiges Jahr
            return false;
        if (monat < 1 || monat > 12)    // ungültiger Monat
            return false;
        if (tag < 1)    
            return false;
        if (monat == 2) // Februar
        {
            if (jahr % 4 == 0 && jahr % 100 != 0 || jahr % 400 == 0)  // Schaltjahr
            {
                if (tag > 29)
                    return false;
            }
            else
            {
                if (tag > 28)
                    return false;
            }
        }
        // April, Juni, Sept., November (30 Tage)
        else if (monat == 4 || monat == 6 || monat == 9 || monat == 11) 
        {
            if (tag > 30)
                return false;
        }
        // Monte mit 31 Tagen
        else
        {
            if (tag > 31)
                return false;
        }
        return true;  // kein Fehler gefunden
    }

}
