
abstract class Vehicle{
    abstract void acceleration();
    abstract void brake();

    void startEngine(){
        System.out.println("Engine Started");
    }
}

class Car extends Vehicle{

    @Override
    void acceleration() {
        System.out.println("Car: Pressing gas Pedal...");
    }

    @Override
    void brake() {
        System.out.println("Car: Applying brakes...");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.startEngine();
        myCar.acceleration();
        myCar.brake();
    }
}
