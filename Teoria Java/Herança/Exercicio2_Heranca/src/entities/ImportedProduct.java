package entities;

public class ImportedProduct extends Product {

	private Double customsFee;
	
	public ImportedProduct() {
		super();
	}
	
	public ImportedProduct(String name, Double price, Double customsFree) {
		super (name, price);
		this.customsFee = customsFree;
	}
	
	public void setCustomsFree (double customsFree) {
		this.customsFee = customsFree;
	}
	
	public Double getCustomsFree () {
		return customsFee;
	}
	
	
	public Double totalPrice() {
		Double price = super.getPrice() + customsFee;
		return price;
	}
	
	@Override
	public String priceTag() {
		return String.format("%s $%.2f (Customs fee: $%.2f)", getName(), totalPrice(), customsFee);
	}
}
