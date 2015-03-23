package DBLayer;
import ModelLayer.*;

import java.util.ArrayList;
/**
 * Interface to the DBSalesOrderr
 * @author group 6
 */
public interface IFDBSalesOrder {
    // get all SalesOrders
    public ArrayList<SalesOrder> getAllSalesOrders(boolean retriveAssociation);
    //get one SalesOrder having the o_id
    public SalesOrder findSalesOrder(String o_id, boolean retriveAssociation);
  //  public SalesOrder searchSalesOrdero_id( String o_id, boolean retriveAssociation);
    //insert a new SalesOrder
    public int insertSalesOrder(SalesOrder SalesOrder);
    //update information about an SalesOrder
    public int updateSalesOrder(SalesOrder SalesOrder);
    
}
