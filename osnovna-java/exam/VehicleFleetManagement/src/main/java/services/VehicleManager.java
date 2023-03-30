package services;

import exceptions.DuplicateVehicleException;
import exceptions.NoSuchVehicleException;
import models.Vehicle;

public interface VehicleManager {
    void addVehicleToFleet(Vehicle vehicle);

    boolean vinAlreadyExists(int VIN);

    String removeVehicleFromFleet(int VIN) throws NoSuchVehicleException;

    void searchVehicleByVIN(int VIN) throws NoSuchVehicleException;

    void searchVehiclesByModel(String model) throws NoSuchVehicleException;

    void searchVehiclesByManufacturer(String manufacturer) throws NoSuchVehicleException;

    void listFleetMembers();
}
