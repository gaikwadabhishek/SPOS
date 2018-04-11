import java.util.*;

public class Scheduling
{
	static int no_of_process;
	static int proc_no[] = new int[15];
	static int burst_time[] = new int[15];

	public static void fcfs()
	{
		int waiting_time = 0;
		int t_time ;
		burst_time[0] = 0;

		System.out.println("Process\t Burst time \t Waiting Time\t TAT");
		for(int i=1;i<=no_of_process;i++)
		{
			waiting_time = waiting_time+burst_time[i-1];
			t_time = waiting_time+burst_time[i];
			System.out.println(proc_no[i]+"\t"+burst_time[i]+"\t"+waiting_time + "\t" + t_time +"\n");

		}
	}

	public static void SJF()
	{
		int temp,temp1;
		int proc_no1[] = new int[15];
		int burst_time1[] = new int[15];

		for(int i=1;i<no_of_process;i++)
		{
			proc_no1[i] = proc_no[i];
			burst_time1[i] = burst_time[i];

		}

		for (int i=1;i<=no_of_process-1;i++)
		{
			for(int j=1;j<=no_of_process-1;j++)
			{
				if(burst_time1[j]>burst_time1[j+1])
				{
					temp = burst_time[j+1];
					temp1 = proc_no1[j+1];
					burst_time1[j+1]=burst_time1[j];
					proc_no1[j+1] = proc_no1[j];
					proc_no1[j] = temp1;
					burst_time1[j] = temp;

				}
			}
		}

		int waiting_time = 0;
		int t_time;
		burst_time1[0] = 0;
		System.out.println("Process\t Burst time \t Waiting Time\t TAT");
		for(int i=1;i<=no_of_process;i++)
		{
			waiting_time = waiting_time+burst_time[i-1];
			t_time = waiting_time+burst_time[i];
			System.out.println(proc_no1[i]+"\t"+burst_time1[i]+"\t"+waiting_time + "\t" + t_time +"\n");

		}
	}

	static void priority()
	{
		Scanner sc = new Scanner(System.in);
		int pr1[]=new int[15];
		int temp,temp1;
		int proc_no1[] = new int[15];
		int burst_time1[] = new int[15];

		for(int i=1;i<no_of_process;i++)
		{
			proc_no1[i] = proc_no[i];
			burst_time1[i] = burst_time[i];

		}

		for(int i=0;i<no_of_process;i++)
		{
			System.out.println("priority of "+proc_no[i] + " :");
			pr1[i] = sc.nextInt();
			System.out.println();
		}

		for (int i=1;i<=no_of_process-1;i++)
		{
			for(int j=1;j<=no_of_process-1;j++)
			{
				if(pr1[j]>pr1[j+1])
				{
					temp = burst_time[j+1];
					temp1 = proc_no1[j+1];
					burst_time1[j+1]=burst_time1[j];
					proc_no1[j+1] = proc_no1[j];
					proc_no1[j] = temp1;
					burst_time1[j] = temp;

				}
			}
		}
		int waiting_time = 0;
		int t_time;
		burst_time1[0] = 0;
		System.out.println("Process\t Burst time \t Waiting Time\t TAT");
		for(int i=1;i<=no_of_process;i++)
		{
			waiting_time = waiting_time+burst_time[i-1];
			t_time = waiting_time+burst_time[i];
			System.out.println(proc_no1[i]+"\t"+burst_time1[i]+"\t"+waiting_time + "\t" + t_time +"\n");

		}

	}
	static void RR()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Quantum:");
		int quantum = sc.nextInt();

		int rem_bt[] = new int[no_of_process+1];
		int wt[] = new int[no_of_process+1];

		for(int i=1;i<=no_of_process;i++)
		{
			rem_bt[i] = burst_time[i];
		}

		int t = 0;
		int t_time;

		while(true)
		{
			boolean done = true;
			for(int i=1;i<no_of_process;i++)
			{
				if (rem_bt[i]>0)
				{	
					if (rem_bt[i]>quantum)
					{
						t+=quantum;
						rem_bt[i] -= quantum;

					}
					else
					{
						t = t+rem_bt[i];
						wt[i] = t - burst_time[i];
						rem_bt[i] = 0;
					}
				}
			}
			if(done == true)
			break;

		}
		System.out.println("Process\t Burst time \t Waiting Time\t TAT");
		for(int i=1;i<=no_of_process;i++)
		{
			
			t_time = wt[i]+burst_time[i];
			System.out.println(proc_no[i]+"\t"+burst_time[i]+"\t"+wt[i] + "\t" + t_time +"\n");

		}
		
	}



	public static void main(String args[])
	{   
		int choice,choice1;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of processors"+"\n");
		no_of_process=sc.nextInt();
		
		for (int i=1;i<=no_of_process;i++)
		{
			System.out.println("Enter Process no: ");
			proc_no[i]=sc.nextInt();
			System.out.println("Enter burst time: ");
			burst_time[i]=sc.nextInt();
			
		}
		do{
		System.out.println("   Sheduling Algorithms"+"\n");
		System.out.println("1.FCFS"+"\n"+"2.SJF"+"\n"+"3.Priority"+"\n"+"4.RR"+"\n"+"5.Exit"+"\n");
		System.out.println("enter your choice: ");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:fcfs();
				break;
		case 2:SJF();
		       break;
		case 3:priority();
		       break;
		case 4:RR();
			   break;
	
		case 5:System.exit(0);
		       break;
		}
		
		}while(choice!=6);
		
	}

}