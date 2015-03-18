package ModelLayer;

import java.util.ArrayList;

/**
*
* @author Draghi Alexandru
* @version 18.03.2015
*/

public class SalesOrder {

	//instance variables 
	private String orderID;
	private ArrayList<ProductsAmount> productList = new ArrayList<ProductsAmount>();
	private String date;
	private String deliveryStatus;
	private String deliveryDate;
	private Customer customer;
	
public SalesOrder() {
        
    }
    public SalesOrder(String orderID){
        this.orderID = orderID;
    }
    public SalesOrder (String orderID, String date, String deliveryStatus, String deliveryDate)
    {
        this.orderID = orderID;
        this.date = date;
        this.deliveryStatus = deliveryStatus;
        this.deliveryDate = deliveryDate;
        
    }
    //set methods
    public void setOrderID(String orderID)
    {
        this.orderID = orderID;
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    public void setDeliveryStatus (String deliveryStatus)
    {
        this.deliveryStatus = deliveryStatus;
    }
    
    public void setDeliveryDate (String deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }
    
    //get method
    public String getOrderID()
    {
        return orderID;
    }
    public String getDate()
    {
        return date;
    }
    public String getDeliveryStatus()
    {
        return deliveryStatus;
    }

    public String getDeliveryDate()
    {
        return deliveryDate;
    }
}