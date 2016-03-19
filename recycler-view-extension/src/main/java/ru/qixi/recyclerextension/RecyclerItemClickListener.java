package ru.qixi.recyclerextension;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import static android.view.GestureDetector.SimpleOnGestureListener;


/**
 * Created by qixi on 25.10.14.
 */
public abstract class RecyclerItemClickListener extends RecyclerView.SimpleOnItemTouchListener {


    private GestureDetectorCompat mGestureDetector;
    private RecyclerView          mRecyclerView;


    public RecyclerItemClickListener(Context pContext) {
        mGestureDetector = new GestureDetectorCompat(pContext, new SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View childView = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
                if (childView == null) {
                    return false;
                }
                int position = mRecyclerView.getChildAdapterPosition(childView);
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(childView, position);
                    return true;
                }
                return false;
            }
        });
        mGestureDetector.setIsLongpressEnabled(false);
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        //Log.d("view:%s e:%s", view, e);
        mRecyclerView = view;
        mGestureDetector.onTouchEvent(e);
        return false;
    }


    public abstract void onItemClick(View view, int position);


}
