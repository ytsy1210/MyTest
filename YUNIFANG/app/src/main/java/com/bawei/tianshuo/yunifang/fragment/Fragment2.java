package com.bawei.tianshuo.yunifang.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.tianshuo.yunifang.R;
import com.bawei.tianshuo.yunifang.activity.DisplayClassify;
import com.bawei.tianshuo.yunifang.activity.ItemActivity;
import com.bawei.tianshuo.yunifang.activity.MainActivity;
import com.bawei.tianshuo.yunifang.adapter.MyAdapterClassify;
import com.bawei.tianshuo.yunifang.bean.ClassItemBean;
import com.bawei.tianshuo.yunifang.bean.ClassifyBean;
import com.bawei.tianshuo.yunifang.divider.DividerItemDecoration;
import com.bawei.tianshuo.yunifang.util.GetClassifyData;
import com.bawei.tianshuo.yunifang.util.NetOKutil;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/14
 */

public class Fragment2 extends Fragment implements View.OnClickListener,GetClassifyData{
    private String url;
    private View view;
    private MainActivity activity;
    private ImageView imageView_classify_facial_mask;
    private ImageView imageView_classify_emollient_water;
    private ImageView imageView_classify_body_lotion;
    private ImageView imageView_classify_facial_cleanser;
    private ImageView imageView_classify_classify_other;
    private ImageView imageView_classify_classify_kit;
    private ImageView imageView_classify_classify_man;
    private ImageView imageView_classify_hydrating;
    private ImageView imageView_classify_soothing;
    private ImageView imageView_classify_control_oil;
    private ImageView imageView_classify_whitening;
    private ImageView imageView_classify_firming;
    private Button button_classify_combination_skin;
    private Button button_classify_neutral_skin;
    private Button button_classify_dry_skin;
    private Button button_classify_oily_skin;
    private Button button_classify_acne_skin;
    private Button button_classify_sensitive_skin;
    private RecyclerView recyclerView;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
                String json= (String) msg.obj;
                Intent intent=new Intent(activity, DisplayClassify.class);
                intent.putExtra("JSON",json);
                startActivity(intent);

            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if (view==null){
           view=inflater.inflate(R.layout.fragment2,null);
       }
       ViewGroup parent= (ViewGroup) view.getParent();
        if (parent!=null){
            parent.removeView(view);
        }
        activity= (MainActivity) getActivity();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        RequestQueue queue= Volley.newRequestQueue(activity);
        String url="http://m.yunifang.com/yunifang/mobile/category/list?random=96333&encode=bf3386e14fe5bb0bcef234baebca2414";
        final StringRequest request=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson=new Gson();
                ClassifyBean classifyBean=gson.fromJson(s,ClassifyBean.class);
                final ArrayList<ClassifyBean.DataBean.GoodsBriefBean> goods= (ArrayList<ClassifyBean.DataBean.GoodsBriefBean>) classifyBean.getData().getGoodsBrief();
                MyAdapterClassify myAdapterClassify=new MyAdapterClassify(goods,activity);
                recyclerView.setLayoutManager(new GridLayoutManager(activity,2));
                recyclerView.setAdapter(myAdapterClassify);
                recyclerView.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.VERTICAL, 5, Color.parseColor("#FFE9EAE2")));
                recyclerView.addItemDecoration(new DividerItemDecoration(activity, LinearLayoutManager.HORIZONTAL, 10, Color.parseColor("#FFE9EAE2")));

                myAdapterClassify.setOnItemClickListener(new MyAdapterClassify.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {
                        Intent intent=new Intent(activity, ItemActivity.class);
                        String id=goods.get(position).getId();
                        intent.putExtra("ID",id);
                        startActivity(intent);
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        queue.add(request);
    }

    private void initView() {
        imageView_classify_facial_mask = (ImageView) view.findViewById(R.id.imageView_classify_facial_mask);
        imageView_classify_emollient_water = (ImageView) view.findViewById(R.id.imageView_classify_emollient_water);
        imageView_classify_body_lotion = (ImageView) view.findViewById(R.id.imageView_classify_body_lotion);
        imageView_classify_facial_cleanser= (ImageView) view.findViewById(R.id.imageView_classify_facial_cleanser);
        imageView_classify_classify_other = (ImageView) view.findViewById(R.id.imageView_classify_other);
        imageView_classify_classify_kit = (ImageView) view.findViewById(R.id.imageView_classify_kit);
        imageView_classify_classify_man = (ImageView) view.findViewById(R.id.imageView_classify_man);
        imageView_classify_hydrating = (ImageView) view.findViewById(R.id.imageView_classify_hydrating);
        imageView_classify_soothing = (ImageView) view.findViewById(R.id.imageView_classify_soothing);
        imageView_classify_control_oil = (ImageView) view.findViewById(R.id.imageView_classify_control_oil);
        imageView_classify_whitening = (ImageView) view.findViewById(R.id.imageView_classify_whitening);
        imageView_classify_firming = (ImageView) view.findViewById(R.id.imageView_classify_firming);
        button_classify_combination_skin = (Button) view.findViewById(R.id.button_classify_combination_skin);
        button_classify_neutral_skin = (Button) view.findViewById(R.id.button_classify_neutral_skin);
        button_classify_dry_skin = (Button) view.findViewById(R.id.button_classify_dry_skin);
        button_classify_oily_skin = (Button) view.findViewById(R.id.button_classify_oily_skin);
        button_classify_acne_skin = (Button) view.findViewById(R.id.button_classify_acne_skin);
        button_classify_sensitive_skin = (Button) view.findViewById(R.id.button_classify_sensitive_skin);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_classify);


        imageView_classify_facial_mask.setOnClickListener(this);
        imageView_classify_emollient_water.setOnClickListener(this);
        imageView_classify_body_lotion.setOnClickListener(this);
        imageView_classify_facial_cleanser.setOnClickListener(this);
        imageView_classify_classify_other.setOnClickListener(this);
        imageView_classify_classify_kit.setOnClickListener(this);
        imageView_classify_classify_man.setOnClickListener(this);


        imageView_classify_hydrating.setOnClickListener(this);
        imageView_classify_soothing.setOnClickListener(this);
        imageView_classify_control_oil.setOnClickListener(this);
        imageView_classify_whitening.setOnClickListener(this);
        imageView_classify_firming.setOnClickListener(this);

        button_classify_combination_skin.setOnClickListener(this);
        button_classify_oily_skin.setOnClickListener(this);
        button_classify_dry_skin.setOnClickListener(this);
        button_classify_neutral_skin.setOnClickListener(this);
        button_classify_acne_skin.setOnClickListener(this);
        button_classify_sensitive_skin.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView_classify_facial_mask:
                url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=23";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;
            case R.id.imageView_classify_emollient_water:
                 url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=39";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;
            case R.id.imageView_classify_body_lotion:
                 url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=40";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;
            case R.id.imageView_classify_facial_cleanser:
                 url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=24";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;
            case R.id.imageView_classify_other:
                url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=35";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;
            case R.id.imageView_classify_kit:
                url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=33";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;
            case R.id.imageView_classify_man:
                url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=41";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;


            case R.id.imageView_classify_hydrating:
                url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=13819&encode=d58e53c4b9e24bd5ba276ba68f8e98ec&category_id=17";
                NetOKutil.getData(url,activity,Fragment2.this);
                        break;
            case R.id.imageView_classify_soothing:
                url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=13819&encode=d58e53c4b9e24bd5ba276ba68f8e98ec&category_id=31";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;
            case R.id.imageView_classify_control_oil:
                url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=13819&encode=d58e53c4b9e24bd5ba276ba68f8e98ec&category_id=19";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;
            case R.id.imageView_classify_whitening:
                url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=13819&encode=d58e53c4b9e24bd5ba276ba68f8e98ec&category_id=18";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;
            case R.id.imageView_classify_firming:
                url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=13819&encode=d58e53c4b9e24bd5ba276ba68f8e98ec&category_id=20";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;

            case R.id.button_classify_combination_skin:
                url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=86588&encode=102e81c24a35dbdc9bb130c3c164434b&category_id=14";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;
            case R.id.button_classify_neutral_skin:
                url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=86588&encode=102e81c24a35dbdc9bb130c3c164434b&category_id=13";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;
            case R.id.button_classify_dry_skin:
                url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=86588&encode=102e81c24a35dbdc9bb130c3c164434b&category_id=29";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;
            case R.id.button_classify_oily_skin:
                url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=86588&encode=102e81c24a35dbdc9bb130c3c164434b&category_id=28";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;
            case R.id.button_classify_acne_skin:
                url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=86588&encode=102e81c24a35dbdc9bb130c3c164434b&category_id=15";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;
            case R.id.button_classify_sensitive_skin:
                url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=86588&encode=102e81c24a35dbdc9bb130c3c164434b&category_id=37";
                NetOKutil.getData(url,activity,Fragment2.this);
                break;


        }
    }

    @Override
    public void getClassifyData(String str) {
        Message message=handler.obtainMessage();
        message.what=0;
        message.obj=str;
        handler.sendMessage(message);
    }
}
