import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartManager {
    private Scanner sc;
    private Renter currentUser;
    private ArrayList<Vehicle> vehicles;
    private Admin admin;

    public CartManager(Scanner scanner, Renter renter, ArrayList<Vehicle> vehicles, Admin admin) {
        this.sc = scanner;
        this.currentUser = renter;
        this.vehicles = vehicles;
        this.admin = admin;
    }

    public void manageCart() {
        boolean flag = true;
        while (flag) {
            System.out.println("\n******** Welcome To Cart ********");
            System.out.println("""
                                1.View Cart
                                2.Add To Cart
                                3.Exit""");
            System.out.print("Enter Your Choice :");
            Integer choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (!currentUser.getRentelVehicle().isEmpty())
                        viewCart();
                    else
                        System.out.println("***You Haven't Rented Any Vehicle Yet***");
                    break;
                case 2:
                    if (currentUser.getRentelVehicle().size() == 2) {
                        System.out.println("You Have Reached The Maximum Number Of Rented Vehicles");
                    } else {
                        // addToCart();
                    }
                    break;
                case 3:
                    System.out.println("\tThank You For Visit");
                    flag = false;
                    break;
                default:
                    System.out.println("\tInvalid Input");
            }
        }
    }

    private void viewCart() {
        System.out.println("*****************************************************************************************************************************");
        System.out.printf("%-8s %-24s %-22s %-26s %-23s %-23s", "S.NO", "NAME", "NUMBER", "STATUS", "BORROWED DATE", "RETURNING DATE\n");
        System.out.println("*****************************************************************************************************************************");
        for (int i = 0; i < currentUser.getRentelVehicle().size(); i++) {
            ArrayList<String> details = currentUser.getRentelVehicle().get(i);
            System.out.format("%-8s %-24s %-22s %-26s %-23s %-23s", (i + 1), details.get(0), details.get(1), details.get(2), details.get(3), details.get(4) + "\n");
            System.out.println();
        }
        System.out.println("*****************************************************************************************************************************");
        manageCart();
    }

//    private void addToCart(Vehicle vehicle) {
//        System.out.print("\n List Of Vehicle Type :\n");
//        for (int i = 0; i < vehicles.size(); i++) {
//            System.out.println("\t" + (i + 1) + ". " + vehicles.get(i).getType());
//        }
//        System.out.print("Select The Vehicle :");
//        int vehicleIndex = (sc.nextInt() - 1);
//        sc.nextLine();
//
//        if (vehicle.getType().getStatus().get(vehicleIndex).equals("AVAILABLE")) {
//            int requiredDeposit = (typ == 0) ? 10000 : 3000;
//
//            if (currentUser.getAmount() >= requiredDeposit) {
//                String borrowDate = BorrowDate();
//                currentUser.getRentelVehicle().add(new ArrayList<>(List.of(vehicles.get(category).getVehicleNames().get(vehicleIndex), vehicles.get(category).getVehicleNumbers().get(vehicleIndex), "RENTED", borrowDate, borrowDate)));
//                currentUser.getRentelHistory().add(new ArrayList<>(List.of(vehicles.get(category).getVehicleNames().get(vehicleIndex), vehicles.get(category).getVehicleNumbers().get(vehicleIndex), vehicles.get(category).getStatus().get(vehicleIndex), borrowDate, borrowDate)));
//                admin.getHistory().add(new ArrayList<>(List.of(currentUser.getName(), vehicles.get(category).getVehicleNames().get(vehicleIndex), vehicles.get(category).getVehicleNumbers().get(vehicleIndex), borrowDate, borrowDate)));
//
//                System.out.println("\t" + vehicles.get(category).getVehicleNames().get(vehicleIndex) + " Vehicle Successfully Rented");
//                vehicles.get(category).getStatus().set(vehicleIndex, "RENTED");
//                manageCart();
//            } else {
//                System.out.println("****Deposit Is Not Sufficient For Renting A Vehicle****");
//                manageCart();
//            }
//        } else {
//            System.out.println("Vehicle Is Not Available At The Moment");
//            manageCart();
//        }
//    }





}

