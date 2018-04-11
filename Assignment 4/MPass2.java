import java.io.*;
import java.*;

class MNT
{
	String mname;
	int mdtIndex;
	public MNT(String string, int i) {
		mname=string;
		mdtIndex=i;
	}
}

public class MPass2
{
	public static void main(String[] args) throws NullPointerException,Exception {
		int MNTP=0;
		int MDTP=0;
		int ALAP=0;
		int MDTPNEW=0;
		MNT mnt[]=new MNT[30];
		String mdt[]=new String[30];
		String mdtnew[]=new String[30];
		String ala[]=new String[30];
		
		mnt[MNTP]=new MNT("INCR",0);
		MNTP++;
		mnt[MNTP]=new MNT("MUL",1);
		MNTP++;
		mnt[MNTP]=new MNT("DIV",2);
		MNTP++;
		
		
		mdt[MDTP]=new String("INCR #0 #1");
		MDTP++;
		mdt[MDTP]=new String("ADD AREG #0");
		MDTP++;
		mdt[MDTP]=new String("MOVEM AREG #0");
		MDTP++;
		mdt[MDTP]=new String("ADD AREG #1");
		MDTP++;
		mdt[MDTP]=new String("MOVEM AREG #1");
		MDTP++;
		
		FileReader fr=new FileReader("SampleFile.txt");
		BufferedReader br=new BufferedReader(fr);
		
		String s1,temp,a;
		int j = -2,k=0;
		char alaInd;
		int alaIndia;
		String alanew,actualArg = null;
		int h,finalala;
		char alaIndFinal;
		
		while((s1=br.readLine())!=null)
		{
			h=-1;
			j=-1;
			String line[]=s1.split(" ");
			for(int i=0;i<MNTP;i++)
			{
				if((line[0]).equals(mnt[i].mname))
				{
					j=mnt[i].mdtIndex;
					//System.out.println("j is :"+j);
					ala[ALAP]=line[1];
					//System.out.println("ala[ALAP] is: "+ala[ALAP]);
					ALAP++;
					ala[ALAP]=line[2];
					//System.out.println("ala[ALAP++] is: "+ala[ALAP]);
					//System.out.println("MDTP is : "+MDTP);
					while(k<MDTP)
					{
						if(k==j)
						{
							a="";
							String line2[]=mdt[j].split(" ");
							//System.out.println("line2[].length is :"+line2.length);
							for(h=1;h<line2.length;h++)
							{
								if(line2[h].charAt(0)=='#')
								{
									alaInd=line2[h].charAt(1);
									//System.out.println("alaInd is : "+alaInd);
									
									alanew=""+alaInd;
									//System.out.println("alanew is : "+alanew );
									
									finalala=Integer.parseInt(alanew);
									//System.out.println("finalala is : "+finalala);
									
									actualArg=ala[finalala];
									//System.out.println("Actual Arguement "+finalala+" is : "+ actualArg);
									
									a=a+" "+actualArg;
									//System.out.println("a is :"+a);
									
								}
								else
								{
									a=" "+line2[h];
								}
								
							}
							mdtnew[MDTPNEW]=line2[0]+a;
							MDTPNEW++;
						}
						j++;
						k++;
					}
					
					System.out.println("\n");
					System.out.println("ALA Table is: ");
					for(int w=0;w<=ALAP;w++)
					{
						System.out.println(ala[w]);
					}
					
					System.out.println("\n");
					System.out.println("MDT Table is: ");
					for(int y=0;y<MDTPNEW;y++)
					{
						System.out.println(mdtnew[y]+"   ");
					}
					
				}
			}
		}
		
		
		
		
	}
}



//String s = "" + 's';


//humko index mila h matlab #1 ka 1 nikala h but wo char mein h toh int mein akerna h aur ala se uss index pe se arg leke #1 ki jaga daalna h