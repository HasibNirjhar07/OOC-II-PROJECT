import java.util.*;
class Admin {
    static ArrayList<String>Rej=new ArrayList<>(); 
    public static Scanner sc=new Scanner(System.in);
    Merchant m;
    void Display(){
        System.out.println("****Welcome Admin****");
        String id="admin";
        String pass="1234";
        System.out.print("Enter the Name :");
        String n=sc.nextLine();
        boolean flag=true;
        while(flag){
            System.out.print("Enter the password :");
            String m=sc.nextLine();
            if(n.equals(id) && !m.equals(pass)){
                System.out.println("Ircorrect password");
                System.out.println("Try Again");
            }
            else if(n.equals(id) && m.equals(pass)){
                 mainadmin();
                 flag=false;
            }
        }
    }

    public void mainadmin(){
            boolean flag=true;
            while(flag){
            System.out.println("***Welcome Admin***");
            System.out.println("   1 - Add Merchant    ");
            System.out.println("   2 - Remove Merchant    ");
            System.out.println("   3 - Approve Merchant    ");
            System.out.println("   4 - Exit    ");
            System.out.print("Enter Your Choice :");
            int x=sc.nextInt();
            switch(x){
                    case 1:
                        add();
                    break;
                    case 2:
                        remove();
                    break;
                    case 3:
                        Approve();
                    break;
                    case 4:
                        System.out.println("Thank you Admin");
                        flag =false;
                    break;
                    default:
                        System.out.println("Invalid input");
                    break;
                }
            }
        }

    void add(){

            System.out.print("Enter the Merchant Name :");
            sc.nextLine();
            String y=sc.nextLine();
            boolean flag=true;
            while(flag){
            if(!Merchant.mer.contains(y)){
            m.mer.add(y);
            System.out.print("Enter the PassWord :");
            String z=sc.nextLine();
            m.pass.add(z);
            System.out.println("Merchant Added Successfully");
            flag=false;
            }
        }
    }


    void remove(){
        System.out.print("Enter the Merchant Name :");
        sc.nextLine();
        String z=sc.nextLine();
        boolean flag=true;
        while(flag){
            if(!Merchant.mer.contains(z)){
                System.out.println("Merchant name does not exists");
            }
            else if(Merchant.mer.contains(z)){
                int o=Merchant.mer.indexOf(z);
                Merchant.mer.remove(z);
                Merchant.pass.remove(o);
                System.out.println("Merchant Removed Successfully");
                flag=false;
            }
        }
    }


    void Approve(){
          if(m.newMer.size()==0){
              System.out.println("No new Merchant");
          }
          else{
          for(int i=0;i<m.newMer.size();i++){
             System.out.println("Merchant "+m.newMer.get(i)+"Need to Approwed");
             System.out.println("approve OR Reject");
             sc.nextLine();
             String s=sc.nextLine();
             if(s.equalsIgnoreCase("Approve")){
              m.mer.add(m.newMer.get(i));
              m.pass.add(m.newpass.get(i));
              m.newMer.remove(i);
              m.newpass.remove(i);
              System.out.println("Merchant Approved");
              return ;
             }
             else{
                 System.out.println("Merchant Rejected");
                Rej.add(m.newMer.get(i));
                m.newMer.remove(i);
                m.newpass.remove(i);
                return ;
             }
          }
        }
    }
}
