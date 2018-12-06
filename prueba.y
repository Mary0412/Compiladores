%{
  import java.io.*;
  import java.util.ArrayList;
  import java.util.Collections;
  import java.util.Iterator;
%}
      
// lista de tokens por orden de prioridad

%token NUM  // numero (entero o flotante)
%token CONS // constante (cadena o caracter)
%token ABR_PARENT // abrir paréntesis
%token CER_PARENT // cerrar paréntesis
%token LLAVE_ABR // abrir llaves
%token LLAVE_CER // cerrar llaves
%token COR_ABR // abrir corchetes
%token COR_CER // cerrar corchetess
%token ASIG       // simbolo usado para la asignación
%token IDENTIFICADOR 
%token INT
%token FLOAT
%token DOUBLE
%token CHAR
%token VOID
%token FOR
%token STRUCT
%token IF
%token ELSE
%token WHILE
%token DO
%token RETURN
%token SWITCH
%token BREAK
%token PRINT
%token FUNC
%token CASE
%token DEF  //default
%token TRUE
%token FALSE
%token PYC  // punto y coma
%token COMA  
%token DOSP  // dos puntos
%token PUNTO  
%token OP_AND_OR //operadores and y or
%token OP_NEG     //operador negacion
%token OP_REL //operadores relacionales
%left  OP_MAS OP_MENOS // operadores binarios de menos prioridad
%left  OP_MULT OP_DIV OP_MOD   // operadores binarios de mas prioridad  
      
%%

programa
       :  declaraciones funciones {writer.escribe(F_codigo); writer.cerrarF();}
       |  
       ; 

declaraciones
       :  tipo lista PYC declaraciones {System.out.println("declaraciones");  banderafunc=0;}
       |  {System.out.println("declaraciones");  banderafunc=0;}
       ;

tipo
       :  INT     { 
                    tipo_tipo=0; 
                    aux.add(analex.getIdenti()); 
                    posArray.add(tipo_tipo); 
                    System.out.println("tipo");
                  }
       |  FLOAT   { 
                    tipo_tipo=1;  
                    aux.add(analex.getIdenti()); 
                    posArray.add(tipo_tipo); 
                    System.out.println("tipo");
                    }
       |  DOUBLE  { 
                    tipo_tipo=2; 
                    aux.add(analex.getIdenti()); 
                    posArray.add(tipo_tipo); 
                    System.out.println("tipo");
                    }
       |  CHAR    { 
                    tipo_tipo=3;  
                    aux.add(analex.getIdenti()); 
                    posArray.add(tipo_tipo); 
                    System.out.println("tipo");
                  }
       |  VOID    { 
                  tipo_tipo=4;  
                  aux.add(analex.getIdenti()); 
                  posArray.add(tipo_tipo); 
                  System.out.println("tipo");
                  }
       |  STRUCT LLAVE_ABR declaraciones LLAVE_CER  { System.out.println("tipo");
       }
       ;

lista 
       :  lista COMA IDENTIFICADOR arreglo 
          { System.out.println("lista");
            aux.add(analex.getIdenti());
            posArray.add(tipo_tipo);
            addSimbolo(numTS,analex.getIdenti(),arreglo_base,0,"var",null); 
          }
       |  IDENTIFICADOR arreglo
          {  System.out.println("lista");
            aux.add(analex.getIdenti());
            posArray.add(tipo_tipo);
            addSimbolo(numTS,analex.getIdenti(),arreglo_base,0,"var",null); 
          }
       ;

arreglo
       :  COR_ABR NUM COR_CER arreglo
          {  System.out.println("arreglo");
            arregloP_base=arreglo_base;
            double dimen=Double.parseDouble(analex.getNumber())*TablaT.get(numTT).get(arreglo_base).getDim();
            arreglo_base=addTipo(numTT,"array",dimen,arregloP_base)-1;
          }
       |  {  System.out.println("arreglo");
            arreglo_base=tipo_tipo;
          }
       ;

funciones
       :  FUNC tipo IDENTIFICADOR ABR_PARENT argumentos CER_PARENT LLAVE_ABR declaraciones sentencia LLAVE_CER funciones
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
       |  {System.out.println("funciones");}
       ;

argumentos
       :  lista_argumentos 
            {  System.out.println("argumentos");
            argumentos_lista=listargumentos_lista; 
            }
       |  {  System.out.println("argumentos");
            argumentos_lista=null; 
          }
       ;

lista_argumentos
       :  lista_argumentos COMA tipo IDENTIFICADOR parte_arreglo
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
       |  tipo IDENTIFICADOR parte_arreglo
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
       ;

parte_arreglo
       :  COR_ABR COR_CER parte_arreglo
            { 
              if (banderafunc==0)
              {
              nuevaTablaS();
              banderafunc=1;
              }
            }
       |  { 
            if (banderafunc==0)
              {
              nuevaTablaS();
              banderafunc=1;
              }
          }
       ;

