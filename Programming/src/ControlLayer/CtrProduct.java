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
	
	 public Product findByName(String Name)
	    {
	        IFDBProd Prod = new DBProduct();
	        return Prod.searchProductName(Name, true);
	    }
	 
	 public Product findByID(String P_id)
	    {
	        IFDBProd Prod = new DBProduct();
	        return Prod.findProduct( P_id, true);
	    }
	
	 public int updateProduct (String P_id, String name, double purchasePrice, double salesPrice, double rentPrice, String countryOfOrigin, String minStock ){
		 IFDBProd Prod = new DBProduct();
		 Product newProd = new Product();
		 newProd.setP_id(P_id);
		 newProd.setName(name);
		 newProd.setPurchasePrice(purchasePrice);
		 newProd.setSalesPrice(salesPrice);
		 newProd.setRentPrice(rentPrice);
		 newProd.setCountryOfOrigin(countryOfOrigin);
		 newProd.setMinStock(minStock);
		 return Prod.updateProduct(newProd);
	 }
	 
	 public void insertNew (Product prodObj)
	 {
		 IFDBProd Prod = new DBProduct();
		 Prod.insertProduct(prodObj);
		 
	 }
}
