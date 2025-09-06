package shapes;

public class Triangle extends Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "Triangle (base: " + String.format("%.2f", base) +
                ", height: " + String.format("%.2f", height) + ", color: " + color + ")";
    }
}

