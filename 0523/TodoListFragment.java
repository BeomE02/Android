package com.example.todomanager.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.todomanager.R;
import com.example.todomanager.adapter.TodoAdapter;
import com.example.todomanager.db.TodoDatabase;
import com.example.todomanager.model.TodoItem;
import com.example.todomanager.util.DateUtils;

import java.util.*;
import java.util.concurrent.Executors;

public class TodoListFragment extends Fragment {

    // UI 컴포넌트들
    private SwipeRefreshLayout swipeRefresh;
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

        initViews(view);
        setupRecyclerView();
        setupSwipeRefresh();
        setupClickListeners();

        loadTodayTodos();
        return view;
    }

    /**
     * 뷰 초기화
     */
    private void initViews(View view) {
        swipeRefresh = view.findViewById(R.id.swipeRefresh);
        recyclerView = view.findViewById(R.id.recyclerView);
        tvEmpty = view.findViewById(R.id.tvEmpty);
        btnDeleteAll = view.findViewById(R.id.btnDeleteAll);
    }

    /**
     * RecyclerView 설정
     */
    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new TodoAdapter(
                todoList,
                this::onTodoComplete,
                this::onTodoDelete
        );
        recyclerView.setAdapter(adapter);
    }

    /**
     * SwipeRefreshLayout 설정
     */
    private void setupSwipeRefresh() {
        swipeRefresh.setOnRefreshListener(this::loadTodayTodos);

        // 새로고침 색상 설정
        swipeRefresh.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
    }

    /**
     * 클릭 리스너 설정
     */
    private void setupClickListeners() {
        btnDeleteAll.setOnClickListener(v -> showDeleteAllDialog());
    }

    /**
     * 오늘의 할 일 목록 로딩
     */
    private void loadTodayTodos() {
        // 새로고침 애니메이션 시작
        if (!swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(true);
        }

        long todayStart = DateUtils.getTodayStartTimestamp();

        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                // 데이터베이스에서 오늘의 할 일 가져오기
                List<TodoItem> data = TodoDatabase.getInstance(getContext())
                        .todoDao().getTodayTodos(todayStart);

                // UI 스레드에서 UI 업데이트
                requireActivity().runOnUiThread(() -> {
                    updateUI(data);
                    swipeRefresh.setRefreshing(false); // 로딩 완료
                });

            } catch (Exception e) {
                // 에러 발생 시 UI 스레드에서 처리
                requireActivity().runOnUiThread(() -> {
                    swipeRefresh.setRefreshing(false);
                    Toast.makeText(getContext(), "데이터 로딩 중 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
                });
            }
        });
    }

    /**
     * UI 업데이트 (데이터 변경 반영)
     */
    private void updateUI(List<TodoItem> data) {
        todoList.clear();
        todoList.addAll(data);
        adapter.notifyDataSetChanged();

        boolean isEmpty = todoList.isEmpty();
        recyclerView.setVisibility(isEmpty ? View.GONE : View.VISIBLE);
        tvEmpty.setVisibility(isEmpty ? View.VISIBLE : View.GONE);
        btnDeleteAll.setVisibility(isEmpty ? View.GONE : View.VISIBLE);
    }

    /**
     * 할 일 완료 처리
     */
    private void onTodoComplete(TodoItem item) {
        if (item.isDone) return;

        new AlertDialog.Builder(getContext())
                .setTitle("할 일 완료")
                .setMessage("정말 완료하셨나요?")
                .setPositiveButton("네", (dialog, which) -> {
                    item.isDone = true;
                    item.doneTime = System.currentTimeMillis();

                    Executors.newSingleThreadExecutor().execute(() -> {
                        try {
                            TodoDatabase.getInstance(getContext()).todoDao().updateTodo(item);
                            requireActivity().runOnUiThread(() -> {
                                adapter.notifyDataSetChanged();
                                Toast.makeText(getContext(), "🎉 할 일을 완료했습니다!", Toast.LENGTH_SHORT).show();
                            });
                        } catch (Exception e) {
                            requireActivity().runOnUiThread(() -> {
                                Toast.makeText(getContext(), "완료 처리 중 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
                            });
                        }
                    });
                })
                .setNegativeButton("취소", null)
                .show();
    }

    /**
     * 할 일 삭제 처리
     */
    private void onTodoDelete(TodoItem item) {
        new AlertDialog.Builder(getContext())
                .setTitle("할 일 삭제")
                .setMessage("이 항목을 삭제할까요?")
                .setPositiveButton("삭제", (dialog, which) -> {
                    Executors.newSingleThreadExecutor().execute(() -> {
                        try {
                            TodoDatabase.getInstance(getContext()).todoDao().deleteTodo(item);
                            requireActivity().runOnUiThread(() -> {
                                loadTodayTodos(); // 목록 새로고침
                                Toast.makeText(getContext(), "할 일이 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                            });
                        } catch (Exception e) {
                            requireActivity().runOnUiThread(() -> {
                                Toast.makeText(getContext(), "삭제 중 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
                            });
                        }
                    });
                })
                .setNegativeButton("취소", null)
                .show();
    }

    /**
     * 전체 삭제 확인 다이얼로그
     */
    private void showDeleteAllDialog() {
        long todayStart = DateUtils.getTodayStartTimestamp();

        new AlertDialog.Builder(getContext())
                .setTitle("전체 삭제")
                .setMessage("오늘 등록된 모든 할 일을 삭제할까요?")
                .setPositiveButton("삭제", (dialog, which) -> {
                    Executors.newSingleThreadExecutor().execute(() -> {
                        try {
                            TodoDatabase.getInstance(getContext()).todoDao().deleteAllTodayTodos(todayStart);
                            requireActivity().runOnUiThread(() -> {
                                loadTodayTodos(); // 목록 새로고침
                                Toast.makeText(getContext(), "모든 할 일이 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                            });
                        } catch (Exception e) {
                            requireActivity().runOnUiThread(() -> {
                                Toast.makeText(getContext(), "삭제 중 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
                            });
                        }
                    });
                })
                .setNegativeButton("취소", null)
                .show();
    }

    /**
     * Fragment가 다시 보여질 때 데이터 새로고침
     */
    @Override
    public void onResume() {
        super.onResume();
        loadTodayTodos();
    }

    /**
     * 메모리 누수 방지를 위한 정리
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (swipeRefresh != null) {
            swipeRefresh.setOnRefreshListener(null);
        }
    }
}