import java.util.ArrayList;
import java.util.Scanner;

public class Renter implements RenterInterface {
    public static Renter currentUser;
    private String name;
    private String password;
    private int amount;
    private ArrayList<ArrayList<String>> rentelVehicle;
    private ArrayList<ArrayList<String>> rentelHistory;


    Scanner sc = new Scanner(System.in);

    public Renter(String name, String password, int amount) {
        this.name = name;
        this.password = password;
        this.amount = amount;
        this.rentelVehicle = new ArrayList<>();
        this.rentelHistory = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAmount() {
        return amount;
    }

    public ArrayList<ArrayList<String>> getRentelVehicle() {
        return rentelVehicle;
    }

    public ArrayList<ArrayList<String>> getRentelHistory() {
        return rentelHistory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setRentelVehicle(ArrayList<ArrayList<String>> rentelVehicle) {
        this.rentelVehicle = rentelVehicle;
    }

    // Other methods for Renter functionality

//    public void Borrower() {
//        boolean flag = true;
//        while (flag) {
//            System.out.println("\n******** User ********");
//            System.out.println("""
//                                1 - Renter Login
//                                2 - Create Account
//                                3 - Back""");
//            System.out.print("Choose your option : ");
//            Integer option = sc.nextInt();
//            sc.nextLine();
//
//            switch (option) {
//                case 1:
//
//                    RenterLoginManager renterLoginManager = new RenterLoginManager(sc, renters, vehicles);
//
//                    renterLoginManager.renterLogin();
//                    break;
//                case 2:
//                   RenterCreationManager renterCreationManager = new RenterCreationManager(sc);
//                   renterCreationManager.renterCreateAccount();
//                    break;
//                case 3:
//                    System.out.println("\tThank You For Visit");
//                    flag = false;
//                    HomeMenu homeMenu = new HomeMenu(sc, renters, vehicles);
//                    homeMenu.displayMenu();
//                    break;
//                default:
//                    System.out.println("\tInvalid Input");
//                    Borrower();
//                    break;
//            }
//        }
//    }


}
