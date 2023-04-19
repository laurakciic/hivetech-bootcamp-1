
public class Vehicle implements Accelerable{
    private String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void drive() {
        System.out.println(getModel() + " driving...");
    }

    public void park() {
        System.out.println(getModel() + " parking...");
    }

    @Override
    public void accelerate() {
        System.out.println(getModel() + " accelerating...");
    }
}
