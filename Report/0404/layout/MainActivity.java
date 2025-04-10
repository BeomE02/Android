package com.example.myapp;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // XML의 ImageView 연결
        imageView = findViewById(R.id.imageView);

        // 동적으로 이미지 변경하기
        imageView.setImageResource(R.drawable.example_image);
    }
}
