import java.util.ArrayList;

public class Admin {
    public static String name = "admin";
    public static String password = "admin";

     ArrayList<ArrayList<String>> Reports = new ArrayList<>();
     ArrayList<ArrayList<String>> History = new ArrayList<>();

    public ArrayList<ArrayList<String>> getHistory() {
        return History;
    }
}

