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

import java.util.Random;


public class CustomSquareView extends View {

    private Paint p;
    private float left, top, length;
    private int color, iterator;

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
        left = 500;
        top = 300;
        length = 300;
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        canvas.drawRect(left, top, left+length, top+length, p);
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            setColor(Color.argb(255, (int) (Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256)));
            animation();
        }
        return super.onTouchEvent(event);
    }

    public void setColor(int newColor) {
        color = newColor;
        p.setColor(color);
        invalidate();
    }

    public void animation() {
        if(iterator%2==0){
            ObjectAnimator positionAnimator = ObjectAnimator.ofFloat(this, "left", left, left+(int)(Math.random()*100));
            positionAnimator.setDuration(100);
            positionAnimator.start();
            ObjectAnimator pos = ObjectAnimator.ofFloat(this, "top", top, top+(int)(Math.random()*100));
            pos.setDuration(100);
            pos.start();
        }else{
            ObjectAnimator pos = ObjectAnimator.ofFloat(this, "top", top, top-(int)(Math.random()*100));
            pos.setDuration(100);
            pos.start();
            ObjectAnimator positionAnimator = ObjectAnimator.ofFloat(this, "left", left, left-(int)(Math.random()*100));
            positionAnimator.setDuration(100);
            positionAnimator.start();
        }
        iterator++;
    }

    public void setLeft(float left) {
        this.left = left;
        invalidate();
    }

    public void setTop(float top) {
        this.top = top;
        invalidate();
    }
}
