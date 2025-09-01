package assignment_2_2;

class Item {
    String name;
    double cost;
    String category;

    Item(String name, double cost, String category) {
        this.name = name;
        this.cost = cost;
        this.category = category;
    }

    public String toString() {
        return name + " : €" + cost + " (" + category + ")";
    }
}

