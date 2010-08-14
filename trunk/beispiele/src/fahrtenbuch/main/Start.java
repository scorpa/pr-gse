/*
 * Created on 09.04.2009
 *
 */
package fahrtenbuch.main;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fahrtenbuch.gui.Hauptfenster;
import fahrtenbuch.persistenz.FahrtenbuchDateianbindung;

/**
 * Projekt Fahrtenbuch
 * zum Starten des Programms
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Start
{

    /**
     * @param args Datei, in welcher das Fahrtenbuch gespeichert wird
     */
    public static void main(String[] args)
    {
        if (args.length == 1)
        {
            File datei = new File(args[0]);
            FahrtenbuchDateianbindung dateiAnbindung = new FahrtenbuchDateianbindung(datei);
            Hauptfenster hf = new Hauptfenster(dateiAnbindung);
            hf.pack();
            hf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            hf.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Start: java fahrtenbuch.main.Start <dateiname>", 
                    "Fahrtenbuch", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

}
