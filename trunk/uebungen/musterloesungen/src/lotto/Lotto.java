package lotto;

import java.util.Random;

/**
 * �bungsbeispiel willnix.spengergasse.at
 * - gse - 08_Array_Medium - 
 * @author Rudolf Radlbauer
 *
 */
public class Lotto
{
    private boolean[] zahlen;
    private Random rnd;
    
    public Lotto()
    {
        // es gibt 45 Zahlen
        zahlen = new boolean[45];
        reset();
        rnd = new Random();
    }
    
    // Hilfsmethode
    private void reset()
    {
        for (int i = 0; i < zahlen.length; i++)
            zahlen[i] = false;        
    }
    
    public void ziehen(int anz)
    {
        if (anz > 0 && anz <= zahlen.length)
        {
            reset(); // alle auf false zur�cksetze, sonst k�nnten wir in eine Endlosschleife laufen.
            for (int i = 0; i < anz; i++)  // anz Mal
            {
                boolean neu = false;
                // hier ben�tigt man eine while-Schleife:
                // solange die Bedingung in den runden Klammern
                // erf�llt ist, wird alles in den geschwungenen
                // Klammern ausgef�hrt
                while (!neu)  // solange keine neue Zahl gezogen wurde
                {
                    int z = rnd.nextInt(zahlen.length);
                    if (zahlen[z] == false)
                    {
                        zahlen[z] = true;
                        neu = true;
                    }
                }
            }
        }
        else
            System.out.println("ung�ltige Anzahl: " + anz);
        
    }
    
    public void ziehen()
    {
        ziehen(6);
    }
    
    public void ausgeben()
    {
        for (int i = 0; i < zahlen.length; i++)
        {
            if (zahlen[i])
                System.out.print((i+1) + " ");  // Index geht von 0 bis 44, wir wollen von 1 bis 45 => +1
        }
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        Lotto l = new Lotto();
        for (int i = 0; i < 10; i++)
        {
            l.ziehen();
            l.ausgeben();
        }
        
    }

}
