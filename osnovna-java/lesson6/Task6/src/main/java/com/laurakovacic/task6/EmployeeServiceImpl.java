package com.laurakovacic.task6;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;


public class EmployeeServiceImpl implements EmployeeService {

    Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class.getName());
    Set<Employee> employees = new HashSet<>();

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);

        LOGGER.info("Successfully added employee: "
                + employee.getFirstName()
                + " "
                + employee.getLastName()
                + ", salary: "
                + employee.getSalary());
    }

    @Override
    public void listAllEmployees() {
        System.out.println("Employees:");
        int i = 1;
        for(Employee employee: employees) {
            System.out.println(i + ". " + employee.getFirstName() + " " + employee.getLastName() + ", salary: " + employee.getSalary());
            i++;
        }
        System.out.println();
    }
}
