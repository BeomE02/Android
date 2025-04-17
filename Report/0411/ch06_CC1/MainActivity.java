package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etTask;
    private Button btnAdd;
    private ListView listView;
    private ArrayList<String> tasks;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask   = findViewById(R.id.etTask);
        btnAdd   = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);

        // 1) 초기에는 빈 리스트
        tasks = new ArrayList<>();

        // 2) 체크박스 모드의 ArrayAdapter 설정
        adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_multiple_choice,
            tasks
        );
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // 3) 추가 버튼 클릭 시
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = etTask.getText().toString().trim();
                if (!newTask.isEmpty()) {
                    tasks.add(newTask);
                    adapter.notifyDataSetChanged();
                    etTask.setText("");
                }
            }
        });
    }
}
