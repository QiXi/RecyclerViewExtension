package ru.qixi.recyclerextension;

import android.support.v7.widget.RecyclerView;
import android.graphics.Rect;
import android.view.View;


public class SpacingItemDecoration extends RecyclerView.ItemDecoration {

    private boolean mIncludeEdge;
    private int     mSpacing;
    private int     mSpacingEdge;


    public SpacingItemDecoration(int spacing, int spacingEdge) {
        mSpacing = spacing;
        mIncludeEdge = (spacingEdge > 0);
        mSpacingEdge = spacingEdge;
    }


    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        if (mIncludeEdge) {
            outRect.left = mSpacingEdge;
            outRect.right = mSpacingEdge;
            if (position == 0) {
                outRect.top = mSpacingEdge;
            }
            outRect.bottom = mSpacing;
            return;
        }
        outRect.left = 0;
        outRect.right = 0;
        if (position >= 1) {
            outRect.top = mSpacing;
        }
    }

}
