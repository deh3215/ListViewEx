package com.example.a32150.listviewex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ListView lv;
    TextView tv;
    String[] activityNames = {
            "DataPickerEx",
            "ListViewEx",
            "RadioButtonEx",
            "SpinnerEx",
            "GridViewEx"
    };
    Class[] activityClasses = {
            DatePickerEx.class,
            ListViewEx.class,
            RadioButtonEx.class,
            SpinnerEx.class,
            GridViewEx.class
    };

    private ArrayAdapter<String> listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.listview1);
        tv = (TextView)findViewById(R.id.textView1);

        listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_single_choice, activityNames);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setAdapter(listAdapter);
        
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, activityClasses[position]);
                tv.setText("切換到:"+activityClasses[position]);
                Toast.makeText(getApplicationContext(), activityNames[position], Toast.LENGTH_SHORT);
                startActivity(i);
            }
        });
    }







}
