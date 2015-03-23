package ModelLayer;



public class Product {

	//instance variables 
	private String pid;
	private String pName;
	private double pPP;
	private double pSP;
	private double pRP;
	private String pCountry;
	private String pMinStock;
	private String Supplier_id;
	private String Type;
	
public Product() {
        
    }
    public Product(String pid){
        this.pid = pid;
    }
    public Product (String pid, String pName, double pPP, double pSP, double pRP, String pCountry, String pMinStock,String Supplier_id,
    		String Type)
    {
    	this.pid = pid;
        this.pName = pName;
        this.pPP = pPP;
        this.pSP = pSP;
        this.pRP = pRP;
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
    public void setpPP(double pPP)
    {
        this.pPP = pPP;
    }
    public void setpSP (double pSP)
    {
        this.pSP = pSP;
    }
    
    public void setpRP (double pRP)
    {
        this.pRP = pRP;
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
        return pPP;
    }
    public double getpSP()
    {
        return pSP;
    }

    public double getpRP()
    {
        return pRP;
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