import java.util.ArrayList;
import java.util.Scanner;

public class RenterCreationManager {
    private Scanner sc;
    private ArrayList<Renter> renters;

    public RenterCreationManager(Scanner scanner, ArrayList<Renter> renters) {
        this.sc = scanner;
        this.renters = renters;
    }

    public void renterCreateAccount() {
        System.out.println("\n<****** Renter Sign up ********>");
        System.out.print("User name : ");
        String newUserName = sc.nextLine();
        System.out.print("Password : ");
        String newUserPassword = sc.nextLine();
        System.out.print("Conform password : ");
        String newUserConformPassword = sc.nextLine();
        System.out.print("Enter The Deposit Amount :");
        int newAmount = sc.nextInt();
        sc.nextLine();

        // Check If User Exist
        for (Renter renter : renters) {
            if (renter.getName().equals(newUserName)) {
                System.out.println("Account Already Exists, Login");
                // Assuming RenterLoginManager is a class
                RenterLoginManager renterLoginManager = new RenterLoginManager(sc, renters);
                renterLoginManager.renterLogin();
                return;
            }
        }

        // Check password
        if (!newUserPassword.equals(newUserConformPassword)) {
            System.out.println("\tPassword Mismatch, Try Again");
            renterCreateAccount();
            return;
        }

        // Add Renter
        renters.add(new Renter(newUserName, newUserPassword, newAmount));
        System.out.println("\tAccount Created Successfully");
        // Assuming RenterLoginManager is a class
        RenterLoginManager renterLoginManager = new RenterLoginManager(sc, renters);
        renterLoginManager.renterLogin();
    }

    // Other methods related to RenterCreationManager
}


