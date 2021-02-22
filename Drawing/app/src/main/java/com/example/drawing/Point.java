package com.example.drawing;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * Originally Created by AnderWeb (Gustavo Claramunt) on 7/10/14.
 */
public class Point {


    private float x = 0;
    private float y = 0;

    public Point(double x, double y) {
        this.x = (float)x;
        this.y = (float)y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}