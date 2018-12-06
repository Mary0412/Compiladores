//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 2 "prueba.y"
  import java.io.*;
  import java.util.ArrayList;
  import java.util.Collections;
  import java.util.Iterator;
//#line 22 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short NUM=257;
public final static short CONS=258;
public final static short ABR_PARENT=259;
public final static short CER_PARENT=260;
public final static short LLAVE_ABR=261;
public final static short LLAVE_CER=262;
public final static short COR_ABR=263;
public final static short COR_CER=264;
public final static short ASIG=265;
public final static short IDENTIFICADOR=266;
public final static short INT=267;
public final static short FLOAT=268;
public final static short DOUBLE=269;
public final static short CHAR=270;
public final static short VOID=271;
public final static short FOR=272;
public final static short STRUCT=273;
public final static short IF=274;
public final static short ELSE=275;
public final static short WHILE=276;
public final static short DO=277;
public final static short RETURN=278;
public final static short SWITCH=279;
public final static short BREAK=280;
public final static short PRINT=281;
public final static short FUNC=282;
public final static short CASE=283;
public final static short DEF=284;
public final static short TRUE=285;
public final static short FALSE=286;
public final static short PYC=287;
public final static short COMA=288;
public final static short DOSP=289;
public final static short PUNTO=290;
public final static short OP_AND_OR=291;
public final static short OP_NEG=292;
public final static short OP_REL=293;
public final static short OP_MAS=294;
public final static short OP_MENOS=295;
public final static short OP_MULT=296;
public final static short OP_DIV=297;
public final static short OP_MOD=298;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    1,    1,    3,    3,    3,    3,    3,    3,
    4,    4,    5,    5,    2,    2,    6,    6,    8,    8,
    9,    9,    7,    7,   10,   10,   10,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   14,   14,   15,   15,
   12,   12,   12,   16,   16,   13,   13,   13,   13,   13,
   13,   13,   13,   13,   17,   17,   18,   18,   11,   11,
   11,   11,   11,   11,   19,
};
final static short yylen[] = {                            2,
    2,    0,    4,    0,    1,    1,    1,    1,    1,    4,
    4,    2,    4,    0,   11,    0,    1,    0,    5,    3,
    3,    0,    2,    0,    5,    6,    5,    7,    9,    4,
    3,    2,    3,    8,    2,    3,    5,    0,    3,    0,
    1,    1,    3,    4,    4,    3,    3,    3,    3,    3,
    1,    1,    1,    4,    1,    0,    3,    1,    3,    2,
    3,    3,    1,    1,    1,
};
final static short yydefred[] = {                         0,
    5,    6,    7,    8,    9,    0,    0,    0,    0,    0,
    0,    1,    0,    0,    0,    0,    0,   12,    0,    0,
   10,    0,    0,    3,    0,    0,    0,   11,    0,    0,
    0,   13,    0,    0,    0,    0,   20,    0,    0,    0,
   24,    0,   21,    0,   19,   24,    0,    0,    0,    0,
    0,   24,    0,    0,    0,    0,   23,    0,    0,    0,
   15,    0,    0,   24,    0,    0,    0,   53,   52,    0,
   32,    0,    0,    0,   35,    0,    0,    0,   33,    0,
   43,    0,    0,   63,   64,    0,    0,    0,    0,    0,
    0,   31,    0,    0,    0,    0,    0,    0,   36,    0,
    0,   44,    0,    0,    0,    0,    0,   65,    0,   24,
    0,    0,    0,    0,    0,    0,   48,   49,   50,    0,
   30,   45,    0,   61,    0,   24,    0,    0,    0,    0,
   54,    0,    0,   24,    0,    0,    0,    0,    0,    0,
   28,    0,    0,    0,   24,   24,   24,   34,    0,    0,
    0,   37,
};
final static short yydgoto[] = {                          7,
    8,   12,    9,   14,   18,   30,  129,   31,   37,   57,
   87,   58,   88,  139,  144,   73,  113,  114,  109,
};
final static short yysindex[] = {                       128,
    0,    0,    0,    0,    0, -236,    0, -275, -248,  128,
  128,    0, -198,  -89, -190, -184, -174,    0,  128, -178,
    0, -161, -150,    0, -198,  128, -198,    0, -148, -128,
 -121,    0, -125,  -84,  128,  -83,    0,  128,  -81, -125,
    0, -125,    0,  -21,    0,    0, -275, -107,  -59,  -50,
  -32,    0, -142,  -31,  -76, -245,    0,  -36,  -30,   24,
    0, -245,  -35,    0, -146, -146,   66,    0,    0, -239,
    0,  -91,  -30, -245,    0,  -26, -245, -245,    0, -194,
    0,  -86, -146,    0,    0, -146, -257,  109, -250,  -17,
 -245,    0, -245, -245, -245, -245, -245, -243,    0,   96,
 -147,    0, -146, -249,  -45,   87, -146,    0, -245,    0,
 -146, -124,  -16,  -41,  -75,  -75,    0,    0,    0,  -18,
    0,    0, -259,    0,   87,    0,  -45, -124,   87, -225,
    0, -245,  -34,    0,   87,  -39, -124,  -25,  -19,  -42,
    0,   -7,  -23,  -10,    0,    0,    0,    0,   87,  -64,
   87,    0,
};
final static short yyrindex[] = {                         2,
    0,    0,    0,    0,    0,    0,    0,  254,    0,   14,
    0,    0,  -62,    0,    0,    0,    0,    0,    1,    0,
    0,    0,    0,    0,  -62,   27,  -62,    0,    0,    0,
   28,    0, -135,    0,    0,    0,    0,   45,    0, -135,
    0, -135,    0,    0,    0,    0,  254,    9,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   26,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0, -220,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   29,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0, -123, -127,    0,    0,    0,    0,
    0, -133,    0,   32, -201, -165,    0,    0,    0,    0,
    0,    0,    0,    0, -126,    0,  -98, -254, -119,    0,
    0,    0, -205,    0, -118,  108, -129,    0,   31,    0,
    0,    0,    0,    0,    0,    0,    0,    0, -108,   31,
 -204,    0,
};
final static short yygindex[] = {                         0,
   12,  247,  152,    0,   94,    0,  -37,    0,  142,  189,
  -47,    0,  -48,    0,  147,  -44,    0,    0,    0,
};
final static int YYTABLESIZE=407;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         59,
    4,    2,  106,   44,   72,   62,   11,   76,   60,  110,
  124,   68,   69,   80,   67,   59,  120,   13,   89,   91,
   70,   15,   59,   62,   10,   98,   82,  134,  100,  101,
   24,  107,   62,  107,  136,  104,   62,   59,  105,   51,
  107,  107,  112,   51,  115,  116,  117,  118,  119,   41,
   93,   94,   95,   96,   97,  123,   38,   39,   46,  127,
  128,   59,   46,  130,   17,  107,   51,   51,  125,  102,
   51,   21,   51,   51,   51,   51,   51,   51,   38,   39,
   59,   22,   23,  137,   59,   46,   46,   25,  135,   46,
   59,   46,   46,   46,   47,   59,  140,   26,   47,   93,
   94,   95,   96,   97,   59,   59,   59,  149,  150,  151,
   68,   69,   83,   27,   68,   69,  122,   33,   28,   70,
   32,   47,   47,   70,   22,   47,   58,   47,   47,   47,
   57,   34,   24,   25,   24,   25,   60,   36,   84,   85,
   27,   26,   27,   26,   71,   86,   93,   94,   95,   96,
   97,   29,   22,   29,   58,   62,   24,   25,   57,   24,
   25,   59,   16,   60,   27,   26,   35,   27,   26,   93,
   94,   95,   96,   97,   46,   29,   38,   29,   29,   48,
   40,   43,   63,   45,   42,   49,   39,   50,   59,   51,
   52,   53,   54,   55,   56,   92,   46,   19,   20,   64,
  103,   48,   93,   94,   95,   96,   97,   49,   65,   50,
   75,   51,   52,   53,   54,   55,   56,  145,   46,  143,
   95,   96,   97,   48,   14,   14,   66,   74,   77,   49,
   81,   50,   78,   51,   52,   53,   54,   55,   56,   46,
   47,  111,  133,  131,   48,  107,  132,  141,  138,  146,
   49,  148,   50,   16,   51,   52,   53,   54,   55,   56,
   99,    4,    4,  142,  143,  147,    4,   93,   94,   95,
   96,   97,    4,   41,    4,    4,    4,    4,    4,    4,
    4,    4,    4,    4,   46,   79,   18,   17,   56,   48,
   42,   55,   40,   61,  126,   49,  152,   50,    0,   51,
   52,   53,   54,   55,   56,    4,    4,    0,    0,    0,
    4,    0,    0,    0,    0,    0,    4,    0,    4,    0,
    4,    4,    4,    4,    4,    4,   46,    0,    0,    0,
    0,   48,    0,    0,    0,    0,    0,   49,    0,   50,
    0,   90,   52,   53,   54,   55,   56,   46,    0,    0,
    0,    0,   48,    0,    0,    0,    0,    0,   49,    0,
   50,    0,   51,   52,   53,   54,   55,   56,   24,    0,
    0,    0,    0,   24,    0,    0,    0,    0,    0,   24,
    0,   24,  121,   24,   24,   24,   24,   24,   24,   93,
   94,   95,   96,   97,    1,    2,    3,    4,    5,    0,
    6,  108,   93,   94,   95,   96,   97,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         44,
    0,    0,  260,   41,   53,  260,  282,   56,   46,  260,
  260,  257,  258,   62,   52,   60,  260,  266,   66,  259,
  266,   10,   67,  263,  261,   74,   64,  287,   77,   78,
   19,  291,  287,  291,  260,   83,  291,   82,   86,  260,
  291,  291,   91,  264,   93,   94,   95,   96,   97,   38,
  294,  295,  296,  297,  298,  103,  262,  262,  260,  107,
  109,  106,  264,  111,  263,  291,  287,  288,  106,  264,
  291,  262,  293,  294,  295,  296,  297,  298,  284,  284,
  125,  266,  257,  132,  129,  287,  288,  266,  126,  291,
  135,  293,  294,  295,  260,  140,  134,  259,  264,  294,
  295,  296,  297,  298,  149,  150,  151,  145,  146,  147,
  257,  258,  259,  264,  257,  258,  264,  266,   25,  266,
   27,  287,  288,  266,  260,  291,  260,  293,  294,  295,
  260,  260,  260,  260,  262,  262,  260,  263,  285,  286,
  260,  260,  262,  262,  287,  292,  294,  295,  296,  297,
  298,  260,  288,  262,  288,  263,  284,  284,  288,  287,
  287,  260,   11,  287,  284,  284,  288,  287,  287,  294,
  295,  296,  297,  298,  261,  284,  261,   26,  287,  266,
  264,   40,  290,   42,  266,  272,   35,  274,  287,  276,
  277,  278,  279,  280,  281,  287,  261,  287,  288,  259,
  287,  266,  294,  295,  296,  297,  298,  272,  259,  274,
  287,  276,  277,  278,  279,  280,  281,  260,  261,  284,
  296,  297,  298,  266,  287,  288,  259,  259,  265,  272,
  266,  274,  263,  276,  277,  278,  279,  280,  281,  261,
  262,  259,  261,  260,  266,  291,  288,  287,  283,  257,
  272,  262,  274,    0,  276,  277,  278,  279,  280,  281,
  287,  261,  262,  289,  284,  289,  266,  294,  295,  296,
  297,  298,  272,  265,  274,  262,  276,  277,  278,  279,
  280,  281,  282,  282,  261,  262,  260,  260,  260,  266,
  265,  260,  262,   47,  106,  272,  150,  274,   -1,  276,
  277,  278,  279,  280,  281,  261,  262,   -1,   -1,   -1,
  266,   -1,   -1,   -1,   -1,   -1,  272,   -1,  274,   -1,
  276,  277,  278,  279,  280,  281,  261,   -1,   -1,   -1,
   -1,  266,   -1,   -1,   -1,   -1,   -1,  272,   -1,  274,
   -1,  276,  277,  278,  279,  280,  281,  261,   -1,   -1,
   -1,   -1,  266,   -1,   -1,   -1,   -1,   -1,  272,   -1,
  274,   -1,  276,  277,  278,  279,  280,  281,  261,   -1,
   -1,   -1,   -1,  266,   -1,   -1,   -1,   -1,   -1,  272,
   -1,  274,  287,  276,  277,  278,  279,  280,  281,  294,
  295,  296,  297,  298,  267,  268,  269,  270,  271,   -1,
  273,  293,  294,  295,  296,  297,  298,
};
}
final static short YYFINAL=7;
final static short YYMAXTOKEN=298;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"NUM","CONS","ABR_PARENT","CER_PARENT","LLAVE_ABR","LLAVE_CER",
"COR_ABR","COR_CER","ASIG","IDENTIFICADOR","INT","FLOAT","DOUBLE","CHAR","VOID",
"FOR","STRUCT","IF","ELSE","WHILE","DO","RETURN","SWITCH","BREAK","PRINT",
"FUNC","CASE","DEF","TRUE","FALSE","PYC","COMA","DOSP","PUNTO","OP_AND_OR",
"OP_NEG","OP_REL","OP_MAS","OP_MENOS","OP_MULT","OP_DIV","OP_MOD",
};
final static String yyrule[] = {
"$accept : programa",
"programa : declaraciones funciones",
"programa :",
"declaraciones : tipo lista PYC declaraciones",
"declaraciones :",
"tipo : INT",
"tipo : FLOAT",
"tipo : DOUBLE",
"tipo : CHAR",
"tipo : VOID",
"tipo : STRUCT LLAVE_ABR declaraciones LLAVE_CER",
"lista : lista COMA IDENTIFICADOR arreglo",
"lista : IDENTIFICADOR arreglo",
"arreglo : COR_ABR NUM COR_CER arreglo",
"arreglo :",
"funciones : FUNC tipo IDENTIFICADOR ABR_PARENT argumentos CER_PARENT LLAVE_ABR declaraciones sentencia LLAVE_CER funciones",
"funciones :",
"argumentos : lista_argumentos",
"argumentos :",
"lista_argumentos : lista_argumentos COMA tipo IDENTIFICADOR parte_arreglo",
"lista_argumentos : tipo IDENTIFICADOR parte_arreglo",
"parte_arreglo : COR_ABR COR_CER parte_arreglo",
"parte_arreglo :",
"sentencia : sentencia sentencias",
"sentencia :",
"sentencias : IF ABR_PARENT condicion CER_PARENT sentencia",
"sentencias : IF ABR_PARENT condicion CER_PARENT sentencias sentencia",
"sentencias : WHILE ABR_PARENT condicion CER_PARENT sentencia",
"sentencias : DO sentencia WHILE ABR_PARENT condicion CER_PARENT PYC",
"sentencias : FOR ABR_PARENT sentencia PYC condicion PYC sentencia CER_PARENT sentencia",
"sentencias : parte_izquierda ASIG expresion PYC",
"sentencias : RETURN expresion PYC",
"sentencias : RETURN PYC",
"sentencias : LLAVE_ABR sentencia LLAVE_CER",
"sentencias : SWITCH ABR_PARENT expresion CER_PARENT LLAVE_ABR casos predeterminado LLAVE_CER",
"sentencias : BREAK PYC",
"sentencias : PRINT expresion PYC",
"casos : CASE DOSP NUM sentencia predeterminado",
"casos :",
"predeterminado : DEF DOSP sentencia",
"predeterminado :",
"parte_izquierda : IDENTIFICADOR",
"parte_izquierda : var_arreglo",
"parte_izquierda : IDENTIFICADOR PUNTO IDENTIFICADOR",
"var_arreglo : IDENTIFICADOR COR_ABR expresion COR_CER",
"var_arreglo : var_arreglo COR_ABR expresion COR_CER",
"expresion : expresion OP_MAS expresion",
"expresion : expresion OP_MENOS expresion",
"expresion : expresion OP_MULT expresion",
"expresion : expresion OP_DIV expresion",
"expresion : expresion OP_MOD expresion",
"expresion : var_arreglo",
"expresion : CONS",
"expresion : NUM",
"expresion : IDENTIFICADOR ABR_PARENT parametros CER_PARENT",
"parametros : lista_param",
"parametros :",
"lista_param : lista_param COMA expresion",
"lista_param : expresion",
"condicion : condicion OP_AND_OR condicion",
"condicion : OP_NEG condicion",
"condicion : ABR_PARENT condicion CER_PARENT",
"condicion : expresion relacional expresion",
"condicion : TRUE",
"condicion : FALSE",
"relacional : OP_REL",
};

