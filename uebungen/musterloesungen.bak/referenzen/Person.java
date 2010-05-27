package referenzen;
/**
 Übung zum Verständnis von Referenzen
 @author Rudolf Radlbauer
 @version  1. Version
 */
public class Person
{
    // Attribute:
    // private <typ> <attributs-name>
    private String name;  // String ist eigentlich auch eine Klasse ==> Referenz auf String-Objekt
    private char geschlecht;   // einzelnes Zeichen
    private int geburtsJahr;   // Ganzzahl
    
    
    /*
     * Der Code im Konstruktor wird durchgeführt, wenn eine neue Instanz von Person angelegt wird.
     * In unserem Fall verlangt er in den Parametern Startwerte für alle Attribute.
     * (Das ist nicht notwendigerweise so.)
     * Das heißt, der Benutzer muss gleich wenn er eine Person erzeugt,
     * alle diese Informationen mitgeben.
     * Der Konstruktor muss genauso heißen wie die Klasse.
     * Im Gegensatz zu anderen Methoden wird beim Konstruktor kein Rückgabetyp angegeben.
     */
    public Person(String neuerName, char geschl, int jahr)
    {
        if (neuerName != null                // nur wenn eine Referenz auf gültiges String-Objekt übergeben wird 
                && neuerName.length() > 0)   // und wenn der Name eine Länge > 0 hat (Klasse String hat eine Methode length())
        {
            name = neuerName;
        }
        else
        {
            // falls der Benutzer nichts Vernünftiges eingibt setze ich Default-Wert ein
            name = "unbekannt";
        }
        
        if (geschl == 'w' || geschl == 'm')
        {
            geschlecht = geschl;
        }
        else
        {
            // falls der Benutzer nichts Vernünftiges eingibt, nehem ich weiblich an
            // (es gibt auf der Welt etwas mehr Frauen als Männer)
            // irgendwann einmal werden wir eine bessere Lösung kennenlernen
            geschlecht = 'w';
        }
        
        // nächstes Jahr (2009) müssen wir hier etwas ändern
        if (jahr >= 1900 && jahr <= 2008)
        {
            geburtsJahr = jahr;
        }
        else
        {
            // wieder müssen wir hier irgend einen Default-Wert annehmen
            geburtsJahr = 1900;
        }
    }
    
    // Default-Konstruktor
    public Person()
    {
        name = "unbekannt";
        geschlecht = 'w';
        geburtsJahr = 1900;
    }
    
    /**
     * get-Methode
     */
    public int getGeburtsJahr()
    {
        return geburtsJahr;
    }
    
    /**
     * set-Methode
     */
    public void setGeburtsJahr(int jahr)
    {
        if (jahr >= 1900 && jahr <= 2008)
        {
            geburtsJahr = jahr;
        }
        else
        {
            // hier könnte man eine Fehlermeldung ausgeben
        }
    }
    
    /**
     * get-Methode
     */
    public char getGeschlecht()
    {
        return geschlecht;
    }
    
    /**
     * set-Methode
     */
    public void setGeschlecht(char geschl)
    {
        if (geschl == 'w' || geschl == 'm')
        {
            geschlecht = geschl;
        }

    }
    
    /**
     * get-Methode
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * setMethode
     */
    public void setName(String neuerName)
    {
        // siehe oben
        if (neuerName != null && neuerName.length() > 0)   
        {
            name = neuerName;
        }
    }
    
    public int berechneAlter()
    {
        // natürlich gibt es Möglichkeiten, das aktuelle Jahr abzufragen,
        // die lernen wir allerdings erst später.
        // Vorerst einfach 2008
        return  2008 - geburtsJahr;
    }
    
    
    
    
    
    
    
}
