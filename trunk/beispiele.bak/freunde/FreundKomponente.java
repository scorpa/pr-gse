package freunde;

import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FreundKomponente extends JPanel
{
    private final static SimpleDateFormat DATUMSFORMAT =
            new SimpleDateFormat("dd.MM.yyyy");

    private JTextField tfName = new JTextField();
    private JTextField tfGeburtsTag = new JTextField();
    private JTextField tfGroesse = new JTextField();

    private Freund freund;

    public FreundKomponente()
    {
        initKomponente();
    }

    private void initKomponente()
    {
        setLayout(new GridLayout(0,2));  // Zeilen, Spalten
        add(new JLabel("Name"));
        add(tfName);
        add(new JLabel("Geburtsdatum"));
        add(tfGeburtsTag);
        add(new JLabel("Größe"));
        add(tfGroesse);
    }

    public void setFreund(Freund f)
    {
        this.freund = f;
        tfName.setText(f.getName());
        tfGeburtsTag.setText(DATUMSFORMAT.format(f.getGeburtsTag()));
        tfGroesse.setText(String.valueOf(f.getGroesse()));
    }

    public Freund getFreund() throws ParseException, NumberFormatException
    {
        if (freund == null)
            freund = new Freund();
        freund.setName(tfName.getText());
        freund.setGeburtsTag(DATUMSFORMAT.parse(tfGeburtsTag.getText()));
        freund.setGroesse(Integer.parseInt(tfGroesse.getText()));

        return freund;
    }

}
