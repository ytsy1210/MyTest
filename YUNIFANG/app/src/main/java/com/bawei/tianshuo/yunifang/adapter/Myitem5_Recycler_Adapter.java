package com.bawei.tianshuo.yunifang.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.tianshuo.yunifang.R;
import com.bawei.tianshuo.yunifang.bean.HomeBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/20
 */

public class Myitem5_Recycler_Adapter  extends RecyclerView.Adapter<Myitem5_Recycler_Adapter.MyViewHolder>{
    private ArrayList<HomeBean.DataBean.SubjectsBean> subs;
    private Context context;
    private MyAdapterClassify.OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void onItemClick(View v,int position);
    }
    public void setOnItemClickListener(MyAdapterClassify.OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public Myitem5_Recycler_Adapter(ArrayList<HomeBean.DataBean.SubjectsBean> subs, Context context) {
        this.subs = subs;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item_5_1_home,null);
        final MyViewHolder holder=new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getLayoutPosition();
                //注册点击监听
                if (onItemClickListener!= null) {
                    onItemClickListener.onItemClick(v, position);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load(subs.get(position).getImage()).into(holder.imageView);
        ArrayList<HomeBean.DataBean.SubjectsBean.GoodsListBean> list= (ArrayList<HomeBean.DataBean.SubjectsBean.GoodsListBean>) subs.get(position).getGoodsList();
        for (int i = 0; i <list.size() ; i++) {
            LinearLayout linearLayout= (LinearLayout) View.inflate(context,R.layout.item_home_goods,null);
            ImageView image= (ImageView) linearLayout.findViewById(R.id.imageView_home_item_goods);
            TextView text1= (TextView) linearLayout.findViewById(R.id.textView_home_item_goodsName);
            TextView text2= (TextView) linearLayout.findViewById(R.id.textView_home_item_showPrice);
            TextView text3= (TextView) linearLayout.findViewById(R.id.textView_home_item_marketPrice);
            text3.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            Glide.with(context).load(list.get(i).getGoods_img()).placeholder(R.drawable.default_loading).error(R.drawable.default_loading).diskCacheStrategy(DiskCacheStrategy.ALL).into(image);
            text1.setText(list.get(i).getGoods_name());
            text2.setText("￥"+list.get(i).getShop_price());
            text3.setText("￥"+list.get(i).getMarket_price());
            holder.linearLayout.addView(linearLayout);

        }
    }

    @Override
    public int getItemCount() {
        return subs.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        LinearLayout linearLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.imageView_item5_home);
            linearLayout= (LinearLayout) itemView.findViewById(R.id.linearLayout5_item_home);
        }
    }
}
