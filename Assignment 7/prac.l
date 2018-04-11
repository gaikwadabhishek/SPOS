
%{
	#include<stdio.h>
	int wcount = 0, ccount = 0, lcount = 0;	
%}

%%
[\n]	{lcount++;wcount++;}
[" "]	wcount++;
[a-zA-Z]	ccount++;
%%

void main()
{
	FILE *fp;
	fp = fopen("data.txt","r");
	yyin = fp;
	yylex();
	printf("word count: %d",wcount);
	printf("\nchar count: %d",ccount);
	printf("\nline count: %d",lcount);

}