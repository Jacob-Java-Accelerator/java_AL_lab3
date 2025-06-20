package week3.functional.lambda.refactor;

import java.util.function.Function;

public class OrderTotalOld {
	public static void main(String[] args) {
		Function<Double[], Double> totalCalculator = new Function<>() {
			@Override
			public Double apply(Double[] prices) {
				double total = 0;
				for (double price : prices) {
					total += price;
				}
				return total;
			}
		};

		Double[] prices = { 10.0, 20.0, 15.5 };
		System.out.println("Total: $" + totalCalculator.apply(prices));
	}
}
