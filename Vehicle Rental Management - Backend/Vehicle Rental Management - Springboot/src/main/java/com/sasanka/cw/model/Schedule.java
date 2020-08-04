package com.sasanka.cw.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Schedule")
public class Schedule {
    @Id
    private String customerName;
    private String customerNIC;
    private String pickupDate;
    private String dropoffDate;
    private String vehiclePlateNo;

    public Schedule(String customerName, String customerNIC, String pickupDate, String dropoffDate, String vehiclePlateNo) {

        this.customerName = customerName;
        this.customerNIC = customerNIC;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
        this.vehiclePlateNo = vehiclePlateNo;

    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNIC() {
        return customerNIC;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC = customerNIC;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(String dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public String getVehiclePlateNo() {
        return vehiclePlateNo;
    }

    public void setVehiclePlateNo(String vehiclePlateNo) {
        this.vehiclePlateNo = vehiclePlateNo;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "customerName='" + customerName + '\'' +
                ", customerNIC='" + customerNIC + '\'' +
                ", pickupDate='" + pickupDate + '\'' +
                ", dropoffDate='" + dropoffDate + '\'' +
                ", vehiclePlateNo='" + vehiclePlateNo + '\'' +
                '}';
    }
}
