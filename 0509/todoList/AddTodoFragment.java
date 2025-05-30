package com.example.todomanager.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.todomanager.R;
import com.example.todomanager.db.TodoDatabase;
import com.example.todomanager.model.TodoItem;

import java.text.SimpleDateFormat;
import java.util.*;

import java.util.concurrent.Executors;

public class AddTodoFragment extends Fragment {

    private EditText editTitle, editContent;
    private Button btnSave, btnCancel, btnSelectDate;
    private TextView tvSelectedDate;

    private Calendar selectedDate;

    public AddTodoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_todo, container, false);

        editTitle = view.findViewById(R.id.editTitle);
        editContent = view.findViewById(R.id.editContent);
        btnSave = view.findViewById(R.id.btnSave);
        btnCancel = view.findViewById(R.id.btnCancel);
        btnSelectDate = view.findViewById(R.id.btnSelectDate);
        tvSelectedDate = view.findViewById(R.id.tvSelectedDate);

        // 기본 날짜는 오늘
        selectedDate = Calendar.getInstance();
        updateDateText();

        btnSelectDate.setOnClickListener(v -> showDatePicker());
        btnCancel.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());

        btnSave.setOnClickListener(v -> {
            String title = editTitle.getText().toString().trim();
            String content = editContent.getText().toString().trim();

            if (TextUtils.isEmpty(title)) {
                Toast.makeText(getContext(), "제목을 입력하세요", Toast.LENGTH_SHORT).show();
                return;
            }

            long timestamp = selectedDate.getTimeInMillis();
            TodoItem todo = new TodoItem(title, content, timestamp);

            Executors.newSingleThreadExecutor().execute(() -> {
                TodoDatabase.getInstance(getContext()).todoDao().insertTodo(todo);
            });

            Toast.makeText(getContext(), "할 일이 추가되었습니다", Toast.LENGTH_SHORT).show();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new TodoListFragment())
                    .commit();
        });

        return view;
    }

    private void showDatePicker() {
        int year = selectedDate.get(Calendar.YEAR);
        int month = selectedDate.get(Calendar.MONTH);
        int day = selectedDate.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(getContext(), (view, y, m, d) -> {
            selectedDate.set(y, m, d);
            updateDateText();
        }, year, month, day).show();
    }

    private void updateDateText() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String formatted = sdf.format(selectedDate.getTime());
        tvSelectedDate.setText("선택된 날짜: " + formatted);
    }
}
