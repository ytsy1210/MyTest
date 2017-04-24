package com.bawei.tianshuo.yunifang.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/21
 */

public class NewWorkInfo {
    public static boolean isNetWork(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=manager.getActiveNetworkInfo();
        if (info!=null&&info.getType()==manager.TYPE_WIFI){
            return true;
        }
        return false;
    }
}
