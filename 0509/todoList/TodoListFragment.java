package com.example.todomanager.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todomanager.R;
import com.example.todomanager.adapter.TodoAdapter;
import com.example.todomanager.db.TodoDatabase;
import com.example.todomanager.model.TodoItem;
import com.example.todomanager.util.DateUtils;

import java.util.*;
import java.util.concurrent.Executors;

public class TodoListFragment extends Fragment {

    private RecyclerView recyclerView;
    private TodoAdapter adapter;
    private List<TodoItem> todoList = new ArrayList<>();
    private TextView tvEmpty;
    private Button btnDeleteAll;

    public TodoListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        tvEmpty = view.findViewById(R.id.tvEmpty);
        btnDeleteAll = view.findViewById(R.id.btnDeleteAll);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new TodoAdapter(
                todoList,
                this::onTodoComplete,
                this::onTodoDelete
        );
        recyclerView.setAdapter(adapter);

        btnDeleteAll.setOnClickListener(v -> showDeleteAllDialog());

        loadTodayTodos();
        return view;
    }

    private void loadTodayTodos() {
        long todayStart = DateUtils.getTodayStartTimestamp();

        Executors.newSingleThreadExecutor().execute(() -> {
            List<TodoItem> data = TodoDatabase.getInstance(getContext())
                    .todoDao().getTodayTodos(todayStart);

            requireActivity().runOnUiThread(() -> {
                todoList.clear();
                todoList.addAll(data);
                adapter.notifyDataSetChanged();

                boolean isEmpty = todoList.isEmpty();
                recyclerView.setVisibility(isEmpty ? View.GONE : View.VISIBLE);
                tvEmpty.setVisibility(isEmpty ? View.VISIBLE : View.GONE);
                btnDeleteAll.setVisibility(isEmpty ? View.GONE : View.VISIBLE);
            });
        });
    }

    private void onTodoComplete(TodoItem item) {
        if (item.isDone) return;

        new AlertDialog.Builder(getContext())
                .setTitle("할 일 완료")
                .setMessage("정말 완료하셨나요?")
                .setPositiveButton("네", (dialog, which) -> {
                    item.isDone = true;
                    item.doneTime = System.currentTimeMillis();

                    Executors.newSingleThreadExecutor().execute(() -> {
                        TodoDatabase.getInstance(getContext()).todoDao().updateTodo(item);
                        requireActivity().runOnUiThread(() -> adapter.notifyDataSetChanged());
                    });
                })
                .setNegativeButton("취소", null)
                .show();
    }

    private void onTodoDelete(TodoItem item) {
        new AlertDialog.Builder(getContext())
                .setTitle("할 일 삭제")
                .setMessage("이 항목을 삭제할까요?")
                .setPositiveButton("삭제", (dialog, which) -> {
                    Executors.newSingleThreadExecutor().execute(() -> {
                        TodoDatabase.getInstance(getContext()).todoDao().deleteTodo(item);
                        requireActivity().runOnUiThread(this::loadTodayTodos);
                    });
                })
                .setNegativeButton("취소", null)
                .show();
    }

    private void showDeleteAllDialog() {
        long todayStart = DateUtils.getTodayStartTimestamp();

        new AlertDialog.Builder(getContext())
                .setTitle("전체 삭제")
                .setMessage("오늘 등록된 모든 할 일을 삭제할까요?")
                .setPositiveButton("삭제", (dialog, which) -> {
                    Executors.newSingleThreadExecutor().execute(() -> {
                        TodoDatabase.getInstance(getContext()).todoDao().deleteAllTodayTodos(todayStart);
                        requireActivity().runOnUiThread(this::loadTodayTodos);
                    });
                })
                .setNegativeButton("취소", null)
                .show();
    }
}
