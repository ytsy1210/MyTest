package com.bawei.tianshuo.yunifang.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bawei.tianshuo.yunifang.R;
import com.bawei.tianshuo.yunifang.activity.MainActivity;
import com.bawei.tianshuo.yunifang.adapter.MyHomeAdapter;
import com.bawei.tianshuo.yunifang.bean.ClassifyBean;
import com.bawei.tianshuo.yunifang.bean.HomeBean;
import com.bawei.tianshuo.yunifang.util.GetClassifyData;
import com.bawei.tianshuo.yunifang.util.NetOKutil;
import com.google.gson.Gson;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/14
 */

public class Fragment1 extends Fragment implements GetClassifyData{
    private View view;
    private MainActivity activity;
    private ImageView imageView_code;
    private ImageView imageView_message;
    private ListView listView;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
                String json= (String) msg.obj;
                Gson gson=new Gson();
                HomeBean bean=gson.fromJson(json,HomeBean.class);
                HomeBean.DataBean data=bean.getData();
                MyHomeAdapter adapter=new MyHomeAdapter(activity,data);
                listView.setAdapter(adapter);
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if (view==null){
           view=inflater.inflate(R.layout.fragment1,null);
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
        String url="http://m.yunifang.com/yunifang/mobile/home?random=84831&encode=9dd34239798e8cb22bf99a75d1882447";
        NetOKutil.getData(url,activity,Fragment1.this);
    }

    private void initView() {
        imageView_code = (ImageView) view.findViewById(R.id.imageView_home_sweep_code);
        imageView_message = (ImageView) view.findViewById(R.id.imageView_home_message);
        listView = (ListView) view.findViewById(R.id.listView_home);

    }

    @Override
    public void getClassifyData(String str) {
        Message message=handler.obtainMessage();
        message.what=0;
        message.obj=str;
        handler.sendMessage(message);
    }
}
