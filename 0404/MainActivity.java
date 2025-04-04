package com.example.contraintlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    TextView resultText;
    String operator = "";
    EditText currentInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        resultText = findViewById(R.id.resultText);

        number1.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) currentInput = number1;
        });

        number2.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) currentInput = number2;
        });

        currentInput = number1; // 기본값

        setNumberButtonListeners();
        setOperatorButtonListeners();
    }

    private void setNumberButtonListeners() {
        int[] numberBtnIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        };

        for (int id : numberBtnIds) {
            Button btn = findViewById(id);
            btn.setOnClickListener(v -> {
                if (currentInput != null) {
                    currentInput.append(btn.getText());
                }
            });
        }

        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(v -> {
            number1.setText("");
            number2.setText("");
            resultText.setText("결과: ");
            operator = "";
        });
    }

    private void setOperatorButtonListeners() {
        findViewById(R.id.btnAdd).setOnClickListener(v -> operator = "+");
        findViewById(R.id.btnSubtract).setOnClickListener(v -> operator = "-");
        findViewById(R.id.btnMultiply).setOnClickListener(v -> operator = "*");
        findViewById(R.id.btnDivide).setOnClickListener(v -> operator = "/");

        Button btnEquals = findViewById(R.id.btnEquals);
        btnEquals.setOnClickListener(v -> {
            try {
                double num1 = Double.parseDouble(number1.getText().toString());
                double num2 = Double.parseDouble(number2.getText().toString());
                double result;

                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/":
                        if (num2 == 0) {
                            resultText.setText("0으로 나눌 수 없습니다.");
                            return;
                        }
                        result = num1 / num2;
                        break;
                    default:
                        resultText.setText("연산자를 선택하세요.");
                        return;
                }

                resultText.setText("결과: " + result);
            } catch (NumberFormatException e) {
                resultText.setText("숫자를 모두 입력하세요.");
            }
        });
    }
}

