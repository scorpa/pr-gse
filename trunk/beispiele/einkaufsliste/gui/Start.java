package einkaufsliste.gui;

import einkaufsliste.datei.Serialisierung;
import einkaufsliste.fachlogik.DateiAnbindung;
import einkaufsliste.fachlogik.EinkaufsListe;
import einkaufsliste.fachlogik.EinkaufsListeException;
import einkaufsliste.fachlogik.EinkaufsListeImplement;
import einkaufsliste.fachlogik.ProduktListe;
import einkaufsliste.fachlogik.ProduktVerwaltung;
import einkaufsliste.fachlogik.ProduktVerwaltungImpl;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

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
