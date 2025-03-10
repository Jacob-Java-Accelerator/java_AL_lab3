package week3.productCatalog.labs;

public class ProductMain {

  public static void main(String[] args) {
    ProductInterface product = ProductFactory.createProduct(
        "Socks",
        """
             Experience unparalleled comfort and exceptional
             durability with our Ultra-Comfort Merino Wool Socks.
             Designed for those who demand the best in their footwear,
             these socks are the perfect blend of luxury,
             performance, and style. Whether you're hiking through rugged terrain,
             running a marathon, or simply lounging at home,
             these socks will keep your feet feeling cozy and fresh all day long.
            """,
        5,
        ProductType.CLOTHING_PRODUCT);

    System.out.println(product.toString());
  }

}
