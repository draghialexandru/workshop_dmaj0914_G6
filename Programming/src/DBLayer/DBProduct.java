package DBLayer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.Product;

/**
 * DBProduct.java
 * @author group 6
 * @version 18.03.2015
 *
 */
public class DBProduct implements IFDBProd{
    private  Connection con;
    /** Creates a new instance 
     * of DBProduct */
    public DBProduct() {
      con = DbConnection.getInstance().getDBcon();
    }
  //Implements the methods from the interface
    // get all Products
    public ArrayList<Product> getAllProducts(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }
    //get one Product having the P_id
    public Product findProduct(String P_id, boolean retriveAssociation)
    {   String wClause = "  P_id = '" + P_id + "'";
        return singleWhere(wClause, retriveAssociation);
    }
    //find one Product having the Name
    public Product searchProductName(String name, boolean retriveAssociation)
    {

        System.out.println("SearchProduct " + name);
        return singleWhere(name, retriveAssociation);
    }
     //insert a new Product
    public int insertProduct(Product Prod)
    {  
       int rc = -1;
	   String query="INSERT INTO Product(P_id,name,purchasePrice,salesPrice,rentPrice,countryOfOrigin,minStock)  VALUES('"+
       Prod.getP_id() + "','" +
	  		Prod.getName()  + "','"  +
	  			Prod.getPurchasePrice() + "','"  +
	  				Prod.getSalesPrice()  + "','"  +
                        Prod.getRentPrice() + "','" +
                        	Prod.getCountryOfOrigin() + "','" + 
                        		Prod.getMinStock();

       try{ // insert new Product
          con.setAutoCommit(false);
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
          con.commit();
          con.setAutoCommit(true);
       }//end try
       catch(SQLException ex){
          System.out.println("Product ikke oprettet");
          System.out.println("Insert exception in Product db: "+ex);
	  try{
             rc=-1;
             con.rollback();
             con.setAutoCommit(true);
          }
          catch(Exception ex1)
          {
             System.out.println("Error rolling back"+ ex1);
          }
       }
       return(rc);
    }

	public int updateProduct(Product Prod)
	{
		Product ProdObj  = Prod;
		int rc=-1;

		String query="UPDATE Product SET "+
			"P_id='"+ ProdObj.getP_id() + "', "+
		 	  "Name ='"+ ProdObj.getName()+"', "+
		 	  "purchasePrice ='"+ ProdObj.getPurchasePrice() + "', " +
                          "salesPrice ='"+ ProdObj.getSalesPrice() + "', " +
                          "rentPrice ='"+ ProdObj.getRentPrice() + "' " +
                          "countryOfOrigin='"+ ProdObj.getCountryOfOrigin() + "', "+
                          "minStock ='" + ProdObj.getMinStock() + "','" +
		          " WHERE P_id = '"+ ProdObj.getP_id() + "'";
                System.out.println("Update query:" + query);
  		try{ // update Product
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//slut try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in Product db: "+ex);
	  	}
		return(rc);
	}
	
	public int delete(String P_id)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM Product WHERE P_id = '" +
				P_id + "'";
                System.out.println(query);
	  	try{ // delete from Product
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}//slut try	
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in Product db: "+ex);
   	        }
		return(rc);
	}
	
	//private methods
        //michWere is used whenever we want to select more than one Product
	
	 
	private ArrayList<Product> miscWhere(String wClause, boolean retrieveAssociation)
	{
            ResultSet results;
	    ArrayList<Product> list = new ArrayList<Product>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the Product from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
		while( results.next() ){
	     	 Product ProdObj = new Product();
		 ProdObj = buildProduct(results);	
                 list.add(ProdObj);	
		}//end while
                 stmt.close();     
                 
			
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	//Singelwhere is used when we only select one Product 	
	private Product singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Product ProdObj = new Product();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the Product from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            ProdObj = buildProduct(results);
                            //assocaition is to be build
                            stmt.close();
	 		}
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return ProdObj;
	}
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT P_id,Name, purchasePrice, salesPrice,rentPrice, countryOfOrigin,minStock";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an Product object
	private Product buildProduct(ResultSet results)
      {   Product ProdObj = new Product();
          try{ // the columns from the table Product  are used
        	  	ProdObj.setP_id(results.getString("P_id"));
                ProdObj.setName(results.getString("Name"));
                ProdObj.setPurchasePrice(results.getDouble("purchasePrice"));
                ProdObj.setSalesPrice(results.getDouble("salesPrice"));
                ProdObj.setRentPrice(results.getDouble("rentPrice"));
                ProdObj.setCountryOfOrigin(results.getString("countryOfOrigin"));
                ProdObj.setMinStock(results.getString("minStock"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the Product object");
         }
         return ProdObj;
      }
 
}  
    

