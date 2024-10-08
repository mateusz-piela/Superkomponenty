package com.example.superkomponenty;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomCircleView extends View {

    private Paint p;
    private float cx, cy, radius;
    private int color;

    public CustomCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        p = new Paint();
        p.setAntiAlias(true);
        p.setStyle(Paint.Style.FILL);
        color = Color.BLUE;
        p.setColor(color);
        radius = 100;
        cx = 500;
        cy = 900;
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        canvas.drawCircle(cx, cy, radius, p);
        super.onDraw(canvas);/*
        setColor(Color.RED);
        setRadius(500);
        setPosition(500, 2000);*/
    }

    public void setColor(int newColor) {
        color = newColor;
        p.setColor(color);
        invalidate();
    }

    public void setRadius(float newRadius) {
        radius = newRadius;
        invalidate();
    }

    public void setPosition(float newCx, float newCy) {
        cx = newCx;
        cy = newCy;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            setColor(Color.GREEN);
            animation();
        }
        return super.onTouchEvent(event);
    }

    public void animation() {
        ObjectAnimator radiusAnimator = ObjectAnimator.ofFloat(this, "radius", radius, radius+100);
        radiusAnimator.setDuration(1000);
        radiusAnimator.start();

        ObjectAnimator positionAnimator = ObjectAnimator.ofFloat(this, "cy", cy, cy+500);
        positionAnimator.setDuration(1000);
        positionAnimator.start();
    }

    public void setCy(float cy) {
        this.cy = cy;
        invalidate();
    }
}
