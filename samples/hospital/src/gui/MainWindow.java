package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import patients.Adress;
import patients.Patient;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class MainWindow extends JFrame
{

	// Oberflächenelemente
	private JPanel contentPane;
	private JList<Patient> jlPatients;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfSvnr;
	private JTextField tfCity;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnMale;

	
	// references to data
	private DefaultListModel<Patient> patientModel = new DefaultListModel<>();

	// additional tools
	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
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
		initFrame();
		
		// JList a reference to its data model
		jlPatients.setModel(patientModel);
		
		// add the radio buttons to a button group
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnFemale);
		group.add(rdbtnMale);
	}
	
	private void initFrame()
	{
		setTitle("Hospital with Departments");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		jlPatients = new JList();
		jlPatients.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				patientSelected(arg0);
			}
		});
		jlPatients.setModel(new AbstractListModel() {
			String[] values = new String[] {"Patient1", "Patient2", "Patient3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(jlPatients);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new GridLayout(0, 2, 5, 5));
		
		JLabel lblName = new JLabel("Name");
		panel.add(lblName);
		
		tfName = new JTextField();
		panel.add(tfName);
		tfName.setColumns(10);
		
		rdbtnMale = new JRadioButton("male");
		panel.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("female");
		panel.add(rdbtnFemale);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth (dd.MM.yyyyy)");
		panel.add(lblDateOfBirth);
		
		tfBirth = new JTextField();
		panel.add(tfBirth);
		tfBirth.setColumns(10);
		
		JLabel lblSocialSecurityNr = new JLabel("Social Security Nr");
		panel.add(lblSocialSecurityNr);
		
		tfSvnr = new JTextField();
		panel.add(tfSvnr);
		tfSvnr.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				savePatient(arg0);
			}
		});
		
		JLabel lblCity = new JLabel("City");
		panel.add(lblCity);
		
		tfCity = new JTextField();
		panel.add(tfCity);
		tfCity.setColumns(10);
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("New");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPatient(e);
			}
		});
		panel.add(btnCancel);
	}

	
	// will be invoked by clicking the SAVE button
	protected void savePatient(ActionEvent ae) 
	{
		try
		{
			Patient p = jlPatients.getSelectedValue();
			if (p == null)
			{
				newPatient(ae);
			}
			else
			{
				updatePatient(p);
			}
			
		} catch (ParseException e)
		{
			JOptionPane.showMessageDialog(this, "Date format is not correct");
		} catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this, "not a number");
		}
	}
	
	// will be invoked by clicking the NEW button
	protected void newPatient(ActionEvent ae) 
	{
		try
		{
			Patient p = new Patient(Integer.parseInt(tfSvnr.getText()));
			updatePatient(p);
			patientModel.addElement(p);
			jlPatients.setSelectedValue(p, true);
		} catch (ParseException e)
		{
			JOptionPane.showMessageDialog(this, "Date format is not correct");
		} catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this, "not a number");
		}
	}
	
	
	// will be invoked when a patient is selected in the list
	protected void patientSelected(ListSelectionEvent lse) 
	{
		Patient p = jlPatients.getSelectedValue();
		if (p != null)
		{
			updateFields(p);
		}
	}
	
	// used by newPatient() and savePatient()
	private void updatePatient(Patient p) throws ParseException, NumberFormatException
	{
		String name = tfName.getText();
		Date birth = sdf.parse(tfBirth.getText());
		String city = tfCity.getText();
		
		p.setBirth(birth);
		p.setName(name);
		Adress a = p.getAdress();
		a.setCity(city);
		p.setAdress(a);
		
		if (rdbtnFemale.isSelected())
			p.setFemale(true);
		else
			p.setFemale(false);
		
		
		jlPatients.repaint();
	}
	
	// used by patientSelected()
	private void updateFields(Patient p)
	{
		tfName.setText(p.getName());
		tfBirth.setText(sdf.format(p.getBirth()));
		tfSvnr.setText(String.valueOf(p.getSvnr()));
		tfCity.setText(p.getAdress().getCity());
		if (p.isFemale())
			rdbtnFemale.setSelected(true);
		else
			rdbtnMale.setSelected(true);
			
	}
	
	
}
