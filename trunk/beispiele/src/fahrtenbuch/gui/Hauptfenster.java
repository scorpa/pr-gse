/*
 * Created on 07.04.2009
 *
 */
package fahrtenbuch.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import fahrtenbuch.fachlogik.Abrechnung;
import fahrtenbuch.fachlogik.Ausgabe;
import fahrtenbuch.fachlogik.Fahrer;
import fahrtenbuch.fachlogik.Fahrt;
import fahrtenbuch.fachlogik.Fahrtenbuch;
import fahrtenbuch.fachlogik.FahrtenbuchException;
import fahrtenbuch.fachlogik.FahrtenbuchSpeicher;
import fahrtenbuch.fachlogik.Kostenpunkt;
import fahrtenbuch.fachlogik.Tankstop;

/**
 * Projekt Fahrtenbuch
 * Hauptfenster der Applikation 
 * 
 * @author Rudolf Radlbauer
 *
 */
@SuppressWarnings("serial") // wird icht serialisiert
public class Hauptfenster extends JFrame
{
    private FahrtenbuchSpeicher speicher;  // Referenz auf die Speicher-Klasse
    private Fahrtenbuch fahrtenbuch;  // Rererenz auf das Fahrtenbuch (wird von Speicher-Klasse angefordert)
    
    private JComboBox cbFahrer;
    private DefaultListModel lmFahrten;
    private DefaultListModel lmKosten;
    private JList jlFahrten;
    private JList jlKosten;
    
