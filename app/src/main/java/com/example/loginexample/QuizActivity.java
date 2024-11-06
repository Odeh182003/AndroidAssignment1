package com.example.loginexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizActivity extends AppCompatActivity {
    private EditText edtxt1,edtxt2,edtxt3;
    private TextView txt;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtxt1 = findViewById(R.id.edtxt);
        edtxt2 = findViewById(R.id.edtxt2);
        edtxt3 = findViewById(R.id.edtxt3);
        btn = findViewById(R.id.button);
        txt = findViewById(R.id.textView3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayQuizResults();
            }
        });
    }
    public void displayQuizResults(){
        String answer1 = edtxt1.getText().toString();
        String answer2 = edtxt2.getText().toString();
        String answer3 = edtxt3.getText().toString();
       analyzeMood(answer1);

    }
    private String analyzeMood(String feelings) {
        String moodAnalysis;

        // Simple mood analysis based on keywords
        if (feelings.isEmpty()) {
            return "Please share how you are feeling.";
        }

        feelings = feelings.toLowerCase();
        if (feelings.contains("happy") || feelings.contains("excited") || feelings.contains("good")) {
            moodAnalysis = "It sounds like you're feeling positive! Keep up the great work!";
        } else if (feelings.contains("sad") || feelings.contains("bad") || feelings.contains("down")) {
            moodAnalysis = "It seems like you're feeling low. It's okay to have tough days. Consider talking to someone.";
        } else if (feelings.contains("anxious") || feelings.contains("nervous")) {
            moodAnalysis = "You might be feeling anxious. Remember to take deep breaths and try to relax.";
        } else if (feelings.contains("angry") || feelings.contains("frustrated")) {
            moodAnalysis = "It's okay to feel angry. Find healthy ways to express this emotion.";
        } else {
            moodAnalysis = "Thanks for sharing! Remember, it's important to reflect on how you're feeling.";
        }
        txt.setText(moodAnalysis);
        txt.setVisibility(View.VISIBLE);
        return moodAnalysis;
    }
}