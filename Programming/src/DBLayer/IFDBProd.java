package DBLayer;
import ModelLayer.*;

import java.util.ArrayList;
/**
 * Interface to the DBProductr
 * @author group 6
 */
public interface IFDBProd {
    // get all Products
    public ArrayList<Product> getAllProducts(boolean retriveAssociation);
    //get one Product having the P_id
    public Product findProduct(String P_id, boolean retriveAssociation);
    public Product searchProductpName( String pName, boolean retriveAssociation);
  //  public Product searchProductP_id( String P_id, boolean retriveAssociation);
    //insert a new Product
    public int insertProduct(Product Prod);
    //update information about an Product
    public int updateProduct(Product Prod);
    
}
