package services;

import exceptions.DuplicateVehicleException;
import exceptions.EmptyFleetException;
import exceptions.NoSuchVehicleException;
import models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleManagerImpl implements VehicleManager {

    List<Vehicle> fleet = new ArrayList<>();

    /**
     *
     * @param newVehicle - vehicle object to be saved in the fleet
     */
    @Override
    public void addVehicleToFleet(Vehicle newVehicle) {
        fleet.add(newVehicle);
        System.out.println("Vehicle " + newVehicle.getManufacturer().toUpperCase() + " " + newVehicle.getModel().toUpperCase() + " added successfully.");
    }

    /**
     *
     * @param VIN - unique value var of the vehicle object to be created (V-vehicle, I-identification, N-number)
     * @return - if VIN value is already present in the fleet, func returns true, otherwise false
     */
    @Override
    public boolean vinAlreadyExists(int VIN) {
        for (Vehicle member: fleet) {
            if (member.getVIN() == VIN) return true;
        }
        return false;
    }

    /**
     *
     * @param VIN - unique value variable of which vehicles differ
     * @throws NoSuchVehicleException if fleet does not contain VIN of the vehicle user has given
     */
    @Override
    public String removeVehicleFromFleet(int VIN) throws NoSuchVehicleException {
        try {
            isFleetEmpty();
        } catch (EmptyFleetException e) {
            return "Fleet does not contain any vehicles, please add some first.";
        }

        for (Vehicle vehicle: fleet) {
            if (vehicle.getVIN() == VIN) {
                fleet.remove(vehicle);
                return "Vehicle successfully removed.";
            }
        }
        throw new NoSuchVehicleException("No such vehicle in the fleet.");
    }

    /**
     *
     * @throws EmptyFleetException if list of fleet vehicles does not contain any Vehicle object
     */
    @Override
    public boolean isFleetEmpty() throws EmptyFleetException {
        if (fleet.isEmpty()) throw new EmptyFleetException();
        return false;
    }

    /**
     *
     * @param VIN - search parameter based upon vehicle will be listed
     * @throws NoSuchVehicleException if no vehicle in the fleet corresponds to the given VIN
     */
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

    /**
     *
     * @param model - search parameter based upon vehicle/s will be listed
     * @throws NoSuchVehicleException if no vehicle in the fleet corresponds to the given model
     */
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

    /**
     *
     * @param manufacturer - search parameter based upon vehicle/s will be listed
     * @throws NoSuchVehicleException if no vehicle in the fleet corresponds to the given manufacturer
     */
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
        try {
            isFleetEmpty();
        } catch (EmptyFleetException e) {
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
