package DBLayer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.ProductsAmount;

/**
 * DBProductsAmount.java
 * @author group 6
 * @version 18.03.2015
 *
 */
public class DBProductsAmount implements IFDBAmount{
    private  Connection con;
    /** Creates a new instance 
     * of DBProductsAmount */
    public DBProductsAmount() {
      con = DbConnection.getInstance().getDBcon();
    }
  //Implements the methods from the interface
    // get all ProductsAmounts
    public ArrayList<ProductsAmount> getAllProductsAmounts(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }
    //get one ProductsAmount having the p_id
    public ProductsAmount searchAmountp_id( String p_id, boolean retriveAssociation)
    {   String wClause = "  p_id = '" + p_id + "'";
        return singleWhere(wClause, retriveAssociation);
    }
     //insert a new ProductsAmount
    public int insertAmount(ProductsAmount Amount)
    {  
       int rc = -1;
	   String query="INSERT INTO ProductsAmount(p_id,Amount,Order_id)  VALUES('"+
       Amount.getP_id() + "','" +
	  		Amount.getAmount()  + "','"  +
	  			Amount.getOrder_id();

       try{ // insert new ProductsAmount
          con.setAutoCommit(false);
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
          con.commit();
          con.setAutoCommit(true);
       }//end try
       catch(SQLException ex){
          System.out.println("ProductsAmount ikke oprettet");
          System.out.println("Insert exception in ProductsAmount db: "+ex);
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

	public int updateAmount(ProductsAmount Amount)
	{
		ProductsAmount AmountObj  = Amount;
		int rc=-1;

		String query="UPDATE ProductsAmount SET "+
			"p_id='"+ AmountObj.getP_id() + "', "+
		 	  "amount ='"+ AmountObj.getAmount()+"', "+
		 	  "order_id ='"+ AmountObj.getOrder_id() + "', " +
		          " WHERE p_id = '"+ AmountObj.getP_id() + "'";
                System.out.println("Update query:" + query);
  		try{ // update ProductsAmount
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//slut try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in ProductsAmount db: "+ex);
	  	}
		return(rc);
	}
	
	public int delete(String pid)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM ProductsAmount WHERE pid = '" +
				pid + "'";
                System.out.println(query);
	  	try{ // delete from ProductsAmount
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}//slut try	
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in ProductsAmount db: "+ex);
   	        }
		return(rc);
	}
	
	//private methods
        //michWere is used whenever we want to select more than one ProductsAmount
	
	 
	private ArrayList<ProductsAmount> miscWhere(String wClause, boolean retrieveAssociation)
	{
            ResultSet results;
	    ArrayList<ProductsAmount> list = new ArrayList<ProductsAmount>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the ProductsAmount from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
		while( results.next() ){
	     	 ProductsAmount AmountObj = new ProductsAmount();
		 AmountObj = buildProductsAmount(results);	
                 list.add(AmountObj);	
		}//end while
                 stmt.close();     
                 
			
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	//Singelwhere is used when we only select one ProductsAmount 	
	private ProductsAmount singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ProductsAmount AmountObj = new ProductsAmount();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the ProductsAmount from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            AmountObj = buildProductsAmount(results);
                            //assocaition is to be build
                            stmt.close();
	 		}
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return AmountObj;
	}
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT pid,pName, pPP, pSP,pRP, pCountry,pMinStock,supplier_id,type";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an ProductsAmount object
	private ProductsAmount buildProductsAmount(ResultSet results)
      {   ProductsAmount AmountObj = new ProductsAmount();
          try{ // the columns from the table ProductsAmount  are used
        	  	AmountObj.setP_id(results.getString("pid"));
                AmountObj.setAmount(results.getString("Amount"));
                AmountObj.setOrder_id(results.getString("Order_id"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the ProductsAmount object");
         }
         return AmountObj;
      }
 
}  
    

