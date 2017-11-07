package com.example.a32150.listviewex;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewEx extends AppCompatActivity {

    GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_ex);

        gv=findViewById(R.id.gridview);
        gv.setAdapter(new ImageAdapter(this));
    }

    class ImageAdapter extends BaseAdapter{
        int[] imgAry = {
          R.drawable.img001,
          R.drawable.img002,
          R.drawable.img003,
          R.drawable.img004,
          R.drawable.img005,
          R.drawable.img006,
          R.drawable.img007,
          R.drawable.img008,
          R.drawable.img009,
          R.drawable.img010,
          R.drawable.img011,
          R.drawable.img012
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
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView iv = new ImageView(ct);
            iv.setLayoutParams(new GridView.LayoutParams(150,150));
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iv.setPadding(8,8,8,8);
            iv.setImageResource(imgAry[i]);

            return iv;
        }
    }
}
