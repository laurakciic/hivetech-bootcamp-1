public class Car extends Vehicle implements Accelerable {

    public Car(String model) {
        super(model);
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public void drive() {
        System.out.println(getModel() + " driving...");;
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
