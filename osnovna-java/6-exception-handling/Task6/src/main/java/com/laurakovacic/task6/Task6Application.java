package com.laurakovacic.task6;

import com.laurakovacic.task6.customExceptions.InsufficientArgumentException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@SpringBootApplication
public class Task6Application {

    public static void main(String[] args) {

        EmployeeServiceImpl service  = new EmployeeServiceImpl();
        Logger LOGGER = Logger.getLogger(Task6Application.class.getName());

        try {
            FileHandler fileHandler = new FileHandler("log.txt");
            LOGGER.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            LOGGER.info("Successfully created log file.");
        } catch (IOException e) {
            LOGGER.warning("Log file could not be created: " + e.getMessage());
        }

        try {
            service.addEmployee(new Employee("Dario", "Zinic", 33, 0));
        } catch (InsufficientArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            LOGGER.severe(e.getMessage());

            try {
                service.addEmployee(new Employee("Marko", "Markic", 33, 40));
                service.addEmployee(new Employee("Luka", "Roncevic", 45, 100));
                service.listAllEmployees();

            } catch (InsufficientArgumentException exc) {
                System.out.println("Error: " + exc.getMessage());
                LOGGER.severe(exc.getMessage());
            }
        }
    }
}
