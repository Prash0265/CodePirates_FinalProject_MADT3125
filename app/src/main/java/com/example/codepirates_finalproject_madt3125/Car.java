package com.example.codepirates_finalproject_madt3125;

public class Car extends Vehicle {
    String gear;
    String type;

    public Car(String make, String plate, String color, String category, String gear, String type) {
        super(make, plate, color, category);
        this.gear = gear;
        this.type = type;
    }

    @Override
    public String toString() {
        String vehicleDescription;
        vehicleDescription = super.toString();
        vehicleDescription += "\t - gear type:" + gear + "\n";
        vehicleDescription += "\t - type:" + type + "\n";
        return "Employee has a car: \n" + vehicleDescription;
    }

}
