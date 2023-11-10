package hw.practice1.model.vo;

public class Product {
	
	private String pName;
	private int price;
	private String brand;
	public Product() {
		super();
	}

	public Product(String pName, int price, String brand) {
		super();
		this.pName = pName;
		this.price = price;
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [pName=" + pName + ", price=" + price + ", brand=" + brand + "]";
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
