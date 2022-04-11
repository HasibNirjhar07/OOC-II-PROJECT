import java.util.*;

public class User {
    String name;
    String pass;
    String gender;
    Integer money;
    
    public User(String name, String pass, String geder, Integer money){
        this.name = name;
        this.pass = pass;
        this.gender = gender;
        this.money = money;
    }

    ArrayList<String> User_Complient=new ArrayList<>();
    ArrayList<ArrayList<String>> User_History = new ArrayList<>();
}
