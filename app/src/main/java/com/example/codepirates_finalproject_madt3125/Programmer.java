package com.example.codepirates_finalproject_madt3125;

public class Programmer extends Employee {
    final int GAIN_FACTOR_ERROR = 200;
    int nbProjects;
    int bonus;

    public Programmer(String name, int birthYear, int nbProjects, int rate) {
        this(name, birthYear, nbProjects, rate, null);
    }

    public Programmer(String name, int birthYear, int nbProjects, int rate, Vehicle employeeVehicle) {
        super(name, birthYear, rate, "Programmer", employeeVehicle);
        this.nbProjects = nbProjects;
        System.out.println("We have a new employee: " + name + ", a " + getRole());

    }

    @Override
    public float getAnnualIncome() {
        bonus = GAIN_FACTOR_ERROR * nbProjects;
        return bonus + super.getAnnualIncome();
    }

    @Override
    public String toString() {
        String output;
        output = super.toString();
        output += "and completed " + nbProjects + " projects." + "\n";
        output += "His/Her estimated annual income is " + getAnnualIncome();
        return output;
    }
}
