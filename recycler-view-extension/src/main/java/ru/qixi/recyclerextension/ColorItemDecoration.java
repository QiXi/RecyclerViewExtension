package ru.qixi.recyclerextension;

import android.graphics.Canvas;
import android.graphics.Paint;


/**
 * Created by qixi on 06.04.2015.
 */
public class ColorItemDecoration extends DividerItemDecoration {

    private final Paint mPaint;
    private final int   mSize;


    public ColorItemDecoration(int orientation, int color, int size) {
        super(orientation);
        mPaint = new Paint();
        mPaint.setColor(color);
        mSize = size;
    }


    @Override
    protected void onDrawVertical(Canvas c, int left, int top, int right, int bottom) {
        c.drawRect(left, top, right, bottom, mPaint);
    }


    @Override
    protected void onDrawHorizontal(Canvas c, int left, int top, int right, int bottom) {
        c.drawRect(left, top, right, bottom, mPaint);
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