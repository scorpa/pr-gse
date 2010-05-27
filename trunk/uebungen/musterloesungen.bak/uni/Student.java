package uni;

import java.util.ArrayList;

/**
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Student
{
    private String name;
    private ArrayList<String> faecher;
    private ArrayList<Pruefung> pruefungen;
    
    public Student(String name)
    {
        // Im Namen muss was drinstehen
        if (name != null && name.length() > 0)
            this.name = name;
        else
        {
            System.out.println("ungültiger Name");
            name = "unbekannt";
        }
        
        // Listen instanziieren
        pruefungen = new ArrayList<Pruefung>();
        faecher = new ArrayList<String>();
    }

    public String getName()
    {
        return name;
    }
    
    /**
     * fügt ein neues Fach zur Liste der Fächer dazu
     * @param fach
     */
    public void inskribieren(String fach)
    {
        if (fach != null && fach.length() > 0)
            faecher.add(fach);
        else
            System.out.println("ungültiges Fach");
    }
    
    public void add(Pruefung p)
    {
        if (p != null)
        {
            // eine Prüfung darf nur zu einem Fach abgelegt werden, welches inskribiert wurde
            if (faecher.contains(p.getFach()))
                pruefungen.add(p);
            else
                System.out.println("dieses Fach wurde nicht inskribiert");
        }
        else
            System.out.println("null-Referenz nicht erlaubt");
    }
    
    public int berechneNote(String fach)
    {
        // erst einmal muss das Fach inskribiert sein
        if (!faecher.contains(fach))
        {
            System.out.println("nicht inskribiert");
            return -1;
        }
        float summe = 0;
        int anzahl = 0;
        
        // jetzt durchsuchen wir die Prüfungsliste
        for (Pruefung p : pruefungen)
        {
            if (p.getFach().equals(fach))  // gehört die Prüfung zum übergebenen Fach?
            {
                summe += p.getNote();  // Note zur Notensumme
                anzahl++;               // Anzahl der Noten in diesem Fach erhöhen
            }
        }
        if (anzahl > 0)   // hat der Student in diesem Fach überhaupt eine Prüfung abgelegt?
            return Math.round(summe / anzahl);
        else
            return 5;
    }
    
    public void notenListe()
    {
        // gehe alle Fächer durch
        for (String fach : faecher)
        {
            long note = Math.round(berechneNote(fach));  // berechne Note im jeweiligen Fach
            System.out.println(fach + ": " + note);     // gib Fach und Note aus
        }
    }
    
    public double berechneDurchschnitt()
    {
        double summe = 0;
        
        // gehe alle Fächer durch
        for (String fach : faecher)
            summe += berechneNote(fach);  // Addiere Note zur Notensumme
        
        return summe / faecher.size();  // dividiere durch Anzahl der Fächer
    }
    
    public boolean bestanden()
    {
        
        // gehe alle Fächer durch
        for (String fach : faecher)
        {
            // sobald ein 5er gefunden wird, ist der Student nicht durchgekommen
            if (berechneNote(fach) == 5)
                return false;
        }
        // kein 5er wurde gefunden --> durchgekommen
        return true;
    }

}
