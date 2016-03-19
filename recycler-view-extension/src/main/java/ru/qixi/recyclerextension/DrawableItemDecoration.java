package ru.qixi.recyclerextension;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;


/**
 * Created by qixi on 06.04.2015.
 */
public class DrawableItemDecoration extends DividerItemDecoration {

    private final Drawable mDivider;
    private final int      mSize;


    public DrawableItemDecoration(int orientation, Drawable divider) {
        super(orientation);
        mDivider = divider;
        mSize = mDivider.getIntrinsicHeight();
    }


    @Override
    protected void onDrawVertical(Canvas c, int left, int top, int right, int bottom) {
        mDivider.setBounds(left, top, right, bottom);
        mDivider.draw(c);
    }


    @Override
    protected void onDrawHorizontal(Canvas c, int left, int top, int right, int bottom) {
        mDivider.setBounds(left, top, right, bottom);
        mDivider.draw(c);
    }


    @Override
    protected int getDividerHeight() {
        return mSize;
    }


    @Override
    protected int getDividerWidth() {
        return mSize;
    }

}