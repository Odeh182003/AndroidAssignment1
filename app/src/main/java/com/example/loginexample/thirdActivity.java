package com.example.loginexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class thirdActivity extends AppCompatActivity {
    private TextView txt1;
    private Spinner spinner;
    //private Medicationclass midicines;
    private Button btn;
    private ArrayList<String> moodList;
    private ArrayAdapter<String> moodAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        txt1 = findViewById(R.id.title);
       spinner = findViewById(R.id.mood_spinner);
        btn = findViewById(R.id.add_mood_button);
        String[] moods = {"Happy", "Sad", "Angry", "Anxious", "Excited", "Calm"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, moods);
        //spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        // Initialize mood list and adapter for ListView
        moodList = new ArrayList<>();
        moodAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, moodList);
        //moodListView.setAdapter(moodAdapter);

        // Add Mood Button Click Listener
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedMood = spinner.getSelectedItem().toString();
                moodList.add(selectedMood);
                moodAdapter.notifyDataSetChanged();
                txt1.setText("I am "+selectedMood);
                Toast.makeText(thirdActivity.this, "Mood Added: " + selectedMood, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
