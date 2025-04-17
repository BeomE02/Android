    package com.example.myapplication;

    import android.os.Bundle;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.RadioGroup;
    import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        private RadioGroup radioGroup;
        private Button btnDisplay;
        private ImageView imageView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            radioGroup = findViewById(R.id.radioGroup);
            btnDisplay = findViewById(R.id.btnDisplay);
            imageView = findViewById(R.id.imageView);

            btnDisplay.setOnClickListener(v -> {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == R.id.radio233) {
                    imageView.setImageResource(R.drawable.image0);
                } else if (selectedId == R.id.radio41) {
                    imageView.setImageResource(R.drawable.image1);
                } else if (selectedId == R.id.radio44) {
                    imageView.setImageResource(R.drawable.image2);
                }
            });

        }
    }

