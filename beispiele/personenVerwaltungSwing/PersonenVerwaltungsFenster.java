package personenVerwaltungSwing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PersonenVerwaltungsFenster extends JFrame
{
    private JTextField tfName = new JTextField();
    private JTextField tfGeburtsDatum = new JTextField();
    private JTextField tfGewicht = new JTextField();
    private JButton bnSpeichern = new JButton("speichern");
    private JButton bnNeu = new JButton("neu");
    private JList jlPersonen = new JList();
    private DefaultListModel personenModel = new DefaultListModel();

    public PersonenVerwaltungsFenster()
    {
        initFrame();
    }

    /**
     * baut mein Fenster auf
     */
    private void initFrame()
    {
        setTitle("PersonenVerwaltung");
        setLayout(new BorderLayout());

        JPanel center = new JPanel();
        add(center, BorderLayout.CENTER);
        center.setLayout(new GridLayout(0, 2));  // zeilen, spalten
        center.add(new JLabel("Name"));
        center.add(tfName);
        center.add(new JLabel("Geburtsdatum"));
        center.add(tfGeburtsDatum);
        center.add(new JLabel("Gewicht"));
        center.add(tfGewicht);
        center.add(bnNeu);
        center.add(bnSpeichern);

        JScrollPane scrollpane = new JScrollPane(jlPersonen);
        this.add(scrollpane, BorderLayout.WEST);
        jlPersonen.setModel(personenModel);
        personenModel.addElement("String1");
        personenModel.addElement("String2");

    }

}
