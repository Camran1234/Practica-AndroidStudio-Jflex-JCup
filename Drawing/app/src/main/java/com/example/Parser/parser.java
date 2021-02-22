
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.example.Parser;

import java_cup.runtime.*;
import com.example.Shapes.*;
import com.example.Errors.ErrorSintactico;
import java.util.ArrayList;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\033\000\002\002\004\000\002\002\006\000\002\002" +
    "\002\000\002\002\003\000\002\012\006\000\002\012\002" +
    "\000\002\003\006\000\002\003\006\000\002\003\006\000" +
    "\002\003\006\000\002\003\006\000\002\003\003\000\002" +
    "\013\005\000\002\013\005\000\002\013\005\000\002\013" +
    "\005\000\002\013\005\000\002\013\003\000\002\013\003" +
    "\000\002\014\003\000\002\014\003\000\002\004\007\000" +
    "\002\005\011\000\002\006\011\000\002\007\013\000\002" +
    "\010\013\000\002\011\015" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\140\000\010\002\uffff\003\004\014\005\001\002\000" +
    "\004\002\ufffe\001\002\000\016\003\012\007\014\010\016" +
    "\011\010\012\015\013\011\001\002\000\004\002\007\001" +
    "\002\000\004\002\001\001\002\000\004\005\127\001\002" +
    "\000\004\005\111\001\002\000\012\002\ufff6\003\ufff6\014" +
    "\ufff6\015\ufff6\001\002\000\012\002\ufffc\003\ufffc\014\ufffc" +
    "\015\075\001\002\000\004\005\062\001\002\000\004\005" +
    "\046\001\002\000\004\005\017\001\002\000\010\003\021" +
    "\005\020\023\023\001\002\000\010\003\021\005\020\023" +
    "\023\001\002\000\016\006\uffef\017\uffef\020\uffef\021\uffef" +
    "\022\uffef\024\uffef\001\002\000\004\006\043\001\002\000" +
    "\016\006\ufff0\017\ufff0\020\ufff0\021\ufff0\022\ufff0\024\ufff0" +
    "\001\002\000\014\017\026\020\027\021\031\022\030\024" +
    "\025\001\002\000\010\003\021\005\020\023\023\001\002" +
    "\000\010\003\021\005\020\023\023\001\002\000\010\003" +
    "\021\005\020\023\023\001\002\000\010\003\021\005\020" +
    "\023\023\001\002\000\010\003\021\005\020\023\023\001" +
    "\002\000\016\006\ufff3\017\ufff3\020\ufff3\021\ufff3\022\ufff3" +
    "\024\ufff3\001\002\000\016\006\ufff2\017\ufff2\020\ufff2\021" +
    "\ufff2\022\ufff2\024\ufff2\001\002\000\016\006\ufff5\017\ufff5" +
    "\020\ufff5\021\031\022\030\024\ufff5\001\002\000\016\006" +
    "\ufff4\017\ufff4\020\ufff4\021\031\022\030\024\ufff4\001\002" +
    "\000\014\017\026\020\027\021\031\022\030\024\037\001" +
    "\002\000\010\003\021\005\020\023\023\001\002\000\014" +
    "\017\026\020\027\021\031\022\030\024\041\001\002\000" +
    "\004\004\042\001\002\000\004\006\uffea\001\002\000\012" +
    "\002\ufffa\003\ufffa\014\ufffa\015\ufffa\001\002\000\014\006" +
    "\045\017\026\020\027\021\031\022\030\001\002\000\016" +
    "\006\ufff1\017\ufff1\020\ufff1\021\ufff1\022\ufff1\024\ufff1\001" +
    "\002\000\010\003\021\005\020\023\023\001\002\000\004" +
    "\006\061\001\002\000\014\017\026\020\027\021\031\022" +
    "\030\024\051\001\002\000\010\003\021\005\020\023\023" +
    "\001\002\000\014\017\026\020\027\021\031\022\030\024" +
    "\053\001\002\000\010\003\021\005\020\023\023\001\002" +
    "\000\014\017\026\020\027\021\031\022\030\024\055\001" +
    "\002\000\010\003\021\005\020\023\023\001\002\000\014" +
    "\017\026\020\027\021\031\022\030\024\057\001\002\000" +
    "\004\004\060\001\002\000\004\006\uffe8\001\002\000\012" +
    "\002\ufff8\003\ufff8\014\ufff8\015\ufff8\001\002\000\010\003" +
    "\021\005\020\023\023\001\002\000\004\006\073\001\002" +
    "\000\014\017\026\020\027\021\031\022\030\024\065\001" +
    "\002\000\010\003\021\005\020\023\023\001\002\000\014" +
    "\017\026\020\027\021\031\022\030\024\067\001\002\000" +
    "\010\003\021\005\020\023\023\001\002\000\014\017\026" +
    "\020\027\021\031\022\030\024\071\001\002\000\004\004" +
    "\072\001\002\000\004\006\uffeb\001\002\000\012\002\ufffb" +
    "\003\ufffb\014\ufffb\015\ufffb\001\002\000\010\002\uffff\003" +
    "\004\014\005\001\002\000\004\005\076\001\002\000\010" +
    "\003\021\005\020\023\023\001\002\000\004\006\107\001" +
    "\002\000\014\017\026\020\027\021\031\022\030\024\101" +
    "\001\002\000\010\003\021\005\020\023\023\001\002\000" +
    "\014\017\026\020\027\021\031\022\030\024\103\001\002" +
    "\000\006\012\104\016\106\001\002\000\004\006\uffee\001" +
    "\002\000\004\006\uffec\001\002\000\004\006\uffed\001\002" +
    "\000\010\002\ufffd\003\ufffd\014\ufffd\001\002\000\004\002" +
    "\000\001\002\000\010\003\021\005\020\023\023\001\002" +
    "\000\004\006\126\001\002\000\014\017\026\020\027\021" +
    "\031\022\030\024\114\001\002\000\010\003\021\005\020" +
    "\023\023\001\002\000\014\017\026\020\027\021\031\022" +
    "\030\024\116\001\002\000\010\003\021\005\020\023\023" +
    "\001\002\000\014\017\026\020\027\021\031\022\030\024" +
    "\120\001\002\000\010\003\021\005\020\023\023\001\002" +
    "\000\014\017\026\020\027\021\031\022\030\024\122\001" +
    "\002\000\010\003\021\005\020\023\023\001\002\000\014" +
    "\017\026\020\027\021\031\022\030\024\124\001\002\000" +
    "\004\004\125\001\002\000\004\006\uffe7\001\002\000\012" +
    "\002\ufff7\003\ufff7\014\ufff7\015\ufff7\001\002\000\010\003" +
    "\021\005\020\023\023\001\002\000\004\006\142\001\002" +
    "\000\014\017\026\020\027\021\031\022\030\024\132\001" +
    "\002\000\010\003\021\005\020\023\023\001\002\000\014" +
    "\017\026\020\027\021\031\022\030\024\134\001\002\000" +
    "\010\003\021\005\020\023\023\001\002\000\014\017\026" +
    "\020\027\021\031\022\030\024\136\001\002\000\010\003" +
    "\021\005\020\023\023\001\002\000\014\017\026\020\027" +
    "\021\031\022\030\024\140\001\002\000\004\004\141\001" +
    "\002\000\004\006\uffe9\001\002\000\012\002\ufff9\003\ufff9" +
    "\014\ufff9\015\ufff9\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\140\000\004\002\005\001\001\000\002\001\001\000" +
    "\004\003\012\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\012\073\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\006\021\013\023\001\001\000" +
    "\004\013\043\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\013\035\001" +
    "\001\000\004\013\034\001\001\000\004\013\033\001\001" +
    "\000\004\013\032\001\001\000\004\013\031\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\013\037\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\010" +
    "\046\013\047\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\013\051\001\001\000\002\001\001\000\004\013" +
    "\053\001\001\000\002\001\001\000\004\013\055\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\006\005\062\013\063\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\013\065\001\001\000" +
    "\002\001\001\000\004\013\067\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\002\107\001\001\000\002\001\001\000\006\004\076" +
    "\013\077\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\013\101\001\001\000\002\001\001\000\004\014\104" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\006\011\111" +
    "\013\112\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\013\114\001\001\000\002\001\001\000\004\013\116" +
    "\001\001\000\002\001\001\000\004\013\120\001\001\000" +
    "\002\001\001\000\004\013\122\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\007\127\013\130\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\013\132\001\001\000\002\001\001\000" +
    "\004\013\134\001\001\000\002\001\001\000\004\013\136" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



	ArrayList<Circle> circles = new ArrayList<>();
	ArrayList<Square> squares = new ArrayList<>();
	ArrayList<Line> lines = new ArrayList<>();	
	ArrayList<Rectangle> rectangles = new ArrayList<>();
	ArrayList<Polygon> polygons = new ArrayList<>();
	ArrayList<Animation> animations = new ArrayList<>();
	ArrayList<ErrorSintactico> errorSintacticos = new ArrayList<>();
	Shape lastProduction;

	public parser (Scanner lexema){
		super(lexema);
	}
	public ArrayList<ErrorSintactico> getMistakes(){
		return errorSintacticos;
	}
	public ArrayList<Circle> getCircles(){
		return this.circles;
	}		
	public ArrayList<Square> getSquares(){
		return this.squares;
	}
	public ArrayList<Line> getLines(){
		return this.lines;
	}
	public ArrayList<Rectangle> getRectangles(){
		return this.rectangles;
	}
	public ArrayList<Polygon> getPolygons(){
		return this.polygons;
	}
	public ArrayList<Animation> getAnimations(){
		return this.animations;
	}
