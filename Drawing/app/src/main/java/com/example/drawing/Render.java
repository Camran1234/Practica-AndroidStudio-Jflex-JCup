package com.example.drawing;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.solver.state.State;
import android.util.Property;
import android.view.View;
import com.example.Shapes.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.example.Parser.parser;

public class Render extends View {
    ArrayList<Circle> circles;
    ArrayList<Square> squares;
    ArrayList<Rectangle> rectangles;
    ArrayList<Line> lines;
    ArrayList<Polygon> polygons;
    ArrayList<Animation> animations;
    ArrayList<Path> figuras = new ArrayList<>();
    ArrayList<Paint> pinturas = new ArrayList<>();
    ArrayList<Path> undoneFiguras = new ArrayList<>();
    private boolean needReset=false;

    private long startTime = System.currentTimeMillis();
    private long duration = 5000;
    private long elapsedTime ;
    public Render(Context context, parser parser) {
        super(context);
        //obtenemos las listas de figuras generadas en el analizador sintactico
        circles = parser.getCircles();
        squares = parser.getSquares();
        rectangles = parser.getRectangles();
        lines = parser.getLines();
        polygons = parser.getPolygons();
        animations = parser.getAnimations();
        startTime= System.currentTimeMillis();
        this.postInvalidate();
    }

