package com.bawei.tianshuo.yunifang.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.bawei.tianshuo.yunifang.R;
import com.bawei.tianshuo.yunifang.adapter.MyFragmentPagerAdapter;
import com.bawei.tianshuo.yunifang.fragment.Fragment1;
import com.bawei.tianshuo.yunifang.fragment.Fragment2;
import com.bawei.tianshuo.yunifang.fragment.Fragment3;
import com.bawei.tianshuo.yunifang.fragment.Fragment4;
import com.bawei.tianshuo.yunifang.fragment.Fragment5;
import com.bawei.tianshuo.yunifang.util.NoScrollViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private NoScrollViewPager viewPager;
    private RadioButton radioButton_home;
    private RadioButton radioButton_classify;
    private RadioButton radioButton_community;
    private RadioButton radioButton_shopping;
    private RadioButton radioButton_user;
    private ArrayList<Fragment> fragments;
    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        fragments=new ArrayList<>();
        Fragment1 fragment1=new Fragment1();
        Fragment2 fragment2=new Fragment2();
        Fragment3 fragment3=new Fragment3();
        Fragment4 fragment4=new Fragment4();
        Fragment5 fragment5=new Fragment5();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);
        fragments.add(fragment5);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        for (int i = 0; i <fragments.size() ; i++) {
            transaction.add(R.id.frameLayout,fragments.get(i));
        }
        transaction.show(fragments.get(0));
        transaction.hide(fragments.get(1));
        transaction.hide(fragments.get(2));
        transaction.hide(fragments.get(3));
        transaction.hide(fragments.get(4));
        transaction.commit();
      /*  MyFragmentPagerAdapter adapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);*/
        radioButton_home.setChecked(true);
    }

    private void initView() {
       // viewPager = (NoScrollViewPager) findViewById(R.id.viewPager_All);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        radioButton_home = (RadioButton) findViewById(R.id.radioButton_home);
        radioButton_classify = (RadioButton) findViewById(R.id.radioButton_classify);
        radioButton_community = (RadioButton) findViewById(R.id.radioButton_community);
        radioButton_shopping= (RadioButton)findViewById(R.id.radioButton_shopping);
        radioButton_user = (RadioButton)findViewById(R.id.radioButton_user);
        radioButton_home.setOnClickListener(this);
        radioButton_classify.setOnClickListener(this);
        radioButton_community.setOnClickListener(this);
        radioButton_shopping.setOnClickListener(this);
        radioButton_user.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radioButton_home:
                transaction = fragmentManager.beginTransaction();
                transaction.show(fragments.get(0));
                transaction.hide(fragments.get(1));
                transaction.hide(fragments.get(2));
                transaction.hide(fragments.get(3));
                transaction.hide(fragments.get(4));
                transaction.commit();
                break;
            case R.id.radioButton_classify:
                transaction = fragmentManager.beginTransaction();
                transaction.show(fragments.get(1));
                transaction.hide(fragments.get(0));
                transaction.hide(fragments.get(2));
                transaction.hide(fragments.get(3));
                transaction.hide(fragments.get(4));
                transaction.commit();
                break;

            case R.id.radioButton_community:
                transaction = fragmentManager.beginTransaction();
                transaction.show(fragments.get(2));
                transaction.hide(fragments.get(1));
                transaction.hide(fragments.get(0));
                transaction.hide(fragments.get(3));
                transaction.hide(fragments.get(4));
                transaction.commit();
                break;
            case R.id.radioButton_shopping:
                transaction = fragmentManager.beginTransaction();
                transaction.show(fragments.get(3));
                transaction.hide(fragments.get(1));
                transaction.hide(fragments.get(2));
                transaction.hide(fragments.get(0));
                transaction.hide(fragments.get(4));
                transaction.commit();
                break;
            case R.id.radioButton_user:
                transaction = fragmentManager.beginTransaction();
                transaction.show(fragments.get(4));
                transaction.hide(fragments.get(1));
                transaction.hide(fragments.get(2));
                transaction.hide(fragments.get(3));
                transaction.hide(fragments.get(0));
                transaction.commit();
                break;

        }
    }
}
