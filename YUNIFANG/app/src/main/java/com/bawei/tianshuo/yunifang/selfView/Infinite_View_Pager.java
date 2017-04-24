package com.bawei.tianshuo.yunifang.selfView;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/18
 */

public class Infinite_View_Pager extends RelativeLayout {
    //图的url集合
    private ArrayList<String> img_url_list;

    //小圆点的集合
    private ArrayList<View> shape_list;

    //显示视图的View集合
    private ArrayList<View> show_list;

    //传入的上下文
    private Context context;

    //linearlayout距底边的距离
    private int linear_padding_bottom = 20;

    //小圆点之间的距离
    private int iv_padding_right = 10;

    //小圆点的大小
    private int shape_size = 20;

    //用于显示小圆点的shape_selector
    private int shape_selector_res;

    //图片轮播的延时
    private int auto_delay_time = 7000;

    //小圆点的数目
    private int num;

    //内置Handler
    private Handler handler = new Handler();

    protected ViewPager vp;

    //设置圆点大小
    public void setShape_size(int shape_size) {
        this.shape_size = shape_size;
    }

    //设置自动轮播的间隔时间
    public void setAuto_delay_time(int auto_delay_time) {
        this.auto_delay_time = auto_delay_time;
    }

    //设置圆点和底边的距离
    public void setLinear_Padding_bottom(int linear_padding_bottom) {
        this.linear_padding_bottom = linear_padding_bottom;
    }

    //设置圆点之间的距离
    public void setIv_padding_right(int iv_padding_right) {
        this.iv_padding_right = iv_padding_right;
    }

    public Infinite_View_Pager(Context context) {
        super(context);
        this.context = context;
    }

    public Infinite_View_Pager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public Infinite_View_Pager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    //入口 从此方法开始运行
    public void set_img_url(ArrayList<String> img_url_list, int shape_selector_res) {
        if (img_url_list == null) {
            throw new RuntimeException("传入的img_url_list为null");
        } else if (img_url_list.isEmpty()) {
            throw new RuntimeException("传入的img_url_list的长度为0");
        }
        this.shape_selector_res = shape_selector_res;
        this.img_url_list = img_url_list;
        this.num = img_url_list.size();
        add_View_Pager();
    }

    //添加主ViewPager
    protected void add_View_Pager() {
        vp = new ViewPager(context);
        //添加的ViewPager的长宽为 Match_Parent Match_Parent
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        this.addView(vp);
        add_Linear_Layout();
    }

    //添加小圆点的LinearLayout
    protected void add_Linear_Layout() {
        //创建一个LinearLayout
        LinearLayout ll = new LinearLayout(context);
        //设置LinearLayout距离父控件底边的距离
        ll.setPadding(0, 0, 0, linear_padding_bottom);
        //创建一个参数   注意：参数是给父控件看的  所以该控件的父控件是什么布局就写什么布局参数
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        //设置和父控件底对齐
        p.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        //设置水平居中
        p.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        //将参数设置给LinearLayout
        ll.setLayoutParams(p);
        //添加LinearLayout
        this.addView(ll);
        //把该LinearLayout放到视图的最顶层
        this.bringChildToFront(ll);

        linear_layout_add_View(ll);
    }

    //添加ViewPager和LinearLayout中的视图
    protected void linear_layout_add_View(LinearLayout ll) {

        shape_list = new ArrayList<View>();
        show_list = new ArrayList<View>();

        //添加小圆点
        for (int i = 0; i < num; i++) {
            ImageView iv = new ImageView(context);
            ViewGroup.LayoutParams p = new ViewGroup.LayoutParams(shape_size, shape_size);
            iv.setLayoutParams(p);
            iv.setPadding(0, 0, iv_padding_right, 0);
            iv.setImageResource(shape_selector_res);
            shape_list.add(iv);
            ll.addView(iv);
        }

        //将第一个设为选中状态
        shape_list.get(0).setSelected(true);

        //如果传入集合长度小于3  ViewPager无限轮播会报异常  在这里处理一下
        //将原有的集合长度翻倍  直到集合长度大于2
        while (img_url_list.size() < 3) {
            img_url_list.addAll(img_url_list);
        }

        //添加显示图片的View
        for (int i = 0; i < img_url_list.size(); i++) {
            ImageView iv = new ImageView(context);
            ViewGroup.LayoutParams p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            iv.setLayoutParams(p);
            show_list.add(iv);
            net_request_img(iv, img_url_list.get(i));
        }

        vp_setListen();
        show_Image();

    }

    //加载图片使用ImageLoader
    protected void net_request_img(ImageView view, String url) {
       /* ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(url, view);*/
        Glide.with(context).load(url).into(view);
    }

    //改变小圆点的状态
    protected void shape_change_color(int position) {
        int pos = position % num;
        for (int i = 0; i < shape_list.size(); i++) {
            shape_list.get(i).setSelected(i == pos ? true : false);
        }
    }

    //给ViewPager添加监听
    protected void vp_setListen() {

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                shape_change_color(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    //显示图片
    protected void show_Image() {
        MyAdapter ma = new MyAdapter();
        vp.setAdapter(ma);
        vp.setCurrentItem(show_list.size() * 100000, false);
    }

    //自动轮播
    protected void auto_play() {
        int index = vp.getCurrentItem();
        index++;
        vp.setCurrentItem(index);
    }

    //ViewPager的适配器
    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            int pos = position % show_list.size();
            View view = show_list.get(pos);
            container.removeView(view);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int pos = position % show_list.size();
            View view = show_list.get(pos);
            container.addView(view);
            return view;
        }

    }

    //开始轮播
    public void start_auto_play() {
        handler.postDelayed(able, auto_delay_time);
    }

    //停止轮播
    public void stop_auto_play() {
        handler.removeCallbacksAndMessages(null);
    }

    //发送的runnable
    private Runnable able = new Runnable() {
        @Override
        public void run() {
            auto_play();
            handler.postDelayed(able, auto_delay_time);
        }
    };

}
