import java.util.*;

public class Main {
    static Scanner sc = new Scanner( System.in );

    static Admin admin=new Admin();

    static List<String> Location = new ArrayList<>(List.of("A","B","C","D","E","F","G","H","I","J"));

    static ArrayList <User> users = new ArrayList <>(List.of(new User("A", "111", "M", 10000),new User("B", "222", "F", 20000)));
    static User CurrentUser;

    static ArrayList <Taxi> taxi = new ArrayList <>(List.of(new Taxi("1", "F", 400, "A"),new Taxi("2", "F", 300, "B"),new Taxi("3", "F", 600, "C")));

    private static void Home(){
        boolean flag = true;
        while( flag ){
            System.out.println("***********>WELCOME TO TAXI BOOKING<***********");
            System.out.println("""
                    1.Adminstator
                    2.User
                    3.Exit
                    """);
            System.out.print("Choose Your Option :");
            Integer Option = sc.nextInt();
            sc.nextLine();
            switch( Option ){
                case 1:
                    main_Admin();
                break;
                case 2:
                    main_User();
                break;
                case 3:
                    System.out.println("Thank you for Visit");
                    flag = false;
                break;
                default:
                    System.out.println("\tInvalid Input");
                    Home();
            }
        }
    }

    private static void main_Admin(){
        System.out.println("<******* Admin Login *******>");
        System.out.print("Admin name :");
        String adname=sc.nextLine();
        System.out.print("Password :");
        String pass=sc.nextLine();

        if(!admin.name.equals(adname) || !admin.password.equals(pass)){
            System.out.println("\tWrong credentials, try again");
            main_Admin();
        }
        admin();

    }

    private static void admin(){
        boolean flag=true;
        while(flag){
            System.out.println("*****************Welcome Admin******************");
            System.out.println("""
                1.Add taxi
                2.View User History
                3.Income
                4.View Reports
                5.Exit
                    """);
            System.out.print("Enter Your Choicen : ");
            Integer Choice = sc.nextInt();
            sc.nextLine();
            switch(Choice){
                case 1 :
                    taxi_add();
                break;
                case 2:
                if(admin.History.size()==0){
                    System.out.println("Dont Have History");
                    admin();
                }
                else
                    Admin_User_History();
                break;
                case 3:
                    Income();
                break;
                case 4:
                if(admin.Reports.size()==0){
                    System.out.println("Don't Have Any Reports");
                    admin();
                }
                else
                    Admin_Report();
                break;
                case 5:
                    System.out.println("Thank you for Vist");
                    flag = false;
                    Home();
                break;
                default:
                    System.out.println("\tInvalid Input");
                    admin();

            }
        }
    }

    private static void Admin_Report(){
        System.out.println("*********************************************");
        System.out.printf("%-6s %-15s %-30s", "S.NO", "USER NAME", "REPORT");
        System.out.println();
        System.out.println("*********************************************");

        for (int i = 0; i < admin.Reports.size(); i++) {
            ArrayList<String> details = admin.Reports.get(i);
            System.out.format("%-6s %-15s %-30s ", (i + 1),details.get(0), details.get(1)+"\n");
            System.out.println();
        }
        System.out.println("**********************************************");
        admin();
    }


    private static void Income(){
        System.out.println("******************************");
        System.out.printf("%-8s %-10s %-8s", "S.NO", "TAXI NAME", "BILL\n");
            System.out.println("********************************");
            for (int i = 0; i < admin.History.size(); i++) {
                ArrayList<String> details = admin.History.get(i);
                System.out.format("%-8s %-10s %-8s", (i + 1), details.get(3), details.get(4)+"\n");
                System.out.println();
            }
            System.out.println("*******************************");
            System.out.println("Total Income : "+admin.income);
            admin();
    }


    private static void Admin_User_History(){
        System.out.println("*******************************************************************");
        System.out.printf("%-8s %-10s %-8s %-8s %-10s %-8s", "S.NO", "USER NAME", "START", "END", "TAXI NAME", "BILL\n");
            System.out.println("*******************************************************************");
            for (int i = 0; i < admin.History.size(); i++) {
                ArrayList<String> details = admin.History.get(i);
                System.out.format("%-8s %-10s %-8s %-8s %-10s %-8s", (i + 1), details.get(0), details.get(1), details.get(2), details.get(3) ,details.get(4)+"\n");
                System.out.println();
            }
            System.out.println("*******************************************************************");
            admin();

    }

    private static void taxi_add(){
        System.out.print("Enter The Taxi Name : ");
        String new_name = sc.nextLine();
        System.out.print("Enter The Taxi Location : ");
        String new_loc = sc.nextLine();

        taxi.add(new Taxi(new_name,"F",0,new_loc));
        System.out.println("Taxi "+new_name+" Added Successfully");
    }


