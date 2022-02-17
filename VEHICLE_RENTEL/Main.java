import java.util.*;

public class Main {
    static Scanner sc=new Scanner(System.in);

    //Admin Block Variables
    static Admin admin=new Admin();

    //Renter Block Variables
    static ArrayList<Renter> renters = new ArrayList<>(List.of(new Renter("A", "1111", 30000), new Renter("B", "2222", 30000)));
    static Renter currentUser;
    static int category;

    //Vehicle   Block Variables
    static ArrayList <Vehicle> vehicle = new ArrayList<> (List.of (
        new Vehicle("Car", new ArrayList<String>(List.of("BMW", "AUDI")), new ArrayList<String>(List.of("TN37", "TN78")),new ArrayList<String>(List.of("AVAILABLE", "RENTED"))),
        new Vehicle("Bike",new ArrayList<String>(List.of("YAMAHA", "TVS")), new ArrayList<String>(List.of("TN66", "TN55")),new ArrayList<String>(List.of("RENTED" ,"AVAILABLE")))));


   // *************************************************Home Menu***********************************************************

   private static void Home(){
        boolean flag = true;
        while(flag){
            System.out.println("\n********************** Welcome To Rentel Web ***************************");
            System.out.println("""
                    1.Adminstator
                    2.Borrower
                    3.Exit""");
            System.out.print("Choose Your Option :");
            Integer Option=sc.nextInt();
            sc.nextLine();

            switch(Option){
                case 1:
                    madmin();
                break;
                case 2:
                    Borrower();
                break;
                case 3:
                    flag=false;
                    System.out.println("\tThank You For Visit");
                break;
                default:
                    System.out.println("\tInvalid Input");
                    Home();
            }
       }
   }

   //************************************Admin Block **********************************************

    private static void madmin(){
        System.out.println("<******* Admin Login *******>");
        System.out.print("Admin name :");
        String adname=sc.nextLine();
        System.out.print("Password :");
        String pass=sc.nextLine();

        if(!admin.name.equals(adname) || !admin.password.equals(pass)){
            System.out.println("\tWrong credentials, try again");
            madmin();
        }
        admin();
    }

    private static void admin(){
        boolean flag=true;
        while(flag){
            System.out.println("\n******** Welcome, Admin *******");
            System.out.println("""
                        1.Add Vehicle
                        2.View Vehicle
                        3.Change Security Deposit
                        4.View Reports
                        5.View History
                        6.Exit""");
            System.out.print("Choose Your Option :");
            Integer Option=sc.nextInt();
            sc.nextLine();

            switch(Option){
                case 1:
                    Add_Vehicle();
                break;
                case 2:
                    View_Vehicle();
                break;
                case 3:
                    Deposit();
                break;
                case 4:
                    if(admin.Reports.size()!=0)
                        View_Reports();
                    else 
                        System.out.println("***You Dont Have Any Repots***");
                        admin();
                break;
                case 5:
                    Total_History();
                break;
                case 6:
                    System.out.println("\tThank You For Vist");
                    flag = false;
                    Home();
                break;
                default:
                    System.out.println("\tInvalid Input");
                    admin();

            }
        }
    }
    //Add vehicle Block

    private static void Add_Vehicle() {
        System.out.print("\n***Welcome To Add_Vehicle Page***");
        
        //Show Vehicle Type
        System.out.print("\n List Of Vechile Type :\n");
        for (int i = 0; i < vehicle.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + vehicle.get(i).type);
        }
        System.out.print("Select Vehicle Type :");
        Integer typ = (sc.nextInt() - 1);
        sc.nextLine();
        if (typ >= vehicle.size()) {
            System.out.println ("\tInvalid Input");
            Add_Vehicle();
            return;
        }
        
        //Add Vehicle
        System.out.print("Enter The Vechicle Name :");
        String newname=sc.nextLine();
        System.out.print("Enter The Vechicle Number :");
        String newnumber=sc.nextLine();
        System.out.print("Enter The Vehicle Status :");
        String newstatus=sc.nextLine();

        vehicle.get(typ).Vname.add(newname);
        vehicle.get(typ).number.add(newnumber);
        vehicle.get(typ).status.add(newstatus);

