package DBLayer;
import ModelLayer.*;

import java.util.ArrayList;
/**
 * Interface to the DBSupplierr
 * @author group 6
 */
public interface IFDBSupp {
    // get all Suppliers
    public ArrayList<Supplier> getAllSuppliers(boolean retriveAssociation);
    //get one Supplier having the id
    public Supplier findSupplier(String SuppID, boolean retriveAssociation);
    public Supplier searchSuppliersName( String sName, boolean retriveAssociation);
    public Supplier searchSuppliers_id( String s_id, boolean retriveAssociation);
    //insert a new Supplier
    public int insertSupplier(Supplier Supp);
    //update information about an Supplier
    public int updateSupplier(Supplier Supp);
    
}
