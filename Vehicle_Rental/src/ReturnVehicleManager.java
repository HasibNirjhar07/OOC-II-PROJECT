import java.util.ArrayList;
import java.util.Scanner;

public class ReturnVehicleManager {
    private Scanner sc;
    private Renter currentUser;
    private ArrayList<Vehicle> vehicles;

    public ReturnVehicleManager(Scanner scanner, Renter renter, ArrayList<Vehicle> vehicles) {
        this.sc = scanner;
        this.currentUser = renter;
        this.vehicles = vehicles;
    }

    public void returnVehicle() {
        if (currentUser.getRentelVehicle().isEmpty()) {
            System.out.println("You Don't Have Any Rented Vehicles");
            // Handle the return or navigate to the appropriate place
        } else {
            System.out.println("*****************************************************************************************************************************");
            System.out.printf("%-8s %-24s %-22s %-26s %-23s %-23s", "S.NO", "NAME", "NUMBER", "STATUS", "BORROWED DATE", "RETURNING DATE\n");
            System.out.println("*****************************************************************************************************************************");
            for (int i = 0; i < currentUser.getRentelVehicle().size(); i++) {
                ArrayList<String> details = currentUser.getRentelVehicle().get(i);
                System.out.format("%-8s %-24s %-22s %-26s %-23s %-23s", (i + 1), details.get(0), details.get(1), details.get(2), details.get(3), details.get(4) + "\n");
                System.out.println();
            }
            System.out.println("*****************************************************************************************************************************");

            System.out.print("Choose The Returning Vehicle :");
            int returningIndex = (sc.nextInt() - 1);
            System.out.print("Enter The Kms Of The Vehicle Used :");
            int kms = sc.nextInt();
            sc.nextLine();

            System.out.print("Is There Any Damage :");
            String damage = sc.nextLine();

            // Process return, calculate rent, and update status
            processReturn(returningIndex, kms, damage);

            System.out.println("Your Vehicle Returned Successfully");
        }
    }

    private void processReturn(int returningIndex, int kms, String damage) {
        ArrayList<String> details = currentUser.getRentelVehicle().get(returningIndex);
        String currentVehicle = details.getFirst();

        int category = 0;  // Assuming category is always 0 for cars
        int rent = calculateRent(kms, damage);

        int index = currentUser.getRentelVehicle().indexOf(details);
        int amount = currentUser.getAmount();
        amount = amount - rent;
        currentUser.setAmount(amount);

        // Change details
        for (int i = 0; i < vehicles.size(); i++) {
            for (int j = 0; j < vehicles.size(); j++) {
                if (currentVehicle.equals(vehicles.get(i).getVname().get(j))) {
                    vehicles.get(i).getStatus().set(j, "AVAILABLE");
                }
            }
        }
        currentUser.getRentelVehicle().remove(index);
    }

    private int calculateRent(int kms, String damage) {
        int rent = 1500;

        if (kms > 500) {
            rent += 1500;
        }

        if (damage.equalsIgnoreCase("Yes")) {
            System.out.print("Enter The Damage Level (HIGH, MEDIUM, LOW): ");
            String level = sc.nextLine();

            switch (level.toUpperCase()) {
                case "HIGH":
                    rent += 7500;
                    break;
                case "MEDIUM":
                    rent += 5000;
                    break;
                case "LOW":
                    rent += 2500;
                    break;
                default:
                    break;
            }
        }

        return rent;
    }
}
