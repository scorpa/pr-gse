package verkaufsstatistik;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Main
{
    public static void main(String[] args)
    {
        try
        {
            List<Artikel> liste = new ArrayList<Artikel>();
            for (int i = 0; i < 3; i++)
            {
                ArtikelEingabe eingabe = new ArtikelEingabe();
                eingabe.setVisible(true);
                System.out.println(eingabe.getArtikel());
                liste.add(eingabe.getArtikel());
            }
            ArtikelSpeicher speicher = new ArtikelSpeicher("test.dat");
            speicher.speichern(liste);
            for (Artikel a : speicher.laden())
                System.out.println(a);
        } catch (Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
