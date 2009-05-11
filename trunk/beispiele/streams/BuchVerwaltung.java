/*
 * Created on 16.11.2008
 *
 */
package streams;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class BuchVerwaltung
{
    private ArrayList<Buch> buecher;
    
    public BuchVerwaltung()
    {
        buecher = new ArrayList<Buch>();
    }
    
    /**
     * Serialisiert die Bücherliste
     * @param datei Datei, in welche gespeichert wird
     */
    public void serialisieren(String datei)
    {
    	ObjectOutputStream oos = null;
    	try
		{
			oos = new ObjectOutputStream(new FileOutputStream(datei));
			oos.writeObject(buecher);
		} catch (FileNotFoundException e)
		{
			System.out.println("Kann Datei nicht zum Serialisieren öffnen: " + datei);
		} catch (IOException e)
		{
			System.out.println("Fehler beim Serialisieren: " + e.getMessage());
		}
		finally  // kommt in jedem Fall dran
		{
			if (oos != null)
				try
				{
					oos.close();
				} catch (IOException e)
				{
					System.out.println("Kann Datei nicht schließen: " + datei);
				}
		}
    }
    
    /**
     * lädt die Bücherliste aus serialisierter Datei
     * @param datei Datei, aus welcher die Bücherliste geladen wird
     */
    public void deserialisieren(String datei)
    {
    	ObjectInputStream ois = null;
    	try
		{
			ois = new ObjectInputStream(new FileInputStream(datei));
			buecher = (ArrayList<Buch>) ois.readObject();
		} catch (FileNotFoundException e)
		{
			System.out.println("Kann Datei nicht zum Deserialisieren öffnen: " + datei);
		} catch (IOException e)
		{
			System.out.println("Fehler beim Deserialisieren: " + e.getMessage());
		} catch(ClassNotFoundException e)
		{
			System.out.println("Feler beim Deserialisieren: " + e.getMessage());
		} finally
		{
			if (ois != null)
				try
				{
					ois.close();
				} catch (IOException e)
				{
					System.out.println("Kann Datei nicht schließen: " + datei);
				}
		}
    	
    }
    
    /**
     * Speichert die Bücherliste in Binär-Format
     * @param datei  Datei, in welche gespeichert wird
     */
    public void speichern(String datei)
    {
    	DataOutputStream dos = null;
    	try
		{
			dos = new DataOutputStream(new FileOutputStream(datei));
			dos.writeInt(buecher.size());
			for (Buch b : buecher)
			{
				dos.writeUTF(b.getIsbn());
				dos.writeUTF(b.getAutor());
				dos.writeUTF(b.getTitel());
				dos.writeUTF(b.getVerlag());
				dos.writeInt(b.getSeiten());
				if (b.getKunde() != null)
					dos.writeUTF(b.getKunde());
				else
					dos.writeUTF(" ");
			}
		} catch (FileNotFoundException e)
		{
			System.out.println("Kann Datei nicht zum Speichern öffnen: " + datei);
		} catch (IOException e)
		{
			System.out.println("Fehler beim Speichern: " + e.getMessage());			
		} finally
		{
			if (dos != null)
				try
				{
					dos.close();
				} catch (IOException e)
				{
					System.out.println("Kann Datei nicht schließen: " + datei);
				}
		}
    }
    
    /**
     * lädt die Bücherliste aus binärer Datei
     * @param datei  Datei, aus welcher die Bücherliste geladen wird
     */
    public void laden(String datei)
    {
    	DataInputStream dis = null;
    	try
		{
			dis = new DataInputStream(new FileInputStream(datei));
			int anzahl = dis.readInt();
			for (int i = 0; i < anzahl; i++)
			{
				String isbn = dis.readUTF();
				Buch b = new Buch(isbn);
				b.setAutor(dis.readUTF());
				b.setTitel(dis.readUTF());
				b.setVerlag(dis.readUTF());
				b.setSeiten(dis.readInt());
				String kunde = dis.readUTF();
				if (kunde.trim().length() > 0)
					b.entlehnen(kunde);   
				anlegen(b);
				
			}
		} catch (FileNotFoundException e)
		{
			System.out.println("Kann Datei nicht zum Laden öffnen: " + datei);
		} catch (IOException e)
		{
			System.out.println("Fehler beim Laden: " + e.getMessage());
		} finally
		{
			if (dis != null)
				try
				{
					dis.close();
				} catch (IOException e)
				{
					System.out.println("Kann Datei nicht schließen: " + datei);
				}
		}
    	
    	
    }
    
    /**
     * Speichert die Bücherliste in Textformat
     * @param datei  Datei, in welche gespeichert wird
     */
    public void schreiben(String datei)
    {
    	PrintWriter pw = null;
		try
		{
			pw = new PrintWriter(new FileWriter(datei));
			pw.println(buecher.size());
			for (Buch b : buecher)
			{
				StringBuilder str = new StringBuilder();
				str.append(b.getIsbn().replaceAll("\t", "    ")).append("\t");
				str.append(b.getAutor().replaceAll("\t", "    ")).append("\t");
				str.append(b.getTitel().replaceAll("\t", "    ")).append("\t");
				str.append(b.getSeiten()).append("\t");
				str.append(b.getVerlag().replaceAll("\t", "    ")).append("\t");
				if (b.getKunde() != null)
					str.append(b.getKunde().replaceAll("\t", "    "));
				pw.println(str);
				
			}
		} catch (IOException e)
		{
			System.out.println("Fehler beim Schreiben in Datei  " + datei + ": " + e.getMessage());
		} finally
		{
			if (pw != null)
				pw.close();
		}
   	
    }
    
    /**
     * liest die Bücherliste aus Textdatei
     * @param datei  Datei, aus welcher die Bücherliste geladen wird
     */
    public void einlesen(String datei)
    {
    	BufferedReader br = null;
    	try
		{
			br = new BufferedReader(new FileReader(datei));
			int anzahl = Integer.parseInt(br.readLine());
			for (int i = 0; i < anzahl; i++)
			{
				String zeile = br.readLine();
				StringTokenizer tokens = new StringTokenizer(zeile, "\t");
				String isbn = tokens.nextToken();
				Buch b = new Buch(isbn);
				b.setAutor(tokens.nextToken());
				b.setTitel(tokens.nextToken());
				b.setSeiten(Integer.parseInt(tokens.nextToken()));
				b.setVerlag(tokens.nextToken());
				if (tokens.hasMoreTokens())
					b.entlehnen(tokens.nextToken());

				anlegen(b);
			}
		} catch (FileNotFoundException e)
		{
			System.out.println("Kann Datei nicht zum Lesen öffnen: " + datei);
		} catch(IOException e)
		{
			System.out.println("Fehler beim Lesen: " + e.getMessage());
		} catch(Exception e)
		{
			System.out.println("ungültiges Format in Datei " + datei);
		}
		finally
		{
			if (br != null)
				try
				{
					br.close();
				} catch (IOException e)
				{
					System.out.println("Kann Datei nicht schließen: " + datei);
				}
		}
    }
    
    
    
    public void anlegen(Buch buch)
    {
        if (buch != null)
            buecher.add(buch);
        else
            System.out.println("buch darf nicht null seinb");
    }
    
    public void ausmustern(Buch buch)
    {
        if (!buecher.remove(buch))
            System.out.println("Buch war nicht vorhanden");
    }
    
    public void liste()
    {
        ueberschrift();
        for (Buch b : buecher)
            ausgeben(b);
    }
    
    public void listeEntlehnt()
    {
        ueberschrift();
        for (Buch b : buecher)
        {
            if (b.getKunde() != null)
                ausgeben(b);
        }
    }
    
    public void listeVerfuegbar()
    {
        ueberschrift();
        for (Buch b : buecher)
        {
            if (b.getKunde() == null)
                ausgeben(b);
        }
    }
    
    public int anzahlEntlehnt()
    {
        int anzahl = 0;
        for (Buch b : buecher)
            if (b.getKunde() != null)
                anzahl++;
        return anzahl;
    }
    
    
    private void ueberschrift()
    {
        System.out.println("ISBN\t\tAutor\t\tTitel\t\tSeiten\t\tentlehnt");
    }
    
    private void ausgeben(Buch b)
    {
        System.out.println(b.getIsbn() + "\t" + b.getAutor() + "\t" + b.getTitel() 
                + "\t" + b.getSeiten() + "\t" + ((b.getKunde() == null) ? "nein" : "ja"));
    }

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		for (Buch b : buecher)
		{
			str.append(b.getIsbn()).append("\t");
			str.append(b.getAutor()).append("\t");
			str.append(b.getTitel()).append("\t");
			str.append(b.getSeiten()).append("\t");
			str.append(b.getVerlag()).append("\t");
			str.append((b.getKunde() != null) ? b.getKunde() : "").append("\n");
		}
		return str.toString();
	}
    
    

}
