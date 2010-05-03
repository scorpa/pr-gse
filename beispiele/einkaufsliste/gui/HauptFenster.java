package einkaufsliste.gui;

import einkaufsliste.fachlogik.EinkaufsListe;
import einkaufsliste.fachlogik.EinkaufsListeException;
import einkaufsliste.fachlogik.DateiAnbindung;
import einkaufsliste.fachlogik.EinkaufsListeImplement;
import einkaufsliste.fachlogik.Produkt;
import einkaufsliste.fachlogik.ProduktVerwaltung;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Hauptfenster der Einkaufsliste-Applikation
 * @author Rudolf Radlbauer
 */
public class HauptFenster extends JFrame
{
    private DateiAnbindung dateiAnbindung;  // für das Speichern und Laden
    private ProduktVerwaltung produkte;		// Referenz auf die verwendete ProduktVerwaltung
    private EinkaufsListe liste = new EinkaufsListeImplement();   // verwendete Einkaufsliste
    private boolean bearbeitet = false;  // müssen wir etwas speichern?
    private File datei;  // aktuell bearbeitete Datei
    
    private DefaultListModel lmProdukte = new DefaultListModel();   // Datenmodell für Produkteliste
    private JList jlProdukte = new JList(lmProdukte);
    private DefaultListModel lmEinkauf = new DefaultListModel();    // Datenmodell für Einkaufsliste
    private JList jlEinkauf = new JList(lmEinkauf);
    private JButton bnAdd = new JButton("-->");
    private JButton bnDelete = new JButton("<--");
    private SpinnerNumberModel snmAnzahl = new SpinnerNumberModel(1, 1, 100, 1);
    private JSpinner spAnzahl = new JSpinner(snmAnzahl);
    private JTextArea taAusgabe = new JTextArea();

