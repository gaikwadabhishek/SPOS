%{
	#include<stdio.h>
%}
%token ID TYPE IF WHILE NUM ROP MAIN
%left ROP
%left '+' '-'
%left '*' '/'
%%
program :MAIN '(' ')' '{'DS stmtlist '}'
DS	:DS D				{printf("Valid statement.\n");}
  	|D				{printf("Valid statement.\n");}
  	;		
D	:TYPE varlist ';'
 	;
varlist	:varlist ',' ID
	|ID
	;
stmtlist:stmtlist stmt			{printf("Valid statement.\n");}
	|stmt				{printf("Valid statement.\n");}
	;
stmt	:AS
    	|ifstmt
    	|wstmt
	|'{' stmtlist '}'
	;	
AS	:ID '=' EXP ';'
	;
EXP	:EXP '+' EXP|EXP '-' EXP|EXP '*' EXP|EXP '/' EXP|EXP ROP EXP| NUM |ID
	; 
ifstmt	:IF'('EXP')'stmt
	;
wstmt	:WHILE'('EXP')'stmt
	;
%%
main()
{
FILE *fp;
	extern FILE *yyin;
	fp=fopen("Sample2.txt","r");
	if(fp==NULL)
	{
		printf("ERROR");
	}
	else
	{
	yyin=fp;
	yyparse();
	}
}

