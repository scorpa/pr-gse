package reversi;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ReversiBrett extends JFrame
{
	private Reversi reversi;
	private ReversiPanel panel;
	
	public ReversiBrett(Reversi r)
	{
		reversi = r;
		panel = new ReversiPanel(r);
		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);
		setSize(500,500);
	}
	
	public static void main(String[] args)
	{
		ReversiBrett brett = new ReversiBrett(new ReversiTestImpl());
		brett.setVisible(true);
		brett.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
