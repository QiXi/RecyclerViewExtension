package ru.qixi.recyclerextension;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by qixi on 21.11.15.
 */
public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int mVerticalSpaceHeight;


    public VerticalSpaceItemDecoration(int verticalSpaceHeight) {
        mVerticalSpaceHeight = verticalSpaceHeight;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.top = mVerticalSpaceHeight;
    }

}

