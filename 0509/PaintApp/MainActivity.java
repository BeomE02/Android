package com.example.paintapp;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private PaintView paintView;
    private Button btnColor, btnClear, btnUndo, btnSave;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paintView = findViewById(R.id.paintView);
        btnColor = findViewById(R.id.btnColor);
        btnClear = findViewById(R.id.btnClear);
        btnUndo = findViewById(R.id.btnUndo);
        btnSave = findViewById(R.id.btnSave);
        seekBar = findViewById(R.id.seekBar);

        btnColor.setOnClickListener(v -> showColorPicker());
        btnClear.setOnClickListener(v -> paintView.clearCanvas());
        btnUndo.setOnClickListener(v -> paintView.undo());
        btnSave.setOnClickListener(v -> {
            Bitmap bitmap = paintView.getBitmap();
            saveImageToGallery(bitmap);
        });

        seekBar.setMax(50);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                paintView.setStrokeWidth(progress);
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void showColorPicker() {
        final String[] colors = {"검정", "빨강", "파랑", "초록", "노랑"};
        final int[] colorValues = {
                Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW
        };

        new AlertDialog.Builder(this)
                .setTitle("색상 선택")
                .setItems(colors, (dialog, which) -> paintView.setColor(colorValues[which]))
                .show();
    }

    private void saveImageToGallery(Bitmap bitmap) {
        String savedImageURL = MediaStore.Images.Media.insertImage(
                getContentResolver(),
                bitmap,
                "PaintApp_" + System.currentTimeMillis(),
                "그림판 앱으로 저장됨"
        );

        if (savedImageURL != null) {
            Toast.makeText(this, "저장 완료!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "저장 실패", Toast.LENGTH_SHORT).show();
        }
    }
}
