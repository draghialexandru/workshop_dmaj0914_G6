package ModelLayer;
/**
*
* @author group 6
* @version 18.03.2015
*/

public class Equipment {
	private String type;
	private String description;
	private String productType;

public Equipment() {
	productType = "Equipment";
	}


public Equipment(String type,String description){
    this.type = type;
    this.description = description;
}
//set instances
public void setType(String type)
{
	this.type = type;
}
public void setDescription(String description)
{
	this.description = description;
}
//get instances
public String getType()
{
	return type;
}
public String getDescription()
{
	return description;
}
}