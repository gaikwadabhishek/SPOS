import java.io.*;
import java.util.*;

public class lru_code()
{
	int n,fsize,page_faults = 0, page_hits =0;
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of pages:");
	n = nextInt();
	HashSet<Integer> s = new HashSet<>(n);
	HashMap<Integer,Integer> indexes = new HashMap<>();
	int pages[] = new int[n];
	System.out.println("Enter the frame size:");
	fsize = sc.nextInt();
	System.out.println("ENter the string of pages:");
	for(int i=0;i<n;i++)
	{
		pages[i] = sc.nextInt();
	}
	`
}