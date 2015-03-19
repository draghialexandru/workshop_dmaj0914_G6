package GUILayer;

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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton button_1;
	private JButton button;
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
		panel_1.setBounds(10, 11, 372, 240);
		panel.add(panel_1);
		
		JLabel label = new JLabel("ID");
		label.setBounds(10, 25, 11, 14);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(62, 22, 86, 20);
		panel_1.add(textField);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(10, 53, 42, 14);
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(62, 50, 86, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(62, 79, 86, 20);
		panel_1.add(textField_2);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 82, 53, 14);
		panel_1.add(lblAddress);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(62, 107, 86, 20);
		panel_1.add(textField_3);
		
		JLabel lblZipcode = new JLabel("ZipCode");
		lblZipcode.setBounds(10, 110, 42, 14);
		panel_1.add(lblZipcode);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(62, 135, 86, 20);
		panel_1.add(textField_4);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(10, 138, 53, 14);
		panel_1.add(lblCity);
		
		button = new JButton("Find");
		button.setBounds(158, 49, 89, 23);
		panel_1.add(button);
		
		button_1 = new JButton("Add");
		button_1.setBounds(158, 21, 89, 23);
		panel_1.add(button_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(62, 166, 86, 20);
		panel_1.add(textField_5);
		
		JLabel lblPhoneno = new JLabel("PhoneNo");
		lblPhoneno.setBounds(10, 169, 53, 14);
		panel_1.add(lblPhoneno);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(158, 78, 89, 23);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(158, 106, 89, 23);
		panel_1.add(btnDelete);
		
		JButton btnOk = new JButton("Ok");
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
