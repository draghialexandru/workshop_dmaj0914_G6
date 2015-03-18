package ModelLayer;



public class Product {

	//instance variables 
	private String name;
	private double purchasePrice;
	private double salesPrice;
	private double rentPrice;
	private String countryOfOrigin;
	private int minStock;
	private String productType;
	
public Product() {
        
    }
    public Product(String name){
        this.name = name;
    }
    public Product (String name, double purchasePrice, double salesPrice, double rentPrice, String countryOfOrigin, int minStock,
    		String productType)
    {
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.salesPrice = salesPrice;
        this.rentPrice = rentPrice;
        this.countryOfOrigin = countryOfOrigin;
        this.minStock = minStock;
        this.productType = productType;
        
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
}