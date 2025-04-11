package com.example.intentex;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(v -> finish());  // 현재 액티비티 종료
    }
}
