package GUILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MainGUI extends JFrame{
	private JTextField textSearch;
	private JTextField textAmount;
	private JButton btnCheckout;
	private JButton btnMoreOptions;
	private JButton btnRemove;
	private JButton btnAdd;
	private JLabel label_4;
	private JLabel label_3;
	private JLabel label_2;
	private JLabel label_1;
	private JLabel label;
	private static MainGUI mainGUI;
	public MainGUI() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 500, 300);
		this.setTitle("Western Style Ltd.");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setBounds(10, 11, 46, 14);
		panel.add(lblSearch);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(178, 11, 54, 14);
		panel.add(lblAmount);
		
		textSearch = new JTextField();
		textSearch.setBounds(66, 8, 86, 20);
		panel.add(textSearch);
		textSearch.setColumns(10);
		
		textAmount = new JTextField();
		textAmount.setColumns(10);
		textAmount.setBounds(242, 8, 86, 20);
		panel.add(textAmount);
		
		label = new JLabel("");
		label.setBounds(10, 36, 464, 26);
		panel.add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(10, 73, 464, 26);
		panel.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(10, 110, 464, 26);
		panel.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setBounds(10, 147, 464, 26);
		panel.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setBounds(10, 184, 464, 26);
		panel.add(label_4);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(385, 228, 89, 23);
		btnAdd.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try
				{
					int searchID = Integer.parseInt(textSearch.getText());
					int amount = Integer.parseInt(textAmount.getText());
					//control.returnProductByID(searchID, amount);
					
				}
				catch(Exception e)
				{
					String searchName = textSearch.getText();
					try
					{
						int amount = Integer.parseInt(textAmount.getText());
						//control.returnProductByName(searchName, amount);
					}
					catch(Exception evt)
					{
						System.out.println("bad amount input");
					}
				}
			}
		});
		panel.add(btnAdd);
		
		btnRemove = new JButton("Remove");
		btnRemove.setBounds(286, 228, 89, 23);
		btnRemove.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try
				{
					int searchID = Integer.parseInt(textSearch.getText());
					int amount = Integer.parseInt(textAmount.getText());
					//control.removeProductByID(searchID, amount);
					
				}
				catch(Exception e)
				{
					String searchName = textSearch.getText();
					try
					{
						int amount = Integer.parseInt(textAmount.getText());
						//control.removeProductByName(searchName, amount);
					}
					catch(Exception evt)
					{
						System.out.println("bad amount input");
					}
				}
			}
		});
		panel.add(btnRemove);
		
		btnMoreOptions = new JButton("More Options");
		btnMoreOptions.setBounds(156, 228, 120, 23);
		btnMoreOptions.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MoreOptionsGUI moreOptions = null;
				moreOptions = new MoreOptionsGUI();
				moreOptions.setVisible(true);
				moreOptions.setLocationRelativeTo(null);
				moreOptions.setOptions(moreOptions);
			}
		});
		panel.add(btnMoreOptions);
		
		btnCheckout = new JButton("Check-out");
		btnCheckout.setBounds(10, 228, 112, 23);
		btnCheckout.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CheckoutGUI checkout = null;
				checkout = new CheckoutGUI();
				checkout.setVisible(true);
				checkout.setLocationRelativeTo(null);
				checkout.setCheckout(checkout);
			}
		});
		panel.add(btnCheckout);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		mainGUI = new MainGUI();
		mainGUI.setVisible(true);
		mainGUI.setLocationRelativeTo(null);
		*/
	}

}