@Override
	public void syntax_error(Symbol symbol){
	    report_expected_token_ids();
	    int line = symbol.left;
	    int column = symbol.right;
	    String token = (String) cur_token.value;
	    //Obtenemos la produccion
        String errorArmado="";
        for(int index=0; index<expected_token_ids().size() ; index++){
            errorArmado += symbl_name_from_id(expected_token_ids().get(index));
        }
	    String error = "Se esperaba la forma: " + errorArmado;
        errorSintacticos.add(new ErrorSintactico(token, line, column, error));
    	}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= g EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // g ::= CHART gr u g 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("g",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // g ::= 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("g",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // g ::= error 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("g",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // u ::= ANIMATE OPENPARENTHESIS a CLOSEPARENTHESIS 
            {
              Object RESULT =null;
		 System.out.println("Animacion Encontrada: "); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("u",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // u ::= 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("u",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // gr ::= CIRCLE OPENPARENTHESIS c CLOSEPARENTHESIS 
            {
              Object RESULT =null;
		 System.out.println("Se encontro un circulo"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("gr",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // gr ::= SQUARE OPENPARENTHESIS s CLOSEPARENTHESIS 
            {
              Object RESULT =null;
		 System.out.println("Se encontro un cuadrado"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("gr",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // gr ::= RECTANGLE OPENPARENTHESIS r CLOSEPARENTHESIS 
            {
              Object RESULT =null;
		 System.out.println("Se encontro un rectangulo"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("gr",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // gr ::= LINE OPENPARENTHESIS l CLOSEPARENTHESIS 
            {
              Object RESULT =null;
		 System.out.println("Se encontro un linea"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("gr",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // gr ::= POLYGON OPENPARENTHESIS p CLOSEPARENTHESIS 
            {
              Object RESULT =null;
		 System.out.println("Se encontro un poligono"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("gr",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // gr ::= error 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("gr",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // op ::= op MINUS op 
            {
              Double RESULT =null;
		int o1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int o1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Double o1 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int o2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int o2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Double o2 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT= o1 - o2; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // op ::= op SUMA op 
            {
              Double RESULT =null;
		int o1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int o1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Double o1 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int o2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int o2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Double o2 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT=o1 + o2; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // op ::= op TIMES op 
            {
              Double RESULT =null;
		int o1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int o1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Double o1 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int o2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int o2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Double o2 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT= o1 * o2; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // op ::= op DIV op 
            {
              Double RESULT =null;
		int o1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int o1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Double o1 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int o2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int o2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Double o2 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT= o1 / o2; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // op ::= OPENPARENTHESIS op CLOSEPARENTHESIS 
            {
              Double RESULT =null;
		int o1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int o1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Double o1 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT= o1;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // op ::= NUMBER 
            {
              Double RESULT =null;
		int oleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int oright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object o = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT= Double.parseDouble(String.valueOf(o));
              CUP$parser$result = parser.getSymbolFactory().newSymbol("op",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // op ::= error 
            {
              Double RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("op",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // f ::= LINE 
            {
              String RESULT =null;
		 RESULT="linea"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("f",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // f ::= CURVE 
            {
              String RESULT =null;
		 RESULT="curva"; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("f",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // a ::= op COMA op COMA f 
            {
              Object RESULT =null;
		int n1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int n1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Double n1 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int n2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int n2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Double n2 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String t = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 System.out.println("Se encontro una animacion: "+n1+", "+n2+", "+t); 
	animations.add(new Animation(lastProduction, String.valueOf(n1), String.valueOf(n2),String.valueOf(t)));
              CUP$parser$result = parser.getSymbolFactory().newSymbol("a",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // c ::= op COMA op COMA op COMA COLOR 
            {
              Object RESULT =null;
		int n1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).left;
		int n1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).right;
		Double n1 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-6)).value;
		int n2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int n2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Double n2 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int n3left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int n3right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Double n3 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int clrleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int clrright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object clr = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 System.out.println("Circulo: "+n1+", "+n2+", "+n3+", "+clr); 
	circles.add(new Circle(String.valueOf(clr), String.valueOf(n1), String.valueOf(n2), String.valueOf(n3)  ));		
	lastProduction = circles.get(circles.size()-1);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("c",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // s ::= op COMA op COMA op COMA COLOR 
            {
              Object RESULT =null;
		int n1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).left;
		int n1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).right;
		Double n1 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-6)).value;
		int n2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int n2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Double n2 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int n3left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int n3right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Double n3 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int clrleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int clrright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object clr = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 System.out.println("Cuadrado: "+n1+", "+n2+", "+n3+", "+clr); 
	squares.add(new Square(String.valueOf(clr), String.valueOf(n1), String.valueOf(n2), String.valueOf(n3)  ));
		lastProduction = squares.get(squares.size()-1);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("s",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // r ::= op COMA op COMA op COMA op COMA COLOR 
            {
              Object RESULT =null;
		int n1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-8)).left;
		int n1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-8)).right;
		Double n1 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-8)).value;
		int n2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).left;
		int n2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).right;
		Double n2 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-6)).value;
		int n3left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int n3right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Double n3 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int n4left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int n4right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Double n4 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int clrleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int clrright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object clr = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 System.out.println("Rectangle: "+n1+", "+n2+", "+n3+", "+n4+", "+clr); 
	rectangles.add(new Rectangle(String.valueOf(clr), String.valueOf(n1), String.valueOf(n2), String.valueOf(n3), String.valueOf(n4)  ));
	lastProduction = rectangles.get(rectangles.size()-1);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("r",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-8)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // l ::= op COMA op COMA op COMA op COMA COLOR 
            {
              Object RESULT =null;
		int n1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-8)).left;
		int n1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-8)).right;
		Double n1 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-8)).value;
		int n2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).left;
		int n2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).right;
		Double n2 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-6)).value;
		int n3left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int n3right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Double n3 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int n4left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int n4right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Double n4 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int clrleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int clrright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object clr = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 System.out.println("Line: "+n1+", "+n2+", "+n3+", "+n4+", "+clr); 
	lines.add(new Line(String.valueOf(clr), String.valueOf(n1), String.valueOf(n2), String.valueOf(n3), String.valueOf(n4) ));
	lastProduction = lines.get(lines.size()-1);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("l",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-8)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // p ::= op COMA op COMA op COMA op COMA op COMA COLOR 
            {
              Object RESULT =null;
		int n1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-10)).left;
		int n1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-10)).right;
		Double n1 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-10)).value;
		int n2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-8)).left;
		int n2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-8)).right;
		Double n2 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-8)).value;
		int n3left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).left;
		int n3right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).right;
		Double n3 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-6)).value;
		int n4left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int n4right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Double n4 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int n5left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int n5right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Double n5 = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int clrleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int clrright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object clr = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 System.out.println("Polygon: "+n1+", "+n2+", "+n3+", "+n4+", "+n5+","+clr);
	polygons.add(new Polygon(String.valueOf(clr), String.valueOf(n1), String.valueOf(n2), String.valueOf(n3), String.valueOf(n4), String.valueOf(n5))); 	
	lastProduction = polygons.get(polygons.size()-1);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("p",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-10)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
