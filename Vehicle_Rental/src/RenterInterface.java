
import java.util.ArrayList;

public interface RenterInterface {

    public String getName();
    public String getPassword();
    public int getAmount();
    public ArrayList<ArrayList<String>> getRentelVehicle();
    public ArrayList<ArrayList<String>> getRentelHistory();
    public void setName(String name);
    public void setPassword(String password);
    public void setAmount(int amount);



}