//#line 350 "prueba.y"

/** referencia al analizador léxico**/
  private Yylex analex ;

/*Clase interna (para la tabla de simbolos)*/
public class Simbolo
{
  int Pos;
  String Id;
  int Type;
  double Dir;
  String Var;
  ArrayList<Integer> Args;

    public int getPos() {
        return Pos;
    }

    public void setPos(int Pos) {
        this.Pos = Pos;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public double getDir() {
        return Dir;
    }

    public void setDir(double Dir) {
        this.Dir = Dir;
    }

    public String getVar() {
        return Var;
    }

    public void setVar(String Var) {
        this.Var = Var;
    }

    public ArrayList<Integer> getArgs() {
        return Args;
    }

    public void setArgs(ArrayList<Integer> Args) {
        this.Args = Args;
    }
}
/*Clase interna (para la tabla de tipos)*/
public class Tipos
{
  Integer Pos;
  String Type;
  double Dim;
  Integer TipoBase;
  ArrayList<Simbolo> TipoBase2;

    public Integer getPos() {
        return Pos;
    }

    public void setPos(Integer Pos) {
        this.Pos = Pos;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public double getDim() {
        return Dim;
    }

    public void setDim(double Dim) {
        this.Dim = Dim;
    }

    public Integer getTipoBase() {
        return TipoBase;
    }

    public void setTipoBase(Integer TipoBase) {
        this.TipoBase = TipoBase;
    }

    public ArrayList<Simbolo> getTipoBase2() {
        return TipoBase2;
    }

    public void setTipoBase2(ArrayList<Simbolo> TipoBase2) {
        this.TipoBase2 = TipoBase2;
    }
}

