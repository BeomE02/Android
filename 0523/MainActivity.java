package com.example.todomanager;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.todomanager.fragment.CalendarFragment;
import com.example.todomanager.fragment.StatisticsFragment;
import com.example.todomanager.fragment.TodoListFragment;
import com.example.todomanager.fragment.AddTodoFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private Button btnNavTodoList, btnNavCalendar, btnNavStats;
    private FloatingActionButton fabAdd;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupBottomNavigation();

        // 기본으로 할 일 목록 Fragment 표시
        showFragment(new TodoListFragment(), true);
    }

    private void initViews() {
        btnNavTodoList = findViewById(R.id.btnNavTodoList);
        btnNavCalendar = findViewById(R.id.btnNavCalendar);
        btnNavStats = findViewById(R.id.btnNavStats);
        fabAdd = findViewById(R.id.fabAdd);
    }

    private void setupBottomNavigation() {
        btnNavTodoList.setOnClickListener(v -> {
            showFragment(new TodoListFragment(), false);
            updateNavigationButtons(true, false, false);
        });

        btnNavCalendar.setOnClickListener(v -> {
            showFragment(new CalendarFragment(), false);
            updateNavigationButtons(false, true, false);
        });

        btnNavStats.setOnClickListener(v -> {
            showFragment(new StatisticsFragment(), false);
            updateNavigationButtons(false, false, true);
        });

        fabAdd.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new AddTodoFragment())
                    .addToBackStack(null)
                    .commit();
        });

        // 초기 상태 설정
        updateNavigationButtons(true, false, false);
    }

    private void showFragment(Fragment fragment, boolean isInitial) {
        currentFragment = fragment;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);

        if (!isInitial) {
            // 백스택 클리어 (네비게이션 간 이동 시)
            for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++) {
                getSupportFragmentManager().popBackStack();
            }
        }

        transaction.commit();
    }

    private void updateNavigationButtons(boolean todoSelected, boolean calendarSelected, boolean statsSelected) {
        // 할 일 목록 버튼
        btnNavTodoList.setTextColor(getResources().getColor(
                todoSelected ? android.R.color.holo_blue_bright : android.R.color.darker_gray));

        // 캘린더 버튼
        btnNavCalendar.setTextColor(getResources().getColor(
                calendarSelected ? android.R.color.holo_blue_bright : android.R.color.darker_gray));

        // 통계 버튼
        btnNavStats.setTextColor(getResources().getColor(
                statsSelected ? android.R.color.holo_blue_bright : android.R.color.darker_gray));
    }

    @Override
    public void onBackPressed() {
        // 백스택이 있으면 뒤로가기, 없으면 메인 화면으로
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            // 현재 메인 Fragment가 아니면 할 일 목록으로 이동
            if (!(currentFragment instanceof TodoListFragment)) {
                showFragment(new TodoListFragment(), false);
                updateNavigationButtons(true, false, false);
            } else {
                super.onBackPressed();
            }
        }
    }
}