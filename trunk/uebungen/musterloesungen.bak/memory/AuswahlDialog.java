/*
 * Created on 09.05.2009
 *
 */
package memory;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AuswahlDialog extends JDialog implements ActionListener
{
    private SpinnerNumberModel zeilen;
    private SpinnerNumberModel spalten;
    
    
    public AuswahlDialog()
    {
        setTitle("Feldgröße");
        initDialog();
        pack();
        setModal(true);
    }
    
    public int getZeilen()
    {
        return zeilen.getNumber().intValue();
    }

    public int getSpalten()
    {
        return spalten.getNumber().intValue();
    }

    private void initDialog()
    {
        zeilen = new SpinnerNumberModel(4, 1, 10, 1);
        spalten = new SpinnerNumberModel(4, 1, 10, 1);
        setLayout(new GridLayout(2,3));
        add(new JSpinner(zeilen));
        JLabel x = new JLabel("X");
        x.setHorizontalAlignment(JLabel.CENTER);
        add(x);
        add(new JSpinner(spalten));
        JButton ok = new JButton("OK");
        ok.addActionListener(this);
        add(new JLabel());
        add(ok);
        
    }

    public void actionPerformed(ActionEvent e)
    {
        dispose();
        
    }
    

}
