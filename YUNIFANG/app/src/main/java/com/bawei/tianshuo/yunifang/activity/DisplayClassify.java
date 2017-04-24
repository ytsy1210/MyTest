package com.bawei.tianshuo.yunifang.activity;

import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.tianshuo.yunifang.R;
import com.bawei.tianshuo.yunifang.adapter.MyAdapterClassify;
import com.bawei.tianshuo.yunifang.adapter.MyAdapterItemClassify;
import com.bawei.tianshuo.yunifang.bean.ClassItemBean;
import com.bawei.tianshuo.yunifang.divider.DividerItemDecoration;
import com.bawei.tianshuo.yunifang.util.GetClassifyData;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/17
 */

public class DisplayClassify extends AppCompatActivity {

    private ImageButton imageButton_disPlay_classify;
    private TextView textView_display_classify;
    private GridView gridView_display_classify;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.display_classify);
        initView();
        initData();
    }

    private void initData() {
        final Intent intent=getIntent();
        String json=intent.getStringExtra("JSON");
        Gson gson=new Gson();
        ClassItemBean bean=gson.fromJson(json,ClassItemBean.class);
        final ArrayList< ClassItemBean.DataBean > goods= (ArrayList<ClassItemBean.DataBean>) bean.getData();
        MyAdapterItemClassify myAdapterClassify=new MyAdapterItemClassify(goods,this);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(myAdapterClassify);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL, 5, Color.parseColor("#FFE9EAE2")));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL, 10, Color.parseColor("#FFE9EAE2")));

        myAdapterClassify.setOnItemClickListener(new MyAdapterItemClassify.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Intent intent1=new Intent(DisplayClassify.this,ItemActivity.class);
                String id=goods.get(position).getId();
                intent1.putExtra("ID",id);
                startActivity(intent1);
            }
        });
    }

    private void initView() {
        imageButton_disPlay_classify = (ImageButton) findViewById(R.id.imageButton_display_classify);
        textView_display_classify = (TextView) findViewById(R.id.textView_display_classify);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_classify_item);
        imageButton_disPlay_classify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
