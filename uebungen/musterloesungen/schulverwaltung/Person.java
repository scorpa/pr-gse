/*
 * Created on 11.02.2009
 *
 */
package schulverwaltung;

import java.util.Date;

/**
 * Personenklasse als Basisklasse für Schüler und Lehrer
 * @author Rudolf Radlbauer
 *
 */
public class Person
{
    private String vorname;
    private String nachname;
    private Date geburtsDatum;
    
    public Person()
    {
        vorname = "unbekannt";
        nachname = "unbekannt";
        geburtsDatum = new Date();   // aktuelles Datum
    }

    public Date getGeburtsDatum()
    {
        return geburtsDatum;
    }

    public void setGeburtsDatum(Date geburtsDatum)
    {
        Date heute = new Date();
        if (heute.compareTo(geburtsDatum) >= 0)   // Geburtsdatum muss in Vergangenheit liegen
            this.geburtsDatum = geburtsDatum;
    }

    public String getNachname()
    {
        return nachname;
    }

    public void setNachname(String nachname)
    {
        if (nachname != null && nachname.length() > 0)
            this.nachname = nachname;
    }

    public String getVorname()
    {
        return vorname;
    }

    public void setVorname(String vorname)
    {
        if (vorname != null && vorname.length() >= 0)
            this.vorname = vorname;
    }
    
    public void ausgeben()
    {
        System.out.print(nachname + "\t" + vorname);
    }

}
