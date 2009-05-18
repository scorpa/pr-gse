package fotoquiz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FotoQuiz extends JFrame
{
	int rows;
	int columns;
	private PanelWithBackground panel;
	private List<Image> images = new ArrayList<Image>();
	private JButton[][] buttons;
	Iterator<Image> nextImage;
	
	public FotoQuiz()
	{
		InputStream confStream = getClass().getResourceAsStream("/fotoquiz/images.conf");
		try
		{
			if (confStream != null)
			{
				BufferedReader conf = new BufferedReader(new InputStreamReader(confStream));
				String dimStr = conf.readLine();
				try
				{
					StringTokenizer tokenz = new StringTokenizer(dimStr);
					rows = Integer.parseInt(tokenz.nextToken());
					columns = Integer.parseInt(tokenz.nextToken());
				} catch(Exception e)
				{
					throw new IOException("invalid format of config file");
				}
				String name = conf.readLine();
				while (name != null && name.trim().length() > 0)
				{
					URL url = getClass().getResource(name);
					if (url == null)
						throw new IOException("cannot find image: " + name);
					Image img = ImageIO.read(url);
					images.add(img);
					name = conf.readLine();
				}
				conf.close();
				nextImage = images.iterator();
			}
			else
				throw new IOException("cannot read configuration file");
			
			initFrame();				
		} catch(Exception e)
		{
            e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error loading images", JOptionPane.ERROR_MESSAGE);
		}
		finally
		{
			if (confStream != null)
				try
				{
					confStream.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		}
	}

	private void initFrame()
	{
		buttons = new JButton[rows][columns];
		panel = new PanelWithBackground();
		if (nextImage.hasNext())
			panel.setImage(nextImage.next());
		panel.setLayout(new GridLayout(rows, columns));
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < columns; c++)
			{
				JButton jbn = new JButton("" + (r*columns+c+1));
				jbn.setFont(jbn.getFont().deriveFont(20f));
				buttons[r][c] = jbn ;
				panel.add(jbn);
				jbn.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						JButton bn = (JButton) e.getSource();
						bn.setVisible(false);
					}});
			}
		add(panel, BorderLayout.CENTER);
		JPanel buttons = new JPanel(new FlowLayout());
		add(buttons, BorderLayout.SOUTH);
		JButton open = new JButton("X");
		buttons.add(open);
		JButton next = new JButton("-->");
		buttons.add(next);
		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				open();
			}});
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				next();
			}});
		
		
		
	}
	
	
	protected void next()
	{
		if (nextImage.hasNext())
		{
			panel.setImage(nextImage.next());
			hideAll();
		}
		else
			JOptionPane.showMessageDialog(this, "keine weiteren Bilder mehr");
	}

	private void hideAll()
	{
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < columns; c++)
				buttons[r][c].setVisible(true);
		
	}

	protected void open()
	{
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < columns; c++)
				buttons[r][c].setVisible(false);
	}

	public static void main(String[] args)
	{
		try
		{
			FotoQuiz quiz = new FotoQuiz();
			quiz.setDefaultCloseOperation(EXIT_ON_CLOSE);
			quiz.setSize(800, 600);
			quiz.setVisible(true);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
