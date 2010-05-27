/*
 * Created on 11.06.2009
 *
 */
package videothek;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


/**
 * schnellere Lösung für die Aufgabe - hier wird gleich das Fenster serialisiert.
 * @author Rudolf Radlbauer
 *
 */
public class QuickAndDirty extends JFrame
{
    private static final long serialVersionUID = 593962652765408287L;

    private final static String SPEICHER_DATEI = "videothek/quickanddirty.ser";
    
    private JTextField tfTitel = new JTextField();
    private JComboBox cbGenre = new JComboBox();
    private SpinnerNumberModel smDauer = new SpinnerNumberModel();
    private JRadioButton rbDVD = new JRadioButton();
    private JRadioButton rbVCD = new JRadioButton();
    private JRadioButton rbVHS = new JRadioButton();
    private JCheckBox cbGesehen = new JCheckBox();
    
    
    public QuickAndDirty()
    {
        setTitle("Meine Videos");
        initFenster();
        ladeGenres();
    }
    
    
    private void ladeGenres()
    {
        try
        {
            InputStream stream = Config.class.getResourceAsStream("genres.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String genre = reader.readLine();
            while (genre != null)
            {
                if (genre.trim().length() > 0)
                    cbGenre.addItem(genre);
                genre = reader.readLine();
            }
            reader.close();
            stream.close();
        } catch(IOException e)
        {
            e.printStackTrace();
            // falls Datei nicht gefunden wurde, verwenden wir Standardeinträge
            cbGenre.addItem("Krimi");
            cbGenre.addItem("Science-Fiction");
            cbGenre.addItem("Kommödie");
            cbGenre.addItem("Drama");

        }
    }
        


    private void initFenster()
    {
        ButtonGroup group = new ButtonGroup();
        group.add(rbDVD);
        group.add(rbVCD);
        group.add(rbVHS);
        rbDVD.setSelected(true);
        

        setLayout(new GridLayout(8,2));
        
        add(new JLabel("Filmtitel"));
        add(tfTitel);
        add(new JLabel("Genre"));
        add(cbGenre);
        add(new JLabel("Spieldauer (Min)"));
        add(new JSpinner(smDauer));
        add(new JLabel("DVD"));
        add(rbDVD);
        add(new JLabel("VideoCD"));
        add(rbVCD);
        add(new JLabel("VHS"));
        add(rbVHS);
        add(new JLabel("gesehen"));
        add(cbGesehen);
        
        JButton bnSpeichern = new JButton("Speichern");
        add(bnSpeichern);
        bnSpeichern.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                speichern();
            }});
    }
    
    private void speichern()
    {
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SPEICHER_DATEI));
            out.writeObject(this);
            out.close();
            JOptionPane.showMessageDialog(this, "Daten gespeichert");
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, "Fehler beim Speichern der Daten");
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());            
        }
    }
    
    
    public static void main(String[] args)
    {
        QuickAndDirty fenster = null;
        
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(SPEICHER_DATEI));
            fenster = (QuickAndDirty) in.readObject();
            in.close();
        } catch (FileNotFoundException e)
        {
            fenster = new QuickAndDirty();;
            System.out.println("erster Programmstart");
            // erster Programmstart -> Datei existiert noch nicht
        } catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(fenster, "Fehler beim Laden der Daten");
        }
        if (fenster != null)
        {
            fenster.setDefaultCloseOperation(EXIT_ON_CLOSE);
            fenster.pack();
            fenster.setVisible(true);
        }

    }
        
}
