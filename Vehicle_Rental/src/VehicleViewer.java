import java.util.ArrayList;
import java.util.Scanner;

public class VehicleViewer implements IVehicleView {
    private ArrayList<Vehicle> vehicles;
    private VehicleManager vehicleManager;

    public VehicleViewer() {
        this.vehicles = new ArrayList<>();
        this.vehicleManager = new VehicleManager(vehicles);
    }

    public void viewVehicle() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("*** Welcome To View Vehicle Site ***");
            System.out.println("1. View Vehicle\n2. Search By Name\n3. Search By Number\n4. Exit");
            System.out.print("Enter The Choice : ");
            Integer choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    showVehicle();
                    break;
                case 2:
                    searchByName();
                    break;
                case 3:
                    searchByNumber();
                    break;
                case 4:
                    System.out.println("\tThank You For Visit");
                    flag = false;
                    break;
                default:
                    System.out.println("\tInvalid Input");
            }
        }
    }

    // Show Vehicle Block
    public void showVehicle() {
        // Show Vehicle Type
        Scanner sc = new Scanner(System.in);
        System.out.print("\n List Of Vehicle Type :\n");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + vehicles.get(i).getType());
        }
        System.out.print("Select Vehicle Type :");
        Integer typ = sc.nextInt() - 1;
        sc.nextLine();
        if (typ < 0 || typ >= vehicles.size()) {
            System.out.println("\tInvalid Input");
            return;
        }

        // Show Vehicle in Type
        System.out.println("*****************************************");
        System.out.printf("%-6s %-15s %-10s %-20s\n", "S.NO", "VEHICLE NAME", "NUMBER", "STATUS");
        System.out.println("*****************************************");

        for (int i = 0; i < vehicles.get(typ).getVname().size(); i++) {
            System.out.printf("%-6s %-15s %-10s %-20s\n", (i + 1), vehicles.get(typ).getVname().get(i),
                    vehicles.get(typ).getNumber().get(i), vehicles.get(typ).getStatus().get(i));
        }

        System.out.println("******************************************");
    }

    public void searchByName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Name Of The Vehicle: ");
        String vehicleName = sc.nextLine();
        int index = 0;

        for (Vehicle currentVehicle : vehicles) {
            for (int i = 0; i < currentVehicle.getVname().size(); i++) {
                if (vehicleName.equals(currentVehicle.getVname().get(i))) {
                    index++;
                    displayVehicleDetails(currentVehicle, i);
                    return; // No need to continue searching if found
                }
            }
        }

        if (index == 0) {
            System.out.println("There Is No Vehicle With This Name");
        }
    }

    public void searchByNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Number Of The Vehicle: ");
        String vehicleNumber = sc.nextLine();
        int index = 0;

        for (Vehicle currentVehicle : vehicles) {
            for (int i = 0; i < currentVehicle.getNumber().size(); i++) {
                if (vehicleNumber.equals(currentVehicle.getNumber().get(i))) {
                    index++;
                    displayVehicleDetails(currentVehicle, i);
                    return; // No need to continue searching if found
                }
            }
        }

        if (index == 0) {
            System.out.println("There Is No Vehicle With This Number");
        }
    }

    public void displayVehicleDetails(Vehicle currentVehicle, int index) {
        System.out.println("*******************************************");
        System.out.printf("%-6s %-15s %-10s %-20s\n", "S.NO", "VEHICLE NAME", "NUMBER", "STATUS");
        System.out.println("*******************************************");
        System.out.printf("%-6s %-15s %-10s %-20s\n", "1", currentVehicle.getVname().get(index),
                currentVehicle.getNumber().get(index), currentVehicle.getStatus().get(index));
        System.out.println("*******************************************");
    }
}
