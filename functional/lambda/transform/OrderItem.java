package week3.functional.lambda.transform;

public class OrderItem {
	private final String name;
	private final double price;
	private final String category;

	public OrderItem(String name, double price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public String getName() { return name; }
	public double getPrice() { return price; }
	public String getCategory() { return category; }

	@Override
	public String toString() {
		return name + " - $" + price + " [" + category + "]";
	}
}
