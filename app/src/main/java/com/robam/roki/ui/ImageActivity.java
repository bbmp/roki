package com.robam.roki.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jaeger.library.StatusBarUtil;
import com.robam.roki.R;
import com.robam.roki.ui.view.MaskRound;
import com.robam.roki.utils.ImageUtils;

public class ImageActivity extends AppCompatActivity {
    private MaskRound round;
    private Button start;
    private Button addRound, addSquare;
    private ImageView iv_bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        round = findViewById(R.id.round);
        start = findViewById(R.id.start);
        addRound = findViewById(R.id.bt_add);
        addSquare = findViewById(R.id.bt_square);
//        iv_bg = findViewById(R.id.iv_background);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int left = round.getLeft();
                int right = round.getRight();
                int top = round.getTop();
                int bottom = round.getBottom();
                int width = round.getWidth();
                int height = round.getHeight();
                int x = left + width/2;
                int y = top + height/2;
//                Bitmap bitmap = ((BitmapDrawable)iv_bg.getDrawable()).getBitmap();
                round.spiltRound();
            }
        });
        addRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                round.addRound();
            }
        });
        addSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                round.addSquare();
            }
        });
    }
}