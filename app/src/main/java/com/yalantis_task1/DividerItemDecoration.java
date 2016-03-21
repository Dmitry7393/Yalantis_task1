package com.yalantis_task1;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private int space_length ;
    public DividerItemDecoration(int space) {
        space_length = space;
    }
    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        outRect.right = space_length;
    }
}