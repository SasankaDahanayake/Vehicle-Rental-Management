public class Motorbike extends Vehicle {

    //creating instance variables
    private String motorbikeType;
    private String transmission;
    private String cylinderCapacity;

    //Declaring Constructors
    public Motorbike(){

    }

    public Motorbike(String plateNo, String make, boolean isAvailable, int rentalPrice, String motorbikeType, String transmission, String cylinderCapacity){

       //Super used as a reference to the parent class objects.
        super(plateNo, make, isAvailable, rentalPrice);
        this.motorbikeType = motorbikeType;
        this.transmission = transmission;
        this.cylinderCapacity = cylinderCapacity;

    }

    //Getter and Setter methods
    public String getMotorbikeType(){

        return motorbikeType;

    }

    public void setMotorbikeType(String motorbikeType){

        this.motorbikeType = motorbikeType;

    }

    public String getTransmission(){

        return transmission;

    }

    public void setTransmission(String transmission){

        this.transmission = transmission;

    }

    public String getCylinderCapacity(){

        return cylinderCapacity;

    }

    public void setCylinderCapacity(String cylinderCapacity){

        this.cylinderCapacity = cylinderCapacity;

    }

    //ToString used to return the string representation of the object
    @Override
    public String toString() {
        return "Motorbike{" +
                "motorbikeType='" + motorbikeType + '\'' +
                ", transmission='" + transmission + '\'' +
                ", cylinderCapacity='" + cylinderCapacity + '\'' +
                ", plateNo='" + super.plateNo + '\'' +
                ", make='" + super.make + '\'' +
                ", isAvailable=" + super.isAvailable +
                ", rentalPrice=" + super.rentalPrice +
                '}';
    }

    public String getVehicle(){

        return "Motorbike";

    }
}
