package com.example.drawing;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.Errors.ErrorLexico;
import com.example.Errors.ErrorSintactico;
import com.example.Errors.Ocurrencia;
import com.example.Errors.TokenHandler;
import com.example.Parser.parser;
import com.example.Shapes.*;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    int option;
    parser parser;
    int rowsToDraw;
    ArrayList<Circle> circulos;
    ArrayList<Square> cuadrados;
    ArrayList<Rectangle> rectangles;
    ArrayList<Line> lines;
    ArrayList<Polygon> polygon;
    ArrayList<Animation> animaciones;
    ArrayList<ArrayList> shapes = new ArrayList<>();
    ArrayList<Ocurrencia> ocurrencias;
    ArrayList<ErrorLexico> erroresLexicos;
    ArrayList<ErrorSintactico> erroresSintacticos;
    TokenHandler tokenHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        option =MainActivity.option ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        try {
            System.out.println("1");
            this.assignParser();
            System.out.println("2");
            this.assignOption();
            System.out.println("3");
            this.tableToDraw(option);
            System.out.println("Fin");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void assignParser(){
        System.out.println("Z1");
        System.out.println("Z2");
        this.parser = MainActivity.dataOfParser;
        if(MainActivity.withoutMistakes==true){
            System.out.println("Z3");
            circulos = parser.getCircles();
            System.out.println("Z4");
            cuadrados = parser.getSquares();
            rectangles = parser.getRectangles();
            lines = parser.getLines();
            polygon = parser.getPolygons();
            animaciones = parser.getAnimations();
            System.out.println("ZZZZZZZ");
        }
        System.out.println("Z80");
        erroresLexicos = MainActivity.scanner.getErrorList();
        if(parser==null){
            System.out.println("es nulo");
        }
        erroresSintacticos = parser.getMistakes();
        tokenHandler = MainActivity.scanner.getTokenHandler();

        shapes.add(circulos);
        shapes.add(cuadrados);
        shapes.add(rectangles);
        shapes.add(lines);
        shapes.add(polygon);
    }
    private void assignOption(){
        this.option = MainActivity.option;
    }
    private void tableToDraw(int option){

        TableLayout tableLayout =(TableLayout) findViewById(R.id.table);

        TableRow.LayoutParams  params1=new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT,1.0f);
        TableRow.LayoutParams params2=new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow row;
        switch  (option){
            //Reporte de ocurrencias de Operadores Matematicos
            case 1:
                ArrayList<String> formatos = new ArrayList<>();
                formatos.add("SUMA");
                formatos.add("MINUS");
                formatos.add("TIMES");
                formatos.add("DIV");
                TextView operador;
                TextView linea;
                TextView columna;
                TextView ocurrencia;
                ocurrencias = tokenHandler.generateListOnMultipleTokenBase(formatos);
                for(int index=0; index<ocurrencias.size()+1; index++){
                    row = new TableRow(this);
                    operador = new TextView(this);
                    linea = new TextView(this);
                    columna = new TextView(this);
                    ocurrencia = new TextView(this);

                    if(index==0){
                        operador.setBackgroundColor(Color.RED);
                        linea.setBackgroundColor(Color.RED);
                        operador.setBackgroundColor(Color.RED);
                        columna.setBackgroundColor(Color.RED);
                        ocurrencia.setBackgroundColor(Color.RED);

                        operador.setText("Operador");
                        linea.setText("Linea");
                        columna.setText("Columna");
                        ocurrencia.setText("Ocurrencia");

                    }else {
                        operador.setBackgroundColor(Color.WHITE);
                        linea.setBackgroundColor(Color.WHITE);
                        operador.setBackgroundColor(Color.WHITE);
                        columna.setBackgroundColor(Color.WHITE);
                        ocurrencia.setBackgroundColor(Color.WHITE);

                        operador.setText(ocurrencias.get(index-1).getType());
                        linea.setText(ocurrencias.get(index-1).getLine());
                        columna.setText(ocurrencias.get(index-1).getColumn());
                        ocurrencia.setText(ocurrencias.get(index-1).getOccurrence());
                    }
                    operador.setLayoutParams(params1);
                    linea.setLayoutParams(params1);
                    columna.setLayoutParams(params1);
                    ocurrencia.setLayoutParams(params1);

                        row.addView(operador);
                        row.addView(linea);
                        row.addView(columna);
                        row.addView(ocurrencia);
                        row.setLayoutParams(params2);
                        tableLayout.addView(row);
                }


                break;
                //Reporte de colores usados
            case 2:
                TextView textViewColor;
                TextView textViewColorTimes;
                ArrayList<String> colors = new ArrayList<>();
                //Obtenemos una lista de todos los colores
                for(int index=0; index<5; index++){
                    for(int indexShape=0; indexShape<shapes.get(index).size(); indexShape++){
                        Shape shapeColor =(Shape) shapes.get(index).get(indexShape);
                        colors.add(shapeColor.getColorAsString());
                    }
                }
                CompareColors compareColors = new CompareColors();
                compareColors.parseColors(colors);



                for(int index=0 ; index <9; index++){
                    row = new TableRow(this);
                    textViewColor = new TextView(this);
                    textViewColorTimes = new TextView(this);
                    int magnitud=0;
                    if(index==0){
                        textViewColorTimes.setBackgroundColor(Color.GREEN);
                        textViewColor.setBackgroundColor(Color.GREEN);

                        textViewColor.setText("Color");
                        textViewColorTimes.setText("Cantidad de Usos");
                        textViewColorTimes.setBackgroundColor(Color.GREEN);
                        textViewColor.setBackgroundColor(Color.GREEN);

                        textViewColor.setLayoutParams(params1);
                        textViewColorTimes.setLayoutParams(params1);
                    }else {
                        textViewColorTimes.setBackgroundColor(Color.WHITE);
                        textViewColor.setBackgroundColor(Color.WHITE);
                        magnitud = compareColors.getColorMagnitud(index);
                        textViewColor.setText(compareColors.getColor(index));
                        textViewColorTimes.setText(Integer.toString(magnitud));

                        textViewColor.setLayoutParams(params1);
                        textViewColorTimes.setLayoutParams(params1);
                    }
                    if(magnitud!=0 || index==0){
                        row.addView(textViewColor);
                        row.addView(textViewColorTimes);
                        row.setLayoutParams(params2);
                        tableLayout.addView(row);
                    }
                }
                break;
                //Reporte de objetos usados
            case 3:
                TextView textViewObject ;
                TextView textViewTimes ;
                Shape shape;
                for(int index=0 ; index <6; index++){
                    int magnitud=0;
                   row = new TableRow(this);
                    textViewObject = new TextView(this);
                    textViewTimes = new TextView(this);
                    if(index==0){
                        textViewTimes.setBackgroundColor(Color.YELLOW);
                        textViewObject.setBackgroundColor(Color.YELLOW);

                        textViewObject.setText("Objeto");
                        textViewTimes.setText("Cantidad de Usos");

                        textViewObject.setLayoutParams(params1);
                        textViewTimes.setLayoutParams(params1);
                    }else{
                        textViewTimes.setBackgroundColor(Color.WHITE);
                        textViewObject.setBackgroundColor(Color.WHITE);

                        magnitud =shapes.get(index-1).size();
                        try{
                            shape = (Shape) shapes.get(index-1).get(0);
                            textViewObject.setText(shape.typeObject());
                            textViewTimes.setText(Integer.toString(magnitud));

                            textViewObject.setLayoutParams(params1);
                            textViewTimes.setLayoutParams(params1);
                        }catch (Exception ex){

                        }

                    }

                    if(magnitud!=0 || index==0){
                        row.addView(textViewObject);
                        row.addView(textViewTimes);
                        row.setLayoutParams(params2);
                        tableLayout.addView(row);
                    }
                }

                break;
                //Reporte de animaciones hechas
            case 4:
                TextView textViewAnimation;
                TextView textViewAnimationRepeat;
                int timesAnimationLine=0;
                int timesAnimationCurve=0;
                //Obtenemos la cantidad de animaciones
                for(int index=0; index<animaciones.size(); index++){
                    if(animaciones.get(index).getAnimation()){
                        timesAnimationLine++;
                    }else{
                        timesAnimationCurve++;
                    }
                }
                //Agregamos los textos
                for(int index=0; index<3; index++){
                    row = new TableRow(this);
                    textViewAnimation = new TextView(this);
                    textViewAnimationRepeat = new TextView(this);
                    if(index==0){
                        textViewAnimation.setBackgroundColor(Color.GREEN);
                        textViewAnimationRepeat.setBackgroundColor(Color.GREEN);

                        textViewAnimation.setText("Animacion");
                        textViewAnimationRepeat.setText("Cantidad de veces animadas");

                    }else if(index==1){
                        textViewAnimation.setBackgroundColor(Color.WHITE);
                        textViewAnimationRepeat.setBackgroundColor(Color.WHITE);

                        textViewAnimation.setText("Linea");
                        textViewAnimationRepeat.setText(Integer.toString(timesAnimationLine));
                    }else if(index==2){
                        textViewAnimation.setBackgroundColor(Color.WHITE);
                        textViewAnimationRepeat.setBackgroundColor(Color.WHITE);

                        textViewAnimation.setText("Curva");
                        textViewAnimationRepeat.setText(Integer.toString(timesAnimationCurve));
                    }
                    textViewAnimation.setLayoutParams(params1);
                    textViewAnimationRepeat.setLayoutParams(params1);

                    row.addView(textViewAnimation);
                    row.addView(textViewAnimationRepeat);
                    row.setLayoutParams(params2);
                    tableLayout.addView(row);
                }
                break;
                //Reporte de errores
            case 5:
                TextView lexema;
                TextView line;
                TextView column;
                TextView type;
                TextView mistake;

                //Graficamos errores lexicos
                for(int index=0 ; index <erroresLexicos.size()+1; index++){
                    row = new TableRow(this);
                    lexema = new TextView(this);
                    line = new TextView(this);
                    column = new TextView(this);
                    type = new TextView(this);
                    mistake = new TextView(this);
                    if(index==0){
                        lexema.setBackgroundColor(Color.YELLOW);
                        line.setBackgroundColor(Color.YELLOW);
                        column.setBackgroundColor(Color.YELLOW);
                        type.setBackgroundColor(Color.YELLOW);
                        mistake.setBackgroundColor(Color.YELLOW);

                        lexema.setText("Lexema");
                        line.setText("Linea");
                        column.setText("Columna");
                        type.setText("Tipo");
                        mistake.setText("Descripcion");

                        lexema.setLayoutParams(params1);
                        line.setLayoutParams(params1);
                        column.setLayoutParams(params1);
                        type.setLayoutParams(params1);
                        mistake.setLayoutParams(params1);
                    }else{ ;
                        lexema.setBackgroundColor(Color.WHITE);
                        line.setBackgroundColor(Color.WHITE);
                        column.setBackgroundColor(Color.WHITE);
                        type.setBackgroundColor(Color.WHITE);
                        mistake.setBackgroundColor(Color.WHITE);
                        try{
                            lexema.setText(erroresLexicos.get(index-1).getError());
                            line.setText(erroresLexicos.get(index-1).getLine());
                            column.setText(erroresLexicos.get(index-1).getColumn());
                            type.setText("Lexico");
                            mistake.setText("Simbolo no Reconocido");

                            lexema.setLayoutParams(params1);
                            line.setLayoutParams(params1);
                            column.setLayoutParams(params1);
                            type.setLayoutParams(params1);
                            mistake.setLayoutParams(params1);
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }

                    }

                        row.addView(lexema);
                        row.addView(line);
                        row.addView(column);
                        row.addView(type);
                        row.addView(mistake);
                        row.setLayoutParams(params2);
                        tableLayout.addView(row);
                }
                for(int index=0 ; index <erroresSintacticos.size(); index++){
                    int magnitud=0;
                    row = new TableRow(this);
                    lexema = new TextView(this);
                    line = new TextView(this);
                    column = new TextView(this);
                    type = new TextView(this);
                    mistake = new TextView(this);
                    lexema.setBackgroundColor(Color.WHITE);
                    line.setBackgroundColor(Color.WHITE);
                    column.setBackgroundColor(Color.WHITE);
                    type.setBackgroundColor(Color.WHITE);
                    mistake.setBackgroundColor(Color.WHITE);
                        try{
                            lexema.setText(erroresSintacticos.get(index).getToken());
                            line.setText(erroresSintacticos.get(index).getLine());
                            column.setText(erroresSintacticos.get(index).getColumn());
                            type.setText("Sintactico");
                            mistake.setText(erroresSintacticos.get(index).getError());

                            lexema.setLayoutParams(params1);
                            line.setLayoutParams(params1);
                            column.setLayoutParams(params1);
                            type.setLayoutParams(params1);
                            mistake.setLayoutParams(params1);
                        }catch (Exception ex){

                        }
                        row.addView(lexema);
                        row.addView(line);
                        row.addView(column);
                        row.addView(type);
                        row.addView(mistake);
                        row.setLayoutParams(params2);
                        tableLayout.addView(row);
                }
                break;

        }
    }

}