package mitglied;
/**
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Mitglied
{
    private String name; // Name in der Form "<Vorname> <Nachname>"
    private String eintritt;    // Datum in der Form "<dd>:<mm>:<jjjj>"
    
    
    public Mitglied(String name)
    {
        if (name != null)
        {
            int indexOfSpace = name.indexOf(' ');
            if (indexOfSpace > 0  // space existiert und liegt nicht am Anfang
                    && indexOfSpace < name.length()-1  // space liegt nicht an letzter Stelle
                    && indexOfSpace == name.lastIndexOf(' '))   // es gibt exakt 1 Space
            {
                this.name = name;
            }
            else
            {
                System.out.println("ungültiges Namensformat");
                this.name = "Vorname Nachname";
            }
        }
        else
        {
            System.out.println("Name darf nicht null sein");
            this.name = "Vorname Nachname";            
        }
    }


 
    public void setEintritt(String eintritt)
    {
        // Das ist etwas kompliziert, aber es gibt
        // - zumindest mit den derzeit zur Verfügung stehenden Mitteln - 
        // nichts einfacheres.
        if (eintritt != null 
                && eintritt.length() == 10
                && isDigit(eintritt.charAt(0))
                && isDigit(eintritt.charAt(1))
                && eintritt.charAt(2) == ':'
                && isDigit(eintritt.charAt(3))
                && isDigit(eintritt.charAt(4))
                && eintritt.charAt(5) == ':'
                && isDigit(eintritt.charAt(6))
                && isDigit(eintritt.charAt(7))
                && isDigit(eintritt.charAt(8))
                && isDigit(eintritt.charAt(9)))
        {
            this.eintritt = eintritt;
        }
        else
        {
            System.out.println("ungültiges Datumsformat");
            this.eintritt = "01:01:1970";
        }
    }
    
    
    public String getVorname()
    {
        // vom Beginn bis 1 vor dem Leerzeichen
        // (substring liefert von startindex bis endindex-1)
        return name.substring(0, name.indexOf(' ')); 
        
        /* etwas ausführlicher:
         * -------------------------------
        int ende = name.indexOf(' ');
        String vorname = name.substring(0, ende);
        return vorname;
        * --------------------------------
        */
    }
    
    public String getNachname()
    {
        return name.substring(name.indexOf(' ')+1); // 1 nach dem Leerzeichen bis Ende
               
        /* etwas ausführlicher:
         * -------------------------------
        int beginn = name.indexOf(' ') + 1;
        String nachname = name.substring(beginn);
        return nachname;
        * --------------------------------
        */
    }
    
    public boolean vornameBeginntMit(String str)
    {
        return getVorname().startsWith(str);
        
        /* etwas ausführlicher:
         * -------------------------------
        String vorname = this.getVorname();
        boolean janein = vorname.startsWith(str);
        return janein;
        * --------------------------------
        */
    }
    
    public boolean nachnameBeginntMit(String str)
    {
        return getNachname().startsWith(str);
    }
    
    public int getDauerMitgliedschaft(int aktuellesJahr)
    {
        Integer jahr = new Integer(eintritt.substring(6));
        return aktuellesJahr - jahr.intValue();
        
        /* etwas ausführlicher:
         * -------------------------------
        String jahrString = eintritt.substring(6);
        Integer jahr = new Integer(jahrString);
        int dauer = aktuellesJahr - jahr.intValue();
        return dauer;
        * --------------------------------
        */        
    }
    
    
    
    // Hilfsmethode um zu testen, ob ein Zeichen eine Ziffer ist
    private boolean isDigit(char c)
    {
        return (c >= '0' && c <= '9');
    }
    
    
    
 
}
