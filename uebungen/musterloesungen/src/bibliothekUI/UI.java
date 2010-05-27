package bibliothekUI;

public class UI
{

    private BuchVerwaltung buecher;

    public UI()
    {
        buecher = new BuchVerwaltung();
    }
    
    public void run()
    {
        char option = ' ';

        while (option != '0')
        {
            System.out.println("============================================");
            System.out.println("n) neues Buch anlegen");
            System.out.println("l) Bücher auflisten");
            System.out.println("a) Buch ausmustern");
            System.out.println("e) entlehnte Bücher auflisten");
            System.out.println("v) verfügbare Bücher auflisten");
            System.out.println("1) entlehnen");
            System.out.println("2) zurückgeben");
            System.out.println("0) beenden");
            System.out.println("============================================");

            option = Input.readChar("Ihre Auswahl: ");

            if (option == 'n')
                neuesBuch();
            else if (option == 'l')
                auflisten();
            else if (option == 'a')
                ausmustern();
            else if (option == 'e')
                auflistenEntlehnt();
            else if (option == 'v')
                auflistenVerfuegbar();
            else if (option == '1')
                entlehnen();
            else if (option == '2')
                zurueckgeben();
            else if (option != '0')
                System.out.println("Ungültige Eingabe, bitte wählen sie eine gültige Option aus.");
        }
    }

    public void neuesBuch()
    {
        String isbn = Input.readText("ISBN-Nummer: ");
        String autor = Input.readText("Autor: ");
        String titel = Input.readText("Titel: ");
        String verlag = Input.readText("Verlag: ");
        int seitenanzahl = Input.readInt("Seitenzahl:");

        Buch b = new Buch(isbn);
        b.setAutor(autor);
        b.setTitel(titel);
        b.setVerlag(verlag);
        b.setSeiten(seitenanzahl);
        buecher.anlegen(b);
    }

    public void auflisten()
    {
        System.out.println("Anzahl Bücher gesamt: " + buecher.anzahl());
        if (buecher.anzahl() > 0)
            buecher.liste();
    }

    public void ausmustern()
    {
        String isbn = Input.readText("ISBN-Nummer:");

        Buch b = buecher.suchen(isbn);
        if (b != null)
            buecher.ausmustern(b);
        else
            System.out.println("Buch kann nicht gefunden werden");
    }

    public void auflistenEntlehnt()
    {
        System.out.println("Anzahl entlehnter Bücher: " + buecher.anzahlEntlehnt());
        if (buecher.anzahlEntlehnt() > 0)
            buecher.listeEntlehnt();
    }

    public void auflistenVerfuegbar()
    {
        System.out.println("Anzahl verfügbarer Bücher: " + buecher.anzahlVerfuegbar());
        if (buecher.anzahlVerfuegbar() > 0)
            buecher.listeVerfuegbar();
    }

    public void entlehnen()
    {
        String isbn = Input.readText("ISBN-Nummer:");
        Buch b = buecher.suchen(isbn);

        if (b != null)
        {
            if (b.getKunde() == null)
            {
                String name = Input.readText("Bitte den Kundennamen eintragen: ");
                b.entlehnen(name);
            } else
                System.out.println("Buch ist bereits entlehnt");
        } else
            System.out.println("Buch konnte nicht gefunden werden");
    }

    public void zurueckgeben()
    {
        String isbn = Input.readText("ISBN-Nummer:");
        Buch b = buecher.suchen(isbn);
        if (b != null)
        {
            if (b.getKunde() != null)
            {
                System.out.println("Kunde ist: " + b.getKunde());
                b.retour();
            }
            else
                System.out.println("Buch ist nicht entlehnt");
        }
        else
            System.out.println("Buch nicht gefunden");
    }
    
    
 

}
