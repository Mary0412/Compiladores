/* The following code was generated by JFlex 1.4.3 on 3/12/18 12:56 AM */

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 3/12/18 12:56 AM from the specification file
 * <tt>prueba.l</tt>
 */
class Yylex {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\57\1\6\25\0\1\57\1\32\1\5\2\0\1\27\1\30"+
    "\1\7\1\12\1\13\1\25\1\23\1\21\1\24\1\4\1\26\12\3"+
    "\1\22\1\20\1\33\1\11\1\33\2\0\32\1\1\16\1\10\1\17"+
    "\1\0\1\2\1\0\1\42\1\45\1\47\1\43\1\46\1\37\1\1"+
    "\1\50\1\34\1\1\1\55\1\40\1\1\1\35\1\41\1\56\1\1"+
    "\1\51\1\53\1\36\1\44\1\52\1\54\3\1\1\14\1\31\1\15"+
    "\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\1\1\5\1\1"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\2\1"+
    "\1\25\1\26\14\2\1\27\1\30\1\0\1\31\2\0"+
    "\1\26\1\32\1\2\1\33\5\2\1\34\13\2\2\31"+
    "\1\35\2\2\1\36\16\2\1\37\2\2\1\40\3\2"+
    "\1\41\1\42\1\43\1\2\1\44\4\2\1\45\1\46"+
    "\2\2\1\47\3\2\1\50\1\51\1\52\1\2\1\53"+
    "\1\54\1\55\1\56";

