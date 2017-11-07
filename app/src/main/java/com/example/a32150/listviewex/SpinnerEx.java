package com.example.a32150.listviewex;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerEx extends AppCompatActivity {

    //TextView tv;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_ex);
        Spinner sp = (Spinner)findViewById(R.id.spinner);

        adapter = ArrayAdapter.createFromResource(this, R.array.bike_brand, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.select_dialog_multichoice);

        sp.setAdapter(adapter);
        sp.setSelection(0, true);
        sp.setOnItemSelectedListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.spinner_menu, menu);
        MenuItem item = menu.findItem(R.id.actionbar_spinner);
        Spinner sp = (Spinner) MenuItemCompat.getActionView(item);

        sp.setAdapter(adapter);
        sp.setSelection(0, true);
        sp.setOnItemSelectedListener(listener);

        return super.onCreateOptionsMenu(menu);
    }

    AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(SpinnerEx.this, "你選的是" + adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };


}
