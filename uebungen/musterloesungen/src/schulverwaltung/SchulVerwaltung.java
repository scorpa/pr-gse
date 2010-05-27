/*
 * Created on 11.02.2009
 *
 */
package schulverwaltung;

import java.util.ArrayList;

public class SchulVerwaltung
{
    private String bezeichnung;
    private ArrayList<Person> personen;
    
    
    
    public SchulVerwaltung(String bezeichnung)
    {
        super();
        this.bezeichnung = "unbekannt";  // für den Fall, dass was Ungültiges übergeben wurde
        setBezeichnung(bezeichnung);
        personen = new ArrayList<Person>();
    }
    
    public String getBezeichnung()
    {
        return bezeichnung;
    }
    
    public void setBezeichnung(String bezeichnung)
    {
        if (bezeichnung != null && bezeichnung.length() > 0)
            this.bezeichnung = bezeichnung;
    }
    
    public void aufnehmen(Person p)
    {
        personen.add(p);
    }
    
    public void liste()
    {
        if (personen.size() > 0)
        {
            System.out.println("Nachname\tVorname\tKuerzel/id\tKlasse(n)");
            System.out.println("-----------------------------------------------------------------------------");
            for (Person p : personen)
            {
                p.ausgeben();
                System.out.println();  // Zeilenumbruch
            }
            System.out.println("-----------------------------------------------------------------------------");
        }
        else
            System.out.println("keine Personen vorhanden");
    }
        
    
    /**
     * suche Schüler mit dieser Schülernummer
     * @param schuelerNummer gesuchte Schülernummer
     * @return Referenz auf gefundene Person oder null, falls nicht gefunden
     */
    public Person finden(int schuelerNummer)
    {
        for (Person p : personen)
        {
            // Überprüfung, ob es sich hier um eine Instanz von Schueler handelt
            if (p instanceof Schueler)
            {
                Schueler s = (Schueler)p;
                if (s.getSchuelerNummer() == schuelerNummer)
                    return s;
            }
        }
        return null;
    }
  
    /**
     * suche Lehrer mit diesem Kürzel
     * @param kuerzel gesuchtes Kürzel
     * @return Referenz auf gefundene Person oder null, falls nicht gefunden
     */

    public Person finden(String kuerzel)
    {
        for (Person p : personen)
        {
            // Überprüfung, ob es sich hier um eine Instanz von Lehrer handelt
            if (p instanceof Lehrer)
            {
                Lehrer l = (Lehrer)p;
                if (l.getKuerzel().equals(kuerzel))
                    return l;
            }
        }
        return null;
    }
    
    
}
