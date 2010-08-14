package fotoquiz;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelWithBackground extends JPanel
{
	private Image image;
	
	public PanelWithBackground()
	{
		image = null;
	}

	public PanelWithBackground(Image image)
	{
		setImage(image);
	}

	public PanelWithBackground(URL imageURL) throws IOException
	{
		setImage(imageURL);
	}

	
	public void setImage(Image image)
	{
		if (image != null)
			this.image = image;
		else
			throw new IllegalArgumentException("invalid image: null");		
	}
	
	public void setImage(URL imageURL) throws IOException
	{
		image = ImageIO.read(imageURL);
	}
	
	
	

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (image != null)
		{
			int ratio = image.getHeight(this) * 1000 / image.getWidth(this);
			int width = getWidth();
			int height = getHeight();
			if (width * ratio / 1000 < height)
				height = width * ratio / 1000;
			else
				width = height * 1000 / ratio;
			g.drawImage(image, (getWidth()-width)/2, (getHeight()-height)/2, width, height, this);			
		}
	}
	
	


}
