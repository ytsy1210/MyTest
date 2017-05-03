package com.bawei.tianshuo.tianshuo1502l20170410;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Circle circle;
    private Button reSet;
    private Button start;
    private int mix;
    private int time;
    private TextView textView;
    private Timer timer;

    class MyTimer extends TimerTask{
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    time--;
                    mix = mix + 1;
                    circle.setProgress(mix);
                    if (time<=0) {
                        timer.cancel();
                    }
                    textView.setText(time+"");
                }

            });

        }
    }
    /*匿名内部类，只可调用一次
 TimerTask task=new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    time--;
                    mix = mix + 1;
                    textView.setText(time+"");
                    circle.setProgress(mix);
                    if (time==0) {
                        timer.cancel();
                    }
                }

            });

        }
    };*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.button_start);
        reSet = (Button) findViewById(R.id.button_reSet);
        circle = (Circle) findViewById(R.id.circle);
        textView = (TextView) findViewById(R.id.text);
        start.setOnClickListener(this);
        reSet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_start:
                textView.setVisibility(View.VISIBLE);
                if (timer!=null){
                    timer.cancel();
                }
                time=30;
                mix = 0;
                circle.setMax(30);
                timer = new Timer();
               // timer.schedule(new MyTimer(),0,1000);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                time--;
                                mix = mix + 1;
                                circle.setProgress(mix);
                                if (time<=0) {
                                    timer.cancel();
                                }
                                textView.setText(time+"");
                            }

                        });

                    }
                },0,1000);
               /* mix = 0;
                circle.setMax(100);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            mix = mix + 1;
                            circle.setProgress(mix);
                            try {
                                sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (mix == 100) {
                                break;
                            }

                        }
                    }


                }).start();*/
                break;
            case R.id.button_reSet:
                textView.setVisibility(View.GONE);
                timer.cancel();
                mix=0;
                circle.setProgress(mix);

                break;
        }
    }

}
