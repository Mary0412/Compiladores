%%

%byaccj

%{

  private Parser yyparser ;

  /** constructor del analizador sintáctico**/

  public Yylex(java.io.Reader r, Parser p ) 
  {
    this(r);
    linea_actual = 1 ;
    yyparser = p  ;
    valor="";
  }

  private int linea_actual; /** Contador de lineas **/
  private String valor;
  private String identi;
  private String number;

  /** devuelve el numero de linea donde está el último caracter leido **/

  public int lineaActual()
  {
     return linea_actual;
  }

  public String getValor()
  {
     return valor;
  }
  public String getIdenti()
  {
     return identi;
  }
  public String getNumber()
  {
     return number;
  }
  

%}

Identificador = [a-zA-Z][a-zA-Z0-9_]*
Entero = [0-9]+
Decimal = {Entero}"."{Entero}?
Cadena = \"[^\n]*\"
Caracter = "'"[^\n]"'"
Caracter2 = "'"\\[^\n]"'"

%%

"="    {  valor=yytext();
          return Parser.ASIG ;
       }
"("    {  valor=yytext();
          return Parser.ABR_PARENT ; 
       }
")"    {  valor=yytext();
          return Parser.CER_PARENT ; 
       }
"{"    {  valor=yytext();
          return Parser.LLAVE_ABR ; 
       }
"}"    {  valor=yytext();
          return Parser.LLAVE_CER ; 
       }
"["    {  valor=yytext();
          return Parser.COR_ABR ; 
       }
"]"    {  valor=yytext();
          return Parser.COR_CER ; 
       }
";"    {  valor=yytext();
          return Parser.PYC ;
       }
","    {  valor=yytext();
          return Parser.COMA ;
       }
":"    {  valor=yytext();
          return Parser.DOSP ;
       }
"."    {  valor=yytext();
          return Parser.PUNTO ;
       }
"+"    {  valor=yytext();
          yyparser.yylval = new ParserVal( new Character(yytext().charAt(0)) ) ;
          return Parser.OP_MAS ;
       }
"-"    {  valor=yytext();
          yyparser.yylval = new ParserVal( new Character(yytext().charAt(0)) ) ;
          return Parser.OP_MENOS ;
       }      
"*"
       {  valor=yytext();
          yyparser.yylval = new ParserVal( new Character(yytext().charAt(0)) ) ;
          return Parser.OP_MULT ;
       }
"/"
       {  valor=yytext();
          yyparser.yylval = new ParserVal( new Character(yytext().charAt(0)) ) ;
          return Parser.OP_DIV ;
       }
"%"
       {  valor=yytext();
          yyparser.yylval = new ParserVal( new Character(yytext().charAt(0)) ) ;
          return Parser.OP_MOD ;
       }
"&&"|"||"
       {  valor=yytext();
          return Parser.OP_AND_OR ;
       }
"!"
       {  valor=yytext();
          return Parser.OP_NEG ;
       }      
"<"|">"|"<="|">="|"!="|"=="
       {  valor=yytext();
          return Parser.OP_REL ;
       }
"int"  {  valor=yytext();
          return Parser.INT ;
       }
"float"
       {  valor=yytext();
          return Parser.FLOAT ;
       }
"double"
       {  valor=yytext();
          return Parser.DOUBLE ;
       }
"char" {  valor=yytext();
          return Parser.CHAR ;
       }
"void" {  valor=yytext();
          return Parser.VOID ;
       }
"struct" 
       {  valor=yytext();
          return Parser.STRUCT ;
       }
"if"   {  valor=yytext();
          return Parser.IF ;
       }
"else" {  valor=yytext();
          return Parser.ELSE ;
       }
"while"
       {  valor=yytext();
          return Parser.WHILE ;
       }
"do"   {  valor=yytext();
          return Parser.DO ;
       }
"return"
       {  valor=yytext();
          return Parser.RETURN ;
       }
"switch"
       {  valor=yytext();
          return Parser.SWITCH ;
       }
"break"
       {  valor=yytext();
          return Parser.BREAK ;
       }
"print"
       {  valor=yytext();
          return Parser.PRINT ;
       }
"func" {  valor=yytext();
          return Parser.FUNC ;
       }
"for"  {  valor=yytext();
          return Parser.FOR ;
       }
"case" {  valor=yytext();
          return Parser.CASE ;
       }
"default"
       {  valor=yytext();
          return Parser.DEF ;
       }
"true" {  valor=yytext();
          return Parser.TRUE ;
       }
"false"
       {  valor=yytext();
          return Parser.FALSE ;
       }
{Cadena} 
       {  valor=yytext();
          return Parser.CONS ; 
       }
{Caracter}|{Caracter2}  
       {  valor=yytext();
          return Parser.CONS ; 
       }
{Entero} 
       {  number=yytext();
          yyparser.yylval = new ParserVal( new Integer(yytext()) );
          return Parser.NUM ; 
       }
{Decimal}  
       {  number=yytext();
          yyparser.yylval = new ParserVal( new Double(yytext()) ); 
          return Parser.NUM ; 
       }
{Identificador}
       {  identi=yytext();
          yyparser.yylval = new ParserVal( (Object) yytext() ); 
          return Parser.IDENTIFICADOR ;  
       }

\n     { // lleva la cuenta de lineas 
         linea_actual ++ ;
       }

[ \t]+ {  /** ignorar espacios en blanco **/ 
       }

.      {  /** cualquier otra cosa produce un mensaje de error **/
          yyparser.yyerror("el(los) carácter(es) '"+yytext()+"' no forma(n) ningún token conocido"); 
       }
