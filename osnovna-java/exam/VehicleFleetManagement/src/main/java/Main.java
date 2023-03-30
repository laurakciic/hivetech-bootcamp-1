import exceptions.DuplicateVehicleException;
import exceptions.NoSuchVehicleException;
import models.Car;
import models.Truck;
import models.Vehicle;
import services.VehicleManager;
import services.VehicleManagerImpl;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.Year;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final VehicleManager service = new VehicleManagerImpl();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger LOGGER = createLogger();

    public static void main(String[] args) {
        int menu = 0; // ensure menu is initialized and in case of wrong input it jumps to the default case in switch case
        while(menu != 5) {
            boolean isValid = false;
            while (!isValid) {
                showMainMenuOptions();
                try {
                    menu = scanner.nextInt();
                    if (menu < 1 || menu > 5) {
                        throw new InputMismatchException();
                    } else {
                        isValid = true;
                    }
                } catch (InputMismatchException e) {
                    LOGGER.warning("Invalid input for main menu.");
                    LOGGER.getHandlers()[0].flush(); // flush the log messages to the log file
                    System.out.println(); // without new line console output is inconsistent
                    System.out.println("Please enter a whole number, between 1 and 5.");
                    scanner.nextLine();
                }
            }

            switch (menu) {
                case 1 -> service.addVehicleToFleet(createNewVehicle()); // DuplicateVehicleExc is handled when entering VIN
                case 2 -> searchVehicles();
                case 3 -> service.listFleetMembers();
                case 4 -> removeVehicle();
                case 5 -> LOGGER.info("User has exited the program.");
                default -> System.out.println("Please enter a number between 1-5.");
            }
        }
        scanner.close();
    }

    // MARK: FUNCTIONS

    public static Logger createLogger() {
        Logger LOGGER = Logger.getLogger(Main.class.getName());

        try {
            FileHandler fileHandler = new FileHandler("log.txt");
            LOGGER.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            LOGGER.warning("Log could not be created: " + e.getMessage());
        }

        return LOGGER;
    }

    public static void showMainMenuOptions() {
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("Vehicle Fleet Management System");
        System.out.println("--------------------------------");
        System.out.println("1. Add a vehicle to the fleet");
        System.out.println("2. Search vehicles by VIN/model/manufacturer");
        System.out.println("3. Print all vehicles in the fleet");
        System.out.println("4. Remove vehicle from the fleet");
        System.out.println("5. Quit");
        System.out.print("Enter option: ");
    }

    public static Vehicle createNewVehicle() {
        if (getVehicleChoice() == 1) {
            return createNewCar();
        } else {
            return createNewTruck();
        }
    }

    public static int getVehicleChoice() {
        boolean isValid = false;
        int menu = 0;

        while (!isValid){
            System.out.println("What type of vehicle would you like to add?");
            System.out.println("Enter '1' for car");
            System.out.println("Enter '2' for truck");
            System.out.print("Enter option: ");
            try {
                menu = scanner.nextInt();
                if (menu < 1 || menu > 2) throw new InputMismatchException("Entered input was neither '1' nor '2'");
                isValid = true;
            } catch (InputMismatchException e) {
                LOGGER.warning("Invalid input.");
                LOGGER.getHandlers()[0].flush(); // flush the log messages to the log file
                System.out.println(); // without new line console output is inconsistent
                scanner.nextLine();
            }
        }
        return menu;
    }

    public static Car createNewCar() {
        return new Car(getVin(), getManufacturer(), getModel(), getManufactureYear(), getPaint(), getFuelType(), getDoorNumber(), getBodyStyle());
    }

    public static Truck createNewTruck() {
        return new Truck(getVin(), getManufacturer(), getModel(), getManufactureYear(), getPaint(), getFuelType(), getCargoCapacity());
    }

    public static void searchVehicles() {
        try {
            searchVehiclesBy(getSearchChoice()); // first find out how user wants to filter vehicles (by VIN/model/manufacturer)
        } catch (InputMismatchException e) {
            LOGGER.warning("Wrong input for search choice.");
        }
    }

    public static void removeVehicle() {
        int vin = vehicleToRemove();                                    // get vin
        try {
            System.out.println(service.removeVehicleFromFleet(vin));    // pass vin to a method for removing a vehicle
        } catch (NoSuchVehicleException e) {
            LOGGER.warning("Tried to delete a vehicle that does not exist.");
        }
    }

    public static int vehicleToRemove() {
        int vin = 0;
        while (vin <= 0) {
            System.out.print("Enter VIN of the vehicle you would like to remove: ");
            try {
                vin = scanner.nextInt();
                if (vin <= 0) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                LOGGER.info("Invalid input.");
                LOGGER.getHandlers()[0].flush(); // flush the log messages to the log file
                System.out.println(); // without new line console output is inconsistent
                scanner.nextLine();
            }
        }
        return vin;
    }

    public static int getSearchChoice() {
        int searchChoice = 0;
        while (searchChoice <= 0 || searchChoice > 3) {
            System.out.println("How would you like to search vehicles?");
            System.out.println("Enter '1' to search by VIN");
            System.out.println("Enter '2' to search by model");
            System.out.println("Enter '3' to search by manufacturer");
            System.out.print("Enter option: ");
            try {
                searchChoice = scanner.nextInt();
                if (searchChoice <= 0 || searchChoice > 3) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                LOGGER.warning("Invalid input");
                LOGGER.getHandlers()[0].flush(); // flush the log messages to the log file
                System.out.println(); // without new line console output is inconsistent
                scanner.nextLine();
            }
        }
        return searchChoice;
    }

    public static void searchVehiclesBy(int filter) {
        if (filter == 1) {
            searchByVIN();
        } else if (filter == 2) {
            searchByModel();
        } else if (filter == 3) {
            searchByManufacturer();
        } else {
            throw new InputMismatchException("Please enter a number between 1 and 3.");
        }
    }

    public static void searchByVIN() {
        int vin = 0;

        while (vin <= 0) {
            System.out.print("Enter VIN: ");
            try {
                vin = scanner.nextInt();
                if (vin <= 0) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                LOGGER.warning("Invalid input for VIN.");
                LOGGER.getHandlers()[0].flush(); // flush the log messages to the log file
                System.out.println(); // without new line console output is inconsistent
                scanner.nextLine();
            }
        }

        try {
            service.searchVehicleByVIN(vin);
        } catch (NoSuchVehicleException e) {
            LOGGER.info("No vehicle found with specified vin.");
        }
    }

    public static void searchByModel() {
        String model = "";

        System.out.print("Enter model: ");
        try {
            model = scanner.next();
        } catch (InputMismatchException e) {
            LOGGER.info("Wrong input type for model.");
        }

        try {
            service.searchVehiclesByModel(model);
        } catch (NoSuchVehicleException e) {
            LOGGER.info("No vehicle found with specified model.");
        }
    }

    public static void searchByManufacturer() {
        String manufacturer = "";

        System.out.print("Enter manufacturer: ");
        try {
            manufacturer = scanner.next();
        } catch (InputMismatchException e) {
            LOGGER.info("Wrong input type for manufacturer.");
        }

        try {
            service.searchVehiclesByManufacturer(manufacturer);
        } catch (NoSuchVehicleException e) {
            LOGGER.info("No vehicle found with specified manufacturer.");
        }
    }

    // MARK: functions called when creating a new vehicle

    public static int getVin() {
        int vin = 0;
        while (vin <= 0 || service.vinAlreadyExists(vin)) {
            System.out.print("Enter VIN: ");
            try {
                vin = scanner.nextInt();
                if (vin <= 0) throw new InputMismatchException();
                if (service.vinAlreadyExists(vin)) throw new DuplicateVehicleException("Vehicle with given VIN already exists.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter only whole numbers larger than zero.");
                scanner.nextLine(); // consume newline character
            } catch (DuplicateVehicleException e) {
                System.out.println("Vehicle with given VIN already exists, please enter different VIN.");
                scanner.nextLine(); // consume newline character
            }
        }
        return vin;
    }

    public static Year getManufactureYear() {
        Year carInventionYear = Year.of(1885);
        Year manufactureYear = null;
        while (manufactureYear == null || manufactureYear.isBefore(carInventionYear)) {
            System.out.print("Enter manufacture year: ");
            try {
                manufactureYear = Year.of(scanner.nextInt());
                if (manufactureYear.isBefore(carInventionYear)) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // consume newline character
            } catch (DateTimeException e) {
                System.out.println("Invalid year. Please try again.");
                scanner.nextLine(); // consume newline character
            }
        }
        return manufactureYear;
    }

    public static String getFuelType() {
        String fuelType = "";
        List<String> validFuelTypes = Arrays.asList("petrol", "diesel", "lpg");
        while (fuelType.isEmpty()) {
            System.out.print("Enter fuel type (petrol, diesel, lpg): ");
            fuelType = scanner.next().trim().toLowerCase();
            if (!validFuelTypes.contains(fuelType)) {
                System.out.println("Invalid fuel type. Please try again.");
                fuelType = "";
            }
        }
        return fuelType;
    }

    public static Double getCargoCapacity() {
        double cargoCapacity = 0.0;
        while (cargoCapacity == 0.0) {
            System.out.print("Enter cargo capacity: ");
            try {
                cargoCapacity = scanner.nextDouble();
                if (cargoCapacity <= 0.0) throw new IllegalArgumentException();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number larger than 0.");
                cargoCapacity = 0.0;
                scanner.nextLine();
            }
        }
        return cargoCapacity;
    }

    public static String getBodyStyle() {
        String bodyStyle = "";
        List<String> validBodyStyles = Arrays.asList("sedan", "coupe", "suv", "truck");
        while (bodyStyle.isEmpty()) {
            System.out.print("Enter body style (sedan, coupe, suv, truck): ");
            bodyStyle = scanner.next().trim().toLowerCase();
            if (!validBodyStyles.contains(bodyStyle)) {
                System.out.println("Invalid body style. Please try again.");
                bodyStyle = "";
            }
        }
        return bodyStyle;
    }

    public static int getDoorNumber() {
        int doorNumber = 0;
        while (doorNumber <= 0) {
            System.out.print("Enter number of doors: ");
            try {
                doorNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid number of doors. Please try again.");
                scanner.nextLine(); // consume newline character
            }
            if (doorNumber <= 0) {
                System.out.println("Number of doors must be a positive whole number. Please try again.");
            }
        }
        return doorNumber;
    }

    public static String getManufacturer() {
        System.out.print("Enter manufacturer: ");
        return scanner.next().trim();
    }

    public static String getModel() {
        System.out.print("Enter model: ");
        return scanner.next().trim();
    }

    public static String getPaint() {
        System.out.print("Enter color: ");
        return scanner.next().trim();
    }
}
