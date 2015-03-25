package GUILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import java.awt.Canvas;
import javax.swing.JMenu;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class MoreOptionsGUI extends JFrame {
	private JTextField textID;
	private JTextField textField;
	private MoreOptionsGUI moreOptions;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnFind;
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnOk;
	private JPanel panel_2;
	private JLabel lblName_1;
	private JTextField textField_4;
	private JLabel lblAddress;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblPhoneNo;
	private JTextField textField_7;
	private JLabel lblOrderid;
	private JTextField textField_8;
	private JLabel lblPaid;
	private JButton button;
	private JButton button_1;
	
	public MoreOptionsGUI() {
		
		//this.moreOptions = moreOptions;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 500, 372);
		this.setTitle("Western Style Ltd.");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(385, 299, 89, 23);
		btnOk.addActionListener(new java.awt.event.ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				moreOptions.dispose();
			}
			
			
		});
		panel.add(btnOk);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Product", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setToolTipText("");
		panel_1.setName("");
		panel_1.setBounds(10, 11, 232, 262);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 25, 11, 14);
		panel_1.add(lblId);
		
		textID = new JTextField();
		textID.setBounds(62, 22, 86, 20);
		panel_1.add(textID);
		textID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 53, 42, 14);
		panel_1.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(62, 50, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(62, 79, 86, 20);
		panel_1.add(textField_1);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(10, 82, 53, 14);
		panel_1.add(lblQuantity);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(62, 107, 86, 20);
		panel_1.add(textField_2);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 110, 42, 14);
		panel_1.add(lblPrice);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(62, 135, 86, 20);
		panel_1.add(textField_3);
		
		JLabel lblSupplier = new JLabel("Supplier");
		lblSupplier.setBounds(10, 138, 53, 14);
		panel_1.add(lblSupplier);
		
		btnFind = new JButton("Find");
		btnFind.setBounds(109, 174, 89, 23);
		panel_1.add(btnFind);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 174, 89, 23);
		panel_1.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(10, 208, 89, 23);
		panel_1.add(btnUpdate);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(109, 208, 89, 23);
		panel_1.add(btnRemove);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10, 299, 89, 23);
		btnCancel.addActionListener(new java.awt.event.ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				moreOptions.dispose();
			}
		});
		panel.add(btnCancel);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setToolTipText("");
		panel_2.setName("");
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Supplier", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(242, 11, 232, 262);
		panel.add(panel_2);
		
		lblName_1 = new JLabel("Name");
		lblName_1.setBounds(10, 25, 42, 14);
		panel_2.add(lblName_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(62, 22, 86, 20);
		panel_2.add(textField_4);
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 53, 42, 14);
		panel_2.add(lblAddress);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(62, 50, 86, 20);
		panel_2.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(62, 79, 86, 20);
		panel_2.add(textField_6);
		
		lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setBounds(10, 82, 53, 14);
		panel_2.add(lblPhoneNo);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(62, 107, 86, 20);
		panel_2.add(textField_7);
		
		lblOrderid = new JLabel("ID");
		lblOrderid.setBounds(10, 110, 42, 14);
		panel_2.add(lblOrderid);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(62, 135, 86, 20);
		panel_2.add(textField_8);
		
		lblPaid = new JLabel("Country");
		lblPaid.setBounds(10, 138, 53, 14);
		panel_2.add(lblPaid);
		
		button = new JButton("Find");
		button.setBounds(109, 174, 89, 23);
		panel_2.add(button);
		
		button_1 = new JButton("Add");
		button_1.setBounds(10, 174, 89, 23);
		panel_2.add(button_1);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.setBounds(10, 208, 89, 23);
		panel_2.add(btnUpdate_1);
		
		JButton btnRemove_1 = new JButton("Remove");
		btnRemove_1.setBounds(109, 208, 89, 23);
		panel_2.add(btnRemove_1);
	}
	
	public void setOptions(MoreOptionsGUI moreOptions)
	{
		this.moreOptions = moreOptions;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
