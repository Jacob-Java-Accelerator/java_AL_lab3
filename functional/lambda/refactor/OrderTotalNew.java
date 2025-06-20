package week3.functional.lambda.refactor;

import java.util.function.Function;

public class OrderTotalNew {
	public static void main(String[] args) {
		Function<Double[], Double> totalCalculator = prices ->
				java.util.Arrays.stream(prices).mapToDouble(Double::doubleValue).sum();

		Double[] prices = { 10.0, 20.0, 15.5 };
		System.out.println("Total: $" + totalCalculator.apply(prices));
	}
}
