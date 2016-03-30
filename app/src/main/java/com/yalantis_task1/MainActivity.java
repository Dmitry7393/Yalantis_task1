package com.yalantis_task1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
//[Comment] Wrong toolbar and status bar colors
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true); //[Comment] Can be null
    }
    /** Creating RecyclerView */
    private void initRecyclerView()
    { //[Comment] FORMATTING!!!
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter mAdapter = new MyRecyclerViewAdapter(getDataSet());

        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                                        new DividerItemDecoration(15);
        mRecyclerView.addItemDecoration(itemDecoration);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
    /** Show toast with control name when user presses any control*/
    public void onClickToast(View view) {
        String text = view.getClass().getSimpleName();
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
    /** Returns the array with images */
    private ArrayList<Bitmap> getDataSet() {
        String [] list_images = listAssetFiles("Pictures"); //[Comment] Hardcode
        ArrayList results = new ArrayList<Bitmap>(); //[Comment] new ArrayList<>(). Use abstraction instead of realization.
        Bitmap bitmap;
        for (int index = 0; index < list_images.length; index++)
        { //[Comment] Wring formatting
            bitmap =  loadImageFromAsset("Pictures/" + list_images[index]);
            results.add(index, bitmap);
        }
        return results;
    }
    /** Returns the bitmap from folder assets */
    public Bitmap loadImageFromAsset(String filename) {
        Bitmap bitmap;
        try {
            InputStream ims = getAssets().open(filename);
            bitmap = BitmapFactory.decodeStream(ims);
        }
        catch(IOException ex) {
            return null;
        }
        return bitmap;
    }
    /** Returns the list of images from assets/Pictures */
    private String[] listAssetFiles(String path) {
        String [] list;
        try {
            list = getAssets().list(path);
        } catch (IOException e) {
            return null;
        }
        return list;
    }
}
