package ModelLayer;
/**
*
* @author group 6
* @version 18.03.2015
*/

public class GunReplicas {
	private String fabric;
	private String calibre;
	private String productType;

public GunReplicas() {
	productType = "GunReplicas";
	}


public GunReplicas(String fabric,String calibre){
    this.fabric = fabric;
    this.calibre = calibre;
}
//set instances
public void setFabric(String fabric)
{
	this.fabric = fabric;
}
public void setCalibre(String calibre)
{
	this.calibre = calibre;
}
//get instances
public String getFabric()
{
	return fabric;
}
public String getCalibre()
{
	return calibre;
}
}