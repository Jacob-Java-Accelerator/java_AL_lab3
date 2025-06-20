package week3.productCatalog.labs.switchstatement;

public class CategoryHandler {

	public static String getCategoryTag(String category) {
		return switch (category) {
			case "Electronics" -> "🔌 Tech & Gadgets";
			case "Clothing" -> "👕 Fashion & Apparel";
			case "Books" -> "📚 Literature";
			case "Groceries" -> "🛒 Daily Essentials";
			default -> "❓ Unknown Category";
		};
	}

	public static void main(String[] args) {
		String tag = getCategoryTag("Clothing");
		System.out.println("Category Tag: " + tag);
	}
}
