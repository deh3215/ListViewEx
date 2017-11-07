package com.example.a32150.listviewex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewEx extends AppCompatActivity {

    private ListView lv;
    TextView tv;
    private String[] list = {"鉛筆","原子筆","鋼筆","毛筆","彩色筆"};
    private ArrayAdapter<String> listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listview1);
        tv=(TextView)findViewById(R.id.textView1);

        listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_single_choice,list);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "你選擇的是第" + + (position+1)+"項 : "+list[position], Toast.LENGTH_SHORT).show();
                tv.setText("你選擇的是第" + (position+1)+"項 : "+list[position]);
            }
        });


    }
}
