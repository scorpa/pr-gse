/*
 * Created on 22.02.2009
 *
 */
package lohnverrechnung;

import java.util.Calendar;

public class Mitarbeiter
{
    private int nr;
    private String name;
    private int eintritt;
    
    public Mitarbeiter(int nr)
    {
        setNr(nr);
        eintritt = aktuellesJahr();
        name = "unbekannt";
        
    }

    public int getEintritt()
    {
        return eintritt;
    }

    public void setEintritt(int eintritt)
    {
        if (eintritt >= 1900 && eintritt <= aktuellesJahr())
            this.eintritt = eintritt;
        else
            System.out.println("ungültiges Eintrittsjahr");
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        if (name != null && name.length() > 0)
            this.name = name;
        else
            System.out.println("ungültiger Name");
    }

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
    
    public double berechneLohn()
    {
        return 0;
    }
    
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
    
    public void ausgeben()
    {
        System.out.println("Mitarbeiternummer:\t" + nr);
        System.out.println("Name:\t" + name);
        System.out.println("Eintrittsjahr:\t" + eintritt);
    }
    
    
    public static int aktuellesJahr()
    {
        Calendar heute = Calendar.getInstance();
        return heute.get(Calendar.YEAR);
    }
    
    
    
    
    
}
