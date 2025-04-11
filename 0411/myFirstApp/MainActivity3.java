package com.example.myfirstapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity3 extends AppCompatActivity {

    private static final String PREF_NAME = "theme_pref";
    private static final String KEY_DARK_MODE = "dark_mode";

    private Switch switchTheme;
    private Button btnBackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ⚡ 테마 먼저 적용
        SharedPreferences pref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        boolean isDark = pref.getBoolean(KEY_DARK_MODE, false);
        AppCompatDelegate.setDefaultNightMode(
                isDark ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO
        );

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        switchTheme = findViewById(R.id.switchTheme);
        btnBackToMain = findViewById(R.id.btnBackToMain);

        switchTheme.setChecked(isDark);

        switchTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean(KEY_DARK_MODE, isChecked);
            editor.apply();

            AppCompatDelegate.setDefaultNightMode(
                    isChecked ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO
            );

            recreate(); // 즉시 테마 반영
        });

        btnBackToMain.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity1.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}
