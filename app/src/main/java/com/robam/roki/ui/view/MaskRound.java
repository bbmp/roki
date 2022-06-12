package com.robam.roki.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.robam.roki.R;
import com.robam.roki.utils.Point;
import com.robam.roki.utils.Round;
import com.robam.roki.utils.Shape;
import com.robam.roki.utils.Square;

import java.util.ArrayList;
import java.util.List;

public class MaskRound extends View {
    private Context context;
    private Bitmap bitmap;
    //yuanxinzuobiao
    private List<Shape> rShape = new ArrayList<>();
    private float scale;
    private int initR = 120;
    private final static float R1 = 0.3f;
    private final static float R2 = 0.6f;
    private List<Point> Area1 = new ArrayList();
    private List<Point> Area2 = new ArrayList();
    private List<Point> Area3 = new ArrayList();
    private List<Point> Area4 = new ArrayList();
    private List<Point> Area5 = new ArrayList();
    private List<Point> Area6 = new ArrayList();
    private List<Point> Area7 = new ArrayList();
    private List<Point> Area8 = new ArrayList();
    private List<Point> Area9 = new ArrayList();
    private List<Point> Area10 = new ArrayList();
    private List<Point> Area11 = new ArrayList();
    private List<Point> Area12 = new ArrayList();
    private List<Point> Area13 = new ArrayList();

    public MaskRound(Context context) {
        super(context);
        this.context = context;
    }

