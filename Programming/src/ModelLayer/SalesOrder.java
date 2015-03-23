package ModelLayer;

import java.util.ArrayList;

/**
*
* @author group 6
* @version 18.03.2015
*/

public class SalesOrder {

	//instance variables 
	private String o_id;
	private ArrayList<ProductsAmount> productList = new ArrayList<ProductsAmount>();
	private String odate;
	private String cid;
	private String oDelStatus;
	private String oDelDate;
	private String inNO;
	private Customer customer;
	
public SalesOrder() {
        
    }
    public SalesOrder(String o_id){
        this.o_id = o_id;
    }
    public SalesOrder (String o_id, String odate,String cid, String oDelStatus, String oDelDate,String inNO)
    {
        this.o_id = o_id;
        this.odate = odate;
        this.cid = cid;
        this.oDelStatus = oDelStatus;
        this.oDelDate = oDelDate;
        this.inNO = inNO;
        
    }
    //set methods
    public void seto_id(String o_id)
    {
        this.o_id = o_id;
    }
    public void setodate(String odate)
    {
        this.odate = odate;
    }
    public void setcid(String cid)
    {
    	this.cid = cid;
    }
    public void setoDelStatus (String oDelStatus)
    {
        this.oDelStatus = oDelStatus;
    }
    
    public void setoDelDate (String oDelDate)
    {
        this.oDelDate = oDelDate;
    }
    public void setinNO(String inNO)
    {
    	this.inNO = inNO;
    }
    
    //get method
    public String geto_id()
    {
        return o_id;
    }
    public String getodate()
    {
        return odate;
    }
    public String getcid()
    {
    	return cid;
    }
    public String getoDelStatus()
    {
        return oDelStatus;
    }

    public String getoDelDate()
    {
        return oDelDate;
    }
    public String getinNO()
    {
    	return inNO;
    }
}