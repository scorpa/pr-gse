package tapete;

/**
 * Diese Klasse beinhaltet nur einen Teil der Aufgabenstellung!
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Tapete
{
    private int breite;
    private int hoehe;
    
    public Tapete(int breite, int hoehe)
    {
        // TODO: Überprüfungen fehlen
        this.breite = breite;
        this.hoehe = hoehe;
    }
    
    public void printMuster(int nr)
    {
        if (nr == 2)
        {
            int count = 0;
            int zeile = 0;
            while (zeile < hoehe)  // Zeilen von 0 bis hoehe-1
            {
                int spalte = 0;
                while (spalte < breite) // Spalten von 0 bis breite-1
                {
                    if (count %2 == 0)
                        System.out.print('*');
                    else
                        System.out.print('.');
                    count++;
                    spalte++;
                }
                System.out.println();
                zeile++;
            }
        }
        else if (nr == 7)
        {
            int anzahlZeichen = hoehe * breite;
            StringBuilder str = new StringBuilder();
            int prim = 1;
            int count = 0;
            while(str.length() < anzahlZeichen)
            {
                if (count %2 == 0)
                {
                    str.append(prim);
                    prim = nextPrim(prim);
                }
                else
                    str.append('.');
                count++;
            }
            
            int zeichen = 0;
            while (zeichen < str.length())
            {
                System.out.print(str.charAt(zeichen));
                if ((zeichen+1) % breite == 0)
                    System.out.println();
                zeichen++;
            }
        }
    }
    
    
    public int nextPrim(int aktPrim)
    {
        int zahl = aktPrim+1;
        while(true)
        {
            boolean prim = true;
            int teiler = 2;
            while(teiler < zahl && prim)
            {
                if (zahl % teiler == 0)
                    prim = false;
                teiler++;
            }
            if (prim)
                return zahl;
            
            zahl++;
        }
    }

}
