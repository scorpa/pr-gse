/*
 * Created on 11.02.2009
 *
 */
package schulverwaltung;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class Menu
{
    private final static SimpleDateFormat FORMATTER = new SimpleDateFormat("dd.mm.yyyy");
    private SchulVerwaltung verwaltung;
    
    public Menu()
    {
        String name = Input.readText("Name der Schule: ");
        verwaltung = new SchulVerwaltung(name);
        int auswahl = -1;
        
        while (auswahl != 0)
        {
            System.out.println();
            System.out.println("=========== bitte auswählen ==================");
            System.out.println("0\tbeenden");
            System.out.println("1\tPersonen auflisten");
            System.out.println("2\tSchüler anlegen");
            System.out.println("3\tLehrer anlegen");
            System.out.println("4\tSchülerdaten ausgeben");
            System.out.println("5\tLehrerdaten ausgeben");
            
            auswahl = Input.readInt("Ihre Auswahl: ");
            
            System.out.println();
            
            switch(auswahl)
            {
            case 0: break;
            case 1: verwaltung.liste(); break;
            case 2: neuerSchueler(); break;
            case 3: neuerLehrer(); break;
            case 4: schuelerDaten(); break;
            case 5: lehrerDaten(); break;
            default: System.out.println("ungültige Auswahl");
            }
        }
        
    }

    private void lehrerDaten()
    {
        String kuerzel = Input.readText("Kürzel: ");
        Lehrer l = (Lehrer) verwaltung.finden(kuerzel);
        if (l != null)
        {
            printPerson(l);
            System.out.println("Kürzel: " + l.getKuerzel());
            System.out.print("Unterrichtete Klassen: ");
            for (String klasse : l.getKlassen())
                System.out.print(klasse + " ");
            System.out.println();
        }
        else
            System.out.println("Lehrer nicht gefunden");
    }

    private void schuelerDaten()
    {
        int schuelerNummer = Input.readInt("Schuelernummer: ");
        Schueler s = (Schueler) verwaltung.finden(schuelerNummer);
        if (s != null)
        {
            printPerson(s);
            System.out.println("Schülernummer: " + s.getSchuelerNummer());
            System.out.println("Klasse: " + s.getKlasse());
        }
        else
            System.out.println("Schüler nicht gefunden");
    }

    private void printPerson(Person p)
    {
        System.out.println("Vorname: " + p.getVorname());
        System.out.println("Nachname: " + p.getNachname());
        System.out.println("Geburtsdatum: " + FORMATTER.format(p.getGeburtsDatum()));
    }


    private void neuerLehrer()
    {
        String kuerzel = Input.readText("Kürzel: ");
        Lehrer l = new Lehrer(kuerzel);
        personenDaten(l);
        String klassen = Input.readText("Unterrichtete Klassen (durch Abstand getrennt): ");
        StringTokenizer tokenizer = new StringTokenizer(klassen);
        while (tokenizer.hasMoreTokens())
            l.addKlasse(tokenizer.nextToken());
        verwaltung.aufnehmen(l);
    }

    private void neuerSchueler()
    {
        int nr = Input.readInt("Schülernummer: ");
        Schueler s = new Schueler(nr);
        personenDaten(s);
        String klasse = Input.readText("Klasse: ");
        s.setKlasse(klasse);
        verwaltung.aufnehmen(s);
    }
    
    private void personenDaten(Person p)
    {
        String vorname = Input.readText("Vorname: ");
        String nachname = Input.readText("Nachname: ");
        Date geburtsDatum = Input.readDate("Geburtsdatum: ");
        p.setVorname(vorname);
        p.setNachname(nachname);
        p.setGeburtsDatum(geburtsDatum);
    }

}
