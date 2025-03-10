package week3.productCatalog.labs.record;

record Product(String name, String description, int price) {

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getPrice() {
    return price;
  }
}
