package DBLayer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.SalesOrder;

/**
 * DBSalesOrder.java
 * @author group 6
 * @version 18.03.2015
 *
 */
public class DBSalesOrder implements IFDBSalesOrder{
    private  Connection con;
    /** Creates a new instance 
     * of DBSalesOrder */
    public DBSalesOrder() {
      con = DbConnection.getInstance().getDBcon();
    }
  //Implements the methods from the interface
    // get all SalesOrders
    public ArrayList<SalesOrder> getAllSalesOrders(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }
    //get one SalesOrder having the o_id
    public SalesOrder findSalesOrder(String o_id, boolean retriveAssociation)
    {   String wClause = "  o_id = '" + o_id + "'";
        return singleWhere(wClause, retriveAssociation);
    }
    //find one SalesOrder having the odate
    public SalesOrder searchSalesOrderodate(String odate, boolean retriveAssociation)
    {

        System.out.println("SearchSalesOrder " + odate);
        return singleWhere(odate, retriveAssociation);
    }
     //insert a new SalesOrder
    public int insertSalesOrder(SalesOrder SalesOrder)
    {  
       int rc = -1;
	   String query="INSERT INTO SalesOrder(o_id,odate,cid,oDelStatus,oDelDate,pinNO)  VALUES('"+
       SalesOrder.geto_id() + "','" +
	  		SalesOrder.getodate()  + "','"  +
	  			SalesOrder.getcid() + "','"  +
	  				SalesOrder.getoDelStatus()  + "','"  +
                        SalesOrder.getoDelDate() + "', "+
                        "pinNO='"+ SalesOrder.getinNO();

       try{ // insert new SalesOrder
          con.setAutoCommit(false);
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
          con.commit();
          con.setAutoCommit(true);
       }//end try
       catch(SQLException ex){
          System.out.println("SalesOrder ikke oprettet");
          System.out.println("Insert exception in SalesOrder db: "+ex);
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

	public int updateSalesOrder(SalesOrder SalesOrder)
	{
		SalesOrder SalesOrderObj  = SalesOrder;
		int rc=-1;

		String query="UPDATE SalesOrder SET "+
			"o_id='"+ SalesOrderObj.geto_id() + "', "+
		 	  "odate ='"+ SalesOrderObj.getodate()+"', "+
		 	  "cid ='"+ SalesOrderObj.getcid() + "', " +
                          "oDelStatus ='"+ SalesOrderObj.getoDelStatus() + "', " +
                          "oDelDate ='"+ SalesOrderObj.getoDelDate() + "' " +
                          "pinNO='"+ SalesOrderObj.getinNO() + "', "+
		          " WHERE o_id = '"+ SalesOrderObj.geto_id() + "'";
                System.out.println("Update query:" + query);
  		try{ // update SalesOrder
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//slut try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in SalesOrder db: "+ex);
	  	}
		return(rc);
	}
	
	public int delete(String o_id)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM SalesOrder WHERE o_id = '" +
				o_id + "'";
                System.out.println(query);
	  	try{ // delete from SalesOrder
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}//slut try	
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in SalesOrder db: "+ex);
   	        }
		return(rc);
	}
	
	//private methods
        //michWere is used whenever we want to select more than one SalesOrder
	
	 
	private ArrayList<SalesOrder> miscWhere(String wClause, boolean retrieveAssociation)
	{
            ResultSet results;
	    ArrayList<SalesOrder> list = new ArrayList<SalesOrder>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the SalesOrder from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
		while( results.next() ){
	     	 SalesOrder SalesOrderObj = new SalesOrder();
		 SalesOrderObj = buildSalesOrder(results);	
                 list.add(SalesOrderObj);	
		}//end while
                 stmt.close();     
                 
			
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	//Singelwhere is used when we only select one SalesOrder 	
	private SalesOrder singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		SalesOrder SalesOrderObj = new SalesOrder();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the SalesOrder from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            SalesOrderObj = buildSalesOrder(results);
                            //assocaition is to be build
                            stmt.close();
	 		}
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return SalesOrderObj;
	}
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT o_id,odate, cid, oDelStatus,oDelDate, pinNO";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an SalesOrder object
	private SalesOrder buildSalesOrder(ResultSet results)
      {   SalesOrder SalesOrderObj = new SalesOrder();
          try{ // the columns from the table SalesOrder  are used
        	  	SalesOrderObj.seto_id(results.getString("o_id"));
                SalesOrderObj.setodate(results.getString("odate"));
                SalesOrderObj.setcid(results.getString("cid"));
                SalesOrderObj.setoDelStatus(results.getString("oDelStatus"));
                SalesOrderObj.setoDelDate(results.getString("oDelDate"));
                SalesOrderObj.setinNO(results.getString("pinNO"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the SalesOrder object");
         }
         return SalesOrderObj;
      }
 
}  
    

