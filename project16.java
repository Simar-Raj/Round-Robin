import java.util.*;
public class project16 {
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int i,j,k,qunt,sum=0;
        System.out.print("Enter the  number of process:=");
        int num=scan.nextInt();
        int burst[]=new int[ num];
        int waiting[]=new int[ num];
        int  turnaround[]=new int[ num];
        int arrival[]=new int[ num];
        int remain[]=new int[num];
        for(i=0;i<num;i++)
        {
            System.out.print("Enter Arrival Time for Process ["+(i+1)+"]=");
            arrival[i]=scan.nextInt();
            System.out.print("Enter burst Time for Process ["+(i+1)+"]=");
            scan.nextLine();
            burst[i]=scan.nextInt();

        }

        System.out.print("\nEnter Time quantum:=");
        qunt=scan.nextInt();
        for (i=0;i<num;i++)
        {
            remain[i]=burst[i];
        }
        for(i=0;i< num;i++)
            waiting[i]=0;
        do
        {
            for(i=0;i< num;i++)
            {
                if(remain[i]>qunt)
                {
                    remain[i]=remain[i]-qunt;
                    for(j=0;j< num;j++)
                    {
                        if((j!=i)&&(remain[j]!=0))
                            waiting[j]+=qunt;
                    }
                }
                else
                {
                    for(j=0;j< num;j++)
                    {
                        if((j!=i)&&(remain[j]!=0))
                            waiting[j]+=remain[i];
                    }
                    remain[i]=0;
                }
            }
            sum=0;
            for(k=0;k< num;k++)
                sum=sum+remain[k];
        }while(sum!=0);
        for(i=0;i< num;i++)
             turnaround[i]=waiting[i]+burst[i];
        System.out.println("Name\t\tArrival\t\tburst\t\twaiting\t\t turnaround");
        for(i=0;i<num;i++)
        {
            System.out.println("process["+(i+1)+"]\t"+arrival[i]+"\t\t"+burst[i]+"\t\t"+waiting[i]+"\t\t"+ turnaround[i]);
        }
        float Average_waiting=0;
        float Average_turnaround=0;
        for(j=0;j< num;j++)
        {
            Average_waiting+=waiting[j];
        }
        for(j=0;j< num;j++)
        {
            Average_turnaround+= turnaround[j];
        }
        System.out.println("Average Waiting Time ="+(Average_waiting/ num));
        System.out.println("Average Turnaround Time="+(Average_turnaround/ num));
    }
}