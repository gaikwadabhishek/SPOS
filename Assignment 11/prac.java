import java.util.*;
import java.io.*;
public class prac {
	int req[],allo[][],max[][],need[][],n,m;
	boolean finp[],safe;
	int seq[], ind = 0;
	Scanner sc = new Scanner(System.in);
	public prac()
	{
		System.out.println("Enter the number of processes:");
		n = sc.nextInt();
		System.out.println("Enter the number of resources:");
		m = sc.nextInt();
		allo = new int[n][m];
		max = new int[n][m];
		avail = new int[n][m];
		fin = new int[n][m];
		seq = new int[n];

		System.out.println("Enter the MAX MATRIX:");
		for(int i = 0; i <n;i++)
		{
			for(int j=0;j<m;j++)
			{
				max[i][j] = sc.nextInt();
			}
		}
		System.out.println("Enter the AVAIL MATRIX:");
		for(int i = 0; i <n;i++)
		{
			avail[j] = sc.nextInt();
		}
		System.out.println("Enter the ALLOC MATRIX:");
		for(int i = 0; i <n;i++)
		{
			for(int j=0;j<m;j++)
			{
				allo[i][j] = sc.nextInt();
			}
		}
		need = new int[n][m];
		for(int i = 0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				need[i][j] = max[i][j] - allo[i][j];
			}
		}
		System.out.println("\n Need matix is :");
		for(int i = 0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(need[i][j]);
			}
			System.out.println("");
		}
		req = new int[m];

	}
	
}