package shapes;

public class Circle extends Shape {
    private final double radius;

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle (radius: " + String.format("%.2f", radius) + ", color: " + color + ")";
    }
}

