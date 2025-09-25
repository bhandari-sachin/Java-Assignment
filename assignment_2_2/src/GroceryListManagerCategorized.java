package assignment_2_2;

import java.util.HashMap;

public class GroceryListManagerCategorized {

    // Store item name -> Item object
    private final HashMap<String, Item> groceryList = new HashMap<>();

    // Add item with cost and category
    public void addItem(String name, double cost, String category) {
        if (!groceryList.containsKey(name)) {
            groceryList.put(name, new Item(name, cost, category));
            System.out.println(name + " added under " + category + " with cost €" + cost);
        } else {
            System.out.println(name + " is already in the list!");
        }
    }

    // Remove item
    public void removeItem(String name) {
        if (groceryList.remove(name) != null) {
            System.out.println(name + " removed from the list.");
        } else {
            System.out.println(name + " is not in the list!");
        }
    }

    // Display all items
    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("The grocery list is empty.");
        } else {
            System.out.println("\nGrocery List:");
            int index = 1;
            for (Item item : groceryList.values()) {
                System.out.println(index + ". " + item);
                index++;
            }
        }
    }

    // Check if an item exists
    public boolean checkItem(String name) {
        return groceryList.containsKey(name);
    }

    // Calculate total cost
    public double calculateTotalCost() {
        double total = 0;
        for (Item item : groceryList.values()) {
            total += item.cost;
        }
        return total;
    }

    // Display items by category
    public void displayByCategory(String category) {
        System.out.println("\nItems in category: " + category);
        boolean found = false;
        for (Item item : groceryList.values()) {
            if (item.category.equalsIgnoreCase(category)) {
                System.out.println("- " + item.name + " (€" + item.cost + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found in this category.");
        }
    }

    // Main method
    public static void main(String[] args) {
        GroceryListManagerCategorized manager = new GroceryListManagerCategorized();

        manager.addItem("Apple", 2.5, "Fruits");
        manager.addItem("Milk", 1.8, "Dairy");
        manager.addItem("Bread", 3.0, "Bakery");
        manager.addItem("Cheese", 4.0, "Dairy");

        manager.displayList();

        System.out.println("\nTotal cost: €" + manager.calculateTotalCost());

        manager.displayByCategory("Dairy");
        manager.displayByCategory("Fruits");

        System.out.println("\nRemoving Milk...");
        manager.removeItem("Milk");
        manager.displayList();
    }
}

