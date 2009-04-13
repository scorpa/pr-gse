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

/**
 * Projekt Fahrtenbuch
 * Dient zum Speichern und Laden eines Fahrtenbuches in einer serialisierten Datei
 * 
 * @author Rudolf Radlbauer
 *
 */
public class FahrtenbuchDateianbindung implements FahrtenbuchSpeicher
{
    private File datei;

    /**
     * Konstruktor bekommt die Datei als Parameter
     * @param datei Datei zum Laden/Speichern
     */
    public FahrtenbuchDateianbindung(File datei)
    {
        this.datei = datei;
    }
    
    /**
     * speichert das Fahrtenbuch in der Datei
     */
    public void speichern(Fahrtenbuch fahrtenbuch) throws FahrtenbuchException
    {
        ObjectOutputStream oos = null;
        try
        {
            oos = new ObjectOutputStream(new FileOutputStream(datei));
            oos.writeObject(fahrtenbuch);
        } catch (IOException e)
        {
            e.printStackTrace();
            throw new FahrtenbuchException("Fehler beim Speichern des Fahrtenbuches");
        }
        finally
        {
            if (oos != null)
                try
                {
                    oos.close();
                } catch (IOException e)
                {
                    // sollte normalerweise nicht auftreten
                    e.printStackTrace();
                }
        }
    }

    /**
     * lädt das Fahrtenbuch aus der Datei
     */
    public Fahrtenbuch laden() throws FahrtenbuchException
    {
        Fahrtenbuch fahrtenbuch = null;
        if (datei.exists())
        {
            ObjectInputStream ois = null;
            try
            {
                ois = new ObjectInputStream(new FileInputStream(datei));
                fahrtenbuch = (Fahrtenbuch) ois.readObject();
            } catch (IOException e)
            {
                e.printStackTrace();
                throw new FahrtenbuchException("Fehler beim Laden des Fahrtenbuches");
            } catch (ClassNotFoundException e)
            {
                e.printStackTrace();
                throw new FahrtenbuchException("Fehler beim Laden der Klasse Fahrtenbuch");
            }
            finally
            {
                if (ois != null)
                    try
                    {
                        ois.close();
                    } catch (IOException e)
                    {
                        // sollte normalerweise nicht auftreten
                        e.printStackTrace();
                    }
            }
            
        } 
        else
            fahrtenbuch = new Fahrtenbuch();

        return fahrtenbuch;
    }
    
    
    

}
