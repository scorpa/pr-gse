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
            liste.add(new Feld("bild" + i));
            liste.add(new Feld("bild" + i));
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
        // TODO Auto-generated method stub
        return false;
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
        // TODO fertigstellen
        Feld f = felder[zeile][spalte];
        switch(f.getStatus())
        {
        case 0:  // verdeckt
            if (feld1 == null && feld2 == null)  // auch sonst nichts aufgedeckt
            {
                feld1 = f;
                f.setStatus(1);
            }
        }
        
        
        
        return false;
    }

    public int tipps()
    {
        return zaehler;
    }


}
