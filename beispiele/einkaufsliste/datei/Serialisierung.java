
package einkaufsliste.datei;

import einkaufsliste.fachlogik.DateiAnbindung;
import einkaufsliste.fachlogik.EinkaufsListe;
import einkaufsliste.fachlogik.EinkaufsListeException;
import einkaufsliste.fachlogik.ProduktVerwaltung;
import einkaufsliste.fachlogik.ProduktVerwaltungImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Serialisierung implements DateiAnbindung
{

    public void speichern(ProduktVerwaltung produkte, File datei) throws EinkaufsListeException
    {
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(datei));
            out.writeObject(produkte);
            out.close();
        } catch (IOException ex)
        {
            ex.printStackTrace();
            throw new EinkaufsListeException("Fehler beim Speichern der Produkteliste");
        }
    }

    public void speichern(EinkaufsListe liste, File datei) throws EinkaufsListeException
    {
        try
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(datei));
			out.writeObject(liste);
			out.close();
		} catch (IOException e)
		{
			e.printStackTrace();
			throw new EinkaufsListeException("Fehler beim Speichern der Einkaufsliste");
		}
    }

    public ProduktVerwaltung ladeProdukte(File datei) throws EinkaufsListeException
    {
        ProduktVerwaltung verwaltung = null;
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(datei));
            verwaltung = (ProduktVerwaltung) in.readObject();
            in.close();
        } catch (FileNotFoundException ex)
        {
            verwaltung = new ProduktVerwaltungImpl();
        } catch(IOException ex)
        {
            ex.printStackTrace();
            throw new EinkaufsListeException("Fehler beim Laden der Produkteliste");
        } catch(ClassNotFoundException ex)
        {
        	ex.printStackTrace();
            throw new EinkaufsListeException("Fehler beim Deserialisieren der Produkteliste");
        }

        return verwaltung;
    }

    public EinkaufsListe ladeEinkaufsliste(File datei) throws EinkaufsListeException
    {
        EinkaufsListe liste = null;
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(datei));
            liste = (EinkaufsListe) in.readObject();
            in.close();
        } catch(IOException ex)
        {
            ex.printStackTrace();
            throw new EinkaufsListeException("Fehler beim Laden der Einkaufsliste");
        } catch(ClassNotFoundException ex)
        {
        	ex.printStackTrace();
            throw new EinkaufsListeException("Fehler beim Deserialisieren der Einkaufsliste");
        }

        return liste;    
    }

}
