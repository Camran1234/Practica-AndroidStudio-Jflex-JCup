package com.example.drawing;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.Parser.Lexema;
import com.example.Parser.parser;

import org.xml.sax.Parser;

import java.io.StringReader;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Render shape;
    EditText editText ;
    Button entryButton;
    String[] optionsSpinner = {"Ayuda Lexica","Graficar Circulo","Graficar Cuadrado","Graficar Rectangulo", "Graficar Linea","Graficar Poligono","Animar objeto"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        entryButton =  (Button) findViewById(R.id.ingresarButton);
        entryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String entry = editText.getText().toString();
                    StringReader reader = new StringReader(entry);

                    Lexema lexema = new Lexema(reader);
                    parser parser = new parser(lexema);
                    parser.parse();
                    List<String> hola = lexema.getErrorList();
                    for(int index=0; index<hola.size();index++){
                        editText.append(hola.get(index).toString());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    editText.append("error: "+e.getMessage());
                    e.printStackTrace();
                }


            }
        });
        /*//The context of what are we going to work
        shape = new Render(this);
        shape.setBackgroundColor(Color.BLUE);
        setContentView(shape);*/
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