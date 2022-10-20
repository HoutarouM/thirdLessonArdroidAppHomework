package com.example.thirdlessonandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//    intencje jawne zawsze dozwolone
//    niejawne potrzebuja zezwolenie

    Button checkBtn;
    Button hintBtn;

    RadioGroup answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        checkBtn = findViewById(R.id.button);
        hintBtn = findViewById(R.id.button2);

        checkBtn.setOnClickListener(view -> {
            if (checkAnswer()) {
                Toast.makeText(MainActivity.this, R.string.good_answer, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, R.string.bad_answer, Toast.LENGTH_SHORT).show();
            }
        });

        hintBtn.setOnClickListener(view -> {
//            intencja jawna, wiadomo skad do kad
            Intent intent = new Intent(MainActivity.this, HintActivity.class);

            startActivity(intent);
        });
    }

    private boolean checkAnswer() {
        answers = findViewById(R.id.radio_group);

        int answerId = answers.getCheckedRadioButtonId();

        if (answerId == R.id.radioButton2) {
            return true;
        } else {
            return false;
        }
    }
}