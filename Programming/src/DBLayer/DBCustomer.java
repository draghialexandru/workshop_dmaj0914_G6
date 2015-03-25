package DBLayer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.Customer;

/**
 * DBCustomer.java
 * @author group 6
 * @version 18.03.2015
 *
 */
public class DBCustomer implements IFDBCus{
    private  Connection con;
    /** Creates a new instance 
     * of DBCustomer */
    public DBCustomer() {
      con = DbConnection.getInstance().getDBcon();
    }
  //Implements the methods from the interface
    // get all Customers
    public ArrayList<Customer> getAllCustomers(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }
    //get one Customer having the c_id
    public Customer findCustomer(String Cusc_id, boolean retriveAssociation)
    {   String wClause = "  c_id = '" + Cusc_id + "'";
        return singleWhere(wClause, retriveAssociation);
    }
  //get one Customer having the cphone_no
    public Customer findCustomercphone_no(String cphone_no, boolean retriveAssociation)
    {   String wClause = "  cphone_no = '" + cphone_no + "'";
        return singleWhere(wClause, retriveAssociation);
    }
    //find one Customer having the c_name
    public Customer searchCustomercname(String cname, boolean retriveAssociation)
    {

        System.out.println("SearchCustomer " + cname);
        return singleWhere(cname, retriveAssociation);
    }
  //find one customer having the c_id
    public Customer searchCustomerc_id(String attValue, boolean retriveAssociation)
    {
        String wClause = "c_id = '" + attValue + "'";
        System.out.println("Search Customer: " + wClause);
        return singleWhere(wClause, retriveAssociation);
    }
     //insert a new Customer
    public int insertCustomer(Customer Cus)
    {  
       int rc = -1;
	   String query="INSERT INTO Customer(c_id,cname,caddress,czip_code,ccity,cphone_no)  VALUES('"+
       Cus.getID() + "','" +
	  		Cus.getName()  + "','"  +
	  			Cus.getAddress() + "','"  +
	  				Cus.getZipcode()  + "','"  +
                        Cus.getCity() + "','" +
                        	Cus.getPhoneno() + "')";

       try{ // insert new Customer
          con.setAutoCommit(false);
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
          con.commit();
          con.setAutoCommit(true);
       }//end try
       catch(SQLException ex){
          System.out.println("Customer ikke oprettet");
          System.out.println("Insert exception in Customer db: "+ex);
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

	public int updateCustomer(Customer Cus)
	{
		Customer CusObj  = Cus;
		int rc=-1;

		String query="UPDATE Customer SET "+
			"c_id='"+ CusObj.getID() + "', "+
		 	  "cname ='"+ CusObj.getName()+"', "+
		 	  "caddress ='"+ CusObj.getAddress() + "', " +
                          "czip_Code ='"+ CusObj.getZipcode() + "', " +
                          "ccity ='"+ CusObj.getCity() + "', " +
                          "cphone_no ='"+ CusObj.getPhoneno() + "' "+
		          " WHERE c_id = '"+ CusObj.getID() + "'";
                System.out.println("Update query:" + query);
  		try{ // update Customer
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//slut try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in Customer db: "+ex);
	  	}
		return(rc);
	}
	
	public int delete(String c_id)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM Customer WHERE c_id = '" +
				c_id + "'";
                System.out.println(query);
	  	try{ // delete from Customer
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}//slut try	
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in Customer db: "+ex);
   	        }
		return(rc);
	}
	
	//private methods
        //michWere is used whenever we want to select more than one Customer
	
	 
	private ArrayList<Customer> miscWhere(String wClause, boolean retrieveAssociation)
	{
            ResultSet results;
	    ArrayList<Customer> list = new ArrayList<Customer>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the Customer from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
		while( results.next() ){
	     	 Customer CusObj = new Customer();
	     	 CusObj = buildCustomer(results);	
                 list.add(CusObj);	
		}//end while
                 stmt.close();     
                 
			
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	//Singelwhere is used when we only select one Customer 	
	private Customer singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Customer CusObj = new Customer();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the Customer from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            CusObj = buildCustomer(results);
                            //assocaition is to be build
                            stmt.close();
	 		}
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return CusObj;
	}
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT c_id, cname, caddress, czip_code, ccity, cphone_no  FROM Customer";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an Customer object
	private Customer buildCustomer(ResultSet results)
      {   Customer CusObj = new Customer();
          try{ // the columns from the table Customer  are used
        	  	CusObj.setID(results.getString("c_id"));
                CusObj.setName(results.getString("cname"));
                CusObj.setAddress(results.getString("caddress"));
                CusObj.setZipcode(results.getString("czip_code"));
                CusObj.setCity(results.getString("ccity"));
	  	CusObj.setPhoneno(results.getString("cphone_no"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the Customer object");
         }
         return CusObj;
      }
 
}  
    

