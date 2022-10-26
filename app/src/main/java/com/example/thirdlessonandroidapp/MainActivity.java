package com.example.thirdlessonandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Question> questions = new ArrayList<>();

    ImageView photo;

    TextView questionText;

    RadioGroup radioGroup;
    RadioButton rBtn1;
    RadioButton rBtn2;
    RadioButton rBtn3;

    Button checkBtn;
    Button hintBtn;

    int questionsIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ArrayList<Integer> a = new ArrayList<>();
        a.add(R.string.q1a1);
        a.add(R.string.q1a2);
        a.add(R.string.q1a3);

        addQuestion(R.string.q1, a, R.drawable.photo, "test", 1);

        ArrayList<Integer> b = new ArrayList<>();
        b.add(R.string.q2a1);
        b.add(R.string.q2a2);
        b.add(R.string.q2a3);

        addQuestion(R.string.q2, b, R.drawable.photo, "test", 1);

        getLayoutViews();

        setViewsValues(questions.get(questionsIndex));

        checkBtn.setOnClickListener(view -> {
            if (checkAnswer(questions.get(questionsIndex))) {
                if (questionsIndex + 1 < questions.size()) {
                    questionsIndex++;
                    setViewsValues(questions.get(questionsIndex));
                } else {
                    Toast.makeText(MainActivity.this, "Ostatnie pytanie", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, R.string.bad_answer, Toast.LENGTH_SHORT).show();
            }
        });

        hintBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, HintActivity.class);

            startActivity(intent);
        });
    }

    private void getLayoutViews() {
//                get layout views
        photo = findViewById(R.id.imageView);

        questionText = findViewById(R.id.text_view);

        radioGroup = findViewById(R.id.radio_group);
        rBtn1 = findViewById(R.id.radioButton);
        rBtn2 = findViewById(R.id.radioButton2);
        rBtn3 = findViewById(R.id.radioButton3);

        checkBtn = findViewById(R.id.button);
        hintBtn = findViewById(R.id.button2);
    }

    private void addQuestion(int questionTestId, ArrayList<Integer> answers, int photoDrawableId, String hintText, int correctAnswerId) {
//       create question
        Question firstQuestion = new Question(questionTestId, answers, photoDrawableId, hintText, correctAnswerId);
        questions.add(firstQuestion);
    }

    private void setViewsValues(Question question) {
//      show data from question object
        photo.setImageResource(question.getImageId());
        questionText.setText(question.getQuestionText());
        rBtn1.setText(question.getAnswers().get(0));
        rBtn2.setText(question.getAnswers().get(1));
        rBtn3.setText(question.getAnswers().get(2));
    }


    private boolean checkAnswer(Question question) {
        radioGroup = findViewById(R.id.radio_group);

        int answerId = radioGroup.getCheckedRadioButtonId();

        if (answerId == R.id.radioButton) {
            answerId = 0;
        }

        if (answerId == R.id.radioButton2) {
            answerId = 1;
        }

        if (answerId == R.id.radioButton3) {
            answerId = 2;
        }

        return question.isCorrectAnswer(answerId);
    }
}