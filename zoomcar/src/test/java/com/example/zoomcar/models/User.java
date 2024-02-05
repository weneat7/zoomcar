public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    List<Vehicle> rentedVehicles;
    List<Vehicle> ownedVehicles;
}
