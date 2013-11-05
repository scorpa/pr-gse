package demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Bilder
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		File file = new File("sample_images/1.2.840.113619.2.5.1762583153.215519.978957063.79/1.2.840.113619.2.5.1762583153.215519.978957063.80.dcm");

		Iterator<ImageReader> dcmReaders = ImageIO.getImageReadersByFormatName("DICOM");
		if (dcmReaders.hasNext())
		{
			ImageReader reader = dcmReaders.next();
			System.out.println(reader);
			reader.setInput(new FileImageInputStream(file));
			BufferedImage img = reader.read(0);
			
			JFrame f = new JFrame();
			f.add(new JLabel(new ImageIcon(img)));
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.pack();
			f.setVisible(true);
			
			
			
			System.out.println(img);
		}

	}

}
