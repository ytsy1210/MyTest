package com.bawei.tianshuo.weektwo_text;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/16
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private ArrayList<Bean> list;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;
    private Context context;
    //点击监听
    interface OnItemClickListener{
        void onitemCliclk(View v,int position);
    }
    //长按监听
    interface OnItemLongClickListener{
        void onitemLongClick(View v,int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener=onItemLongClickListener;
    }

    public MyAdapter(ArrayList<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view=View.inflate(context,R.layout.item,null);
        final MyViewHolder holder=new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getLayoutPosition();
                if (onItemClickListener!=null){
                    onItemClickListener.onitemCliclk(view,position);
                }
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position=holder.getLayoutPosition();
                if (onItemLongClickListener!=null){
                    onItemLongClickListener.onitemLongClick(view,position);
                }
                return true;
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(list.get(position).getStr());
        holder.checkBox.setChecked(list.get(position).isFlag());
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean flag=list.get(position).isFlag();
                flag=!flag;
                list.get(position).setFlag(flag);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        CheckBox checkBox;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.textView);
            checkBox= (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }
}
