package com.example.Shapes;

public class Square extends Shape{
    public Square(String color, String posX, String posY, String size) {
        super(color);
        try{
            data.add(Double.parseDouble(posX));
            data.add(Double.parseDouble(posY));
            data.add(Double.parseDouble(size));
            System.out.println("Se encontro un cuadrado");
        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }
}
