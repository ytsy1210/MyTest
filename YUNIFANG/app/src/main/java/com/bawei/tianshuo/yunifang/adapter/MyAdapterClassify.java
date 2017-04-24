package com.bawei.tianshuo.yunifang.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.tianshuo.yunifang.R;
import com.bawei.tianshuo.yunifang.bean.ClassifyBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/17
 */

public class MyAdapterClassify extends RecyclerView.Adapter<MyAdapterClassify.MyViewHolder> {

    private ArrayList<ClassifyBean.DataBean.GoodsBriefBean> goods;
    private Context context;
    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void onItemClick(View v,int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public MyAdapterClassify(ArrayList<ClassifyBean.DataBean.GoodsBriefBean> goods, Context context) {
        this.goods = goods;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item_classify_goods,null);
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
        Glide.with(context).load(goods.get(position).getGoods_img()).placeholder(R.drawable.default_loading).error(R.drawable.default_loading).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);
        holder.textView1.setText(goods.get(position).getEfficacy());
        holder.textView2.setText(goods.get(position).getGoods_name());
        holder.textView3.setText("￥"+goods.get(position).getShop_price());
        holder.textView4.setText("￥"+goods.get(position).getMarket_price());
        holder.textView4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return goods.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
     public MyViewHolder(View itemView) {
         super(itemView);
         imageView= (ImageView) itemView.findViewById(R.id.imageView_classify_item_goods);
         textView1= (TextView) itemView.findViewById(R.id.textView_classify_item_efficacy);
         textView2= (TextView) itemView.findViewById(R.id.textView_classify_item_goodsName);
         textView3= (TextView) itemView.findViewById(R.id.textView_classify_item_showPrice);
          textView4= (TextView) itemView.findViewById(R.id.textView_classify_item_marketPrice);
     }
 }
}
