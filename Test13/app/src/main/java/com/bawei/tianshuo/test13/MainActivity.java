package com.bawei.tianshuo.test13;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener{

    private ListView listView;
    private int num=20;
    private ArrayList<String> list=new ArrayList<>();
    private MyAdapter adapter;
    private int visibleLastIndex = 0; //最后的可视项索引
    private int visibleItemCount;  // 当前窗口可见项总数

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        for (int i = 0; i <num ; i++) {
            list.add("条目"+i);
        }
        initAdapter();
        listView.setOnScrollListener(this);
    }

    private void initAdapter() {
        if (adapter==null){
            adapter = new MyAdapter();
            listView.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        int itemsLastIndex = adapter.getCount() - 1; //数据集最后一项的索引
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE &&
                visibleLastIndex == itemsLastIndex)
        {
            num+=20;
            for (int i = list.size()-1; i <num ; i++) {
                list.add("条目"+i);
            }
            initAdapter();
        }
    }
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.visibleItemCount = visibleItemCount;
        visibleLastIndex = firstVisibleItem + visibleItemCount - 1;
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
                holder.text= (TextView) convertView.findViewById(R.id.text);
                convertView.setTag(holder);
            }else {
                holder= (ViewHolder) convertView.getTag();
            }
            holder.text.setText(list.get(position));
            return convertView;
        }
class ViewHolder{
    TextView text;
}
    }
}
