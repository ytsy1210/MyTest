package com.bawei.tianshuo.tianshuo1502l20170417.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bawei.tianshuo.tianshuo1502l20170417.R;
import com.bawei.tianshuo.tianshuo1502l20170417.bean.Bean;

import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/17
 */

public class MyAdapter2  extends RecyclerView.Adapter<MyAdapter2.MyViewHolder2>{

    private ArrayList<Bean> list;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;
    private Context context;
    //点击监听
   public   interface OnItemClickListener{
        void onitemCliclk(View v,int position);
    }
    //长按监听
    public   interface OnItemLongClickListener{
        void onitemLongClick(View v,int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener=onItemLongClickListener;
    }

    public MyAdapter2(ArrayList<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
       final View view=View.inflate(context,R.layout.item2,null);
        final MyViewHolder2 holder2=new MyViewHolder2(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder2.getLayoutPosition();
                if (onItemClickListener!=null){
                    onItemClickListener.onitemCliclk(view,position);
                }
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position=holder2.getLayoutPosition();
                if (onItemLongClickListener!=null){
                    onItemLongClickListener.onitemLongClick(view,position);
                }
                return true;
            }
        });
        return holder2;
    }

    @Override
    public void onBindViewHolder(MyViewHolder2 holder, final int position) {
        holder.textView2.setText(list.get(position).getItem());
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

    class  MyViewHolder2 extends RecyclerView.ViewHolder{
        TextView textView2;
        CheckBox checkBox;
        public MyViewHolder2(View itemView) {
            super(itemView);
            textView2= (TextView) itemView.findViewById(R.id.text2);
            checkBox= (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }
}
