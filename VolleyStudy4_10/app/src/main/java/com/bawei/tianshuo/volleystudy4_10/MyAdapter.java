package com.bawei.tianshuo.volleystudy4_10;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/10
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private JSONArray array;
    private  SetOnCheckChange setOnCheckChange;
    //储存条目的id 和状态
    private  HashMap<String,Boolean> map=new HashMap<>();
    interface  SetOnCheckChange{
        void onCheck(boolean check);

    }

    public MyAdapter(Context context, JSONArray array,SetOnCheckChange setOnCheckChange) {
        this.context = context;
        this.array = array;
        this.setOnCheckChange=setOnCheckChange;
        //初始化状态,默认未选中
        setCheck(false);

    }
    //设置条目id和状态
    public void setCheck(boolean checkFlag) {
        map.clear();
        for (int i = 0; i < array.length(); i++) {
            try {
                String id = array.getJSONObject(i).getString("ID");
                map.put(id, checkFlag);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    public void setData(JSONArray array){
        this.array=array;
        for (int i = 0; i <array.length() ; i++) {
            try {
                setCheck(map.get(array.getJSONObject(i).getString("ID")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        notifyDataSetChanged();
    }
    //更新状态
    public void notityCheck(boolean checkFlag) {
        setCheck(checkFlag);
        notifyDataSetChanged();

    }
    @Override
    public int getCount() {
        return array!=null?array.length(): 0;
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
        ViewHolder holder;
        if (convertView==null){
            convertView=View.inflate(context,R.layout.item,null);
            holder=new ViewHolder();
            holder.checkBox= (CheckBox) convertView.findViewById(R.id.checkbox);
            holder.imageView= (ImageView) convertView.findViewById(R.id.imageView);
            holder.textView= (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        try {
            JSONObject jsonObject=array.getJSONObject(position);
            String title=jsonObject.getString("TITLE");
            final String id=jsonObject.getString("ID");
            String imageUrl=jsonObject.getString("IMAGEURL");

            holder.textView.setText(title);
            Picasso.with(context).load(imageUrl).into(holder.imageView);
            //自选框判断
            holder.checkBox.setChecked(map.get(id));
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean checked=((CheckBox)v).isChecked();
                    map.put(id,checked);
                    //假设全选按钮为选中，遍历子条目，是否均已选中
                    boolean isChecked = true;
                    for (String key:map.keySet()) {
                           boolean values=map.get(key);
                        //加入子条目中有未选中的，全选取消
                           if (!values){
                               isChecked=false;
                               //取消全选
                               setOnCheckChange.onCheck(isChecked);
                               //子条目有一个未选中，则为不全选状态，调用接口，、
                               //改变全选按钮状态，在此返回，结束该方法
                              return;
                           }
                    }
                    //遍历子条目，如果均已选中，则isChecked 为true,全选按钮为选中状态
                    if (isChecked){
                        setOnCheckChange.onCheck(isChecked);
                    }
                }
            });












        } catch (JSONException e) {
            e.printStackTrace();
        }
        return convertView;
    }
    class  ViewHolder{
        CheckBox checkBox;
        ImageView imageView;
        TextView textView;
    }
}
