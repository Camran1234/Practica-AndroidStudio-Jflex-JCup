package com.example.Shapes;

public class Polygon extends Shape{
    public Polygon(String color, String posX, String posY, String height, String width, String sizes) {
        super(color);
        try{
            data.add(Double.parseDouble(posX));
            data.add(Double.parseDouble(posY));
            data.add(Double.parseDouble(height));
            data.add(Double.parseDouble(width));
            data.add(Double.parseDouble(sizes));

        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }

    public String typeObject(){
        return "poligono";
    }

}
