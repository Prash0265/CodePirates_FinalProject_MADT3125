package com.example.codepirates_finalproject_madt3125;

public class Vehicle {
    String plate;
    String color;
    String category;

    public Vehicle(String plate, String color, String category) {
        this.plate = plate;
        this.color = color;
        this.category = category;
    }


    public String getPlate() {
        return plate;
    }

    public String getColor() {
        return color;
    }


    public String getCategory() {
        return category;
    }


    public String toString() {
        String vehicleDescription;
        vehicleDescription = "\t - plate:" + getPlate() + "\n";
        vehicleDescription += "\t - color:" + getColor() + "\n";
        vehicleDescription += "\t - category:" + getCategory() + "\n";
        return vehicleDescription;
    }
}
