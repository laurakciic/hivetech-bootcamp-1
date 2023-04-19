public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Vehicle");
        Car car = new Car("Tesla");
        Truck truck = new Truck("Truck");

        vehicle.drive();
        vehicle.accelerate();
        vehicle.park();

        car.drive();
        car.accelerate();
        car.park();

        truck.accelerate();
        truck.drive();
        truck.park();
    }
}
