package com.example.a32150.listviewex;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewEx extends AppCompatActivity {

    GridView gv;
    private final int count = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_ex);

        gv=findViewById(R.id.gridview);
        gv.setNumColumns(count);
        gv.setAdapter(new ImageAdapter(this));
    }

    class ImageAdapter extends BaseAdapter{
        int[] imgAry = {
          R.drawable.img001, R.drawable.img002, R.drawable.img003,
          R.drawable.img004, R.drawable.img005, R.drawable.img006,
          R.drawable.img007, R.drawable.img008, R.drawable.img009,
          R.drawable.img010, R.drawable.img011, R.drawable.img012
        };

        Context ct;

        ImageAdapter(Context cxt)  {
            ct = cxt;
        }

        @Override
        public int getCount() {
            return imgAry.length;
        }

        @Override
        public Object getItem(int i) {
            return imgAry[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            //抓取螢幕寬,高
            //DisplayMetrics displayMetrics = new DisplayMetrics();
            //getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//            int height = displayMetrics.heightPixels;
//            int width = displayMetrics.widthPixels;
            int width=getResources().getDisplayMetrics().widthPixels ;
            int height=getResources().getDisplayMetrics().heightPixels ;


            ImageView iv = new ImageView(ct);
            iv.setLayoutParams(new GridView.LayoutParams(width/count,height/(imgAry.length/count)));
            Log.d("WIDTH", ""+width);
            Log.d("HEIGHT", ""+height);
            iv.setScaleType(ImageView.ScaleType.CENTER);
            //iv.setPadding(8,8,8,8);
            iv.setImageResource(imgAry[i]);

            return iv;
        }
    }
}
