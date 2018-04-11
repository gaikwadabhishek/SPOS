import java.util.*;
import java.io.*;

class Lit
{
	String literal;
	int addr;
	Lit(String l)
	{
		literal=l;
	}

}
class Sym
{
	String sname;
	int addr;
	int len;
	Sym(String s1)
	{
		sname=s1;
	}
}
class Pass1
{
	public static void main(String args[])throws Exception
	{
		int loc=0,sindex=0,lindex=0;
		boolean flag=false;
		Lit LArray[]=new Lit[10];
		Sym SArray[]=new Sym[10];
		HashMap<String, Integer> POT = new HashMap<>();
 		POT.put("START",1);
        POT.put("END",2);
        POT.put("DC",7);
        POT.put("ORIGIN",3);
        POT.put("EQU",4);
        POT.put("LTORG",5);
        POT.put("DS",6);


        HashMap<String, Integer> MOT = new HashMap<>();
 		MOT.put("MOVER",1);
        MOT.put("MOVEM",2);
        MOT.put("ADD",3);
        MOT.put("SUB",4);
        MOT.put("MULT",5);
        MOT.put("DIV",6);
        MOT.put("BC",7);

        HashMap<String, Integer> REG = new HashMap<>();
 		REG.put("AREG",1);
        REG.put("BREG",2);
        REG.put("CREG",3);
        REG.put("DREG",4);


        FileReader fr=new FileReader("xyz.txt");
        BufferedReader br=new BufferedReader(fr);

        String CurrentLine;
		try
		{
		while ((CurrentLine = br.readLine()) != null)
		{
				int val,ind=-1,regval=0;

      			 String s[]=CurrentLine.split("	");
      			 for(int i=0;i<s.length;i++)
      			 {
      			 	//System.out.print(s[i]+"\t");
      			 }
      			 System.out.println();
				if(POT.containsKey(s[0]))
				{

					val=POT.get(s[0]);
					if(s[0].equals("START"))
					{
						if(s[1]!=null)
						{
							loc=Integer.parseInt(s[1]);
						}
						System.out.println("AD "+val+"	"+"C "+loc);
					}
					else if(s[0].equals("END"))
					{
						System.out.println("AD "+val);
						for(int i=0;i<lindex;i++)
						{
							LArray[i].addr=loc;
							loc++;
						}
					}

				}


				else if(MOT.containsKey(s[0]))
				{

					char ch;
					val=MOT.get(s[0]);
					if(REG.containsKey(s[1]))
					{
						regval=REG.get(s[1]);
					}
					if(s[2].charAt(0)=='=')
					{
						ch='L';
						//int l1=Integer.parseInt(s[2].charAt(1));
						LArray[lindex]=new Lit(s[2]);
						ind=lindex;
						lindex++;
					}
					else
					{
					ch='S';


						for(int i=0;i<sindex;i++)
						{
							if(s[2].equals(SArray[i].sname))
							{
								flag=true;
								break;
							}

						}
						if(flag==false)
						{
						SArray[sindex]=new Sym(s[2]);
						ind=sindex;
						sindex++;
						}


					}


					System.out.println("IS "+val+"	"+regval+"	"+ch+" "+ind);
					loc++;
				}
				else
				{

					if(s[1].equals("DS")||s[1].equals("DC"))
					{
						val=POT.get(s[1]);

						int l=Integer.parseInt(s[2]);
						int i;
						flag=false;
						for( i=0;i<sindex;i++)
						{
							if(s[0].equals(SArray[i].sname))
							{
								flag=true;
								break;
							}

						}
						if(flag==false)
						{
							SArray[sindex]=new Sym(s[0]);
							ind=sindex;
							SArray[sindex].addr=loc;
							SArray[sindex].len=l;
							sindex++;
						}
						else
						{
							SArray[i].addr=loc;
							SArray[i].len=l;
						}
						loc+=l;
						System.out.println("AD	"+val+"	"+"c	"+l);
					}
					else
					{
						System.out.println("Label");
						flag=false;
						for(int i=0;i<sindex;i++)
						{
							if(s[0].equals(SArray[i].sname))
							{
								flag=true;
								break;
							}

						}
						if(flag==false)
						{

						SArray[sindex]=new Sym(s[0]);
						ind=sindex;
						SArray[sindex].addr=loc;
						sindex++;
						}
						else
						{
							System.out.println("Duplicate Label");
							System.exit(0);
						}
					}
				}

		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("**************Symbol Table*******");
		System.out.println("sindex\tsname\taddress\tlength");
		for(int i=0;i<sindex;i++)
		{
						//System.out.println("**************Symbol *******");
						System.out.println(i+"\t"+SArray[i].sname+"\t"+SArray[i].addr+"\t"+SArray[i].len);

		}
		System.out.println("**************Literal Table*******");
		System.out.println("lindex\tlname\tAddress");
		for(int i=0;i<lindex;i++)
						{
						//System.out.println("**************Symbol *******");
						System.out.println(i+"\t"+LArray[i].literal+"\t"+LArray[i].addr);

						}
    }
}

/*OUTPUT;-



AD 1    C 100

IS 1    1       S 0

IS 3    2       L 0

IS 4    1       L 1

IS 2    1       S 1

AD      6       c       2

AD      7       c       3

AD      6       c       2

AD 2

1
**************Symbol Table*******
sindex  sname   address length
0       A       104     2
1       C       109     2
2       B       106     3
**************Literal Table*******
lindex  lname   Address
0       ='5'    111
1       ='1'    112
Press any key to continue . . .

*/