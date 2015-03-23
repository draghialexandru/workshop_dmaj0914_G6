package ControlLayer;
import ModelLayer.*;
import DBLayer.*;

import java.util.ArrayList;



public class CtrSalesOrder {

	public CtrSalesOrder() {
		
	}
	
	public ArrayList findAllSalesOrders()
	{
		IFDBSalesOrder SalesOrder = new DBSalesOrder();
	      ArrayList allSalesOrder = new ArrayList();
	      allSalesOrder = SalesOrder.getAllSalesOrders(false);
	      return allSalesOrder;
	}
	 
	 public SalesOrder findByID(String o_id)
	    {
	        IFDBSalesOrder SalesOrder = new DBSalesOrder();
	        return SalesOrder.findSalesOrder( o_id, true);
	    }
	
	 public int updateSalesOrder (String o_id, String odate, String cid, String oDelStatus, String oDelDate, String inNO ){
		 IFDBSalesOrder SalesOrder = new DBSalesOrder();
		 SalesOrder newSalesOrder = new SalesOrder();
		 newSalesOrder.seto_id(o_id);
		 newSalesOrder.setodate(odate);
		 newSalesOrder.setcid(cid);
		 newSalesOrder.setoDelStatus(oDelStatus);
		 newSalesOrder.setoDelDate(oDelDate);
		 newSalesOrder.setinNO(inNO);
		 return SalesOrder.updateSalesOrder(newSalesOrder);
	 }
	 
	 public void insertNew (SalesOrder SalesOrderObj)
	 {
		 IFDBSalesOrder SalesOrder = new DBSalesOrder();
		 SalesOrder.insertSalesOrder(SalesOrderObj);
		 
	 }
}
