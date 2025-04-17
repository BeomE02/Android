package com.example.codingchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnIntroduction, btnSettings, btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIntroduction = findViewById(R.id.btnIntroduction);
        btnSettings     = findViewById(R.id.btnSettings);
        btnStart        = findViewById(R.id.btnStart);

        btnIntroduction.setOnClickListener(v ->
            startActivity(new Intent(this, IntroductionActivity.class))
        );

        btnSettings.setOnClickListener(v ->
            startActivity(new Intent(this, SettingsActivity.class))
        );

        btnStart.setOnClickListener(v ->
            startActivity(new Intent(this, StartActivity.class))
        );
    }
}
