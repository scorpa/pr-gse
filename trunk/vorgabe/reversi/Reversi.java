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
	 * Gibt die Farbe des Feldes an der Position (x,y) zur�ck: <br/>
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
	 * @return  'r' -- rot <br/>
	 * 			'g' -- gr�n <br/>
	 *          ' ' -- leer
	 */
	public char get(int x, int y);
	
	
	/**
	 * Setzt den n�chsten Spielstein an der Position (x,y):<br/>
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
	 * Damit k�nnen Steine f�r die Startaufstellung auf die 
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
	 * @param farbe 'r' -- rot; 	'g' -- gr�n; ' ' -- leer
	 */
	public void set(int x, int y, char farbe);
	
	/**
	 * Damit ist es m�glich zu erzwingen, mit welcher Farbe der n�chste Stein gesetzt wird.
	 * @param farbe 'r' -- rot; 	'g' -- gr�n
	 */
	public void next(char farbe);
	
	
	/**
	 * Damit kann man abfragen, mit welcher Farbe der n�chste Stein gesetzt wird
	 * @return 'r' -- rot; 	'g' -- gr�n
	 */
	public char next();
	
	/**
     * Wird aufgerufen, wenn ein neues Spiel begonnen wird. 
     * Das Spiel soll also in den Grundzustand versetzt werden. 
     *
	 */
    public void neuesSpiel();
    
    /**
     * Liefert die Siegerfarbe zur�ck oder ' ' wenn das Spiel noch nicht beendet ist.
     * @return 'r' -- rot hat gewonnen;     'g' -- gr�n hat gewonnen;    ' ' -- das Spiel ist noch nicht beendet
     */
    char sieger();

}
