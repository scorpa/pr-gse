package reversi;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReversiPanel extends JPanel implements Observer
{
    private Reversi reversi;
    private JButton[][] buttons;
    private ImageIcon red;
    private ImageIcon green;
	private JLabel status = new JLabel();

    
    
    public ReversiPanel(Reversi r)
	{
        red = createIcon("/reversi/rss-red-32.png");
        green = createIcon("/reversi/rss-green-32.png");
        
        this.reversi = r;
        
        createButtons();
        initPanel();
	}
    
    private void createButtons()
    {
        buttons = new JButton[8][8];

        for (int x = 0; x < buttons.length; x++)
            for (int y = 0; y < buttons[0].length; y++)
            {
                buttons[x][y] = new JButton();
                buttons[x][y].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        click(e);
                    }});
            }        
        update(null, null);
    }
    
    private void initPanel()
    {
       setLayout(new BorderLayout());
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(8,8));        
        for (int row = 0; row < buttons.length; row++)
            for (int col = 0; col < buttons[0].length; col++)
                buttonPanel.add(buttons[row][col]);
        add(buttonPanel, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);
        
    }
    
    private void click(ActionEvent e)
    {
        for (int x = 0; x < buttons.length; x++)
            for (int y = 0; y < buttons[0].length; y++)
            {
                if (buttons[x][y] == e.getSource())
                    reversi.set(x, y);
            }
        update(null, null);
    }

    public void update(Observable o, Object arg)
    {
        for (int x = 0; x < buttons.length; x++)
            for (int y = 0; y < buttons[0].length; y++)
            {
                char farbe = reversi.get(x, y);
                if (farbe == 'r')
                    buttons[x][y].setIcon(red);
                else if (farbe == 'g')
                    buttons[x][y].setIcon(green);
                else
                    buttons[x][y].setIcon(null);
                
            }
        char next = reversi.next();
        if (next == 'g')
            status.setText("nächster Zug: grün");
        else
            status.setText("nächster Zug: rot");            
    }
    
    private ImageIcon createIcon(String datei)
    {
        URL url = getClass().getResource(datei);
        if (url != null)
            return new ImageIcon(url);
        else
            throw new IllegalStateException("Icon not found: " + datei);
    }

	
	public static void main(String[] args)
	{
		ReversiPanel brett = new ReversiPanel(new ReversiTestImpl());
        JFrame f = new JFrame("Reversi");
        f.add(brett);
        f.setSize(800,800);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
