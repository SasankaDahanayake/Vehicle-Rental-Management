public class Car extends Vehicle {

    //creating instance variables
    private String carType;
    private int numberSeats;
    private String transmission;
    private boolean driverIncluded;

    //constructors
    public Car(){

    }

    public Car(String plateNo, String make, boolean isAvailable, int rentalPrice, String carType, int numberSeats, String transmission, boolean driverIncluded){

        //super used as a reference to the superclass objects.
        super(plateNo, make, isAvailable, rentalPrice);
        this.carType = carType;
        this.numberSeats = numberSeats;
        this.transmission = transmission;
        this.driverIncluded = driverIncluded;

    }

    //Getter and setter methods
    public String getCarType(){

        return carType;

    }

    public void setCarType(String carType){

        this.carType = carType;

    }

    public int getNumberSeats(){

        return numberSeats;

    }

    public void setNumberSeats(int numberSeats){

        this.numberSeats = numberSeats;

    }

    public String getTransmission(){

        return transmission;

    }

    public void setTransmission(String transmission){

        this.transmission = transmission;

    }

    public boolean isDriverIncluded(){

        return driverIncluded;

    }

    public void setDriverIncluded(boolean driverIncluded){

        this.driverIncluded = driverIncluded;

    }

    //ToString used to return the string representation of the object
    @Override
    public String toString() {
        return "Car{" +
                "carType='" + carType + '\'' +
                ", numberSeats=" + numberSeats +
                ", transmission='" + transmission + '\'' +
                ", driverIncluded=" + driverIncluded +
                ", plateNo='" + super.plateNo + '\'' +
                ", make='" + super.make + '\'' +
                ", isAvailable=" + super.isAvailable +
                ", rentalPrice=" + super.rentalPrice +
                '}';
    }

    public String getVehicle(){

        return "Car";
    }
}

