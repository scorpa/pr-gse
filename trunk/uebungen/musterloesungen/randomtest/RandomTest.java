package randomtest;

import java.util.Random;

public class RandomTest
{
    private Random random;
    private int[] zahlen;
    
    /**
     * instanziiert das Array mit der übergebenen 
     * Größe
     * @param groesse der Wertebereich, der getestet wird
     */
    public RandomTest(int groesse)
    {
        zahlen = new int[groesse];
        random = new Random();
    }
    
    /**
     * generiert Zufallszahlen und zählt mit
     * @param anzahl so viele Zufallszahlen werden generiert
     */
    public void test(int anzahl)
    {
        for (int i = 0; i < anzahl; i++)
        {
            int z = random.nextInt(zahlen.length);
            zahlen[z]++;
        }
    }
    
    public void clear()
    {
        for (int i = zahlen.length-1; i >= 0; i--)
            zahlen[i] = 0;
    }
    
    
    public void strichListe()
    {
        for (int i = 0; i < zahlen.length; i++)
        {
            System.out.print(i + ": ");
            for (int j = 0; j < zahlen[i]; j++)
                System.out.print('|');
            System.out.println();
        }
    }
    
    
    public double berechneDurchschnitt()
    {
        double summe = 0;
        for (int i = 0; i < zahlen.length; i++)
            summe = summe + zahlen[i];
        return summe / zahlen.length;
    }
    
    // noch nicht fertig
    public int[] histogramm()
    {
        int[] histo = new int[maximum()+1];
        for (int i = 0; i < zahlen.length; i++)
        {
            int z = zahlen[i];
            histo[z]++;
            // histo[zahlen[i]]++;
        }
        return histo;
    }
    
    public int maximum()
    {
        int max = zahlen[0];
        for (int i = 1; i < zahlen.length; i++)
        {
            if (zahlen[i] > max)
                max = zahlen[i];
        }
        return max;
    }
    
    
}