    /**
     * onDraw is a modified method for us to draw shapes
     * @param canvas
     */
    @SuppressLint("Range")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
                this.drawLine(canvas);
                this.drawCircle(canvas);;
                this.drawRectangle(canvas);
                this.drawSquares(canvas);
                this.calculatePolygon(canvas);
        System.out.println("Termino");
    }

    private void addAnimation(Shape shape, double posX, double posY, Canvas canvas){
        double toAddX = 0;
        double toAddY =0;
        elapsedTime = System.currentTimeMillis() - startTime;
        for(int indexAnimation=0; indexAnimation<animations.size(); indexAnimation++){
            //We add the animation
            if(animations.get(indexAnimation).sameShape(shape)){
                Matrix matrix = new Matrix();
                if(animations.get(indexAnimation).getAnimation()){
                    toAddX= (animations.get(indexAnimation).getEndX() - posX) * elapsedTime/5000;
                    toAddY= (animations.get(indexAnimation).getEndY() - posY) * elapsedTime/5000;
                    System.out.println("ANIMACION");
                    System.out.println(toAddX+", "+toAddY);
                    System.out.println("YES: "+animations.get(indexAnimation).getEndY()+", "+posY+", "+posX);
                }else{
                    double radius = Math.sqrt((Math.pow((animations.get(indexAnimation).getEndX() - posX),2)+Math.pow((animations.get(indexAnimation).getEndY() - posY),2)));
                    toAddX= radius * Math.cos(((Math.atan((animations.get(indexAnimation).getEndY() - posY)/(animations.get(indexAnimation).getEndX() - posX)))) * elapsedTime/duration);
                    toAddY= radius * Math.sin(((Math.atan((animations.get(indexAnimation).getEndY() - posY)/(animations.get(indexAnimation).getEndX() - posX)))) * elapsedTime/duration);
                    System.out.println("AStartes"+(Math.atan((animations.get(indexAnimation).getEndY() - posY)/(animations.get(indexAnimation).getEndX() - posX))));
                }
                matrix.postTranslate((float)( (toAddX )),(float)( (toAddY )));
                canvas.concat(matrix);
                break;
            }
        }
        if(elapsedTime < duration)
            this.postInvalidateDelayed( 1000 / 60);

    }

    /**
     * Draw a line from an x and y position to an end position of x and y, can assign colors
     * @param canvas
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void drawLine(Canvas canvas){
        Paint paint = new Paint();
        double posX;
        double posY;
        double endX;
        double endY;
        for(int indexLine=0; indexLine<lines.size(); indexLine++){
            try {
                posX = lines.get(indexLine).getData().get(0);
                posY = lines.get(indexLine).getData().get(1);
                endX = lines.get(indexLine).getData().get(2);
                endY = lines.get(indexLine).getData().get(3);
                paint.setColor(lines.get(indexLine).getColor());
                paint.setStrokeWidth(10);
                addAnimation(lines.get(indexLine),posX, posY, canvas);
                canvas.drawLine((float) posX, (float)posY, (float)endX, (float)endY, paint);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        }
    }

    /**
     * Method to draw a circle
     * @param canvas
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void drawCircle (Canvas canvas){
        Paint paint = new Paint();
        double posX;
        double posY;
        double ratio;
        for(int indexCircles=0; indexCircles<circles.size(); indexCircles++){
            try{
                posX = circles.get(indexCircles).getData().get(0);
                posY = circles.get(indexCircles).getData().get(1);
                ratio = circles.get(indexCircles).getData().get(2);
                paint.setColor(circles.get(indexCircles).getColor());
                paint.setStrokeWidth(10);
                Path path = new Path();
                path.addCircle((float)posX, (float)posY,(float)ratio, Path.Direction.CW);
                addAnimation(circles.get(indexCircles),posX, posY, canvas);
                canvas.drawPath(path,paint);
                /*Matrix matrix = new Matrix();
                matrix.postTranslate((float)posX+50 * elapsedTime/1000,(float)posY+50 * elapsedTime/1000);
                canvas.concat(matrix);*/
            }catch(Exception ex){
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }

        }
    }

    /**
     * Comment
     * @param canvas
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void drawRectangle(Canvas canvas){
        Paint paint = new Paint();
        double posX;
        double posY;
        double height;
        double width;
        int right;
        int bottom;

        for(int indexRectangles=0; indexRectangles<rectangles.size(); indexRectangles++){
            try {
                posX = rectangles.get(indexRectangles).getData().get(0);
                posY = rectangles.get(indexRectangles).getData().get(1);
                height = rectangles.get(indexRectangles).getData().get(2);
                width = rectangles.get(indexRectangles).getData().get(3);
                paint.setColor(rectangles.get(indexRectangles).getColor());
                paint.setStrokeWidth(10);
                //canvas.drawRect((float)posX, (float)posY, (float)width, (float)height, paint);
                Path path = new Path();
                right = ((int)width+(int)posX);
                bottom = ((int)height+(int)posY);
                path.addRect((int)posX , (int)posY, right, bottom, Path.Direction.CW);
                addAnimation(rectangles.get(indexRectangles),posX, posY, canvas);
                canvas.drawPath(path,paint);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Method to draw squares
     * @param canvas
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void drawSquares(Canvas canvas){
        Paint paint = new Paint();
        double posX;
        double posY;
        double size;
        int right;
        int bottom;
        for(int indexSquares=0; indexSquares<squares.size(); indexSquares++){
            try {
                posX = squares.get(indexSquares).getData().get(0);
                posY = squares.get(indexSquares).getData().get(1);
                size = squares.get(indexSquares).getData().get(2);
                paint.setColor(squares.get(indexSquares).getColor());
                paint.setStrokeWidth(10);
                Path path = new Path();
                right = ((int)size+(int)posX);
                bottom = ((int)size+(int)posY);
                path.addRect((int)posX , (int)posY , right, bottom, Path.Direction.CW);
                addAnimation(squares.get(indexSquares),posX, posY, canvas);
                canvas.drawPath(path, paint);
            }catch(Exception ex){
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }

        }
    }

    void drawPolygon(Canvas canvas,ArrayList<Point> points, int color, Polygon polygon, double posX, double posY){
        // line at minimum...
        if (points.size() < 3) {
            return;
        }

        // paint
        Paint polyPaint = new Paint();
        polyPaint.setColor(color);
        polyPaint.setStyle(Paint.Style.FILL);

        // path
        Path polyPath = new Path();
        polyPath.moveTo(points.get(0).getX(), points.get(0).getY());
        int i, len;
        len = points.size();
        for (i = 0; i < len; i++) {
            polyPath.lineTo(points.get(i).getX(), points.get(i).getY());
        }
        polyPath.lineTo(points.get(0).getX(), points.get(0).getY());
        addAnimation(polygon,(float)posX, (float)posY, canvas);
        canvas.drawPath(polyPath, polyPaint);
        /*Matrix matrix = new Matrix();
        matrix.postTranslate((float)points.get(0).getX()-50 * elapsedTime/1000,(float)points.get(0).getX()+50 * elapsedTime/1000);
        canvas.concat(matrix);*/
        // draw
    }

    private void calculatePolygon(Canvas canvas){
        for(int indexPolygon=0; indexPolygon<polygons.size(); indexPolygon++){
            try{
                double posX = (double)polygons.get(indexPolygon).getData().get(0);
                double posY = (double)polygons.get(indexPolygon).getData().get(1);
                double height = (double)polygons.get(indexPolygon).getData().get(2);
                double width = (double)polygons.get(indexPolygon).getData().get(3);
                double sides = (double)polygons.get(indexPolygon).getData().get(4);
                ArrayList<Double> add;
                int color = polygons.get(indexPolygon).getColor();
                this.optionPolygon((int)sides, color,(int)posX, (int)posY, (int)width, (int)height, polygons.size(), canvas, polygons.get(indexPolygon));
            }catch (Exception ex){
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }
        }

    }

    private void optionPolygon(int sides, int color, double posX, double posY , double width, double height, int space, Canvas canvas, Polygon polygon){
        double grades = 360/sides;
        double x;
        double y;
        boolean firstPair=false;
        boolean secondaPair = false;
        ArrayList<Point> points;
        points = new ArrayList<>();
        for(int indexPoints=0; indexPoints<sides ; indexPoints++){
            y = Math.sqrt(( (Math.pow(width,2)) * (Math.pow(height,2)) ) / ( (Math.pow(width,2)) + (Math.pow(height,2))* Math.pow(Math.tan(grades * indexPoints * Math.PI/180),2))) ;
            x = Math.sqrt(Math.pow(width,2) * (1 - ((Math.pow(y,2))/(Math.pow(height,2)))));
            if((grades*indexPoints)>=0&&(grades*indexPoints)<=90){

            }else if((grades*indexPoints)>=90&&(grades*indexPoints)<=180){
                y=y*-1;
            } else if((grades*indexPoints)>=180 && (grades*indexPoints)<=270){
                y=y*-1;
                x=x*-1;
            }else if((grades*indexPoints)>=270 && (grades*indexPoints)<=360){
                x=x*-1;
            }

            y = y + posY;
            x = x + posX;

            points.add(new Point(x,y));


        }
        drawPolygon(canvas, points, color, polygon, posX, posY);
    }

}


