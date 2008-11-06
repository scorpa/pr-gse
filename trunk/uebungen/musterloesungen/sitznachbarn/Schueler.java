/*
 * Created on 19.10.2008
 *
 */
package sitznachbarn;

/**
 * 
 * @author Rudolf Radlbauer
 * Aufgabe 10: Sitznachbarn
 */
public class Schueler
{
    private String name;
    private Schueler linkerNachbar;
    private Schueler rechterNachbar;

    public Schueler(String name)
    {
        if (name != null && name.length() > 0)
            this.name = name;
        else
        {
            System.out.println("ungültiger Name");
            name = "unbekannt";
        }
    }

    public void setLinkerNachbar(Schueler linkerNachbar)
    {
        this.linkerNachbar = linkerNachbar;
    }

    public void setRechterNachbar(Schueler rechterNachbar)
    {
        this.rechterNachbar = rechterNachbar;
    }
    
    public void listeLinks()
    {
        /* 
         * gibt eigenen Namen aus und falls ein linker Nachbar existiert
         * soll dieser seine Liste ausgeben.
         */
        System.out.println(name);
        if (linkerNachbar != null)
            linkerNachbar.listeLinks();
    }
    
    public void listeRechts()
    {
        /* 
         * gibt eigenen Namen aus und falls ein rechter Nachbar existiert
         * soll dieser seine Liste ausgeben.
         */
        System.out.println(name);
        if (rechterNachbar != null)
            rechterNachbar.listeRechts();
        
    }
    
    public int anzahlLinks()
    {
        int anzahl = 1;
        if (linkerNachbar != null)
        {
            // frage den linken Nachbarn nach der Anzahl SEINER linken Nachbarn
            // (inklusive er selbst) und addiere sie dazu
            anzahl += linkerNachbar.anzahlLinks();
        }
        return anzahl;
    }
    
    public int anzahlRechts()
    {
        int anzahl = 1;
        if (rechterNachbar != null)
        {
            // frage den rechten Nachbarn nach der Anzahl SEINER linken Nachbarn
            // (inklusive er selbst) und addiere sie dazu
            anzahl += rechterNachbar.anzahlRechts();
        }
        return anzahl;
        
    }

}
