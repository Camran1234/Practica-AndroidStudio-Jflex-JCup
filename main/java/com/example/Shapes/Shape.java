package com.example.Shapes;

import android.graphics.Color;

import java.util.ArrayList;

public  class Shape {
    ArrayList<Double> data = new ArrayList<>();
    String color;
    public Shape(String color){
        this.color = color;
    }

    public ArrayList<Double> getData(){
        return data;
    }

    public int getColor(){
        int newColor;
        switch(color){
            case "azul":
                newColor = Color.BLUE;
                break;
            case "rojo":
                newColor = Color.RED;
                break;
            case "verde":
                newColor = Color.GREEN;
                break;
            case "amarillo":
                newColor = Color.YELLOW;
                break;
            case "naranja":
                newColor = Color.rgb(225,128,0);
                break;
            case "morado":
                newColor = Color.MAGENTA;
                break;
            case "cafe":
                newColor = Color.rgb(153,76,0);
                break;
            case "negro":
                newColor = Color.BLACK;
                break;
            default:
                newColor = Color.WHITE;
        }
        return newColor;
    }

    /**
     * Return x Initial Position
     * @return
     */
    public double initialPositionX(){
        return this.data.get(0);
    }

    /**
     * Return Y initial position
     * @return
     */
    public double initialPositionY(){
        return this.data.get(1);
    }

}