    private static void main_User(){
        boolean flag = true;
        while( flag ){
            System.out.println("************<WELCOME TO USER PAGE>************");
            System.out.println("""
                    1.User login
                    2.New User
                    3.Exit
                    """);
            System.out.print("Choose Your Option :");
            Integer Option = sc.nextInt();
            sc.nextLine();

            switch( Option ){
                case 1:
                    User_login();
                break;
                case 2:
                    User_sign();
                break;
                case 3 :
                    System.out.println("Thank You for Visit");
                    Home();
                break;
                default:
                    System.out.println("\tInvalid Input");
                    main_User();
            }
        }
    }

    private static void User_login(){
        System.out.println("\n******* User Login *********");
        System.out.print("User name : ");
        String userName = sc.nextLine();

        for (User user : users){
            if (user.name.equals(userName)) {
                System.out.print("Password : ");
                String password = sc.nextLine();
                if (user.pass.equals(password)) 
                    CurrentUser = user;
                else {
                    System.out.println("\tWrong Password");
                    User_login();
                    break;
                }
            }
        }

        if (CurrentUser == null) {
            System.out.println("\tYou don't have an account, please Sign up");
                User_sign();
            return;
        }
        Current_User();
    }

    private static void User_sign(){
        System.out.println("\n<****** User Sign up ********>");
        System.out.print("User name : ");
        String newUserName = sc.nextLine();
        System.out.print("User Gender : ");
        String newgen = sc.nextLine();
        System.out.print("Password : ");
        String newUserPassword = sc.nextLine();
        System.out.print("Conform password : ");
        String newUserConformPassword = sc.nextLine();
        System.out.print("Enter The Amount :");
        Integer newamount=sc.nextInt();
        sc.nextLine();

        for (User user : users) {
            if (user.name.equals(newUserName)) {
                System.out.println("Account Already Exist, Login");
                User_login();
                return;
            }
        }

        if (!newUserPassword.equals(newUserConformPassword)) {
            System.out.println("\tPassword Mismatch, Try Again");
            User_sign();
            return;
        }

        users.add(new User(newUserName, newUserPassword, newgen, newamount ));
        System.out.println("\tAccount Created Successfully");
        User_login();


    }


    private static void Current_User(){
        boolean flag = true;
        while( flag ){
            System.out.println("\n******* Welcome, Mr." + CurrentUser.name + " *******");
            System.out.println("""
                    1.Booking
                    2.View Taxi
                    3.Report
                    4.History
                    5.Exit
                    """);
            System.out.print("Choose your Choose : ");
            Integer Choose = sc.nextInt();
            sc.nextLine();

            switch( Choose ){
                case 1:
                    Booking();
                break;
                case 2:
                    View_taxi();
                break;
                case 3:
                    Report();
                break;
                case 4:
                if(CurrentUser.User_History.size()==0){
                    System.out.println("You Have No History Of Booking");
                    Current_User();
                }
                else
                    History();
                break;
                case 5:
                    System.out.println("Thank You for Visit");
                    main_User();
                break;
                default:
                    System.out.println("\tInvalid Input");
                    Current_User();

            }
        }
    }

    private static void History(){
        System.out.println("*********************************************************");
            System.out.printf("%-8s %-8s %-8s %-8s %-8s", "S.NO", "START", "END", "NAME", "BILL\n");
            System.out.println("*********************************************************");
            for (int i = 0; i < CurrentUser.User_History.size(); i++) {
                ArrayList<String> details = CurrentUser.User_History.get(i);
                System.out.format("%-8s %-8s %-8s %-8s %-8s", (i + 1), details.get(0), details.get(1), details.get(2), details.get(3) +"\n");
                System.out.println();
            }
            System.out.println("*********************************************************");
    }

    private static void View_taxi(){
        System.out.println("*********************************************");
        System.out.printf("%-6s %-15s %-10s %-20s", "S.NO", "VEHICLE NAME", "STATUS", "LOCATION");
        System.out.println();
        System.out.println("*********************************************");

        for (int i = 0; i < taxi.size(); i++) {
            System.out.format("%-6s %-15s %-10s %-20s", (i + 1), taxi.get(i).taxi_name, taxi.get(i).avai, taxi.get(i).loc);
            System.out.println();
        }

        System.out.println("**********************************************");
        Current_User();

    }
    private static void Report() {
        System.out.println("Type Your Report as a comment ");
        String re = sc.nextLine();
        admin.Reports.add(new ArrayList<>(List.of(CurrentUser.name,re)));
        CurrentUser.User_Complient.add(re);
        System.out.println("Your Report is Saved");
    }



