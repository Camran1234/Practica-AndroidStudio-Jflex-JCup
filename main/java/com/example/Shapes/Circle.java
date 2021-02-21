package com.example.Shapes;

public class Circle extends Shape {
    public Circle(String color, String  posX, String posY, String ratio) {
        super(color);
        try{
            data.add(Double.parseDouble(posX));
            data.add(Double.parseDouble(posY));
            data.add(Double.parseDouble(ratio));
            System.out.println("Circulo encontrado");
        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }
}
