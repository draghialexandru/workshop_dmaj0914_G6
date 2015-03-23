package ModelLayer;

/**
*
* @author group 6
* @version 18.03.2015
*/

public class Invoice {
	//instance variables
	private String inNo;
	private String inPayDay;
	private Double price;
	private String oid;
	private Product product;
	private SalesOrder SalesOrder;
	
	public Invoice() {
	}
	public Invoice(String inNo,String inPayDay,Double price,String oid) {
		this.setinNo(inNo);
		this.setInPayDay(inPayDay);
		this.setPrice(price);
		this.setOid(oid);
	}
	public String getinNo() {
		return inNo;
	}
	public void setinNo(String inNo) {
		this.inNo = inNo;
	}
	public String getInPayDay() {
		return inPayDay;
	}
	public void setInPayDay(String inPayDay) {
		this.inPayDay = inPayDay;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
