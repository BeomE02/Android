package com.example.diceapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView diceImage;
    private Button btnRoll;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceImage = findViewById(R.id.diceImage);
        btnRoll = findViewById(R.id.btnRoll);
        random = new Random();

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        int diceNumber = random.nextInt(6) + 1; // 1 ~ 6

        int imageResId = getResources().getIdentifier(
                "dice_" + diceNumber, "drawable", getPackageName());

        diceImage.setImageResource(imageResId);
    }
}
