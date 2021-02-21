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

    private long startTime ;
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
    }

    /**
     * onDraw is a modified method for us to draw shapes
     * @param canvas
     */
    @SuppressLint("Range")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        while(elapsedTime<=duration){
            elapsedTime = System.currentTimeMillis() - startTime;
            if(elapsedTime%100==0){
                System.out.println("4");
                if(undoneFiguras.isEmpty()==false){
                        for(int indexAnimation=0; indexAnimation<undoneFiguras.size(); indexAnimation++){
                            pinturas.remove(undoneFiguras.get(indexAnimation));
                            figuras.remove(undoneFiguras.get(indexAnimation));
                            undoneFiguras.remove(indexAnimation);
                            invalidate();
                        }
                }
                this.drawLine(canvas);
                this.drawCircle(canvas);;
                this.drawRectangle(canvas);
                this.drawSquares(canvas);
                this.calculatePolygon(canvas);
                for(int indexFiguras=0; indexFiguras<figuras.size(); indexFiguras++){
                    if(needReset==false) {
                        canvas.drawPath(figuras.get(indexFiguras), pinturas.get(indexFiguras));
                    }
                }
                if(needReset){
                    for(int index=0; index<undoneFiguras.size(); index++){
                            if(figuras.contains(undoneFiguras.get(index))){
                                canvas.drawPath(figuras.get(index), pinturas.get(index));
                            }
                    }
                }
                needReset=true;
            }
        }
        System.out.println("Termino");


        //canvas.drawRect(0 ,200,canvas.getWidth(),50, paint);
       // canvas.drawLine(0,0,100,150,paint);
    }

    private ArrayList<Double> addAnimation(Shape shape, double posX, double posY){
        double toAddX = 0;
        double toAddY =0;
        for(int indexAnimation=0; indexAnimation<animations.size(); indexAnimation++){
            //We add the animation
            if(animations.get(indexAnimation).sameShape(shape)){
                //Matrix matrix = new Matrix();
                if(animations.get(indexAnimation).getAnimation()){
                    toAddX= animations.get(indexAnimation).getEndX() - posX;
                    toAddY= animations.get(indexAnimation).getEndY() - posY;
                }else{
                    double radius = Math.sqrt((Math.pow((animations.get(indexAnimation).getEndX() - posX),2)+Math.pow((animations.get(indexAnimation).getEndY() - posY),2))/2);
                    toAddX= radius * Math.cos((180*Math.PI/180) * elapsedTime/duration);
                    toAddY= radius * Math.sin((180*Math.PI/180) * elapsedTime/duration);
                }
                //matrix.postTranslate((float)(posX+ (toAddX * elapsedTime/1000)),(float)(posY+ (toAddY * elapsedTime/1000)));
                //canvas.concat(matrix);
                break;
            }
        }
        ArrayList<Double> points = new ArrayList<>();
        points.add(toAddX);
        points.add(toAddY);
        return points;
        //Alway draw the path
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
                Path path =  new Path();
                ArrayList<Double> add;
                add = addAnimation(lines.get(indexLine) ,posX, posY);
                double sumaX = (double)add.get(0);
                double sumaY = (double)add.get(1);
                path.moveTo((float)posX + (float)sumaX, (float)posY + (float)sumaY);
                path.lineTo((float)endX + (float)sumaX, (float)endY+ (float)sumaY) ;
                if(needReset==false){
                    figuras.add(path);
                    pinturas.add(paint);
                }
                if(sumaX!=0 || sumaY!=0){
                    undoneFiguras.add(path);
                    if(needReset){
                        figuras.add(path);
                        pinturas.add(paint);
                    }
                }
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
                ArrayList<Double> add;
                add = addAnimation(circles.get(indexCircles) ,posX, posY);
                double sumaX = (double)add.get(0);
                double sumaY = (double)add.get(1);
                path.addCircle((float)posX+(float)sumaX, (float)posY+(float)(sumaY),(float)ratio, Path.Direction.CW);
                /*Matrix matrix = new Matrix();
                matrix.postTranslate((float)posX+50 * elapsedTime/1000,(float)posY+50 * elapsedTime/1000);
                canvas.concat(matrix);*/
                if(needReset==false){
                    figuras.add(path);
                    pinturas.add(paint);
                }
                if(sumaX!=0 || sumaY!=0){
                    undoneFiguras.add(path);
                    if(needReset){
                        figuras.add(path);
                        pinturas.add(paint);
                    }
                }
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
                ArrayList<Double> add;
                add = addAnimation(rectangles.get(indexRectangles) ,posX, posY);
                double sumaX = (double)add.get(0);
                double sumaY = (double)add.get(1);
                right = ((int)width+(int)posX+(int)sumaX);
                bottom = ((int)height+(int)posY+(int)sumaY);
                path.addRect((int)posX +(int)sumaX, (int)posY+(int)sumaY, right, bottom, Path.Direction.CW);
                if(needReset==false){
                    figuras.add(path);
                    pinturas.add(paint);
                }
                if(sumaX!=0 || sumaY!=0){
                    undoneFiguras.add(path);
                    if(needReset){
                        figuras.add(path);
                        pinturas.add(paint);
                    }
                }
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
                ArrayList<Double> add;
                add = addAnimation(squares.get(indexSquares) ,posX, posY);
                double sumaX = (double)add.get(0);
                double sumaY = (double)add.get(1);
                right = ((int)size+(int)posX+(int)sumaX);
                bottom = ((int)size+(int)posY+(int)sumaY);
                path.addRect((int)posX +(int)sumaX, (int)posY +(int)sumaY, right, bottom, Path.Direction.CW);
                if(needReset==false){
                    figuras.add(path);
                    pinturas.add(paint);
                }
                if(sumaX!=0 || sumaY!=0){
                    undoneFiguras.add(path);
                    if(needReset){
                        figuras.add(path);
                        pinturas.add(paint);
                    }
                }
            }catch(Exception ex){
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }

        }
    }

    void drawPolygon(Canvas canvas,ArrayList<Point> points, int color, Polygon polygon, double sumaX, double sumaY){
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
        if(needReset==false){
            figuras.add(polyPath);
            pinturas.add(polyPaint);
        }
        if(sumaX!=0 || sumaY!=0){
            undoneFiguras.add(polyPath);
            if(needReset){
                figuras.add(polyPath);
                pinturas.add(polyPaint);
            }
        }
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
                add = addAnimation(polygons.get(indexPolygon) ,posX, posY);
                double sumaX = (double)add.get(0);
                double sumaY = (double)add.get(1);
                int color = polygons.get(indexPolygon).getColor();
                this.optionPolygon((int)sides, color,(int)posX+(int)sumaX, (int)posY+(int)sumaY, (int)width, (int)height, polygons.size(), canvas, polygons.get(indexPolygon), sumaX, sumaY);
            }catch (Exception ex){
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }
        }

    }

    private void optionPolygon(int sides, int color, double posX, double posY , double width, double height, int space, Canvas canvas, Polygon polygon, double sumaX, double sumaY){
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
            System.out.println("width: "+width+" height:"+height);
            System.out.println(indexPoints+"-"+sides+" grados: "+grades*indexPoints+", rads: "+grades*indexPoints*Math.PI/180);
            System.out.println(x+", "+y);
            points.add(new Point(x,y));


        }
        drawPolygon(canvas, points, color, polygon, sumaX, sumaY);
    }

}


