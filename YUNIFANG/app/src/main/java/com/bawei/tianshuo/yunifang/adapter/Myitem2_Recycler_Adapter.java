package com.bawei.tianshuo.yunifang.adapter;

import android.content.Context;
import android.graphics.Paint;
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

public class Myitem2_Recycler_Adapter extends RecyclerView.Adapter<Myitem2_Recycler_Adapter.MyViewHolder>{
    private ArrayList<HomeBean.DataBean.Ad5Bean> ad5S;
    private Context context;
    private MyAdapterClassify.OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void onItemClick(View v,int position);
    }
    public void setOnItemClickListener(MyAdapterClassify.OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    public Myitem2_Recycler_Adapter(ArrayList<HomeBean.DataBean.Ad5Bean> ad5S, Context context) {
        this.ad5S = ad5S;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item_item2_home,null);
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
        Glide.with(context).load(ad5S.get(position).getImage()).placeholder(R.drawable.default_loading).error(R.drawable.default_loading).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);
        holder.textView.setText(ad5S.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return ad5S.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.imageView2_item2_home);
            textView= (TextView) itemView.findViewById(R.id.textView2_item2_home);
        }
    }
}
