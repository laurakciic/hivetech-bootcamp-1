package models;

import java.time.Year;

public class Truck extends Vehicle {
    private Double cargoCapacity;

    public Truck(int VIN, String manufacturer, String model, Year manufactureYear, String paint, String fuelType,
                 Double cargoCapacity) {
        super(VIN, manufacturer, model, manufactureYear, paint, fuelType);
        this.cargoCapacity = cargoCapacity;
    }

    public Double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(Double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "manufacturer='" + super.getManufacturer() + '\'' +
                ", model='" + super.getModel() + '\'' +
                ", VIN=" + super.getVIN() +
                ", manufactureYear=" + super.getManufactureYear() +
                ", fuelType='" + super.getFuelType() + '\'' +
                ", paint='" + super.getPaint() + '\'' +
                ", cargoCapacity=" + cargoCapacity +
                '}';
    }
}
