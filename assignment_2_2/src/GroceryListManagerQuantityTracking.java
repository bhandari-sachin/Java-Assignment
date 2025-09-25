package assignment_2_2;

import java.util.HashMap;

public class GroceryListManagerQuantityTracking {

    private final HashMap<String, Item> groceryList = new HashMap<>();

    // Add item with cost, category, and quantity
    public void addItem(String name, double cost, String category, int quantity) {
        if (!groceryList.containsKey(name)) {
            groceryList.put(name, new Item(name, cost, category, quantity));
            System.out.println(name + " added under " + category + " with cost €" + cost + " and quantity " + quantity);
        } else {
            System.out.println(name + " is already in the list! Updating quantity instead.");
            updateQuantity(name, groceryList.get(name).quantity + quantity);
        }
    }

    // Update the quantity of an existing item
    public void updateQuantity(String name, int newQuantity) {
        Item item = groceryList.get(name);
        if (item != null) {
            item.quantity = newQuantity;
            System.out.println("Quantity of " + name + " updated to " + newQuantity);
        } else {
            System.out.println(name + " is not in the list!");
        }
    }

    // Display items with positive quantity
    public void displayAvailableItems() {
        System.out.println("\nAvailable Items:");
        boolean found = false;
        for (Item item : groceryList.values()) {
            if (item.quantity > 0) {
                System.out.println("- " + item);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items with positive quantity.");
        }
    }

    // Existing methods (Task 2 + 3) for reference:
    public void removeItem(String name) {
        if (groceryList.remove(name) != null) {
            System.out.println(name + " removed from the list.");
        } else {
            System.out.println(name + " is not in the list!");
        }
    }

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

    public boolean checkItem(String name) {
        return groceryList.containsKey(name);
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Item item : groceryList.values()) {
            total += item.cost * item.quantity; // account for quantity
        }
        return total;
    }

    public void displayByCategory(String category) {
        System.out.println("\nItems in category: " + category);
        boolean found = false;
        for (Item item : groceryList.values()) {
            if (item.category.equalsIgnoreCase(category) && item.quantity > 0) {
                System.out.println("- " + item.name + " (€" + item.cost + ") x" + item.quantity);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found in this category.");
        }
    }

    // Main method to demonstrate Task 4
    public static void main(String[] args) {
        GroceryListManagerQuantityTracking manager = new GroceryListManagerQuantityTracking();

        manager.addItem("Apple", 2.5, "Fruits", 5);
        manager.addItem("Milk", 1.8, "Dairy", 2);
        manager.addItem("Bread", 3.0, "Bakery", 0); // zero quantity to test displayAvailableItems()
        manager.addItem("Cheese", 4.0, "Dairy", 3);

        manager.displayAvailableItems();

        System.out.println("\nTotal cost: €" + manager.calculateTotalCost());

        manager.updateQuantity("Bread", 4);
        manager.displayAvailableItems();

        manager.displayByCategory("Dairy");
    }
}

