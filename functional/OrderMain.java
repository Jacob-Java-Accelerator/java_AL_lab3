package week3.functional;

import java.util.Arrays;

public class OrderMain {
  public static void main(String[] args) {

    Order order = new Order("hello", 14.3);
    Order order2 = new Order("hi", 12.3);

    OrderTotalProcessor orderTotalProcessor = new OrderTotalProcessor() {
      @Override
      public OrderTotal process(Order[] orders) {
        return Arrays.stream(orders)
            .reduce(
                new OrderTotal(0, 0.0),
                (total, order) -> new OrderTotal(
                    total.getTotalAmount() + 1,
                    total.getTotalPriceAmount() + order.getAmount()),
                (total1, total2) -> new OrderTotal(
                    total1.getTotalAmount() + total2.getTotalAmount(),
                    total1.getTotalPriceAmount() + total2.getTotalPriceAmount()));
      }
    };

    /*
     * Using Anonymous inner classes
     */
    OrderProcessor processor = new OrderProcessor() {
      @Override
      public OrderTotal process(Order[] orders) {
        return orderTotalProcessor.process(orders);
      }
    };

    OrderTotal orderTotal = processor.process(new Order[] { order, order2 });
    System.out.println(orderTotal.toString());

    /*
     * Rewrite using lambda
     *
     */

    OrderTotalProcessor orderTotalProcessorLambda = orders -> {
      return Arrays.stream(orders)
          .reduce(
              new OrderTotal(0, 0.0),
              (total, x) -> new OrderTotal(
                  total.getTotalAmount() + 1,
                  total.getTotalPriceAmount() + x.getAmount()),
              (total1, total2) -> new OrderTotal(
                  total1.getTotalAmount() + total2.getTotalAmount(),
                  total1.getTotalPriceAmount() + total2.getTotalPriceAmount()));
    };

    // lambda syntax
    // OrderProcessor processorLambda = orders ->
    // orderTotalProcessorLambda.process(orders);

    // using method reference
    OrderProcessor processorMethodReference = orderTotalProcessorLambda::process;

    // OrderTotal orderTotal2 = processorLambda.process(new Order[] { order, order2
    // });
    OrderTotal orderTotal2 = processorMethodReference.process(new Order[] { order, order2 });
    System.out.println(orderTotal2.toString());
  }
}
