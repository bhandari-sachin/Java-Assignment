package assignment_2_2;

import java.util.HashMap;
import java.util.Map;

public class GroceryListManagerHashMap {

    private HashMap<String, Double> groceryList = new HashMap<>();

    // Add an item with cose

    public void addItem(String item, double cost) {
        if (!groceryList.containsKey(item)) {
            groceryList.put(item, cost);
            System.out.println(item + " added with cost €" + cost);

        } else {
            System.out.println(item + " already exists in the list!");
        }
    }

    // Remove an item

    public void removeItem(String item) {
        if (groceryList.remove(item) != null) {

            System.out.println(item + " removed from list!");
        } else {
            System.out.println(item + " is not in the list!");
        }


    }

    // Display the list

    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("No items in the list!");
        }
        else {
            System.out.println("\nGrocery List:");
            int index = 1;
            for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
                System.out.println(index + ". " + entry.getKey() + " : €" + entry.getValue());
                index++;
            }
        }

    }

    // check if an item is present
    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    // Calculate total cost
    public double calculateTotalCost(){
        double total = 0.0;
        for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
            total += entry.getValue();
        }
        return total;
    }


    // Main method

    public static void main(String[] args) {
        GroceryListManagerHashMap groceryListManager = new GroceryListManagerHashMap();

        // Add items
        groceryListManager.addItem("Apple", 2.5);
        groceryListManager.addItem("Banana", 2.9);
        groceryListManager.addItem("Cheese", 3.5);
        groceryListManager.addItem("Pizza", 2.0);
        groceryListManager.addItem("Pizza", 2.1); // duplicate test


        // Display list
        groceryListManager.displayList();

        // Check item
        String checkItem = "Milk";
        System.out.println("\nIs \"" + checkItem + "\" in the grocery list? " + groceryListManager.checkItem(checkItem));


        // Calculate total cost
        System.out.println("\nTotal Cost: €" + groceryListManager.calculateTotalCost());


        // Remove item
        System.out.println("\nRemoving \"" + checkItem + "\" from the list.");
        groceryListManager.removeItem(checkItem);

        // Display updated list
        groceryListManager.displayList();
        System.out.println("\nTotal Cost: €" + groceryListManager.calculateTotalCost());

        // Try removing non-existent item
        groceryListManager.removeItem(checkItem);
    }

















}
