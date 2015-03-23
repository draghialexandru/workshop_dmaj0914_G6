package DBLayer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.Supplier;

/**
 * DBSupplier.java
 * @author group 6
 * @version 18.03.2015
 *
 */
public class DBSupplier implements IFDBSupp{
    private  Connection con;
    /** Creates a new instance 
     * of DBSupplier */
    public DBSupplier() {
      con = DbConnection.getInstance().getDBcon();
    }
  //Implements the methods from the interface
    // get all Suppliers
    public ArrayList<Supplier> getAllSuppliers(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }
    //get one Supplier having the s_id
    public Supplier findSupplier(String Supps_id, boolean retriveAssociation)
    {   String wClause = "  s_id = '" + Supps_id + "'";
        return singleWhere(wClause, retriveAssociation);
    }
  //get one Supplier having the sEmail
    public Supplier findSuppliersEmail(String sEmail, boolean retriveAssociation)
    {   String wClause = "  sEmail = '" + sEmail + "'";
        return singleWhere(wClause, retriveAssociation);
    }
    //find one Supplier having the c_sName
    public Supplier searchSuppliersName(String sName, boolean retriveAssociation)
    {

        System.out.println("SearchSupplier " + sName);
        return singleWhere(sName, retriveAssociation);
    }
  //find one Supplier having the c_sName
    public Supplier searchSuppliers_id(String attValue, boolean retriveAssociation)
    {
        String wClause = "s_id = '" + attValue + "'";
        System.out.println("Search Supplier: " + wClause);
        return singleWhere(wClause, retriveAssociation);
    }
     //insert a new Supplier
    public int insertSupplier(Supplier Supp)
    {  
       int rc = -1;
	   String query="INSERT INTO Supplier(sName,sAddress,sCountry,pPhone,sEmail,s_id)  VALUES('"+

	  		Supp.getsName()  + "','"  +
	  			Supp.getsAddress() + "','"  +
	  				Supp.getsCountry()  + "','"  +
                        Supp.getsPhone() + "','" +
                        	Supp.getsEmail()  + "','" +
                        	       Supp.gets_id() + "')";

       try{ // insert new Supplier
          con.setAutoCommit(false);
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
          con.commit();
          con.setAutoCommit(true);
       }//end try
       catch(SQLException ex){
          System.out.println("Supplier ikke oprettet");
          System.out.println("Insert exception in Supplier db: "+ex);
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

	public int updateSupplier(Supplier Supp)
	{
		Supplier SuppObj  = Supp;
		int rc=-1;

		String query="UPDATE Supplier SET "+
		 	  "sName ='"+ SuppObj.getsName()+"', "+
		 	  "sAddress ='"+ SuppObj.getsAddress() + "', " +
                          "sCountry ='"+ SuppObj.getsCountry() + "', " +
                          "pPhone ='"+ SuppObj.getsPhone() + "' " +
                          "sEmail='"+ SuppObj.getsEmail() + "', "+
              			  "s_id='"+ SuppObj.gets_id() + "', "+
		          " WHERE s_id = '"+ SuppObj.gets_id() + "'";
                System.out.println("Update query:" + query);
  		try{ // update Supplier
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//slut try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in Supplier db: "+ex);
	  	}
		return(rc);
	}
	
	public int delete(String s_id)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM Supplier WHERE s_id = '" +
				s_id + "'";
                System.out.println(query);
	  	try{ // delete from Supplier
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}//slut try	
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in Supplier db: "+ex);
   	        }
		return(rc);
	}
	
	//private methods
        //michWere is used whenever we want to select more than one Supplier
	
	 
	private ArrayList<Supplier> miscWhere(String wClause, boolean retrieveAssociation)
	{
            ResultSet results;
	    ArrayList<Supplier> list = new ArrayList<Supplier>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the Supplier from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
		while( results.next() ){
	     	 Supplier SuppObj = new Supplier();
	     	 SuppObj = buildSupplier(results);	
                 list.add(SuppObj);	
		}//end while
                 stmt.close();     
                 
			
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	//Singelwhere is used when we only select one Supplier 	
	private Supplier singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Supplier SuppObj = new Supplier();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the Supplier from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            SuppObj = buildSupplier(results);
                            //assocaition is to be build
                            stmt.close();
	 		}
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return SuppObj;
	}
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT sName, sAddress, sCountry, pPhone, sEmail, s_id   FROM Supplier";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an Supplier object
	private Supplier buildSupplier(ResultSet results)
      {   Supplier SuppObj = new Supplier();
          try{ // the columns from the table Supplier  are used
                SuppObj.setsName(results.getString("sName"));
                SuppObj.setsAddress(results.getString("sAddress"));
                SuppObj.setsCountry(results.getString("sCountry"));
                SuppObj.setsPhone(results.getString("pPhone"));
	  	SuppObj.setsEmail(results.getString("sEmail"));
	  	SuppObj.sets_id(results.getString("s_id"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the Supplier object");
         }
         return SuppObj;
      }
 
}  
    

