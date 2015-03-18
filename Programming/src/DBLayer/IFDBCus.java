package DBLayer;
import ModelLayer.*;

import java.util.ArrayList;
/**
 * Interface to the DBCustomerr
 * @author Draghi Alexandru
 */
public interface IFDBCus {
    // get all Customers
    public ArrayList<Customer> getAllCustomers(boolean retriveAssociation);
    //get one Customer having the id
    public Customer findCustomer(String CusID, boolean retriveAssociation);
    public Customer searchCustomerName( String name, boolean retriveAssociation);
    public Customer searchCustomerID( String id, boolean retriveAssociation);
    //insert a new Customer
    public int insertCustomer(Customer Cus);
    //update information about an Customer
    public int updateCustomer(Customer Cus);
    
}
