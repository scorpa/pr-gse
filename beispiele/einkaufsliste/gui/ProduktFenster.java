
package einkaufsliste.gui;

import einkaufsliste.fachlogik.EinkaufsListeException;
import einkaufsliste.fachlogik.ProduktVerwaltung;
import einkaufsliste.fachlogik.GESCHAEFT;
import einkaufsliste.fachlogik.LAND;

import einkaufsliste.fachlogik.Produkt;
import einkaufsliste.fachlogik.ProduktVerwaltungImpl;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Fenster zum Verwalten der Produkte in der ProduktVerwaltung
 * @author Rudolf Radlbauer
 */
public class ProduktFenster extends JDialog implements ActionListener, ListSelectionListener
{
    // Instanz meiner Produktverwaltung
    private ProduktVerwaltung verwaltung;
    // Produkt, welches ich gerade bearbeite
    private Produkt inBearbeitung;

    // Eingabe-Elemente
    private JList jlProdukte;
    private DefaultListModel lmProdukte;
    private JTextField tfBezeichnung = new JTextField();
    private JTextField tfPreis = new JTextField();
    private JComboBox cbGeschaeft;
    private JComboBox cbHerkunft;
    private JRadioButton rbBio = new JRadioButton("ja");
    private JRadioButton rbNoBio = new JRadioButton("nein");
    private JButton bnNeu = new JButton("NEU");
    private JButton bnSpeichern = new JButton("SPEICHERN");
    private JButton bnLoeschen = new JButton("LOESCHEN");


