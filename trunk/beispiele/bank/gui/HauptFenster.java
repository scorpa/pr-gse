/*
 * Created on 17.03.2006
 *
 */
package bank.gui;

import bank.fachlogik.Konto;
import bank.fachlogik.KontoVerwaltung;
import bank.fachlogik.KontoVerwaltungException;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDesktopPane;
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
import javax.swing.JSplitPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bank.xml.XmlSupport;

/**
 * Hauptfenster der Applikation
 * 
 * @uml.dependency supplier="gui.KontoListModel"
 * @uml.dependency supplier="gui.KontoFenster"
 */
public class HauptFenster extends JFrame
{

    private KontoListModel model; // verwendete KontoVerwaltung
    private JDesktopPane desktop; // MDI-Bereich
    private JList kontoListe; // 
    private JLabel statusZeile; 
    private FensterController fensterController; // verwaltet die inneren
    

    // Fenster

    /**
     * Konstruktor macht aus der KontoVerwaltung ein KontoListModel baut die
     * Oberfläche zusammen instanziiert die Attribute
     */
    public HauptFenster(KontoVerwaltung verwaltung)
    {
        super("Spengerbank AG");
        try
        {
            model = new KontoListModel(verwaltung);
        } catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Fehler beim Initialisieren", JOptionPane.ERROR_MESSAGE);
            dispose();
        }

