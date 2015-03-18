package ModelLayer;

/**
*
* @author Draghi Alexandru
* @version 18.03.2015
*/

public class Supplier {

	//instance variables 
	private String id;
	private String name;
	private String address;
	private String country;
	private String phoneno;
	private String email;
public Supplier() {
        
    }
    public Supplier(String id){
        this.id = id;
    }
    public Supplier (String id,String name, String address, String country, String phoneno, String email)
    {
    	this.id = id;
        this.name = name;
        this.address = address;
        this.country = country;
        this.phoneno = phoneno;
        this.email = email;
    }
    //set methods
    public void setID(String id)
    {
    	this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setcountry (String country)
    {
        this.country = country;
    }
    
    public void setPhoneno (String phoneno)
    {
        this.phoneno = phoneno;
    }
    public void setemail (String email)
    {
        this.email = email;
    }
    
    //get method
    public String getID()
    {
    	return id;
    }
    public String getName()
    {
        return name;
    }
    public String getAddress()
    {
        return address;
    }
    public String getcountry()
    {
        return country;
    }

    public String getPhoneno()
    {
        return phoneno;
    }
    public String getEmail()
   {
       return email;
   }
}