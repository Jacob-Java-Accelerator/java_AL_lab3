package week3.productCatalog.labs;

/**
 * Product
 */
sealed abstract class Product implements ProductInterface permits ClothingProduct, ElectronicsProduct {

  String name;
  String description;
  int price;

  Product(String name, String description, int price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  Product() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Product [name=" + name + ", description=" + description + ", price=" + price + "]";
  }
}
