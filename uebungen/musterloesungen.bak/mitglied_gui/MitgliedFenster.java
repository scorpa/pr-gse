/*
 * Created on 19.05.2009
 *
 */
package mitglied_gui;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MitgliedFenster extends JDialog
{
    private final static SimpleDateFormat FORMATTER = new SimpleDateFormat("dd.MM.yyyy");
    private Mitglied mitglied;
    private JTextField tfName;
    private JTextField tfEintritt;


    public MitgliedFenster(Mitglied mitglied) throws HeadlessException
    {
        this.mitglied = mitglied;
        setTitle("Mitglied bearbeiten");
        initDialog();
        updateFenster();
        pack();
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    private void updateFenster()
    {
        tfName.setText(mitglied.getName());
        tfEintritt.setText(FORMATTER.format(mitglied.getEintrittsDatum()));
        
    }

    private void initDialog()
    {
    	tfName = new JTextField();
    	tfEintritt = new JTextField();
        setLayout(new GridLayout(3, 2));
        add(new JLabel("Name"));
        add(tfName);
        add(new JLabel("Eintrittsdatum"));
        add(tfEintritt);
        JButton hobbies = new JButton("Hobbies");
        JButton ok = new JButton("OK");
        add(hobbies);
        add(ok);
        hobbies.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new HobbiesFenster(mitglied.getHobbies()).setVisible(true);
                
            }});
        ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
            	try
            	{
	                updateDaten();
	                dispose();
            	} catch(Exception e)
            	{
            		JOptionPane.showMessageDialog(MitgliedFenster.this, e.getMessage(), 
            				"Eingabefehler", JOptionPane.ERROR_MESSAGE);
            	}

            }});       
    }

    private void updateDaten()
    {
        mitglied.setName(tfName.getText());
        try
        {
            mitglied.setEintrittsDatum(FORMATTER.parse(tfEintritt.getText()));
        } catch (ParseException e)
        {
            JOptionPane.showMessageDialog(this, "Format des Eintrittsdatums: TT.MM.JJJJ");
        }
    }
    
    

}
