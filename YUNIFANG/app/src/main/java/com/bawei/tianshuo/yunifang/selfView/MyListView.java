package com.bawei.tianshuo.yunifang.selfView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/18
 */

public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       int expandSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec,expandSpec);
    }
}
