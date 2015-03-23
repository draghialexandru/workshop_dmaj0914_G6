package DBLayer;
import ModelLayer.*;

import java.util.ArrayList;
/**
 * Interface to the DBInvoicer
 * @author group 6
 */
public interface IFDBInv {
    // get all Invoices
    public ArrayList<Invoice> getAllInvoices(boolean retriveAssociation);
    //get one Invoice having the inNo
    public Invoice findInvoice(String inNo, boolean retriveAssociation);
    //insert a new Invoice
    public int insertInvoice(Invoice Inv);
    //update information about an Invoice
    public int updateInvoice(Invoice Inv);
    
}
