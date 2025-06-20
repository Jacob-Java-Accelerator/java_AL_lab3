package week3.productCatalog.labs.switchstatement;

public class ProductDescription {

	public static String getDescription(String productName) {
		return """
               Product Overview:
               ==================
               Name     : %s
               Category : Electronics
               Features :
                   - High performance
                   - Energy efficient
                   - 2-year warranty
               """.formatted(productName);
	}

	public static void main(String[] args) {
		String description = getDescription("4K Smart TV");
		System.out.println(description);
	}
}
