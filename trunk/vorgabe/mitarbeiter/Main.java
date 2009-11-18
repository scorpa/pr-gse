package mitarbeiter;

import javax.swing.JFrame;

public class Main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		MitarbeiterDAO dao = new MemoryMitarbeiterDAO();
		GUI gui = new GUI(dao);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(800, 300);
		gui.setVisible(true);

	}

}
