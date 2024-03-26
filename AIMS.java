package Project;

	import java.util.*;

	public class AIMS {

		    private static class Product {
		        private String name;
		        private int quantity;
		        private double price;
		        private String category;

		        public Product(String name, int quantity, double price, String category) {
		            this.name = name;
		            this.quantity = quantity;
		            this.price = price;
		            this.category = category;
		        }

		        public String getName() {
		            return name;
		        }

		        public int getQuantity() {
		            return quantity;
		        }

		        public void setQuantity(int quantity) {
		            this.quantity = quantity;
		        }

		        public double getPrice() {
		            return price;
		        }

		        public String getCategory() {
		            return category;
		        }
		    }

		    private static class InventorySystem {
		        private Map<String, Product> inventory;
		        private List<String> salesHistory;

		        public InventorySystem() {
		            this.inventory = new HashMap<>();
		            this.salesHistory = new ArrayList<>();
		        }

		        public void addItem(String name, int quantity, double price, String category) {
		            Product product = new Product(name, quantity, price, category);
		            inventory.put(name, product);
		            System.out.println("Item added to inventory:");
		            System.out.println("Name: " + name + ", Quantity: " + quantity + ", Price: ₱" + price + ", Category: " + category);
		        }

		        public void sellItem(String name, int quantity) {
		            if (inventory.containsKey(name)) {
		                Product product = inventory.get(name);
		                if (product.getQuantity() >= quantity) {
		                    product.setQuantity(product.getQuantity() - quantity);
		                    double totalPrice = quantity * product.getPrice();
		                    salesHistory.add("Sold: " + quantity + " " + name + "(s), Total Price: ₱" + totalPrice + ", Timestamp: " + new Date());
		                    System.out.println("Item sold:");
		                    System.out.println("Name: " + name + ", Quantity: " + quantity + ", Total Price: ₱" + totalPrice);
		                } else {
		                    System.out.println("Not enough " + name + " in stock.");
		                }
		            } else {
		                System.out.println("Item " + name + " not found in inventory.");
		            }
		        }

		        public void displayInventory() {
		            System.out.println("Current Inventory:");
		            if (inventory.isEmpty()) {
		                System.out.println("No items in inventory.");
		            } else {
		                for (Product product : inventory.values()) {
		                    System.out.println("Name: " + product.getName() + ", Quantity: " + product.getQuantity() + ", Price: ₱" + product.getPrice() + ", Category: " + product.getCategory());
		                }
		            }
		        }

		        public void searchProduct(String keyword) {
		            System.out.println("Search Results:");
		            boolean found = false;
		            for (Product product : inventory.values()) {
		                if (product.getName().toLowerCase().contains(keyword.toLowerCase()) || product.getCategory().toLowerCase().contains(keyword.toLowerCase())) {
		                    System.out.println("Name: " + product.getName() + ", Quantity: " + product.getQuantity() + ", Price: ₱" + product.getPrice() + ", Category: " + product.getCategory());
		                    found = true;
		                }
		            }
		            if (!found) {
		                System.out.println("No matching products found.");
		            }
		        }

		        public void checkStockAlert() {
		            System.out.println("Low Stock Alerts:");
		            boolean hasAlerts = false;
		            for (Product product : inventory.values()) {
		                if (product.getQuantity() < 5) {
		                    System.out.println("Name: " + product.getName() + ", Quantity: " + product.getQuantity());
		                    hasAlerts = true;
		                }
		            }
		            if (!hasAlerts) {
		                System.out.println("No items with low stock.");
		            }
		        }

		        public void displaySalesHistory() {
		            System.out.println("Sales History:");
		            if (salesHistory.isEmpty()) {
		                System.out.println("No sales yet.");
		            } else {
		                for (String sale : salesHistory) {
		                    System.out.println(sale);
		                }
		            }
		        }
		    }

		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        InventorySystem inventorySystem = new InventorySystem();

		        while (true) {
		            System.out.println("\n=== Inventory Management System ===");
		            System.out.println("1. Add item to inventory");
		            System.out.println("2. Sell item from inventory");
		            System.out.println("3. Display current inventory");
		            System.out.println("4. Search product");
		            System.out.println("5. Check low stock alerts");
		            System.out.println("6. Display sales history");
		            System.out.println("7. Exit");
		            System.out.print("Enter your choice: ");

		            int choice = scanner.nextInt();
		            switch (choice) {
		                case 1:
		                    System.out.print("Enter item name: ");
		                    String addItemName = scanner.next();
		                    System.out.print("Enter quantity to add: ");
		                    int addQuantity = scanner.nextInt();
		                    System.out.print("Enter price per item: ");
		                    double addItemPrice = scanner.nextDouble();
		                    System.out.print("Enter category: ");
		                    String addItemCategory = scanner.next();
		                    inventorySystem.addItem(addItemName, addQuantity, addItemPrice, addItemCategory);
		                    break;
		                case 2:
		                    System.out.print("Enter item name: ");
		                    String sellItemName = scanner.next();
		                    System.out.print("Enter quantity to sell: ");
		                    int sellQuantity = scanner.nextInt();
		                    inventorySystem.sellItem(sellItemName, sellQuantity);
		                    break;
		                case 3:
		                    inventorySystem.displayInventory();
		                    break;
		                case 4:
		                    System.out.print("Enter search keyword: ");
		                    String searchKeyword = scanner.next();
		                    inventorySystem.searchProduct(searchKeyword);
		                    break;
		                case 5:
		                    inventorySystem.checkStockAlert();
		                    break;
		                case 6:
		                    inventorySystem.displaySalesHistory();
		                    break;
		                case 7:
		                    System.out.println("Exiting...");
		                    System.exit(0);
		                    break;
		                default:
		                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
		            }
		        }
		    }
		}
