package com.example.codepirates_finalproject_madt3125;

public class Manager extends Employee {
    final int GAIN_FACTOR_CLIENT = 500;
    final int GAIN_FACTOR_TRAVEL = 100;
    int nbClients;
    int bonus;

    public Manager(String name, int birthYear, int nbClients, int rate) {
        this(name, birthYear, nbClients, rate, null);
    }

    public Manager(String name, int birthYear, int nbClients, int rate, Vehicle employeeVehicle) {
        super(name, birthYear, rate, "Manager", employeeVehicle);
        this.nbClients = nbClients;
        System.out.println("We have a new employee: " + name + ", a " + getRole());
    }



    @Override
    public float getAnnualIncome() {
        bonus = GAIN_FACTOR_CLIENT * nbClients;
        return bonus + super.getAnnualIncome();
    }

    @Override
    public String toString() {
        String output;
        output = super.toString();
        output += "He/She has brought " + nbClients + " new clients." + "\n";
        output += "His/Her estimated annual income is " + getAnnualIncome();
        return output;
    }
}
