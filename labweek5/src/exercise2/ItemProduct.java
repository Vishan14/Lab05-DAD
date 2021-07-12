package exercise2;

import java.io.Serializable;

public class ItemProduct implements Serializable {
	
	private String name;
	private int itemProductID;
	private float price;
	

	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setItemProductID(int itemProductID)
	{
		this.itemProductID = itemProductID;
	}
	
	public int getItemProductID()
	{
		return itemProductID;
	}
	
	public void setPrice(float price)
	{
		this.price = price;
	}
	
	public float getPrice()
	{
		return price;
	}

}