import java.util.ArrayList;
import java.util.List;

public class Vehicle  {
    private String type;
    private ArrayList<String> Vname;
    private ArrayList<String> number;
    private ArrayList<String> status;

    public Vehicle(String type, ArrayList<String> Vname, ArrayList<String> number, ArrayList<String> status) {
        this.type = type;
        this.Vname = Vname;
        this.number = number;
        this.status = status;
    }

    public Vehicle(String newName, String newNumber, String newStatus) {}

    public String getType() {
        return type;
    }

    public ArrayList<String> getVname() {
        return Vname;
    }

    public ArrayList<String> getNumber() {
        return number;
    }

    public ArrayList<String> getStatus() {
        return status;
    }

}
