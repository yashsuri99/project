import java.util.*;
import java.io.*;
import availroom.*;

class Hotel extends IDcheck {


    Scanner sc = new Scanner(System.in);
    String room[] = { "Single Room(Floors 1-3)", "Deluxe Room(Floors 4-5)" };
    String rate[] = { "999", "2999" };

    void viewRoom() {clearScreen();
        System.out.println("AVAILABLE ROOMS - ");
        int size = room.length;
        for (int i = 0; i < size; i++) {
            System.out.println(i + 1 + ". " + room[i]);
        }
    }


    void RoomBook() {
        String s;int floor,floorroom;
        System.out.println("Select Room Type");
        int c = sc.nextInt();
        if(c==1 || c==2)
        {
            while(true)
            { //clearScreen();
                System.out.println("Enter the floor number you want ...");
                floor = sc.nextInt();
                if(c==1 && (floor<=0 || floor>3))
                    System.out.println("Invalid input..");
                else if(c==2 && (floor<=3 || floor>5))
                    System.out.println("Invalid input..");
                else
                {System.out.println("\nEnter the room number(1-9) on the floor ...");
                    floorroom = sc.nextInt();
                    if(floorroom<0 || floorroom>9)
                    {  System.out.println("Invalid input..");}
                    else
                    {
                        availrooms.occupiedroom(c,floor,floorroom);
                        if(availrooms.availflag==0)
                        { s = room[c - 1];
                            writeToFile(s);
                            System.out.println("\n\nEnter No. of days for stay.");
                            int days = sc.nextInt();
                            s = ("Days of Stay = " + days);
                            writeToFile(s);
                            calculate(c - 1, days);
                            break;}
                    }
                }


            }}else{System.out.println("Invalid selection...");}

    }

    void calculate(int a,int d){
        String s;
        double rates = Double.parseDouble(rate[a]);
        System.out.println("Rate for 1 day : "+rates);
        double cost = rates * d;
        System.out.println("Total rate : "+cost);
        double discount = 0;
        s = ("Total Cost = " + cost);
        writeToFile(s);
        if (cost > 12000) {
            discount = 0.15 * cost;
            s = ("Discount Applied (15%)  = " + discount);
            writeToFile(s);
        }
        double gst = (0.18 * cost);
        s = ("GST APPLIED (18%) = " + gst);
        writeToFile(s);
        cost = cost + gst - discount;
        s = ("Final Amount = " + cost + "");
        writeToFile(s);
        s = ("************************************************");
        writeToFile(s);

    }

    void displayBill() {
        try {
            File f1 = new File(userID + ".txt");
            BufferedReader br = new BufferedReader(new FileReader(f1));
            String s;
            while ((s = br.readLine()) != null)
            {
                System.out.println(s);
            }
        }
        catch (Exception e)
        {
            System.out.println("Total cost :"+e);
        }

        File file = new File(userID + ".txt");

        if(file.delete())
        {
            System.out.println("\n\nP.S.File deleted successfully");
        }
        else
        {
            System.out.println("\n\nP.S.Failed to delete the file");
        }
    }

    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    void User()
    {
        clearScreen();
        Scanner sc = new Scanner(System.in);
        int reset = 1;
        while (reset == 1)
        {
            System.out.println("SELECT \n1.Registered User \n2.New User");
            int choice = sc.nextInt();
            if (choice == 1)
            {

                if (ID() == 0)
                {
                    reset = 0;
                    int ch=1,inout=1;
                    do
                    {
                        clearScreen();
                        System.out.println("SELECT \n1.Check In \n2.Check Out \n3.Food\n4.Room Service Request\n5.Exit");
                        inout=sc.nextInt();
                        if(inout==1)
                        {
                            do
                            {
                                viewRoom();
                                RoomBook();
                                System.out.println("\nEnter any number to exit or 1 to book another room ...");
                                ch=sc.nextInt();

                            }while(ch==1);
                        }
                        else if(inout==2)
                        {
                            displayBill();
                            System.out.println("\nPress any key...");
                            String enterkey=sc.next();
                        }

                        else if(inout==3)
                        {
                            Food();
                        }

                        else if(inout==4)
                        {
                            System.out.println("\nEnter room number for room service...");
                            int roomno=sc.nextInt();
                            System.out.println("\nRoom Service request placed Successfully..");
                            try
                            {System.out.println("\nOrder placed...");
                                Thread.sleep(3000);
                            }
                            catch(Exception e){}
                        }

                        else if(inout!=5)
                        {System.out.println("\nInvalid Selection");
                            System.out.println("\nPress any key...");
                            String enterkey=sc.next();
                        }

                    }while(inout!=5);
                }
                else
                {
                    System.out.println("press 1 to retry , 0 to continue");
                    reset = sc.nextInt();
                }
            }
            else if (choice == 2)
            {
                RegisterUser();
            }
        }

    }

    void Food()
    {
        int ch,qty;
        int temp = 0;
        int price = 0;
        do
        { clearScreen();
            System.out.println("Food Items available \n");
            System.out.println("1.Pasta  \t200");
            System.out.println("2.Pizza  \t350");
            System.out.println("3.Burger \t150");
            System.out.println("4.Tofu   \t200");
            System.out.println("5.Exit");
            System.out.println("\n\nEnter your choice...");
            ch = sc.nextInt();
            switch(ch)
            {
                case 1:{
                    System.out.println("Enter the quantity :");
                    qty = sc.nextInt();
                    temp = qty*200;
                    try
                    {System.out.println("\nOrder placed...");
                        Thread.sleep(2000);
                    }
                    catch(Exception e){}
                    break;
                }
                case 2:{
                    System.out.println("Enter the quantity :");
                    qty = sc.nextInt();
                    temp = qty*350;
                    try
                    {System.out.println("\nOrder placed...");
                        Thread.sleep(2000);
                    }
                    catch(Exception e){}
                    break;
                }
                case 3:{
                    System.out.println("Enter the quantity :");
                    qty = sc.nextInt();
                    temp = qty*150;
                    try
                    {System.out.println("\nOrder placed...");
                        Thread.sleep(2000);
                    }
                    catch(Exception e){}
                    break;
                }
                case 4:{
                    System.out.println("Enter the quantity :");
                    qty = sc.nextInt();
                    temp = qty*200;
                    try
                    {System.out.println("\nOrder placed...");
                        Thread.sleep(2000);
                    }
                    catch(Exception e){}
                    break;
                }
                case 5:break;
                default:try
                {System.out.println("Invalid input...");
                    Thread.sleep(2000);
                }
                catch(Exception e){}
            }
            price+=temp;
        }while(ch!=5);

        System.out.println("\nThe total bill is : " + price);
        System.out.println("\nEnter any key to go back to previous menu...");
        String s = sc.next();
    }

    public static void main(String args[])
    {
        Hotel obj = new Hotel();
        obj.User();

    }
}