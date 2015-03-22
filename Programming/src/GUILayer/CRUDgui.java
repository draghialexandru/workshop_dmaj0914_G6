package GUILayer;

import ControlLayer.CtrCus;
import ModelLayer.Customer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

public class CRUDgui extends JFrame{
	private JTextField textID;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textZip;
	private JTextField textCity;
	private JTextField textPhone;
	private JButton btnAdd;
	private JButton btnFind;
	private JLabel lblError;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnOk;
	private CtrCus ctrCus = new CtrCus();
	public CRUDgui() {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 500, 300);
		this.setTitle("Western Style Ltd.");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("");
		panel_1.setName("");
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 464, 206);
		panel.add(panel_1);
		
		JLabel label = new JLabel("ID");
		label.setBounds(10, 25, 11, 14);
		panel_1.add(label);
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(62, 22, 86, 20);
		panel_1.add(textID);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(10, 53, 42, 14);
		panel_1.add(label_1);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(62, 50, 86, 20);
		panel_1.add(textName);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(62, 79, 86, 20);
		panel_1.add(textAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 82, 53, 14);
		panel_1.add(lblAddress);
		
		textZip = new JTextField();
		textZip.setColumns(10);
		textZip.setBounds(62, 107, 86, 20);
		panel_1.add(textZip);
		
		JLabel lblZipcode = new JLabel("ZipCode");
		lblZipcode.setBounds(10, 110, 42, 14);
		panel_1.add(lblZipcode);
		
		textCity = new JTextField();
		textCity.setColumns(10);
		textCity.setBounds(62, 135, 86, 20);
		panel_1.add(textCity);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(10, 138, 53, 14);
		panel_1.add(lblCity);
		
		btnFind = new JButton("Find");
		btnFind.setBounds(158, 49, 89, 23);
		btnFind.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textID.getText()!=null || textPhone.getText()!=null)
				{
					Customer customer = ctrCus.findByID(textID.getText());
					//System.out.println("done");
					textName.setText(customer.getName());
					textAddress.setText(customer.getAddress());
					textZip.setText(customer.getZipcode());
					textCity.setText(customer.getCity());
					textPhone.setText(customer.getPhoneno());
					lblError.setText("comand competed");
				}
				else
				{
					lblError.setText("insert id or phone no");
				}
			}
			
		});
		panel_1.add(btnFind);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(158, 21, 89, 23);
		btnAdd.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(textID.getText().length()>0 && textName.getText().length()>0  && textAddress.getText().length()>0  && textZip.getText().length()>0 && textCity.getText().length()>0 && textPhone.getText().length()>0)
				{
					Customer customer = new Customer();
					customer.setID(textID.getText());
					customer.setName(textName.getText());
					customer.setAddress(textAddress.getText());
					customer.setZipcode(textZip.getText());
					customer.setCity(textCity.getText());
					customer.setPhoneno(textPhone.getText());
					ctrCus.insertNew(customer);
					lblError.setText("customer added");
				}
				else
				{
					lblError.setText("fill all fields");
				}
			}
			
		});
		panel_1.add(btnAdd);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(62, 166, 86, 20);
		panel_1.add(textPhone);
		
		JLabel lblPhoneno = new JLabel("PhoneNo");
		lblPhoneno.setBounds(10, 169, 53, 14);
		panel_1.add(lblPhoneno);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(158, 78, 89, 23);
		btnUpdate.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(textID.getText().length()>0 && textName.getText().length()>0  && textAddress.getText().length()>0  && textZip.getText().length()>0 && textCity.getText().length()>0 && textPhone.getText().length()>0)
				{
					ctrCus.updateCus(textID.getText(), textName.getText(), textAddress.getText(), textZip.getText(), textCity.getText(), textPhone.getText());
					lblError.setText("customer updated");
				}
				else
				{
					lblError.setText("fill all fields");
				}
			}
			
		});
		panel_1.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(158, 106, 89, 23);
		btnDelete.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				lblError.setText("Sorry I want to have information about everyone");
			}
			
		});
		panel_1.add(btnDelete);
		
		lblError = new JLabel("");
		lblError.setBounds(158, 138, 296, 48);
		panel_1.add(lblError);
		
		btnOk = new JButton("Ok");
		btnOk.setBounds(385, 228, 89, 23);
		btnOk.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*
				if(textID.getText() == )
				{
					
				}
				else
				{
					
				}
				*/
				MainGUI main = new MainGUI();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
			}
			
		});
		panel.add(btnOk);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
