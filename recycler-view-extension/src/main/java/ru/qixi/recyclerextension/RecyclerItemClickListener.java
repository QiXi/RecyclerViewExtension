package ru.qixi.recyclerextension;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by qixi on 25.10.14.
 */
public abstract class RecyclerItemClickListener extends RecyclerView.SimpleOnItemTouchListener {


    private GestureDetectorCompat mGestureDetector;
    private RecyclerView          mRecyclerView;


    public RecyclerItemClickListener(Context pContext) {
        mGestureDetector = new GestureDetectorCompat(pContext, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent pMotionEvent) {
                View childView = mRecyclerView.findChildViewUnder(pMotionEvent.getX(), pMotionEvent.getY());
                int position = getViewPosition(mRecyclerView, childView);
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(childView, position);
                    return true;
                }
                onSingleTap();
                return false;
            }
        });
        mGestureDetector.setIsLongpressEnabled(false);
    }


    private int getViewPosition(RecyclerView recyclerView, View view) {
        return (view == null) ? RecyclerView.NO_POSITION : recyclerView.getChildAdapterPosition(view);
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView pChildView, MotionEvent pMotionEvent) {
        mRecyclerView = pChildView;
        mGestureDetector.onTouchEvent(pMotionEvent);
        return false;
    }


    public abstract void onItemClick(View childView, int position);


    public void onSingleTap() {

    }

}
