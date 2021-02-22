package com.example.Shapes;

public class Line extends Shape{

    public Line(String color, String initX, String initY, String endX, String endY) {
        super(color);
        try{
            data.add(Double.parseDouble(initX));
            data.add(Double.parseDouble(initY));
            data.add(Double.parseDouble(endX));
            data.add(Double.parseDouble(endY));
            System.out.println("Linea Encontrada");
        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }

    public String typeObject(){
        return "linea";
    }
}
