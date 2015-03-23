package ModelLayer;

/**
*
* @author group 6
* @version 18.03.2015
*/

public class Supplier {

	//instance variables 
	private String s_id;
	private String sName;
	private String sAddress;
	private String sCountry;
	private String sPhone;
	private String sEmail;
public Supplier() {
        
    }
    public Supplier(String s_id){
        this.s_id = s_id;
    }
    public Supplier (String sName, String sAddress, String sCountry, String sPhone, String sEmail,String s_id)
    {
        this.sName = sName;
        this.sAddress = sAddress;
        this.sCountry = sCountry;
        this.sPhone = sPhone;
        this.sEmail = sEmail;
    	this.s_id = s_id;
    }
    //set methods
    public void sets_id(String s_id)
    {
    	this.s_id = s_id;
    }
    public void setsName(String sName)
    {
        this.sName = sName;
    }
    public void setsAddress(String sAddress)
    {
        this.sAddress = sAddress;
    }
    public void setsCountry (String sCountry)
    {
        this.sCountry = sCountry;
    }
    
    public void setsPhone (String sPhone)
    {
        this.sPhone = sPhone;
    }
    public void setsEmail (String sEmail)
    {
        this.sEmail = sEmail;
    }
    
    //get method
    public String gets_id()
    {
    	return s_id;
    }
    public String getsName()
    {
        return sName;
    }
    public String getsAddress()
    {
        return sAddress;
    }
    public String getsCountry()
    {
        return sCountry;
    }

    public String getsPhone()
    {
        return sPhone;
    }
    public String getsEmail()
   {
       return sEmail;
   }
}