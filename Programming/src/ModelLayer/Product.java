package ModelLayer;



public class Product {

	//instance variables 
	private String pid;
	private String pName;
	private double purchaseP;
	private double sellP;
	private double rentP;
	private String pCountry;
	private String pMinStock;
	private String Supplier_id;
	private String Type;
	
public Product() {
        
    }
    public Product(String pid){
        this.pid = pid;
    }
    public Product (String pid, String pName, double purchaseP, double sellP, double rentP, String pCountry, String pMinStock,String Supplier_id,
    		String Type)
    {
    	this.pid = pid;
        this.pName = pName;
        this.purchaseP = purchaseP;
        this.sellP = sellP;
        this.rentP = rentP;
        this.pCountry = pCountry;
        this.pMinStock = pMinStock;
        this.Supplier_id = Supplier_id;
        this.Type = Type;
        
    }
    //set methods
    public void setpid(String pid)
    {
    	this.pid = pid;
    }
    public void setpName(String pName)
    {
        this.pName = pName;
    }
    public void setpPP(double purchaseP)
    {
        this.purchaseP = purchaseP;
    }
    public void setpSP (double sellP)
    {
        this.sellP = sellP;
    }
    
    public void setpRP (double rentP)
    {
        this.rentP = rentP;
    }
    public void setpCountry (String pCountry)
    {
        this.pCountry = pCountry;
    }
    public void setpMinStock (String pMinStock)
    {
    	this.pMinStock = pMinStock;
    }
    public void setSupplier_id (String Supplier_id)
    {
    	this.Supplier_id = Supplier_id;
    }
    public void setType(String Type)
    {
    	this.Type = Type;
    }
    
    //get method
    public String getpid()
    {
    	return pid;
    }
    public String getpName()
    {
        return pName;
    }
    public double getpPP()
    {
        return purchaseP;
    }
    public double getpSP()
    {
        return sellP;
    }

    public double getpRP()
    {
        return rentP;
    }
    public String getpCountry()
   {
       return pCountry;
   }
    public String getpMinStock()
    {
    	return pMinStock;
    }
    public String getSupplier_id()
    {
    	return Supplier_id;
    }
    public String getType()
    {
    	return Type;
    }
}