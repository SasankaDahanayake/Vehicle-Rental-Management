package com.sasanka.cw.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Bike")
public class Motorbike {

    @Id
    String id;
    String plateNo;
    String make;
    boolean isAvailable;
    int rentalPrice;
    String motorbikeType;
    String transmission;
    String cylinderCapacity;

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

    public String getMotorbikeType() {
        return motorbikeType;
    }

    public void setMotorbikeType(String motorbikeType) {
        this.motorbikeType = motorbikeType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(String cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id='" + id + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", make='" + make + '\'' +
                ", isAvailable=" + isAvailable +
                ", rentalPrice=" + rentalPrice +
                ", motorbikeType='" + motorbikeType + '\'' +
                ", transmission='" + transmission + '\'' +
                ", cylinderCapacity='" + cylinderCapacity + '\'' +
                '}';
    }
}
