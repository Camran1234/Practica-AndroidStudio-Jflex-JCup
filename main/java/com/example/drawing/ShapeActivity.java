package com.example.drawing;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

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
        setContentView(R.layout.activity_shape);
        //The context of what are we going to work
        shape = new Render(this, parser);
        setContentView(shape);

    }

    private void assignParser(){
        this.parser = MainActivity.dataOfParser;
    }

    private void addShapes(int size, ArrayList<Shape> newShapes){

    }

}