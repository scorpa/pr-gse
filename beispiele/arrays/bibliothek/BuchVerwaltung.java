/*
 * Created on 24.11.2008
 *
 */
package bibliothek;

public class BuchVerwaltung
{
    private Buch[] buecher;  // das Array mit den Büchern
    private int anzahl;      // hier wird die aktuelle Anzahl der Bücher gespeichert.
    
    public BuchVerwaltung(int kapazitaet)   // wieviele Bücher kann ich maximal speichern
    {
        // Array anlegen (hier wird keine Buch-Instanz angelegt!!!)
        buecher = new Buch[kapazitaet];
        anzahl = 0;   // zu Beginn ist noch kein Buch in der Verwaltung
    }
    
    /**
     * ein Buch wird in die Verwaltung aufgenommen
     * @param b
     * @return der Rückgabewert gibt an, ob das Buch aufgenommen werden konnte
     */
    public boolean aufnehmen(Buch b)
    {
        boolean aufgenommen = false;
        
        if (b != null)  // wir wollen keine null-Referenz aufnehmen
        {
            // ist überhaupt noch Platz für ein Buch?
            if (anzahl < buecher.length)
            {
                // beim Index anzahl ist der nächste freie Platz
                buecher[anzahl] = b;
                anzahl++;
                aufgenommen = true;
            }
        }
        return aufgenommen;
    }
    
    /**
     * Ein Buch wird ausgemustert (aus der Verwaltung entfernt)
     * @param index ist der Index des Buches, welches entfernt werden soll
     * @return der Rückgabewert gibt an, ob tatsächlich ein Buch entfernt wurde.
     */
    public boolean ausmustern(int index)
    {
        boolean ausgemustert = false;
        if (index >= 0 && index < anzahl)
        {
            for (int i = index; i < anzahl - 1; i++)
                buecher[i] = buecher[i+1];
            anzahl--;
            ausgemustert = true;
        }
        
        
        return ausgemustert;
    }
    

}
