package week3.functional.lambda.transform;

import java.util.*;
import java.util.stream.*;

public class OrderProcessor {
	public static void main(String[] args) {
		List<OrderItem> items = List.of(
				new OrderItem("Laptop", 1200.0, "Electronics"),
				new OrderItem("T-Shirt", 25.0, "Clothing"),
				new OrderItem("Headphones", 199.99, "Electronics"),
				new OrderItem("Book", 15.0, "Books")
		);


		List<OrderItem> electronics = items.stream()
				.filter(item -> item.getCategory().equals("Electronics"))
				.collect(Collectors.toList());

		System.out.println("Electronics:");
		electronics.forEach(System.out::println);


		List<OrderItem> discounted = items.stream()
				.map(item -> new OrderItem(
						item.getName(),
						item.getPrice() * 0.9,
						item.getCategory()
				))
				.collect(Collectors.toList());

		System.out.println("\nDiscounted Items:");
		discounted.forEach(System.out::println);
	}
}

