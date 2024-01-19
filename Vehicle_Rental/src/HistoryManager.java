import java.util.ArrayList;

public class HistoryManager {
    private Admin admin;
    private AdminControlPanel adminControlPanel;

    public HistoryManager(Admin admin) {
        this.admin = admin;
    }

    public void viewHistory() {
        totalHistory();
        adminControlPanel.run();
    }

    private void totalHistory() {
        if (admin.getHistory().isEmpty()) {
            System.out.println("Don't Have Any Rented Vehicle History");
        } else {
            System.out.println("**************************************************************************************************************************");
            System.out.printf("%-8s %-24s %-22s %-26s %-23s %-23s", "S.NO", "RENTER NAME", "NAME", "NUMBER", "BORROWED DATE", "RETURNING DATE\n");
            System.out.println("**************************************************************************************************************************");
            for (int i = 0; i < admin.getHistory().size(); i++) {
                ArrayList<String> details = admin.getHistory().get(i);
                System.out.format("%-8s %-24s %-22s %-26s %-23s %-23s", (i + 1), details.get(0), details.get(1), details.get(2), details.get(3), details.get(4) + "\n");
                System.out.println();
            }
            System.out.println("**************************************************************************************************************************");
        }
    }
}
