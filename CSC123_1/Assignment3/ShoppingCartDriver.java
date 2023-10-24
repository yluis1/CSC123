//Yoselin Luis (yluis1@toromail.csudh.edu)
public class ShoppingCartDriver {

	public static void main(String[] args) {
		
		ShoppingCart cart = new ShoppingCart();

        Item item1 = new GeneralGroceryItem("Mop", "Vendor 1", 8.99, 4.50, 0.5, 8.0);
        Item item2 = new Publication("Charlotte's Web", "Bookstore", 15.50, 12.50, 1.2, 5.0, "Author: E.B.White", "October", 192);
        Item item3 = new FoodItem("Watermelon", "Grocery Store", 3.49, 1.00, 0.2, 3.0, "10/21/2023", "10/23/2023");

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);

        System.out.println("Number of items in the shopping cart:"+ cart.getNumItems());
        System.out.println("Total Cost: $" + cart.calculateTotalCost());
        cart.printItems();

    }
}
