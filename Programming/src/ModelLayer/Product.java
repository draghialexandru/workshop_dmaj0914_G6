package ModelLayer;

/**
*
* @author Draghi Alexandru
* @version 18.03.2015
*/

public class Product {

	//instance variables 
	private String name;
	private double purchasePrice;
	private double salesPrice;
	private double rentPrice;
	private String countryOfOrigin;
	private int minStock;
	private String size;
	private String colour;
	private String type;
	private String description;
	private String fabric;
	private String calibre;
	
	
public Product() {
        
    }
    public Product(String name){
        this.name = name;
    }
    public Product (String name, double purchasePrice, double salesPrice, double rentPrice, String countryOfOrigin, int minStock,
    		String size,String colour, String type, String description, String fabric, String calibre)
    {
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.salesPrice = salesPrice;
        this.rentPrice = rentPrice;
        this.countryOfOrigin = countryOfOrigin;
        this.minStock = minStock;
        this.size = size;
        this.colour = colour;
        this.type = type;
        this.description = description;
        this.fabric = fabric;
        this.calibre = calibre;
        
    }
    //set methods
    public void setName(String name)
    {
        this.name = name;
    }
    public void setPurchasePrice(double purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }
    public void setSalesPrice (double salesPrice)
    {
        this.salesPrice = salesPrice;
    }
    
    public void setRentPrice (double rentPrice)
    {
        this.rentPrice = rentPrice;
    }
    public void setCountryOfOrigin (String countryOfOrigin)
    {
        this.countryOfOrigin = countryOfOrigin;
    }
    public void setMinStock (int minStock)
    {
    	this.minStock = minStock;
    }
    public void setSize(String size)
    {
    	this.size = size;
    }
    public void setColour(String colour)
    {
    	this.colour = colour;
    }
    public void setType(String type)
    {
    	this.type = type;
    }
    public void setDescription(String description)
    {
    	this.description = description;
    }
    public void setFabric(String fabric)
    {
    	this.fabric = fabric;
    }
    public void setCalibre(String calibre)
    {
    	this.calibre = calibre;
    }
    
    //get method
    public String getName()
    {
        return name;
    }
    public double getPurchasePrice()
    {
        return purchasePrice;
    }
    public double getSalesPrice()
    {
        return salesPrice;
    }

    public double getRentPrice()
    {
        return rentPrice;
    }
    public String getCountryOfOrigin()
   {
       return countryOfOrigin;
   }
    public int getMinStock()
    {
    	return minStock;
    }
    public String getSize()
    {
    	return size;
    }
    public String getColour()
    {
    	return colour;
    }
    public String getType()
    {
    	return type;
    }
    public String getDescription()
    {
    	return description;
    }
    public String getFabric()
    {
    	return fabric;
    }
    public String getCalibre()
    {
    	return calibre;
    }
    
    
}