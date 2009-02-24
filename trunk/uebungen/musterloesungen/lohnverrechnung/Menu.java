/*
 * Created on 22.02.2009
 *
 */
package lohnverrechnung;

/**
 * zeilenorientierte Benutzerschnittstelle
 * @author Rudolf Radlbauer
 *
 */
public class Menu
{
    private LohnVerrechnung lohnverrechnung;  // Lohnverrechnungs-Instanz

    /**
     * Im Konstruktor wird die Benutzerschnittstelle gestartet
     *
     */
    public Menu()
    {
        lohnverrechnung = new LohnVerrechnung();

        int option = -1;

        while (option != 0)
        {
            System.out.println();
            System.out.println("============= bitte ausw�hlen =================");
            System.out.println("0) beenden");
            System.out.println("1) neuer Mitarbeiter");
            System.out.println("2) Mitarbeiterdaten �ndern");
            System.out.println("3) Mitarbeiterliste");
            System.out.println("4) Mitarbeiterdaten anzeigen");
            System.out.println("5) Gehaltstabelle");
            System.out.println("================================================");
            option = Input.readInt("Ihre Auswahl: ");

            switch (option)
            {
            case 0:
                System.out.println("Auf Wiedersehen");
                break;
            case 1:
                neuerMitarbeiter();
                break;
            case 2:
                datenAendern();
                break;
            case 3:
                lohnverrechnung.liste();
                break;
            case 4:
                mitarbeiterDaten();
                break;
            case 5:
                lohnverrechnung.gehaltsTabelle();
                System.out.println("--------- Lohnkosten: " + lohnverrechnung.lohnkosten() + " ------------");
                break;

            default:
                System.out.println("ung�ltige Auswahl");
                break;

            }
        }
    }

    /**
     * Ausgeben der Mitarbeiterdaten
     *
     */
    private void mitarbeiterDaten()
    {
        int nr = Input.readInt("Mitarbeiternummer: ");
        Mitarbeiter m = lohnverrechnung.suchen(nr);
        if (m != null)
            m.ausgeben();  // jeder Mitarbeitertyp kann selbst seine Daten ausgeben
        else
            System.out.println("Kein Mitarbeiter mit dieser Mitarbeiternummer");
    }

    /**
     * �ndern der Mitarbeiterdaten
     *
     */
    private void datenAendern()
    {
        int nr = Input.readInt("Mitarbeiternummer: ");
        Mitarbeiter m = lohnverrechnung.suchen(nr);
        if (m != null)
            m.einlesen();  // jeder Mitarbeitertyp kann selbst seine Daten einlesen
        else
            System.out.println("Kein Mitarbeiter mit dieser Mitarbeiternummer");
    }

    /**
     * Anlegen eines neuen Mitarbeiters
     *
     */
    private void neuerMitarbeiter()
    {
        int nr = Input.readInt("Mitarbeiternummer: ");
        while (nr <= 0)
        {
            System.out.println("Mitarbeiternummer muss positiv sein");
            nr = Input.readInt("Mitarbeiternummer: ");
        }

        Mitarbeiter m = null;
        do
        {
            System.out.println("---------- Bitte ausw�hlen ---------");
            System.out.println("1) neuer Angestellter");
            System.out.println("2) neuer Arbeiter");
            System.out.println("3) neuer Vertreter");
            System.out.println("------------------------------------");
            int option = Input.readInt("Ihre Auswahl: ");

            // erstellen des richtigen Mitarbeitertyps
            switch (option)
            {
            case 1:
                m = new Angestellter(nr);
                break;
            case 2:
                m = new Arbeiter(nr);
                break;
            case 3:
                m = new Vertreter(nr);
                break;
            default:
                System.out.println("ung�ltige Auswahl");
            }

        } while (m == null);
        m.einlesen();  // jeder Mitarbeitertyp liest selbst seine Daten richtig ein
        lohnverrechnung.einstellen(m);  // der Mitarbeiter muss auch in die Lohnverrechnung aufgenommen werden.
    }

}
