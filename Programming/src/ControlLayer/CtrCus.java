

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
    public Customer findByName(String Name)
    {
        IFDBCus dbCus = new DBCustomer();
        return dbCus.searchCustomerName(Name, true);
    }
      public Customer findByID(String ID)
    {
        IFDBCus dbCus = new DBCustomer();
        return dbCus.searchCustomerID( ID, true);
    }
      public int updateCus(String id, String Name, String address, String zipCode, String city, String phoneno)
      {
          IFDBCus dbCus = new DBCustomer();
          Customer Cus = new Customer();
          Cus.setID(id);
          Cus.setName(Name);
          Cus.setAddress(address);
          Cus.setZipcode(zipCode);
          Cus.setCity(city);
          Cus.setPhoneno(phoneno);
          return  dbCus.updateCustomer(Cus);
          
          
      }
      public void insertNew(Customer CusObj)
      {
           IFDBCus dbCus = new DBCustomer();
           dbCus.insertCustomer(CusObj);
      }
    
}
