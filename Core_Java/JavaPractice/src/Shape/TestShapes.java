package Shape;

public class TestShapes {
    public static void main(String[] args) {
        Shape circle = new Circle(3);
        Shape rect = new Rectangle(4,5);
        System.out.println("Circle Area: "+circle.area());
        System.out.println("Reactangle Area: "+rect.area());
    }
}
