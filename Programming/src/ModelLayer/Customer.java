package ModelLayer;

/**
*
* @author group 6
* @version 16.03.2015
*/

public class Customer {

	//instance variables 
	private String c_id;
	private String cname;
	private String caddress;
	private String czip_code;
	private String ccity;
	private String cphone_no;
public Customer() {
        
    }
    public Customer(String c_id){
        this.c_id = c_id;
    }
    public Customer (String c_id,String cname, String caddress, String czip_code, String ccity, String cphone_no)
    {
    	this.c_id = c_id;
        this.cname = cname;
        this.caddress = caddress;
        this.czip_code = czip_code;
        this.ccity = ccity;
        this.cphone_no = cphone_no;
    }
    //set methods
    public void setID(String c_id)
    {
    	this.c_id = c_id;
    }
    public void setName(String cname)
    {
        this.cname = cname;
    }
    public void setAddress(String caddress)
    {
        this.caddress = caddress;
    }
    public void setZipcode (String czip_code){
        this.czip_code = czip_code;
    }
    public void setCity (String ccity){
        this.ccity = ccity;
    }
    public void setPhoneno (String cphone_no){
        this.cphone_no = cphone_no;
    }
    
    //get method
    public String getID()
    {
    	return c_id;
    }
    public String getName()
    {
        return cname;
    }
    public String getAddress()
    {
        return caddress;
    }
    public String getZipcode()
    {
        return czip_code;
    }
     public String getCity()
    {
        return ccity;
    }
    public String getPhoneno()
    {
        return cphone_no;
    }
    
}