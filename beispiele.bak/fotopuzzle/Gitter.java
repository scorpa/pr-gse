package fotopuzzle;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/*
 * Created on 23.10.2009
 *
 */

public class Gitter extends JComponent
{
    private final static int RAND = 2048;

    @Override
    protected void paintComponent(Graphics g)
    {
        int size = getWidth();
        g.setColor(Color.black);
        
        for (int i = 0; i < 4; i++)
        {
            // senkrecht
            g.fillRect(getX() + (int)(size*0.25*i), getY(), (int)(size*0.033), size);
            g.fillRect(getX() + (int)(size*0.25*i + size*0.2177), getY(), (int)(size*0.033), size);
            // waagrecht
            g.fillRect(getX(), getY() + (int)(size*0.25*i), size, (int)(size*0.033));
            g.fillRect(getX(), getY() + (int)(size*0.25*i + size*0.2177), size, (int)(size*0.033));
        }
        
        g.fillRect(getX()-RAND, getY()-RAND, RAND, RAND*3);
        g.fillRect(getX()-RAND, getY()-RAND, RAND*3, RAND);
        g.fillRect(getX()+getWidth(), getY()-RAND, RAND, RAND*3);
        g.fillRect(getX()-RAND, getY()+getHeight(), RAND*3, RAND);
        g.setColor(Color.red);
        g.drawRect(getX(), getY(), getWidth(), getHeight());
        
    }

}
