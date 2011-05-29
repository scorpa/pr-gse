package verkaufsstatistik;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Rudolf Radlbauer
 */
public class ArtikelEingabe extends JDialog
{
    private Artikel artikel;

    private JTextField tfBezeichnung = new JTextField();
    private JTextField tfAnzahl = new JTextField();
    private JTextField tfPreis = new JTextField();
    private SpinnerDateModel mVerkaufsBeginn = new SpinnerDateModel();
    private JButton ok = new JButton("OK");

    public ArtikelEingabe()
    {
        setModal(true);
        artikel = new Artikel();
        initDialog();
        pack();
    }

    private void initDialog()
    {
        setLayout(new GridLayout(0, 2));
        add(new JLabel("Bezeichnung"));
        add(tfBezeichnung);
        add(new JLabel("Anzahl"));
        add(tfAnzahl);
        add(new JLabel("Preis"));
        add(tfPreis);
        JSpinner datum = new JSpinner(mVerkaufsBeginn);
        datum.setEditor(new JSpinner.DateEditor(datum, "dd.MM.yyyy"));
        add(datum);
        add(ok);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                ok();
            }
        });
    }

    private void ok()
    {
        try
        {
            artikel.setBezeichnung(tfBezeichnung.getText());
            artikel.setAnzahl(Integer.parseInt(tfAnzahl.getText()));
            artikel.setPreis(Float.parseFloat(tfPreis.getText()));
            artikel.setVerkaufsBeginn(mVerkaufsBeginn.getDate());
            dispose();
        }  catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "bitte bei Anzahl und Preis Zahlen eingeben");
        } catch(IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public Artikel getArtikel()
    {
        return artikel;
    }


}
