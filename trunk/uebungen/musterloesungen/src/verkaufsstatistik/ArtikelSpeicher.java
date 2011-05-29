
package verkaufsstatistik;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author Rudolf Radlbauer
 */
public class ArtikelSpeicher
{
    private String dateiname;

    public ArtikelSpeicher(String dateiname)
    {
        this.dateiname = dateiname;
    }

    public void speichern(List<Artikel> liste) throws IOException
    {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dateiname));
        out.writeObject(liste);
        out.close();
    }

    public List<Artikel> laden() throws IOException, ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(dateiname));
        List<Artikel> liste = (List<Artikel>) in.readObject();
        in.close();
        return liste;
    }
}
