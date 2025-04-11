package com.example.myfirstapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    private TextView txtTimer;
    private Button btnStart, btnPause, btnReset, btnBackToMain;
    private CountDownTimer countDownTimer;
    private boolean isRunning = false;

    private long timeLeftInMillis = 25 * 60 * 1000; // 25분

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtTimer = findViewById(R.id.txtTimer);
        btnStart = findViewById(R.id.btnStart);
        btnPause = findViewById(R.id.btnPause);
        btnReset = findViewById(R.id.btnReset);
        btnBackToMain = findViewById(R.id.btnBackToMain);

        updateTimerText();

        btnStart.setOnClickListener(v -> startTimer());
        btnPause.setOnClickListener(v -> pauseTimer());
        btnReset.setOnClickListener(v -> resetTimer());
        btnBackToMain.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity1.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }

    private void startTimer() {
        if (isRunning) return;

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimerText();
            }

            public void onFinish() {
                isRunning = false;
                txtTimer.setText("완료!");

                // ✅ 공부 기록 저장
                SharedPreferences pref = getSharedPreferences("study_history", MODE_PRIVATE);
                String old = pref.getString("log", "");
                String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
                pref.edit().putString("log", old + now + "\n").apply();
            }
        }.start();

        isRunning = true;
    }

    private void pauseTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            isRunning = false;
        }
    }

    private void resetTimer() {
        pauseTimer();
        timeLeftInMillis = 25 * 60 * 1000;
        updateTimerText();
    }

    private void updateTimerText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        txtTimer.setText(String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds));
    }
}
