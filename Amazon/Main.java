import java.util.*;

public class Main {
    private static Scanner sc=new Scanner(System.in);
    public static User use=new User();
    public static Merchant mer=new Merchant();
    public static Admin ad=new Admin();

    public static void main(String[] args){
        Boolean flag=true;
        while(flag){
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("***********Welcome To Amazon***********");
        System.out.println("           1 - Admin Login             ");
        System.out.println("           2 - Merchant Login          ");
        System.out.println("           3 - User Login              ");
        System.out.println("           4 - Exit                    ");
        int a=sc.nextInt();

        switch(a){
            case 1:
                ad.Display();
            break;
            case 2:
                mer.setMer("");
                mer.setPass("");
                mer.Display();
            break;
            case 3:
                use.setBuyername("");
                use.setBuyerid("");
                use.setId(-1);
                use.setmoney(-1);
                use.Display();

            break;
            case 4:
            System.out.println("********Thank you for using********");
                flag=false;
            break;
            default:
                System.out.println("Invalid Input");
            }
        }
    }
}
