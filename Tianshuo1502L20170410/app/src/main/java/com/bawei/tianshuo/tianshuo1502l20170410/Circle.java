package com.bawei.tianshuo.tianshuo1502l20170410;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 类的用途：自定义控件
 * author: 田硕
 * date:2017/4/10
 */

public class Circle extends View {
    private int width=50/2;
    private float currentX=100+width;
    private float currentY=100+width;

    private Paint paint;
    private  Paint paint1;
    private  float radius = 100;
    private RectF rectF;

    private int mix=0;
    private int max=100;
    private Paint paint2;
    public Circle(Context context) {
        super(context);
        init();
    }

    public Circle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Circle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(currentX,currentY,radius,paint);
        float alig = (float) mix/max*360;
        canvas.drawArc(rectF,-90,alig,false,paint1);
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void  setProgress(int mix){
        this.mix=mix;
        postInvalidate();
    }

    private void init() {

        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        paint.setColor(Color.parseColor("#D1D1D1"));
        paint.setStyle(Paint.Style.STROKE);

        paint1=new Paint();
        paint1.setAntiAlias(true);
        paint1.setStrokeWidth(10);
        paint1.setColor(Color.parseColor("#090909"));
        paint1.setStyle(Paint.Style.STROKE);
        rectF=new RectF(width,width,radius*2+width,radius*2+width);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX=event.getX();
        currentY=event.getY();
        return  true;
    }
}
