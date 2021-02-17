package com.example.drawing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

import java.lang.reflect.Field;

public class Render extends View {
    
    public Render(Context context) {
        super(context);
    }

    /**
     * onDraw is a modified method for us to draw shapes
     * @param canvas
     */
    @SuppressLint("Range")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawRect(0 ,200,canvas.getWidth(),50, paint);
       // canvas.drawLine(0,0,100,150,paint);
    }

    /**
     * Draw a line from an x and y position to an end position of x and y, can assign colors
     * @param canvas
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @param color
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void drawLine(Canvas canvas, float startX, float startY, float endX, float endY, String color){
        Paint paint = new Paint();
        //We convert our color into a int RGB
        paint.setColor(getColor(color));
        paint.setStrokeWidth(10);
        //Draw the line with the help of canvas class
        canvas.drawLine(startX, startY, endX, endY, paint);
    }

    /**
     * Method to draw a circle
     * @param canvas
     * @param startX
     * @param startY
     * @param radius
     * @param color
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void drawCircle (Canvas canvas, float startX, float startY, float radius, String color){
        Paint paint = new Paint();
        paint.setColor(getColor(color));
        paint.setStrokeWidth(10);
        canvas.drawCircle(startX, startY, radius, paint);
    }

    /**
     * Comment
     * @param canvas
     * @param startX
     * @param startY
     * @param sizeX
     * @param sizeY
     * @param color
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void drawRectangle(Canvas canvas,float startX, float startY, float sizeX, float sizeY, String color){
        Paint paint = new Paint();
        paint.setColor(getColor(color));
        paint.setStrokeWidth(3);
        canvas.drawRect(startX,startY,sizeX,sizeY,paint);
    }

    /**
     * Function that get the number of RGB of a Color class
     * @param color
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private int getColor(String color){
        Color newColor = new Color();
        try {
            Field field = Class.forName("java.awt.Color").getField(color);
            newColor = (Color)field.get(null);
        } catch (Exception e) {
            color = null;
            System.out.println("No Color detected: ");
        }
        return newColor.toArgb();
    }
}
