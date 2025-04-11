package com.example.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    Button btnTimer, btnTheme, btnHistory, btnGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        btnTimer = findViewById(R.id.btnTimer);
        btnTheme = findViewById(R.id.btnTheme);
        btnHistory = findViewById(R.id.btnHistory);
        btnGoal = findViewById(R.id.btnGoal);

        btnTimer.setOnClickListener(v ->
                startActivity(new Intent(this, MainActivity2.class)));

        btnTheme.setOnClickListener(v ->
                startActivity(new Intent(this, MainActivity3.class)));

        btnHistory.setOnClickListener(v ->
                startActivity(new Intent(this, MainActivity4.class)));

        btnGoal.setOnClickListener(v ->
                startActivity(new Intent(this, MainActivity5.class)));
    }
}
