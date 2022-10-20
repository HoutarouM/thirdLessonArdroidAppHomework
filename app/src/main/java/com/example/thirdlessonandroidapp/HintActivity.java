package com.example.thirdlessonandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HintActivity extends AppCompatActivity {
    Button returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hint);

        returnBtn = findViewById(R.id.button3);

        returnBtn.setOnClickListener(view -> {
            Intent intent = new Intent(HintActivity.this, MainActivity.class);

            startActivity(intent);
        });
    }
}