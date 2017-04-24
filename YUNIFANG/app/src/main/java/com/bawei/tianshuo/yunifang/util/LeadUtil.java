package com.bawei.tianshuo.yunifang.util;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/11
 */

public class LeadUtil {
    private ViewPager viewPager;
    private  ArrayList<ImageView> imageViews;
    private Context context;

    public LeadUtil(Context context,ViewPager viewPager, int[] pics) {
        this.viewPager = viewPager;
        this.context = context;
        this.imageViews=getPic(pics);
    }

    private ArrayList<ImageView> getPic(int[] pics){
        ArrayList<ImageView> imageViews=new ArrayList<>();
    for (int i = 0; i <pics.length ; i++) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(pics[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageViews.add(imageView);
    }
    return  imageViews;
}


    public  void initViewPager( Context context){
        viewPager.setAdapter(new MyAdapter(context));
    }

  /*  public void changeActivity(final Context packageContext, final Class<?> cls){

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position==(imageViews.size()-1)){
                    Intent intent=new Intent(packageContext,cls);
                    packageContext.startActivity(intent);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
*/

class  MyAdapter extends PagerAdapter{

    private Context context;

    public MyAdapter( Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
        return imageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=imageViews.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      container.removeView((View) object);
    }

}
}
