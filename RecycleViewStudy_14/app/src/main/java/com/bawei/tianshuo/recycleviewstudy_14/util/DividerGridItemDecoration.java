package com.bawei.tianshuo.recycleviewstudy_14.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/14
 */

public class DividerGridItemDecoration extends RecyclerView.ItemDecoration {
    private static  final  int[] ATTRS=new int[]{android.R.attr.listDivider};
    private Drawable mDividerer;

    public DividerGridItemDecoration(Context context) {
        TypedArray a=context.obtainStyledAttributes(ATTRS);
        mDividerer=a.getDrawable(0);
        a.recycle();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        drawHorizontal(c,parent);
        drawVertical(c,parent);
    }

    private void drawVertical(Canvas c, RecyclerView parent) {
        /*
        *  final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++)
        {
            final View child = parent.getChildAt(i);

            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getTop() - params.topMargin;
            final int bottom = child.getBottom() + params.bottomMargin;
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicWidth();

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }*/
        int childCount=parent.getChildCount();
        for (int i = 0; i <childCount ; i++) {
            View child=parent.getChildAt(i);
            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) child.getLayoutParams();
            int top=child.getTop()-params.topMargin;
            int bottom=child.getBottom()+params.bottomMargin;
            int left=child.getRight()+params.rightMargin;
            int right=left+mDividerer.getIntrinsicWidth();
            mDividerer.setBounds(left,top,right,bottom);
            mDividerer.draw(c);
        }

    }

    private void drawHorizontal(Canvas c, RecyclerView parent) {
        /*
        * int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++)
        {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getLeft() - params.leftMargin;
            final int right = child.getRight() + params.rightMargin
                    + mDivider.getIntrinsicWidth();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }*/
        int childCount=parent.getChildCount();
        for (int i = 0; i <childCount ; i++) {
            //获得子视图
            View child=parent.getChildAt(i);
            //获得参数
            RecyclerView.LayoutParams parmas= (RecyclerView.LayoutParams) child.getLayoutParams();
            int left=child.getLeft()-parmas.leftMargin;
            int right=child.getRight()+parmas.rightMargin+mDividerer.getIntrinsicWidth();
            int top=child.getBottom()+parmas.bottomMargin;
            int bottom=top+mDividerer.getIntrinsicHeight();
            mDividerer.setBounds(left,top,right,bottom);
            mDividerer.draw(c);
        }
    }
    //获取列数
    public int getSpanCount(RecyclerView parent){
        int spanCount=-1;
        RecyclerView.LayoutManager layoutManager=parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager){
            spanCount=((GridLayoutManager) layoutManager).getSpanCount();

        }else if (layoutManager instanceof StaggeredGridLayoutManager){
            spanCount=((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return  spanCount;
    }
    //判断是否是最后一列
    public boolean isLastColum(RecyclerView parent,int pos, int spanCount,int childCount){
        RecyclerView.LayoutManager layoutManager=parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager){
            if ((pos+1)%spanCount==0){//若为最后一列，则不用绘制右边
                return true;
            }
        }else if (layoutManager instanceof  StaggeredGridLayoutManager){
            int orientation=((StaggeredGridLayoutManager) layoutManager).getOrientation();
            if (orientation==StaggeredGridLayoutManager.VERTICAL){
                if ((pos+1)%spanCount==0){
                    return  true;
                }
            }else {
                childCount=childCount-childCount%spanCount;
                if (pos>=childCount){//为最后一列，不需要绘制
                    return  true;
                }
            }
        }
    return  false;
    }
    //判断是否是最后一行
    public boolean isLastRaw(RecyclerView parent,int pos,int spanCount,int childCount){
        RecyclerView.LayoutManager layoutManager=parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager){
            childCount = childCount - childCount % spanCount;
            if (pos >= childCount)// 如果是最后一行，则不需要绘制底部
                return true;
        }else if (layoutManager instanceof  StaggeredGridLayoutManager){
            int orientation=((StaggeredGridLayoutManager) layoutManager).getOrientation();
            if (orientation==StaggeredGridLayoutManager.VERTICAL){//纵向滚动
                childCount=childCount-childCount%spanCount;
                if (pos>=childCount){
                    return false;
                }
            }else {
                if ((pos+1)%spanCount==0){//横向滚动
                    return true;
                }
            }
        }
        return  false;
    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
       int spanCount=getSpanCount(parent);
        int childCount=parent.getAdapter().getItemCount();
        if (isLastColum(parent,itemPosition,spanCount,childCount)){
            //如果是最后一列，不用绘制最后一列
            outRect.set(0,0,0,mDividerer.getIntrinsicHeight());
        }else if (isLastRaw(parent,itemPosition,spanCount,childCount)){
            outRect.set(0,0,mDividerer.getIntrinsicWidth(),0);
        }else {
            outRect.set(0,0,mDividerer.getIntrinsicWidth(),mDividerer.getIntrinsicHeight());
        }
    }
}
