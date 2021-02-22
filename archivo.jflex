/*Primera Seccion*/
package com.example.Parser;
import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.List;
import static com.example.Parser.sym.*;
import com.example.Errors.ErrorLexico;
import com.example.Errors.TokenHandler;
%%

%class Scanner
%cup
%unicode
%line
%column
%public
/*Expresiones Regulares*/
LineTerminator = [\r|\n|\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

//Expresion regular para graficar 
Color = (azul | rojo | verde | amarillo | naranja | morado | cafe | negro)
Suma = "+"
Resta = "-"
Multiplicacion = "*"
Division = "/"
Parentesis_Abierto= "("
Parentesis_Cerrado= ")"
Coma = ","
Numero = [0-9]+ [ "."(0-9)]?
Graficar = "graficar"
Animar = "animar objeto anterior"
Curva = "curva"
Circulo = "circulo"
Cuadrado = "cuadrado"
Rectangulo = "rectangulo"
Linea = "linea"
Poligono = "poligono"

//Secciones de codigo incrustadas
%{
	TokenHandler tokenHandler = new TokenHandler();
	ArrayList<ErrorLexico> mistakes;
	private Symbol Mistake(String lexema){
		String mistake = "Error: "+lexema+", en Linea: "+(yyline+1)+", en Columna: "+(yycolumn+1);
		ErrorLexico error = new ErrorLexico(lexema, (yyline+1), (yycolumn+1));
		mistakes.add(error);
      return null;
    }
	public ArrayList<ErrorLexico> getErrorList() {
		return mistakes;
	}
	public void uploadToken(String token){
		tokenHandler.AddToken(token, yytext(), yyline+1, yycolumn+1);
	}
	
	public TokenHandler getTokenHandler(){
		return tokenHandler;
	}
%}
%init{
	mistakes = new ArrayList<>();
%init}

//Separador de area
%%

// Reglas Lexicas
<YYINITIAL> {
	{Color}   { uploadToken("COLOR");return new Symbol(COLOR, yyline + 1, yycolumn + 1, yytext());}
	{Parentesis_Abierto}   {uploadToken("OPENPARENTHESIS");return new Symbol(OPENPARENTHESIS, yyline + 1, yycolumn + 1); }
	{Parentesis_Cerrado}   {uploadToken("CLOSEPARENTHESIS");return new Symbol(CLOSEPARENTHESIS, yyline + 1, yycolumn + 1);  }
	{Circulo}   {uploadToken("CIRCLE");return new Symbol(CIRCLE, yyline + 1, yycolumn + 1); }
	{Cuadrado}   {uploadToken("SQUARE");return new Symbol(SQUARE, yyline + 1, yycolumn + 1); }
	{Rectangulo}   {uploadToken("RECTANGLE");return new Symbol(RECTANGLE, yyline + 1, yycolumn + 1); }
	{Linea}   {uploadToken("LINE");return new Symbol(LINE, yyline + 1, yycolumn + 1); }
	{Poligono}  {uploadToken("POLYGON");return new Symbol(POLYGON, yyline + 1, yycolumn + 1); }
	{Graficar}   {uploadToken("CHART");return new Symbol(CHART, yyline + 1, yycolumn + 1); }
	{Animar}   {uploadToken("ANIMATE");return new Symbol(ANIMATE, yyline + 1, yycolumn + 1); }
	{Curva}   {uploadToken("CURVE");return new Symbol(CURVE, yyline + 1, yycolumn + 1); }
	{Suma}   {uploadToken("SUMA");return new Symbol(SUMA, yyline + 1, yycolumn + 1, yytext()); }
	{Resta}   {uploadToken("MINUS");return new Symbol(MINUS, yyline + 1, yycolumn + 1, yytext()); }
	{Multiplicacion}   {uploadToken("TIMES");return new Symbol(TIMES, yyline + 1, yycolumn + 1, yytext()); }
	{Division}   {uploadToken("DIV");return new Symbol(DIV, yyline + 1, yycolumn + 1, yytext()); }
	{Numero}   {uploadToken("NUMBER");return new Symbol(NUMBER, yyline + 1, yycolumn + 1, yytext()); }
	{Coma}   {uploadToken("COMA");return new Symbol(COMA, yyline + 1, yycolumn + 1); }
	{WhiteSpace} {/* ignore */}
}


[^]	{System.out.println("Error en el lexema: "+yytext()); return Mistake(yytext());}
