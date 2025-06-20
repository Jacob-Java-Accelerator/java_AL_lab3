package week3.productCatalog.labs.sealedclass;

public final class ClothingProduct extends Product {

	public ClothingProduct(String name, double price) {
		super(name, price);
	}

	@Override
	public String getCategory() {
		return "Clothing";
	}
}
