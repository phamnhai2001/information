package com.example.infomation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        private ListView lvList;
        private void initUI() {
            lvList = findViewById(R.id.lvList);
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        ArrayList<String> data = new ArrayList<>();

        data.add("A-0987654321");
        data.add("B-0876301819");
        data.add("C-0325671904");
        data.add("D-0302445555");
        data.add("E-0179238028");
        data.add("F-0377889911");
        data.add("G-0322334455");
        data.add("H-0366778899");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);

        lvList.setAdapter(myAdapter);

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemChosen = (String) lvList.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("contact", itemChosen);
                startActivity(intent);
            }
        });
    }
}