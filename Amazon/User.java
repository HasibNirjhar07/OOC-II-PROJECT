import java.util.*;

class User {
     static ArrayList<String> Buyername = new ArrayList<>();
     static ArrayList<String> Buyerid = new ArrayList<>();
     static ArrayList<Integer> Id=new ArrayList<>();
     static ArrayList<String> cart=new ArrayList<>();
     static ArrayList<Integer> money=new ArrayList<>();
     static HashMap<Integer,ArrayList<String>> map=new HashMap<Integer,ArrayList<String>>();
     static Integer Ids=4;
     // Buyername.add("AAA");
     private static Scanner sc = new Scanner(System.in);

     void Display() {
          boolean flag = true;
          while (flag) {
               // System.out.println("\033[H\033[2J");
               // System.out.flush();
               setBuyername("");
               setBuyerid("");
               setId(-1);
               setmoney(-1);
               System.out.println("********Welcome User********");
               System.out.println("        1 - Sign in         ");
               System.out.println("        2 - Sign up        ");
               System.out.println("        3 - Exit            ");
               int b = sc.nextInt();
               sc.nextLine();
               switch (b) {
                    case 1:
                         Sign_in();
                         break;
                    case 2:
                         Sign_up();
                         break;
                    case 3:
                         System.out.println("*********Thank You********");
                         flag = false;
                         break;
                    default:
                         System.out.println("Invalid input");
               }

          }
     }

     public void setBuyername(String setBuyername) {
          Buyername.addAll(Arrays.asList("Aravind", "Nithish", "Hari", "Dinesh"));
          // if(!newUser.equals(""))Buyername.add(newUser);
     }

     public void setBuyerid(String setBuyerid) {
          Buyerid.addAll(Arrays.asList("1111", "2222", "3333", "4444"));
     }

     public void setId(Integer setId){
          Id.addAll(Arrays.asList(1,2,3,4));
     }

     public void setmoney(Integer setmoney){
          Id.addAll(Arrays.asList(100000,40000,55555,55555));
     }

     private void Sign_in() {
          System.out.println("***Welcome to Log in Page***");
          boolean flag=true;
          while(flag){
          System.out.print("Enter the User Name :");
          // sc.nextLine();
          String user = sc.nextLine();
          System.out.print("Enter the Password :");
          String pass = sc.nextLine();
          int c = Buyername.indexOf(user);
          if(Buyername.contains(user) && pass.equals(Buyerid.get(c))) {
              System.out.println("Welcome " + user);
              user_fun(c,c);
              flag=false;
          } 
          else if(Buyername.contains(user) && !pass.equals(Buyerid.get(c))){
              System.out.println("Password incorrect");
              System.out.println("Sign in Again");
          }
          else if(!Buyername.contains(user)) {
              System.out.println("User not exists");
              flag=false;
     }
   }
}

     public void Sign_up(){
         System.out.println("***Welcome to sign Up Page***");
         boolean flag=true;
         while(flag){
         System.out.print("Enter the New User Name :");
         String newUser=sc.nextLine();
         System.out.print("Enter the Password :");
         String newPass=sc.nextLine();
         System.out.println("Enter the Money");
         int x=sc.nextInt();
         if(Buyername.contains(newUser)){
               System.out.println("User name exists");
         }
         else{
              Buyername.add(newUser);
              Buyerid.add(newPass);
              Id.add(++Ids);
              money.add(x);
              System.out.println("***Account created Successfully***");
              flag=false;
         }
     }
   }

   public void user_fun(int n,int m){
        boolean flag=true;
        while(flag){
           System.out.println("***Welcome "+Buyername.indexOf(n)+"***");
           System.out.println("""
                       1 - Available Products
                       2 - Cart
                       3 - Buy
                       4 - Exit
                       Enter the input""");
          int a=sc.nextInt();
          switch(a){
               case 1:
                  Available(n,m);
               break;
               case 2:
                  cart(n,m);
               break;
               case 3:
                  Buy(n,m);
               break;
               case 4:
                    System.out.println("********Thank You********");
                    flag=false;
               default:
                    System.out.println("Invalid Input");
               break;
          }
      }
   }

