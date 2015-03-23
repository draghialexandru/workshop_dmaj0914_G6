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
    public void setc_id(String c_id)
    {
    	this.c_id = c_id;
    }
    public void setcname(String cname)
    {
        this.cname = cname;
    }
    public void setcaddress(String caddress)
    {
        this.caddress = caddress;
    }
    public void setczip_code (String czip_code){
        this.czip_code = czip_code;
    }
    public void setccity (String ccity){
        this.ccity = ccity;
    }
    public void setcphone_no (String cphone_no){
        this.cphone_no = cphone_no;
    }
    
    //get method
    public String getc_id()
    {
    	return c_id;
    }
    public String getcname()
    {
        return cname;
    }
    public String getcaddress()
    {
        return caddress;
    }
    public String getczip_code()
    {
        return czip_code;
    }
     public String getccity()
    {
        return ccity;
    }
    public String getcphone_no()
    {
        return cphone_no;
    }
    
}