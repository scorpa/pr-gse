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
 *
 * @author Rudolf Radlbauer
 */
public class HauptFenster extends JFrame
{
    private DateiAnbindung dateiAnbindung;
    private ProduktVerwaltung produkte;
    private EinkaufsListe liste = new EinkaufsListeImplement();
    private boolean bearbeitet = false;
    private File datei;
    
    private DefaultListModel lmProdukte = new DefaultListModel();
    private JList jlProdukte = new JList(lmProdukte);
    private DefaultListModel lmEinkauf = new DefaultListModel();
    private JList jlEinkauf = new JList(lmEinkauf);
    private JButton bnAdd = new JButton("-->");
    private JButton bnDelete = new JButton("<--");
    private SpinnerNumberModel snmAnzahl = new SpinnerNumberModel(1, 1, 100, 1);
    private JSpinner spAnzahl = new JSpinner(snmAnzahl);
    private JTextArea taAusgabe = new JTextArea();

    public HauptFenster(DateiAnbindung dateiAnbindung)
    {
        try
        {
            this.dateiAnbindung = dateiAnbindung;
            initFrame();
            initMenu();
            produkte = dateiAnbindung.ladeProdukte(new File("produkte.dat"));
            aktualisiereProduktListe();
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

    private void exit()
    {
        try
        {
            dateiAnbindung.speichern(produkte, new File("produkte.dat"));
            System.exit(0);
        } catch (EinkaufsListeException ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }


    private void aktualisiereProduktListe()
    {
        try
        {
            lmProdukte.clear();
            for (Produkt p : produkte.liste())
            {
            	if (!lmEinkauf.contains(p))
            		lmProdukte.addElement(p);
            }
        } catch (EinkaufsListeException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

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
                neueListe();
            }
        });
        JMenuItem oeffnen = new JMenuItem("oeffnen");
        mListe.add(oeffnen);
        oeffnen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                listeOeffnen();
            }
        });
        JMenuItem speichern = new JMenuItem("speichern");
        mListe.add(speichern);
        speichern.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                speichern();
            }
        });
        JMenuItem speichernUnter = new JMenuItem("speichern unter ...");
        mListe.add(speichernUnter);
        speichernUnter.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                speichernUnter();
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

    protected void neueListe()
	{
		if (bearbeitet)
		{
			switch(JOptionPane.showConfirmDialog(this, "Änderungen speichern?"))
			{
				case JOptionPane.YES_OPTION:
					speichern();
					break;
					
				case JOptionPane.NO_OPTION:
					break;
					
				case JOptionPane.CANCEL_OPTION:
					return;
			}
		}
		liste = new EinkaufsListeImplement();
		lmEinkauf.clear();
		bearbeitet = false;
		aktualisiereProduktListe();
	}

	protected void listeOeffnen()
	{
		// TODO Auto-generated method stub
		
	}

	protected void speichern() throws EinkaufsListeException
	{
		if (datei == null)
			speichernUnter();
		else
			dateiAnbindung.speichern(liste, datei);
		
	}

	protected void speichernUnter()
	{
		// TODO Auto-generated method stub
		
	}

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
            } catch (EinkaufsListeException ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }

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
            } catch (EinkaufsListeException ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }

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

    private void anzahlNeu()
    {
        Produkt p = (Produkt) jlEinkauf.getSelectedValue();
        if (p != null)
        {
            try
            {
                liste.setAnzahl(p, snmAnzahl.getNumber().intValue());
                bearbeitet = true;
            } catch (EinkaufsListeException ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }

    }

    private void produkteBearbeiten()
    {
        ProduktFenster pf = new ProduktFenster(produkte);
        pf.setVisible(true);
        aktualisiereProduktListe();
        
    }

}
