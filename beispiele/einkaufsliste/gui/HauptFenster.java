package einkaufsliste.gui;

import einkaufsliste.fachlogik.EinkaufsListe;
import einkaufsliste.fachlogik.ProduktVerwaltung;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Rudolf Radlbauer
 */
public class HauptFenster extends JFrame
{
    private ProduktVerwaltung produkte;
    private EinkaufsListe liste;
    
    private DefaultListModel lmProdukte = new DefaultListModel();
    private JList jlProdukte = new JList(lmProdukte);
    private DefaultListModel lmEinkauf = new DefaultListModel();
    private JList jlEinkauf = new JList(lmEinkauf);
    private JButton bnAdd = new JButton("-->");
    private JButton bnDelete = new JButton("X");
    private SpinnerNumberModel snmAnzahl = new SpinnerNumberModel(1, 1, 100, 1);
    private JSpinner spAnzahl = new JSpinner(snmAnzahl);
    private JTextArea taAusgabe = new JTextArea();

    public HauptFenster(ProduktVerwaltung produkte, EinkaufsListe liste)
    {
        this.produkte = produkte;
        this.liste = liste;
        initFrame();
        initMenu();
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
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        JMenuItem oeffnen = new JMenuItem("oeffnen");
        mListe.add(oeffnen);
        oeffnen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        JMenuItem speichern = new JMenuItem("speichern");
        mListe.add(speichern);
        speichern.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        JMenuItem speichernUnter = new JMenuItem("speichern unter ...");
        mListe.add(speichernUnter);
        speichernUnter.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        JMenu mProdukte = new JMenu("Produkte");
        menubar.add(mProdukte);
        JMenuItem bearbeiten = new JMenuItem("bearbeiten");
        mProdukte.add(bearbeiten);
        bearbeiten.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });


    }


    // nur zum Testen
    public static void main(String[] args)
    {
        HauptFenster fenster = new HauptFenster(null, null);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.pack();
        fenster.setVisible(true);
    }

}
