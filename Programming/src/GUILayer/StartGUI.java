package GUILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import ControlLayer.CtrCus;
import ModelLayer.Customer;

public class StartGUI extends JFrame{
	private JTextField textID;
	private JButton btnContinue;
	private JButton btnMoreoptions;
	private Customer customer;
	private JLabel lblError;
	
	public StartGUI() {
		
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
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 14, 46, 14);
		panel.add(lblId);
		
		lblError = new JLabel("");
		lblError.setBounds(10, 45, 167, 14);
		panel.add(lblError);
		
		btnContinue = new JButton("Continue");
		btnContinue.setBounds(211, 41, 113, 23);
		btnContinue.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// 

				if(textID.getText().length() > 0 )
				{
					CtrCus control = new CtrCus();
					customer = control.findByID(textID.getText());
					String x = customer.getID().substring(0, 4).intern();
					String y = textID.getText().substring(0, 4).intern();
					System.out.println(x+y);
					if(x == y)
					{
						MainGUI main = new MainGUI();
						main.setVisible(true);
						main.setLocationRelativeTo(null);
					}
					else
					{
						lblError.setText("wrong id" + customer.getID());
					}
				}
				else
				{
					lblError.setText("write customer's id");
				}
				
			}
			
		});
		panel.add(btnContinue);
		
		btnMoreoptions = new JButton("MoreOptions");
		btnMoreoptions.setBounds(211, 10, 113, 23);
		btnMoreoptions.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				CRUDgui main = new CRUDgui();
				main.setVisible(true);
				main.setLocationRelativeTo(null);
			}
			
		});
		panel.add(btnMoreoptions);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StartGUI start = new StartGUI();
		start.setVisible(true);
		start.setLocationRelativeTo(null);
	}
}