  /*variables*/
  public int tipo_tipo;
  public int arreglo_base, arregloP_base;
  public ArrayList<Integer> argumentos_lista, listargumentos_lista, listargumentosP_lista;
  public int numTS=0, numTT=0, conTS=0, conTT=0;
  public int TS=0, TT=0;
  public int contEt=0;
  public int counter=1;
  public int banderafunc=0;
  public double dir=0, ultima_dir;
  public String F_codigo, S_codigo, B_codigo, SP_codigo, P_codigo, SP2_codigo;
  public String E_codigo, E_dir, EP_dir, SP3_codigo;
  public String B_verdadero, B_falso, S_sig, SP_sig, SP2_sig, SP3_sig;
  public static ArrayList<String> aux = new ArrayList<String>();
  public static ArrayList<String> aux2 = new ArrayList<String>();
  public static ArrayList<Integer> posArray = new ArrayList<Integer>();
  public static ArrayList<ArrayList<Simbolo>> TablaS=new ArrayList<ArrayList<Simbolo>>();
  public static ArrayList<ArrayList<Tipos>> TablaT=new ArrayList<ArrayList<Tipos>>();
  public EscribeFichero writer= new EscribeFichero();
  public FileWriter fichero = null;
  public PrintWriter pw = null;
  
  /*crear tabla de tipos inicial*/
  public void TablaTipos1()
  {
    Tipos tipos = new Tipos();
    ArrayList<Tipos> Lista1= new ArrayList<Tipos>();
   
    tipos.setPos(TT);
    tipos.setType("int");
    tipos.setDim(4);
    tipos.setTipoBase(-1);
    tipos.setTipoBase2(null);
    Lista1.add(tipos);

    TT++;

    tipos = new Tipos();
    tipos.setPos(TT);
    tipos.setType("float");
    tipos.setDim(4);
    tipos.setTipoBase(-1);
    tipos.setTipoBase2(null);
    Lista1.add(tipos);

    TT++;

    tipos = new Tipos();
    tipos.setPos(TT);
    tipos.setType("double");
    tipos.setDim(8);
    tipos.setTipoBase(-1);
    tipos.setTipoBase2(null);
    Lista1.add(tipos);

    TT++;

    tipos = new Tipos();
    tipos.setPos(TT);
    tipos.setType("char");
    tipos.setDim(1);
    tipos.setTipoBase(-1);
    tipos.setTipoBase2(null);
    Lista1.add(tipos);

    TT++;

    tipos = new Tipos();
    tipos.setPos(TT);
    tipos.setType("void");
    tipos.setDim(0);
    tipos.setTipoBase(-1);
    tipos.setTipoBase2(null);
    Lista1.add(tipos);

    TT++;

    TablaT.add(Lista1);

  }

