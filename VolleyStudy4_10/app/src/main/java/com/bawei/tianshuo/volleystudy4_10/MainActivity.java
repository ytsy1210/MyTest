package com.bawei.tianshuo.volleystudy4_10;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayout;
import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayoutDirection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private SwipyRefreshLayout swpLayout;
    private ListView listView;
    private CheckBox checkBox_all;
    private int startNum=0;
    private Handler handler = new Handler();
    private JSONArray jsonArray;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        //设置刷新机制
        //设置颜色
        swpLayout.setColorSchemeResources(R.color.colorAccent,android.R.color.holo_orange_light,android.R.color.holo_blue_bright,android.R.color.holo_green_light);
      //设置方向，下拉加载/上拉刷新/两者皆调用
        swpLayout.setDirection(SwipyRefreshLayoutDirection.BOTH);
        swpLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(int index) {
                startNum=0;
                getData();
              handler.postDelayed(new Runnable() {

                  @Override
                  public void run() {
                    swpLayout.setRefreshing(false);
                  }
              },4000)  ;
            }

            @Override
            public void onLoad(int index) {
                startNum++;
                getData();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                  swpLayout.setRefreshing(false);
                }
            },4000);
            }
        });
        getData();
    }

    private void initView() {
        swpLayout = (SwipyRefreshLayout) findViewById(R.id.swl);
        listView = (ListView) findViewById(R.id.listView);
        checkBox_all = (CheckBox) findViewById(R.id.checkBox_all);
        checkBox_all.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
     switch (v.getId()){
         case R.id.checkBox_all:
             boolean isCheck= ((CheckBox) v).isChecked();
             if (isCheck){
                 //全选，刷新适配器刷新数据
                 adapter.notityCheck(isCheck);
             }else {
                 //取消全选，刷新视频器刷新数据
                 adapter.notityCheck(isCheck);
             }
             break;
     }
    }

    public void getData() {
        RequestQueue queue= Volley.newRequestQueue(this);
        //http://www.93.gov.cn/93app/data.do?channelId= 0 &startNum=0
        String url = "http://www.93.gov.cn/93app/data.do?" + "channelId=" + 0 + "&startNum=" + startNum;
     //创建StringRequest
        StringRequest request=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray data = jsonObject.getJSONArray("data");
                    if (startNum == 0) {
                        jsonArray = new JSONArray();
                    }
                    for (int i = 0; i < data.length(); i++) {
                        //把数据源添加到jsonArray
                        jsonArray.put(data.get(i));
                    }
                  initAdapter(jsonArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        queue.add(request);
    }
    public void initAdapter(JSONArray jsonArray){
        if (adapter==null){
            adapter=new MyAdapter(this, jsonArray, new MyAdapter.SetOnCheckChange() {
                @Override
                public void onCheck(boolean check) {
                    checkBox_all.setChecked(check);
                }
            });
           // adapter.setData(jsonArray);
            listView.setAdapter(adapter);
        }else {
            adapter.setData(jsonArray);
        }

    }
}