    /**
     * Aufbau des Hauptfensters
     * @param dateiAnbindung Referenz auf die Implementierung der Dateianbindung
     */
    public HauptFenster(DateiAnbindung dateiAnbindung)
    {
        try
        {
            this.dateiAnbindung = dateiAnbindung;
            initFrame();  // Fenster zusammenbauen
            initMenu();   // Menu zusammenbauen
            // Die Produktliste wird immer in der Datei "produkte.dat" abgelegt
            produkte = dateiAnbindung.ladeProdukte(new File("produkte.dat"));
            aktualisieren();  // Listen und Eingabefelder aktualisieren
            // Wir wollen das Schließen des Fensters kontrollieren
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(WindowEvent e)
                {
                    exit();
                }

            });
        } catch (EinkaufsListeException ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    /**
     * wird aufgerufen, wenn das Hauptfenster geschlossen wird.
     * Zuerst werden eventuelle Änderungen gespeichert, dann wird das Programm beendet
     */
    private void exit()
    {
        try
        {
        	// Produktliste wird in jedem Fall gespeichert
            dateiAnbindung.speichern(produkte, new File("produkte.dat"));
            if (bearbeitet)  // gibt es Änderungen
            {
            	switch(JOptionPane.showConfirmDialog(this, "Änderungen speichern?"))
            	{
            	case JOptionPane.NO_OPTION:  // Benutzer will Änderungen verwerfen
            		System.exit(0);
            		
            	case JOptionPane.YES_OPTION: // Benutzer will Änderungen speichern
            		speichern();
            		if (!bearbeitet)
            			System.exit(0);
            		
            	case JOptionPane.CANCEL_OPTION:  // Benutzer will doch noch weitermachen
            		break;
            	}
            }
            else
            	System.exit(0);  // nichts zu speichern
        } catch (EinkaufsListeException ex)
        {
        	ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }


    /**
     * aktualisiert die Listen und Eingabefelder
     */
    private void aktualisieren()
    {
        try
        {
        	// aktualisiere Einkaufsliste
        	lmEinkauf.clear();
        	for (Produkt p : liste.liste())
        		lmEinkauf.addElement(p);
        	
        	// aktualisiere Produktliste
        	// (Die Produkte, welche in der Einkaufsliste sind, gehören nicht hinein)
            lmProdukte.clear();
            for (Produkt p : produkte.liste())
            {
            	if (!lmEinkauf.contains(p))
            		lmProdukte.addElement(p);
            }
            
            // aktualisiere das Ausgabefeld
            aktualisiereAusgabe();
             
            // Daten wurden geladen, daher keine Änderungen
            bearbeitet = false;
            
        } catch (EinkaufsListeException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    /**
     * aktualisiert das Ausgabefeld
     * @throws EinkaufsListeException
     */
    private void aktualisiereAusgabe() throws EinkaufsListeException
    {
        int anzahlProdukte = liste.anzahlProdukte();
        int anzahlBio = liste.anzahlBio();
        String gesamtPreis = String.format("%.2f", liste.gesamtPreis());
        
        StringBuilder txt = new StringBuilder("Gesamtpreis: ").append(gesamtPreis);
        txt.append("\nAnzahl Produkte: ").append(liste.anzahlProdukte());
        txt.append("\ndavon Bio-Produkte: ").append(anzahlBio);
        // Prozent kann man nur berechnen, falls überhaupt ein Produkt vorhanden ist
        if (anzahlProdukte > 0)
        	txt.append(" (").append(anzahlBio * 100 / anzahlProdukte).append("%)");
        taAusgabe.setText(txt.toString());
    }
    

    /**
     * Aufbau des Fensters
     */
    private void initFrame()
    {
        setLayout(new BorderLayout());
        JPanel center = new JPanel(new GridLayout(1, 3));
        add(center, BorderLayout.CENTER);

        center.add(new JScrollPane(jlProdukte));

        JPanel mitte = new JPanel();
        GridLayout grid = new GridLayout(0, 3);
        mitte.setLayout(grid);
        center.add(mitte);
        for (int i = 0; i < 4; i++)
            mitte.add(new JLabel());
        mitte.add(bnAdd);
        for (int i = 0; i < 5; i++)
            mitte.add(new JLabel());
        mitte.add(spAnzahl);
        for (int i = 0; i < 5; i++)
            mitte.add(new JLabel());
        mitte.add(bnDelete);
        for (int i = 0; i < 4; i++)
            mitte.add(new JLabel());

        center.add(new JScrollPane(jlEinkauf));

        taAusgabe.setRows(3);
        taAusgabe.setEditable(false);
        add(new JScrollPane(taAusgabe), BorderLayout.SOUTH);

        bnAdd.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                produktDazu();
            }
        });

        bnDelete.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                produktWeg();
            }
        });


        spAnzahl.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e)
            {
                anzahlNeu();
            }
        });

        jlEinkauf.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e)
            {
                auswahl();
            }
        });

    }
    
    /**
     * Aufbau des Menus
     */
    private void initMenu()
    {
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

        JMenu mListe = new JMenu("Liste");
        menubar.add(mListe);
        JMenuItem neu = new JMenuItem("neu");
        mListe.add(neu);
        neu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try
				{
					neueListe();
				} catch (EinkaufsListeException ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(HauptFenster.this, ex);				}
            	}
        });
        JMenuItem oeffnen = new JMenuItem("oeffnen");
        mListe.add(oeffnen);
        oeffnen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try
				{
					listeOeffnen();
				} catch (EinkaufsListeException ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(HauptFenster.this, ex);
				}
            }
        });
        JMenuItem speichern = new JMenuItem("speichern");
        mListe.add(speichern);
        speichern.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                try
				{
					speichern();
				} catch (EinkaufsListeException ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(HauptFenster.this, ex);
				}
            }
        });
        JMenuItem speichernUnter = new JMenuItem("speichern unter ...");
        mListe.add(speichernUnter);
        speichernUnter.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                try
				{
					speichernUnter();
				} catch (EinkaufsListeException ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(HauptFenster.this, ex);
				}
            }
        });

        JMenu mProdukte = new JMenu("Produkte");
        menubar.add(mProdukte);
        JMenuItem bearbeiten = new JMenuItem("bearbeiten");
        mProdukte.add(bearbeiten);
        bearbeiten.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                produkteBearbeiten();
            }
        });


    }

    /**
     * Eine neue Einkaufsliste wird angelegt.
     * Davor müssen eventuell Änderungen in der alten Liste gespeichert werden.
     * @throws EinkaufsListeException
     */
    private void neueListe() throws EinkaufsListeException
	{
		if (bearbeitet)  // muss etwas gespeichert werden?
		{
			switch(JOptionPane.showConfirmDialog(this, "Änderungen speichern?"))
			{
				case JOptionPane.YES_OPTION:  // Benutzer will speichern
					speichern();
					break;
					
				case JOptionPane.NO_OPTION: // Benutzer will Änderungen verwerfen
					break;
					
				case JOptionPane.CANCEL_OPTION: // Benutzer will alte Liste weiter bearbeiten
					return;
			}
		}
		liste = new EinkaufsListeImplement();  // neue Einkaufsliste
		lmEinkauf.clear();  
		datei = null;
		aktualisieren();
	}

    /**
     * Bestehende Einkaufsliste wird geöffnet
     * Davor müssen eventuelle Änderungen gespeichert werden
     * @throws EinkaufsListeException
     */
	private void listeOeffnen() throws EinkaufsListeException
	{
		if (bearbeitet)  // ist etwas zu speichern?
		{
			switch(JOptionPane.showConfirmDialog(this, "Änderungen speichern?"))
			{
			case JOptionPane.YES_OPTION:  // Benutzer will speichern
				speichern();
				break;
				
			case JOptionPane.NO_OPTION:   // Benutzer will Änderungen verwerfen
				break;
				
			case JOptionPane.CANCEL_OPTION:  // Benutzer will doch noch alte Liste bearbeiten
				return;
			}
		}
			
		// Auswahl der bestehenden Liste	
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)  // hat Benutzer tatsächlich ausgewählt?
		{
			datei = chooser.getSelectedFile();
			liste = dateiAnbindung.ladeEinkaufsliste(datei);
			aktualisieren();
		}
		
	}

	/**
	 * Speichern der aktuell bearbeiteten Einkaufsliste
	 * @throws EinkaufsListeException
	 */
	private void speichern() throws EinkaufsListeException
	{
		// Falls die Liste neu angelegt wurde, muss eine neue Datei ausgewählt werden
		if (datei == null)
			speichernUnter();
		else
		{  // andernfalls wird die geöffnete Datei aktualisiert
			dateiAnbindung.speichern(liste, datei);
			bearbeitet = false;
		}
		
	}

	/**
	 * Einkaufsliste wird in einer neuen Datei gespeichert
	 * @throws EinkaufsListeException
	 */
	private void speichernUnter() throws EinkaufsListeException
	{
		// Auswahl der Datei
		JFileChooser chooser = new JFileChooser();
		if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
		{
			datei = chooser.getSelectedFile();
			dateiAnbindung.speichern(liste, datei);
			bearbeitet = false;
		}		
	}

	/**
	 * ein Produkt wird in die Einkaufsliste eingefügt
	 */
	private void produktDazu()
    {
        Produkt p = (Produkt) jlProdukte.getSelectedValue();
        if (p != null)
        {
            try
            {
                lmProdukte.removeElement(p);
                lmEinkauf.addElement(p);
                jlEinkauf.setSelectedValue(p, true);
                liste.aufnehmen(p, 1);
                snmAnzahl.setValue(1);
                bearbeitet = true;
                aktualisiereAusgabe();
            } catch (EinkaufsListeException ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }

	/**
	 * ein Produkt wird aus der Einkaufsliste entfernt
	 */
    private void produktWeg()
    {
        Produkt p = (Produkt) jlEinkauf.getSelectedValue();
        if (p != null)
        {
            try
            {
                lmEinkauf.removeElement(p);
                liste.entfernen(p);
                lmProdukte.addElement(p);
                bearbeitet = true;
                aktualisiereAusgabe();
            } catch (EinkaufsListeException ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }

    /**
     * Ein Produkt der Einkaufsliste wird selektiert
     * Dabei muss der Spinner für die Anzahl angepasst werden
     */
    private void auswahl()
    {
        Produkt p = (Produkt) jlEinkauf.getSelectedValue();
        if (p != null)
        {
            try
            {
                snmAnzahl.setValue(liste.getAnzahl(p));
            } catch (EinkaufsListeException ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }

    /**
     * Die Anzahl für ein Produkt wurde verändert
     */
    private void anzahlNeu()
    {
        Produkt p = (Produkt) jlEinkauf.getSelectedValue();
        if (p != null)
        {
            try
            {
                liste.setAnzahl(p, snmAnzahl.getNumber().intValue());
                bearbeitet = true;
                aktualisiereAusgabe();
            } catch (EinkaufsListeException ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }

    }

    /**
     * öffnet den Dialog zum bearbeiten der Produkte.
     * Danach müssen die Listen aktualisiert werden.
     */
    private void produkteBearbeiten()
    {
        ProduktFenster pf = new ProduktFenster(produkte);
        pf.setVisible(true);
        aktualisieren();
        
    }

}
