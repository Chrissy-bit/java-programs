import java.io.*;
class Rearrange
{
    InputStreamReader isr=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(isr);

    int Arr[];
    int N;
    //default constructor to initialize data members 
    Rearrange()
    {
        N=0;
        Arr=new int[N];
    }
    //to enter size of array followed by array elements
    void enter() throws IOException
    {
        System.out.print("Enter size of array: ");
        N=Integer.parseInt(br.readLine());
        System.out.println("Enter "+N+" elements: ");

        Arr= new int[N];

        for(int i=0;i<Arr.length;i++)
        {
            Arr[i]= Integer.parseInt(br.readLine());
        }
    }
    //to display array elements
    void display()
    {
        for(int i=0;i<N;i++)
        {
            System.out.println(Arr[i]);
        }
    }
    //to insert an item at a specified position in the array
    void insert(int p, int item) throws IOException
    {
        if(p>N)
        {
            System.out.println("Invaid Position"); //error if insert position exceeds array length
        }
        else
        {
            N++;
            for(int k=N;k<p-1;k--)
            {
                Arr[k]=Arr[k-1];
            }
            Arr[p-1]=item;
        }
    }
    //to delete an item at specified position from the array
    void remove(int p) throws IOException
    {
        if(p<0 || p>N)
        {
            System.out.println("Invalid Position"); //error if item position doesn't exists/ exceeds array length
        }
        else
        {
            N--;
            for(int m=p-1;m<N;m++)
            {
                Arr[m]=Arr[m+1];
            }
        }
    }
}

/*void main() throws IOException
{
Rearrange ob=new Rearrange();
ob.enter();

System.out.print("Enter position of element to delete: ");
int pos1=Integer.parseInt(br.readLine());
ob.remove(pos1);
System.out.println("\nARRAY AFTER DELETION: "); 
ob.display();

System.out.print("Enter element to insert: ");
int insert=Integer.parseInt(br.readLine());

System.out.print("Enter its position: ");
int pos=Integer.parseInt(br.readLine());
ob.insert(pos,insert);
System.out.println("\nARRAY AFTER INSERTION: "); 
ob.display();

}
}*/
