package entities;

public class product {
	private String name;
	private double price;
	private int quantity;
	
	public product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public product (String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice (double price) {
		 this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	
public double TotalValueInStock() {
	return price * quantity;
}
public void addProducts(int quantity) {
	this.quantity += quantity;
}
public void removeProducts(int quantity) {
	this.quantity -= quantity;
}public String toString() {
	return name
			+ ", $ "
			+ String.format("%.2f" , price)
			+", "
			+ quantity
			+" units, total: $"
			+String.format("%.2f" , TotalValueInStock());
}
}
