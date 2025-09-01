package assignment_2_2;

public class GroceryListTester {

    public static void main(String[] args) {
        GroceryListManagerQuantityTracking manager = new GroceryListManagerQuantityTracking();

        // --- Add items with different costs, categories, and quantities ---
        manager.addItem("Apple", 2.5, "Fruits", 5);
        manager.addItem("Banana", 1.2, "Fruits", 10);
        manager.addItem("Milk", 1.8, "Dairy", 2);
        manager.addItem("Cheese", 4.0, "Dairy", 3);
        manager.addItem("Bread", 3.0, "Bakery", 0); // zero quantity to test displayAvailableItems
        manager.addItem("Cake", 5.0, "Bakery", 1);

        // --- Display all items ---
        System.out.println("\n--- Full Grocery List ---");
        manager.displayList();

        // --- Test total cost calculation (taking quantity into account) ---
        System.out.println("\n--- Total Cost ---");
        System.out.println("Total cost: €" + manager.calculateTotalCost());

        // --- Test category display ---
        System.out.println("\n--- Items in Fruits ---");
        manager.displayByCategory("Fruits");

        System.out.println("\n--- Items in Bakery ---");
        manager.displayByCategory("Bakery");

        // --- Test quantity tracking ---
        System.out.println("\n--- Available Items ---");
        manager.displayAvailableItems();

        // --- Update quantity and test again ---
        System.out.println("\n--- Updating quantity of Bread to 4 ---");
        manager.updateQuantity("Bread", 4);
        manager.displayAvailableItems();

        // --- Check if an item exists ---
        System.out.println("\nIs Milk in the list? " + manager.checkItem("Milk"));
        System.out.println("Is Orange in the list? " + manager.checkItem("Orange"));

        // --- Remove an item ---
        System.out.println("\nRemoving Cheese from the list...");
        manager.removeItem("Cheese");
        manager.displayList();

        // --- Final total cost after updates ---
        System.out.println("\n--- Final Total Cost ---");
        System.out.println("Total cost: €" + manager.calculateTotalCost());
    }
}
