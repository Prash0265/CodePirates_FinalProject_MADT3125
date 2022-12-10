package com.example.codepirates_finalproject_madt3125;

public class Motorcycle extends Vehicle {
    Boolean sidecar;

    public Motorcycle(String make, String plate, String color, String category, Boolean sidecar) {
        super(make, plate, color, category);
        this.sidecar = sidecar;
    }


    @Override
    public String toString() {
        String vehicleDescription;
        vehicleDescription = super.toString();
        if (sidecar) {
            vehicleDescription += "\t - with sidecar\n";
        } else vehicleDescription += "\t - without sidecar\n";
        return "Employee has a Motorcycle: \n" + vehicleDescription;
    }
}
