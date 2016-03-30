package com.yalantis_task1;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private int space_length ; //[Comment] Wrong name and formatting. Use google code style
    public DividerItemDecoration(int space) {
        space_length = space;
    }
    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) { //[Comment] Deprecated method
        outRect.right = space_length;
    }
}