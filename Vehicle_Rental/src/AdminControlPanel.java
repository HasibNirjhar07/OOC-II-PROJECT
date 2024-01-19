import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminControlPanel {
    private Scanner sc;
    private Admin admin;


    public AdminControlPanel(Scanner scanner) {
        this.sc = scanner;
    }

    public void run() {
        boolean flag = true;
        while (flag) {
            System.out.println("\n******** Welcome, Admin *******");
            System.out.println("""
                        1.Add Vehicle
                        2.View Vehicle
                        3.Change Security Deposit
                        4.View Reports
                        5.View History
                        6.Exit""");
            System.out.print("Choose Your Option :");
            Integer option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    List<Vehicle> vehicles = new ArrayList<>();
                    VehicleManager vehicleManager = new VehicleManager(vehicles);
                    vehicleManager.addVehicle();
                    break;
                case 2:
                    VehicleViewer vehicleViewer = new VehicleViewer();
                    vehicleViewer.viewVehicle();
                    break;
                case 3:
//                    DepositManager depositManager = new DepositManager(sc);
//                    depositManager.manageDeposit();
//                    break;
                case 4:

                    ReportManager reportManager = new ReportManager(admin);
                    reportManager.viewReports();
                    break;
                case 5:
                    HistoryManager historyManager = new HistoryManager(admin);
                    historyManager.viewHistory();
                    break;
                case 6:
                    System.out.println("\tThank You For Visit");
                    flag = false;
                    break;
                default:
                    System.out.println("\tInvalid Input");
            }
        }
    }
}
