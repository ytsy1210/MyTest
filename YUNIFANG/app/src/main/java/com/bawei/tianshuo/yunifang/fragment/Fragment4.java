package com.bawei.tianshuo.yunifang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.tianshuo.yunifang.R;
import com.bawei.tianshuo.yunifang.activity.MainActivity;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/14
 */

public class Fragment4 extends Fragment {
    private View view;
    private MainActivity activity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if (view==null){
           view=inflater.inflate(R.layout.fragment4,null);
       }
       ViewGroup parent= (ViewGroup) view.getParent();
        if (parent!=null){
            parent.removeView(view);
        }
        activity= (MainActivity) getActivity();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
