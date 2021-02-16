/*Primera Seccion*/
import java_cup.runtime.*;

%%

%class Lexema
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
Operador = ("+"|"-"|"*"|"/")
Parentesis_Abierto= "("
Parentesis_Cerrado= ")"
Coma = ","
Numero = [0-9]+ [.(0-9)+]
Graficar = "graficar"
Animar = "animar objeto anterior"
Curva = curva
Circulo = "circulo"
Cuadrado = "cuadrado"
Rectangulo = "rectangulo"
Linea = "linea"
Poligono = "poligono"

//Secciones de codigo incrustadas
%{
%}


//Separador de area
%%

// Reglas Lexicas
<YYINITIAL> {
	{Color}   {return new Symbol(COLOR, yyline + 1, yycolumn + 1);}
	{Parentesis_Abierto}   {return new Symbol(OPENPARENTHESIS, yyline + 1, yycolumn + 1);}
	{Parentesis_Cerrado}   {return new Symbol(CLOSEPARENTHESIS, yyline + 1, yycolumn + 1);}
	{Circulo}   {return new Symbol(CIRCLE, yyline + 1, yycolumn + 1);}
	{Cuadrado}   {return new Symbol(SQUARE, yyline + 1, yycolumn + 1);}
	{Rectangulo}   {return new Symbol(RECTANGLE, yyline + 1, yycolumn + 1);}
	{Linea}   {return new Symbol(LINE, yyline + 1, yycolumn + 1);}
	{Poligono}  {return new Symbol(POLYGON, yyline + 1, yycolumn + 1);}
	{Graficar}   {return new Symbol(CHART, yyline + 1, yycolumn + 1);}
	{Animar}   {return new Symbol(ANIMATE, yyline + 1, yycolumn + 1);}
	{Curva}   {return new Symbol(CURVE, yyline + 1, yycolumn + 1);}
	{Operador}   {return new Symbol(OPERATOR, yyline + 1, yycolumn + 1);}
	{Numero}   {return new Symbol(NUMBER, yyline + 1, yycolumn + 1);}
	{Coma}   {return new Symbol(COMA, yyline + 1, yycolumn + 1);}
	{WhiteSpace} {/* ignore */}
}


[^]	{System.out.println("Error en el lexema: "+yytext());}
