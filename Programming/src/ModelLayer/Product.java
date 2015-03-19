package ModelLayer;



public class Product {

	//instance variables 
	private String P_id;
	private String name;
	private double purchasePrice;
	private double salesPrice;
	private double rentPrice;
	private String countryOfOrigin;
	private String minStock;
	private String productType;
	
public Product() {
        
    }
    public Product(String P_id){
        this.P_id = P_id;
    }
    public Product (String P_id, String name, double purchasePrice, double salesPrice, double rentPrice, String countryOfOrigin, String minStock,
    		String productType)
    {
    	this.P_id = P_id;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.salesPrice = salesPrice;
        this.rentPrice = rentPrice;
        this.countryOfOrigin = countryOfOrigin;
        this.minStock = minStock;
        this.productType = productType;
        
    }
    //set methods
    public void setP_id(String P_id)
    {
    	this.P_id = P_id;
    }
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
    public void setMinStock (String minStock)
    {
    	this.minStock = minStock;
    }
    public void setProductType(String productType)
    {
    	this.productType = productType;
    }
    
    //get method
    public String getP_id()
    {
    	return P_id;
    }
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
    public String getMinStock()
    {
    	return minStock;
    }
    public String getProductType()
    {
    	return productType;
    }
}