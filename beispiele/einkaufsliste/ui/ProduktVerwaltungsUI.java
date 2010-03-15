

package einkaufsliste.ui;

import einkaufsliste.fachlogik.GESCHAEFT;
import einkaufsliste.fachlogik.LAND;
import einkaufsliste.fachlogik.Produkt;
import einkaufsliste.fachlogik.ProduktVerwaltung;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rudi
 */
public class ProduktVerwaltungsUI
{
    private ProduktVerwaltung verwaltung;

    public ProduktVerwaltungsUI(ProduktVerwaltung verwaltung)
    {
        this.verwaltung = verwaltung;
    }

    public boolean menu()
    {
        System.out.println();
        System.out.println("==========================");
        System.out.println("Bitte auswählen:");
        System.out.println("1) Produkt anlegen");
        System.out.println("2) Produkte auflisten");
        System.out.println("3) Produkt löschen");
        System.out.println("4) Programm beenden");
        System.out.println("==========================");
        int auswahl = Input.readInt("Ihre Auswahl: ");

        switch(auswahl)
        {
            case 1:
                neuesProdukt();
                break;

            case 2:
                auflisten();
                break;

            case 3:
                loeschen();
                break;

            case 4:
                System.out.println("Auf wiedersehen");
                break;

            default:
                System.out.println("ungültige Auswahl");
                break;
        }

        return (auswahl != 4);
    }


    public void run()
    {
        while(menu())
            ;
    }

    private void neuesProdukt()
    {
        String bezeichnung = Input.readText("Produktbezeichnung: ");
        System.out.println("Bitte Geschäft auswählen");
        for (GESCHAEFT g : GESCHAEFT.values())
            System.out.println("\t" + g);
        String g = Input.readText("Auswahl: ");
        GESCHAEFT geschaeft = GESCHAEFT.valueOf(g);
        float preis = Input.readFloat("Produktpreis: ");
        System.out.println("Bitte Herkunftsland auswählen");
        for (LAND l : LAND.values())
            System.out.println("\t" + l);
        String l = Input.readText("Auswahl: ");
        LAND land = LAND.valueOf(l);
        char b = Input.readChar("Bioprodukt (b) oder nicht (k): ");
        boolean bio = false;
        if (b == 'b')
            bio = true;

        Produkt produkt = new Produkt();
        produkt.setBezeichnung(bezeichnung);
        produkt.setGeschaeft(geschaeft);
        produkt.setHerkunft(land);
        produkt.setPreis(preis);
        produkt.setBio(bio);

        verwaltung.anlegen(produkt);
    }

    private void auflisten()
    {
        System.out.println("------ Produktliste ------");
        List<Produkt> liste = verwaltung.liste();
        for (Produkt p : liste)
            System.out.println(p.getBezeichnung());
        System.out.println("--------------------------");
        System.out.println();
    }

    private void loeschen()
    {
        String bezeichnung = Input.readText("Bezeichnung des Produkts: ");
        verwaltung.entfernen(bezeichnung);
    }
}
