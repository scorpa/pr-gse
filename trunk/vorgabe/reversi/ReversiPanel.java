package reversi;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ReversiPanel extends JPanel
{
	private Reversi reversi;
	private JButton[][] buttons;
	
	public ReversiPanel(Reversi reversi)
	{
		super();
		this.reversi = reversi;
		buttons = new JButton[8][8];
		for (JButton[] row : buttons)
			for (JButton b : row)
				b = new JButton();
		
		setLayout(new GridLayout(8,8));
		
		for (JButton[] row : buttons)
			for (JButton b : row)
				add(b);				
	}
	
	

}
