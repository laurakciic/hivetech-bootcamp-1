package com.laurakovacic.task6;

import com.laurakovacic.task6.customExceptions.InsufficientArgumentException;

public class Employee {
    private String firstName;
    private String lastName;
    private int hourlyRate;
    private int hoursWorked;
    private int salary;

    public Employee(String firstName, String lastName, int hourlyRate, int hoursWorked) throws InsufficientArgumentException {
        this.firstName = firstName;
        this.lastName = lastName;

        /**
         * before calculating the salary, check for an invalid input of arguments
         */
        if (hourlyRate < 1 || hoursWorked < 1) {
            throw new InsufficientArgumentException("Hourly rate and/or hours worked cannot be smaller than 1.");
        } else {
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
            this.salary = setSalary();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getSalary() {
        return salary;
    }

    public int setSalary() {
        return this.salary = this.hourlyRate * this.hoursWorked;
    }
}
