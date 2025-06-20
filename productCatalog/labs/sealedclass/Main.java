package week3.productCatalog.labs.sealedclass;

public class Main {
	public static void main(String[] args) {
		Product phone = new ElectronicsProduct("Smartphone", 799.99);
		Product tshirt = new ClothingProduct("T-Shirt", 19.99);

		printProduct(phone);
		printProduct(tshirt);
	}

	public static void printProduct(Product product) {
		System.out.println("Name: " + product.getName());
		System.out.println("Price: $" + product.getPrice());
		System.out.println("Category: " + product.getCategory());
		System.out.println("---------------------------");
	}
}
