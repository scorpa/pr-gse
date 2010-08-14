package freunde;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI.ListSelectionHandler;

public class HauptFenster extends JFrame
{
    private FreundKomponente kFreund = new FreundKomponente();
    private JButton bnSpeichern = new JButton("SPEICHERN");
    private JButton bnNeu = new JButton("NEU");
    private DefaultListModel lmFreunde = new DefaultListModel();
    private JList lFreunde = new JList(lmFreunde);

    public HauptFenster()
    {
        initFenster();
    }

    private void initFenster()
    {
        setLayout(new BorderLayout());
        add(new JScrollPane(lFreunde), BorderLayout.WEST);
        add(kFreund, BorderLayout.CENTER);
        JPanel unten = new JPanel();
        unten.setLayout(new FlowLayout());
        unten.add(bnSpeichern);
        unten.add(bnNeu);
        add(unten, BorderLayout.SOUTH);
        bnSpeichern.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                speichern();
            }
        });
        bnNeu.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                neu();
            }
        });

        lFreunde.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e)
            {
                auswahl();
            }
        });
    }

    private void speichern()
    {
        try
        {
            Freund f = kFreund.getFreund();
            if (!lmFreunde.contains(f))
                lmFreunde.addElement(f);
        } catch (Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void auswahl()
    {
        Freund f = (Freund) lFreunde.getSelectedValue();
        kFreund.setFreund(f);
    }

    private void neu()
    {
        Freund f = new Freund();
        kFreund.setFreund(f);
    }
}
