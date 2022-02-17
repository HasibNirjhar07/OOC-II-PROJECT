import java.util.*;

public class Vehicle {
    String type;
    ArrayList<String> Vname=new ArrayList<>();
    ArrayList<String> number=new ArrayList<>();
    ArrayList<String> status=new ArrayList<>();

    public Vehicle(String type,ArrayList<String> Vname,ArrayList<String> number,ArrayList<String> status){
        this.type=type;
        this.Vname=Vname;
        this.number=number;
        this.status=status;
    }
}
