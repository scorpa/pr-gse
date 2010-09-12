package mitarbeiter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import javax.imageio.stream.FileImageInputStream;


public class FileMitarbeiterDao extends MemoryMitarbeiterDAO
{
	private File file = new File("mitarbeiter.dat");

	public FileMitarbeiterDao() throws PersistenzException
	{
		if (file.exists())
		{
			try
			{
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				repository = (Map<Integer, Mitarbeiter>) ois.readObject();
				maxNr = ois.readInt();
				ois.close();
			} catch (IOException e)
			{
				e.printStackTrace();
				throw new PersistenzException("kann Datei nicht öffnen: " + file);
			} catch(ClassNotFoundException e)
			{
				e.printStackTrace();
				throw new PersistenzException("Fehler beim Deserialisieren: " + e.getMessage());
			}
		}
	}

	@Override
	public void close() throws PersistenzException
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(repository);
			oos.writeInt(maxNr);
			oos.close();
		} catch (IOException e)
		{
			e.printStackTrace();
			throw new PersistenzException("kann Datei nicht öffnen: " + file);
		} 
		
	}
	
	

}
