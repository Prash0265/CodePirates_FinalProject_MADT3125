package com.example.codepirates_finalproject_madt3125;

public interface Contract {
    float getFinalAmount();
}

class Permanent implements Contract {
    int nbChildren;
    boolean married;
    int monthlySalary;
    int bonusPerChildPerMonth;
    int accumulatedDays;

    public int getNbChildren() {
        return nbChildren;
    }


    public boolean isMarried() {
        return married;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public int getAccumulatedDays() {
        return accumulatedDays;
    }

    Permanent(int nbChildren, boolean married, int monthlySalary, int bonusPerChildPerMonth, int accumulatedDays) {
        this.nbChildren = nbChildren;
        this.married = married;
        this.monthlySalary = monthlySalary;
        this.bonusPerChildPerMonth = bonusPerChildPerMonth;
        this.accumulatedDays = accumulatedDays;
    }

    public float getFinalAmount() {
        int finalAmount = monthlySalary;
        if (isMarried()) {
            finalAmount += (nbChildren * bonusPerChildPerMonth);
        }
        return finalAmount * accumulatedDays / 20f;
    }

    @Override
    public String toString() {
        String output;
        output = ". he/she is Married" + " and he/she has " + getNbChildren() + " children.\nHe/She has worked for " + getAccumulatedDays() + " days and upon contract his/her monthly salary is " + getMonthlySalary();
        return output;
    }

}

class Temporary implements Contract {
    int hourlySalary;
    int accumulatedHours;

    public int getHourlySalary() {
        return hourlySalary;
    }

    public int getAccumulatedHours() {
        return accumulatedHours;
    }

    Temporary(int hourlySalary, int accumulatedHours) {
        this.hourlySalary = hourlySalary;
        this.accumulatedHours = accumulatedHours;
    }

    public float getFinalAmount() {
        int finalAmount;
        finalAmount = hourlySalary * accumulatedHours;
        return finalAmount;
    }

    @Override
    public String toString() {
        String output;
        output = ". he/she is temporary employee with " + getHourlySalary() + "\nhourly salary and he has worked for " + getAccumulatedHours() + " hours";
        return output;
    }


}
