package week3.productCatalog.labs;

class ProductFactory {

  public static ProductInterface createProduct(String name, String description, int price, ProductType type) {
    ProductInterface product = create(type);

    product.setName(name);
    product.setDescription(description);
    product.setPrice(price);

    return product;
  }

  public static ProductInterface create(ProductType type) {
    return switch (type) {
      case ProductType.CLOTHING_PRODUCT -> new ClothingProduct();
      case ProductType.ELECTRONIC_PRODUCT -> new ElectronicsProduct();
    };
  }
}
