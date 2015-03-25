package GUILayer;

import ControlLayer.CtrProduct;
import ModelLayer.Product;

import ControlLayer.CtrSupp;
import ModelLayer.Supplier;

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
	private JTextField textName;
	private MoreOptionsGUI moreOptions;
	private JTextField textCountry;
	private JTextField textType;
	private JTextField textSupp;
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
	private JLabel lblError;
	private CtrProduct ctrProduct = new CtrProduct();
	private JButton btnUpdate;
	private JButton btnRemove;
	private JTextField textBuy;
	private JTextField textSell;
	private JTextField textRent;
	private JTextField textMinStock;
	
	public MoreOptionsGUI() {
		
		//this.moreOptions = moreOptions;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 582, 372);
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
		panel_1.setBounds(10, 11, 304, 277);
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
		
		textName = new JTextField();
		textName.setBounds(62, 50, 86, 20);
		panel_1.add(textName);
		textName.setColumns(10);
		
		textCountry = new JTextField();
		textCountry.setColumns(10);
		textCountry.setBounds(62, 79, 86, 20);
		panel_1.add(textCountry);
		
		JLabel lblQuantity = new JLabel("Country");
		lblQuantity.setBounds(10, 82, 53, 14);
		panel_1.add(lblQuantity);
		
		textType = new JTextField();
		textType.setColumns(10);
		textType.setBounds(62, 107, 86, 20);
		panel_1.add(textType);
		
		JLabel lblPrice = new JLabel("Type");
		lblPrice.setBounds(10, 110, 42, 14);
		panel_1.add(lblPrice);
		
		textSupp = new JTextField();
		textSupp.setColumns(10);
		textSupp.setBounds(62, 135, 86, 20);
		panel_1.add(textSupp);
		
		JLabel lblSupplier = new JLabel("Supplier");
		lblSupplier.setBounds(10, 138, 53, 14);
		panel_1.add(lblSupplier);
		
		btnFind = new JButton("Find");
		btnFind.setBounds(205, 134, 89, 23);
		btnFind.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (textID.getText()!=null){
					try{
						Product product = ctrProduct.findByID(textID.getText());
	
						textName.setText(product.getpName());
						textCountry.setText(product.getpCountry());
						textType.setText(product.getType());
						textSupp.setText(product.getSupplier_id());
						textBuy.setText(Double.toString(product.getpPP()));
						textSell.setText(Double.toString(product.getpSP()));
						textRent.setText(Double.toString(product.getpRP()));
						textMinStock.setText(product.getpMinStock());
						//System.out.println("working");
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
				else 
				{
					lblError.setText("Please insert product ID");
				}
				
			}
			
			
		});
		panel_1.add(btnFind);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 243, 89, 23);
		btnAdd.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (textID.getText().length()>0 && textName.getText().length()>0 && textCountry.getText().length()>0 && textType.getText().length()>0 && textSupp.getText().length()>0 && textBuy.getText().length()>0 && textSell.getText().length()>0 && textRent.getText().length()>0 && textMinStock.getText().length()>0){
						Product product = new Product();
						product.setpid(textID.getText());
						product.setpName(textName.getText());
						product.setpCountry(textCountry.getText());
						product.setType(textType.getText());
						product.setSupplier_id(textSupp.getText());
						product.setpPP(Integer.parseInt(textBuy.getText()));
						product.setpSP(Integer.parseInt(textSell.getText()));
						product.setpRP(Integer.parseInt(textRent.getText()));
						product.setpMinStock(textMinStock.getText());
						ctrProduct.insertNew(product);
				}
				else 
				{
					lblError.setText("Please insert product ID");
				}
				
			}
			
			
		});
		panel_1.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(109, 243, 89, 23);
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (textID.getText().length()>0 && 
						textName.getText().length()>0 && 
						textCountry.getText().length()>0 && 
						textType.getText().length()>0 && 
						textSupp.getText().length()>0 && 
						textBuy.getText().length()>0 && 
						textSell.getText().length()>0 && 
						textRent.getText().length()>0 && 
						textMinStock.getText().length()>0)
				{
					ctrProduct.updateProduct(textID.getText(),
							textName.getText(), 
							Integer.parseInt(textBuy.getText()), 
							Integer.parseInt(textSell.getText()), 
							Integer.parseInt(textRent.getText()), 
							textCountry.getText(), 
							textMinStock.getText(), 
							textSupp.getText(), 
							textType.getText());	
					
				}
				else 
				{
					lblError.setText("Please insert product ID");
				}
				
			}
			
			
		});
		panel_1.add(btnUpdate);
		
		btnRemove = new JButton("Remove");
		btnRemove.setBounds(205, 243, 89, 23);
		btnRemove.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (textID.getText().length()>0)
				{
					ctrProduct.delete(textID.getText());	
					
				}
				else 
				{
					lblError.setText("Please insert product ID");
				}
				
			}
			
			
		});
		panel_1.add(btnRemove);
		
		JLabel lblBuy = new JLabel("Buy");
		lblBuy.setBounds(156, 25, 53, 14);
		panel_1.add(lblBuy);
		
		JLabel lblSell = new JLabel("Sell");
		lblSell.setBounds(156, 53, 53, 14);
		panel_1.add(lblSell);
		
		JLabel lblRent = new JLabel("Rent");
		lblRent.setBounds(156, 82, 53, 14);
		panel_1.add(lblRent);
		
		textBuy = new JTextField();
		textBuy.setColumns(10);
		textBuy.setBounds(208, 22, 86, 20);
		panel_1.add(textBuy);
		
		textSell = new JTextField();
		textSell.setColumns(10);
		textSell.setBounds(208, 50, 86, 20);
		panel_1.add(textSell);
		
		textRent = new JTextField();
		textRent.setColumns(10);
		textRent.setBounds(208, 79, 86, 20);
		panel_1.add(textRent);
		
		JLabel lblMinStock = new JLabel("Min Stock");
		lblMinStock.setBounds(156, 110, 53, 14);
		panel_1.add(lblMinStock);
		
		textMinStock = new JTextField();
		textMinStock.setColumns(10);
		textMinStock.setBounds(208, 107, 86, 20);
		panel_1.add(textMinStock);
		
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
		panel_2.setBounds(324, 11, 232, 262);
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