sentencia
       :  sentencia sentencias  
          { 
            SP_sig=creaEtiqueta();
            S_sig=SP_sig;                          /*???*/
            S_codigo=SP_codigo+SP_sig+SP2_codigo;
          }
       |  { 
            S_sig=creaEtiqueta();
            P_codigo=S_codigo+S_sig;
          }
       ;

sentencias
       :  IF ABR_PARENT condicion CER_PARENT sentencia 
          { B_verdadero=creaEtiqueta();
            B_falso=S_sig;
            SP_sig=S_sig;
            S_codigo=B_codigo+B_verdadero+SP_sig;
          }
       |  IF ABR_PARENT condicion CER_PARENT sentencias %prec ELSE sentencia 
          {
            B_verdadero=creaEtiqueta();
            B_falso=creaEtiqueta();
            SP_sig=S_sig;
            SP2_sig=S_sig;
            S_codigo=B_codigo+B_verdadero+SP_codigo+"goto"+SP_sig+B_falso+SP2_codigo;
          }
       |  WHILE ABR_PARENT condicion CER_PARENT sentencia 
          {
            B_verdadero=creaEtiqueta();
            B_falso=S_sig;
            SP_sig=creaEtiqueta();
            S_codigo=SP_sig+B_codigo+B_verdadero+SP_codigo+"goto"+SP_sig;
          }
       |  DO sentencia WHILE ABR_PARENT condicion CER_PARENT PYC 
          {
            SP_sig=creaEtiqueta();
            B_verdadero=creaEtiqueta();
            B_falso=S_sig;
            S_codigo=B_verdadero+SP_codigo+SP_sig+B_codigo;
          }
       |  FOR ABR_PARENT sentencia PYC condicion PYC sentencia CER_PARENT sentencia 
          { 
            SP_sig=creaEtiqueta();
            SP3_sig=creaEtiqueta();
            SP2_sig=SP_sig;
            B_verdadero=creaEtiqueta();
            B_falso=S_sig;
            S_codigo=SP_codigo+SP_sig+B_codigo+B_verdadero+SP3_codigo+SP3_sig+SP2_codigo+"goto"+SP2_sig;
          }
       |  parte_izquierda ASIG expresion PYC 
          {
            S_codigo=E_codigo+analex.getIdenti()+"="+E_dir;
          }
       |  RETURN expresion PYC 
          {
          System.out.println("sentencias");
          }
       |  RETURN PYC 
          { 
          System.out.println("sentencias");
          }
       |  LLAVE_ABR sentencia LLAVE_CER
          {
            SP_sig=S_sig;
            S_codigo=SP_codigo;
          }
       |  SWITCH ABR_PARENT expresion CER_PARENT LLAVE_ABR casos predeterminado LLAVE_CER 
          { 
          System.out.println("sentencias");
          }
       |  BREAK PYC
          {
          System.out.println("sentencias");
          }
       |  PRINT expresion PYC
          {
          System.out.println("sentencias");
          }
       ;

casos
       :  CASE DOSP NUM sentencia predeterminado {System.out.println("casos");}
       | {System.out.println("casos");}
       ;

predeterminado
       :  DEF DOSP sentencia {System.out.println("predeterminado");}
       | {System.out.println("predeterminado");}
       ;

parte_izquierda
       :  IDENTIFICADOR {System.out.println("parte_izquierda");}
       |  var_arreglo   {System.out.println("parte_izquierda");}
       |  IDENTIFICADOR PUNTO IDENTIFICADOR   {System.out.println("parte_izquierda");}
       ;

var_arreglo
       :  IDENTIFICADOR COR_ABR expresion COR_CER {System.out.println("var_arreglo");}
       |  var_arreglo COR_ABR expresion COR_CER {System.out.println("var_arreglo");}
       ;

expresion
       :  expresion OP_MAS expresion {System.out.println("expresion");}
       |  expresion OP_MENOS expresion {System.out.println("expresion");}
       |  expresion OP_MULT expresion {System.out.println("expresion");}
       |  expresion OP_DIV expresion {System.out.println("expresion");}
       |  expresion OP_MOD expresion {System.out.println("expresion");}
       |  var_arreglo {System.out.println("expresion");}
       |  CONS {System.out.println("expresion");}
       |  NUM {System.out.println("expresion");}
       |  IDENTIFICADOR ABR_PARENT parametros CER_PARENT   {System.out.println("expresion");}
       ;

parametros 
       :  lista_param {System.out.println("parametros");}
       | {System.out.println("parametros");}
       ;

lista_param
       :  lista_param COMA expresion {System.out.println("lista_param");}
       |  expresion {System.out.println("lista_param");}
       ;

condicion
       :  condicion OP_AND_OR condicion {System.out.println("condicion");}
       |  OP_NEG  condicion {System.out.println("condicion");}
       |  ABR_PARENT condicion CER_PARENT  {System.out.println("condicion");}
       |  expresion relacional expresion {System.out.println("condicion");}
       |  TRUE {System.out.println("condicion");}
       |  FALSE {System.out.println("condicion");}
       ;

relacional
       :  OP_REL {System.out.println("relacional");}
       ;



%%

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
