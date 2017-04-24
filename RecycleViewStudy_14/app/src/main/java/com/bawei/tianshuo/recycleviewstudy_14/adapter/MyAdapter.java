package com.bawei.tianshuo.recycleviewstudy_14.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.tianshuo.recycleviewstudy_14.R;

import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/14
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<String> list;
    private Context context;
    private OnItemClickListener onItemClickListener;
    private  OnItemLongClickListener onItemLongClickListener;
    public MyAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //点击事件的接口
    interface  OnItemClickListener{
        void onItemClick(View view,int position);
    }
    //长按点击事件的接口
    interface  OnItemLongClickListener{
        void onItemLongClick(View view, int position);
    }
    //提供一个外部可访问的方法
    public  void setOnClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public  void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener=onItemLongClickListener;
    }

    //将View绑定给ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item,null);
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
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position=holder.getLayoutPosition();
                if (onItemLongClickListener!=null){
                    onItemLongClickListener.onItemLongClick(v,position);
                }
                //事件消费，不继续传递
                return true;
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.tv_title);
        }

    }
}
