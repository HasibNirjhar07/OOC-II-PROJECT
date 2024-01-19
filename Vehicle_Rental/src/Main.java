import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean currentUser;

    public static void main(String[] args) {

        ArrayList<Renter> renters = new ArrayList<>(List.of(
                new Renter("A", "1111", 30000),
                new Renter("B", "2222", 30000)
        ));

        ArrayList<Vehicle> vehicles = new ArrayList<>(List.of(
                new Vehicle("Car", new ArrayList<>(List.of("BMW", "AUDI")), new ArrayList<>(List.of("TN37", "TN78")), new ArrayList<>(List.of("AVAILABLE", "RENTED"))),
                new Vehicle("Bike", new ArrayList<>(List.of("YAMAHA", "TVS")), new ArrayList<>(List.of("TN66", "TN55")), new ArrayList<>(List.of("RENTED", "AVAILABLE")))
        ));

        Scanner scanner = new Scanner(System.in);

        HomeMenu homeMenu = new HomeMenu(scanner, renters, vehicles);
        homeMenu.displayMenu();

        scanner.close();
    }
}
