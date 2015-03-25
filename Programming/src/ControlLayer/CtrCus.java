

package ControlLayer;
import ModelLayer.*;
import DBLayer.*;
import java.util.ArrayList;
/**
 * CtrCus.java
 * @author group 6
 * @version 18.03.2015
 */
public class CtrCus {
   
    
    /** Creates a new instance of CtrCus */
    public CtrCus() {
        
    }
    public ArrayList findAllCustomer()
    {
      IFDBCus dbCus = new DBCustomer();
      ArrayList allCus = new ArrayList();
      allCus = dbCus.getAllCustomers(false);
      return allCus;
    }
    public Customer findBycname(String cname)
    {
        IFDBCus dbCus = new DBCustomer();
        return dbCus.searchCustomercname(cname, true);
    }
      public Customer findByID(String c_id)
    {
        IFDBCus dbCus = new DBCustomer();
        return dbCus.searchCustomerc_id( c_id, true);
    }
      public int updateCus(String c_id, String cname, String caddress, String czip_code, String ccity, String cphone_no)
      {
          IFDBCus dbCus = new DBCustomer();
          Customer Cus = new Customer();
          Cus.setID(c_id);
          Cus.setName(cname);
          Cus.setAddress(caddress);
          Cus.setZipcode(czip_code);
          Cus.setCity(ccity);
          Cus.setPhoneno(cphone_no);
          return  dbCus.updateCustomer(Cus);
          
          
      }
      public void insertNew(Customer CusObj)
      {
           IFDBCus dbCus = new DBCustomer();
           dbCus.insertCustomer(CusObj);
      }
    
      public void delete(String c_id)
      {
    	  IFDBCus dbCus = new DBCustomer();
    	  dbCus.delete(c_id);
      }
}
