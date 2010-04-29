package einkaufsliste.gui;

import einkaufsliste.datei.Serialisierung;
import einkaufsliste.fachlogik.DateiAnbindung;

/**
 *
 * @author Rudolf Radlbauer
 */
public class Start
{

    public static void main(String[] args)
    {
        DateiAnbindung dateiAnbindung = new Serialisierung();

        HauptFenster fenster = new HauptFenster(dateiAnbindung);
        fenster.setSize(800, 300);
        fenster.setVisible(true);


    }

}