        initFrame();
        initMenu();
        kontenAuswaehlen();
        fensterController = new FensterController();

    }

    /**
     * baut die Oberfläche zusammen
     * 
     */
    private void initFrame()
    {
        desktop = new JDesktopPane();

        JSplitPane split = new JSplitPane();
        getContentPane().add(split, BorderLayout.CENTER);
        statusZeile = new JLabel();
        getContentPane().add(statusZeile, BorderLayout.SOUTH);
        statusZeile.setFont(new Font(null, Font.BOLD, 16));

        split.add(desktop, JSplitPane.RIGHT);
        kontoListe = new JList(model);
        kontoListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // lass
        // nur
        // einfache
        // Auswahl
        // zu
        kontoListe.setCellRenderer(new KontoCellRenderer()); // Darstellung
        // der Konten in
        // der Liste
        // (siehe unten)
        split.add(new JScrollPane(kontoListe), JSplitPane.LEFT);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // macht der
        // WindowListener
        // -> beenden()
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                beenden();
            }
        });

        // bearbeiten bei Doppel-Klick
        kontoListe.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 2)
                    bearbeiteKonto();
            }
        });

    }

    /**
     * baut das Menu zusammen
     * 
     */
    private void initMenu()
    {
        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);
        
        JMenu mKonto = new JMenu("Konto");
        mbar.add(mKonto);
        JMenuItem kontoNeu = new JMenuItem("neu");
        mKonto.add(kontoNeu);
        kontoNeu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                neuesKonto();
            }
        });
        JMenuItem kontoBearbeiten = new JMenuItem("bearbeiten");
        mKonto.add(kontoBearbeiten);
        kontoBearbeiten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                bearbeiteKonto();
            }
        });
        JMenuItem kontoLoeschen = new JMenuItem("löschen");
        mKonto.add(kontoLoeschen);
        kontoLoeschen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                loescheKonto();
            }
        });

        JMenu mUeberweisung = new JMenu("Überweisung");
        mbar.add(mUeberweisung);
        JMenuItem ueberweisen = new JMenuItem("durchführen");
        mUeberweisung.add(ueberweisen);
        ueberweisen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                ueberweisen();
            }
        });
        
        JMenu mAuswahl = new JMenu("Auswahl");
        mbar.add(mAuswahl);
        JMenuItem alle = new JMenuItem("alle Konten");
        mAuswahl.add(alle);
        alle.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                alleAuswaehlen();
            }});
        JMenuItem auswaehlen = new JMenuItem("Konten auswählen ...");
        mAuswahl.add(auswaehlen);
        auswaehlen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                kontenAuswaehlen();
            }});

        JMenu mXml = new JMenu("XML");
        mbar.add(mXml);
        JMenuItem export = new JMenuItem("exportieren");
        mXml.add(export);
        export.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                xmlExport();
            }});
        
        JMenuItem importieren = new JMenuItem("importieren");
        mXml.add(importieren);
        importieren.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                xmlImport();
            }});

    }
    
    private void alleAuswaehlen()
    {
        try
        {
            model.befuellen("");
            statusZeile.setText("alle Konten ausgewählt");
        } catch (KontoVerwaltungException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Fehler beim Auswählen der Kontos",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void kontenAuswaehlen()
    {
    	KontoAuswahlFenster auswahl = new KontoAuswahlFenster(this);
    	auswahl.setVisible(true);
        try
        {
            model.befuellen(auswahl.getFilter());
            if ("".equals(auswahl.getFilter()))
            	statusZeile.setText("alle Konten ausgewählt");
            else
            	statusZeile.setText("Konten beginnend mit \"" + auswahl.getFilter() + "\" ausgewählt");
        } catch (KontoVerwaltungException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Fehler beim Auswählen der Konten",
                    JOptionPane.ERROR_MESSAGE);
        }
    	
    }

    /**
     * wird aufgerufen, wenn ein neues Konto angelegt werden soll
     * 
     */
    private void neuesKonto()
    {
        try
        {
            // instanziiere neues KontoFenster und übergebe es dem Controller
            fensterController.oeffneFenster(new KontoFenster(model));
        } catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Fehler beim Anlegen eine neuen Kontos",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * wird aufgerufen, wenn ein Konto bearbeitet werden soll
     * 
     */
    private void bearbeiteKonto()
    {
        // zuerst muss herausgefunden werdne, welches Konto zu bearbeiten ist
        Konto konto = (Konto) kontoListe.getSelectedValue();
        if (konto != null)
        {
            KontoFenster kf = fensterController.getFenster(konto);
            if (kf == null)
            {
                fensterController.oeffneFenster(new KontoFenster(konto, model));
            } else
            {
                // ist bereits ein Fenster für dieses Konto offen, so ist nichts
                // zu tun
            }
        } else
            JOptionPane.showMessageDialog(this,
                    "Bitte Konto aus Liste auswählen!", "Konto bearbeiten",
                    JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * wird aufgerufen, wenn ein Konto gelöscht werden soll
     * 
     */
    private void loescheKonto()
    {
        // zuerst herausfinden, welches Konto ausgewählt ist
        Konto konto = (Konto) kontoListe.getSelectedValue();
        if (konto != null)
        {
            // Sicherheitsabfrage
            int option = JOptionPane.showConfirmDialog(this, "Konto Nr. "
                    + konto.getNummer() + " wirklich löschen?",
                    "Konto Löschen", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION)
            {
                try
                {
                    // entferne Konto aus der Verwaltung
                    model.entfernen(konto);
                    // falls ein Fenster für dieses Konto offen ist, muss es
                    // geschlossen werden
                    KontoFenster kf = fensterController.getFenster(konto);
                    if (kf != null)
                        kf.dispose();
                } catch (Exception e)
                {
                    JOptionPane.showMessageDialog(this, e.getMessage(),
                            "Konto " + konto.getNummer() + " löschen",
                            JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }

        } else
            JOptionPane.showMessageDialog(this,
                    "Bitte Konto aus Liste auswählen!", "Konto löschen",
                    JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * wird aufgerufen, wenn Programm beendet werden soll. Beendet Programm nur,
     * wenn alle Fenster geschlossen wurden.
     * 
     */
    private void beenden()
    {
        if (fensterController.getFensterAnzahl() == 0)
        {
            try
            {
                model.close();
            } catch (KontoVerwaltungException e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage(),
                        "Fehler beim beenden des Programms",
                        JOptionPane.ERROR_MESSAGE);
            }
            dispose();
        } else
            JOptionPane.showMessageDialog(this,
                    "Bitte zuerst alle Fenster schließen", "Programm beenden",
                    JOptionPane.ERROR_MESSAGE);

    }

    private void ueberweisen()
    {
        UeberweisungsFenster uf = new UeberweisungsFenster(model);
        desktop.add(uf);
        try
        {
            uf.setSelected(true);
        } catch (PropertyVetoException e)
        {
            e.printStackTrace();
        }
    }
    
    private void xmlExport()
    {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                new XmlSupport().exportieren(chooser.getSelectedFile(), model.getListe());
            } catch (KontoVerwaltungException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    private void xmlImport()
    {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                List<Konto> liste = new XmlSupport().importieren(chooser.getSelectedFile());
                for (Konto k : liste)
                    model.speichern(k);
            } catch (KontoVerwaltungException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, e.getMessage(), "Fehler beim Importieren eines Kontos", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    

    /**
     * Innere Klasse FensterController zum Verwalten der Inneren Fenster. Ist
     * gleichzeitig ein ListSelectionListener um auf Selektion in der Kontoliste
     * zu reagieren. Ist gleichzeitig ein Observer um auf Veränderungen in
     * Konto-Daten zu reagieren (Update in Liste)
     * 
     * @author Rudolf Radlbauer
     * 
     */
    private class FensterController extends InternalFrameAdapter implements
            ListSelectionListener, Observer
    {
        private Map<Konto, KontoFenster> kontoFensterListe; // Map zum Verwalten der Fenster

        /**
         * Konstruktor instanziiert die Map, fügt sich selbst als Listener bei
         * der Liste ein, um auf Selektion zu reagieren
         * 
         */
        public FensterController()
        {
            kontoFensterListe = new HashMap<Konto, KontoFenster>();
            kontoListe.addListSelectionListener(this);
        }

        /*
         * (non-Javadoc)
         * 
         * @see javax.swing.event.InternalFrameAdapter#internalFrameClosed(javax.swing.event.InternalFrameEvent)
         */
        @Override
        public void internalFrameClosed(InternalFrameEvent e)
        {
            KontoFenster kf = (KontoFenster) e.getSource();
            kontoFensterListe.remove(kf.getKonto());
            kf.getKonto().deleteObserver(this);
        }

        /**
         * sorgt dafür, dass das entsprechende Konto in der Liste ausgewählt
         * wird, wenn ein offenes Konto-Fenster selektiert wird
         */
        public void internalFrameActivated(InternalFrameEvent e)
        {
            Konto konto = ((KontoFenster) e.getSource()).getKonto();
            kontoListe.setSelectedValue(konto, true);
        }

        /**
         * fügt das übergebene KontoFenster in die DesktopPane ein und
         * regirstriert sich selbst als FrameListener bei diesem Fenster und als
         * Observer beim entsprechenden Konto. Nimmt außerdem das Fenster in die
         * Fensterverwaltung auf.
         * 
         * @param fenster
         *            KontoFenster, welches geöffnet werden soll
         */
        public void oeffneFenster(KontoFenster fenster)
        {
            kontoFensterListe.put(fenster.getKonto(), fenster); // aufnehmen in
            // Fensterverwaltung
            fenster.getKonto().addObserver(this);
            fenster.addInternalFrameListener(this);
            desktop.add(fenster);
            try
            {
                fenster.setSelected(true); // Fenster soll auch gleich
                // selektiert und im Vordergrund
                // sein
            } catch (PropertyVetoException ex)
            {
                ex.printStackTrace();
            }
        }

        /**
         * sorgt dafür, dass das zugehörige KontoFenster (falls existent) in den
         * Vordergrund gebracht wird, wenn in der Kontoliste ein Konto
         * ausgewählt wurde
         */
        public void valueChanged(ListSelectionEvent e)
        {
            // solange der Benutzer in der JList herumscrollt, kommt hier true
            if (!e.getValueIsAdjusting())
            {
                Konto k = (Konto) kontoListe.getSelectedValue();
                if (k != null)
                {
                    KontoFenster f = kontoFensterListe.get(k);
                    if (f != null)
                        try
                        {
                            f.setSelected(true);
                        } catch (PropertyVetoException ex)
                        {
                            ex.printStackTrace();
                        }
                }
            }
        }

        /**
         * liefert zum übergebenen Konto das zugehörige Fenster, falls eines
         * offen ist
         * 
         * @param k
         *            Konto, zu dem das Fenster gesucht wird
         * @return zugehöriges KontoFenster oder null, falls keines offen ist
         */
        public KontoFenster getFenster(Konto konto)
        {
            return kontoFensterListe.get(konto);
        }

        /**
         * liefert die Anzahl der offenen KontoFenster
         * 
         * @return Anzahl der offenen KontoFenster
         */
        public int getFensterAnzahl()
        {
            return kontoFensterListe.size();
        }

        /**
         * reagiert auf Änderungen in einem Konto -> Update der Liste
         */
        public void update(Observable o, Object arg)
        {
            kontoListe.repaint();

        }

    }

    /**
     * Innere Klasse für Darstellung der Konten in der Liste
     * 
     * @author Rudolf Radlbauer
     * 
     */
    private class KontoCellRenderer extends JPanel implements ListCellRenderer
    {
        private JLabel nummer = new JLabel();

        private JLabel besitzer = new JLabel();

        /**
         * Konstruktor baut das Layout auf (2spaltige Anzeige)
         * 
         */
        public KontoCellRenderer()
        {
            setLayout(new GridLayout(1, 2));
            add(nummer);
            add(besitzer);
        }

        /**
         * fügt die Daten ein und setzt Farben
         */
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus)
        {
            Konto konto = (Konto) value;
            nummer.setText(String.valueOf(konto.getNummer()));
            besitzer.setText(konto.getBesitzer());
            if (isSelected)
            {
                setBackground(list.getSelectionBackground());
                nummer.setForeground(list.getSelectionForeground());
                besitzer.setForeground(list.getSelectionForeground());
            } else
            {
                setBackground(list.getBackground());
                nummer.setForeground(list.getForeground());
                besitzer.setForeground(list.getForeground());
            }

            // für jede Zelle in der JList wir this geliefert (macht nichts,
            // weil dann von der Liste geklont)
            return this;
        }

    }

}
