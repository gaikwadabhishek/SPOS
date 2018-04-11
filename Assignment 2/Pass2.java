import java.util.*;
import java.io.*;

class Lit
{
	String literal;
	int addr;
	Lit(String l,int a2)
	{
		literal=l;
		addr=a2;
	}
}
class Sym
{
	String sname;
	int addr;
	int len;
	Sym(String s1,int a1,int l1)
	{
		sname=s1;
		addr=a1;
		len=l1;
	}
}
class Pass2
{
	public static void main(String args[])throws Exception
	{
		int loc=0,sindex=0,lindex=0;
		boolean flag=false;
		Lit LArray[]=new Lit[20];
		Sym SArray[]=new Sym[20];
		Scanner sc=new Scanner(System.in);
		int lno,sno,len,addr,addr1;
		String nm1;
		System.out.println("How many symbols to be entered??");
		sno=sc.nextInt();


		for(int i=0;i<sno;i++)
		{
			System.out.println("Enter Symbol_name ,Symbol_address ,Symbol_length");
			String nm=sc.next();
			addr=sc.nextInt();
			len=sc.nextInt();
			SArray[i]=new  Sym(nm,addr,len);
			sindex++;
		}
		System.out.println("How many Literals to be entered??");
		lno=sc.nextInt();

		for(int i=0;i<lno;i++)
		{
			System.out.println("Enter name & ,address");
			nm1=sc.next();
			addr1=sc.nextInt();
			LArray[i]=new  Lit(nm1,addr1);
		}

		HashMap<Integer,String> POT=new HashMap<Integer,String>();
		POT.put(1,"START");
		POT.put(2,"END");
		POT.put(3,"ORIGIN");
		POT.put(4,"EQU");
		POT.put(5,"LTORG");
		POT.put(6,"DS");
		POT.put(7,"DC");


		FileReader fr=new FileReader("abc.txt");
        BufferedReader br=new BufferedReader(fr);
        String CurrentLine,val;
		int v,v1,v2,v3;
		while ((CurrentLine = br.readLine()) != null)
		{
			String s[]=CurrentLine.split("	");
			/*for(int i=0;i<s.length;i++)
			{
				System.out.print(s[i]+"\t");
			}*/
			System.out.println();
			if(s[0].equals("AD"))
			{
				v=Integer.parseInt(s[1]);
				val=POT.get(v);
				//System.out.println("	"+val);
				if(val.equals("START"))
				{
					if(s[3]!=null)
					{
						loc=Integer.parseInt(s[3]);
					}
					else
					{
						System.out.println(v+"	"+loc);
					}
				}
				else if(val.equals("END"))
				{
					System.out.println(loc+")	"+v);
					loc++;
				}
				else if(val.equals("DS"))
				{
					System.out.println(loc+")	"+v);
					loc=loc+(Integer.parseInt(s[3]));
					//System.out.println(loc+")	"+v);
					//loc++;
				}
				else if(val.equals("DC"))
				{
					int a1=Integer.parseInt(s[3]);
					System.out.println(loc+")	"+"00 00 0"+a1);
					loc++;
				}
			}
			else if(s[0].equals("IS"))
			{
				//System.out.println("Hello	");
				v1=Integer.parseInt(s[1]);
				v2=Integer.parseInt(s[2]);
				v3=Integer.parseInt(s[4]);
				int v4=v3-1;
				if(s[3].charAt(0)=='S')
				{
					int a=SArray[v4].addr;
					System.out.println(loc+")	"+v1+"	"+v2+"	"+a);
					loc++;
				}
				else
				{
					int a=LArray[v4].addr;
					System.out.println(loc+")	"+v1+"	"+v2+"	"+a);
					loc++;
				}
			}


		}
	}
}
/*How many symbols to be entered??
3
Enter Symbol_name ,Symbol_address ,Symbol_length
A
222
3
Enter Symbol_name ,Symbol_address ,Symbol_length
B
223
1
Enter Symbol_name ,Symbol_address ,Symbol_length
C
224
2
How many Literals to be entered??
1
Enter name & ,address
=7
225


200)    1       1       222

201)    2       1       223

202)    3       1       224

203)    1       1       225

204)    6

209)    00 00 02

210)    2
Press any key to continue . . .
*/
