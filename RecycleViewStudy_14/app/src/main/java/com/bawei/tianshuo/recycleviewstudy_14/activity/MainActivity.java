package com.bawei.tianshuo.recycleviewstudy_14.activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.tianshuo.recycleviewstudy_14.R;
import com.bawei.tianshuo.recycleviewstudy_14.adapter.MyAdapter;
import com.bawei.tianshuo.recycleviewstudy_14.util.DividerGridItemDecoration;
import com.bawei.tianshuo.recycleviewstudy_14.util.DividerItemDecoration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        for (int i = 0; i <30 ; i++) {
            list.add("这是第"+i+"条信息");
        }
        //寻找控件
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        //设置布局管理器
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        //设置适配器
        MyAdapter adapter=new MyAdapter(list,this);
        recyclerView.setAdapter(adapter);
       // recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        //type_recyclerView.addItemDecoration(new RecyclerViewDivider(getActivity(), LinearLayoutManager.VERTICAL, 5, Color.parseColor("#FFE9EAE2")));
       // type_recyclerView.addItemDecoration(new RecyclerViewDivider(getActivity(), LinearLayoutManager.HORIZONTAL, 10, Color.parseColor("#FFE9EAE2")));
    }
}
