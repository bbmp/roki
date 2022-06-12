package com.robam.roki.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ImageUtils {
    private final static float R1 = 0.3f;
    private final static float R2 = 0.6f;
    private static List Area1 = new ArrayList();
    private static List Area2 = new ArrayList();
    private static List Area3 = new ArrayList();
    private static List Area4 = new ArrayList();
    private static List Area5 = new ArrayList();
    private static List Area6 = new ArrayList();
    private static List Area7 = new ArrayList();
    private static List Area8 = new ArrayList();
    private static List<Shape> Area9 = new ArrayList();
    private static List Area10 = new ArrayList();
    private static List Area11 = new ArrayList();
    private static List Area12 = new ArrayList();
    private static List Area13 = new ArrayList();


    public static void spiltRound(int x, int y, int r, Bitmap bitmap) {
        //第一象限
        for (int i = y-1; i > (y-r); i--) {
            for (int j = x; j < (x+r); j++) {
                int distance2 = (j - x)*(j - x) + (i - y)*(i - y);

                if (distance2 < r*r*R1*R1) {
                    //diyikuai
                    Area1.add(new Shape(j, i));
                } else if (distance2 < r*r*R2*R2) {

                    Area2.add(new Shape(j, i));
                } else if (distance2 < r*r) {
                    //jisuanjiaodu
                    double dianji = j * j + i*0;
                    double mod = Math.sqrt(j * j + i * i) * Math.sqrt(j * j + 0);
                    double arc = Math.acos(dianji/mod)*180/Math.PI;
                    if (arc > 0 && arc <= 22.5)
                        Area6.add(new Shape(j, i));
                    else if (arc > 22.5 && arc <= 67.5)
                        Area7.add(new Shape(j, i));
                    else
                        Area8.add(new Shape(j, i));
                } else
                    break;
            }
        }
        //dierxiangxian
        for (int i = y; i > (y-r); i--) {
            for (int j = x-1; j > (x-r); j--) {
                int distance2 = (j - x)*(j - x) + (i - y)*(i - y);
                if (distance2 < r*r*R1*R1) {
                    //diyikuai
                    Area1.add(new Shape(j, i));
                } else if (distance2 < r*r*R2*R2) {

                    Area3.add(new Shape(j, i));
                } else if (distance2 < r*r) {
                    double dianji = j*j + i*0;
                    double mod = Math.sqrt(j*j + i*i) * Math.sqrt(j*j + 0);
                    double arc = Math.acos(dianji/mod)*180/Math.PI;
                    if (arc >= 0 && arc < 22.5)
                        Area10.add(new Shape(j, i));
                    else if (arc >= 22.5 && arc < 67.5)
                        Area9.add(new Shape(j, i));
                    else
                        Area8.add(new Shape(j, i));
                } else
                    break;
            }
        }
        //disanxiangxian
        for (int i = y+1; i < (y+r); i++) {
            for (int j = x; j > (x-r); j--) {
                int distance2 = (j - x)*(j - x) + (i - y)*(i - y);
                if (distance2 < r*r*R1*R1) {
                    //diyikuai
                    Area1.add(new Shape(j, i));
                } else if (distance2 < r*r*R2*R2) {
                    Area4.add(new Shape(j, i));
                } else if (distance2 < r*r) {
                    double dianji = j*j + i*0;
                    double mod = Math.sqrt(j*j + i*i) * Math.sqrt(j*j + 0);
                    double arc = Math.acos(dianji/mod)*180/Math.PI;
                    if (arc > 0 && arc <= 22.5)
                        Area10.add(new Shape(j, i));
                    else if (arc > 22.5 && arc <= 67.5)
                        Area11.add(new Shape(j, i));
                    else
                        Area12.add(new Shape(j, i));
                } else
                    break;
            }
        }
        //disixiangxian
        for (int i = y; i < y+r; i++) {
            for (int j = x+1; j < x+r; j++) {
                int distance2 = (j - x)*(j - x) + (i - y)*(i - y);
                if (distance2 < r*r*R1*R1) {
                    //diyikuai
                    Area1.add(new Shape(j, i));
                } else if (distance2 < r*r*R2*R2) {

                    Area5.add(new Shape(j, i));
                } else if (distance2 < r*r) {
                    double dianji = j*j + i*0;
                    double mod = Math.sqrt(j*j + i*i) * Math.sqrt(j*j + 0);
                    double arc = Math.acos(dianji/mod)*180/Math.PI;
                    if (arc >= 0 && arc < 22.5)
                        Area6.add(new Shape(j, i));
                    else if (arc >= 22.5 && arc < 67.5)
                        Area13.add(new Shape(j, i));
                    else
                        Area12.add(new Shape(j, i));
                } else
                    break;
            }
        }

        for (int i=0; i<Area9.size(); i++) {
            int pixel = bitmap.getPixel(Area9.get(i).x, Area9.get(i).y);
            Log.e("Area9", "rgb"+Color.red(pixel)+","+Color.green(pixel)+","+Color.blue(pixel));

        }
        Log.e("Area1", "size=" +Area1.size());
        Log.e("Area2", "size=" +Area2.size());
        Log.e("Area3", "size=" +Area3.size());
        Log.e("Area4", "size=" +Area4.size());
        Log.e("Area5", "size=" +Area5.size());
        Log.e("Area6", "size=" +Area6.size());
        Log.e("Area7", "size=" +Area7.size());
        Log.e("Area8", "size=" +Area8.size());
        Log.e("Area9", "size=" +Area9.size());
        Log.e("Area10", "size=" +Area10.size());
        Log.e("Area11", "size=" +Area11.size());
        Log.e("Area12", "size=" +Area12.size());
        Log.e("Area13", "size=" +Area13.size());
    }
    //nishizhen
    private static boolean signByCrossProduct(int x1, int y1, int x2, int y2, int x, int y) {
        int dx1 = x1 - x;
        int dx2 = x2 - x;
         int dy1 = y1 - y;
        int dy2 = y2 - y;
        if (dx1 * dy2 - dy1* dx2 > 0)
            return true;
        return false;
    }
}
