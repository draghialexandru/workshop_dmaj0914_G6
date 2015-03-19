package GUILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;

public class CheckoutGUI extends JFrame {
	
	private CheckoutGUI checkout;
	
	public CheckoutGUI() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 500, 300);
		this.setTitle("Western Style Ltd.");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnPay = new JButton("Pay");
		btnPay.setBounds(385, 228, 89, 23);
		btnPay.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				checkout.dispose();
			}
		});
		panel.add(btnPay);
		
		JButton btnInvoice = new JButton("Invoice");
		btnInvoice.setBounds(206, 228, 89, 23);
		panel.add(btnInvoice);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10, 228, 89, 23);
		btnCancel.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				checkout.dispose();
			}
		});
		panel.add(btnCancel);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotal.setBounds(10, 11, 74, 23);
		panel.add(lblTotal);
		
		JLabel label = new JLabel("0");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(94, 11, 74, 23);
		panel.add(label);
	}
	public void setCheckout(CheckoutGUI checkout)
	{
		this.checkout = checkout;
	}
}
