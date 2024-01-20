import java.util.ArrayList;
import java.util.Scanner;

public class RenterManager {
    private Scanner sc;
    private Renter currentUser;
    private ArrayList<Renter> renters;
    private ArrayList<Vehicle> vehicles;

    public RenterManager(Scanner scanner, ArrayList<Renter> renters, ArrayList<Vehicle> vehicles) {
        this.sc = scanner;
        this.renters = renters;
        this.vehicles = vehicles;
    }

    public void renterMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("\n******** User ********");
            System.out.println("""
                            1 - Renter Login
                            2 - Create Account
                            3 - Back""");
            System.out.print("Choose your option : ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    RenterLoginManager renterLoginManager = new RenterLoginManager(sc, renters);
                    renterLoginManager.renterLogin();
                    break;
                case 2:
                    RenterCreationManager renterCreationManager = new RenterCreationManager(sc, renters);
                    renterCreationManager.renterCreateAccount();
                    break;
                case 3:
                    System.out.println("\tThank You For Visit");
                    flag = false;
                    break;
                default:
                    System.out.println("\tInvalid Input");
                    break;
            }
        }
    }


}