        System.out.println("\t" + newname + " Successfully Added In " + vehicle.get(typ).type);
    }

    //View Vehicle Block
    private static void View_Vehicle(){
        boolean flag = true;
        while(flag){
            System.out.println("*** Welcome To View Vehicle Site ***");
            System.out.println("""
                                1.View Vehicle
                                2.Search By Name
                                3.Search By Number
                                4.Exit""");
            System.out.print("Enter The Choice :");
            Integer choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    Show_Vehicle();
                break;
                case 2:
                    By_Name();
                break;
                case 3:
                    By_Number();
                break;
                case 4:
                    System.out.println("\tThank You For Visit");
                    flag=false;
                    return ;
                default :
                    System.out.println("\tInvalid Input");
                    View_Vehicle();

            }
        }

    }

    //Show Vehice Block
    private static void Show_Vehicle(){
        
        //Show Vehicle Type
        System.out.print("\n List Of Vechile Type :\n");
        for (int i = 0; i < vehicle.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + vehicle.get(i).type);
        }
        System.out.print("Select Vehicle Type :");
        Integer typ=(sc.nextInt() - 1);
        sc.nextLine();
        if (typ >= vehicle.size()) {
            System.out.println("\tInvalid Input");
            Add_Vehicle();
            return;
        }

        //Show Vehicle in Type
        System.out.println("*****************************************");
        System.out.printf("%-6s %-15s %-10s %-20s", "S.NO", "VEHICLE NAME", "NUMBER", "STATUS");
        System.out.println();
        System.out.println("*****************************************");

        for (int i = 0; i < vehicle.get(typ).Vname.size(); i++) {
            System.out.format("%-6s %-15s %-10s %-20s", (i + 1), vehicle.get(typ).Vname.get(i), vehicle.get(typ).number.get(i), vehicle.get(typ).status.get(i));
            System.out.println();
        }

        System.out.println("******************************************");
        category= typ;
        View_Vehicle();
        return;
    }


    //Search By Name
    private static void By_Name(){
        System.out.print("Enter The Name Of The Vehicle :");
        String Vehiclename=sc.nextLine();
        int index=0;
        for(int i=0 ; i < vehicle.size() ; i++){
            for(int j=0; j < vehicle.size() ; j++){
                if(Vehiclename.equals(vehicle.get(j).Vname.get(i))){
                    index++;
                    System.out.println("*******************************************");
                    System.out.printf("%-6s %-15s %-10s %-20s", "S.NO", "VEHICLE NAME", "NUMBER", "STATUS");
                    System.out.println();
                    System.out.println("*******************************************");
                    System.out.format("%-6s %-15s %-10s %-20s", "1" , vehicle.get(j).Vname.get(i), vehicle.get(j).number.get(i), vehicle.get(j).status.get(i));
                    System.out.println();
                    System.out.println("*******************************************");
                    View_Vehicle();
                }
            }
        }
        if(index==0){
            System.out.println("There Is No Vehicle In This Name");
            View_Vehicle();
        }
    }


    //By number
    private static void By_Number(){
        System.out.print("Enter The Number Of The Vehicle :");
        String Vehiclenumber=sc.nextLine();
        int index=0;
        for(int i=0 ; i < vehicle.size() ; i++){
            for(int j=0; j < vehicle.size() ; j++){
                if(Vehiclenumber.equals(vehicle.get(j).number.get(i))){
                    index++;
                    System.out.println("********************************************");
                    System.out.printf("%-6s %-15s %-10s %-20s", "S.NO", "VEHICLE NAME", "NUMBER", "STATUS");
                    System.out.println();
                    System.out.println("********************************************");
                    System.out.format("%-6s %-15s %-10s %-20s", "1" , vehicle.get(j).Vname.get(i), vehicle.get(j).number.get(i), vehicle.get(j).status.get(i));
                    System.out.println();
                    System.out.println("********************************************");
                    View_Vehicle();
                }
            }
        }
        if(index==0){
            System.out.println("There Is No Vehicle In This Name");
            View_Vehicle();
        }
    }


    //Manage Deposit Block
    private static void Deposit(){
        boolean flag=true;
        while( flag ){
            System.out.println("*** Welcome To Deposit Management ***");
            System.out.println("""
                            1.View Deposit
                            2.Change Deposit
                            3.Exit""");
        System.out.print("Enter The Choice :");
        Integer Choice = sc.nextInt();
        sc.nextLine();
        switch(Choice){
            case 1:
                View_deposit();
            break;
            case 2:
                Change_Deposit();
            break;
            case 3:
                System.out.println("\tThank You For Visit");
                flag=false;
                admin();
            break;
            default:
                System.out.println("\tInvalid Input");
                Deposit();
        }


        }
    }

    //View Deposit Block
    private static void View_deposit(){
        System.out.println("**************************************");
        System.out.printf("%-8s %-15s %-10s","S.NO","NAME","DEPOSIT");
        System.out.println();
        System.out.println("**************************************");
        for(int i = 0 ;i < renters.size() ; i++){
            System.out.format ("%-8s %-15s %-10s", ( i + 1 ) , renters.get(i).name , renters.get(i).amount);
            System.out.println();
        }
        System.out.println("**************************************");
        Deposit();
        return;
    }

    //Change Deposit
    private static void Change_Deposit(){
        System.out.println("**************************************");
        System.out.printf("%-8s %-15s %-10s","S.NO","NAME","DEPOSIT");
        System.out.println();
        System.out.println("**************************************");
        for(int i = 0 ;i < renters.size() ; i++){
            System.out.format ("%-8s %-15s %-10s", ( i + 1 ) , renters.get(i).name , renters.get(i).amount);
            System.out.println();
        }
        System.out.println("**************************************");
        System.out.print("Choose The Renter Name :");
        Integer uname=(sc.nextInt() - 1);
        sc.nextLine();
        if (uname >= renters.size()) {
            System.out.println("\tInvalid Input");
            Change_Deposit();
            return;
        }
        System.out.print("Input The New Deposit Amount :");
        Integer newamount=sc.nextInt();
        sc.nextLine();
        renters.get(uname).amount= newamount;
        System.out.println("\t "+newamount +"Changed Successfully To "+ renters.get(uname).name + "Deposite");

    }

    //View Reports Block
    private static void View_Reports(){
        System.out.println("*******************************************************************************");
        System.out.printf("%-8s %-24s %-22s %-24s ", "S.NO", "NAME", "NUMBER", "REPORT\n");
        System.out.println("*******************************************************************************");
        for (int i = 0; i < admin.Reports.size(); i++) {
            ArrayList<String> details = admin.Reports.get(i);
            System.out.format("%-8s %-24s %-22s %-24s ", (i + 1), details.get(0), details.get(1), details.get(2) +"\n");
            System.out.println();
        }
        System.out.println("********************************************************************************");
        admin();

    }

    //Total History
    private static void Total_History(){
        if(admin.History.size()==0){
            System.out.println("Dont Have Any Rented Vehicle History");
            admin();
        }
        else{
            System.out.println("**************************************************************************************************************************");
            System.out.printf("%-8s %-24s %-22s %-26s %-23s %-23s", "S.NO","RENTER NAME", "NAME", "NUMBER", "BORROWED DATE", "RETURNING DATE\n");
            System.out.println("**************************************************************************************************************************");
            for (int i = 0; i < admin.History.size(); i++) {
                ArrayList<String> details = admin.History.get(i);
                System.out.format("%-8s %-24s %-22s %-26s %-23s %-23s", (i + 1), details.get(0), details.get(1), details.get(2), details.get(3), details.get(4) +"\n");
                System.out.println();
            }
            System.out.println("**************************************************************************************************************************");
        }
        admin();

    }


    //****************************************** Borrower Block *************************************************
   private static void Borrower(){
        boolean flag = true;
        while (flag) {
            System.out.println("\n******** User ********");
            System.out.println("""
                            1 - Renter Login
                            2 - Create Account
                            3 - Back""");
            System.out.print("Choose your option : ");
            Integer option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    Renter_Login();
                break;
                case 2:
                    Renter_CreateAccount();
                break;
                case 3:
                    System.out.println("\tThank You For Visit");
                    flag = false;
                    Home();
                break;
                default:
                    System.out.println("\tInvalid Input");
                    Borrower();
                break;
            }
        }
    }


    //Renter Login Block
    private static void Renter_Login(){
        System.out.println("\n******* Renter Login *********");
        System.out.print("Renter name : ");
        String userName = sc.nextLine();

        //check If User Exist Or Not
        for (Renter renter : renters){
            if (renter.name.equals(userName)) {
                System.out.print("Password : ");
                String password = sc.nextLine();
                if (renter.password.equals(password)) 
                    currentUser = renter;
                else {
                    System.out.println("\tWrong Password");
                    Renter_Login();
                    break;
                }
            }
        }
        if (currentUser == null) {
            System.out.println("\tYou don't have an account, please Sign up");
                Renter_CreateAccount();
            return;
        }
        Renter_Choice();
    }


        //Renter Choices
        private static void Renter_Choice(){
        Boolean flag = true;
        while ( flag ){
            System.out.println("\n******* Welcome, Mr." + currentUser.name + " *******");
            System.out.println("""
                                1.View Vehicle
                                2.Cart
                                3.Return Vehicle
                                4.View History
                                5.Report 
                                6.Exit""");
            System.out.print("Enter Your Choice :");
            Integer Choice=sc.nextInt();
            sc.nextLine();
            switch( Choice ){
                case 1:
                    View_Vehicle();
                break;
                case 2:
                    Cart();
                break;
                case 3:
                    Return_Vehicle();
                break;
                case 4:
                    View_History();
                break;
                case 5:
                    Report();
                break;
                case 6:
                    System.out.println ("\tThank You For Visit");
                    flag = false;
                    Borrower();
                break;
                default:
                    System.out.println ("\tInvalid Input");
                    Renter_Choice();

            }
        }
    } 


    //Renter Create Account
    private static void Renter_CreateAccount() {
        System.out.println("\n<****** Renter Sign up ********>");
        System.out.print("User name : ");
        String newUserName = sc.nextLine();
        System.out.print("Password : ");
        String newUserPassword = sc.nextLine();
        System.out.print("Conform password : ");
        String newUserConformPassword = sc.nextLine();
        System.out.print("Enter The Deposite Amount :");
        Integer newamount=sc.nextInt();
        sc.nextLine();

        //Check If User Exist
        for (Renter renter : renters) {
            if (renter.name.equals(newUserName)) {
                System.out.println("Account Already Exist, Login");
                Renter_Login();
                return;
            }
        }

        //check password
        if (!newUserPassword.equals(newUserConformPassword)) {
            System.out.println("\tPassword Mismatch, Try Again");
            Renter_CreateAccount();
            return;
        }

        //add Renter
        renters.add(new Renter(newUserName, newUserPassword,newamount ));
        System.out.println("\tAccount Created Successfully");
        Renter_Login();
    }

    //Cart Block
    private static void Cart(){
        boolean flag=true;
        while( flag ){
            System.out.println("\n******** Wecome To Cart ********");
            System.out.println("""
                                1.View Cart
                                2.Add To Cart
                                3.Exit""");
            System.out.print("Enter Your Choice :");
            Integer Choice=sc.nextInt();
            sc.nextLine();

            switch(Choice){
                case 1:
                    if(currentUser.Rentel_Vehicle.size()!=0)
                        View_Cart();
                    else System.out.println("***You Dont Rented Any Vehicle***");
                break;
                case 2:
                    if(currentUser.Rentel_Vehicle.size()==2){
                        System.out.println("You Already Reached The Maximum Number Of Rented Vehicles");
                    }
                    else Add_Cart();
                break;
                case 3:
                    System.out.println ("\tThank You For Visit");
                    flag = false;
                    Renter_Choice();
                break;
                default:
                    System.out.println ("\tInvalid Input");
                    Cart();

            }
        }
    }

    //View Cart Block
    private static void View_Cart(){

        System.out.println("*****************************************************************************************************************************");
        System.out.printf("%-8s %-24s %-22s %-26s %-23s %-23s", "S.NO", "NAME", "NUMBER", "STATUS", "BORROWED DATE", "RETURNING DATE\n");
        System.out.println("*****************************************************************************************************************************");
        for (int i = 0; i < currentUser.Rentel_Vehicle.size(); i++) {
            ArrayList<String> details = currentUser.Rentel_Vehicle.get(i);
            System.out.format("%-8s %-24s %-22s %-26s %-23s %-23s", (i + 1), details.get(0), details.get(1), details.get(2), details.get(3), details.get(4) +"\n");
            System.out.println();
        }
        System.out.println("*****************************************************************************************************************************");
        Cart();
    }

    //Add To Cart Block
    private static void Add_Cart(){
        System.out.print("\n List Of Vehicle Type :\n");
        for (int i = 0; i < vehicle.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + vehicle.get(i).type);
        }
        System.out.print("Select Vehicle Type :");
        Integer typ=(sc.nextInt() - 1);
        sc.nextLine();
        if (typ >= vehicle.size()) {
            System.out.println("\tInvalid Input");
            Add_Vehicle();
            return;
        }

        //show Vehicle
        System.out.println("*********************************************");
        System.out.printf("%-6s %-15s %-10s %-20s", "S.NO", "VEHICLE NAME", "NUMBER", "STATUS");
        System.out.println();
        System.out.println("*********************************************");

        for (int i = 0; i < vehicle.get(typ).Vname.size(); i++) {
            System.out.format("%-6s %-15s %-10s %-20s", (i + 1), vehicle.get(typ).Vname.get(i), vehicle.get(typ).number.get(i), vehicle.get(typ).status.get(i));
            System.out.println();
        }

        System.out.println("**********************************************");
        category= typ;

        //Rent Block
        System.out.print("Select The Vehicle :");
        int vehicleindex=(sc.nextInt()-1);
        sc.nextLine();

        //check Vehicle Is Rented
        if (!currentUser.Rentel_Vehicle.isEmpty())
            for (int i = 0; i < currentUser.Rentel_Vehicle.size(); i++)
                if (currentUser.Rentel_Vehicle.get(i).contains(vehicle.get(category).Vname.get(typ))) {
                    System.out.println("\tYou Already Rented This Vehicle");
                    Cart();
                    return;
        }

        if(vehicle.get(typ).status.get(vehicleindex).equals("AVAILABLE")){
            if(typ==0){
                if(currentUser.amount>=10000){
                    String borrowDate = BorrowDate();
                    currentUser.Rentel_Vehicle.add(new ArrayList<>(List.of(vehicle.get(category).Vname.get(vehicleindex), vehicle.get(category).number.get(vehicleindex), "RENTED", borrowDate, borrowDate)));
                    currentUser.Rentel_History.add(new ArrayList<>(List.of(vehicle.get(category).Vname.get(vehicleindex), vehicle.get(category).number.get(vehicleindex), vehicle.get(category).status.get(vehicleindex), borrowDate, borrowDate)));
                    admin.History.add(new ArrayList<>(List.of(currentUser.name,vehicle.get(category).Vname.get(vehicleindex), vehicle.get(category).number.get(vehicleindex), borrowDate, borrowDate)));
                    System.out.println("\t" + vehicle.get(category).Vname.get(vehicleindex) + " Vehicle Successfully Rented");
                    vehicle.get(category).status.set(vehicleindex,"RENTED");
                    Cart();

                }
                else{
                    System.out.println("****Deposit Is Not Sufficient For Rent Vehicle****");
                    Cart();
                }
            }
            else{
                if(currentUser.amount>=3000){
                    String borrowDate = BorrowDate();
                    currentUser.Rentel_Vehicle.add(new ArrayList<>(List.of(vehicle.get(category).Vname.get(vehicleindex), vehicle.get(category).number.get(vehicleindex), "RENTED", borrowDate, borrowDate)));
                    currentUser.Rentel_History.add(new ArrayList<>(List.of(vehicle.get(category).Vname.get(vehicleindex), vehicle.get(category).number.get(vehicleindex), vehicle.get(category).status.get(vehicleindex), borrowDate, borrowDate)));
                    admin.History.add(new ArrayList<>(List.of(currentUser.name,vehicle.get(category).Vname.get(vehicleindex), vehicle.get(category).number.get(vehicleindex), borrowDate, borrowDate)));
                    System.out.println("\t" + vehicle.get(category).Vname.get(vehicleindex) + " Vehicle Successfully Rented");
                    vehicle.get(category).status.set(vehicleindex,"RENTED");
                    Cart();

                }
                else{
                    System.out.println("****Deposit Is Not Sufficient For Rent Vehicle****");
                    Cart();
                }

            }
        }
        else{
            System.out.println("Vehicle Is Not Available At The Moment");
            Cart();
        }
    }
 

    //Return Vehicle Block
    private static void Return_Vehicle(){
        String currentvehicle="";
        if(currentUser.Rentel_Vehicle.size()==0){
            System.out.println("You Dont Have Any Rented Vehicles");
            Renter_Choice();
        }
        else{
            System.out.println("*****************************************************************************************************************************");
            System.out.printf("%-8s %-24s %-22s %-26s %-23s %-23s", "S.NO", "NAME", "NUMBER", "STATUS", "BORROWED DATE", "RETURNING DATE\n");
            System.out.println("*****************************************************************************************************************************");
            for (int i = 0; i < currentUser.Rentel_Vehicle.size(); i++) {
                ArrayList<String> details = currentUser.Rentel_Vehicle.get(i);
                System.out.format("%-8s %-24s %-22s %-26s %-23s %-23s", (i + 1), details.get(0), details.get(1), details.get(2), details.get(3), details.get(4) +"\n");
                System.out.println();
                currentvehicle=details.get(0);
            }
            System.out.println("*****************************************************************************************************************************");
        }

        //Retyrn Details
        System.out.println("These Vehicles Are Currently Rented To You ");
        int Rent=1500;
        System.out.print("Choose The Returning Vehicle :");
        int Returning=(sc.nextInt()-1);
        System.out.print("Enter The Kms Of The Vehicle Used :");
        int Kms=sc.nextInt();
        sc.nextLine();

        //Damage Block
        System.out.print("Is There A Any Damage :");
        String damage=sc.nextLine();
        if(damage.equalsIgnoreCase("Yes")){
            Boolean flag=true;
            while(flag){
                System.out.print("Enter The Damage Lavel :");
                String Level=sc.nextLine();
                switch(Level){
                    case "HIGH":
                        Rent=7500;
                    flag=false;
                    break;
                    case "MEDIUM":
                        Rent=5000;
                    flag=false;
                    break;
                    case "LOW":
                        Rent=2500;
                    flag=false;
                    break;
                    default :
                }
            }
        }

        //Kms Moniter
        if(Kms>500){
            Rent=Rent+1500;
        }
        System.out.print("Total Rent is  ₹: " +Rent);
        int index=renters.indexOf(currentUser);
        int amo=renters.get(index).amount;
        amo=amo-Rent;
        renters.get(index).amount=amo;
        
        //Change Details
        for(int i=0 ; i < vehicle.size() ; i++){
            for(int j=0; j < vehicle.size() ; j++){
                if(currentvehicle.equals(vehicle.get(i).Vname.get(j))){
                    vehicle.get(i).status.set(j, "AVAILABLE");
                    }
                }
            }
            currentUser.Rentel_Vehicle.remove(Returning);
        System.out.println("Your Vehicle Returned Successfully");
    }

    //View History Block
    private static void View_History(){
        if(currentUser.Rentel_History.size()==0){
            System.out.println("You Dont Have Any Rented Vehicles");
            Renter_Choice();
        }
        else{
            System.out.println("*****************************************************************************************************************************");
            System.out.printf("%-8s %-24s %-22s %-26s %-23s %-23s", "S.NO", "NAME", "NUMBER", "STATUS", "BORROWED DATE", "RETURNING DATE\n");
            System.out.println("*****************************************************************************************************************************");
            for (int i = 0; i < currentUser.Rentel_History.size(); i++) {
                ArrayList<String> details = currentUser.Rentel_Vehicle.get(i);
                System.out.format("%-8s %-24s %-22s %-26s %-23s %-23s", (i + 1), details.get(0), details.get(1), details.get(2), details.get(3), details.get(4) +"\n");
                System.out.println();
            }
            System.out.println("*****************************************************************************************************************************");
        }
        Renter_Choice();
    }

    //Report Block
    private static void Report(){
        System.out.print("\n List Of Vechile Type :\n");
        for (int i = 0; i < vehicle.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + vehicle.get(i).type);
        }
        System.out.print("Select Vehicle Type :");
        Integer typ=(sc.nextInt() - 1);
        sc.nextLine();
        if (typ >= vehicle.size()) {
            System.out.println("\tInvalid Input");
            Add_Vehicle();
            return;
        }

        //Show Vehicle in Type
        System.out.println("*****************************************");
        System.out.printf("%-6s %-15s %-10s %-20s", "S.NO", "VEHICLE NAME", "NUMBER", "STATUS");
        System.out.println();
        System.out.println("*****************************************");

        for (int i = 0; i < vehicle.get(typ).Vname.size(); i++) {
            System.out.format("%-6s %-15s %-10s %-20s", (i + 1), vehicle.get(typ).Vname.get(i), vehicle.get(typ).number.get(i), vehicle.get(typ).status.get(i));
            System.out.println();
        }

        System.out.println("******************************************");
        category= typ;
        System.out.print("Select The Reported Vehicle :");
        int Select=(sc.nextInt()-1);
        sc.nextLine();
        System.out.print("Input The Report :");
        String Rep=sc.nextLine();

        admin.Reports.add(new ArrayList<>(List.of(vehicle.get(category).Vname.get(Select), vehicle.get(category).number.get(Select),Rep)));
        System.out.println("Your Report Added Successfully");
        Renter_Choice();
    }


    //Date Block
    private static String BorrowDate() {
        int day = (int) (Math.random() * 31) + 1;
        int month = (int) (Math.random() * 12) + 1;
        int year = 2022;
        return day + "/" + month + "/" + year;
    }



    public static void main(String[] args){
       Home();
   }

}
