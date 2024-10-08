package com.example.superkomponenty;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class CustomSquareView extends View {

    private Paint p;
    private float left, top, length;
    private int color;

    public CustomSquareView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        p = new Paint();
        p.setAntiAlias(true);
        p.setStyle(Paint.Style.FILL);
        color = Color.BLUE;
        p.setColor(color);
        left = 300;
        top = 300;
        length = 300;
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        canvas.drawRect(left, top, left+length, top+length, p);
        super.onDraw(canvas);
    }
}
