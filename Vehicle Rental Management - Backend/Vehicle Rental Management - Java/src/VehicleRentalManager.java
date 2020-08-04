import com.mongodb.DBCollection;

public interface VehicleRentalManager {

    //Methods used to specify the behavior/functions used to specify the vehicle.
    public abstract void addVehicle(Vehicle vehicle);
    public abstract void deleteVehicle();
    public abstract void printVehicles();
    public abstract void saveDetails();
    void exit();
    public abstract boolean execute();

}
