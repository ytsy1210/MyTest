package com.bawei.tianshuo.yunifang.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.bawei.tianshuo.yunifang.R;
import com.bawei.tianshuo.yunifang.activity.GoodsWebView;
import com.bawei.tianshuo.yunifang.activity.ItemActivity;
import com.bawei.tianshuo.yunifang.bean.HomeBean;
import com.bawei.tianshuo.yunifang.selfView.Infinite_View_Pager;
import com.bawei.tianshuo.yunifang.util.ZoomOutPageTransformer;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/19
 */

public class MyHomeAdapter extends BaseAdapter {
    private Context context;
    private HomeBean.DataBean data;
    private final int TYPE0=0;
    private final int TYPE1=1;
    private final int TYPE2=2;
    private final int TYPE3=3;
    private final int TYPE4=4;
    private List list;
    boolean flag=true;

    public MyHomeAdapter(Context context, HomeBean.DataBean data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==TYPE0){
            list=data.getAd1();
            return TYPE0;
        }else if (position==TYPE1){
            list=data.getAd5();
            return TYPE1;
        }else if (position==TYPE2){
            list=data.getBestSellers().get(0).getGoodsList();
            return  TYPE2;
        }else if (position==TYPE3){
            list=data.getActivityInfo().getActivityInfoList();
            return  TYPE3;
        } else if (position==TYPE4){
            list=data.getSubjects();
            return TYPE4;
        }else {
        return super.getItemViewType(position);
    }
    }

    @Override
    public int getViewTypeCount() {
        return 5;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type=position;
        ViewHolder1 holder1=null;
        ViewHolder2 holder2 = null;
        ViewHolder3 holder3=null;
        ViewHolder4 holder4=null;
        ViewHolder5 holder5=null;
        if (convertView==null){
            switch (type){
                case TYPE0:
                    holder1=new ViewHolder1();
                    convertView=View.inflate(context, R.layout.item1_home,null);
                    holder1.viewPager1= (Infinite_View_Pager) convertView.findViewById(R.id.ViewPager_item1_home);
                    convertView.setTag(holder1);
                    break;
                case TYPE1:
                    holder2=new ViewHolder2();
                    convertView=View.inflate(context,R.layout.item2_home,null);
                   holder2.recyclerView2= (RecyclerView) convertView.findViewById(R.id.recyclerView_item2_home);
                    convertView.setTag(holder2);
                    break;
                case TYPE2:
                    holder3=new ViewHolder3();
                    convertView=View.inflate(context,R.layout.item3_home,null);
                    holder3.linearLayout3= (LinearLayout) convertView.findViewById(R.id.linearLayout3_item_home);
                    convertView.setTag(holder3);
                    break;
                case TYPE3:
                    holder4=new ViewHolder4();
                    convertView=View.inflate(context,R.layout.item4_home,null);
                    holder4.viewPager4= (ViewPager) convertView.findViewById(R.id.ViewPager_item4_home);
                    convertView.setTag(holder4);
                    break;
                case TYPE4:
                    holder5=new ViewHolder5();
                    convertView=View.inflate(context,R.layout.item5_home,null);
                    holder5.recyclerView5= (RecyclerView) convertView.findViewById(R.id.recyclerView_item5_home);
                    convertView.setTag(holder5);
                    break;

            }
        }else {
            switch (type){
                case TYPE0:
                    holder1= (ViewHolder1) convertView.getTag();
                    break;
                case TYPE1:
                    holder2= (ViewHolder2) convertView.getTag();
                    break;
                case TYPE2:
                    holder3= (ViewHolder3) convertView.getTag();
                    break;
                case TYPE3:
                    holder4= (ViewHolder4) convertView.getTag();
                    break;
                case TYPE4:
                    holder5= (ViewHolder5) convertView.getTag();
                    break;
            }
        }
         switch (type){
             case TYPE0:
                 ArrayList<HomeBean.DataBean.Ad1Bean> ad1s= (ArrayList<HomeBean.DataBean.Ad1Bean>) list;
                 final ArrayList<String> list1=new ArrayList<>();
                 for (int i = 0; i <ad1s.size() ; i++) {
                     list1.add(ad1s.get(i).getImage());
                 }
                    holder1.viewPager1.set_img_url(list1,R.drawable.selector_point);
                    holder1.viewPager1.start_auto_play();
                 break;
             case TYPE1:
                 final ArrayList<HomeBean.DataBean.Ad5Bean> ad5s= (ArrayList<HomeBean.DataBean.Ad5Bean>) list;
                    holder2.recyclerView2.setLayoutManager(new GridLayoutManager(context,4));
                    Myitem2_Recycler_Adapter adapter=new Myitem2_Recycler_Adapter(ad5s,context);
                    holder2.recyclerView2.setAdapter(adapter);
                 adapter.setOnItemClickListener(new MyAdapterClassify.OnItemClickListener() {
                     @Override
                     public void onItemClick(View v, int position) {
                         int ad_type=ad5s.get(position).getAd_type();
                         if (ad_type==4){
                         String url=ad5s.get(position).getUrl();
                         Intent intent=new Intent(context,GoodsWebView.class);
                         intent.putExtra("URL",url);
                         context.startActivity(intent);
                        }
                     }
                 });
                 break;
             case TYPE2:
                 ArrayList<HomeBean.DataBean.BestSellersBean.GoodsListBeanX> goods= (ArrayList<HomeBean.DataBean.BestSellersBean.GoodsListBeanX>) list;

                 if (flag) {
                     for (int i = 0; i < goods.size(); i++) {
                         final LinearLayout linearLayout = (LinearLayout) View.inflate(context, R.layout.item_home_goods, null);
                         ImageView image = (ImageView) linearLayout.findViewById(R.id.imageView_home_item_goods);
                         TextView text1 = (TextView) linearLayout.findViewById(R.id.textView_home_item_goodsName);
                         TextView text2 = (TextView) linearLayout.findViewById(R.id.textView_home_item_showPrice);
                         TextView text3 = (TextView) linearLayout.findViewById(R.id.textView_home_item_marketPrice);
                         text3.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                         Glide.with(context).load(goods.get(i).getGoods_img()).placeholder(R.drawable.default_loading).error(R.drawable.default_loading).diskCacheStrategy(DiskCacheStrategy.ALL).into(image);
                         text1.setText(goods.get(i).getGoods_name());
                         text2.setText("￥" + goods.get(i).getShop_price());
                         text3.setText("￥"+goods.get(i).getMarket_price());
                         holder3.linearLayout3.addView(linearLayout);
                     }
                     flag=false;
                 }
                 break;
             case TYPE3:
                 ArrayList<HomeBean.DataBean.ActivityInfoBean.ActivityInfoListBean> infos= (ArrayList<HomeBean.DataBean.ActivityInfoBean.ActivityInfoListBean>) list;
                 while (infos.size()<12){
                    infos.addAll(infos);
                 }
                 ArrayList<ImageView> images=new ArrayList<>();
                 for (int i = 0; i <infos.size() ; i++) {
                     ImageView imageView=new ImageView(context);
                     imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                     imageView.setBackgroundResource(R.drawable.item_background);
                     Glide.with(context).load(infos.get(i).getActivityImg()).placeholder(R.drawable.default_loading).error(R.drawable.default_loading).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
                     images.add(imageView);
                 }
                 holder4.viewPager4.setAdapter(new Myitem3_ViewPager_Adapter(images,context));
                 holder4.viewPager4.setPageTransformer(true, new ZoomOutPageTransformer());
                 holder4.viewPager4.setOffscreenPageLimit(4);
                 holder4.viewPager4.setPageMargin(70);
                 holder4.viewPager4.setCurrentItem(images.size() * 100000, false);

                 break;
             case TYPE4:
                 final ArrayList<HomeBean.DataBean.SubjectsBean> subs= (ArrayList<HomeBean.DataBean.SubjectsBean>) list;
                     holder5.recyclerView5.setLayoutManager(new LinearLayoutManager(context));
                     Myitem5_Recycler_Adapter adapter1=new Myitem5_Recycler_Adapter(subs,context);
                     holder5.recyclerView5.setAdapter(adapter1);
                     adapter1.setOnItemClickListener(new MyAdapterClassify.OnItemClickListener() {
                         @Override
                         public void onItemClick(View v, int position) {
                             Intent intent=new Intent(context, ItemActivity.class);
                             String id=subs.get(position).getId();
                             intent.putExtra("ID",id);
                             context.startActivity(intent);
                         }
                     });

                 break;
         }

        return convertView;
    }
    class ViewHolder1{
        Infinite_View_Pager viewPager1;
    }
    class ViewHolder2{
       RecyclerView recyclerView2;
    }
    class ViewHolder3{
        LinearLayout linearLayout3;
    }
    class ViewHolder4{
        ViewPager viewPager4;
    }
    class ViewHolder5{
        RecyclerView recyclerView5;
    }
}
