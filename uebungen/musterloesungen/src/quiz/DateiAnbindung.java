package quiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Rudolf Radlbauer
 */
public class DateiAnbindung
{
    private String datei;

    public DateiAnbindung(String datei)
    {
        this.datei = datei;
    }

    public List<Frage> lesen() throws IOException
    {
        BufferedReader input = new BufferedReader(new FileReader(datei));
        List<Frage> liste = new ArrayList<Frage>();
        String line;
        while((line = input.readLine()) != null)
        {
            if (!line.trim().isEmpty())
            {
                StringTokenizer tokens = new StringTokenizer(line, "|");
                Frage f = new Frage(Integer.parseInt(tokens.nextToken()));
                f.setFrage(tokens.nextToken());
                for (int i = 0; i < 4; i++)
                    f.setAntwort(i, tokens.nextToken());
                f.setRichtig(Integer.parseInt(tokens.nextToken()));
                liste.add(f);
            }
        }
        input.close();
        return liste;
    }

}
