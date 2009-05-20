/*
 * Created on 19.05.2009
 *
 */
package mitglied_gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class HobbiesFenster extends JDialog
{
    private List<String> hobbies; 
    private JTextField[] tfHobbies;
    
    public HobbiesFenster(List<String> hobbies)
    {
        this.hobbies = hobbies;
        setTitle("Hobbies bearbeiten");
        initDialog();
        updateDaten();
        pack();
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }


	private void updateDaten()
	{
		hobbies.clear();
		for (int i = 0; i < tfHobbies.length; i++)
		{
			String hobby = tfHobbies[i].getText().trim();
			if (hobby.length() > 0)
				hobbies.add(hobby);
		}
		
	}


	private void initDialog()
	{
		int count = hobbies.size();
		setLayout(new GridLayout(count+4, 1));
		tfHobbies = new JTextField[count + 3];
		for (int i = 0; i < count+3; i++)
		{
			tfHobbies[i] = new JTextField();
			add(tfHobbies[i]);
		}
		for (int i = 0; i < count; i++)
			tfHobbies[i].setText(hobbies.get(i));	
		JButton ok = new JButton("OK");
		add(ok);
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					updateDaten();
					dispose();
		    	} catch(Exception e)
		    	{
		    		JOptionPane.showMessageDialog(HobbiesFenster.this, e.getMessage(), 
		    				"Eingabefehler", JOptionPane.ERROR_MESSAGE);
		    	}

			}});
	}

}
