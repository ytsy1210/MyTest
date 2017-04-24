package com.bawei.tianshuo.tianshuo1502l20170417.activity;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.tianshuo.tianshuo1502l20170417.R;
import com.bawei.tianshuo.tianshuo1502l20170417.adapter.MyAdapter1;
import com.bawei.tianshuo.tianshuo1502l20170417.adapter.MyAdapter2;
import com.bawei.tianshuo.tianshuo1502l20170417.bean.Bean;
import com.bawei.tianshuo.tianshuo1502l20170417.divider.DividerItemDecoration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private Button button1;
    private Button button2;
    private ArrayList<String> strings;
    private ArrayList<Bean> list;
    private MyAdapter2 adapter;
    private MyAdapter1 adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        strings=new ArrayList<>();
        list=new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            strings.add("item"+i);
            Bean bean=new Bean();
            bean.setFlag(false);
            bean.setPosition(i);
            bean.setItem("这是条目"+(i+1)+"      ");
            list.add(bean);
        }
      recyclerView1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapter1 = new MyAdapter1(this,strings);
        recyclerView1.setAdapter(adapter1);
      recyclerView1.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL_LIST));

        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter2(list,this);
        recyclerView2.setAdapter(adapter);
        recyclerView2.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        adapter1.setOnItemClickListener(new MyAdapter1.OnItemClickListener() {
            @Override
            public void onitemCliclk(View v, int position) {
                Toast.makeText(MainActivity.this, "条目"+position, Toast.LENGTH_SHORT).show();
            }
        });
        adapter1.setOnItemLongClickListener(new MyAdapter1.OnItemLongClickListener() {
            @Override
            public void onitemLongClick(View v, int position) {
                AlertDialog.Builder build=new AlertDialog.Builder(MainActivity.this);
                final AlertDialog alterDialog=build.create();
                View view=View.inflate(MainActivity.this,R.layout.aaaa,null);
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
        adapter.setOnItemClickListener(new MyAdapter2.OnItemClickListener() {
            @Override
            public void onitemCliclk(View v, int position) {
                Toast.makeText(MainActivity.this, "条目"+position, Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnItemLongClickListener(new MyAdapter2.OnItemLongClickListener() {
            @Override
            public void onitemLongClick(View v, int position) {
                AlertDialog.Builder build=new AlertDialog.Builder(MainActivity.this);
                final AlertDialog alterDialog=build.create();
                View view=View.inflate(MainActivity.this,R.layout.aaaa,null);
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
        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
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
