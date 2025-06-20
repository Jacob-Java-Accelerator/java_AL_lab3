# Product Catalog Labs

This directory contains a set of Java labs demonstrating object-oriented and modern Java features for modeling a product catalog. The labs include the use of sealed classes, interfaces, enums, factory patterns, and Java records.

## Overview

The labs are organized to show how to model different types of products (e.g., clothing, electronics) using inheritance, interfaces, and factory methods. There is also an example using Java records for a more concise data model.

---

## Lab Files

### 1. `ProductInterface.java`

Defines the contract for all product types:

```java
interface ProductInterface {
  String getName();
  void setName(String name);
  String getDescription();
  void setDescription(String description);
  int getPrice();
  void setPrice(int price);
}
```

All product classes must implement these methods.

---

### 2. `Product.java`

A sealed abstract class implementing `ProductInterface` and serving as the base for all products:

```java
sealed abstract class Product implements ProductInterface permits ClothingProduct, ElectronicsProduct {
  String name;
  String description;
  int price;
  // ... constructors, getters, setters, toString ...
}
```

- Only `ClothingProduct` and `ElectronicsProduct` can extend this class (enforced by `sealed`).

---

### 3. `ClothingProduct.java` and `ElectronicsProduct.java`

Concrete product types extending `Product`:

```java
final class ClothingProduct extends Product { /* ... */ }
final class ElectronicsProduct extends Product { /* ... */ }
```

Each provides constructors for initialization.

---

### 4. `ProductType.java`

An enum listing all supported product types:

```java
public enum ProductType {
  CLOTHING_PRODUCT,
  ELECTRONIC_PRODUCT
}
```

Used by the factory to determine which product to create.

---

### 5. `ProductFactory.java`

A factory class for creating products based on type:

```java
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
```

- **Extensibility:** To add a new product type, add it to `ProductType`, create a new class extending `Product`, and update the switch in `ProductFactory`.

---

### 6. `ProductMain.java`

A sample main class demonstrating how to use the factory:

```java
public class ProductMain {
  public static void main(String[] args) {
    ProductInterface product = ProductFactory.createProduct(
        "Socks",
        "Experience unparalleled comfort and exceptional durability with our Ultra-Comfort Merino Wool Socks...",
        5,
        ProductType.CLOTHING_PRODUCT);
    System.out.println(product.toString());
  }
}
```

- **Output:**
  ```
  Product [name=Socks, description=Experience unparalleled comfort and exceptional durability with our Ultra-Comfort Merino Wool Socks..., price=5]
  ```

---

### 7. `record/Product.java`

A concise alternative using Java records:

```java
record Product(String name, String description, int price) {
  public String getName() { return name; }
  public String getDescription() { return description; }
  public int getPrice() { return price; }
}
```

- Records are immutable and automatically provide `equals`, `hashCode`, and `toString`.

---

## How to Extend

- **Add a new product type:**
  1. Add a new value to `ProductType`.
  2. Create a new class extending `Product`.
  3. Update the `ProductFactory` switch to handle the new type.

## Summary

These labs demonstrate modern Java OOP features, including sealed classes, records, and the factory pattern, for building a flexible and extensible product catalog system.
