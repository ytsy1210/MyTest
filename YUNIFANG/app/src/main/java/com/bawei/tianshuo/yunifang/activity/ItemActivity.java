package com.bawei.tianshuo.yunifang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.tianshuo.yunifang.R;
import com.bawei.tianshuo.yunifang.adapter.MyGoodsAdapter;
import com.bawei.tianshuo.yunifang.bean.Goods;
import com.bawei.tianshuo.yunifang.util.GetClassifyData;
import com.bawei.tianshuo.yunifang.util.NetOKutil;
import com.google.gson.Gson;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/20
 */

public class ItemActivity extends AppCompatActivity {

    private ImageView imageView_goods_item_back;
    private ImageView imageView_goods_item_cart;
    private ImageView imageView_goods_item_share;
    private RecyclerView recycleView_goodsItem;
    private Button button_goods_item_addCart;
    private Button button_goods_item_buy;
    private String id;
    /*private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
                String json= (String) msg.obj;
                Gson gson=new Gson();
                Goods good=gson.fromJson(json,Goods.class);
                Goods.DataBean goods=good.getData();
               // Goods.DataBean goods=gson.fromJson(json, Goods.DataBean.class);
                recycleView_goodsItem.setLayoutManager(new LinearLayoutManager(ItemActivity.this));
                recycleView_goodsItem.setAdapter(new MyGoodsAdapter(goods,ItemActivity.this));
            }
        }
    };*/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.goods_item_all);
        Intent intent=getIntent();
        id = intent.getStringExtra("ID");
        //Toast.makeText(this,id, Toast.LENGTH_SHORT).show();
        initView();
        initData();
    }

    private void initView() {
        imageView_goods_item_back = (ImageView) findViewById(R.id.imageView_goods_item_back);
        imageView_goods_item_cart = (ImageView)findViewById(R.id.imageView_goods_item_cart);
        imageView_goods_item_share = (ImageView)findViewById(R.id.imageView_goods_item_share);

        recycleView_goodsItem = (RecyclerView) findViewById(R.id.recycleView_goodsItem);
        button_goods_item_addCart = (Button) findViewById(R.id.Button_goods_item_addCart);
        button_goods_item_buy = (Button)findViewById(R.id.Button_goods_item_buy);



    }
    private void initData() {

       // NetOKutil.getData(url,ItemActivity.this,ItemActivity.this);
        RequestQueue queue= Volley.newRequestQueue(ItemActivity.this);
        String url="http://m.yunifang.com/yunifang/mobile/goods/detail?random=46389&encode=70ed2ed2facd7a812ef46717b37148d6&id="+id;
        final StringRequest request=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
              Goods good=gson.fromJson(s,Goods.class);
                Goods.DataBean goods=good.getData();
             //  Goods.DataBean goods=gson.fromJson(s, Goods.DataBean.class);
              //  Log.i("==========",s);
                recycleView_goodsItem.setLayoutManager(new LinearLayoutManager(ItemActivity.this));
                recycleView_goodsItem.setAdapter(new MyGoodsAdapter(goods,ItemActivity.this));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        queue.add(request);
    }

   /* @Override
    public void getClassifyData(String str) {
        Message msg=handler.obtainMessage();
        msg.what=0;
        msg.obj=str;
        handler.sendMessage(msg);
    }*/
}
