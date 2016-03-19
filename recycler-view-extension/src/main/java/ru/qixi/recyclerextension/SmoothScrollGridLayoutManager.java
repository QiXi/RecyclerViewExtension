package ru.qixi.recyclerextension;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;


/**
 * Created by qixi on 11.03.16.
 */
public class SmoothScrollGridLayoutManager extends GridLayoutManager {

    private static final float  MILLISECONDS_PER_INCH = 110f;
    private static final PointF DIRECTION             = new PointF(0, 0);

    private RecyclerView.SmoothScroller mSmoothScroller;


    public SmoothScrollGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
        mSmoothScroller = new TopSnappedSmoothScroller(context) {
            //This controls the direction in which smoothScroll looks for your view
            @Override
            public PointF computeScrollVectorForPosition(int targetPosition) {
                if (getChildCount() == 0) {
                    return null;
                }
                final int firstChildPos = getPosition(getChildAt(0));
                final int direction = targetPosition < firstChildPos /*!= mShouldReverseLayout*/ ? -1 : 1;

                if (getOrientation() == HORIZONTAL) {
                    DIRECTION.set(direction, 0);
                    return DIRECTION;
                } else {
                    DIRECTION.set(0, direction);
                    return DIRECTION;
                }
            }


            //This returns the milliseconds it takes to scroll one pixel.
            @Override
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
            }
        };
    }


    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        mSmoothScroller.setTargetPosition(position);
        startSmoothScroll(mSmoothScroller);
    }


    private class TopSnappedSmoothScroller extends LinearSmoothScroller {


        public TopSnappedSmoothScroller(Context context) {
            super(context);
        }


        @Override
        public PointF computeScrollVectorForPosition(int targetPosition) {
            return SmoothScrollGridLayoutManager.this.computeScrollVectorForPosition(targetPosition);
        }


        @Override
        protected int getVerticalSnapPreference() {
            return SNAP_TO_START;
        }
    }

}