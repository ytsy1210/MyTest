package com.bawei.tianshuo.weektwo_text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/14
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS=new int[]{
            android.R.attr.listDivider
    };
    public  static  final int HORIZONTAL_LIST= LinearLayoutManager.HORIZONTAL;
    public  static  final int VERTICAL_LIST= LinearLayoutManager.VERTICAL;
    private Drawable  mDivider;
    private int mOrientation;

    public DividerItemDecoration(Context context, int mOrientation) {
        TypedArray a=context.obtainStyledAttributes(ATTRS);
        mDivider=a.getDrawable(0);
        a.recycle();
        //设置方向
        setOrientation(mOrientation);
    }

    private void setOrientation(int orientation) {
        if (orientation!=HORIZONTAL_LIST&&orientation!=VERTICAL_LIST){
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation=orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if(mOrientation==HORIZONTAL_LIST){
            drawableHorizontal(c,parent);
        }
        else if (mOrientation==VERTICAL_LIST){
            drawableVertical(c,parent);
        }
    }

    private void drawableVertical(Canvas c, RecyclerView parent) {
        /*
        *  final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            android.support.v7.widget.RecyclerView v = new android.support.v7.widget.RecyclerView(parent.getContext());
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }*/
        int left=parent.getPaddingLeft();
        int right=parent.getWidth()-parent.getPaddingRight();
        int childCount=parent.getChildCount();
        for (int i = 0; i <childCount ; i++) {
            View child=parent.getChildAt(i);
           // RecyclerView v=new RecyclerView(parent.getContext());
            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) child.getLayoutParams();
            int top=child.getBottom()+params.bottomMargin;
            int bottom=top+mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }

    }

    private void drawableHorizontal(Canvas c, RecyclerView parent) {
        /*
        * final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }*/
        int top=parent.getPaddingTop();
        int bottom=parent.getHeight()-parent.getPaddingBottom();
        int childCount=parent.getChildCount();
        for (int i = 0; i <childCount ; i++) {
            View child=parent.getChildAt(i);
            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) child.getLayoutParams();
            int left=child.getRight()+params.rightMargin;
            int right=left+mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
    if (mOrientation==HORIZONTAL_LIST){
        outRect.set(0,0,mDivider.getIntrinsicWidth(),0);

    }else if (mOrientation==VERTICAL_LIST){
        outRect.set(0,0,0,mDivider.getIntrinsicHeight());
    }
    }
}
