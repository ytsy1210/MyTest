package com.bawei.tianshuo.tianshuo1502l20170417.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.tianshuo.tianshuo1502l20170417.R;

import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/17
 */

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder1>{
    private Context context;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;
    private ArrayList<String> strings;
    public   interface OnItemClickListener{
        void onitemCliclk(View v,int position);
    }
    //长按监听
    public   interface OnItemLongClickListener{
        void onitemLongClick(View v,int position);
    }
    public MyAdapter1(Context context, ArrayList<String> strings) {
        this.context = context;
        this.strings = strings;
    }
    public void setOnItemClickListener(MyAdapter1.OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public void setOnItemLongClickListener(MyAdapter1.OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener=onItemLongClickListener;
    }

    @Override
    public MyViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view=View.inflate(context,R.layout.item1,null);
        final MyViewHolder1 holder1=new MyViewHolder1(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder1.getLayoutPosition();
                if (onItemClickListener!=null){
                    onItemClickListener.onitemCliclk(view,position);
                }
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position=holder1.getLayoutPosition();
                if (onItemLongClickListener!=null){
                    onItemLongClickListener.onitemLongClick(view,position);
                }
                return true;
            }
        });
        return holder1;
    }

    @Override
    public void onBindViewHolder(MyViewHolder1 holder, int position) {
       holder.textView1.setText(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder{
        TextView textView1;
        public MyViewHolder1(View itemView) {
            super(itemView);
            textView1= (TextView) itemView.findViewById(R.id.text1);
        }
    }
}
