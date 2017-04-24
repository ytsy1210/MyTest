package com.bawei.tianshuo.text12;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/12
 */

public class MyAdapter extends BaseAdapter {
    private ArrayList<Bean> list;
    private Context context;
    private int num;
    public MyAdapter(ArrayList<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       ViewHolder holder;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context,R.layout.item,null);
            holder.checkBox= (CheckBox) convertView.findViewById(R.id.checkbox);
            holder.textView= (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        final boolean flag=list.get(position).isFlag();
        holder.checkBox.setChecked(flag);
        holder.textView.setText(list.get(position).getStr());

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              list.get(position).setFlag(!flag);

            }
        });

        return convertView;
    }
    class ViewHolder{
        CheckBox checkBox;
        TextView textView;
    }
}
