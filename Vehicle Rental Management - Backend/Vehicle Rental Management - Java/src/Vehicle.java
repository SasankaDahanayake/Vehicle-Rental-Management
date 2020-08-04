//Parent abstract class
abstract class Vehicle {
    //Creating instance variables
    protected String plateNo;
    protected String make;
    protected boolean isAvailable;
    protected int rentalPrice;

    //Constructors
    public Vehicle(){


    }

    public Vehicle(String plateNo, String make, boolean isAvailable, int rentalPrice){

        this.plateNo = plateNo;
        this.make = make;
        this.isAvailable = isAvailable;
        this.rentalPrice = rentalPrice;

    }

    //Getter and Setter methods
    public String getPlateNo(){

        return plateNo;

    }

    public void setPlateNo(String plateNo){

        this.plateNo = plateNo;

    }

    public String getMake(){

        return make;

    }

    public void setMake(String make){

        this.make = make;

    }

    public boolean isAvailable(){

        return isAvailable;

    }

    public void setAvailable(boolean isAvailable){

        this.isAvailable = isAvailable;

    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    //ToString used to return the string representation of the object
    @Override
    public String toString() {

        return "Vehicle{" +
                "plateNo='" + plateNo + '\'' +
                ", make='" + make + '\'' +
                ", isAvailable=" + isAvailable +
                ", rentalPrice=" + rentalPrice +
                '}';
    }

    public abstract String getVehicle();
}
