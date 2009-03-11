package reversi;

/**
 * Interface, welches von einem Reversi-Spiel implementiert werden muss;<br/>
 * wird von der Oberflaechenklasse ReversiBrett verwendet.
 * 
 * 
 * @author radlbauer
 *
 */
public interface Reversi
{
	/**
	 * Gibt die Farbe des Feldes an der Position (x,y) zurück: <br/>
	 * 
	 * ------------------------------------------<br/>
	 * | (0,0) | (0,1) | (0,2) | ......<br/>
	 * ------------------------------<br/>
	 * | (1,0) | (1,1) | .....<br/>
	 * ----------------------<br/>
	 * | ..........<br/>
	 * 
	 * @param x  Zeilennummer
	 * @param y  Spaltennummer
	 * @return  's' -- schwarz <br/>
	 * 			'w' -- weiss <br/>
	 *          ' ' -- leer
	 */
	public char get(int x, int y);
	
	
	/**
	 * Setzt den nächsten Spielstein an der Position (x,y):<br/>
	 * ------------------------------------------<br/>
	 * | (0,0) | (0,1) | (0,2) | ......<br/>
	 * ------------------------------<br/>
	 * | (1,0) | (1,1) | .....<br/>
	 * ----------------------<br/>
	 * | ..........<br/>
	 * 
	 * Es wird davon ausgegangen, dass die Farben immer abwechselnd gesetzt werden.
	 * 
	 * @param x Zeilennummer
	 * @param y Spaltennummer
	 * @return true wenn der Spielzug angenommen wurde, false wenn nicht
	 */
	public boolean set(int x, int y);
	
	/**
	 * Damit können Steine für die Startaufstellung auf die 
	 * Position (x,y) gesetzt werden:<br/>
	 * ------------------------------------------<br/>
	 * | (0,0) | (0,1) | (0,2) | ......<br/>
	 * ------------------------------<br/>
	 * | (1,0) | (1,1) | .....<br/>
	 * ----------------------<br/>
	 * | ..........<br/>
	 * 
	 * @param x Zeilennummer
	 * @param y Spaltennummer
	 * @param farbe 'w' -- weiss; 	's' -- schwarz; ' ' -- leer
	 */
	public void set(int x, int y, char farbe);
	
	/**
	 * Damit ist es möglich zu erzwingen, mit welcher Farbe der nächste Stein gesetzt wird.
	 * @param farbe 'w' -- weiss; 	's' -- schwarz
	 */
	public void next(char farbe);
	
	
	/**
	 * Damit kann man abfragen, mit welcher Farbe der nächste Stein gesetzt wird
	 * @return 'w' -- weiss; 	's' -- schwarz
	 */
	public char next();
	
	

}
