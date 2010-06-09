package quiz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Rudolf Radlbauer
 */
public class HauptFenster extends JFrame
{
    private List<Frage> fragen;
    private JLabel jlFrage = new JLabel();
    private JRadioButton[] rbAntwort = new JRadioButton[4];
    private int aktuelleFrage;

    public HauptFenster(List<Frage> fragen)
    {
        super("Quiz");
        this.fragen = fragen;
        initFrame();
        updateFrage();
    }

    private void initFrame()
    {
        setLayout(new GridLayout(0, 1));
        add(jlFrage);
        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < 4; i++)
        {
            rbAntwort[i] = new JRadioButton();
            group.add(rbAntwort[i]);
            add(rbAntwort[i]);
        }
        rbAntwort[0].setSelected(true);
        JButton ok = new JButton("OK");
        add(ok);
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                weiter();
            }
        });
    }

    private void weiter()
    {
        int antwort = -1;
        for (int i = 0; i < 4; i++)
            if (rbAntwort[i].isSelected())
                antwort = i;
        String message;
        Frage f = fragen.get(aktuelleFrage);
        if (f.getRichtig() == antwort)
            JOptionPane.showMessageDialog(this, "Ihre Antwort ist richtig", "Richtig!",
                    JOptionPane.PLAIN_MESSAGE);
        else
            JOptionPane.showMessageDialog(this, "richtige Antwort: " + f.getAntwort(f.getRichtig()),
                    "Ihre Antwort ist leider nicht richtig", JOptionPane.PLAIN_MESSAGE);
        aktuelleFrage++;
        if (aktuelleFrage < fragen.size())
            updateFrage();
        else
            System.exit(0);
    }

    private void updateFrage()
    {
        if (aktuelleFrage >= 0 && aktuelleFrage < fragen.size())
        {
            Frage frage = fragen.get(aktuelleFrage);
            jlFrage.setText(frage.getFrage());
            for (int i = 0; i < 4; i++)
                rbAntwort[i].setText(frage.getAntwort(i));
        }
    }


}
