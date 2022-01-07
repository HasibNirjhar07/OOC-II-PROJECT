package Inheritance.Relationships.Projects.Amazon;
import java.util.*;
class Merchant {
    static ArrayList<String>mer=new ArrayList<>();
    static ArrayList<String>pass=new ArrayList<>();
    static ArrayList<String>newMer=new ArrayList<>();
    static ArrayList<String>newpass=new ArrayList<>();
    Admin a;
    // Product p=new Product();

    private static Scanner sc=new Scanner(System.in);
    void Display(){
        setMer("");
        setPass("");
        boolean flag=true;
        while(flag){
        System.out.println("****Welcome to Merchant Page****");
        System.out.println("       1 - Existing Merchant     ");
        System.out.println("       2 - New Merchant          ");
        System.out.println("       3 - Exit                  ");
        System.out.print("Enter Your Choice :");
        int n=sc.nextInt();
            switch(n){
                case 1:
                  merch();
                break;
                case 2:
                  newMer();
                break;
                case 3:
                System.out.println("Thank you for Using");
                flag=false;
                break;
            }
        }

    }

    public void setMer(String setMer) {
        mer.addAll(Arrays.asList("A", "B", "C", "D"));
    }

    public void setPass(String setPass) {
        pass.addAll(Arrays.asList("1111", "2222", "3333","4444"));
    }

    public void merch(){
        System.out.println("***Welcome to login page***");
        boolean flag=true;
        while(flag){
        System.out.print("Enter the MerchantName :");
        sc.nextLine();
        String m=sc.nextLine();
        System.out.print("Enter the password :");
        String n=sc.nextLine();
        int c=mer.indexOf(m);
        if(!mer.contains(m)&& !a.Rej.contains(m)){
            System.out.println("User does not Exists");
        }

        else if(mer.contains(m) && !n.equals(pass.get(c))){
            System.out.println("Password incorrect");
            System.out.println("Sign in Again");
        }
        else if(mer.contains(m) && n.equals(pass.get(c))){
            System.out.println("Welcome Merchant");
            merchantUser(m);
            flag=false;
        }
        else if(a.Rej.contains(m)){
           System.out.println("Your Account Rejected By Admin");
           flag=false;
        }
    }
  }

    public void newMer(){
            boolean flag=true;
            while(flag){
            System.out.print("Enter the Merchat Name :");
            sc.nextLine();
            String s=sc.nextLine();
            System.out.print("Enter the Password :");
            String p=sc.nextLine();
            if(mer.contains(s)){
                System.out.println("User name Exists,Enter Again");
            }
            else{
                newMer.add(s);
                newpass.add(p);
                System.out.println("Need to approwed by Admin");
                flag=false;
            }
        }
    }

   public void merchantUser(String n){
      boolean flag=true;
      while(flag){
            System.out.println("""
                   ***Welcome Merchant***
                      1 - Product Add
                      2 - Product Remove
                      3 - View Product
                      4 - Exit""");
            System.out.print("Enter the Choice :");
            int x=sc.nextInt();
            switch(x){
                case 1:
                    Product.Product_add(mer.indexOf(n));
                break;
                case 3:
                    Product.View(mer.indexOf(n));
                break;
                case 2:
                    Product.Product_Remove();
                break;
                case 4:
                   System.out.println("***Thank You For Using***");
                   flag=false;
                break;
                default:
                System.out.println("Invalid Input");
                break;
            }
          
      }
    }

public void setMer(int i) {
}
}
