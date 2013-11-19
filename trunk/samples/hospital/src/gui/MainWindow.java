package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class MainWindow extends JFrame
{

	private JPanel contentPane;
	private JList<Patient> jlPatients;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfSvnr;
	private JTextField tfCity;
	
	private DefaultListModel<Patient> patientModel = new DefaultListModel<>();
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
		jlPatients.setModel(patientModel);
		// hierher Code, welcher nicht zum Fensteraufbau gehört
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
				do_jlPatients_valueChanged(arg0);
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
				do_btnSave_actionPerformed(arg0);
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
				do_btnCancel_actionPerformed(e);
			}
		});
		panel.add(btnCancel);
	}

	protected void do_btnSave_actionPerformed(ActionEvent arg0) 
	{
		try
		{
			
			String name = tfName.getText();
			Date birth = sdf.parse(tfBirth.getText());
			int ssn = Integer.parseInt(tfSvnr.getText());
			String city = tfCity.getText();
			
			Patient p = new Patient(ssn);
			p.setBirth(birth);
			p.setName(name);
			Adress a = new Adress();
			a.setCity(city);
			p.setAdress(a);
			
			patientModel.addElement(p);
			
		} catch (ParseException e)
		{
			JOptionPane.showMessageDialog(this, "Date format is not correct");
		} catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this, "not a number");
		}
	}
	
	protected void do_btnCancel_actionPerformed(ActionEvent e) 
	{
		tfName.setText("");
		tfBirth.setText("");
		tfSvnr.setText("");
		tfCity.setText("");
	}
	
	
	protected void do_jlPatients_valueChanged(ListSelectionEvent arg0) 
	{
		Patient p = jlPatients.getSelectedValue();
		if (p != null)
		{
			tfName.setText(p.getName());
			tfBirth.setText(sdf.format(p.getBirth()));
			tfSvnr.setText(String.valueOf(p.getSvnr()));
			
		}
		
		
	}
}
