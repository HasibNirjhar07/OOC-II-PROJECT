import java.util.ArrayList;

public class ReportManager {
    public Admin admin;

    public ReportManager(Admin admin) {
        this.admin = admin;
    }

    public void viewReports() {
        System.out.println("*******************************************************************************");
        System.out.printf("%-8s %-24s %-22s %-24s ", "S.NO", "NAME", "NUMBER", "REPORT\n");
        System.out.println("*******************************************************************************");
        for (int i = 0; i < admin.Reports.size(); i++) {
            ArrayList<String> details = admin.Reports.get(i);
            System.out.format("%-8s %-24s %-22s %-24s ", (i + 1), details.get(0), details.get(1), details.get(2) + "\n");
            System.out.println();
        }
        System.out.println("********************************************************************************");
    }
}
