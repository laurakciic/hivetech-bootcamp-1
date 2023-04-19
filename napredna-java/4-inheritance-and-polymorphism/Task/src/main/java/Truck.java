public class Truck extends Vehicle implements Accelerable{

    public Truck(String model) {
        super(model);
    }

    @Override
    public void drive() {
        System.out.println(getModel() + " driving...");
    }

    @Override
    public void park() {
        System.out.println(getModel() + " parking...");
    }

    @Override
    public void accelerate() {
        System.out.println(getModel() + " accelerating...");
    }
}
