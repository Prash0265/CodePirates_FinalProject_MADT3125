package com.example.codepirates_finalproject_madt3125;

import java.util.Calendar;

public class Employee {
    private final String name;
    private final int birthYear;
    private final int rate;
    private final String role;
    Vehicle employeeVehicle;
    Contract employeeContract;
    static int maxRate;
    static int minRate;

    static {
        maxRate = 100;
        minRate = 10;
    }

    public Employee(String name, int birthYear, int rate, String role) {
        this.name = name;
        this.birthYear = birthYear;
        if (rate > maxRate) {
            this.rate = maxRate;
        } else this.rate = Math.max(rate, minRate);
        this.role = role;
    }


    public Employee(String name, int birthYear, int rate, String role, Vehicle employeeVehicle) {
        this(name, birthYear, rate, role);
        this.employeeVehicle = employeeVehicle;
    }

    public String getName() {
        return name;
    }


    public int getRate() {
        return rate;
    }


    public String getRole() {
        return role;
    }

    public int employeeAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int age;
        age = currentYear - birthYear;
        return age;
    }

    public float getMonthlySalary() {
        float monthlySalary = 0;
        if (employeeContract != null) {
            monthlySalary = employeeContract.getFinalAmount();
        }
        monthlySalary *= getRate() / 100f;
        return monthlySalary;
    }

    public float getAnnualIncome() {
        return getMonthlySalary() * 12;
    }


    public void signContract(Contract employeeContract) {
        this.employeeContract = employeeContract;
    }


    public String contractInfo() {
        return getName() + " is a " + getRole();
    }

    public String toString() {
        String output;
        output = "Name: " + getName() + "\n";
        output += "Age: " + employeeAge() + "\n";
        output += employeeVehicle.toString();
        output += getName() + " has an Occupation rate: " + getRate() + "%. ";
        return output;
    }
}