   public static void Available(int n,int m){
       System.out.println("****Available Products");
       int j=1;
       for(int i=0;i<Product.name.size();i++){
            System.out.println(j+" "+Product.name.get(i));
            j++;
       }
     //   boolean flag=true;
     //   while(flag){
     //      System.out.println("Enter the Product name :");
     //      sc.nextLine();
     //      String z=sc.nextLine();
     //      if(Product.name.contains(z)){
     //           for(int i=0;i<Product.name.size();i++){
     //                if(Product.name.contains(i)){
     //                     flag=false;
     //                     // int x=Product.name.indexOf(i);
     //                     System.out.print("Product name :"+Product.name.get(i));
     //                     System.out.print("Product Quantity :"+Product.Quantity.get(i));
     //                     System.out.print("Product Description :"+Product.Des.get(i));
     //                     System.out.print("Price :"+Product.Pri.get(i));
     //                     System.out.print("Product Warrenty Periode :"+Product.war.get(i));
     //                     System.out.print("Product Return Periode :"+Product.ret.get(i));
     //                }
     //                else{
     //                     return ;
     //                }
     //           }
     //      }
     //      else{
     //         System.out.println("***Product Not Available***");
     //         flag=false;
     //      } 
      Boolean f=true;
      while(f){
           System.out.println("Would you Like to Buy Product");
           System.out.println("Enter Yes OR No");
           sc.nextLine();
           String z=sc.nextLine();
           if(z.equalsIgnoreCase("Yes")){
                Boolean fl=true;
                while(fl){
                    System.out.println("Enter the Product name :");
                    String x=sc.nextLine();
                    if(Product.name.contains(x)){
                        int y=Product.name.indexOf(x);
                        System.out.println(Product.name.get(y));
                        System.out.println(Product.Pri.get(y));
                        System.out.print("Add to cart,Enter Yes OR No :");
                        String ye=sc.nextLine();
                        if(ye.equalsIgnoreCase("Yes")){
                             int i=0;
                             System.out.println("Your Product Added Successfully");
                             cart.add(i,Product.name.get(y));
                             map.put(m,cart);
                             i++;
                             fl=false;
                        }

                    }
                    else{
                        System.out.println("Product Not Found");
                        fl=false;
                    }
               }
           }

           else{
                f=false;
           }
      }
     }

   public static void cart(int n,int m){
        boolean flag=true;
        while(flag){
             System.out.println("***Welcome to Cart***");
             System.out.println("   1 - view cart     ");
             System.out.println("   2 - Remove Product");
             System.out.println("   3 - Clear Cart    ");
             System.out.println("   4 - Check Out     ");
             System.out.println("   5 - Exit          ");
             System.out.println("Enter the Choice");
             int c=sc.nextInt();
             switch(c){
                  case 1:
                    System.out.println("***Your Cart");
                    System.out.println(map.get(m));
                  break;
                  case 2:
                    System.out.println("Which Product You want to Remove");
                    sc.nextLine();
                    String r=sc.nextLine();
                    cart.remove(r);
                    map.put(m,cart);
                  break;
                  case 3:
                     System.out.println("Whould You Like To Clear The Cart, Enter the Yes Or No");
                     sc.nextLine();
                     String x=sc.nextLine();
                     if(x.equalsIgnoreCase("Yes")){
                          cart.clear();
                          map.put(m,cart);
                     }
                     else{
                          System.out.println("Your Produsts Will Be In Your Cart");
                     }
                  break;
                  case 4:
                    if(cart.size()!=0){
                           int total=0;
                           for(int i=0;i<cart.size();i++){
                                String q=cart.get(i);
                                int v=Product.name.indexOf(q);
                                int to=Product.Pri.get(v);
                                total+=to;
                           }
                           if(money.get(m)<total){
                                System.out.println("Low Balence ");
                           }
                           else{
                                System.out.println("Order Placed Successfully");
                           }
                      }
                      else{
                           System.out.println("Your cart is Empty");
                      }
                  break;
                  case 5:
                     flag=false;
                  break;
                  default:
                    System.out.println("Invalid Input");
                  break;
             }
        }
         
   }

   public static void Buy(int n,int m){
        Boolean flag=true;
        while(flag){
        System.out.println(map.get(m));
        System.out.print("Enter the Name of The Product :");
        sc.nextLine();
        String S=sc.nextLine();
        int k=Product.name.indexOf(S);
        System.out.println("Price Of The Product :"+Product.Pri.get(k));
        System.out.println("Would You Like To Buy This Product :");
        String p=sc.nextLine();
        if(p.equalsIgnoreCase("Yes")){
             if(Product.Pri.get(k)<money.get(k)){
                  System.out.println("Order Placed Successfully");
             }
             else{
                  System.out.println("Insufficiend Funds");
             }
        }
        else{
             System.out.println("Order it Another Time");
        }
     }
   }
}
