package com.bawei.tianshuo.text14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView= (ListView) findViewById(R.id.ListView);
        list = new ArrayList<>();
        for (int i = 0; i <50 ; i++) {
            list.add("条目"+i);
        }
        MyAdapter adapter=new MyAdapter();
        listView.setAdapter(adapter);
        ListViewUtil.setListViewHeightBasedOnChildren(listView);
       /* int height=ListViewUtil.getMsgListViewHeight(listView);
        ViewGroup.LayoutParams params=listView.getLayoutParams();
        params.height = height;
        listView.setLayoutParams(params);*/

    }
class MyAdapter extends BaseAdapter{

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
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(MainActivity.this,R.layout.item,null);
            holder.textView= (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(list.get(position));
        return convertView;
    }
    class ViewHolder{
        TextView textView;
    }
}
}