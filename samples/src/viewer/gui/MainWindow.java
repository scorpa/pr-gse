package viewer.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import viewer.data.Image;
import viewer.data.Patient;
import viewer.dicom.DicomFileReader;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.swing.JLayeredPane;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

public class MainWindow extends JFrame
{
	private PatientTree patientTree;
	private DicomFileReader dcmReader;
	private ImagePanel imagePanel;
	private JTextArea descriptionText = new JTextArea();

	private JPanel contentPane;
	private JScrollPane mainPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow()
	{
		setTitle("DICOM Viewer");
		initWindow();
		try
		{
			imagePanel = new ImagePanel();
			dcmReader = new DicomFileReader();
			descriptionText.setEditable(false);
		} catch (Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void initWindow()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmAddFile = new JMenuItem("add file / folder");
		mntmAddFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmAddFile_actionPerformed(e);
			}
		});
		mnFile.add(mntmAddFile);
		
		JMenuItem mntmClear = new JMenuItem("clear");
		mntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmClear_actionPerformed(e);
			}
		});
		mnFile.add(mntmClear);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		patientTree = new PatientTree();
		patientTree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				do_patientTree_valueChanged(arg0);
			}
		});
		patientTree.setRootVisible(false);
		patientTree.setShowsRootHandles(true);
		scrollPane.setViewportView(patientTree);
		
		mainPanel = new JScrollPane();
		splitPane.setRightComponent(mainPanel);
	}

	protected void do_mntmAddFile_actionPerformed(ActionEvent e) 
	{
		JFileChooser fc = new JFileChooser(new File("."));
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setMultiSelectionEnabled(true);
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
		{
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			try
			{
				for (File f : fc.getSelectedFiles())
				{
					dcmReader.readHeaders(f);
					patientTree.setPatients(dcmReader.getPatients());
				}
			} catch(Throwable t)
			{
				t.printStackTrace();
				JOptionPane.showMessageDialog(this, t.getMessage());
			}
			setCursor(Cursor.getDefaultCursor());
		}
	}
	
	protected void do_mntmClear_actionPerformed(ActionEvent e) 
	{
		dcmReader.clear();
		patientTree.setPatients(dcmReader.getPatients());
	}
	
	protected void do_patientTree_valueChanged(TreeSelectionEvent arg0) 
	{
		try
		{
			Object selected = patientTree.getSelectedObject();
			if (selected != null)
			{
				if (selected instanceof Image)
				{
					mainPanel.setViewportView(null);
					mainPanel.setViewportView(imagePanel);
					imagePanel.setImage((Image) selected);
				}
				else
				{
					mainPanel.setViewportView(null);
					mainPanel.setViewportView(descriptionText);
					descriptionText.setText(selected.toString());
				}
			}
			mainPanel.repaint();
		} catch (Throwable e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
}
