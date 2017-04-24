package com.bawei.tianshuo.yunifang.application;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/20
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
    }
}
