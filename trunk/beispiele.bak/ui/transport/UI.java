package ui.transport;

import java.util.GregorianCalendar;

/**
 * Beispiel für eine zeilenorientierte Menu-Steuerung
 * @author Rudolf Radlbauer
 *
 */
public class UI
{
    private Container aktuell;
    
    /**
     * Im Konstruktor wird die Menu-Schleife gestartet.
     *
     */
    public UI()
    {
        int option = 1;
        
        // solgange der Benutzer nicht 4 eingegeben hat, wird immer wieder das Hauptmenu angezeigt.
        while (option != 0)
        {
            System.out.println("\n\n\n\n");
            System.out.println("=======================================================");
            System.out.println("0) beenden");
            System.out.println("1) neuer Container");
            System.out.println("2) Platten auflisten");
            System.out.println("3) Platte aufladen");
            System.out.println("4) Kunden eintragen");
            System.out.println("5) Lieferdatum eintragen");
            System.out.println("=======================================================");
            
            option = Input.readInt("Ihre Auswahl: ");
            
            /* Anstatt einer Reihe von Verzweigungen ist es einfacher, 
             * eine switch-Anweisung zu verwenden
             * 
            if (option == 1)
                neuerContainer();
            else if (option == 2)
                auflisten();
            else if (option == 3)
                neuePlatte();
            else if (option != 0)
                System.out.println("ungültige Eingabe");
            */
            
            switch(option)
            {
            case 0: // Ende
                break;
                
            case 1:
                neuerContainer();
                break;
                
            case 2:
                auflisten();
                break;
                
            case 3:
                neuePlatte();
                break;
                
            case 4:
                kunde();
                break;
                
            case 5:
                lieferDatum();
                break;
                
            default:
                System.out.println("ungültige Eingabe");
                    
            }
        }
        

    }
    
    private void neuerContainer()
    {
        System.out.println("Daten für neuen Container");
        double laenge = Input.readDouble("Laenge: ");
        double breite = Input.readDouble("Breite: ");
        double gewicht = Input.readDouble("maximales Ladegewicht: ");
        
        if (laenge > 0 && breite > 0 && gewicht > 0)
        {
            aktuell = new Container(laenge, breite);
            aktuell.setMaximalesLadegewicht(gewicht);
        }
        else
            System.out.println("Länge, Breite und Gewicht müssen größer als 0 sein");
        
    }
    
    private void auflisten()
    {
        if (aktuell != null)
        {
            System.out.println("----------- aktueller Container ----------------");
            aktuell.ausgeben();
        }
        else
            System.out.println("kein Container vorhanden");
        
    }
    
    private void neuePlatte()
    {
        if (aktuell != null)
        {
            System.out.println("Daten für neue Platte");
            double laenge = Input.readDouble("Laenge: ");
            double breite = Input.readDouble("Breite: ");
            if (laenge > 0 && breite > 0)
            {
                Platte p = new Platte(laenge, breite);
                if (aktuell.aufladen(p))
                    System.out.println("Platte wurde aufgeladen");
                else
                    System.out.println("Platte konnte nicht aufgeladen werden");
            }
            else
                System.out.println("Länge und Breite der Platte müssen größer als 0 sein");
        }
        else
            System.out.println("bitte zuerst neuen Container anlegen!");
    }
        

    private void kunde()
    {
        if (aktuell != null)
        {
            String name = Input.readText("Name: ");
            String adresse = Input.readText("Adresse: ");
            if (name.length() > 0 && adresse.length() > 0)
            {
                Kunde k = new Kunde(name);
                k.setAdresse(adresse);
                aktuell.setKunde(k);
            }
            else
                System.out.println("Bitte Name UND Adresse eingeben");
        }
        else
            System.out.println("bitte zuerst Container anlegen");
            
    }
    
    private void lieferDatum()
    {
        if (aktuell != null)
        {
            int jahr = Input.readInt("Jahr: ");
            int monat = Input.readInt("Monat: ") - 1;  // Monat von 0 bis 11 
            int tag = Input.readInt("Tag: ");
            System.out.println(tag + "." + monat + "." + jahr);
            GregorianCalendar datum = new GregorianCalendar(jahr, monat, tag);
            GregorianCalendar heute = new GregorianCalendar();
            if (datum.compareTo(heute) >= 0)   // siehe JavaDoc
                aktuell.setLieferDatum(datum);
            else
                System.out.println("Lieferungen in der Vergangenheit sind nicht möglich");
                
            
        }
        else
            System.out.println("Bitte zuerst Container anlegen");
        
    }


}
