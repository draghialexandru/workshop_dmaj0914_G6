package ModelLayer;

/**
*
* @author group 6
* @version 16.03.2015
*/

public class Customer {

	//instance variables 
	private String id;
	private String name;
	private String address;
	private String zipCode;
	private String city;
	private String phoneno;
public Customer() {
        
    }
    public Customer(String id){
        this.id = id;
    }
    public Customer (String id,String name, String address, String zipCode, String city, String phoneno)
    {
    	this.id = id;
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneno = phoneno;
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
    public void setZipcode (String zipCode){
        this.zipCode = zipCode;
    }
    public void setCity (String city){
        this.city = city;
    }
    public void setPhoneno (String phoneno){
        this.phoneno = phoneno;
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
    public String getZipcode()
    {
        return zipCode;
    }
     public String getCity()
    {
        return city;
    }
    public String getPhoneno()
    {
        return phoneno;
    }
    
}