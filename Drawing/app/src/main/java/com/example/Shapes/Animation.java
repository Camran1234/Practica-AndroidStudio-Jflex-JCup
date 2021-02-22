package com.example.Shapes;

public class Animation {
    Shape shape;
    double endX;
    double endY;
    String typeAnimation;

    public Animation(Shape shape, String endX, String endY, String typeAnimation){
        this.shape = shape;
        this.endX = Double.parseDouble(endX);
        this.endY = Double.parseDouble(endY);
        this.typeAnimation = typeAnimation;
    }

    public double getEndX(){
        return endX;
    }
    public double getEndY(){
        return endY;
    }
    /**
     * True for lineal animation
     * False for curve animation
     * @return
     */
    public boolean getAnimation(){
        if (typeAnimation.equalsIgnoreCase("linea")){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Check if the shape instance in this class is the same
     * that the new shape instance send it
     * @param shape
     * @return
     */
    public boolean sameShape(Shape shape){
        if(this.shape == shape){
            return true;
        }else{
            return false;
        }
    }

}