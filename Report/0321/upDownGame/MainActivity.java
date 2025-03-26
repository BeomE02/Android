package com.example.numberguess;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int answerNumber;
    private EditText editTextNumber;
    private TextView textResult;
    private Button btnGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 초기화
        editTextNumber = findViewById(R.id.editTextNumber);
        textResult = findViewById(R.id.textResult);
        btnGuess = findViewById(R.id.btnGuess);

        // 랜덤 정답 생성
        answerNumber = new Random().nextInt(100) + 1; // 1 ~ 100

        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = editTextNumber.getText().toString();

                if (userInput.isEmpty()) {
                    Toast.makeText(MainActivity.this, "숫자를 입력하세요!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int guess = Integer.parseInt(userInput);

                if (guess < answerNumber) {
                    textResult.setText("Low!!");
                } else if (guess > answerNumber) {
                    textResult.setText("High!!");
                } else {
                    textResult.setText("Correct!! 🎉");
                }
            }
        });
    }
}
