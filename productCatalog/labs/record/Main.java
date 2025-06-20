package week3.productCatalog.labs.record;

public class Main {
	public static void main(String[] args) {

		Product product = new Product("Laptop", 999.99, "Electronics");


		System.out.println("Product Name: " + product.name());
		System.out.println("Price: $" + product.price());
		System.out.println("Category: " + product.category());
	}
}