  public int addSimbolo(int tabla, String cad1,int val1, int bdir, String cad2, ArrayList<Integer> lista){

    TS=TablaS.get(tabla).size();

    int exist;
    if (!aux2.contains(cad1)) 
    {
      Simbolo simbolo = new Simbolo();
      simbolo.setPos(TS);
      simbolo.setId(cad1);
      simbolo.setType(val1);
      if (bdir>=0){
        simbolo.setDir(dir);
        dir=dir+TablaT.get(tabla).get(val1).getDim();
      }
      else
        simbolo.setDir(-1);
      simbolo.setVar(cad2);
      simbolo.setArgs(lista);

      aux2.add(cad1);

      TablaS.get(tabla).add(simbolo);
      exist=0;
    }
    else
      exist=-1;

    return exist;

  }

  public String creaEtiqueta(){
    String nueva="L"+contEt+":";
    contEt++;
    return nueva;
  }

  public void nuevaTablaS(){
    TS=0;
    TT=0;
    ultima_dir=dir;
    dir=0;
    TablaS.add(new ArrayList<Simbolo>());
    numTS++;
    TablaTipos1();
    conTS=numTS;
    conTT=numTT;
  }

  public int addTipo(int tabla, String cad1, double val1, Integer val2){
    Tipos tipos = new Tipos();
    tipos.setPos(TT);
    tipos.setType(cad1);
    tipos.setDim(val1);
    tipos.setTipoBase(val2);
    tipos.setTipoBase2(null);

    if (!TablaT.get(tabla).contains(tipos)) 
      TablaT.get(tabla).add(tipos);
      TT++;

    return TT;
  }


