package com.bawei.tianshuo.weektwo_text.textTwo_a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/16
 */

public class MyView extends View {
    private float XR = 400;
    private float YR = 400;
    private float R = 100;

    private int width;
    private int height;
    private  int length;
    private final float increment = 10;
    private final float min = 50;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getWidth();
        height = getHeight();
        if(width>height){
            length=height;
        }else {
            length=width;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(XR, YR, R, paint);

    }

    private float distance;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int pointer = event.getPointerCount();

        float x = event.getX();
        float y = event.getY();

        int k = event.getAction();

        if(k == MotionEvent.ACTION_POINTER_DOWN){
            distance = getDistance(event);
        }

        if(pointer==1){
            if(k == MotionEvent.ACTION_UP||k == MotionEvent.ACTION_MOVE){
                if(x>width-R){
                    XR = width - R;
                }else if(x<R){
                    XR = R;
                }else{
                    XR = x;
                }

                if(y>height-R){
                    YR = height - R;
                }else if(y<R){
                    YR = R;
                }else{
                    YR = y;
                }
                postInvalidate();
            }

        }else if(pointer==2&&k == MotionEvent.ACTION_MOVE){

            float maxR = 0;

            if(XR<YR){
                maxR = XR;
            }else{
                maxR = YR;
            }

            //判断手指方向
            if(distance>getDistance(event)){
                R -= increment;
                if(R<min){
                    R = min;
                }
            }else if(distance<getDistance(event)){
                R += increment;
                if(R>maxR){
                    R = maxR;
                }else if(R>length/2){
                    R = length/2;
                }
            }
            distance = getDistance(event);
            postInvalidate();
        }
        return true;
    }

    private float getDistance(MotionEvent event){

        float xOne = event.getX(0);
        float yOne = event.getY(0);
        float xTwo = event.getX(1);
        float yTwo = event.getY(1);

        return (xOne - xTwo)*(xOne - xTwo)+(yOne - yTwo)*(yOne - yTwo);
    }
}
