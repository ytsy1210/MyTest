package com.bawei.tianshuo.baidumap_19;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/5/3
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
    }
}
