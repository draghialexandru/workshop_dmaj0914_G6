package DBLayer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.Invoice;

/**
 * DBInvoice.java
 * @author group 6
 * @version 18.03.2015
 *
 */
public class DBInvoice implements IFDBInv{
    private  Connection con;
    /** Creates a new instance 
     * of DBInvoice */
    public DBInvoice() {
      con = DbConnection.getInstance().getDBcon();
    }
  //Implements the methods from the interface
    // get all Invoices
    public ArrayList<Invoice> getAllInvoices(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }
    //get one Invoice having the pid
    public Invoice findInvoice(String pid, boolean retriveAssociation)
    {   String wClause = "  pid = '" + pid + "'";
        return singleWhere(wClause, retriveAssociation);
    }
    //find one Invoice having the pName
    public Invoice searchInvoicepName(String pName, boolean retriveAssociation)
    {

        System.out.println("SearchInvoice " + pName);
        return singleWhere(pName, retriveAssociation);
    }
     //insert a new Invoice
    public int insertInvoice(Invoice Inv)
    {  
       int rc = -1;
	   String query="INSERT INTO Invoice(inNo,inPayDay,price,oid)  VALUES('"+
       Inv.getinNo() + "','" +
	  		Inv.getInPayDay()  + "','"  +
	  			Inv.getPrice() + "','"  +
	  				Inv.getOid();

       try{ // insert new Invoice
          con.setAutoCommit(false);
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
          con.commit();
          con.setAutoCommit(true);
       }//end try
       catch(SQLException ex){
          System.out.println("Invoice ikke oprettet");
          System.out.println("Insert exception in Invoice db: "+ex);
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

	public int updateInvoice(Invoice Inv)
	{
		Invoice InvObj  = Inv;
		int rc=-1;

		String query="UPDATE Invoice SET "+
			"inNo='"+ InvObj.getinNo() + "', "+
		 	  "inPayDay ='"+ InvObj.getInPayDay()+"', "+
		 	  "price ='"+ InvObj.getPrice() + "','" + 
		          " WHERE inNo = '"+ InvObj.getinNo() + "'";
                System.out.println("Update query:" + query);
  		try{ // update Invoice
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//slut try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in Invoice db: "+ex);
	  	}
		return(rc);
	}
	
	public int delete(String pid)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM Invoice WHERE pid = '" +
				pid + "'";
                System.out.println(query);
	  	try{ // delete from Invoice
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}//slut try	
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in Invoice db: "+ex);
   	        }
		return(rc);
	}
	
	//private methods
        //michWere is used whenever we want to select more than one Invoice
	
	 
	private ArrayList<Invoice> miscWhere(String wClause, boolean retrieveAssociation)
	{
            ResultSet results;
	    ArrayList<Invoice> list = new ArrayList<Invoice>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the Invoice from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
		while( results.next() ){
	     	 Invoice InvObj = new Invoice();
		 InvObj = buildInvoice(results);	
                 list.add(InvObj);	
		}//end while
                 stmt.close();     
                 
			
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	//Singelwhere is used when we only select one Invoice 	
	private Invoice singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Invoice InvObj = new Invoice();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the Invoice from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            InvObj = buildInvoice(results);
                            //assocaition is to be build
                            stmt.close();
	 		}
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return InvObj;
	}
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT inNo,inPayDay, price, oid";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an Invoice object
	private Invoice buildInvoice(ResultSet results)
      {   Invoice InvObj = new Invoice();
          try{ // the columns from the table Invoice  are used
        	  	InvObj.setinNo(results.getString("inNo"));
                InvObj.setInPayDay(results.getString("inPayDay"));
                InvObj.setPrice(results.getDouble("price"));
                InvObj.setOid(results.getString("Oid"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the Invoice object");
         }
         return InvObj;
      }
 
}  
    

