import java.util.ArrayList;
import java.util.Scanner;

public class HomeMenu {
    private Scanner sc;
    private ArrayList<Renter> renters;
    private ArrayList<Vehicle> vehicles;

    public HomeMenu(Scanner scanner, ArrayList<Renter> renters, ArrayList<Vehicle> vehicles) {
        this.sc = scanner;
        this.renters = renters;
        this.vehicles = vehicles;
    }

    public void displayMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("\n********************** Welcome To Rental Web ***************************");
            System.out.println("""
                    1.Administrator
                    2.Borrower
                    3.Exit""");
            System.out.print("Choose Your Option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    AdminAuthentication adminAuthentication = new AdminAuthentication(sc);
                    adminAuthentication.authenticateAdmin();
                    break;
                case 2:
                    // Call method for Borrower functionality
                    break;
                case 3:
                    flag = false;
                    System.out.println("\tThank You For Visit");
                    break;
                default:
                    System.out.println("\tInvalid Input");
            }
        }
    }
}