    /**
     * Der Konstruktor holt sich von der Speicher-Klasse das Fahrtenbuch und baut dann das Hauptfenster auf.
     * Beim Schließen des Fensters wird ende() aufgerufen
     * @param speicher
     */
    public Hauptfenster(FahrtenbuchSpeicher speicher)
    {
        this.speicher = speicher;
        try
        {
            this.fahrtenbuch = speicher.laden();
        } catch (FahrtenbuchException e1)
        {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this, e1.getMessage(), "Fehler beim Laden des Fahrtenbuchs",
                    JOptionPane.ERROR_MESSAGE);
        }
        initFrame();
        initMenu();
        updateFenster();
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                ende();
            }});
    }
    
    /**
     * holt die Daten vom Fahrtenbuch und füllt die Listen
     *
     */
    private void updateFenster()
    {
        lmFahrten.removeAllElements();
        lmKosten.removeAllElements();
        fahrtenbuch.sortFahrten();
        fahrtenbuch.sortKosten();
        
        Iterator<Fahrt> fit = fahrtenbuch.fahrtenIterator();
        while (fit.hasNext())
            lmFahrten.addElement(fit.next());
        Iterator<Kostenpunkt> kit = fahrtenbuch.kostenIterator();
        while (kit.hasNext())
            lmKosten.addElement(kit.next());
        cbFahrer.removeAllItems();
        for (Fahrer f : fahrtenbuch.alleFahrer())
            cbFahrer.addItem(f);
    }
    
    /**
     * baut das Fenster auf.
     *
     */
    private void initFrame()
    {
        cbFahrer = new JComboBox();
        lmFahrten = new DefaultListModel();
        lmKosten = new DefaultListModel();
        jlFahrten = new JList(lmFahrten);
        jlFahrten.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlKosten = new JList(lmKosten);
        jlKosten.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        setLayout(new BorderLayout());
        
        // Nord-Panel für die Combobox (Fahrer)
        JPanel north = new JPanel();
        add(north, BorderLayout.NORTH);
        north.setLayout(new FlowLayout());
        north.add(new JLabel("Fahrer/in"));
        north.add(cbFahrer);
        
        // Center-Panel -- wird weiter unterteilt
        JPanel center = new JPanel();
        add(center, BorderLayout.CENTER);
        GridLayout centerLayout = new GridLayout(1,2);
        centerLayout.setHgap(20);
        center.setLayout(centerLayout);
        
        // linker Teil von Center-Panel für Fahrten-Liste und zugehörige Buttons
        JPanel centerLeft = new JPanel();
        center.add(centerLeft);
        centerLeft.setLayout(new BorderLayout());
        centerLeft.add(new JLabel("Fahrten"), BorderLayout.NORTH);
        centerLeft.add(new JScrollPane(jlFahrten), BorderLayout.CENTER);

        // rechter Teil von Center-Panel für Kosten-Liste und zugehörige Buttons
        JPanel centerRight = new JPanel();
        center.add(centerRight);
        centerRight.setLayout(new BorderLayout());
        centerRight.add(new JLabel("Kosten"), BorderLayout.NORTH);
        centerRight.add(new JScrollPane(jlKosten), BorderLayout.CENTER);
        
        // Buttons zur Fahrten-Liste
        JPanel buttonsLeft = new JPanel();
        buttonsLeft.setLayout(new GridLayout(10,1));
        centerLeft.add(buttonsLeft, BorderLayout.EAST);
        JButton neueFahrt = new JButton("NEU");
        JButton fahrtBearbeiten = new JButton("BEARBEITEN");
        JButton fahrtLoeschen = new JButton("LÖSCHEN");
        for (int i = 0; i < 3; i++)
            buttonsLeft.add(new JLabel());
        buttonsLeft.add(neueFahrt);
        buttonsLeft.add(fahrtBearbeiten);
        buttonsLeft.add(fahrtLoeschen);
        
        
        // Buttons zur Kosten-Liste
        JPanel buttonsRight = new JPanel();
        buttonsRight.setLayout(new GridLayout(10,1));
        centerRight.add(buttonsRight, BorderLayout.EAST);
        JButton tankstop = new JButton("Tankstop");
        JButton ausgabe = new JButton("Ausgabe");
        JButton kostenBearbeiten = new JButton("BEARBEITEN");
        JButton kostenLoeschen = new JButton("LÖSCHEN");
        for (int i = 0; i < 3; i++)
            buttonsRight.add(new JLabel());
        buttonsRight.add(tankstop);
        buttonsRight.add(ausgabe);
        buttonsRight.add(kostenBearbeiten);
        buttonsRight.add(kostenLoeschen);
        
        // Einhängen der Event-Handler
        neueFahrt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                neueFahrt();
            }});
        
        fahrtBearbeiten.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                fahrtBearbeiten();
            }});

        fahrtLoeschen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                fahrtLoeschen();
            }});
        
        tankstop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                tankstop();
            }});
        
        ausgabe.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                ausgabe();
            }});
        
        kostenBearbeiten.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                kostenBearbeiten();
            }});
        
        kostenLoeschen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                kostenLoeschen();
            }});
        
    }
    

    /**
     * baut die Menüs auf
     *
     */
    private void initMenu()
    {
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu datei = new JMenu("Datei");
        menubar.add(datei);
        JMenuItem ende = new JMenuItem("beenden");
        datei.add(ende);
        
        JMenu abrechnung = new JMenu("Abrechnung");
        menubar.add(abrechnung);
        JMenuItem einzelAbrechnungen = new JMenuItem("für jeden Fahrer");
        abrechnung.add(einzelAbrechnungen);
        
        // Einhängen der Event-Handler
        ende.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                ende();
            }});        

        einzelAbrechnungen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				new AbrechnungsFenster(fahrtenbuch);
			}});
    }



	// =================== event handler Methoden ==============================
    /**
     * beim Beenden der Applikation wird gespeichert
     */
    private void ende()
    {
        try
        {
            speicher.speichern(fahrtenbuch);
        } catch (FahrtenbuchException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(), "Fehler beim Speichern", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }

    /**
     * löschen eines Kostenpunktes
     *
     */
    private void kostenLoeschen()
    {
        Object kosten = jlKosten.getSelectedValue();
        if (kosten != null)
        {
            lmKosten.removeElement(kosten);
            fahrtenbuch.remove((Kostenpunkt) kosten);
        }
        else
            JOptionPane.showMessageDialog(this, "Bitte einen Kostenpunkt auswählen", 
                    "Kosten löschen", JOptionPane.INFORMATION_MESSAGE);
        }

    /**
     * bearbeiten eines Kostenpunktes
     *
     */
    private void kostenBearbeiten()
    {
        Object auswahl = jlKosten.getSelectedValue();
        if (auswahl != null)
        {
            KostenpunktFenster fenster = null;
            if (auswahl instanceof Tankstop)  // Tankstop war ausgewählt
            {
                TankstopFenster dialog = new TankstopFenster(this, (Tankstop)auswahl);
                fenster = dialog;
                dialog.setVisible(true);
            }
            else if (auswahl instanceof Ausgabe)  // Ausgabe war ausgewählt
            {
                AusgabeFenster dialog = new AusgabeFenster(this, (Ausgabe)auswahl);
                fenster = dialog;
                dialog.setVisible(true);
            }
            if (fenster != null && fenster.isOk())
            {
                jlKosten.repaint();  // Liste neu zeichnen
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Bitte einen Kostenpunkt auswählen", 
                    "Kosten bearbeiten", JOptionPane.INFORMATION_MESSAGE);
        
    }

    /**
     * neue Ausgabe
     *
     */
    private void ausgabe()
    {
        try
        {
            Ausgabe a = new Ausgabe();
            a.setFahrer((Fahrer) cbFahrer.getSelectedItem());
            AusgabeFenster dialog = new AusgabeFenster(this, a);
            dialog.setVisible(true);
            if (dialog.isOk())
            {
                lmKosten.addElement(a);
                fahrtenbuch.add(a);
            }
        
        } catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * neuer Tankstop
     *
     */
    private void tankstop()
    {
        try
        {
            Tankstop t = new Tankstop();
            t.setFahrer((Fahrer) cbFahrer.getSelectedItem());
            TankstopFenster dialog = new TankstopFenster(this, t);
            dialog.setVisible(true);
            if (dialog.isOk())
            {
                lmKosten.addElement(t);
                fahrtenbuch.add(t);
            }
        } catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }    
    }

    /**
     * eine Fahrt bearbeiten
     *
     */
    private void fahrtBearbeiten()
    {
        Fahrt fahrt = (Fahrt) jlFahrten.getSelectedValue();
        if (fahrt != null)
        {
            FahrtFenster dialog = new FahrtFenster(this, fahrt);
            dialog.setVisible(true);
            if (dialog.isOk())
            {
                jlFahrten.repaint();  // Liste neu zeichnen
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Bitte eine Fahrt auswählen", 
                    "Fahrt bearbeiten", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * eine Fahrt löschen
     *
     */
    private void fahrtLoeschen()
    {
        Object fahrt = jlFahrten.getSelectedValue();
        if (fahrt != null)
        {
            lmFahrten.removeElement(fahrt);
            fahrtenbuch.remove((Fahrt) fahrt);
        }
        else
            JOptionPane.showMessageDialog(this, "Bitte eine Fahrt auswählen", 
                    "Fahrt löschen", JOptionPane.INFORMATION_MESSAGE);
    }


    /**
     * neue Fahrt eingeben
     *
     */
    private void neueFahrt()
    {
        try
        {
            Fahrt fahrt = new Fahrt();
            fahrt.setFahrer((Fahrer) cbFahrer.getSelectedItem());
            FahrtFenster dialog = new FahrtFenster(this, fahrt);
            dialog.setVisible(true);
            while (dialog.isOk())
            {
            	try
            	{
            		fahrtenbuch.add(fahrt);
                    lmFahrten.addElement(fahrt);
            		break;   // gespeichert
            	} catch(FahrtenbuchException fe)
            	{
            		JOptionPane.showMessageDialog(this, fe.getMessage());
            		dialog = new FahrtFenster(this, fahrt);
            		dialog.setVisible(true);
            	}
            }
        } catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }
        


    
    
    
    
    //================== Delegates für Fahrtenbuch ============================
    

    /**
     * wird von Dialogen für Fahrt- bzw. Kosteneingabe benötigt
     */
    public Fahrer[] alleFahrer()
    {
        return fahrtenbuch.alleFahrer();
    }

}
