package com.bawei.tianshuo.text14;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/14
 */

public class ListViewUtil {
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        if(listView == null) return;
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i,null,listView);
            int desiredWidth = View.MeasureSpec.makeMeasureSpec(listItem.getWidth(), View.MeasureSpec.AT_MOST);
            listItem.measure(desiredWidth, 0);
            totalHeight += listItem.getMeasuredHeight();
          //  Log.i("======",totalHeight+"");

        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
    public static  int getMsgListViewHeight(ListView listView) {
        int totalHeight = 0;

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return totalHeight;
        }

        int height = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            int desiredWidth = View.MeasureSpec.makeMeasureSpec(listItem.getWidth(), View.MeasureSpec.AT_MOST);
            listItem.measure(desiredWidth, 0);
            height += (listItem.getMeasuredHeight());
        }

        totalHeight = height + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        return totalHeight;
    }
}
