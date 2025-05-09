package com.example.todomanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.todomanager.fragment.TodoListFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 기본으로 할 일 목록 Fragment 표시
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new TodoListFragment());
        transaction.commit();

        // 플로팅 버튼 클릭 시 할 일 추가 Fragment로 이동
        FloatingActionButton fab = findViewById(R.id.fabAdd);
        fab.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new com.example.todomanager.fragment.AddTodoFragment())
                    .addToBackStack(null)
                    .commit();
        });
    }
}
