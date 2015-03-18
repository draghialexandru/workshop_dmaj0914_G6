package GUILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MoreOptionsGUI extends JFrame {
	private JTextField textID;
	private JTextField textField;
	private MoreOptionsGUI moreOptions;
	
	public MoreOptionsGUI() {
		
		//this.moreOptions = moreOptions;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setTitle("Western Style Ltd.");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 46, 14);
		panel.add(lblId);
		
		textID = new JTextField();
		textID.setBounds(73, 8, 86, 20);
		panel.add(textID);
		textID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 36, 46, 14);
		panel.add(lblName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(73, 33, 86, 20);
		panel.add(textField);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(335, 228, 89, 23);
		btnOk.addActionListener(new java.awt.event.ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				moreOptions.dispose();
			}
			
			
		});
		panel.add(btnOk);
	}
	
	public void setOptions(MoreOptionsGUI moreOptions)
	{
		this.moreOptions = moreOptions;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
