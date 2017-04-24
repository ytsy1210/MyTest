package com.bawei.tianshuo.yunifang.util;


import android.content.Context;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Network;

import java.io.IOException;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/18
 */

public class NetOKutil {

    //判断是否有网，有网走网络，没网的时候走SD缓存
    public static  void getData(String url,Context context,GetClassifyData getClassifyData){
        boolean flag=NewWorkInfo.isNetWork(context);
        if (flag){
            getDataNet(url,context,getClassifyData);
        }
        else{
            SDcache.getJson(url,getClassifyData);
        }
    }
    public static void getDataNet(final String url, final Context cotext, final GetClassifyData getClassifyData){
       OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        //得到call
        Call call=okHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Toast.makeText(cotext, "数据请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(final Response response) throws IOException {
                    String s=response.body().string();
                     //将解析的数据存入缓存
                       SDcache.saveJson(url,s);
                     getClassifyData.getClassifyData(s);

                    }
                });

    }

}
