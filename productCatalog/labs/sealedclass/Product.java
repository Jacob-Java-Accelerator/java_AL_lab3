package week3.productCatalog.labs.sealedclass;

public sealed abstract class Product permits ElectronicsProduct, ClothingProduct {

	private final String name;
	private final double price;

	protected Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public abstract String getCategory();
}
