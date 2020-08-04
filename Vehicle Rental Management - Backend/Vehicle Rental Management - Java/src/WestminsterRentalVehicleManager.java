
import com.mongodb.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterRentalVehicleManager implements VehicleRentalManager{

    //Setting up the MongoDB Database connection
    MongoClient mongoClient = new MongoClient("localhost",27017);

    //Assigning MongoDB Database Name
    DB dbs = mongoClient.getDB("VehicleRental");

    //Creating two MongoDB Database collections, one to store documents of a car and the other to store documents of a bike.
    DBCollection car = dbs.getCollection("Car");
    DBCollection bike = dbs.getCollection("Bike");


//Array used to store the values of the vehicles and lotNumber used to record the amount of vehicles storing in the parking lot.
    private ArrayList<Vehicle> vehicleList;
    private int lotNumber;

    //This method is used to define the maximum amount of vehicles to be stored in the parking lot.
    public WestminsterRentalVehicleManager(int lotSpace){

        this.lotNumber = lotSpace;
        vehicleList = new ArrayList<Vehicle>();

    }

    //Function to add vehicle into the arrayList and the MongoDB Database
    public void addVehicle(Vehicle vehicle) {
        //Two collections available, one for the car documents and the other for bike documents
        DBCollection car = dbs.getCollection("Car");
        DBCollection bike = dbs.getCollection("Bike");

        //BasicDatabase Object created to reference a collection
        BasicDBObject vehicleObject = new BasicDBObject();

        //An 'if' condition used to only accept a vehicle if there's available space in a parking lot
        if(vehicleList.size()<lotNumber){

            //InstanceOf is used as the object is an instance of the specific class
            if(vehicle instanceof Car){

                //vehicleObject is the BasicDB Object, .put is used to enter the values with the column name and value. This is used for the car.
                vehicleObject.put("plateNo", vehicle.getPlateNo());
                vehicleObject.put("make", vehicle.getMake());
                vehicleObject.put("isAvailable", vehicle.isAvailable());
                vehicleObject.put("rentalPrice", vehicle.getRentalPrice());
                vehicleObject.put("carType", ((Car) vehicle).getCarType());
                vehicleObject.put("numberOfSeats", ((Car) vehicle).getNumberSeats());
                vehicleObject.put("carTransmission", ((Car) vehicle).getTransmission());
                vehicleObject.put("driverIncluded", ((Car) vehicle).isDriverIncluded());
                car.insert(vehicleObject);

            }

                //This instanceOf is used for the bike.
            if(vehicle instanceof Motorbike){

                vehicleObject.put("plateNo", vehicle.getPlateNo());
                vehicleObject.put("make", vehicle.getMake());
                vehicleObject.put("isAvailable", vehicle.isAvailable());
                vehicleObject.put("rentalPrice", vehicle.getRentalPrice());
                vehicleObject.put("motorbikeType", ((Motorbike) vehicle).getMotorbikeType());
                vehicleObject.put("transmission", ((Motorbike) vehicle).getTransmission());
                vehicleObject.put("cylinderCapacity", ((Motorbike) vehicle).getCylinderCapacity()) ;
                bike.insert(vehicleObject);

            }

            //This command is used to add the vehicles into the array.
            vehicleList.add(vehicle);
            System.out.println("Vehicle has been registered into the parking lot.");

        }else{

            System.out.println("There are no parking lots available.");

        }

    }
    //Function to delete vehicle from the MongoDB Database and the array list.
    public void deleteVehicle() {

        //Prompting the user to enter either '1' or '2' in order to execute the switch case.
        System.out.println("Press '1' to delete a car, press '2' to delete a bike.");
        Scanner sc10 = new Scanner(System.in);

        //This particular block of code is used for the validation, verifying user's input being either '1' or '2' and that it being an integer value.
        int vehicle;
        while(true){
            try {
                do {
                    vehicle = sc10.nextInt();
                    if (vehicle > 3 && vehicle < 0) {
                        System.out.println("Entered value is incorrect, please try again.");
                    }
                } while (vehicle > 3 && vehicle < 0);
                break;
            }catch(Exception e){
                System.out.println("Entered value is incorrect, type in the number for the option.");
                sc10.next();
            }
        }

        //Executing the switch case.
        switch (vehicle) {
            //Case 1 is run if '1' was inputted by the user, executing the deletion option for the car.
            case 1:

                System.out.println("Enter the plate number of the car you wish to delete.");
                Scanner sc1 = new Scanner(System.in);
                String deleteCarPlate = sc1.nextLine();
                BasicDBObject deleteCar = new BasicDBObject("plateNo", deleteCarPlate);
                car.remove(deleteCar);
                break;
            //Case 2 is run if '2' was inputted by the user, executing the deletion option for the bike.
            case 2:

                System.out.println("Enter the plate number of the bike you wish to delete.");
                Scanner sc2 = new Scanner(System.in);
                String deleteBikePlate = sc2.nextLine();
                BasicDBObject deleteBike = new BasicDBObject("plateNo", deleteBikePlate);
                bike.remove(deleteBike);

        }
    }

    //This function is used to print the vehicles, applicable for both car and bike. Also prints the MongoDB collection documents.
    public void printVehicles() {
        //Cursor used to collect the documents of the car.
        DBCursor cursor = car.find();
        while(cursor.hasNext()){

            System.out.println(cursor.next());

        }
        //Cursor1 used to collect the documents of the bike.
        DBCursor cursor1 = bike.find();
        while(cursor1.hasNext()){
            //Printing all the documents from both car and bike.
            System.out.println(cursor1.next());

        }
        //For-loop used to collect the vehicle information from the array, cars and bikes are collected individually.
        for (int i = 0; i < vehicleList.size(); i++) {
            //If-condition used to verify information on the array if they are available on both car and bike.
            if (vehicleList.get(i).getVehicle().equals("Car")) {

                System.out.println("Vehicle is a Car, " + "Plate number is " + vehicleList.get(i).getPlateNo() + ", " + "Make is " + vehicleList.get(i).getMake() + ", " + "Rental Price is " + vehicleList.get(i).getRentalPrice());

            } else if (vehicleList.get(i).getVehicle().equals("Motorbike")) {

                System.out.println("Vehicle is a Motorbike, " + "Plate number is " + vehicleList.get(i).getPlateNo() + ", " + "Make is " + vehicleList.get(i).getMake() + ", " + "Rental Price is " + vehicleList.get(i).getRentalPrice());

            } else {

                System.out.println("No vehicles are added.");

            }
        }
    }

    //Save details function used to save the MongoDB Database information into a text file.
    public void saveDetails() {

        System.out.println("What details do you wish to save? Press '1' for car, press '2' for bike.");
        Scanner sc = new Scanner(System.in);
        //Validation executed to validate user's input being either '1' or '2' and that it is an integer value.
        int saveVehicle;
        while(true){
            try {
                do {
                    saveVehicle = sc.nextInt();
                    if (saveVehicle > 3 && saveVehicle < 0) {
                        System.out.println("Entered value is incorrect, please try again.");
                    }
                } while (saveVehicle > 3 && saveVehicle < 0);
                break;
            }catch(Exception e){
                System.out.println("Entered value is incorrect, type in a number of the option.");
                sc.next();
            }
        }

        //Switch-case is used to divide functionalities of car and bike, '1' to save details of the car and '2' to save details of the bike.
        switch(saveVehicle) {
            //Case 1 is for the execution of car files to be saved.
            case 1:
                DBCursor cursor = car.find();
                FileWriter carSave = null;
                try {
                    //File is being created, Car.txt. This shouldn't append as the file should be over-written whenever the code is executed.
                    carSave = new FileWriter("Car.txt", false);
                    //Command used to execute the string value of cursor after documents from the collection is called.
                    String fileString = String.valueOf(cursor.next());
                    carSave.write(fileString);
                    carSave.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;

                //Case 2 is for the execution of bike files to be saved.
            case 2:
                DBCursor cursor1 = bike.find();
                FileWriter bikeSave = null;

                try{
                    bikeSave = new FileWriter("Bike.txt", false);
                    String fileString = String.valueOf(cursor1.next());
                    bikeSave.write(fileString);
                    bikeSave.close();

                } catch (IOException e){
                    e.printStackTrace();
                }

                break;
        }
    }
    //Method used to exit the system.
    public void exit() {
        System.exit(0);
    }

    //Execute method is used to execute the code
    public boolean execute() {
        //boolean exit is used for the looping after each and every execution of the feature.
        boolean exit = false;

        //Certain value could be prompted by the manager to execute which feature they want to use
        System.out.println("To add a new vehicle, press '1'.");
        System.out.println("To delete a vehicle, press '2'");
        System.out.println("To display the available vehicles, press '3'.");
        System.out.println("To save your file, press '4'.");
        System.out.println("To exit your file, press '5'");

        Scanner sc = new Scanner(System.in);
        //Validation used to validate the values entered and to verify if they are string integers.
        int selection;
        while(true){
        try {
            do {
                selection = sc.nextInt();
                if (selection > 6 && selection < 0) {
                    System.out.println("Entered value is incorrect, please try again.");
                }
            } while (selection > 6 && selection < 0);
            break;
        }catch(Exception e){
            System.out.println("Entered value is incorrect, type in a number of the option.");
            sc.next();
            }
        }
        //switch-case used to divide the features according to the cases inputted by the user.
        switch (selection) {

            case 1:
                Scanner sc15 = new Scanner(System.in);
                System.out.println("To add a new Car, press '1'.");
                System.out.println("To add a new Motorbike, press '2'");

                //Validating the user input to make sure they entered a digit or it being either '1' or '2'
                int selection2;
                while(true){
                    try {
                        do {
                            selection2 = sc15.nextInt();
                            if (selection2 > 3 && selection2 < 0) {
                                System.out.println("Entered value is incorrect, please try again.");
                            }
                        } while (selection2 > 3 && selection2 < 0);
                        break;
                    }catch(Exception e){
                        System.out.println("Entered value is incorrect, type in a number of the option.");
                        sc15.next();
                    }
                }

                //Prompting the manager to enter the mutual details of the vehicle
                Scanner sc1 = new Scanner(System.in);
                System.out.println("What is the plate number?");
                String plateNo = sc1.nextLine();

                Scanner sc2 = new Scanner(System.in);
                System.out.println("What is the make?");
                String make = sc2.nextLine();

                //Prompts user for the input through a boolean, whether the answer is 'y' or 'n'.
                Scanner sc3 = new Scanner(System.in);
                System.out.println("Is the vehicle available?");
                String available = sc3.nextLine();

                boolean isAvailable = false;

                if (available.equals("y")) {

                    isAvailable = true;

                } else if (available.equals("n")) {

                    isAvailable = false;

                } else {

                    System.out.println("Please press 'y' or 'n' if the car is available or not.");

                }

                Scanner sc4 = new Scanner(System.in);
                System.out.println("What is the rental price?");
                int rentalPrice;
                //validating rental price of the vehicle, whether the user prompted '1' or '2'.
                while(true){
                    try {
                        do {
                            rentalPrice = sc4.nextInt();
                            if (rentalPrice > 3 && rentalPrice < 0) {
                                System.out.println("Entered value is incorrect, please try again.");
                            }
                        } while (rentalPrice > 3 && rentalPrice < 0);
                        break;
                    }catch(Exception e){
                        System.out.println("Entered value is incorrect, type in a number of the option.");
                        sc4.next();
                    }
                }
                //Switch-case here used to divide the car and the motorbike, and each of their attributes
                switch (selection2) {

                    case 1:

                        System.out.println("You've chosen to add a car.");
                        System.out.println("What is the car type?");
                        Scanner sc8 = new Scanner(System.in);
                        String carType = sc8.nextLine();

                       Scanner sc14 = new Scanner(System.in);
                        System.out.println("Enter the number of seats.");
                        int numberSeats;
                        while(true){
                            try {
                                do {
                                    numberSeats = sc14.nextInt();
                                    if (numberSeats > 3 && numberSeats < 0) {
                                        System.out.println("Entered value is incorrect, please try again.");
                                    }
                                } while (numberSeats > 3 && numberSeats < 0);
                                break;
                            }catch(Exception e){
                                System.out.println("Entered value is incorrect, type in a number of the option.");
                                sc14.next();
                            }
                        }

                        Scanner sc9 = new Scanner(System.in);
                        System.out.println("What is the transmission type of the car?");
                        String transmission = sc9.nextLine();

                        Scanner sc7 = new Scanner(System.in);

                        System.out.println("Is the driver included for this car? (y/n)");
                        String driver = sc7.nextLine();

                        boolean driverIncluded = false;

                        if (driver.equals("y")) {

                            driverIncluded = true;

                        } else if (driver.equals("n")) {

                            driverIncluded = false;

                        } else {

                            System.out.println("Please press 'y' or 'n', whether driver is included or not.");

                        }

                        Car car1 = new Car(plateNo, make, isAvailable, rentalPrice, carType, numberSeats, transmission, driverIncluded);

                        addVehicle(car1);
                        break;

                    case 2:

                        Scanner sc16=new Scanner(System.in);
                        System.out.println("You've chosen to add a bike.");
                        System.out.println("What is the Motorbike type?");
                        String bikeType = sc16.nextLine();

                        Scanner sc17 = new Scanner(System.in);
                        System.out.println("What is the transmission?");
                        String bikeTransmission = sc17.nextLine();

                        Scanner sc18 = new Scanner(System.in);
                        System.out.println("What is the cylinder capacity?");
                        String cylinderCapacity = sc18.nextLine();

                        Motorbike bike1 = new Motorbike(plateNo, make, isAvailable, rentalPrice, bikeType, bikeTransmission, cylinderCapacity);
                        this.addVehicle(bike1);
                        break;
                }

                break;
            //case here used to call the delete vehicle from the database through the method
            case 2:

                    deleteVehicle();
                    break;
            //case here used to print the vehicles on the database through the method
            case 3:

                this.printVehicles();
                break;
            //case here used to save the vehicles into a file from the database through the method
            case 4:

                this.saveDetails();
                break;
            //case here used to exit the program
            case 5:

                this.exit();
                break;
        }

        return exit;

    }
    //main method
    public static void main(String[] args){

        VehicleRentalManager sys = new WestminsterRentalVehicleManager(50);
        boolean exit = false;

        while(!exit){

            exit = sys.execute();

        }

    }
}