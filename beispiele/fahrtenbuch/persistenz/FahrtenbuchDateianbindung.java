/*
 * Created on 09.04.2009
 *
 */
package fahrtenbuch.persistenz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import fahrtenbuch.fachlogik.Fahrtenbuch;
import fahrtenbuch.fachlogik.FahrtenbuchException;
import fahrtenbuch.fachlogik.FahrtenbuchSpeicher;

public class FahrtenbuchDateianbindung implements FahrtenbuchSpeicher
{
    private File datei;
    private Fahrtenbuch fahrtenbuch;
    
    public FahrtenbuchDateianbindung(File datei)
    {
        super();
        this.datei = datei;
        
        if (datei.exists())
        {
            ObjectInputStream ois = null;
            try
            {
                ois = new ObjectInputStream(new FileInputStream(datei));
                fahrtenbuch = (Fahrtenbuch) ois.readObject();
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            finally
            {
                if (ois != null)
                    try
                    {
                        ois.close();
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
            }
            
        }
        else
            fahrtenbuch = new Fahrtenbuch();
    }
    
    public void speichern() throws FahrtenbuchException
    {
        ObjectOutputStream oos = null;
        try
        {
            oos = new ObjectOutputStream(new FileOutputStream(datei));
            oos.writeObject(fahrtenbuch);
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            if (oos != null)
                try
                {
                    oos.close();
                } catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }

    public Fahrtenbuch getFahrtenbuch()
    {
        return fahrtenbuch;
    }
    
    
    

}
