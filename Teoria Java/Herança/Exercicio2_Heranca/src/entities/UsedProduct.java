package entities;

import java.util.Date;

public class UsedProduct extends Product {

	private Date manufactureDate;
	
	public UsedProduct () {
		super();
	}
	
	public UsedProduct (String name, Double price, Date manufactureDate) {
		super (name, price);
		this.manufactureDate = manufactureDate;
	}
	
	
	public void setManufactureDate (Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	public Date getManufactureDate () {
		return manufactureDate;
	}
	
	@Override
	public String priceTag() {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yy");
		return String.format("%s (used) $%.2f (Manufacture date: %s)", 
				getName(), 
				getPrice(), 
				sdf.format(manufactureDate));
	}
	
}
