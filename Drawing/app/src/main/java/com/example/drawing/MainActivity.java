package com.example.drawing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.Parser.Scanner;
import com.example.Parser.parser;
import com.example.Shapes.Animation;
import com.example.Shapes.Shape;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText editText ;
    Button entryButton;
    String[] optionsSpinner = {"Ayuda Lexica","Graficar Circulo","Graficar Cuadrado","Graficar Rectangulo", "Graficar Linea","Graficar Poligono","Animar objeto"};
    String[] optionsSpinner2 = {"Reportes","Ocurrencias Matematicas","Colores Usados","Objetos Usados", "animaciones hechas","errores"};
    public static boolean withoutMistakes=true;
    public static parser dataOfParser;
    public static Scanner scanner;
    public static int option=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editTextTextMultiLine);
        //Getting the instance of Spinner and applying OnItems
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        //Creating the array adapter
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,optionsSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, optionsSpinner2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),optionsSpinner[position],Toast.LENGTH_LONG);
                switch (position){
                    case 1:
                        option = 1;
                        System.out.println("HOla");
                        break;
                    case 2:
                        option = 2;
                        break;
                    case 3:
                        option = 3;
                        break;
                    case 4:
                        option = 4;
                        break;
                    case 5:
                        option = 5;
                        openShapeActivityResults();
                        break;

                }
                if(MainActivity.withoutMistakes==true && position!=0){
                    openShapeActivityResults();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        String[] optionsSpinner3 = {"Reportes","Ocurrencias Matematicas","Colores Usados","Objetos Usados", "animaciones hechas","errores"};
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter2);


        entryButton =  (Button) findViewById(R.id.ingresarButton);
        entryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String entry = editText.getText().toString();
                    //Abrimos el escaner, analizador lexico
                    Reader reader  = new StringReader(entry);
                    Scanner lexema = new Scanner(reader);
                    scanner = lexema;
                    //Lo analizamos con el analizador sintactico
                    parser parser = new parser(lexema);
                    parser.parse();
                    dataOfParser = parser;
                    if(scanner.getErrorList().size()==0 && parser.getMistakes().size()==0){
                        withoutMistakes=true;
                        System.out.println("VERDADERO");
                    }else{
                        withoutMistakes=false;
                        System.out.println("FALSO");
                    }
                    openShapeActivity();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    private void openShapeActivityResults() {
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }

    public void openShapeActivity(){
        Intent intent = new Intent(this, ShapeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),optionsSpinner[position],Toast.LENGTH_LONG);
        String textToAppend="";
        switch (position){
            case 1:
                textToAppend="graficar circulo (<posx>, <posy>, <radio>, <color>)\n";
                break;
            case 2:
                textToAppend="graficar cuadrado (<posx>, <posy>, <tamaño lado>, <color>)\n";
                break;
            case 3:
                textToAppend="graficar rectangulo (<posx>, <posy>, <alto>, <ancho>, <color>)\n";
                break;
            case 4:
                textToAppend="graficar linea (<posx>, <posy>, <posx1>, <posy2>, <color>)\n";
                break;
            case 5:
                textToAppend="graficar poligono (<posx>, <posy>, <alto>, <ancho>, <cantidad lados>, <color>)\n";
                break;
            case 6:
                textToAppend="animar objeto anterior (<destinox>, <destinoy>, <tipoanimacion>)\n";
                break;
        }


        editText.append(textToAppend);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
