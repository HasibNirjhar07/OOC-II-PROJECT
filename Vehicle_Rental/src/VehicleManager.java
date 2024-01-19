import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleManager {
    private ArrayList<Vehicle> vehicles;

    public VehicleManager(List<Vehicle> vehicles) {
        this.vehicles = new ArrayList<>(vehicles);
    }

    public void addVehicle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n*** Welcome To Add Vehicle Page ***");

            // Show Vehicle Type
            System.out.println("\n List Of Vehicle Type :\n");
            for (int i = 0; i < vehicles.size(); i++) {
                System.out.println("\t" + (i + 1) + ". " + vehicles.get(i).getType());
            }

            System.out.print("Select Vehicle Type: ");
            int typeIndex = sc.nextInt() - 1;
            sc.nextLine();

            if (typeIndex < 0 || typeIndex >= vehicles.size()) {
                System.out.println("\tInvalid Input");
                addVehicle();
                return;
            }

            // Add Vehicle
            System.out.print("Enter The Vehicle Name: ");
            String newName = sc.nextLine();
            System.out.print("Enter The Vehicle Number: ");
            String newNumber = sc.nextLine();
            System.out.print("Enter The Vehicle Status: ");
            String newStatus = sc.nextLine();

            // Assuming Vehicle has a constructor with parameters (name, number, status)
            Vehicle newVehicle = new Vehicle(newName, newNumber, newStatus);
            vehicles.add(newVehicle);

            System.out.println("\t" + newName + " Successfully Added In " + vehicles.get(typeIndex).getType());

    }



}

