# Java Accelerator Labs

This repository contains four major labs, each demonstrating key concepts in Java and modern software engineering:

- **functional**: Functional programming and lambdas in Java
- **microblog**: Microservices with Spring Boot, Kubernetes, and Docker
- **productCatalog**: Object-oriented design, sealed classes, records, and factory patterns
- **stocks**: Reactive programming, JavaFX, and real-time data processing

---

## 1. Functional Lab (`functional`)

Demonstrates functional programming in Java using interfaces, lambdas, and method references to process orders.

### Key Classes & Interfaces

- `Order`: Represents an order with a name and amount.
- `OrderTotal`: Holds the total number of orders and their combined price.
- `OrderProcessor` (Functional Interface): Processes an array of orders to produce an `OrderTotal`.
- `OrderTotalProcessor` (Functional Interface): Similar to `OrderProcessor`, used for demonstration.

### Example Usage

```java
Order order = new Order("hello", 14.3);
Order order2 = new Order("hi", 12.3);

OrderTotalProcessor orderTotalProcessor = (orders) -> Arrays.stream(orders)
    .reduce(new OrderTotal(0, 0.0),
        (total, x) -> new OrderTotal(
            total.getTotalAmount() + 1,
            total.getTotalPriceAmount() + x.getAmount()),
        (total1, total2) -> new OrderTotal(
            total1.getTotalAmount() + total2.getTotalAmount(),
            total1.getTotalPriceAmount() + total2.getTotalPriceAmount()));

OrderProcessor processor = orderTotalProcessor::process;
OrderTotal orderTotal = processor.process(new Order[] { order, order2 });
System.out.println(orderTotal);
```

**Output:**

```
Total amount: 2, Total price amount: 26.6 26.6
```

---

## 2. Microblog Lab (`microblog-spring-kubernetes-lab-demo-master`)

A full-stack microservices project using Spring Boot, Docker, and Kubernetes. It features an API Gateway, User Service, and Post Service, all containerized and orchestrated with Kubernetes.

### Architecture

- **API Gateway**: Central entry point, handles routing and cross-cutting concerns.
- **User Service**: Manages user data, scalable via Kubernetes.
- **Post Service**: Manages posts/articles, also scalable.
- **Kubernetes**: Orchestrates and manages service deployment and scaling.
- **Docker**: Containerizes each service for portability.

### Project Goals

- Demonstrate scalable, resilient microservices architecture.
- Use API Gateway for unified access and routing.
- Employ Kubernetes and Docker for deployment, scaling, and management.

### More Info

See [`microblog-spring-kubernetes-lab-demo-master/readme.md`](microblog-spring-kubernetes-lab-demo-master/microblog-spring-kubernetes-lab-demo-master/readme.md) for a detailed breakdown and architecture diagram.

---

## 3. Product Catalog Lab (`productCatalog`)

Demonstrates modern Java OOP features: sealed classes, interfaces, enums, factory patterns, and records for modeling a product catalog.

### Key Files

- `ProductInterface.java`: Interface for all products.
- `Product.java`: Sealed abstract base class for products.
- `ClothingProduct.java`, `ElectronicsProduct.java`: Concrete product types.
- `ProductType.java`: Enum for product types.
- `ProductFactory.java`: Factory for creating products.
- `ProductMain.java`: Usage example.
- `record/Product.java`: Alternative concise model using Java records.

### Example Usage

```java
ProductInterface product = ProductFactory.createProduct(
    "Socks",
    "Experience unparalleled comfort and exceptional durability...",
    5,
    ProductType.CLOTHING_PRODUCT);
System.out.println(product);
```

**Output:**

```
Product [name=Socks, description=Experience unparalleled comfort and exceptional durability..., price=5]
```

### How to Extend

1. Add a new value to `ProductType`.
2. Create a new class extending `Product`.
3. Update the `ProductFactory` switch to handle the new type.

---

## 4. Stocks Lab (`stocks`)

A JavaFX and RxJava-based app for real-time stock price visualization, demonstrating reactive programming and UI updates.

### Key Classes

- `App`: JavaFX application entry point; subscribes to real-time price updates.
- `StockProcessor`: Uses RxJava to process and filter stock price data.
- `StockPriceService`: Fetches current stock price from an external API.
- `StockData`: Data model for stock price API responses.

### Example Usage

```java
public class App extends Application {
  public void start(Stage primaryStage) {
    Observable<Double> priceObservable = stockPriceProcessor.getFilteredStockPrices();
    priceObservable.subscribe(price -> Platform.runLater(() -> updateUI(priceLabel, price)));
  }
}
```

### Concepts Demonstrated

- Reactive programming with RxJava
- Real-time UI updates with JavaFX
- Consuming and parsing external APIs

---

# Summary

Each lab in this repository demonstrates a different aspect of modern Java or software engineering:

- Functional programming and lambdas
- Microservices, Docker, and Kubernetes
- Object-oriented design, sealed classes, and records
- Reactive programming and real-time data

Explore each lab's directory for more details and code samples!
