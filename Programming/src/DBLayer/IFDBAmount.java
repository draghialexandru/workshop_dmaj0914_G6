package DBLayer;
import ModelLayer.ProductsAmount;
/**
 * Interface to the DBAmountuctr
 * @author group 6
 */
public interface IFDBAmount {
	//search Amount by p_id
    public ProductsAmount searchAmountp_id( String p_id, boolean retriveAssociation);
    //insert a new Amount
    public int insertAmount(ProductsAmount Amount);
    //update information about an Amount
    public int updateAmount(ProductsAmount Amount);
    
}
