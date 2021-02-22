package com.example.Shapes;

public class Rectangle extends Shape{
    public Rectangle(String color, String posX, String posY, String width, String height) {
        super(color);
        try{
            data.add(Double.parseDouble(posX));
            data.add(Double.parseDouble(posY));
            data.add(Double.parseDouble(width));
            data.add(Double.parseDouble(height));
            System.out.println("Se encontro un rectangulo");
        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }

    public String typeObject(){
        return "rectangulo";
    }
}
