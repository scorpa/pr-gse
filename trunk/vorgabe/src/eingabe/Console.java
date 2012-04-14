package eingabe;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


/**
 * Konsole für die Ein- und Ausgabe in ein / von einem extra Fenster
 * 
 * @author Rudolf Radlbauer
 *
 */
public class Console extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JTextArea text = new JTextArea();
	private String buffer = text.getText();
	private String command = "";
	
	/**
	 * Konstruktor - öffnet die Konsole
	 */
	public Console()
	{
		add(new JScrollPane(text));
		text.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				if (text.getText().length() < buffer.length())
					text.setText(buffer);
				text.setCaretPosition(text.getText().length());
				if (e.getKeyChar() == '\n')
					parseLine();
			}
		});
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SwingUtilities.invokeLater(new Runnable()
		{
			
			@Override
			public void run()
			{
				setVisible(true);
				
			}
		});
	}
	
	/**
	 * funktioniert wie System.out.println()
	 * @param o das was ausgegeben werden soll
	 */
	public void println(Object o)
	{
		text.append(o.toString());
		text.append("\n");
	}
	
	/**
	 * funktioniert wie System.out.print()
	 * @param o das was ausgegeben werden soll
	 */
	public void print(Object o)
	{
		text.append(o.toString());
	}
	
	/**
	 * schließt die Konsole und beendet das Programm
	 */
	public void close()
	{
		System.exit(0);
	}

	private void parseLine()
	{
		command = text.getText();
		command = command.substring(buffer.length(), command.length()-1);
		synchronized(buffer)
		{
			buffer.notify();
		}
	}
	

	/**
	 * liest einen Text eine
	 * @param prompt Eingabeaufforderung
	 * @return eingelesener Text
	 */
	public String readText(String prompt)
	{
		text.append(prompt);
		text.setCaretPosition(text.getText().length());
		buffer = text.getText();
		try
		{
			synchronized(buffer)
			{
				buffer.wait();
			}
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return command;
	}
	
	

    /**
     * liest einen Wahrheitswert (true oder false)
     * Die Eingabeaufforderung wird so lange wiederholt, bis der Benutzer true oder false eingibt.
     * @param prompt Eingabeaufforderung
     * @return gelesener Wahrheitswert
     */
    public boolean readBoolean(String prompt)
    {
        boolean bool = false;
        boolean ok = false;
        while(!ok)
        {
            String line = readText(prompt);
            if ("true".equals(line.trim()))
            {
                bool = true;
                ok = true;
            }
            else if ("false".equals(line.trim()))
            {
                bool = false;
                ok = true;
            }
            else
                println("Bitte \"true\" oder \"false\" eingeben");
                
        }
        
        return bool;
    }
    
    /**
     * liest ein Zeichen (char)
     * Die Eingabeaufforderung wird so lange wiederholt, bis der Benutzer ein einzelnes Zeichen eingibt.
     * @param prompt Eingabeaufforderung
     * @return gelesenes Zeichen
     */
    public char readChar(String prompt)
    {
        char zeichen = ' ';
        boolean ok = false;
        while(!ok)
        {
            String line = readText(prompt);
            if (line != null && line.length() == 1)
            {
                zeichen = line.charAt(0);
                ok = true;
            }
            else
                println("Bitte einzelnes Zeichen eingeben (dann ENTER)");
        }
        
        return zeichen;
    }
    
    
    
    
    /**
     * liest eine Ganzzahl (int)
     * Die Eingabeaufforderung wird so lange wiederholt, bis der Benutzer eine Zahl eingibt.
     * @param prompt Eingabeaufforderung
     * @return die gelesene Zahl
     */
    public int readInt(String prompt)
    {
        int zahl = 0;
        boolean ok = false;
        while(!ok)
        {
            try
            {
                zahl = Integer.parseInt(readText(prompt));
                ok = true;
            }
            catch(NumberFormatException e)
            {
                println("Bitte Ganzzahl eingeben");
            }
        }
        
        return zahl;
    }
    
    
    /**
     * liest eine Ganzzahl (long)
     * Die Eingabeaufforderung wird so lange wiederholt, bis der Benutzer eine Zahl eingibt.
     * @param prompt Eingabeaufforderung
     * @return die gelesene Zahl
     */
    public long readLong(String prompt)
    {
        long zahl = 0;
        boolean ok = false;
        while(!ok)
        {
            try
            {
                zahl = Long.parseLong(readText(prompt));
                ok = true;
            }
            catch(NumberFormatException e)
            {
                println("Bitte Ganzzahl eingeben");
            }
        }
        
        return zahl;
    }
    
    
    
    /**
     * liest eine Gleitkommazahl (float)
     * Die Eingabeaufforderung wird so lange wiederholt, bis der Benutzer eine Zahl eingibt.
     * @param prompt Eingabeaufforderung
     * @return die gelesene Zahl
     */
    public float readFloat(String prompt)
    {
        float zahl = 0;
        boolean ok = false;
        while(!ok)
        {
            try
            {
                zahl = Float.parseFloat(readText(prompt));
                ok = true;
            }
            catch(NumberFormatException e)
            {
                println("Bitte Dezimalzahl eingeben");
            }
        }
        
        return zahl;
    }
    
    
    /**
     * liest eine Gleitkommazahl (double)
     * Die Eingabeaufforderung wird so lange wiederholt, bis der Benutzer eine Zahl eingibt.
     * @param prompt Eingabeaufforderung
     * @return die gelesene Zahl
     */
    public double readDouble(String prompt)
    {
        double zahl = 0;
        boolean ok = false;
        while(!ok)
        {
            try
            {
                zahl = Double.parseDouble(readText(prompt));
                ok = true;
            }
            catch(NumberFormatException e)
            {
                println("Bitte Dezimalzahl eingeben");
            }
        }
        
        return zahl;
    }
    
    
    /**
     * liest ein Datum ein und liefert eine Date-Instanz
     * Die Eingabeaufforderung wird so lange wiederholt, bis der Benutzer ein gültiges Datum eingibt
     * @param prompt Eingabeaufforderung
     * @param format Format-String
     * @return Referenz auf Date-Instanz
     * @throws IllegalArgumentException falls Format-String nicht passt.
     */
    public Date readDate(String prompt, String format)
    {
        Date date = null;
        do
        {
            try
            {
                SimpleDateFormat formatter = new SimpleDateFormat(format);
                date = formatter.parse(readText(prompt));
            } 
            catch(ParseException pe)
            {
                println("ungültiges Datumsformat (" + format + ")");
            }
        } while(date == null);
        return date;
    }
    
    /**
     * liest ein Datum ein und liefert eine Date-Instanz
     * Die Eingabeaufforderung wird so lange wiederholt, bis der Benutzer ein gültiges Datum eingibt.
     * Das Datum muss im Format "t.m.j" eingegeben werden.
     * @param prompt Eingabeaufforderung
    * @return Referenz auf Date-Instanz
     */

    public Date readDate(String prompt)
    {
        return readDate(prompt, "dd.MM.yyyy");
    }
    
    
    /**
     * nur zum Testen
     * @param args
     */
    public static void main(String[] args)
    {
    	Console c = new Console();
        c.println(c.readText("text: "));
        c.println(c.readDate("Date: "));
        c.println(c.readBoolean("boolean: "));
        c.println(c.readChar("char: "));
        c.println(c.readDouble("double: "));
        c.println(c.readFloat("float: "));
        c.println(c.readInt("int: "));
        c.println(c.readLong("long: "));
        c.close();
    }
 

}
