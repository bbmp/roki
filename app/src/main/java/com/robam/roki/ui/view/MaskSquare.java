package com.robam.roki.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MaskSquare extends View {
    public MaskSquare(Context context) {
        super(context);
    }

    public MaskSquare(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MaskSquare(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MaskSquare(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint pa = new Paint();
        pa.setColor(Color.GREEN);
        pa.setAntiAlias(true);
        pa.setStyle(Paint.Style.FILL);
        pa.setStrokeWidth(4);
        int left = getLeft();
        int right = getRight();
        int width = getWidth();

        canvas.drawRect(0, 0, 263, 263, pa);
    }
}