  /* Funcion para desplegar las tablas*/
  public void getTablas(){ 
    int conta=0;
    Iterator<ArrayList<Simbolo>> ItS = TablaS.iterator();
    while(ItS.hasNext()){
      System.out.println("Tabla de simbolos "+conta);
      conta++;
      System.out.println("Pos\tId\tTipo\tDir\tVar\tArgs");
      ArrayList<Simbolo> renglon=ItS.next();
      Iterator<Simbolo> ItRen = renglon.iterator();
      while(ItRen.hasNext()){
        Simbolo simb=ItRen.next();

        int posTemp=simb.getPos();
        System.out.print(String.valueOf(posTemp)+"\t");
        String idTemp=simb.getId();
        System.out.print(idTemp+"\t");
        int tipoTemp=simb.getType();
        System.out.print(String.valueOf(tipoTemp)+"\t");
        double dirTemp = simb.getDir();
        if (dirTemp>=0)
          System.out.print(String.valueOf(dirTemp)+"\t");
        else
          System.out.print("--\t");
        String varTemp= simb.getVar();
        System.out.print(varTemp+"\t");
        ArrayList<Integer> argsTemp=simb.getArgs();
        if (argsTemp==null)
          System.out.print("--");
        else{
          Iterator<Integer> ItI = argsTemp.iterator();
          while(ItI.hasNext()){
            Integer arg=ItI.next();
            System.out.print(arg+", ");  
          }
        }
        System.out.println();
      }
    }
    conta=0;
    Iterator<ArrayList<Tipos>> ItT = TablaT.iterator();
    while(ItT.hasNext()){
      System.out.println("Tabla de tipos "+conta);
      conta++;
      System.out.println("Pos\tTipo\tDim\tTipoBase");
      ArrayList<Tipos> renglon=ItT.next();
      Iterator<Tipos> ItRen = renglon.iterator();
      while(ItRen.hasNext()){
        Tipos tip=ItRen.next();

        int posTemp=tip.getPos();
        System.out.print(String.valueOf(posTemp)+"\t");
        String tipoTemp=tip.getType();
        System.out.print(tipoTemp+"\t");
        double dimTemp= tip.getDim();
        System.out.print(String.valueOf(dimTemp)+"\t");
        int base1Temp= tip.getTipoBase();
        if (base1Temp>=0)
          System.out.print(String.valueOf(base1Temp)+"\t");
        else
          System.out.print("--\t");
        ArrayList<Simbolo> base2Temp=tip.getTipoBase2();
        //System.out.print(String.valueOf(posTemp)+"\t");
        System.out.println();
      }
    }

  }

