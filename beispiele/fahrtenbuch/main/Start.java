/*
 * Created on 09.04.2009
 *
 */
package fahrtenbuch.main;

import java.io.File;

import javax.swing.JFrame;

import fahrtenbuch.gui.Hauptfenster;
import fahrtenbuch.persistenz.FahrtenbuchDateianbindung;

public class Start
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        File datei = new File("fahrtenbuch.ser");
        FahrtenbuchDateianbindung dateiAnbindung = new FahrtenbuchDateianbindung(datei);
        Hauptfenster hf = new Hauptfenster(dateiAnbindung);
        hf.pack();
        hf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hf.setVisible(true);

    }

}
