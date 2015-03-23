package ControlLayer;
import ModelLayer.*;
import DBLayer.*;

import java.util.ArrayList;



public class CtrProduct {

	public CtrProduct() {
		
	}
	
	public ArrayList findAllProducts()
	{
		IFDBProd Prod = new DBProduct();
	      ArrayList allProd = new ArrayList();
	      allProd = Prod.getAllProducts(false);
	      return allProd;
	}
	
	 public Product findBypName(String pName)
	    {
	        IFDBProd Prod = new DBProduct();
	        return Prod.searchProductpName(pName, true);
	    }
	 
	 public Product findByID(String pid)
	    {
	        IFDBProd Prod = new DBProduct();
	        return Prod.findProduct( pid, true);
	    }
	
	 public int updateProduct (String pid, String pName, double pPP, double pSP, double pRP, String pCountry, String pMinStock, String Supplier_id, String type ){
		 IFDBProd Prod = new DBProduct();
		 Product newProd = new Product();
		 newProd.setpid(pid);
		 newProd.setpName(pName);
		 newProd.setpPP(pPP);
		 newProd.setpSP(pSP);
		 newProd.setpRP(pRP);
		 newProd.setpCountry(pCountry);
		 newProd.setpMinStock(pMinStock);
		 newProd.setSupplier_id(Supplier_id);
		 newProd.setType(type);
		 return Prod.updateProduct(newProd);
	 }
	 
	 public void insertNew (Product prodObj)
	 {
		 IFDBProd Prod = new DBProduct();
		 Prod.insertProduct(prodObj);
		 
	 }
}
