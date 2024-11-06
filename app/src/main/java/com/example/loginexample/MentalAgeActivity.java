package com.example.loginexample;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MentalAgeActivity extends AppCompatActivity {
    private TextView txt, textnon;
    private Spinner sp1;
    private TextView txt2,txt3,txt4,txt5;
    private Spinner sp2,sp3,sp4,sp5;
    private Button btn;
    private List<Questions> questions;
   // private int questionIndex = 0;
    private int total=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mental_age);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txt = findViewById(R.id.txtmental);
       sp1 = findViewById(R.id.spinner);
       sp2 = findViewById(R.id.spinner2);
       sp3 = findViewById(R.id.spinner3);
       sp4 = findViewById(R.id.spinner4);
       sp5 = findViewById(R.id.spinner5);
       txt2 = findViewById(R.id.txtmental2);
       txt3 = findViewById(R.id.txtmental3);
       txt4 = findViewById(R.id.txtmental4);
       txt5 = findViewById(R.id.txtmental5);
        textnon = findViewById(R.id.textnon);
        btn = findViewById(R.id.submitmentalButton);

        questions = new ArrayList<>();
        questions.add(new Questions("Have you Traveled overseas recently?", new String[]{"Pausing to reorganize my life at this stage", "worldwide, for bussiness", "Family trip last year", "Asia, Europe, traveling whenever I feel like"}, new int[]{0,5,15,20}));
        questions.add(new Questions("How do you choose your fitness exercise?", new String[]{"Running outside Occasionally", "My personal trainer gives me new routines", "At home", "Running around doing my errands"}, new int[]{5,17,1,10}));
        questions.add(new Questions("What movie would you rather watch in a rainy, dreary Thursday night?", new String[]{"Romance movies", "Horror movies", "sad movies", "Action, Scifi movies"}, new int[]{25,20,1,17}));
        questions.add(new Questions("What is your favorite day of the week?", new String[]{"Monday", "Friday", "Thursday", "Sunday"}, new int[]{4,17,35,12}));
        questions.add(new Questions("What is the most important social media account?", new String[]{"Instagram", "Facebook", "Twitter", "Tick Tok"}, new int[]{15,19,7,2}));

       showQuestion();

        // Set listener for submit button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sp1.getSelectedItemPosition() != -1 && sp2.getSelectedItemPosition() != -1 &&
                        sp3.getSelectedItemPosition() != -1 && sp4.getSelectedItemPosition() != -1 &&
                        sp5.getSelectedItemPosition() != -1) {

                    // Calculate total score based on selected answers
                    total = 0;
                    total += questions.get(0).getPoints()[sp1.getSelectedItemPosition()];
                    total += questions.get(1).getPoints()[sp2.getSelectedItemPosition()];
                    total += questions.get(2).getPoints()[sp3.getSelectedItemPosition()];
                    total += questions.get(3).getPoints()[sp4.getSelectedItemPosition()];
                    total += questions.get(4).getPoints()[sp5.getSelectedItemPosition()];

                    // Display the final evaluation
                    showFinalEvaluation();
                } else {
                    Toast.makeText(MentalAgeActivity.this, "Please answer all questions.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void showQuestion() {
        // Populate each spinner with answers from the corresponding question
        txt.setText(questions.get(0).getQuestion());
        txt2.setText(questions.get(1).getQuestion());
        txt3.setText(questions.get(2).getQuestion());
        txt4.setText(questions.get(3).getQuestion());
        txt5.setText(questions.get(4).getQuestion());

        populateSpinner(sp1, questions.get(0).getAnswers());
        populateSpinner(sp2, questions.get(1).getAnswers());
        populateSpinner(sp3, questions.get(2).getAnswers());
        populateSpinner(sp4, questions.get(3).getAnswers());
        populateSpinner(sp5, questions.get(4).getAnswers());
    }

    private void populateSpinner(Spinner spinner, String[] answers) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, answers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    private void showFinalEvaluation() {
        String evaluationMessage;
        if (total <= 7) {
            evaluationMessage = "Mental Age: Young - You have a youthful outlook!";
        } else if (total <= 15) {
            evaluationMessage = "Mental Age: Adult - You have a balanced and mature perspective!";
        } else {
            evaluationMessage = "Mental Age: Wise - You have a mature and experienced outlook on life!";
        }
        textnon.setText(evaluationMessage);
        textnon.setVisibility(View.VISIBLE);
        Toast.makeText(this, evaluationMessage, Toast.LENGTH_LONG).show();
    }

    }




