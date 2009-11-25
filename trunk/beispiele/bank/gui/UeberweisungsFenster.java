package bank.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import bank.fachlogik.KontoVerwaltung;
import bank.fachlogik.Ueberweisung;

/**
 * @author Rudolf Radlbauer
 */
public class UeberweisungsFenster extends JInternalFrame
{
    JTextField vonKonto = new JTextField();

    JTextField aufKonto = new JTextField();

    JTextField betrag = new JTextField();

    Ueberweisung ueberweisung;

    public UeberweisungsFenster(KontoVerwaltung verwaltung)
    {
        super("Überweisung");
        initFrame();
        pack();
        setClosable(true);
        setIconifiable(true);
        setVisible(true);
        ueberweisung = new Ueberweisung(verwaltung);
    }

    private void initFrame()
    {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(4, 2));
        cp.add(new JLabel("von Konto"));
        cp.add(vonKonto);
        cp.add(new JLabel("auf Konto"));
        cp.add(aufKonto);
        cp.add(new JLabel("Betrag"));
        cp.add(betrag);
        JButton durchfuehren = new JButton("Durchführen");
        JButton abbrechen = new JButton("Abbrechen");
        cp.add(durchfuehren);
        cp.add(abbrechen);
        durchfuehren.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                durchfuehren();
            }
        });
        abbrechen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                abbrechen();
            }
        });

        addInternalFrameListener(new InternalFrameAdapter() {
            public void internalFrameClosing(InternalFrameEvent e)
            {
                abbrechen();
            }
        });
    }

    private void durchfuehren()
    {
        try
        {
            double betr = new Double(betrag.getText()).doubleValue();
            int kto1 = new Integer(vonKonto.getText()).intValue();
            int kto2 = new Integer(aufKonto.getText()).intValue();
            try
            {
                ueberweisung.setVonKontoNummer(kto1);
            } catch (IllegalArgumentException e)
            {
                JOptionPane.showMessageDialog(this, "Konto Nr. " + kto1,
                        "Konto existiert nicht", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try
            {
                ueberweisung.setAufKontoNummer(kto2);
            } catch (IllegalArgumentException e)
            {
                JOptionPane.showMessageDialog(this, "Konto Nr. " + kto2,
                        "Konto existiert nicht", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ueberweisung.setBetrag(betr);

            int ok = JOptionPane.showConfirmDialog(this, betr + " von Konto "
                    + kto1 + " auf Konto " + kto2, "Überweisung durchführen?",
                    JOptionPane.YES_NO_OPTION);
            if (ok == JOptionPane.OK_OPTION)
            {
                ueberweisung.durchfuehren();
                JOptionPane.showMessageDialog(this, "erfolgreich durchgeführt",
                        "Überweisung", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Bitte nur Zahlen eingeben!");
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Fehler bei Überweisung", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void abbrechen()
    {
        int ok = JOptionPane.showConfirmDialog(this, "Eingaben verwerfen?",
                "Überweisung abbrechen", JOptionPane.YES_NO_OPTION);
        if (ok == JOptionPane.OK_OPTION)
            dispose();
    }

}
