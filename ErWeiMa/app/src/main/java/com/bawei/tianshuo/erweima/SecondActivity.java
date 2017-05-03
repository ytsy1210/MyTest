package com.bawei.tianshuo.erweima;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/5/3
 */

public class SecondActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        WebView  webView= (WebView) findViewById(R.id.webView);
        Intent intent=getIntent();
        String url=intent.getStringExtra("Url");
        webView.loadUrl(url);
    }
}
