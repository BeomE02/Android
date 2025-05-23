// 1. CalendarFragment.java - 새로운 캘린더 Fragment
package com.example.todomanager.fragment;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.todomanager.R;
import com.example.todomanager.adapter.CalendarAdapter;
import com.example.todomanager.db.TodoDatabase;
import com.example.todomanager.model.CalendarDay;
import com.example.todomanager.model.TodoItem;
import java.util.*;
import java.util.concurrent.Executors;

public class CalendarFragment extends Fragment {

    private RecyclerView calendarRecyclerView;
    private CalendarAdapter calendarAdapter;
    private TextView tvCurrentMonth;
    private Button btnPrevMonth, btnNextMonth;

    private Calendar currentCalendar;
    private List<CalendarDay> calendarDays = new ArrayList<>();

    public CalendarFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        initViews(view);
        setupCalendar();
        loadCalendarData();

        return view;
    }

    private void initViews(View view) {
        calendarRecyclerView = view.findViewById(R.id.calendarRecyclerView);
        tvCurrentMonth = view.findViewById(R.id.tvCurrentMonth);
        btnPrevMonth = view.findViewById(R.id.btnPrevMonth);
        btnNextMonth = view.findViewById(R.id.btnNextMonth);

        // 7x6 그리드 (요일 x 주)
        calendarRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 7));

        calendarAdapter = new CalendarAdapter(calendarDays, this::onDateClick);
        calendarRecyclerView.setAdapter(calendarAdapter);

        btnPrevMonth.setOnClickListener(v -> {
            currentCalendar.add(Calendar.MONTH, -1);
            loadCalendarData();
        });

        btnNextMonth.setOnClickListener(v -> {
            currentCalendar.add(Calendar.MONTH, 1);
            loadCalendarData();
        });
    }

    private void setupCalendar() {
        currentCalendar = Calendar.getInstance();
    }

    private void loadCalendarData() {
        updateMonthTitle();

        Executors.newSingleThreadExecutor().execute(() -> {
            // 현재 월의 첫날과 마지막날 계산
            Calendar monthStart = (Calendar) currentCalendar.clone();
            monthStart.set(Calendar.DAY_OF_MONTH, 1);
            monthStart.set(Calendar.HOUR_OF_DAY, 0);
            monthStart.set(Calendar.MINUTE, 0);
            monthStart.set(Calendar.SECOND, 0);
            monthStart.set(Calendar.MILLISECOND, 0);

            Calendar monthEnd = (Calendar) monthStart.clone();
            monthEnd.add(Calendar.MONTH, 1);
            monthEnd.add(Calendar.MILLISECOND, -1);

            // 해당 월의 모든 할 일 가져오기
            List<TodoItem> monthTodos = TodoDatabase.getInstance(getContext())
                    .todoDao().getTodosInRange(monthStart.getTimeInMillis(), monthEnd.getTimeInMillis());

            // 캘린더 데이터 생성
            List<CalendarDay> newCalendarDays = generateCalendarDays(monthStart, monthTodos);

            requireActivity().runOnUiThread(() -> {
                calendarDays.clear();
                calendarDays.addAll(newCalendarDays);
                calendarAdapter.notifyDataSetChanged();
            });
        });
    }

    private List<CalendarDay> generateCalendarDays(Calendar monthStart, List<TodoItem> todos) {
        List<CalendarDay> days = new ArrayList<>();

        // 월의 첫 주 시작일 (일요일부터)
        Calendar cal = (Calendar) monthStart.clone();
        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1; // 0=일요일
        cal.add(Calendar.DAY_OF_MONTH, -firstDayOfWeek);

        // 6주간 생성 (42일)
        for (int i = 0; i < 42; i++) {
            CalendarDay day = new CalendarDay();
            day.date = (Calendar) cal.clone();
            day.dayNumber = cal.get(Calendar.DAY_OF_MONTH);
            day.isCurrentMonth = cal.get(Calendar.MONTH) == monthStart.get(Calendar.MONTH);
            day.isToday = isToday(cal);

            // 해당 날짜의 할 일 개수 계산
            day.todoCount = getTodoCountForDate(cal, todos);
            day.completedCount = getCompletedCountForDate(cal, todos);

            days.add(day);
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }

        return days;
    }

    private int getTodoCountForDate(Calendar date, List<TodoItem> todos) {
        int count = 0;
        Calendar dayStart = (Calendar) date.clone();
        dayStart.set(Calendar.HOUR_OF_DAY, 0);
        dayStart.set(Calendar.MINUTE, 0);
        dayStart.set(Calendar.SECOND, 0);
        dayStart.set(Calendar.MILLISECOND, 0);

        Calendar dayEnd = (Calendar) dayStart.clone();
        dayEnd.add(Calendar.DAY_OF_MONTH, 1);
        dayEnd.add(Calendar.MILLISECOND, -1);

        for (TodoItem todo : todos) {
            if (todo.timestamp >= dayStart.getTimeInMillis() &&
                    todo.timestamp <= dayEnd.getTimeInMillis()) {
                count++;
            }
        }
        return count;
    }

    private int getCompletedCountForDate(Calendar date, List<TodoItem> todos) {
        int count = 0;
        Calendar dayStart = (Calendar) date.clone();
        dayStart.set(Calendar.HOUR_OF_DAY, 0);
        dayStart.set(Calendar.MINUTE, 0);
        dayStart.set(Calendar.SECOND, 0);
        dayStart.set(Calendar.MILLISECOND, 0);

        Calendar dayEnd = (Calendar) dayStart.clone();
        dayEnd.add(Calendar.DAY_OF_MONTH, 1);
        dayEnd.add(Calendar.MILLISECOND, -1);

        for (TodoItem todo : todos) {
            if (todo.timestamp >= dayStart.getTimeInMillis() &&
                    todo.timestamp <= dayEnd.getTimeInMillis() && todo.isDone) {
                count++;
            }
        }
        return count;
    }

    private boolean isToday(Calendar cal) {
        Calendar today = Calendar.getInstance();
        return cal.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                cal.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR);
    }

    private void updateMonthTitle() {
        String[] months = {"1월", "2월", "3월", "4월", "5월", "6월",
                "7월", "8월", "9월", "10월", "11월", "12월"};

        String title = currentCalendar.get(Calendar.YEAR) + "년 " +
                months[currentCalendar.get(Calendar.MONTH)];
        tvCurrentMonth.setText(title);
    }

    private void onDateClick(CalendarDay day) {
        if (!day.isCurrentMonth) return;

        // 선택된 날짜의 할 일 목록 보기
        DayDetailFragment fragment = DayDetailFragment.newInstance(day.date.getTimeInMillis());
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}