  public class EscribeFichero
  {
      public void creaF()
      {
          try
          {
              fichero = new FileWriter("/home/marisela/Escritorio/car/codigo.txt");
              pw = new PrintWriter(fichero);

          } catch (Exception e) {
              e.printStackTrace();
          } 
      }

      public void escribe(String cadena)
      {
        pw.println(cadena);
      }

      public void cerrarF(){
        try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
      }
  }


/*----------------------------------------------------------------*/
  /** constructor: crea el analizador léxico (lexer) **/
  public Parser(Reader r) 
  {
     writer.creaF();
     TablaTipos1();
     TablaS.add(new ArrayList<Simbolo>());
     analex = new Yylex(r, this);
     //yydebug = true ;
  }

  /** obtiene el siguiente token del analizador léxico **/
  private int yylex () 
  {
    int yyl_return = -1;

    try 
    {
       yylval = new ParserVal(0);
       yyl_return = analex.yylex();
    }
    catch (IOException e) 
    {
       System.err.println("error de E/S:"+e);
    }

    return yyl_return;
  }

  public void yyerror (String descripcion, int yystate, int token) 
  {
     System.err.println ("Error en línea "+Integer.toString(analex.lineaActual())+" : "+descripcion);
     System.err.println ("Token leído : "+yyname[token]);
     System.err.print("Token(s) que se esperaba(n) : ");

     String  nombresTokens = "" ;

     int yyn ;

     // añadir en 'nombresTokens' los tokens que permitirian desplazar
     //nombresTokens += "desplazan: " ;

     for( yychar = 0 ; yychar < YYMAXTOKEN ; yychar++ )
     {
        yyn = yysindex[yystate] ;  
        if ((yyn != 0) && (yyn += yychar) >= 0 &&
             yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
            nombresTokens += yyname[yychar] + " ";
        }
     }

    System.err.println(nombresTokens);
    
  }

