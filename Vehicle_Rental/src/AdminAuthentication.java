import java.util.Scanner;

public class AdminAuthentication {
    private Scanner sc;

    public AdminAuthentication(Scanner scanner) {
        this.sc = scanner;
    }

    public void authenticateAdmin() {
        System.out.println("<******* Admin Login *******>");
        System.out.print("Admin name: ");
        String adname = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (!Admin.name.equals(adname) || !Admin.password.equals(pass)) {
            System.out.println("\tWrong credentials, try again");
            authenticateAdmin();
        }

        AdminControlPanel adminControlPanel = new AdminControlPanel(sc);
        adminControlPanel.run();
    }
}
