package ru.qixi.recyclerextension;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by qixi on 13.03.16.
 */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {


    private int     mSpacing;
    private boolean mIncludeEdge;


    public GridSpacingItemDecoration(int spacing, boolean includeEdge) {
        mSpacing = spacing;
        mIncludeEdge = includeEdge;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int spanCount = ((GridLayoutManager) parent.getLayoutManager()).getSpanCount();
        int column = position % spanCount;

        if (mIncludeEdge) {
            outRect.left = mSpacing - column * mSpacing / spanCount;
            outRect.right = (column + 1) * mSpacing / spanCount;

            if (position < spanCount) { // top edge
                outRect.top = mSpacing;
            }
            outRect.bottom = mSpacing; // item bottom
        } else {
            outRect.left = column * mSpacing / spanCount;
            outRect.right = mSpacing - (column + 1) * mSpacing / spanCount;
            if (position >= spanCount) {
                outRect.top = mSpacing; // item top
            }
        }
    }

}