package com.example.loginexample;

import android.content.Intent;
import android.media.midi.MidiDevice;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
private ListView listView;
//private ArrayList<Medicationclass> medicationclassArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.listview);
        String[] testArray = getResources().getStringArray(R.array.list);
        List<String> testList = Arrays.asList(testArray);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getBaseContext(),
                android.R.layout.simple_list_item_1, testList);

        // setting adapter on listview
        listView.setAdapter(adapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Intent intent = new Intent(SecondActivity.this, thirdActivity.class);
                    startActivity(intent);
                }if(i == 1){
                    Intent intent = new Intent(SecondActivity.this,QuizActivity.class);
                    startActivity(intent);
                }if(i == 2){
                    Intent intent = new Intent(SecondActivity.this,MentalAgeActivity.class);
                    startActivity(intent);
                }
            }
        };
       // ListView listView = (ListView) findViewById(R.id.listactivity1);
        listView.setOnItemClickListener(itemListener);
    }
}