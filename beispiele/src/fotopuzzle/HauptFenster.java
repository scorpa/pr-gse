package fotopuzzle;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/*
 * Created on 23.10.2009
 *
 */

public class HauptFenster extends JFrame
{
    private Bild bild = new Bild();
    
    public HauptFenster()
    {
        initMenu();
        setLayout(new BorderLayout());
        add(bild);
    }

    private void initMenu()
    {
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        JMenu file = new JMenu("Datei");
        menubar.add(file);
        JMenuItem save = new JMenuItem("Speichern");
        file.add(save);
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                save();
            }});
        JMenuItem load = new JMenuItem("laden");
        file.add(load);
        load.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                load();
            }});
        
    }

    protected void load()
    {
        try
        {
            JFileChooser chooser = new JFileChooser("D:");
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
            {
                bild.setBild(ImageIO.read(chooser.getSelectedFile()));
                repaint();
            }
        } catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }        
    }

    protected void save()
    {
        try
        {
            JFileChooser chooser = new JFileChooser("D:");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
            {
                bild.save(chooser.getSelectedFile());
            }
        } catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }
    
    public static void main(String[] args)
    {
        HauptFenster fenster = new HauptFenster();
        fenster.setSize(800, 800);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setVisible(true);
    }
    
}
