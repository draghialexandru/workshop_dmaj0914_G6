package GUILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Customer extends JFrame{
	private JTextField textID;
	private JTextField textPhone;
	private JButton btnContinue;
	private JButton btnMoreoptions;
	public Customer() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 350, 120);
		this.setTitle("Western Style Ltd.");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textID = new JTextField();
		textID.setBounds(91, 11, 86, 20);
		panel.add(textID);
		textID.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setBounds(91, 42, 86, 20);
		panel.add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 14, 46, 14);
		panel.add(lblId);
		
		JLabel lblPhoneno = new JLabel("PhoneNo");
		lblPhoneno.setBounds(10, 45, 71, 14);
		panel.add(lblPhoneno);
		
		btnContinue = new JButton("Continue");
		btnContinue.setBounds(211, 41, 113, 23);
		btnContinue.addActionListener(new java.awt.event.ActionListener(){

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
		panel.add(btnContinue);
		
		btnMoreoptions = new JButton("MoreOptions");
		btnMoreoptions.setBounds(211, 10, 113, 23);
		btnMoreoptions.addActionListener(new java.awt.event.ActionListener(){

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
				CRUDgui main = new CRUDgui();
					main.setVisible(true);
					main.setLocationRelativeTo(null);
			}
			
		});
		panel.add(btnMoreoptions);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setVisible(true);
		customer.setLocationRelativeTo(null);
	}
}
