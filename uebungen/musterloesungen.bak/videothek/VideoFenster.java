package videothek;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
 * Prüfungsaufgabe Videothek
 * Fensterklasse
 * @author Rudolf Radlbauer
 *
 */
@SuppressWarnings("serial")
public class VideoFenster extends JFrame
{
    private final static String SPEICHER_DATEI = "videothek/video.ser";
    
    private Video video;
	
	private JTextField tfTitel;
	private JComboBox cbGenre;
	private SpinnerNumberModel smDauer;
	private JRadioButton rbDVD;
	private JRadioButton rbVCD;
	private JRadioButton rbVHS;
	private JCheckBox cbGesehen;
	
	/**
	 * Initialisiert das Fenster
	 */
	public VideoFenster()
	{
		setTitle("Meine Videos");
		initFenster();
		laden();
	}

	/**
	 * baut das Layout auf
	 */
	private void initFenster()
	{
        cbGenre = new JComboBox();
        try
        {
            for (String genre : Config.getGenres())
                cbGenre.addItem(genre);
                
        } catch (IOException e)
        {
            e.printStackTrace();
            // falls Datei nicht gefunden wurde, verwenden wir Standardeinträge
            cbGenre.addItem("Krimi");
            cbGenre.addItem("Science-Fiction");
            cbGenre.addItem("Kommödie");
            cbGenre.addItem("Drama");
        }
		
		tfTitel = new JTextField();
		smDauer = new SpinnerNumberModel(0, 0, 1000, 1);
		rbDVD = new JRadioButton();
		rbVCD = new JRadioButton();
		rbVHS = new JRadioButton();
		cbGesehen = new JCheckBox();
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
	
	/**
	 * liest Daten aus Eingabefeldern und erzeugt daraus eine Video-Instanz;
	 * speichert die Instanz mittels Serialisierung
	 */
	private void speichern()
    {
        try
        {
            Video v = new Video();
            v.setTitel(tfTitel.getText());
            v.setGenre((String) cbGenre.getSelectedItem());
            v.setDauer(smDauer.getNumber().intValue());
            if (rbDVD.isSelected()) v.setMedium(Video.MEDIUM.DVD);
            else if (rbVCD.isSelected()) v.setMedium(Video.MEDIUM.VCD);
            else if (rbVHS.isSelected()) v.setMedium(Video.MEDIUM.VHS);
            v.setGesehen(cbGesehen.isSelected());
        
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SPEICHER_DATEI));
            out.writeObject(v);
            out.close();
            JOptionPane.showMessageDialog(this, "Daten gespeichert");
        }  catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, "Fehler beim Speichern der Daten");
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());            
        }
    }
	
	/**
	 * liest Video-Instanz aus serialisierter Datei, falls vorhanden;
	 * befüllt die Eingabefelder mit den Werten aus der Video-Instanz
	 */
	private void laden()
	{
	    try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(SPEICHER_DATEI));
            video = (Video) in.readObject();
            in.close();
            tfTitel.setText(video.getTitel());
            cbGenre.setSelectedItem(video.getGenre());
            smDauer.setValue(video.getDauer());
            switch(video.getMedium())
            {
            case DVD: rbDVD.setSelected(true); break;
            case VCD: rbVCD.setSelected(true); break;
            case VHS: rbVHS.setSelected(true); break;
            }
            cbGesehen.setSelected(video.isGesehen());
            
        } catch (FileNotFoundException e)
        {
            video = new Video();
            System.out.println("erster Programmstart");
            // erster Programmstart -> Datei existiert noch nicht
        } catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Fehler beim Laden der Daten");
        }
	}

    public static void main(String[] args)
	{
		VideoFenster fenster = new VideoFenster();
		fenster.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fenster.pack();
		fenster.setVisible(true);
	}

}
