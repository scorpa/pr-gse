/*
 * Created on 24.11.2008
 *
 */
package arrays.bibliothek;


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
     * liefert Referenz auf das Buch beim übergebenen Index
     * @param index Index des gewünschten Buches
     * @return Referenz auf das Buch oder null, falls Index nicht gültig
     */
    public Buch get(int index)
    {
        if (index >= 0 && index < anzahl)
            return buecher[index];
        else
            return null;
    }
    
    /**
     * Ein Buch wird ausgemustert (aus der Verwaltung entfernt)
     * @param index ist der Index des Buches, welches entfernt werden soll
     * @return der Rückgabewert gibt an, ob tatsächlich ein Buch entfernt wurde.
     */
    public boolean ausmustern(int index)
    {
        boolean ausgemustert = false;
        // ist der Index überhaupt gültig
        if (index >= 0 && index < anzahl)
        {
            // alle Referenzen nach index müssen um 1 Platz nach vorne kopiert 
            // werden.
            // Anzahl wird um 1 reduziert.
            for (int i = index; i < anzahl - 1; i++)
                buecher[i] = buecher[i+1];
            anzahl--;
            ausgemustert = true;
        }
        
        
        return ausgemustert;
    }
    
    /**
     * Ein Buch wird in der Verwaltung gesucht.
     * Wenn es gefunden wird, wird der Index (erstes Vorkommen) zurückgeliefert,
     * ansonsten -1;
     * @param b Referenz auf die Buch-Instanz, die gesucht werden soll
     * @return der Index der gesuchten Buch-Referenz oder -1, falls nicht gefunden
     */
    public int suchen(Buch b)
    {
        for (int i = 0; i < anzahl; i++)
        {
            if (buecher[i] == b)
                return i;
        }
        return -1;
    }
    
    /**
     * Ein Buch wird ausgemustert (aus der Verwaltung entfernt)
     * @param Referenz auf das Buch, welches ausgemustert werden soll
     * @return der Rückgabewert gibt an, ob tatsächlich ein Buch entfernt wurde.
     */
    public boolean ausmustern(Buch b)
    {
        int index = suchen(b);
        if (index >= 0)
        {
            ausmustern(index);
            return true;
        }
        else
            return false;
    }
    
    
    /**
     * liefert die Anzahl der Bücher zurück, welche mehr Seiten haben als im Parameter
     * übergeben wird.
     * @param Anzahl der Seiten
     * @return Anzahl der Bücher, welche mehr Seiten haben als im Parameter übergeben.
     */
    public int mehrSeiten(int seiten)
    {
        int n = 0;
        for (int i = 0; i < anzahl; i++)
        {
            if (buecher[i].getSeiten() > seiten)
                n++;
        }
        return n;
    }
    
    
    public void liste()
    {
        System.out.println("============ Bücherliste =====================");
        for (int i = 0; i < anzahl; i++)
            System.out.println(buecher[i].getAutor() + "\t" + buecher[i].getTitel() + "\t" + buecher[i].getSeiten() + " Seiten");
    }
    

}
