package week3.productCatalog.labs.sealedclass;

public final class ElectronicsProduct extends Product {

	public ElectronicsProduct(String name, double price) {
		super(name, price);
	}

	@Override
	public String getCategory() {
		return "Electronics";
	}
}
