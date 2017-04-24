package com.bawei.tianshuo.yunifang.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.bawei.tianshuo.yunifang.R;
import com.bawei.tianshuo.yunifang.util.LeadUtil;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/11
 */

public class LeadActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int[] pics;
    private LeadUtil leadUtil;
    private ImageView imageView;
    private boolean flag=false;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_lead);
        initView();

        SharedPreferences preferences=getPreferences(MODE_PRIVATE);
        editor = preferences.edit();
        flag=preferences.getBoolean("flag",false);
        if (flag){
            startActivity(new Intent(LeadActivity.this,WelcomeActivity.class));
        }else {
            initData();
        }
    }

    private void initData() {
        flag=!flag;
        editor.putBoolean("flag",flag);
        editor.commit();

        pics=new int[]{R.drawable.xiaomi_guidance_1,R.drawable.xiaomi_guidance_2,
                R.drawable.xiaomi_guidance_3,R.drawable.xiaomi_guidance_4,R.drawable.xiaomi_guidance_5};

        leadUtil = new LeadUtil(this,viewPager,pics);
        leadUtil.initViewPager(this);
        // leadUtil.changeActivity(this,MainActivity.class);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==pics.length-1){
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            TranslateAnimation ta=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-1.0f,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0);
                            ta.setDuration(3000);
                            ta.setFillAfter(true);
                            imageView.startAnimation(ta);
                            ta.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    startActivity(new Intent(LeadActivity.this,WelcomeActivity.class));
                                    finish();
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                        }
                    });
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager_lead);
        imageView = (ImageView) findViewById(R.id.imageView_5_lead);
    }
}
