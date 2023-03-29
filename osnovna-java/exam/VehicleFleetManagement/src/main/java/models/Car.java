package models;

import java.time.Year;

public class Car extends Vehicle {
    private int doorNumber;
    private String bodyStyle;

    public Car(int VIN, String manufacturer, String model, Year manufactureYear, String paint, String fuelType,
               int doorNumber, String bodyStyle) {
        super(VIN, manufacturer, model, manufactureYear, paint, fuelType);
        this.doorNumber = doorNumber;
        this.bodyStyle = bodyStyle;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + super.getManufacturer() + '\'' +
                ", model='" + super.getModel() + '\'' +
                ", VIN=" + super.getVIN() +
                ", manufactureYear=" + super.getManufactureYear() +
                ", fuelType='" + super.getFuelType() + '\'' +
                ", paint='" + super.getPaint() + '\'' +
                ", doorNumber=" + doorNumber +
                ", bodyStyle='" + bodyStyle + '\'' +
                '}';
    }
}
