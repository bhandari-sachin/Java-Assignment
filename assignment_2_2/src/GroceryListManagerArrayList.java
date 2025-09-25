package assignment_2_2;

import java.util.ArrayList;

public class GroceryListManagerArrayList {

    private final ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        if (!groceryList.contains(item)) {
            groceryList.add(item);
            System.out.println(item + " added to the grocery list.");
        } else {
            System.out.println(item + " is already in the grocery list!");
        }
    }


    public void removeItem(String item) {
        if (groceryList.contains(item)) {
            groceryList.remove(item);
            System.out.println(item + " removed from the grocery list.");
        } else {
            System.out.println(item + " is not in the grocery list.");
        }
    }

    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("Grocery List is empty.");
        } else {
            System.out.println("\nGrocery List:");
            for (int i = 0; i < groceryList.size(); i++) {
                System.out.println((i + 1) + ". " + groceryList.get(i));
            }
        }
    }

    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }


    // Main method

    public static void main(String[] args) {
        GroceryListManagerArrayList groceryListManager = new GroceryListManagerArrayList();

        // Add items
        groceryListManager.addItem("Apple");
        groceryListManager.addItem("Banana");
        groceryListManager.addItem("Cheese");
        groceryListManager.addItem("Apple"); // duplicate test


        // Display list
        groceryListManager.displayList();

        // Check item
        String checkItem = "Apple";
        System.out.println("\nIs \"" + checkItem + "\" in the grocery list? " + groceryListManager.checkItem(checkItem));

        // Remove item
        System.out.println("\nRemoving \"" + checkItem + "\" from the list.");
        groceryListManager.removeItem(checkItem);


        // Display updated list
        groceryListManager.displayList();


        // Try removing non-existent item
        groceryListManager.removeItem(checkItem);
    }


}
