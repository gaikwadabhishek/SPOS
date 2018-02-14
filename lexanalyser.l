%option noyywrap
%{
#include<stdio.h>
int words_count = 0;
int line_count = 0;
int char_count = 0;
%}
%% 
[^ \t\n]+ ++words_count, char_count += strlen(yytext);
[\n] ++line_count, ++char_count;
%%
main()
{
FILE *fp; 
fp=fopen(“temp.txt”,“r”);
yyin=fp;
yylex();
printf("chars: %d\n words: %d\n lines: %d\n",char_count,words_count,line_count);
}
