package transport;

public class UI
{
    private Container aktuell;
    
    public UI()
    {
        int option = 0;
        
        while (option != 4)
        {
            System.out.println("1) neuer Container");
            System.out.println("2) Platten auflisten");
            System.out.println("3) Platte aufladen");
            System.out.println("4) beenden");
            
            option = Input.readInt("Ihre Auswahl: ");
        }
        
        if (option == 1)
            neuerContainer();
        else if (option == 2)
            auflisten();
        else if (option == 3)
            neuePlatte();
    }
    
    private void neuerContainer()
    {
        System.out.println("Daten für neuen Container");
        double laenge = Input.readDouble("Laenge: ");
        double breite = Input.readDouble("Breite: ");
        aktuell = new Container(laenge, breite);
        
    }
    
    private void auflisten()
    {
        // Ausgabe der Maße des Containers und aller Platten
        System.out.println("aktueller Container");
        
    }
    
    private void neuePlatte()
    {
        System.out.println("Daten für neue Platte");
        double laenge = Input.readDouble("Laenge: ");
        double breite = Input.readDouble("Breite: ");
        Platte p = new Platte(laenge, breite);
        if (aktuell.aufladen(p))
            System.out.println("Platte wurde aufgeladen");
        else
            System.out.println("Platte konnte nicht aufgeladen werden");
    }



}
