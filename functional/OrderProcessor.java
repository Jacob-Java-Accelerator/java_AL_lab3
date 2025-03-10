package week3.functional;

@FunctionalInterface
interface OrderProcessor {
  OrderTotal process(Order[] order);
}
