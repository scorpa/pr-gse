
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
 *
 * @author Rudolf Radlbauer
 */
public class ProduktFenster extends JFrame implements ActionListener, ListSelectionListener
{
    private ProduktVerwaltung verwaltung;
    private Produkt inBearbeitung;

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



    public ProduktFenster(ProduktVerwaltung verwaltung)
    {
        this.verwaltung = verwaltung;
        initFrame();
        try
        {
            for (Produkt p : verwaltung.liste())
                lmProdukte.addElement(p);
            inBearbeitung = new Produkt();
            updatePanel();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void initFrame()
    {
        JSplitPane split = new JSplitPane();
        split.setDividerLocation(150);
        add(split);

        lmProdukte = new DefaultListModel();
        jlProdukte = new JList(lmProdukte);
        split.add(new JScrollPane(jlProdukte), JSplitPane.LEFT);

        JPanel rechts = new JPanel();
        split.add(rechts, JSplitPane.RIGHT);
        rechts.setLayout(new GridLayout(0, 2));

        rechts.add(new JLabel("Bezeichnung"));
        rechts.add(tfBezeichnung);

        rechts.add(new JLabel("Preis"));
        rechts.add(tfPreis);

        rechts.add(new JLabel("Geschäft"));
        cbGeschaeft = new JComboBox(GESCHAEFT.values());
        rechts.add(cbGeschaeft);

        rechts.add(new JLabel("Bioprodukt"));
        JPanel janein = new JPanel(new FlowLayout());
        rechts.add(janein);
        janein.add(rbBio);
        janein.add(rbNoBio);
        rbBio.setSelected(true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbBio);
        bg.add(rbNoBio);

        rechts.add(new JLabel("Herkunft"));
        cbHerkunft = new JComboBox(LAND.values());
        rechts.add(cbHerkunft);

        rechts.add(bnLoeschen);
        rechts.add(bnSpeichern);
        rechts.add(bnNeu);
        
        bnLoeschen.addActionListener(this);
        bnNeu.addActionListener(this);
        bnSpeichern.addActionListener(this);
        jlProdukte.addListSelectionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if (e.getSource() == bnNeu)
                neu();
            else if (e.getSource() == bnSpeichern)
                speichern();
            else if (e.getSource() == bnLoeschen)
            {
                if (jlProdukte.getSelectedValue() != null)
                {
                    if (JOptionPane.showConfirmDialog(this, "Sind Sie sicher",
                            "Produkt löschen", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    {
                        lmProdukte.removeElement(jlProdukte.getSelectedValue());
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

    public void valueChanged(ListSelectionEvent e)
    {
        if (e.getValueIsAdjusting())
            return;
        if (e.getSource() == jlProdukte && jlProdukte.getSelectedValue() != null)
        {
            try
            {
                if (checkForChanges())
                {
                    switch (JOptionPane.showConfirmDialog(this, "Änderungen speichern?"))
                    {
                        case JOptionPane.YES_OPTION:
                            speichern();
                            break;

                        case JOptionPane.CANCEL_OPTION:
                            jlProdukte.clearSelection();
                            return;

                        case JOptionPane.NO_OPTION:
                            break;
                    }
                }
                Produkt p = (Produkt) jlProdukte.getSelectedValue();
                if (p != null)
                    inBearbeitung = p;
                updatePanel();
            } catch (Exception ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
                jlProdukte.clearSelection();
            }

        }
    }
    
    private void neu() throws EinkaufsListeException
    {
        if (checkForChanges())
        {
            switch(JOptionPane.showConfirmDialog(this, "Änderungen speichern?"))
            {
                case JOptionPane.CANCEL_OPTION:
                    return;

                case JOptionPane.NO_OPTION:
                    break;

                case JOptionPane.YES_OPTION:
                    speichern();
                    break;
            }
        }
        inBearbeitung = new Produkt();
        updatePanel();
        jlProdukte.clearSelection();
    }


    private void speichern() throws EinkaufsListeException
    {
        updateProdukt();
        if (!lmProdukte.contains(inBearbeitung))
        {
            lmProdukte.addElement(inBearbeitung);
            verwaltung.anlegen(inBearbeitung);
        }

        jlProdukte.setSelectedValue(inBearbeitung, true);
        jlProdukte.repaint();
    }


    private void updateListe() throws EinkaufsListeException
    {
        lmProdukte.clear();
        for (Produkt p : verwaltung.liste())
            lmProdukte.addElement(p);
        jlProdukte.repaint();

    }

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



    // nur zum Testen
    public static void main(String[] args)
    {
        try
        {
            ProduktVerwaltung verwaltung = new ProduktVerwaltungImpl();
            Produkt p = new Produkt();
            p.setBezeichnung("test");
            p.setPreis(100);
            p.setHerkunft(LAND.ITALIEN);
            p.setGeschaeft(GESCHAEFT.BILLA);
            verwaltung.anlegen(p);
            ProduktFenster fenster = new ProduktFenster(verwaltung);
            fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenster.setSize(500, 300);
            fenster.setVisible(true);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


}
