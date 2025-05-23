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
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;

public class DayDetailFragment extends Fragment {

    private static final String ARG_DATE = "date";

    private RecyclerView recyclerView;
    private TodoAdapter adapter;
    private List<TodoItem> todoList = new ArrayList<>();
    private TextView tvDateTitle, tvEmpty;
    private Button btnAddTodo;

    private long selectedDate;

    public static DayDetailFragment newInstance(long date) {
        DayDetailFragment fragment = new DayDetailFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_DATE, date);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            selectedDate = getArguments().getLong(ARG_DATE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day_detail, container, false);

        initViews(view);
        setupDateTitle();
        loadDayTodos();

        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        tvDateTitle = view.findViewById(R.id.tvDateTitle);
        tvEmpty = view.findViewById(R.id.tvEmpty);
        btnAddTodo = view.findViewById(R.id.btnAddTodo);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TodoAdapter(todoList, this::onTodoComplete, this::onTodoDelete);
        recyclerView.setAdapter(adapter);

        btnAddTodo.setOnClickListener(v -> {
            AddTodoFragment fragment = AddTodoFragment.newInstanceWithDate(selectedDate);
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
        });
    }

    private void setupDateTitle() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E)", Locale.KOREAN);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(selectedDate);
        tvDateTitle.setText(sdf.format(cal.getTime()));
    }

    private void loadDayTodos() {
        Calendar dayStart = Calendar.getInstance();
        dayStart.setTimeInMillis(selectedDate);
        dayStart.set(Calendar.HOUR_OF_DAY, 0);
        dayStart.set(Calendar.MINUTE, 0);
        dayStart.set(Calendar.SECOND, 0);
        dayStart.set(Calendar.MILLISECOND, 0);

        Calendar dayEnd = (Calendar) dayStart.clone();
        dayEnd.add(Calendar.DAY_OF_MONTH, 1);
        dayEnd.add(Calendar.MILLISECOND, -1);

        Executors.newSingleThreadExecutor().execute(() -> {
            List<TodoItem> data = TodoDatabase.getInstance(getContext())
                    .todoDao().getTodosInRange(dayStart.getTimeInMillis(), dayEnd.getTimeInMillis());

            requireActivity().runOnUiThread(() -> {
                todoList.clear();
                todoList.addAll(data);
                adapter.notifyDataSetChanged();

                boolean isEmpty = todoList.isEmpty();
                recyclerView.setVisibility(isEmpty ? View.GONE : View.VISIBLE);
                tvEmpty.setVisibility(isEmpty ? View.VISIBLE : View.GONE);
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
                        requireActivity().runOnUiThread(this::loadDayTodos);
                    });
                })
                .setNegativeButton("취소", null)
                .show();
    }
}