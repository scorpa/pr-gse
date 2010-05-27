/*
 * Created on 04.05.2009
 * noch nicht fertig
 */
package memory;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

public class MemoryImpl implements Memory
{
    private Feld[][] felder;
    private Feld feld1;
    private Feld feld2;
    private int zaehler;
    
    public MemoryImpl(int zeilen, int spalten) throws MemoryException
    {
        if ((zeilen * spalten) % 2 != 0)
            throw new MemoryException("ungerade Anzahl von Feldern ist nicht erlaubt");
        felder = new Feld[zeilen][spalten];
        ArrayList<Feld> liste = new ArrayList<Feld>();
        for (int i = 1; i <= zeilen * spalten / 2; i++)
        {
            liste.add(new Feld("/memory/bilder/bild" + i + ".jpeg"));
            liste.add(new Feld("/memory/bilder/bild" + i + ".jpeg"));
        }
        Collections.shuffle(liste); // durchmischen
        for (int z = 0; z < zeilen; z++)
            for (int s = 0; s < spalten; s++)
                felder[z][s] = liste.get(z * spalten + s);
        feld1 = null;
        feld2 = null;
        zaehler = 0;
    }


    public int getSpalten()
    {
        return felder[0].length;
    }


    public int getZeilen()
    {
        return felder.length;
    }
    
    public boolean fertig()
    {
        int gesamt = felder.length * felder[0].length;
        for (Feld[] reihe : felder)
            for (Feld f : reihe)
                if (f.getStatus() == 2)
                    gesamt--;
        return (gesamt == 0);
    }

    public ImageIcon getBild(int zeile, int spalte)
    {
        return felder[zeile][spalte].getIcon();
    }

    public int getStatus(int zeile, int spalte)
    {
        return felder[zeile][spalte].getStatus();
    }

    public boolean tipp(int zeile, int spalte)
    {
        Feld f = felder[zeile][spalte];
        if (f.getStatus() == 0)  // verdeckt
        {
            if (feld1 == null && feld2 == null)  // auch sonst nichts aufgedeckt
            {
                feld1 = f;
                f.setStatus(1);
            }
            else if (feld2 == null)  // 1 anderes Feld aufgedeckt
            {
                feld2 = f;
                if (feld1.getBildName().equals(feld2.getBildName()))
                {  // erraten
                    feld1.setStatus(2);
                    feld2.setStatus(2);
                    feld1 = null;
                    feld2 = null;
                }
                else
                    feld2.setStatus(1);
            }
            else  // bereits 2 aufgedeckt
            {
                // wieder umdrehen
                feld1.setStatus(0);
                feld2.setStatus(0);
                feld1 = f;
                f.setStatus(1);
                feld2 = null;
            }
            zaehler++;
            return true;
        }
        return false; // kann nicht aufgedeckt werden
    }

    public int tipps()
    {
        return zaehler;
    }

    
    /**
     * nur zum Testen
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            Memory m = new MemoryImpl(4,4);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
