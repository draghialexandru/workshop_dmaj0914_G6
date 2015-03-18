package ModelLayer;

/**
*
* @author Draghi Alexandru
* @version 18.03.2015
*/

public class ProductsAmount {
	//instance variables
	private int amount;
	private SalesOrder salesorder;
	private Product product;
	
	public ProductsAmount() {
	}
	public ProductsAmount(int amount) {
		this.amount = amount;
	}
//set method 
	public void setAmount(int amount) {
		this.amount = amount;
	}
//get method
	public int getAmount()
	{
		return amount;
	}
}
