

package ControlLayer;
import ModelLayer.*;
import DBLayer.*;
import java.util.ArrayList;
/**
 * CtrSupp.java
 * @author group 6
 * @version 18.03.2015
 */
public class CtrSupp {
   
    
    /** Creates a new instance of CtrSupp */
    public CtrSupp() {
        
    }
    public ArrayList findAllSupplier()
    {
      IFDBSupp dbSupp = new DBSupplier();
      ArrayList allSupp = new ArrayList();
      allSupp = dbSupp.getAllSuppliers(false);
      return allSupp;
    }
    public Supplier findByName(String sName)
    {
        IFDBSupp dbSupp = new DBSupplier();
        return dbSupp.searchSuppliersName(sName, true);
    }
      public Supplier findBys_id(String s_id)
    {
        IFDBSupp dbSupp = new DBSupplier();
        return dbSupp.searchSuppliers_id( s_id, true);
    }
      public int updateSupp(String sName, String sAddress, String sCountry, String sPhone, String sEmail,String s_id)
      {
          IFDBSupp dbSupp = new DBSupplier();
          Supplier Supp = new Supplier();
          Supp.setsName(sName);
          Supp.setsAddress(sAddress);
          Supp.setsCountry(sCountry);
          Supp.setsPhone(sPhone);
          Supp.setsEmail(sEmail);
          Supp.sets_id(s_id);
          return  dbSupp.updateSupplier(Supp);
          
          
      }
      public void insertNew(Supplier SuppObj)
      {
           IFDBSupp dbSupp = new DBSupplier();
           dbSupp.insertSupplier(SuppObj);
      }
    
}
