package com.example.codepirates_finalproject_madt3125;

public class Manager extends Employee{
    final int GAIN_FACTOR_CLIENT = 500;
    final int GAIN_FACTOR_TRAVEL = 100;
    int nbTravelDays;
    int nbClients;
    int bonus;

    public Manager(String name, int birthYear, int nbClients, int nbTravelDays, int rate) {
        this(name, birthYear,nbClients,nbTravelDays, rate, null);
    }

    public Manager(String name, int birthYear, int nbClients, int nbTravelDays, int rate, Vehicle employeeVehicle) {
        super(name, birthYear, rate, "Manager", employeeVehicle);
        this.nbClients = nbClients;
        this.nbTravelDays = nbTravelDays;
        System.out.println("We have a new employee: " + name + ", a " + getRole());
    }



    @Override
    public float getAnnualIncome() {
        bonus = GAIN_FACTOR_CLIENT * nbClients + GAIN_FACTOR_TRAVEL * nbTravelDays;
        return bonus + super.getAnnualIncome();
    }

    @Override
    public String toString() {
        String output;
        output = super.toString();
        output += "He/She travelled " + nbTravelDays + " days and has brought " + nbClients + " new clients." + "\n";
        output += "His/Her estimated annual income is " + getAnnualIncome();
        return output;
    }
}
