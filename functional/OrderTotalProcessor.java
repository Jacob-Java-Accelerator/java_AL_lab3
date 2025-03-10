package week3.functional;

@FunctionalInterface
interface OrderTotalProcessor {
  OrderTotal process(Order[] order);
}
