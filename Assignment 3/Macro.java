import java.util.*;
import java.io.*;
class MNT
{
	String mname;
	int MDTindex;
	MNT(String m,int i)
	{
		mname=m;
		MDTindex=i;
	}
}
class Macro
{
	public static void main(String args[])throws Exception
	{
		MNT MNTArray[]=new MNT[10];
		String ALA[]=new String[10];
		String MDT[]=new String[30];
		int mntp=0,mdtp=0,alap=0;
		FileReader fr=new FileReader("input.txt");
		FileWriter fw=new FileWriter("output.txt");
       	BufferedReader br=new BufferedReader(fr);
        	String CurrentLine,l1;
		while ((CurrentLine = br.readLine()) != null)
		{
			String s[]=CurrentLine.split("	");

			if(s[0].equals("MACRO"))
			{
				String nl=br.readLine();
				String tkn[]=nl.split("	");

				MNTArray[mntp]=new MNT(tkn[0],mdtp);
				mntp++;
				StringBuilder str = new StringBuilder(tkn[0]);
				for(int i=1;i<tkn.length;i++)
				{
					ALA[alap]=tkn[i];
					str.append(" #"+alap);
					alap++;
				}
				MDT[mdtp]=str.toString();
				mdtp++;
				while (!(l1= br.readLine()).equals("MEND"))
				{
					int k=-1;
					String tkn1[]=l1.split("	");
					StringBuilder s1=new StringBuilder(tkn1[0]+"	"+tkn1[1]);
					for(int i=0;i<tkn1.length;i++)
					{

						if(tkn1[i].charAt(0)=='&')
						{
							for(int j=0;j<alap;j++)
							{
								if(tkn1[i].equals(ALA[j]))
								{
									k=j;
									break;
								}
							}
						}


					}
					s1.append(" #"+k);
					MDT[mdtp]=s1.toString();
					mdtp++;
				}
					MDT[mdtp]="MEND";
					mdtp++;

			}
			else
			{
				System.out.println(CurrentLine);
				fw.write(CurrentLine+"\n");
			}
		}
		System.out.println();
		System.out.println("MDT TABLE.......................");
		System.out.println("MDTIndex\tInstruction");
		for(int i=0;i<mdtp;i++)
		{
			System.out.println(i+"\t\t"+MDT[i]);

		}

				System.out.println();
				System.out.println("ALA TABLE.......................");
				System.out.println("ALAIndex\tArgument");
				for(int i=0;i<alap;i++)
				{
					System.out.println(i+"\t\t"+ALA[i]);

		}

				System.out.println();

				System.out.println("MNT TABLE.........................");
				System.out.println("Index\tMNTName\tMDTIndex");
				for(int i=0;i<mntp;i++)
				{
					System.out.println(i+"\t"+MNTArray[i].mname+"\t"+MNTArray[i].MDTindex+"\n");

				}
		fw.close();
		fr.close();
	}
}
/*Output:
pccoe@ubuntu:~$ javac Macro.java
pccoe@ubuntu:~$ java Macro
START	200
MOVER	AREG	1

MDT TABLE.......................
MDTIndex	Instruction
0		INCR #0 #1
1		ADD	AREG #0
2		MOVEM	AREG #1
3		ADD	AREG #1
4		MOVEM	AREG #1
5		MEND

ALA TABLE.......................
ALAIndex	Argument
0		&AREG1
1		&AREG2

MNT TABLE.........................
Index	MNTName	MDTIndex
0	INCR	0
*/
