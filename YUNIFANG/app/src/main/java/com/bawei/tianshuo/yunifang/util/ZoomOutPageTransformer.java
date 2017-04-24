package com.bawei.tianshuo.yunifang.util;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/20
 */

public class ZoomOutPageTransformer implements ViewPager.PageTransformer {

    private static final float MAX_SCALE = 1.2f;
    private static final float MIN_SCALE = 1.0f;
    @Override
    public void transformPage(View view, float position) {
        if (position < -1){
            view.setScaleX(MIN_SCALE);
            view.setScaleY(MIN_SCALE);
        } else if (position <= 1) //a页滑动至b页 ； a页从 0.0 -1 ；b页从1 ~ 0.0
        { // [-1,1]
//              Log.e("TAG", view + " , " + position + "");
            float scaleFactor =  MIN_SCALE+(1-Math.abs(position))*(MAX_SCALE-MIN_SCALE);
            view.setScaleX(scaleFactor);
            //每次滑动后进行微小的移动目的是为了防止在三星的某些手机上出现两边的页面为显示的情况
            if(position>0){
                view.setTranslationX(-scaleFactor*2);
            }else if(position<0){
                view.setTranslationX(scaleFactor*2);
            }
            view.setScaleY(scaleFactor);

        } else
        {

            view.setScaleX(MIN_SCALE);
            view.setScaleY(MIN_SCALE);

        }

    }
}
