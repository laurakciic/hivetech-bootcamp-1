package services;

import exceptions.DuplicateVehicleException;
import exceptions.NoSuchVehicleException;
import models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleManagerImpl implements VehicleManager {

    List<Vehicle> fleet = new ArrayList<>();

    @Override
    public void addVehicleToFleet(Vehicle newVehicle) {
        fleet.add(newVehicle);
        System.out.println("Vehicle " + newVehicle.getManufacturer().toUpperCase() + " " + newVehicle.getModel().toUpperCase() + " added successfully.");
    }

    @Override
    public boolean vinAlreadyExists(int VIN) {
        for (Vehicle member: fleet) {
            if (member.getVIN() == VIN) return true;
        }
        return false;
    }

    @Override
    public String removeVehicleFromFleet(int VIN) throws NoSuchVehicleException {
        for (Vehicle vehicle: fleet) {
            if (vehicle.getVIN() == VIN) {
                fleet.remove(vehicle);
                return "Vehicle successfully removed.";
            }
        }
        throw new NoSuchVehicleException("No such vehicle in the fleet.");
    }

    @Override
    public void searchVehicleByVIN(int VIN) throws NoSuchVehicleException {
        for (Vehicle vehicle: fleet) {
            if (vehicle.getVIN() == VIN) {
                System.out.println("Vehicle found: " + vehicle);
                return;
            }
        }
        throw new NoSuchVehicleException("Vehicle with the given VIN was not found in the fleet.");
    }

    @Override
    public void searchVehiclesByModel(String model) throws NoSuchVehicleException {
        List<Vehicle> foundVehicles = new ArrayList<>();

        for (Vehicle vehicle: fleet) {
            if (vehicle.getModel().equals(model)) {
                foundVehicles.add(vehicle);
            }
        }
        if (foundVehicles.size() == 0) throw new NoSuchVehicleException("No vehicles of the specified model were found in the fleet.");

        int i = 1;
        System.out.println("Search results: ");
        for (Vehicle vehicle: foundVehicles) {
            System.out.println(i++ + ". " + vehicle.toString());
        }
    }

    @Override
    public void searchVehiclesByManufacturer(String manufacturer) throws NoSuchVehicleException {
        List<Vehicle> foundVehicles = new ArrayList<>();

        for (Vehicle vehicle: fleet) {
            if (vehicle.getManufacturer().equals(manufacturer)) {
                foundVehicles.add(vehicle);
            }
        }
        if (foundVehicles.size() == 0) throw new NoSuchVehicleException("No vehicles of the specified manufacturer were found in the fleet.");

        int i = 1;
        System.out.println("Search results: ");
        for (Vehicle vehicle: foundVehicles) {
            System.out.println(i++ + ". " + vehicle.toString());
        }
    }

    @Override
    public void listFleetMembers() {
        if (fleet.size() == 0) {
            System.out.println("Fleet does not contain any vehicles, please add some first.");
            return;
        }

        int i = 1;
        System.out.println("Fleet");
        for (Vehicle vehicle: fleet) {
            System.out.println(i++ + ". " + vehicle.toString());
        }
    }
}
