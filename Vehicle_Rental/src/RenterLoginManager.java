

import java.util.ArrayList;
import java.util.Scanner;

public class RenterLoginManager {
    private Scanner sc;
    Renter currentUser;
    private ArrayList<Renter> renters;

    public RenterLoginManager(Scanner scanner, ArrayList<Renter> renters) {
        this.sc = scanner;
        this.renters = renters;
    }

    public void renterLogin() {
        System.out.println("\n******* Renter Login *********");
        System.out.print("Renter name : ");
        String userName = sc.nextLine();

        // Check If User Exist Or Not
        for (Renter renter : renters) {
            if (renter.getName().equals(userName)) {
                System.out.print("Password : ");
                String password = sc.nextLine();
                if (renter.getPassword().equals(password))
                    Renter.currentUser = renter;
                else {
                    System.out.println("\tWrong Password");
                    renterLogin();
                    break;
                }
            }
        }

        if (!Main.currentUser) {
            System.out.println("\tYou don't have an account, please Sign up");
           RenterCreationManager renterCreationManager = new RenterCreationManager(sc, renters);
              renterCreationManager.renterCreateAccount();
            // Main.Renter_CreateAccount();
            return;
        }

        // Assuming Renter_Choice is a method in the Main class
        // Main.Renter_Choice();
    }

    // Other methods related to RenterLoginManager
}
