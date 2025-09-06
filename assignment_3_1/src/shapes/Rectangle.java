package shapes;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle (width: " + String.format("%.2f", width) +
                ", height: " + String.format("%.2f", height) + ", color: " + color + ")";
    }
}
