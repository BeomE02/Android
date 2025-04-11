package com.example.contraintlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    FrameLayout colorBox;
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // colorBox는 이미지가 포함된 박스 (배경만 이걸로 바꿈)
        colorBox = findViewById(R.id.colorBox);

        btn1 = findViewById(R.id.btnColor1);
        btn2 = findViewById(R.id.btnColor2);
        btn3 = findViewById(R.id.btnColor3);
        btn4 = findViewById(R.id.btnColor4);

        btn1.setOnClickListener(v -> colorBox.setBackgroundColor(Color.RED));
        btn2.setOnClickListener(v -> colorBox.setBackgroundColor(Color.GREEN));
        btn3.setOnClickListener(v -> colorBox.setBackgroundColor(Color.BLUE));
        btn4.setOnClickListener(v -> colorBox.setBackgroundColor(Color.YELLOW));
    }
}