  private static int [] zzUnpackAction() {
    int [] result = new int[118];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\60\0\140\0\220\0\60\0\300\0\60\0\360"+
    "\0\u0120\0\60\0\60\0\60\0\60\0\60\0\60\0\60"+
    "\0\60\0\60\0\60\0\60\0\60\0\60\0\60\0\u0150"+
    "\0\u0180\0\u0120\0\u0120\0\u01b0\0\u01e0\0\u0210\0\u0240\0\u0270"+
    "\0\u02a0\0\u02d0\0\u0300\0\u0330\0\u0360\0\u0390\0\u03c0\0\u03f0"+
    "\0\u0420\0\300\0\300\0\u0450\0\u0480\0\60\0\60\0\u04b0"+
    "\0\140\0\u04e0\0\u0510\0\u0540\0\u0570\0\u05a0\0\u05d0\0\u0600"+
    "\0\u0630\0\u0660\0\u0690\0\u06c0\0\u06f0\0\u0720\0\u0750\0\u0780"+
    "\0\u07b0\0\u07e0\0\60\0\u0450\0\140\0\u0810\0\u0840\0\140"+
    "\0\u0870\0\u08a0\0\u08d0\0\u0900\0\u0930\0\u0960\0\u0990\0\u09c0"+
    "\0\u09f0\0\u0a20\0\u0a50\0\u0a80\0\u0ab0\0\u0ae0\0\140\0\u0b10"+
    "\0\u0b40\0\140\0\u0b70\0\u0ba0\0\u0bd0\0\140\0\140\0\140"+
    "\0\u0c00\0\140\0\u0c30\0\u0c60\0\u0c90\0\u0cc0\0\140\0\140"+
    "\0\u0cf0\0\u0d20\0\140\0\u0d50\0\u0d80\0\u0db0\0\140\0\140"+
    "\0\140\0\u0de0\0\140\0\140\0\140\0\140";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[118];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\2\1\4\1\5\1\6\1\7\1\10"+
    "\1\2\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\3\1\35\1\36"+
    "\3\3\1\37\1\3\1\40\1\41\1\42\1\3\1\43"+
    "\1\44\1\45\1\46\1\3\1\47\1\50\61\0\3\3"+
    "\30\0\23\3\4\0\1\4\1\51\53\0\5\52\1\53"+
    "\1\0\51\52\6\54\1\0\1\54\1\55\47\54\11\0"+
    "\1\56\76\0\1\57\60\0\1\57\27\0\3\3\30\0"+
    "\1\3\1\60\1\3\1\61\17\3\2\0\3\3\30\0"+
    "\15\3\1\62\5\3\2\0\3\3\30\0\4\3\1\63"+
    "\1\64\1\65\1\3\1\66\12\3\2\0\3\3\30\0"+
    "\5\3\1\67\4\3\1\70\10\3\2\0\3\3\30\0"+
    "\15\3\1\71\5\3\2\0\3\3\30\0\4\3\1\72"+
    "\16\3\2\0\3\3\30\0\6\3\1\73\5\3\1\74"+
    "\6\3\2\0\3\3\30\0\12\3\1\75\10\3\2\0"+
    "\3\3\30\0\5\3\1\76\15\3\2\0\3\3\30\0"+
    "\2\3\1\77\15\3\1\100\2\3\2\0\3\3\30\0"+
    "\14\3\1\101\6\3\2\0\3\3\30\0\15\3\1\102"+
    "\5\3\60\0\1\50\3\0\1\51\63\0\1\103\50\0"+
    "\6\54\1\0\1\104\50\54\1\0\3\3\30\0\2\3"+
    "\1\105\20\3\2\0\3\3\30\0\10\3\1\106\12\3"+
    "\2\0\3\3\30\0\5\3\1\107\15\3\2\0\3\3"+
    "\30\0\15\3\1\110\5\3\2\0\3\3\30\0\4\3"+
    "\1\111\16\3\2\0\3\3\30\0\1\3\1\112\21\3"+
    "\2\0\3\3\30\0\10\3\1\113\12\3\2\0\3\3"+
    "\30\0\3\3\1\114\17\3\2\0\3\3\30\0\12\3"+
    "\1\115\10\3\2\0\3\3\30\0\17\3\1\116\3\3"+
    "\2\0\3\3\30\0\17\3\1\117\3\3\2\0\3\3"+
    "\30\0\6\3\1\120\14\3\2\0\3\3\30\0\2\3"+
    "\1\121\20\3\2\0\3\3\30\0\1\122\22\3\2\0"+
    "\3\3\30\0\15\3\1\123\5\3\2\0\3\3\30\0"+
    "\1\124\22\3\2\0\3\3\30\0\1\125\22\3\2\0"+
    "\3\3\30\0\1\126\22\3\2\0\3\3\30\0\12\3"+
    "\1\127\10\3\2\0\3\3\30\0\6\3\1\130\14\3"+
    "\2\0\3\3\30\0\17\3\1\131\3\3\2\0\3\3"+
    "\30\0\13\3\1\132\7\3\2\0\3\3\30\0\11\3"+
    "\1\133\11\3\2\0\3\3\30\0\6\3\1\134\14\3"+
    "\2\0\3\3\30\0\6\3\1\135\14\3\2\0\3\3"+
    "\30\0\12\3\1\136\10\3\2\0\3\3\30\0\12\3"+
    "\1\137\10\3\2\0\3\3\30\0\15\3\1\140\5\3"+
    "\2\0\3\3\30\0\10\3\1\141\12\3\2\0\3\3"+
    "\30\0\7\3\1\142\13\3\2\0\3\3\30\0\10\3"+
    "\1\143\12\3\2\0\3\3\30\0\2\3\1\144\20\3"+
    "\2\0\3\3\30\0\4\3\1\145\16\3\2\0\3\3"+
    "\30\0\1\3\1\146\21\3\2\0\3\3\30\0\2\3"+
    "\1\147\20\3\2\0\3\3\30\0\12\3\1\150\10\3"+
    "\2\0\3\3\30\0\4\3\1\151\16\3\2\0\3\3"+
    "\30\0\10\3\1\152\12\3\2\0\3\3\30\0\21\3"+
    "\1\153\1\3\2\0\3\3\30\0\15\3\1\154\5\3"+
    "\2\0\3\3\30\0\13\3\1\155\7\3\2\0\3\3"+
    "\30\0\13\3\1\156\7\3\2\0\3\3\30\0\12\3"+
    "\1\157\10\3\2\0\3\3\30\0\2\3\1\160\20\3"+
    "\2\0\3\3\30\0\12\3\1\161\10\3\2\0\3\3"+
    "\30\0\4\3\1\162\16\3\2\0\3\3\30\0\1\3"+
    "\1\163\21\3\2\0\3\3\30\0\2\3\1\164\20\3"+
    "\2\0\3\3\30\0\14\3\1\165\6\3\2\0\3\3"+
    "\30\0\2\3\1\166\20\3\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3600];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\1\1\1\11\2\1\16\11"+
    "\22\1\1\0\1\1\2\0\2\11\23\1\1\11\63\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[118];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */

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
  



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Yylex(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Yylex(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 122) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 39: 
          { valor=yytext();
          return Parser.BREAK ;
          }
        case 47: break;
        case 19: 
          { valor=yytext();
          yyparser.yylval = new ParserVal( new Character(yytext().charAt(0)) ) ;
          return Parser.OP_DIV ;
          }
        case 48: break;
        case 40: 
          { valor=yytext();
          return Parser.WHILE ;
          }
        case 49: break;
        case 9: 
          { valor=yytext();
          return Parser.LLAVE_ABR ;
          }
        case 50: break;
        case 24: 
          { number=yytext();
          yyparser.yylval = new ParserVal( new Double(yytext()) ); 
          return Parser.NUM ;
          }
        case 51: break;
        case 43: 
          { valor=yytext();
          return Parser.RETURN ;
          }
        case 52: break;
        case 20: 
          { valor=yytext();
          yyparser.yylval = new ParserVal( new Character(yytext().charAt(0)) ) ;
          return Parser.OP_MOD ;
          }
        case 53: break;
        case 3: 
          { number=yytext();
          yyparser.yylval = new ParserVal( new Integer(yytext()) );
          return Parser.NUM ;
          }
        case 54: break;
        case 23: 
          { /** ignorar espacios en blanco **/
          }
        case 55: break;
        case 31: 
          { valor=yytext();
          return Parser.TRUE ;
          }
        case 56: break;
        case 37: 
          { valor=yytext();
          return Parser.FLOAT ;
          }
        case 57: break;
        case 5: 
          { // lleva la cuenta de lineas 
         linea_actual ++ ;
          }
        case 58: break;
        case 36: 
          { valor=yytext();
          return Parser.VOID ;
          }
        case 59: break;
        case 34: 
          { valor=yytext();
          return Parser.CASE ;
          }
        case 60: break;
        case 2: 
          { identi=yytext();
          yyparser.yylval = new ParserVal( (Object) yytext() ); 
          return Parser.IDENTIFICADOR ;
          }
        case 61: break;
        case 33: 
          { valor=yytext();
          return Parser.ELSE ;
          }
        case 62: break;
        case 41: 
          { valor=yytext();
          return Parser.PRINT ;
          }
        case 63: break;
        case 22: 
          { valor=yytext();
          return Parser.OP_REL ;
          }
        case 64: break;
        case 44: 
          { valor=yytext();
          return Parser.STRUCT ;
          }
        case 65: break;
        case 42: 
          { valor=yytext();
          return Parser.DOUBLE ;
          }
        case 66: break;
        case 45: 
          { valor=yytext();
          return Parser.SWITCH ;
          }
        case 67: break;
        case 29: 
          { valor=yytext();
          return Parser.INT ;
          }
        case 68: break;
        case 7: 
          { valor=yytext();
          return Parser.ABR_PARENT ;
          }
        case 69: break;
        case 14: 
          { valor=yytext();
          return Parser.COMA ;
          }
        case 70: break;
        case 35: 
          { valor=yytext();
          return Parser.CHAR ;
          }
        case 71: break;
        case 12: 
          { valor=yytext();
          return Parser.COR_CER ;
          }
        case 72: break;
        case 38: 
          { valor=yytext();
          return Parser.FALSE ;
          }
        case 73: break;
        case 32: 
          { valor=yytext();
          return Parser.FUNC ;
          }
        case 74: break;
        case 4: 
          { valor=yytext();
          return Parser.PUNTO ;
          }
        case 75: break;
        case 26: 
          { valor=yytext();
          return Parser.OP_AND_OR ;
          }
        case 76: break;
        case 28: 
          { valor=yytext();
          return Parser.DO ;
          }
        case 77: break;
        case 1: 
          { /** cualquier otra cosa produce un mensaje de error **/
          yyparser.yyerror("el(los) carácter(es) '"+yytext()+"' no forma(n) ningún token conocido");
          }
        case 78: break;
        case 27: 
          { valor=yytext();
          return Parser.IF ;
          }
        case 79: break;
        case 15: 
          { valor=yytext();
          return Parser.DOSP ;
          }
        case 80: break;
        case 16: 
          { valor=yytext();
          yyparser.yylval = new ParserVal( new Character(yytext().charAt(0)) ) ;
          return Parser.OP_MAS ;
          }
        case 81: break;
        case 46: 
          { valor=yytext();
          return Parser.DEF ;
          }
        case 82: break;
        case 25: 
          { valor=yytext();
          return Parser.CONS ;
          }
        case 83: break;
        case 10: 
          { valor=yytext();
          return Parser.LLAVE_CER ;
          }
        case 84: break;
        case 11: 
          { valor=yytext();
          return Parser.COR_ABR ;
          }
        case 85: break;
        case 8: 
          { valor=yytext();
          return Parser.CER_PARENT ;
          }
        case 86: break;
        case 30: 
          { valor=yytext();
          return Parser.FOR ;
          }
        case 87: break;
        case 17: 
          { valor=yytext();
          yyparser.yylval = new ParserVal( new Character(yytext().charAt(0)) ) ;
          return Parser.OP_MENOS ;
          }
        case 88: break;
        case 18: 
          { valor=yytext();
          yyparser.yylval = new ParserVal( new Character(yytext().charAt(0)) ) ;
          return Parser.OP_MULT ;
          }
        case 89: break;
        case 13: 
          { valor=yytext();
          return Parser.PYC ;
          }
        case 90: break;
        case 6: 
          { valor=yytext();
          return Parser.ASIG ;
          }
        case 91: break;
        case 21: 
          { valor=yytext();
          return Parser.OP_NEG ;
          }
        case 92: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return 0; }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
