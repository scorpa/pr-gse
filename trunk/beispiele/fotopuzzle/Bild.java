package fotopuzzle;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Created on 23.10.2009
 *
 */

public class Bild extends JPanel implements MouseMotionListener, MouseListener, MouseWheelListener
{
    private BufferedImage bild;
    private Gitter gitter;
    private double ratio;
    
    private Point start = new Point();
    private Point old = new Point();
    
    public Bild()
    {
        this(new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB));  // dummy
    }
    
    public Bild(BufferedImage bild) 
    {
        setBild(bild);
        gitter = new Gitter();
        gitter.setBounds(0, 0, 800, 800);
        addMouseListener(this);
        addMouseMotionListener(this);
        addMouseWheelListener(this);
    }
    
    public void setBild(BufferedImage bild)
    {
        this.bild = bild;
        ratio = (double)bild.getHeight() / bild.getWidth();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        
        Dimension d = calcImageSize();
        
        g.drawImage(bild, 0, 0, d.width, d.height, this);
        gitter.paintComponent(g);

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        int x = e.getPoint().x - start.x;
        int y = e.getPoint().y - start.y;
        Point neu = new Point(old.x + x, old.y + y);
        gitter.setLocation(neu);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        start = e.getPoint();
        old = gitter.getLocation();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        int size = gitter.getWidth() - e.getUnitsToScroll();
        gitter.setSize(size, size);
        repaint();
    }
    
    public Dimension calcImageSize()
    {
        double r = (double)getHeight() / getWidth();
        int w = getWidth();
        int h = getHeight();
        if (r < ratio)
            w = (int)(h / ratio);
        else
            h = (int)(w * ratio);
        return new Dimension(w,h);

    }
    
    
    public void save(File folder) throws IOException
    {
        double pixels = (int)((double)bild.getWidth() / calcImageSize().width * gitter.getWidth());
        int bPix = (int)(pixels * 0.181);  // Bildchen
//        int qPix = (int)(pixels * 0.25);   // Quadrat (Bildchen mit Rand)
//        int rPix = (int)(pixels * 0.033);  // Rand
//        int x = (int)(pixels * gitter.getX() / gitter.getWidth());
//        int y = (int)(pixels * gitter.getY() / gitter.getWidth());
//        
//        BufferedImage[][] bildchen = new BufferedImage[4][4];
//        
//        for (int z = 0; z < 4; z++)
//            for (int s = 0; s < 4; s++)
//            {
//                int xpos = s * qPix + rPix + x;
//                int ypos = z * qPix + rPix + y;
//                bildchen[z][s] = bild.getSubimage(xpos, ypos, bPix, bPix);
//            }
//        
//        BufferedImage bild1015 = new BufferedImage((int)(bPix*10/4.5), (int)(bPix*15/4.5), bild.getType());
//        
        
        BufferedImage druck1 = new BufferedImage((int)(bPix*10.2/4.5), (int)(bPix*15.2/4.5), bild.getType());
        BufferedImage druck2 = new BufferedImage((int)(bPix*10.2/4.5), (int)(bPix*15.2/4.5), bild.getType());
        BufferedImage druck3 = new BufferedImage((int)(bPix*10.2/4.5), (int)(bPix*15.2/4.5), bild.getType());
        
        copy(0, 0, druck1, 0, 0);
        copy(0, 1, druck1, 0, 1);
        copy(0, 2, druck1, 1, 0);
        copy(0, 3, druck1, 1, 1);
        copy(1, 0, druck1, 2, 0);
        copy(1, 1, druck1, 2, 1);
        
        copy(1, 2, druck2, 0, 0);
        copy(1, 3, druck2, 0, 1);
        copy(2, 0, druck2, 1, 0);
        copy(2, 1, druck2, 1, 1);
        copy(2, 2, druck2, 2, 0);
        copy(2, 3, druck2, 2, 1);
        
        copy(3, 0, druck3, 0, 0);
        copy(3, 1, druck3, 0, 1);
        copy(3, 2, druck3, 1, 0);
        copy(3, 3, druck3, 1, 1);
        
        String folderName = folder.getAbsolutePath() + File.separator;
        
        
        ImageIO.write(druck1, "jpg", new File(folderName + "druck1.jpg"));
        ImageIO.write(druck2, "jpg", new File(folderName + "druck2.jpg"));
        ImageIO.write(druck3, "jpg", new File(folderName + "druck3.jpg"));
        
        
    }
    
 
    
    private void copy(int origZeile, int origSpalte, BufferedImage target, int zeile, int spalte)
    {
        double pixels = (int)((double)bild.getWidth() / calcImageSize().width * gitter.getWidth());
        int bPix = (int)(pixels * 0.181);  // Bildchen
        int qPix = (int)(pixels * 0.25);   // Quadrat (Bildchen mit Rand)
        int rPix = (int)(pixels * 0.033);  // Rand
        int x = (int)(pixels * gitter.getX() / gitter.getWidth());
        int y = (int)(pixels * gitter.getY() / gitter.getWidth());
        int offset = bPix/5;
        
        for (int z = 0; z < bPix; z++)
            for (int s = 0; s < bPix; s++)
            {
                int rgb = bild.getRGB(origSpalte * qPix + rPix + x + s, origZeile * qPix + rPix + y + z); 
                target.setRGB(spalte * bPix + s + offset, zeile * bPix + z + offset, rgb); 
                        
            }

//        int[] buffer = bild.getRGB(origSpalte * qPix + rPix + x, origZeile * qPix + rPix + y, bPix , bPix, null, 0, 0);
//        target.setRGB(spalte * bPix, zeile * bPix, bPix, bPix, buffer, 0, 0);
    }

}
