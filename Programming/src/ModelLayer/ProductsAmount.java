package ModelLayer;

/**
*
* @author group 6
* @version 18.03.2015
*/

public class ProductsAmount {
	//instance variables
	private String p_id;
	private String amount;
	private String order_id;
	private Product product;
	private SalesOrder SalesOrder;
	
	public ProductsAmount() {
	}
	public ProductsAmount(String p_id,String amount,String order_id) {
		this.setP_id(p_id);
		this.amount = amount;
		this.setOrder_id(order_id);
	}
	
//set method 
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
//get method
	public String getAmount()
	{
		return amount;
	}
	public String getP_id() {
		return p_id;
	}
	
	public String getOrder_id() {
		return order_id;
	}
}
