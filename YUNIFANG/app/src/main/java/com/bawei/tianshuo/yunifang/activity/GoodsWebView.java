package com.bawei.tianshuo.yunifang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.webkit.WebView;

import com.bawei.tianshuo.yunifang.R;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/22
 */

public class GoodsWebView extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.webview);
        WebView webView= (WebView) findViewById(R.id.webView);
        Intent intent=getIntent();
        String url=intent.getStringExtra("URL");
        webView.loadUrl(url);

    }
}
