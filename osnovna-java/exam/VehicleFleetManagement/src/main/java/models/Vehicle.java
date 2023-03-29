package models;


import java.time.Year;

public abstract class Vehicle {
    private int VIN;
    private String manufacturer;
    private String model;
    private Year manufactureYear;
    private String paint;
    private String fuelType;

    public Vehicle(int VIN, String manufacturer, String model, Year manufactureYear, String paint, String fuelType) {
        this.VIN = VIN;
        this.manufacturer = manufacturer;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.paint = paint;
        this.fuelType = fuelType;
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Year getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Year manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getPaint() {
        return paint;
    }

    public void setPaint(String paint) {
        this.paint = paint;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
