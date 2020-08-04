package com.sasanka.cw.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Car")
public class Car {
    @Id
    String id;
    String plateNo;
    String make;
    boolean isAvailable;
    int rentalPrice;
    String carType;
    int numberOfSeats;
    String carTransmission;
    boolean driverIncluded;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getCarTransmission() {
        return carTransmission;
    }

    public void setCarTransmission(String carTransmission) {
        this.carTransmission = carTransmission;
    }

    public boolean isDriverIncluded() {
        return driverIncluded;
    }

    public void setDriverIncluded(boolean driverIncluded) {
        this.driverIncluded = driverIncluded;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", make='" + make + '\'' +
                ", isAvailable=" + isAvailable +
                ", rentalPrice=" + rentalPrice +
                ", carType='" + carType + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", carTransmission='" + carTransmission + '\'' +
                ", driverIncluded=" + driverIncluded +
                '}';
    }
}

