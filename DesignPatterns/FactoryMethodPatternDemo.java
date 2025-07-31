interface MotorVehicle {
    void build();
}

class Car implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Build Car");
    }
}

class Motorcycle implements MotorVehicle {
    @Override
    public void build() {
        System.out.println("Build Motorcycle");
    }
}

abstract class MotorVehicleFactory {
    public MotorVehicle create() {
        MotorVehicle vehicle = createMotorVehicle();
        vehicle.build();
        return vehicle;
    }

    protected abstract MotorVehicle createMotorVehicle();
}

class CarFactory extends MotorVehicleFactory {
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Car();
    }
}

class MotorcycleFactory extends MotorVehicleFactory {
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Motorcycle();
    }
}

public class FactoryMethodPatternDemo {
    public static void main(String[] args) {
        MotorVehicleFactory factory = new CarFactory();
        MotorVehicle car = factory.create(); // builds and returns a Car

        factory = new MotorcycleFactory();
        MotorVehicle motorcycle = factory.create(); // builds and returns a Motorcycle
    }
}
