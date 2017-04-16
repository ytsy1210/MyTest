package com.bawei.tianshuo.weektwo_text;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ArrayList<String> str=new ArrayList<>();
    private Button button1;
    private Button button2;
    private RecyclerView recyclerView;
    private ArrayList<Bean> list=new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        for (int i = 0; i <100 ; i++) {
            str.add("条目"+(i+1)+"      ");
        }
        for (int i = 0; i <str.size() ; i++) {
            Bean bean=new Bean();
            bean.setStr(str.get(i));
            bean.setPosition(i);
            bean.setFlag(false);
            list.add(bean);
        }

        //设置布局管理器
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //设置适配器
        adapter = new MyAdapter(list,this);
        recyclerView.setAdapter(adapter);
        //设置分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onitemCliclk(View v, int position) {
                Toast.makeText(MainActivity.this, "这是条目"+position, Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnItemLongClickListener(new MyAdapter.OnItemLongClickListener() {
            @Override
            public void onitemLongClick(View v, int position) {
                AlertDialog.Builder build=new AlertDialog.Builder(MainActivity.this);
                final AlertDialog alterDialog=build.create();
                View view=View.inflate(MainActivity.this,R.layout.aaa,null);
                alterDialog.setView(view);
                alterDialog.show();
                TextView textView= (TextView) view.findViewById(R.id.tttt);
                textView.setText("这是条目"+position);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                     alterDialog.dismiss();
                    }
                });
            }
        });
    }

    private void initView() {
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                for (int i = 0; i <list.size() ; i++) {
                    list.get(i).setFlag(true);
                }
                adapter.notifyDataSetChanged();
                break;
            case R.id.button2:
                for (int i = 0; i <list.size() ; i++) {
                    list.get(i).setFlag(!list.get(i).isFlag());
                }
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
