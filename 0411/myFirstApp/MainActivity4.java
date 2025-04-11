package com.example.myfirstapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    private TextView txtHistory;
    private Button btnClear, btnBackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        txtHistory = findViewById(R.id.txtHistory);
        btnClear = findViewById(R.id.btnClear);
        btnBackToMain = findViewById(R.id.btnBackToMain);

        SharedPreferences pref = getSharedPreferences("study_history", MODE_PRIVATE);
        String history = pref.getString("log", "기록 없음");
        txtHistory.setText(history);

        btnClear.setOnClickListener(v -> {
            pref.edit().clear().apply();
            txtHistory.setText("기록 없음");
        });

        btnBackToMain.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity4.this, MainActivity1.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}
