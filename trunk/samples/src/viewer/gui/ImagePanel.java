package viewer.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;

import viewer.data.Image;
import viewer.dicom.DicomFileReader;

public class ImagePanel extends JPanel
{
	private Image image;
	private BufferedImage bufferedImage;
	private DicomFileReader dcmReader;
	
	public ImagePanel() throws Exception
	{
		dcmReader = new DicomFileReader();
	}
	
	


	public void setImage(Image image) throws IOException
	{
		if (this.image == null || !this.image.getSopInstanceUID().equals(image.getSopInstanceUID()))
		{
			this.image = image;
			bufferedImage =  dcmReader.readImage(image.getFile());
			
			setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));
			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		if (bufferedImage != null)
			g.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), this);
	}
	
}
