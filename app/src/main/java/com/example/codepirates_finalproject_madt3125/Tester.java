package com.example.codepirates_finalproject_madt3125;

public class Tester extends Employee {
    final int GAIN_FACTOR_ERROR = 10;
    int nbBugs;
    int bonus;

    public Tester(String name, int birthYear, int nbBugs, int rate) {
        this(name, birthYear, nbBugs, rate, null);
    }

    public Tester(String name, int birthYear, int nbBugs, int rate, Vehicle employeeVehicle) {
        super(name, birthYear, rate, "Tester", employeeVehicle);
        this.nbBugs = nbBugs;
        System.out.println("We have a new employee: " + name + ", a " + getRole());
    }


    @Override
    public float getAnnualIncome() {
        bonus = GAIN_FACTOR_ERROR * nbBugs;
        return bonus + super.getAnnualIncome();
    }


    @Override
    public String toString() {
        String output;
        output = super.toString();
        output += "and corrected " + nbBugs + " bugs." + "\n";
        output += "His/Her estimated annual income is " + getAnnualIncome();
        return output;
    }
}