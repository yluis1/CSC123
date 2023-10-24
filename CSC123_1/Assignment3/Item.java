//Yoselin Luis (yluis1@toromail.csudh.edu)
import java.util.ArrayList;
import java.util.List;

public class Item {

		private String name;
	    private String vendor;
	    private double price;
	    private double cost;
	    private double weight;
	    private double taxRate;

	    public Item(String name, String vendor, double price, double cost, double weight, double taxRate) {
	        this.name = name;
	        this.vendor = vendor;
	        this.price = price;
	        this.cost = cost;
	        this.weight = weight;
	        this.taxRate = taxRate;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getVendor() {
	        return vendor;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public double getCost() {
	        return cost;
	    }

	    public double getWeight() {
	        return weight;
	    }

	    public double getTaxRate() {
	        return taxRate;
	    }

	    public double calculateTotalCost() {
	        return price + (price * taxRate / 100);
	    }
}

	class Publication extends Item {
	    private String author;
	    private String publicationMonth;
	    private int numPages;

	    public Publication(String name, String vendor, double price, double cost, double weight, double taxRate,
	                       String author, String publicationMonth, int numPages) {
	        super(name, vendor, price, cost, weight, taxRate);
	        this.author = author;
	        this.publicationMonth = publicationMonth;
	        this.numPages = numPages;
	      
	    }
	    public String getAuthor() {
	        return author;
	    }

	    public String getPublicationMonth() {
	        return publicationMonth;
	    }

	    public int getNumPages() {
	        return numPages;
	    }
	}

	class FoodItem extends Item {
	    private String sellByDate;
	    private String useByDate;

	    public FoodItem(String name, String vendor, double price, double cost, double weight, double taxRate,
	                    String sellByDate, String useByDate) {
	        super(name, vendor, price, cost, weight, taxRate);
	        this.sellByDate = sellByDate;
	        this.useByDate = useByDate;
	    }
	    public String getSellByDate() {
	        return sellByDate;
	    }

	    public String getUseByDate() {
	        return useByDate;
	    }
	}


	class GeneralGroceryItem extends Item {
	    public GeneralGroceryItem(String name, String vendor, double price, double cost, double weight, double taxRate) {
	        super(name, vendor, price, cost, weight, taxRate);
	    }
	}
	class ShoppingCart {
	    private List<Item> items = new ArrayList<>();

	    public void addItem(Item item) {
	        items.add(item);
	    }

	    public int getNumItems() {
	        return items.size();
	    }

	    public double calculateTotalCost() {
	        double totalCost = 0;
	        for (Item item : items) {
	            totalCost += item.calculateTotalCost();
	        }
	        return totalCost;
	    }

	    public void printItems() {
	        System.out.println("Items in the shopping cart:");
	        for (Item item : items) {
	            System.out.println("Name: " + item.getName());
	            System.out.println("Vendor: " + item.getVendor());
	            System.out.println("Price: $" + item.getPrice());
	            System.out.println("Tax: $" + (item.getPrice() * item.getTaxRate() / 100));
	            System.out.println("Total: $" + item.calculateTotalCost());
	            System.out.println("------------------------");
	        }
	    }
	}



