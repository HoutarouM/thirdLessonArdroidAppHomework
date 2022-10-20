package com.example.thirdlessonandroidapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button checkBtn;
    RadioGroup answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        checkBtn = findViewById(R.id.button);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAnswer()) {
                    Toast.makeText(MainActivity.this, "Dobra odpowiedz", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Zla odpowiedz", Toast.LENGTH_SHORT).show();
                }
            }
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