    public MaskRound(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.wet);

    }

    public MaskRound(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public MaskRound(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }
    //add a round
    public void addRound() {
        for (int i = 0; i< rShape.size(); i++) {
            rShape.get(i).select = false;
        }
        Round round = new Round(getWidth()/2, getHeight()/2);
        round.r = initR;
        round.select =true;
        rShape.add(round);
        invalidate();
    }

    public void addSquare() {
        for (int i = 0; i< rShape.size(); i++) {
            rShape.get(i).select = false;
        }
        Square square = new Square(getWidth()/2-90, getHeight()/2-80);
        square.width = 180;
        square.height = 160;
        square.select = true;
        rShape.add(square);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float sx = getWidth()*1.0f/bitmap.getWidth();
        float sy = getHeight()*1.0f/bitmap.getHeight();
        scale = sx<sy?sx:sy;
        Paint pa = new Paint();
        Matrix matrix = new Matrix();
        matrix.setScale(scale, scale);
        canvas.drawBitmap(bitmap, matrix, pa);
//        canvas.drawBitmap(bitmap, 0, 0, pa);

        pa.setAntiAlias(true);
        pa.setStyle(Paint.Style.STROKE);
        pa.setStrokeWidth(4);

        for (int i = 0; i< rShape.size(); i++) {
            if (rShape.get(i).select)
                pa.setColor(Color.GREEN);
            else
                pa.setColor(Color.GRAY);
            if (rShape.get(i) instanceof Round) {
                Round round = (Round) rShape.get(i);
                canvas.drawCircle(round.x, round.y, round.r, pa);
            }
            else if (rShape.get(i) instanceof Square) {
                Square square = (Square) rShape.get(i);
                canvas.drawRect(square.x, square.y, square.x+square.width, square.y+square.height, pa);
            }
        }

        int height = getHeight();
        Paint paint = new Paint();
        for (int i=0; i<Area9.size();i++) {
            paint.setColor(Area9.get(i).color);
            canvas.drawPoint(Area9.get(i).x, Area9.get(i).y, paint);
        }
        for (int i=0; i<Area1.size();i++) {
            paint.setColor(Area1.get(i).color);
            canvas.drawPoint(Area1.get(i).x, Area1.get(i).y, paint);
        }
        for (int i=0; i<Area2.size();i++) {
            paint.setColor(Area2.get(i).color);
            canvas.drawPoint(Area2.get(i).x, Area2.get(i).y, paint);
        }
        for (int i=0; i<Area3.size();i++) {
            paint.setColor(Area3.get(i).color);
            canvas.drawPoint(Area3.get(i).x, Area3.get(i).y, paint);
        }
        for (int i=0; i<Area4.size();i++) {
            paint.setColor(Area4.get(i).color);
            canvas.drawPoint(Area4.get(i).x, Area4.get(i).y, paint);
        }
        for (int i=0; i<Area5.size();i++) {
            paint.setColor(Area5.get(i).color);
            canvas.drawPoint(Area5.get(i).x, Area5.get(i).y, paint);
        }
        for (int i=0; i<Area6.size();i++) {
            paint.setColor(Area6.get(i).color);
            canvas.drawPoint(Area6.get(i).x, Area6.get(i).y, paint);
        }
        for (int i=0; i<Area7.size();i++) {
            paint.setColor(Area7.get(i).color);
            canvas.drawPoint(Area7.get(i).x, Area7.get(i).y, paint);
        }
        for (int i=0; i<Area8.size();i++) {
            paint.setColor(Area8.get(i).color);
            canvas.drawPoint(Area8.get(i).x, Area8.get(i).y, paint);
        }
        for (int i=0; i<Area10.size();i++) {
            paint.setColor(Area10.get(i).color);
            canvas.drawPoint(Area10.get(i).x, Area10.get(i).y, paint);
        }
        for (int i=0; i<Area11.size();i++) {
            paint.setColor(Area11.get(i).color);
            canvas.drawPoint(Area11.get(i).x, Area11.get(i).y, paint);
        }
        for (int i=0; i<Area12.size();i++) {
            paint.setColor(Area12.get(i).color);
            canvas.drawPoint(Area12.get(i).x, Area12.get(i).y, paint);
        }
        for (int i=0; i<Area13.size();i++) {
            paint.setColor(Area13.get(i).color);
            canvas.drawPoint(Area13.get(i).x, Area13.get(i).y, paint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                float ev_x = event.getX();
                float ev_y = event.getY();
                for (int i = 0; i< rShape.size(); i++) {
                    if (rShape.get(i) instanceof Round) {
                        Round round = (Round) rShape.get(i);
                        float x = ev_x - round.x;
                        float y = ev_y - round.y;
                        if (Math.sqrt(x * x + y * y) < round.r) {
                            for (int j = 0; j< rShape.size(); j++)
                                rShape.get(j).select = false;

                            round.select = true;
                            invalidate();
                            return true;
                        }
                    } else if (rShape.get(i) instanceof Square) {
                        Square square = (Square) rShape.get(i);
                        if (ev_x > square.x && ev_x < square.x + square.width
                        && ev_y > square.y && ev_y < square.y + square.height) {
                            for (int j = 0; j< rShape.size(); j++)
                                rShape.get(j).select = false;

                            square.select = true;
                            invalidate();
                            return true;
                        }
                    }
                }
            }
                break;
            case MotionEvent.ACTION_MOVE:
                int count = event.getPointerCount();
                float ev_x = event.getX();
                float ev_y = event.getY();
                Shape shape = null;
                for (int i=0; i<rShape.size(); i++) {
                    if (rShape.get(i).select) {
                        shape = rShape.get(i);
                        break;
                    }
                }
                if (null != shape && shape instanceof Round) {
                    Round round = (Round) shape;
                    switch (count) {
                        case 1:
                            float x = ev_x - round.x;
                            float y = ev_y - round.y;
                            if (Math.sqrt(x * x + y * y) < round.r) {
                                rShape.get(0).x = (int) ev_x;
                                rShape.get(0).y = (int) ev_y;
                                invalidate();
                            }
                            break;
                        case 2: {
                            //计算两手之间的距离
                            float disX = Math.abs(event.getX(0) - event.getX(1));
                            float disY = Math.abs(event.getY(0) - event.getY(1));
                            //两手之间的距离就是圆的直径
                            double sqrt = Math.sqrt(disX * disX + disY * disY);
                            //计算圆的半径，重新刷新数据
                            round.r = (int) (sqrt / 2);
                            invalidate();
                        }
                        break;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                break;

        }
        return super.onTouchEvent(event);
    }

    public void spiltRound() {
        Area1.clear();
        Area2.clear();
        Area3.clear();
        Area4.clear();
        Area5.clear();
        Area6.clear();
        Area7.clear();
        Area8.clear();
        Area9.clear();
        Area10.clear();
        Area11.clear();
        Area12.clear();
        Area13.clear();
        Shape shape = null;
        for (int i = 0; i < rShape.size(); i++) {
            if (rShape.get(i).select) {
                shape = rShape.get(i);
                break;
            }
        }
        if (shape != null && shape instanceof Round) {
            Round round = (Round) shape;
            int y = (int) (round.y * 1.0f / scale);
            int x = (int) (round.x * 1.0f / scale);
            int r = (int) (round.r * 1.0f / scale);

            //第一象限
            for (int i = y - 1; i > (y - r); i--) {
                for (int j = x; j < (x + r); j++) {
                    int distance2 = (j - x) * (j - x) + (i - y) * (i - y);

                    if (distance2 < r * r * R1 * R1) {
                        //diyikuai
                        Area1.add(new Point(j, i));
                    } else if (distance2 < r * r * R2 * R2) {

                        Area2.add(new Point(j, i));
                    } else if (distance2 < r * r) {
                        //jisuanjiaodu
                        double dianji = Math.abs(j - x);
                        double mod = Math.sqrt(distance2);
                        double arc = Math.acos(dianji / mod) * 180 / Math.PI;
                        if (arc > 0 && arc <= 22.5)
                            Area6.add(new Point(j, i));
                        else if (arc > 22.5 && arc <= 67.5)
                            Area7.add(new Point(j, i));
                        else
                            Area8.add(new Point(j, i));
                    } else
                        break;
                }
            }
            //dierxiangxian
            for (int i = y; i > (y - r); i--) {
                for (int j = x - 1; j > (x - r); j--) {
                    int distance2 = (j - x) * (j - x) + (i - y) * (i - y);
                    if (distance2 < r * r * R1 * R1) {
                        //diyikuai
                        Area1.add(new Point(j, i));
                    } else if (distance2 < r * r * R2 * R2) {

                        Area3.add(new Point(j, i));
                    } else if (distance2 < r * r) {
                        double dianji = Math.abs(x - j);
                        double mod = Math.sqrt(distance2);
                        double arc = Math.acos(dianji / mod) * 180 / Math.PI;
                        if (arc >= 0 && arc < 22.5)
                            Area10.add(new Point(j, i));
                        else if (arc >= 22.5 && arc < 67.5)
                            Area9.add(new Point(j, i));
                        else
                            Area8.add(new Point(j, i));
                    } else
                        break;
                }
            }
            //disanxiangxian
            for (int i = y + 1; i < (y + r); i++) {
                for (int j = x; j > (x - r); j--) {
                    int distance2 = (j - x) * (j - x) + (i - y) * (i - y);
                    if (distance2 < r * r * R1 * R1) {
                        //diyikuai
                        Area1.add(new Point(j, i));
                    } else if (distance2 < r * r * R2 * R2) {
                        Area4.add(new Point(j, i));
                    } else if (distance2 < r * r) {
                        double dianji = Math.abs(x - j);
                        double mod = Math.sqrt(distance2);
                        double arc = Math.acos(dianji / mod) * 180 / Math.PI;
                        if (arc > 0 && arc <= 22.5)
                            Area10.add(new Point(j, i));
                        else if (arc > 22.5 && arc <= 67.5)
                            Area11.add(new Point(j, i));
                        else
                            Area12.add(new Point(j, i));
                    } else
                        break;
                }
            }
            //disixiangxian
            for (int i = y; i < y + r; i++) {
                for (int j = x + 1; j < x + r; j++) {
                    int distance2 = (j - x) * (j - x) + (i - y) * (i - y);
                    if (distance2 < r * r * R1 * R1) {
                        //diyikuai
                        Area1.add(new Point(j, i));
                    } else if (distance2 < r * r * R2 * R2) {

                        Area5.add(new Point(j, i));
                    } else if (distance2 < r * r) {
                        double dianji = Math.abs(j - x);
                        double mod = Math.sqrt(distance2);
                        double arc = Math.acos(dianji / mod) * 180 / Math.PI;
                        if (arc >= 0 && arc < 22.5)
                            Area6.add(new Point(j, i));
                        else if (arc >= 22.5 && arc < 67.5)
                            Area13.add(new Point(j, i));
                        else
                            Area12.add(new Point(j, i));
                    } else
                        break;
                }
            }

            for (int i = 0; i < Area9.size(); i++) {
                int pixel = bitmap.getPixel(Area9.get(i).x, Area9.get(i).y);
                Log.e("Area9", "x=" + Area9.get(i).x + ",y=" + Area9.get(i).y);
                Area9.get(i).color = pixel;

            }
            for (int i = 0; i < Area1.size(); i++) {
                int pixel = bitmap.getPixel(Area1.get(i).x, Area1.get(i).y);
                Area1.get(i).color = pixel;
            }
            for (int i = 0; i < Area2.size(); i++) {
                int pixel = bitmap.getPixel(Area2.get(i).x, Area2.get(i).y);
                Area2.get(i).color = pixel;
            }
            for (int i = 0; i < Area3.size(); i++) {
                int pixel = bitmap.getPixel(Area3.get(i).x, Area3.get(i).y);
                Area3.get(i).color = pixel;
            }
            for (int i = 0; i < Area4.size(); i++) {
                int pixel = bitmap.getPixel(Area4.get(i).x, Area4.get(i).y);
                Area4.get(i).color = pixel;
            }
            for (int i = 0; i < Area5.size(); i++) {
                int pixel = bitmap.getPixel(Area5.get(i).x, Area5.get(i).y);
                Area5.get(i).color = pixel;
            }
            for (int i = 0; i < Area6.size(); i++) {
                int pixel = bitmap.getPixel(Area6.get(i).x, Area6.get(i).y);
                Area6.get(i).color = pixel;
            }
            for (int i = 0; i < Area7.size(); i++) {
                int pixel = bitmap.getPixel(Area7.get(i).x, Area7.get(i).y);
                Area7.get(i).color = pixel;
            }
            for (int i = 0; i < Area8.size(); i++) {
                int pixel = bitmap.getPixel(Area8.get(i).x, Area8.get(i).y);
                Area8.get(i).color = pixel;
            }
            for (int i = 0; i < Area10.size(); i++) {
                int pixel = bitmap.getPixel(Area10.get(i).x, Area10.get(i).y);
                Area10.get(i).color = pixel;
            }
            for (int i = 0; i < Area11.size(); i++) {
                int pixel = bitmap.getPixel(Area11.get(i).x, Area11.get(i).y);
                Area11.get(i).color = pixel;
            }
            for (int i = 0; i < Area12.size(); i++) {
                int pixel = bitmap.getPixel(Area12.get(i).x, Area12.get(i).y);
                Area12.get(i).color = pixel;
            }
            for (int i = 0; i < Area13.size(); i++) {
                int pixel = bitmap.getPixel(Area13.get(i).x, Area13.get(i).y);
                Area13.get(i).color = pixel;
            }
//        Log.e("Area1", "size=" +Area1.size());
//        Log.e("Area2", "size=" +Area2.size());
//        Log.e("Area3", "size=" +Area3.size());
//        Log.e("Area4", "size=" +Area4.size());
//        Log.e("Area5", "size=" +Area5.size());
//        Log.e("Area6", "size=" +Area6.size());
//        Log.e("Area7", "size=" +Area7.size());
//        Log.e("Area8", "size=" +Area8.size());
//        Log.e("Area9", "size=" +Area9.size());
//        Log.e("Area10", "size=" +Area10.size());
//        Log.e("Area11", "size=" +Area11.size());
//        Log.e("Area12", "size=" +Area12.size());
//        Log.e("Area13", "size=" +Area13.size());
            invalidate();
        }
    }
}
