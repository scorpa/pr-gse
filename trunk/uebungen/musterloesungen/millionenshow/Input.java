package millionenshow;
import java.io.*;

/**
 * @author (Rudolf Radlbauer) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Input
{
    public static int readInt(String prompt)
    {
        int x = 0;
        boolean ok = false;
        do
        {
            try
            {
                System.out.println(prompt);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                x = Integer.parseInt(reader.readLine());
                ok = true;
                
            } catch(Exception ex)
            {
                System.out.println("Fehlerhafte Eingabe");
            }
        } while (!ok);
        return x;
    }
}
