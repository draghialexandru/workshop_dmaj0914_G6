package ControlLayer;
import ModelLayer.*;
import DBLayer.*;

import java.util.ArrayList;



public class CtrInvoice {

	public CtrInvoice() {
		
	}
	
	public ArrayList findAllInvoices()
	{
		IFDBInv Invoice = new DBInvoice();
	      ArrayList allInvoice = new ArrayList();
	      allInvoice = Invoice.getAllInvoices(false);
	      return allInvoice;
	}
	 
	 public Invoice findByID(String inNo)
	    {
	        IFDBInv Invoice = new DBInvoice();
	        return Invoice.findInvoice( inNo, true);
	    }
	
	 public int updateInvoice (String inNo, String inPayDay, Double price, String oid){
		 IFDBInv Invoice = new DBInvoice();
		 Invoice newInvoice = new Invoice();
		 newInvoice.setinNo(inNo);
		 newInvoice.setInPayDay(inPayDay);
		 newInvoice.setPrice(price);
		 newInvoice.setOid(oid);
		 return Invoice.updateInvoice(newInvoice);
	 }
	 
	 public void insertNew (Invoice InvoiceObj)
	 {
		 IFDBInv Invoice = new DBInvoice();
		 Invoice.insertInvoice(InvoiceObj);
		 
	 }
}