    private static void Booking(){
        Boolean flag=true;
        while( flag ){
            System.out.println("*****WELCOME TO BOOKING PAGE*****");
            System.out.print("Enter the Location : ");
            String start=sc.nextLine();
            if(!Location.contains(start)){
                System.out.print("Enter the end Location : ");
                String end =sc.nextLine();
                System.out.println("Taxi not available in that location");
                List<Integer> position = new ArrayList<>();

                for(int i=0;i<taxi.size();i++){
                    Integer a=Math.abs(start.charAt(0)-taxi.get(i).loc.charAt(0));
                    position.add(a);
                }
                int near=Collections.min(position);
                Integer pos = position.indexOf(near);
                System.out.println("Taxi No : " +taxi.get(pos).taxi_name+ " Booked in "+taxi.get(pos).loc+" Successfully");

                int bi=near*100;
                taxi.get(pos).avai = "O";
                taxi.get(pos).loc = end;
                System.out.println("Your bill : "+bi);
                flag=false;
                CurrentUser.money = CurrentUser.money - bi ;
                taxi.get(pos).income=taxi.get(pos).income + bi;
                admin.income=admin.income + bi;
                admin. History. add (new ArrayList<>(List.of(CurrentUser.name, taxi.get(pos).loc, end, taxi.get(pos).taxi_name+" " , bi+" ")));
                CurrentUser. User_History. add (new ArrayList<>(List.of(taxi.get(pos).loc, end, taxi.get(pos).taxi_name+" " , bi+" ")));
                Current_User();
            }

            List<Integer>co = new ArrayList <>();
            for(int i=0; i<taxi.size(); i++){
                if(taxi.get(i).loc.equals(start)){
                    if(taxi.get(i).avai.equals("F")){
                        co.add(taxi.get(i).income);
                    }
                }
            }

            if(co.size()!=1){
                Integer lowest= Collections.min(co);
                Integer index =-1;
                for(int i=0;i<taxi.size();i++){
                    if(taxi.get(i).income==lowest){
                        index=i;
                    }
                }
                System.out.print("Enter the End Location : ");
                String end = sc.nextLine();
                if(!Location.contains(end)){
                    System.out.println("Ending Point does not exists ");
                    Booking();
                }
                if(end.equals(start)){
                    System.out.println("Start and End is same Choose Another Stop");
                    Booking();
                }

                int bi = Math.abs(start.charAt(0) - end.charAt(0))*100;
                System.out.println("Taxi No : "+taxi.get(index).taxi_name+" Booked for you");
                taxi.get(index).avai = "O";
                taxi.get(index).loc = end;
                System.out.println("Your bill : "+bi);
                flag=false;
                CurrentUser.money = CurrentUser.money - bi ;
                taxi.get(index).income=taxi.get(index).income + bi;
                admin.income=admin.income + bi;
                admin. History. add (new ArrayList<>(List.of(CurrentUser.name, start, end, taxi.get(index).taxi_name+" " , bi+" ")));
                CurrentUser. User_History. add (new ArrayList<>(List.of(start, end, taxi.get(index).taxi_name+" " , bi+" ")));
                Current_User();
            
            }
            if(co.size()==1){
                System.out.print("Enter the End Location : ");
                String end = sc.nextLine();
                if(!Location.contains(end)){
                    System.out.println("Ending Point does not exists ");
                    Booking();
                }
                if(end.equals(start)){
                    System.out.println("Start and End is same Choose Another Stop");
                    Booking();
                }

                Integer index =-1;
                for(int i=0;i<taxi.size();i++){
                    if(taxi.get(i).income == co.get(0)){
                        index=i;
                    }
                }

                int bi = Math.abs(start.charAt(0) - end.charAt(0))*100;
                System.out.println("Taxi No : "+taxi.get(index).taxi_name+" Booked for you");
                taxi.get(index).avai = "O";
                taxi.get(index).loc = end;
                System.out.println("Your bill : "+bi);
                flag=false;
                taxi.get(index).income=taxi.get(index).income + bi;
                CurrentUser.money = CurrentUser.money - bi ;
                admin.income=admin.income + bi;
                admin. History. add (new ArrayList<>(List.of(CurrentUser.name, start, end, taxi.get(index).taxi_name+" " , bi+" ")));
                CurrentUser. User_History. add (new ArrayList<>(List.of(start, end, taxi.get(index).taxi_name+" " , bi+" ")));
                Current_User();
            
            }
        }
    }

    public static void main(String[] args){
        Home();
    }
}
