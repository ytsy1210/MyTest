package com.bawei.tianshuo.yunifang.util;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/21
 */

public class SDcache  {

    private static BufferedWriter bf;
    private static BufferedReader br;

    public static  void saveJson(String url, String json){
        String path=url;
        //判断sdcard是否挂载
       String b=url.substring(url.length()-10);
       File file= Environment.getExternalStorageDirectory();
       File file1=new File(file.getPath(),b+".txt");
       try {
           bf = new BufferedWriter(new FileWriter(file1));
           bf.write(json);
           bf.flush();
       } catch (IOException e) {
           e.printStackTrace();
       }
           finally {
           try {
               bf.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }
//从SD卡读取信息
    public static  void  getJson(String url,GetClassifyData getClassifyData){
            String b=url.substring(url.length()-10);
            File file=new File(Environment.getExternalStorageDirectory().getPath(),b+".txt");
            try {
                br = new BufferedReader(new FileReader(file));
                String json=br.readLine();
                Log.i("本地",json);
                getClassifyData.getClassifyData(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
