package ru.qixi.recyclerextension;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by qixi on 06.04.2015.
 */
public abstract class DividerItemDecoration extends RecyclerView.ItemDecoration {

    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST   = LinearLayoutManager.VERTICAL;

    private int mOrientation;


    public DividerItemDecoration(int orientation) {
        setOrientation(orientation);
    }


    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent, state);
        } else {
            drawHorizontal(c, parent, state);
        }
    }


    protected void drawVertical(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + getDividerHeight();//mDivider.getIntrinsicHeight();
            onDrawVertical(c, left, top, right, bottom);
        }
    }


    protected abstract void onDrawVertical(Canvas c, int left, int top, int right, int bottom);


    protected void drawHorizontal(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getRight() + params.rightMargin;
            int right = left + getDividerWidth();//mDivider.getIntrinsicHeight();
            onDrawHorizontal(c, left, top, right, bottom);
        }
    }


    protected abstract void onDrawHorizontal(Canvas c, int left, int top, int right, int bottom);


    protected abstract int getDividerHeight();

    protected abstract int getDividerWidth();


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, getDividerHeight());
        } else {
            outRect.set(0, 0, getDividerWidth(), 0);
        }
    }

}