package Shape;

public class Rectangle extends Shape{
    private double length;
    private double breadth;

    public Rectangle(double breadth, double length) {
        this.breadth = breadth;
        this.length = length;
    }

    @Override
    public double area() {
        return length*breadth;
    }
}