  public void yyerror (String descripcion) 
  {
     System.err.println ("Error en línea "+Integer.toString(analex.lineaActual())+" : "+descripcion);
  }
//#line 822 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("error sintactico",yystate,yychar);
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 53 "prueba.y"
{writer.escribe(F_codigo); writer.cerrarF();}
break;
case 3:
//#line 58 "prueba.y"
{System.out.println("declaraciones");  banderafunc=0;}
break;
case 4:
//#line 59 "prueba.y"
{System.out.println("declaraciones");  banderafunc=0;}
break;
case 5:
//#line 63 "prueba.y"
{ 
                    tipo_tipo=0; 
                    aux.add(analex.getIdenti()); 
                    posArray.add(tipo_tipo); 
                    System.out.println("tipo");
                  }
break;
case 6:
//#line 69 "prueba.y"
{ 
                    tipo_tipo=1;  
                    aux.add(analex.getIdenti()); 
                    posArray.add(tipo_tipo); 
                    System.out.println("tipo");
                    }
break;
case 7:
//#line 75 "prueba.y"
{ 
                    tipo_tipo=2; 
                    aux.add(analex.getIdenti()); 
                    posArray.add(tipo_tipo); 
                    System.out.println("tipo");
                    }
break;
case 8:
//#line 81 "prueba.y"
{ 
                    tipo_tipo=3;  
                    aux.add(analex.getIdenti()); 
                    posArray.add(tipo_tipo); 
                    System.out.println("tipo");
                  }
break;
case 9:
//#line 87 "prueba.y"
{ 
                  tipo_tipo=4;  
                  aux.add(analex.getIdenti()); 
                  posArray.add(tipo_tipo); 
                  System.out.println("tipo");
                  }
break;
case 10:
//#line 93 "prueba.y"
{ System.out.println("tipo");
       }
break;
case 11:
//#line 99 "prueba.y"
{ System.out.println("lista");
            aux.add(analex.getIdenti());
            posArray.add(tipo_tipo);
            addSimbolo(numTS,analex.getIdenti(),arreglo_base,0,"var",null); 
          }
break;
case 12:
//#line 105 "prueba.y"
{  System.out.println("lista");
            aux.add(analex.getIdenti());
            posArray.add(tipo_tipo);
            addSimbolo(numTS,analex.getIdenti(),arreglo_base,0,"var",null); 
          }
break;
case 13:
//#line 114 "prueba.y"
{  System.out.println("arreglo");
            arregloP_base=arreglo_base;
            double dimen=Double.parseDouble(analex.getNumber())*TablaT.get(numTT).get(arreglo_base).getDim();
            arreglo_base=addTipo(numTT,"array",dimen,arregloP_base)-1;
          }
break;
case 14:
//#line 119 "prueba.y"
{  System.out.println("arreglo");
            arreglo_base=tipo_tipo;
          }
break;
case 15:
//#line 126 "prueba.y"
{ System.out.println("funciones");
            int posicion=0;
            Iterator<String> ItS1 = aux.iterator();
            while(ItS1.hasNext()){
              String cadena=ItS1.next();
              posicion++;
              if (!aux2.contains(cadena) && cadena!=null)
              {
                numTS=0;
                addSimbolo(numTS,cadena,posArray.get(posicion-2),-1,"func",argumentos_lista); 
                banderafunc=0;
                dir=ultima_dir;
                F_codigo=creaEtiqueta()+P_codigo;
              }
            }
          }
break;
case 16:
//#line 142 "prueba.y"
{System.out.println("funciones");}
break;
case 17:
//#line 147 "prueba.y"
{  System.out.println("argumentos");
            argumentos_lista=listargumentos_lista; 
            }
break;
case 18:
//#line 150 "prueba.y"
{  System.out.println("argumentos");
            argumentos_lista=null; 
          }
break;
case 19:
//#line 157 "prueba.y"
{ System.out.println("lista_argumentos");
            ArrayList<Simbolo> ListaTemp= TablaS.get(0);
            Iterator<Simbolo> ItRen = ListaTemp.iterator();
            int bandera=0;
            while(ItRen.hasNext()){
              Simbolo simb=ItRen.next();
              String idTemp=simb.getId();
              if (idTemp.equals(analex.getIdenti()))
                bandera++;
            }
            if (bandera==0){
              addSimbolo(numTS,analex.getIdenti(),tipo_tipo,0,"param",null); 
              listargumentos_lista.add(tipo_tipo);
            }
          }
break;
case 20:
//#line 173 "prueba.y"
{ System.out.println("lista_argumentos");
            ArrayList<Simbolo> ListaTemp= TablaS.get(0);
            Iterator<Simbolo> ItRen = ListaTemp.iterator();
            int bandera=0;
            while(ItRen.hasNext()){
              Simbolo simb=ItRen.next();
              String idTemp=simb.getId();
              if (idTemp.equals(analex.getIdenti()))
                bandera++;
            }
            if (bandera==0){
              addSimbolo(numTS,analex.getIdenti(),tipo_tipo,0,"param",null); 
              listargumentos_lista=new ArrayList<Integer>();
              listargumentos_lista.add(tipo_tipo);
            }
          }
break;
case 21:
//#line 193 "prueba.y"
{ 
              if (banderafunc==0)
              {
              nuevaTablaS();
              banderafunc=1;
              }
            }
break;
case 22:
//#line 200 "prueba.y"
{ 
            if (banderafunc==0)
              {
              nuevaTablaS();
              banderafunc=1;
              }
          }
break;
case 23:
//#line 211 "prueba.y"
{ 
            SP_sig=creaEtiqueta();
            S_sig=SP_sig;                          /*???*/
            S_codigo=SP_codigo+SP_sig+SP2_codigo;
          }
break;
case 24:
//#line 216 "prueba.y"
{ 
            S_sig=creaEtiqueta();
            P_codigo=S_codigo+S_sig;
          }
break;
case 25:
//#line 224 "prueba.y"
{ B_verdadero=creaEtiqueta();
            B_falso=S_sig;
            SP_sig=S_sig;
            S_codigo=B_codigo+B_verdadero+SP_sig;
          }
break;
case 26:
//#line 230 "prueba.y"
{
            B_verdadero=creaEtiqueta();
            B_falso=creaEtiqueta();
            SP_sig=S_sig;
            SP2_sig=S_sig;
            S_codigo=B_codigo+B_verdadero+SP_codigo+"goto"+SP_sig+B_falso+SP2_codigo;
          }
break;
case 27:
//#line 238 "prueba.y"
{
            B_verdadero=creaEtiqueta();
            B_falso=S_sig;
            SP_sig=creaEtiqueta();
            S_codigo=SP_sig+B_codigo+B_verdadero+SP_codigo+"goto"+SP_sig;
          }
break;
case 28:
//#line 245 "prueba.y"
{
            SP_sig=creaEtiqueta();
            B_verdadero=creaEtiqueta();
            B_falso=S_sig;
            S_codigo=B_verdadero+SP_codigo+SP_sig+B_codigo;
          }
break;
case 29:
//#line 252 "prueba.y"
{ 
            SP_sig=creaEtiqueta();
            SP3_sig=creaEtiqueta();
            SP2_sig=SP_sig;
            B_verdadero=creaEtiqueta();
            B_falso=S_sig;
            S_codigo=SP_codigo+SP_sig+B_codigo+B_verdadero+SP3_codigo+SP3_sig+SP2_codigo+"goto"+SP2_sig;
          }
break;
case 30:
//#line 261 "prueba.y"
{
            S_codigo=E_codigo+analex.getIdenti()+"="+E_dir;
          }
break;
case 31:
//#line 265 "prueba.y"
{
          System.out.println("sentencias");
          }
break;
case 32:
//#line 269 "prueba.y"
{ 
          System.out.println("sentencias");
          }
break;
case 33:
//#line 273 "prueba.y"
{
            SP_sig=S_sig;
            S_codigo=SP_codigo;
          }
break;
case 34:
//#line 278 "prueba.y"
{ 
          System.out.println("sentencias");
          }
break;
case 35:
//#line 282 "prueba.y"
{
          System.out.println("sentencias");
          }
break;
case 36:
//#line 286 "prueba.y"
{
          System.out.println("sentencias");
          }
break;
case 37:
//#line 292 "prueba.y"
{System.out.println("casos");}
break;
case 38:
//#line 293 "prueba.y"
{System.out.println("casos");}
break;
case 39:
//#line 297 "prueba.y"
{System.out.println("predeterminado");}
break;
case 40:
//#line 298 "prueba.y"
{System.out.println("predeterminado");}
break;
case 41:
//#line 302 "prueba.y"
{System.out.println("parte_izquierda");}
break;
case 42:
//#line 303 "prueba.y"
{System.out.println("parte_izquierda");}
break;
case 43:
//#line 304 "prueba.y"
{System.out.println("parte_izquierda");}
break;
case 44:
//#line 308 "prueba.y"
{System.out.println("var_arreglo");}
break;
case 45:
//#line 309 "prueba.y"
{System.out.println("var_arreglo");}
break;
case 46:
//#line 313 "prueba.y"
{System.out.println("expresion");}
break;
case 47:
//#line 314 "prueba.y"
{System.out.println("expresion");}
break;
case 48:
//#line 315 "prueba.y"
{System.out.println("expresion");}
break;
case 49:
//#line 316 "prueba.y"
{System.out.println("expresion");}
break;
case 50:
//#line 317 "prueba.y"
{System.out.println("expresion");}
break;
case 51:
//#line 318 "prueba.y"
{System.out.println("expresion");}
break;
case 52:
//#line 319 "prueba.y"
{System.out.println("expresion");}
break;
case 53:
//#line 320 "prueba.y"
{System.out.println("expresion");}
break;
case 54:
//#line 321 "prueba.y"
{System.out.println("expresion");}
break;
case 55:
//#line 325 "prueba.y"
{System.out.println("parametros");}
break;
case 56:
//#line 326 "prueba.y"
{System.out.println("parametros");}
break;
case 57:
//#line 330 "prueba.y"
{System.out.println("lista_param");}
break;
case 58:
//#line 331 "prueba.y"
{System.out.println("lista_param");}
break;
case 59:
//#line 335 "prueba.y"
{System.out.println("condicion");}
break;
case 60:
//#line 336 "prueba.y"
{System.out.println("condicion");}
break;
case 61:
//#line 337 "prueba.y"
{System.out.println("condicion");}
break;
case 62:
//#line 338 "prueba.y"
{System.out.println("condicion");}
break;
case 63:
//#line 339 "prueba.y"
{System.out.println("condicion");}
break;
case 64:
//#line 340 "prueba.y"
{System.out.println("condicion");}
break;
case 65:
//#line 344 "prueba.y"
{System.out.println("relacional");}
break;
//#line 1376 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
