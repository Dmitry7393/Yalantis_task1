package com.yalantis_task1;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView
        .Adapter<MyRecyclerViewAdapter
        .DataObjectHolder> {
    private ArrayList<Bitmap> mDataset;
    public static class DataObjectHolder extends RecyclerView.ViewHolder {
        ImageView imageview;

        public DataObjectHolder(View itemView) {
            super(itemView);
            imageview = (ImageView) itemView.findViewById(R.id.recyclerviewimages);
        }

    }

    public MyRecyclerViewAdapter(ArrayList<Bitmap> myDataset) {
        mDataset = myDataset;
    }
    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.imageview.setImageBitmap(mDataset.get(position));  //.getImageUrl() //[Comment] Use third party library. Not bitmap list
    }

    public void addItem(Bitmap dataObj, int index) { //[Comment] Unused
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) { //[Comment] Unused
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}