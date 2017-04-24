package com.bawei.tianshuo.text12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView listView;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private ArrayList<Bean> list;
    private MyAdapter adapter;
    private RadioButton radioButton4;
    private int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            Bean bean=new Bean();
            bean.setFlag(false);
            bean.setStr("条目"+i);
            list.add(bean);
        }
     initAdapter(list);

    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        radioButton3.setOnClickListener(this);
        radioButton4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radioButton1:
                for (int i = 0; i <list.size() ; i++) {
                    list.get(i).setFlag(true);
                }
                initAdapter(list);
                break;
            case R.id.radioButton2:
                for (int i = 0; i <list.size() ; i++) {
                    list.get(i).setFlag(!list.get(i).isFlag());
                }
                initAdapter(list);
                break;
            case R.id.radioButton3:
                for (int i = 0; i <list.size() ; i++) {
                    list.get(i).setFlag(false);
                }
                initAdapter(list);
                break;
            case R.id.radioButton4:
                break;
        }
    }
    public  void initAdapter(ArrayList<Bean> list){
        if (adapter==null){
            adapter=new MyAdapter(list,this);
            listView.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }
    }
}
