package week3.functional;

class OrderTotal {

  private int totalAmount;
  private Double totalPriceAmount;

  public OrderTotal(int totalAmount, Double totalPriceAmount) {
    this.totalAmount = totalAmount;
    this.totalPriceAmount = totalPriceAmount;
  }

  @Override
  public String toString() {
    return "Total amount: " + totalAmount + ", Total price amount: " + totalPriceAmount.toString() + " "
        + totalPriceAmount.toString();
  }

  public int getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(int totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Double getTotalPriceAmount() {
    return totalPriceAmount;
  }

  public void setTotalPriceAmount(Double totalPriceAmount) {
    this.totalPriceAmount = totalPriceAmount;
  }
}
