package com.example.drawing;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.Parser.parser;
import com.example.Shapes.*;

import java.util.ArrayList;

public class ShapeActivity extends AppCompatActivity {

    Render shape;
    parser parser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.assignParser();


        //The context of what are we going to work
        if(MainActivity.withoutMistakes){
            shape = new Render(this, parser);
            setContentView(shape);
        }
    }

    private void assignParser(){
        this.parser = MainActivity.dataOfParser;
    }



}