package Inheritance.Relationships.Projects.Amazon;

import java.util.*;
class Product {
    static ArrayList<String>name=new ArrayList<>();
    static ArrayList<String>Quantity=new ArrayList<>();
    static ArrayList<String>Des=new ArrayList<>();
    static ArrayList<Integer>Pri=new ArrayList<>();
    static ArrayList<String>war=new ArrayList<>();
    static ArrayList<String>ret=new ArrayList<>();
    static ArrayList<String>merchant=new ArrayList<>();
    static ArrayList<String>No_of=new ArrayList<>();
    static int i=0;

    private static Scanner sc=new Scanner(System.in);
    static String Product_Name;
    static String Product_Quantity;
    static String Description;
    static Integer Price;
    static String Warrenty_Periode;
    static String Return_Periode;
    static String merchant_Name;

    public Product(String Product_Nmae,String Product_Quantity,String Description,Integer Price,String Warrenty_Periode,String Return_Periode,String merchant){
        this.Product_Name=Product_Nmae;
        this.Product_Quantity=Product_Quantity;
        this.Description=Description;
        this.Price=Price;
        this.Warrenty_Periode=Warrenty_Periode;
        this.Return_Periode=Return_Periode;
        this.merchant_Name=merchant_Name;
    } 

    static void Product_add(int n){
        Boolean flag=true;
        // int i=0;
        while(flag){
        System.out.print("1 - Enter the Product Name :");
        Product_Name=sc.nextLine();
        name.add(i,Product_Name);
        System.out.print("2 - Enter the Product Quantity :");
        Product_Quantity=sc.nextLine();
        Quantity.add(i,Product_Quantity);
        System.out.print("3 - Enter the Product Description:");
        Description=sc.nextLine();
        Des.add(i,Description);
        System.out.print("4 - Enter the Product Price :");
        Price=sc.nextInt();
        Pri.add(i,Price);
        sc.nextLine();
        System.out.print("4 - Enter the Product Warranty Periode :");
        Warrenty_Periode=sc.nextLine();
        war.add(i,Warrenty_Periode);
        System.out.print("5 - Enter the Product Return Periode:");
        Return_Periode=sc.nextLine();
        ret.add(i,Return_Periode);
        merchant.add(i,Merchant.mer.get(n));
        System.out.print("6 - Enter the Another Product Yes Or No");
        String s=sc.nextLine();
        if(s.equalsIgnoreCase("Yes"))
            i++;
        else
           flag=false;
        }
    }

    static void View(int n){
        System.out.println("***Your Products***");
        String s=Merchant.mer.get(n);
        for(int i=0;i<merchant.size();i++){
            int m=0;
            // int x=merchant.indexOf(s);
            int j=0;
            if(s.equals(merchant.get(i))){
                System.out.println(i+1+" "+name.get(i));
                No_of.add(j,name.get(i));
                j++;
                continue;
            }
            if(No_of.size()==0){
                System.out.println("You Have No Product");
            }
            return ;
        }
    }

    static void Product_Remove(){
      System.out.println("***Your Products***");
      int j=1;
      for(int i=0;i<No_of.size();i++,j++){
          System.out.println(j+" "+No_of.get(i));
      }
      System.out.println("Enter the Remove Product Number");
      int x=sc.nextInt();
      String z=No_of.get(--x);
      int s=name.indexOf(z);
      boolean flag=true;
      while(flag){
      System.out.print("Enter CONFIRM :");
      sc.nextLine();
      String con=sc.nextLine();
      if(con.equalsIgnoreCase("CONFIRM")){
            name.remove(s);
            Quantity.remove(s);
            Des.remove(s);
            Pri.remove(s);
            war.remove(s);
            ret.remove(s);
            merchant.remove(s);
            No_of.remove(z);
            System.out.println("Your Product Remover Successfully");
            --i;
            flag=false;
            return ;

      }
      else{
          System.out.println("Enter CONFIRM Again :");
      }
    }
    }
}
