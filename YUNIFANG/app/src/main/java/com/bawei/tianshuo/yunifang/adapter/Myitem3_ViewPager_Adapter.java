package com.bawei.tianshuo.yunifang.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/20
 */

public class Myitem3_ViewPager_Adapter extends PagerAdapter {
    private ArrayList<ImageView> imageViews;
    private Context context;

    public Myitem3_ViewPager_Adapter(ArrayList<ImageView> imageViews, Context context) {
        this.imageViews = imageViews;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int pos = position % imageViews.size();
        View view = imageViews.get(pos);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        int pos = position % imageViews.size();
        View view =imageViews.get(pos);
       container.removeView(view);
    }
}
