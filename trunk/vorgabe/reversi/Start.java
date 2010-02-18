package reversi;

public class Start
{
	public static void main(String[] args)
	{
		Reversi reversi = new ReversiTestImpl();  // Testimplementierung
		ReversiBrett spiel = new ReversiBrett(reversi);
	}

}
