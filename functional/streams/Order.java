package week3.functional.streams;

public class Order {
	private final String customerName;
	private final double amount;

	public Order(String customerName, double amount) {
		this.customerName = customerName;
		this.amount = amount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return customerName + ": $" + amount;
	}
}

