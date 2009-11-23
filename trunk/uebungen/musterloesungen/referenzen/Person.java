package referenzen;
/**
 �bung zum Verst�ndnis von Referenzen
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
     * Der Code im Konstruktor wird durchgef�hrt, wenn eine neue Instanz von Person angelegt wird.
     * In unserem Fall verlangt er in den Parametern Startwerte f�r alle Attribute.
     * (Das ist nicht notwendigerweise so.)
     * Das hei�t, der Benutzer muss gleich wenn er eine Person erzeugt,
     * alle diese Informationen mitgeben.
     * Der Konstruktor muss genauso hei�en wie die Klasse.
     * Im Gegensatz zu anderen Methoden wird beim Konstruktor kein R�ckgabetyp angegeben.
     */
    public Person(String neuerName, char geschl, int jahr)
    {
        if (neuerName != null                // nur wenn eine Referenz auf g�ltiges String-Objekt �bergeben wird 
                && neuerName.length() > 0)   // und wenn der Name eine L�nge > 0 hat (Klasse String hat eine Methode length())
        {
            name = neuerName;
        }
        else
        {
            // falls der Benutzer nichts Vern�nftiges eingibt setze ich Default-Wert ein
            name = "unbekannt";
        }
        
        if (geschl == 'w' || geschl == 'm')
        {
            geschlecht = geschl;
        }
        else
        {
            // falls der Benutzer nichts Vern�nftiges eingibt, nehem ich weiblich an
            // (es gibt auf der Welt etwas mehr Frauen als M�nner)
            // irgendwann einmal werden wir eine bessere L�sung kennenlernen
            geschlecht = 'w';
        }
        
        // n�chstes Jahr (2009) m�ssen wir hier etwas �ndern
        if (jahr >= 1900 && jahr <= 2008)
        {
            geburtsJahr = jahr;
        }
        else
        {
            // wieder m�ssen wir hier irgend einen Default-Wert annehmen
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
            // hier k�nnte man eine Fehlermeldung ausgeben
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
        // nat�rlich gibt es M�glichkeiten, das aktuelle Jahr abzufragen,
        // die lernen wir allerdings erst sp�ter.
        // Vorerst einfach 2008
        return  2008 - geburtsJahr;
    }
    
    
    
    
    
    
    
}
