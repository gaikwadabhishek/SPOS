%{
	#include<stdio.h>	
%}

%%
"class"|"public"|"static"|"void"|"main"|"int"|"char"  {printf("%s \t %s \n",yytext,"keyword");}
[_a-zA-Z][a-zA-Z_0-9]*	{printf("%s \t %s \n",yytext,"Identifier");}
[0-9]*	{printf("%s \t %s \n",yytext,"Numbers");}
["][^"\n"]*["]	{printf("%s \t %s \n",yytext,"String Constant");}
'\\[tn]' {printf("%s \t %s \n",yytext,"Char const");}
"("|"{"|"}"|")"|"["|"]"  	{printf("%s\t%s\n",yytext,"Bracket");}
"." 				{printf("%s\t%s\n",yytext,"Dot");}   
"//".*				{printf("%s\t%s\n",yytext,"Single line Comment");}
"/*"[a-zA-z0-9 \n]+"*/"		{printf("%s\t%s\n",yytext,"Multiple line Comment");}

%%
void main()
{
	FILE *fp;
	fp = fopen("Sample.java","r");
	if(fp==NULL)
	{
		printf("ERROR");
	}
	else
	{
		yyin=fp;

	}
	yylex();
}