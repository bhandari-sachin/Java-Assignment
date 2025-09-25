
// This Item class is to represent each grocery item with multiple attributes

package assignment_2_2;

class Item {
    String name;
    double cost;
    String category;
    int quantity;

    Item(String name, double cost, String category, int quantity) {
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.quantity = quantity;
    }

    Item(String name, double cost, String category) {
        this(name, cost, category,1);
    }


    @Override
    public String toString() {
        if (quantity > 1) {
            return name + " : €" + cost + " (" + category + ") x" + quantity;
        } else {
            return name + " : €" + cost + " (" + category + ")";
        }
    }

}
