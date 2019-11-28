package availroom;

public class availrooms
{
    public static int[][] availroom = new int[6][10];
    public static int availflag=0;
    availrooms()
    {
        for(int z = 1 ; z<=5 ;z++)
        {
            for(int y = 1 ; y<=10 ; y++)
            {
                availroom[z][y] = 0;

            }
        }}

    public static void occupiedroom(int roomtype,int floor,int floorroom)
    {

        if(availroom[floor][floorroom]==0)
        {
            availflag=0;
            System.out.println("The room is available ...");
            availroom[floor][floorroom] = 1;
            System.out.println(" Room "+floor+"0"+floorroom+" is booked ...");
        }
        else
        {
            availflag=1;
            System.out.println("Sorry...The room is currently not available ...");
        }
    }

}