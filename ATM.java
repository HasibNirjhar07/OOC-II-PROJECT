import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int total = 0;
    public static ArrayList<Integer> money=new ArrayList<>();
    private static int bal[]={40000,50000,60000};
    private static int with=0;
    private static int x[]={1234,5678,1357};
    private static String User[]={"User","NUser","NNUser"};
    private static int id[]={1,1,2};
    private static ArrayList<String> mini=new ArrayList<>();

    public static void main(String[] args) {

        boolean flag = true;
        while (flag) {
            // System.out.println("\033[H\033[2J");
            // System.out.flush();
            System.out.println("1.ADMIN");
            System.out.println("2.USER");
            System.out.println("3.EXIT");
            System.out.println("Enter Your Choice:");
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    admin();
                    break;
                case 2:
                    user();
                    break;
                case 3:
                    System.out.println("Thank you for using");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }


    static void cash() {
        int a[] = { 2000, 500, 200, 100 };
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter the number of " + a[i] + ":");
            int n = sc.nextInt();
            arr.add(n);
            total += a[i] * arr.get(i);
        }
        System.out.println(total);
    }


    static void check() {
        System.out.println(arr);
    }


    public static void admin() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter the admin name: ");
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println("Enter the Pin: ");
        int x = sc.nextInt();
        if (s.equals("Aravindh") && x == 123456) {
            boolean flag = true;
            while (flag) {
                System.out.println("Hello Admin");
                System.out.println("Admin actions");
                System.out.println("1 - Addcash");
                System.out.println("2 - CashCheck");
                System.out.println("3 - Exit");
                System.out.println("Enter the Action: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        cash();
                        break;
                    case 2:
                        check();
                        break;
                    case 3:
                        flag = false;
                        break;
                }
            }
        } else if (s.equals("Admin") && x == 7891011) {
            boolean flag = true;
            while (flag) {
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("Hello Admin");
            System.out.println("Admin actions");
            System.out.println("1 - Addcash");
            System.out.println("2 - Exit");
            System.out.println("Enter the Action: ");
            int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        cash();
                        break;
                    case 2:
                        check();
                        break;
                    case 3:
                        flag = false;
                        break;
                }
            }
        } else {
            System.out.println("Invalid admin user or password");
            System.out.println("Try again");
        }
    }


    static void withdraw(int i){
        boolean flag=true;
        while(flag){
        System.out.println("Enter the amount");
        int amount=sc.nextInt();
        with=amount;
        if(amount<total && bal[i]>amount||total==amount){
           int m=amount/2000;
           int n=amount%2000;
           money.add(m);
           int x=n/500;
           int l=n%500;
           money.add(x);
           int y=l/200;
           int g=l%200;
           money.add(y);
           int z=g/100;
           money.add(z);
           System.out.println(money);
           flag=false;
           System.out.println("Amount withdraw :"+amount);
           mini.add("Amount withdraw :"+amount);

        }
        else if(amount>total){
            System.out.println("Insufficient Funds");
            System.out.println("Enter the Amount Again");
        }
        else if (bal[i]<amount){
          System.out.println("Insuffient Balance");
          System.out.println("Enter the Amount Again");
        }
      }
    }


    static void Pin(int i){
        System.out.println("Enter the new Pin");
        int m=sc.nextInt();
        System.out.println("Type CONFIRM");
        sc.nextLine();
        String s=sc.nextLine();
        if(s.equals("CONFIRM")){
            x[i]=m;
            System.out.println("pin changet Successfuly");
            mini.add("pin changet Successfuly");
        }
    }


    static void Balance(int i){
         System.out.println("Balnce Amount is :" +(bal[i]-with));
         mini.add("Balance Checked :"+(bal[i]-with));
    }


    static void MoneyTrans(int i){
      System.out.println("Enter the user Name");
      sc.nextLine();
      String s=sc.nextLine();
      int ind=-1;
      for(int j=0;j<3;j++){
          if(s.equals(User[j]))
          ind=j;
        }
        if(ind==-1){
          System.out.println("User does not exits");
        }
        else{
          boolean flag=true;
          while(flag){
          System.out.println("Enter the amount");
          int am=sc.nextInt();
          if(am<bal[i]){
              if(id[i]!=id[ind]){
                  System.out.println("User id is another Bank");
                  bal[ind]=bal[ind]+am;
                  System.out.println("Money transfered successfully");
                  double m=am*0.05;
                  bal[i]=(int) (bal[i]-(am+m));
                  mini.add("Money transfered Successfuly "+User[i]+"To"+User[ind]);
                  mini.add("Tax is"+m);
                  flag=false;
              }
              else{
                  bal[ind]=bal[ind]+am;
                  System.out.println("Money transfered successfully");
                  mini.add("Money transfered Successfuly "+User[i]+"To"+User[ind]);
                  bal[i]=bal[i]-am;
                  flag=false;
              }
          }
          else{
            System.out.println("Insufficient Amount");
          }
        }
     }
  }


  static void Dp(int i){
      System.out.println("Enter the depoist Amount");
      int amo=sc.nextInt();
      bal[i]+=amo;
      mini.add("Deposite Amount is :"+amo+"Now Balance is :"+bal[i]);
  }


  static void Mini(int i){
     System.out.println(mini);
  }

    public static void user(){
    System.out.println("Enter the Username");
    sc.nextLine();
    String s=sc.nextLine();
    if(s.equals(User[0])){
        Boolean flag=true;
        int count=1;
        while(flag){
        if(count>3){
            System.out.println("Account is temporarily Blocked..........");
            return;
        }
        count++;
        System.out.println("Enter the Password");
        int n=sc.nextInt();
        int i=0;
        if(n==x[i]){
        boolean fl=true;
        while(fl){
            flag=false;
         System.out.println("Welcome User");
         System.out.println("1 - Withdraw");
         System.out.println("2 - Balance");
         System.out.println("3 - PinChange");
         System.out.println("4 - Money transfer");
         System.out.println("5 - Depoists");
         System.out.println("6 - MiniReport");
        System.out.println("7 - Exit");
        System.out.println("Enter the choice");
        int c=sc.nextInt();
        switch(c){
            case 1:
              withdraw(i);
            break;
            case 2:
              Balance(i);
            break;
            case 3:
              Pin(i);
            break;
            case 4:
              MoneyTrans(i);
            break;
            case 5:
              Dp(i);
            break;
            case 6:
              Mini(i);
            break;
            case 7:
              fl=false;
          }
        }
      }
      else{
          System.out.println("Password Missmatch, Try again");
      }
    }
}
      else if(s.equals(User[1])){
        int i=1;
        boolean flag=true;
        int count=1;
        while(flag){
        if(count>3){
            System.out.println("Account is temporarily Blocked..........");
            return;
        }
          while(flag){
          System.out.println("Enter the Password");
          int n=sc.nextInt();
          if(n==x[i]){
        boolean fl=true;
        while(fl){
        flag=false;
         System.out.println("Welcome User");
         System.out.println("1 - Withdraw");
         System.out.println("2 - Balance");
         System.out.println("3 - PinChange");
         System.out.println("4 - Money transfer");
         System.out.println("5 - Depoists");
         System.out.println("6 - MiniReport");
        System.out.println("7 - Exit");
        System.out.println("Enter the choice");
        int c=sc.nextInt();
        switch(c){
            case 1:
              withdraw(i);
            break;
            case 2:
              Balance(i);
            break;
            case 3:
              Pin(i);
            break;
            case 4:
              MoneyTrans(i);
            break;
            case 5:
               Dp(i);
            break;
            case 6:
               Mini(i);
            break;
            case 7:
              fl=false;
        }
    }
}
else{
    System.out.println("Password Missmatch, Try again");
      }
    }
   }
}
    else{
     System.out.println("User does not exists");
   }
  }
}
