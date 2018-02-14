%option noyywrap
%{
#include<stdio.h>
%}
%%
("public"|"class"|"static"|"void"|"main"|"String"|"args"|"int"|"System"|"out"|"println") {printf(" %s : Keyword \n",yytext);}
("("|")"|"{"|"}"|"["|"]") {printf(" %s : Bracket \n",yytext);}
("+"|"-"|"/"|"*"|"=") {printf(" %s : Operator \n",yytext);}
(","|";"|".") {printf(" %s : Delimeter \n",yytext);}
["][^"]*["] {printf(" %s : String \n",yytext);}
"//"[^\n]* {printf("%s:\tComment\n",yytext);}
[_a-zA-Z]+[_a-zA-Z0-9]* {printf("%s : Identifier \n",yytext);}
"/*"(.|\n)*"*/" {printf("%s : Comment \n",yytext);}
%%
main()
{
FILE *fp; 
fp=fopen("javaprogram.java","r");
yyin=fp;
yylex();
}
