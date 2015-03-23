

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
      public Customer findByc_id(String c_id)
    {
        IFDBCus dbCus = new DBCustomer();
        return dbCus.searchCustomerc_id( c_id, true);
    }
      public int updateCus(String c_id, String cname, String caddress, String czip_code, String ccity, String cphone_no)
      {
          IFDBCus dbCus = new DBCustomer();
          Customer Cus = new Customer();
          Cus.setc_id(c_id);
          Cus.setcname(cname);
          Cus.setcaddress(caddress);
          Cus.setczip_code(czip_code);
          Cus.setccity(ccity);
          Cus.setcphone_no(cphone_no);
          return  dbCus.updateCustomer(Cus);
          
          
      }
      public void insertNew(Customer CusObj)
      {
           IFDBCus dbCus = new DBCustomer();
           dbCus.insertCustomer(CusObj);
      }
    
}
