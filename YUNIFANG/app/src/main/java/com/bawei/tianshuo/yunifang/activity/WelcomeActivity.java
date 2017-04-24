package com.bawei.tianshuo.yunifang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.bawei.tianshuo.yunifang.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/12
 */

public class WelcomeActivity extends AppCompatActivity {

    private Button button;
    private int time=3;
    private Intent intent;
    Timer timer=new Timer();
    TimerTask task=new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    time--;
                    button.setText("跳过"+time+"s");
                    if (time>0==false ){
                        startActivity(intent);
                        timer.cancel();
                    }
                }
            });
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        initView();
        timer.schedule(task,1000,1000);
    }

    private void initView() {
        button = (Button) findViewById(R.id.button_welcome);
        intent = new Intent(WelcomeActivity.this,MainActivity.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                startActivity(intent);
                finish();
            }
        });
    }


}
