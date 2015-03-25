package DBLayer;
import ModelLayer.*;

import java.util.ArrayList;
/**
 * Interface to the DBCustomerr
 * @author group 6
 */
public interface IFDBCus {
    // get all Customers
    public ArrayList<Customer> getAllCustomers(boolean retriveAssociation);
    //get one Customer having the id
    public Customer findCustomer(String CusID, boolean retriveAssociation);
    public Customer searchCustomercname( String cname, boolean retriveAssociation);
    public Customer searchCustomerc_id( String c_id, boolean retriveAssociation);
    //insert a new Customer
    public int insertCustomer(Customer Cus);
    //update information about an Customer
    public int updateCustomer(Customer Cus);
    //delete customer
    public int delete(String c_id);
    
}
