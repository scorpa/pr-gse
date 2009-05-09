/*
 * Created on 09.05.2009
 *
 */
package memory;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MemoryGUI extends JFrame implements ActionListener
{
    private Memory memory;
    private JButton[][] buttons;
    
    public MemoryGUI()
    {
        super("Memory");
        neuesSpiel();
        initFrame();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
                ende();
            }
        });
    }
    
    private void neuesSpiel()
    {
        AuswahlDialog auswahl = new AuswahlDialog();
        auswahl.setVisible(true);
        try
        {
            memory = new MemoryImpl(auswahl.getZeilen(), auswahl.getSpalten());
        } catch (MemoryException e1)
        {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this, e1.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }
    

    private void initFrame()
    {
        getContentPane().removeAll();   // alle Buttons entfernen
        setLayout(new GridLayout(memory.getZeilen(), memory.getSpalten()));
        buttons = new JButton[memory.getZeilen()][memory.getSpalten()];
        for (int z = 0; z < memory.getZeilen(); z++)
            for (int s = 0; s < memory.getSpalten(); s++)
            {
                buttons[z][s] = new JButton();
                buttons[z][s].addActionListener(this);
                buttons[z][s].setText("?");
                add(buttons[z][s]);
            }
        setSize(memory.getSpalten() * 80, memory.getZeilen() * 80);
        validate();
    }

    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        for (int z = 0; z < buttons.length; z++)
            for (int s = 0; s < buttons[0].length; s++)
                if (buttons[z][s] == source)
                {
                    memory.tipp(z, s);
                }
        for (int z = 0; z < buttons.length; z++)
            for (int s = 0; s < buttons[0].length; s++)
            {
                JButton b = buttons[z][s];
                switch(memory.getStatus(z, s))
                {
                case 0:
                    b.setIcon(null);
                    b.setText("?");
                    break;
                    
                case 1:
                case 2:
                    b.setText(null);
                    b.setIcon(memory.getBild(z, s));
                    break;
                }
            }
        if (memory.fertig())
        {
            JOptionPane.showMessageDialog(this, "benötigte Versuche: " + memory.tipps());
            ende();
            neuesSpiel();  // Falls Benutzer nicht aufhört
            initFrame();
        }
    }

    private void ende()
    {
        if (JOptionPane.showConfirmDialog(this, "Spiel beenden?", "Beenden", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
            System.exit(0);
    }
    
    public static void main(String[] args)
    {
        new MemoryGUI().setVisible(true);
    }
    
    

    

}
