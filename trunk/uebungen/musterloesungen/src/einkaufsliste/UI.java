/*
 * Created on 13.01.2009
 *
 */
package einkaufsliste;

public class UI
{
    private EinkaufsListe liste;
    
    public UI()
    {
        liste = new EinkaufsListe();
    }
    
    public void menu()
    {
        int option = -1;
        
        while (option != 0)
        {
            System.out.println("================================================");
            System.out.println("0) Beenden");
            System.out.println("1) Artikel einfügen");
            System.out.println("2) Artikel löschen");
            System.out.println("3) Einkaufsliste ausgeben");
            System.out.println("4) Anzahl ändern");
            System.out.println("================================================");
        
            option = Input.readInt("Bitte auswählen: ");
            
            switch(option)
            {
            case 0:
                System.out.println("Vielen  Dank!");
                break;
            
            case 1:
                einfuegen();
                break;
                
            case 2:
                loeschen();
                break;
                
            case 3:
                liste.liste();
                break;
                
            case 4:
                anzahl();
                break;

            default:
                System.out.println("Bitte Zahl von 0 bis 3 eingeben");
            }
        }
        
    }

    private void anzahl()
    {
        int position = Input.readInt("Position des Artikels: ");
        Artikel a = liste.getArtikel(position);
        if (a != null)
        {
            System.out.println(a.getBezeichnung() 
                    + " Preis: " + a.getPreis()
                    + " Anzahl: " + a.getAnzahl());
            int neu = Input.readInt("Neue Anzahl eingeben: ");
            if (neu > 0)
                a.setAnzahl(neu);
            else
                System.out.println("ungültige Anzahl");
        }
        else
            System.out.println("ungültige Position");
    }

    private void loeschen()
    {
        int position = Input.readInt("Position des Artikels: ");
        liste.weg(position);
    }

    private void einfuegen()
    {
        String bezeichnung = Input.readText("Bezeichnung: ");
        float preis = Input.readFloat("Einzelpreis: ");
        int anzahl = Input.readInt("Anzahl: ");
        if (bezeichnung.length() > 0 && preis > 0 && anzahl > 0)
        {
            Artikel a = new Artikel(bezeichnung);
            a.setPreis(preis);
            a.setAnzahl(anzahl);
            liste.dazu(a);
        }
        else
            System.out.println("Bitte Eingabe überprüfen");
        
    }

}
