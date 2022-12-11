package com.example.codepirates_finalproject_madt3125;

public class Car extends Vehicle {
    String type;

    public Car(String plate, String color, String category, String type) {
        super(plate, color, category);
        this.type = type;
    }

    @Override
    public String toString() {
        String vehicleDescription;
        vehicleDescription = super.toString();
        vehicleDescription += "\t - type:" + type + "\n";
        return "Employee has a car: \n" + vehicleDescription;
    }

}
