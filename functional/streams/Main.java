package week3.functional.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {

		List<Order> orders = List.of(
				new Order("Alice", 150.0),
				new Order("Bob", 89.99),
				new Order("Alice", 200.5),
				new Order("Charlie", 320.0),
				new Order("Bob", 45.0)
		);


		double totalAmount = orders.stream()
				.mapToDouble(Order::getAmount)
				.sum();
		System.out.println("Total Order Amount: $" + totalAmount);


		Map<String, Long> ordersPerCustomer = orders.stream()
				.collect(Collectors.groupingBy(
						Order::getCustomerName,
						Collectors.counting()
				));
		System.out.println("\nOrders Per Customer:");
		ordersPerCustomer.forEach((customer, count) ->
				System.out.println(customer + " => " + count + " orders")
		);


		Map<String, Double> amountPerCustomer = orders.stream()
				.collect(Collectors.groupingBy(
						Order::getCustomerName,
						Collectors.summingDouble(Order::getAmount)
				));
		System.out.println("\nTotal Amount Per Customer:");
		amountPerCustomer.forEach((customer, amount) ->
				System.out.println(customer + " => $" + amount)
		);
	}
}
