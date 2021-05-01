package com.scaler.backend.model.vehicle;

public abstract class Vehicle {
    private String plateNumber;
    private String color;
    private final VehicleType type;

    public Vehicle(VehicleType type) {
        this.type = type;
    }
}