    /**
     * Der Konstruktor bekommt als Parameter eine Referenz auf die Produktverwaltung,
     * mit der wir arbeiten
     * @param verwaltung
     */
    public ProduktFenster(ProduktVerwaltung verwaltung)
    {
        setModal(true);
        this.verwaltung = verwaltung;
        initFrame();  // Fenster aufbauen
        try
        {   // Produktliste befüllen
            for (Produkt p : verwaltung.liste())
                lmProdukte.addElement(p);
            // vorerst gehen wir davon aus, dass ein neues Produkt bearbeitet wird
            inBearbeitung = new Produkt();
            updatePanel(); // neues Produkt in Eingabefeldern anzeigen
        } catch (Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    /**
     * baut das Fenster zusammen
     */
    private void initFrame()
    {
        // SplitPane mit linkem und rechtem Teil
        JSplitPane split = new JSplitPane();
        split.setDividerLocation(150);
        add(split);

        // Produktliste
        lmProdukte = new DefaultListModel();
        jlProdukte = new JList(lmProdukte);
        split.add(new JScrollPane(jlProdukte), JSplitPane.LEFT);

        // rechter Teil des Fensters
        JPanel rechts = new JPanel();
        split.add(rechts, JSplitPane.RIGHT);
        rechts.setLayout(new GridLayout(0, 2));

        // Produktbezeichnung
        rechts.add(new JLabel("Bezeichnung"));
        rechts.add(tfBezeichnung);

        // Produktpreis
        rechts.add(new JLabel("Preis"));
        rechts.add(tfPreis);

        // Geschäft
        rechts.add(new JLabel("Geschäft"));
        cbGeschaeft = new JComboBox(GESCHAEFT.values());
        rechts.add(cbGeschaeft);

        // Bioprodukt oder nicht
        rechts.add(new JLabel("Bioprodukt"));
        JPanel janein = new JPanel(new FlowLayout()); // eigenes kleines Panel
        rechts.add(janein);
        janein.add(rbBio);
        janein.add(rbNoBio);
        rbBio.setSelected(true);
        // Die ButtonGroup verbindet die Radiobuttons zu einer Logischen Einheit
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbBio);
        bg.add(rbNoBio);

        // Herkunft des Produkts
        rechts.add(new JLabel("Herkunft"));
        cbHerkunft = new JComboBox(LAND.values());
        rechts.add(cbHerkunft);

        // Buttons
        rechts.add(bnLoeschen);
        rechts.add(bnSpeichern);
        rechts.add(bnNeu);
        
        bnLoeschen.addActionListener(this);
        bnNeu.addActionListener(this);
        bnSpeichern.addActionListener(this);
        jlProdukte.addListSelectionListener(this);
    }

    /**
     * Das Produktfenster ist gleichzeitig ein ActionListener, welcher bei
     * allen Buttons registriert ist (siehe initFrame()).
     * Die Methode actionPerformed kommt dran, wenn ein Button geklickt wurde.
     *
     * @param e Referenz auf das ActionEvent-Objekt
     */
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if (e.getSource() == bnNeu)
                neu();  // neues Produkt
            else if (e.getSource() == bnSpeichern)
                speichern(); // produkt speichern
            else if (e.getSource() == bnLoeschen) // Produkt löschen
            {
                // ist überhaupt ein Produkt ausgewählt
                if (jlProdukte.getSelectedValue() != null)
                {
                    // Sicherheitsabfrage
                    if (JOptionPane.showConfirmDialog(this, "Sind Sie sicher",
                            "Produkt löschen", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    {
                        // entferne Produkt sowohl von der Verwaltung als auch von der Liste
                        Produkt p = (Produkt) jlProdukte.getSelectedValue();
                        verwaltung.entfernen(p);
                        lmProdukte.removeElement(p);
                        jlProdukte.clearSelection();
                    }
                }
                else
                    JOptionPane.showMessageDialog(this, "bitte zuerst ein Produkt auswählen");
            }
            
        } catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    /**
     * Das Produktfenster ist gleichzeitig ein ListSelectionListener, welcher bei
     * der Produktliste registriert ist (siehe initFrame())
     * Die Methode kommt dran, wenn sich in der Produktliste die Auswahl ändert.
     *
     * @param e Referenz auf den ListSelectionEvent
     */
    public void valueChanged(ListSelectionEvent e)
    {
        if (e.getValueIsAdjusting()) // falls die Auswahländerung noch nicht fertig
            return;
        // Überprüfe, ob der Event von der Produktliste kommt, und ob irgend etwas
        // ausgewählt wurde (Event kommt auch, wenn Auswahl aufgehoben wird)
        if (e.getSource() == jlProdukte && jlProdukte.getSelectedValue() != null)
        {
            try
            {
                // ist das aktuell bearbeitete Produkt verändert worden? - Dann
                // müssen wir diese Änderungen eventuell speichern.
                if (checkForChanges())
                {
                    switch (JOptionPane.showConfirmDialog(this, "Änderungen speichern?"))
                    {
                        case JOptionPane.YES_OPTION: // Benutzer will speichern
                            speichern();
                            break;

                        case JOptionPane.CANCEL_OPTION:  // Benutzer will Auswahländerung abbrechen
                            // in diesem Fall heben wir die Selektion einfach auf.
                            jlProdukte.clearSelection();
                            return;

                        case JOptionPane.NO_OPTION: // Benutzer will nicht speichern
                            break;
                    }
                }
                // falls nun ein Produkt ausgewählt ist, setzen wir dieses als das
                // aktuell bearbeitete Produkt ein
                Produkt p = (Produkt) jlProdukte.getSelectedValue();
                if (p != null)
                    inBearbeitung = p;
                // und übernehmen die Werte in die Eingabefelder
                updatePanel();
            } catch (Exception ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
                jlProdukte.clearSelection();
            }

        }
    }

    /**
     * Ein neues Produkt soll angelegt werden.
     * Vorher ist zu überprüfen, ob das aktuell bearbeitete Produkt
     * gespeichert werden muss.
     *
     * @throws EinkaufsListeException
     */
    private void neu() throws EinkaufsListeException
    {
        if (checkForChanges())
        {
            switch(JOptionPane.showConfirmDialog(this, "Änderungen speichern?"))
            {
                case JOptionPane.CANCEL_OPTION:  // Benuzter will Vorgang abbrechen
                    return;

                case JOptionPane.NO_OPTION:  // Benutzer verzichtet auf Speichern
                    break;

                case JOptionPane.YES_OPTION:  // Benutzer will vorher speichern
                    speichern();
                    break;
            }
        }
        // ein neues Produkt wird auf "in Bearbeitung" gesetzt
        inBearbeitung = new Produkt();
        updatePanel();  // Werte in Eingabeflder übernehmen
        jlProdukte.clearSelection();  // in der Liste ist jetzt nichts ausgewählt
    }

    /**
     * Das aktuell bearbeitete Produkt wird gespeichert
     * (in die Verwaltung und in die Produktliste übernommen)
     *
     * @throws EinkaufsListeException
     */
    private void speichern() throws EinkaufsListeException
    {
        updateProdukt();  // Eigabefelder auslesen
        // Falls das Produkt noch nicht in der Verwaltung vorhanden ist,
        // wird es jetzt übernommen
        if (!lmProdukte.contains(inBearbeitung))
        {
            verwaltung.anlegen(inBearbeitung);
            lmProdukte.addElement(inBearbeitung);
        }

        // neues/gespeichertes Produkt ausgewählt
        jlProdukte.setSelectedValue(inBearbeitung, true);
        jlProdukte.repaint();
    }

    /**
     * Die Eingabefelder werden ausgelesen und die Werte in das aktuell bearbeitete
     * Produkt übernommen
     *
     * @throws EinkaufsListeException
     */
    private void updateProdukt() throws EinkaufsListeException
    {
        inBearbeitung.setBezeichnung(tfBezeichnung.getText());
        try
        {
            inBearbeitung.setPreis(Float.parseFloat(tfPreis.getText()));
        } catch(NumberFormatException nfe)
        {
            throw new EinkaufsListeException("bitte eine Zahl bei Preis eingeben");
        }
        inBearbeitung.setBio(rbBio.isSelected());
        inBearbeitung.setGeschaeft((GESCHAEFT) cbGeschaeft.getSelectedItem());
        inBearbeitung.setHerkunft((LAND) cbHerkunft.getSelectedItem());
    }

    /**
     * die Werte aus dem aktuell bearbeiteten Produkt werden in die Eingabefelder
     * übernommen
     */
    private void updatePanel()
    {
        tfBezeichnung.setText(inBearbeitung.getBezeichnung());
        tfPreis.setText(String.valueOf(inBearbeitung.getPreis()));
        if (inBearbeitung.isBio())
            rbBio.setSelected(true);
        else
            rbNoBio.setSelected(true);
        cbGeschaeft.setSelectedItem(inBearbeitung.getGeschaeft());
        cbHerkunft.setSelectedItem(inBearbeitung.getHerkunft());
    }

    /**
     * Es wird überprüft, ob die Werte in den Eingabefelder sich von
     * denen im aktuell bearbeiteten Produkt unterscheiden
     * (ob das aktuelle Produkt verändert wurde).
     *
     * @return true falls verändert, sonst false
     */
    private boolean checkForChanges()
    {
        boolean changes = false;

        float preis = Float.parseFloat(tfPreis.getText());
        if (
                (!tfBezeichnung.getText().equals(inBearbeitung.getBezeichnung())) ||
                (preis != inBearbeitung.getPreis()) ||
                (rbBio.isSelected() != inBearbeitung.isBio()) ||
                (cbGeschaeft.getSelectedItem() != inBearbeitung.getGeschaeft()) ||
                (cbHerkunft.getSelectedItem() != inBearbeitung.getHerkunft())
            )
            changes = true;
        return changes;
    }



}
