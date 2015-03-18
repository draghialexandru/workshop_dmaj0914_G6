package ModelLayer;
/**
*
* @author Draghi Alexandru
* @version 18.03.2015
*/

public class Clothing {
	private String size;
	private String colour;
	private String productType;
public Clothing() {
	productType = "Clothing";
	}


public Clothing(String size,String colour){
    this.size = size;
    this.colour = colour;
}
//set instances
    public void setSize(String size)
    {
    	this.size = size;
    }
    public void setColour(String colour)
    {
    	this.colour = colour;
    }
//get instances
    public String getSize()
    {
    	return size;
    }
    public String getColour()
    {
    	return colour;
    }
}