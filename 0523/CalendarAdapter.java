// CalendarAdapter.java - 수정된 캘린더 어댑터
package com.example.todomanager.adapter;

import android.graphics.Color;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.todomanager.R;
import com.example.todomanager.model.CalendarDay;
import java.util.List;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder> {

    private final List<CalendarDay> calendarDays;
    private final OnDateClickListener dateClickListener;

    public interface OnDateClickListener {
        void onDateClick(CalendarDay day);
    }

    public CalendarAdapter(List<CalendarDay> calendarDays, OnDateClickListener listener) {
        this.calendarDays = calendarDays;
        this.dateClickListener = listener;
        setHasStableIds(true); // 성능 최적화
    }

    @Override
    public long getItemId(int position) {
        if (position < 0 || position >= calendarDays.size()) {
            return RecyclerView.NO_ID;
        }

        CalendarDay day = calendarDays.get(position);
        if (day != null && day.date != null) {
            return day.date.getTimeInMillis(); // 고유 ID로 날짜 사용
        }
        return position; // fallback으로 position 사용
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_calendar_day, parent, false);
        return new CalendarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        if (position < 0 || position >= calendarDays.size()) {
            return;
        }

        CalendarDay day = calendarDays.get(position);
        if (day != null) {
            holder.bind(day, dateClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return calendarDays != null ? calendarDays.size() : 0;
    }

    static class CalendarViewHolder extends RecyclerView.ViewHolder {
        TextView tvDay, tvTodoCount;

        public CalendarViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDay = itemView.findViewById(R.id.tvDay);
            tvTodoCount = itemView.findViewById(R.id.tvTodoCount);
        }

        public void bind(CalendarDay day, OnDateClickListener listener) {
            if (day == null) return;

            // 날짜 숫자 설정
            tvDay.setText(String.valueOf(day.dayNumber));

            // 기본 상태 리셋
            resetToDefaultState();

            // 현재 월이 아닌 날짜는 흐리게
            if (!day.isCurrentMonth) {
                tvDay.setTextColor(Color.LTGRAY);
                tvTodoCount.setVisibility(View.GONE);
            } else {
                // 오늘 날짜 강조
                if (day.isToday) {
                    highlightToday();
                }

                // 할 일 개수 표시
                displayTodoCount(day);
            }

            // 클릭 리스너 설정
            setClickListener(day, listener);
        }

        private void resetToDefaultState() {
            itemView.setBackgroundColor(Color.WHITE);
            tvDay.setTextColor(Color.BLACK);
            tvTodoCount.setVisibility(View.GONE);
        }

        private void highlightToday() {
            tvDay.setTextColor(Color.WHITE);
            itemView.setBackgroundColor(Color.parseColor("#2196F3"));
        }

        private void displayTodoCount(CalendarDay day) {
            if (day.hasTodos()) {
                tvTodoCount.setVisibility(View.VISIBLE);
                String countText = day.completedCount + "/" + day.todoCount;
                tvTodoCount.setText(countText);

                // 완료 상태에 따른 색상 변경
                if (day.isAllCompleted()) {
                    tvTodoCount.setTextColor(Color.parseColor("#4CAF50")); // 모두 완료: 초록색
                } else if (day.hasPartialCompletion()) {
                    tvTodoCount.setTextColor(Color.parseColor("#FF9800")); // 일부 완료: 주황색
                } else {
                    tvTodoCount.setTextColor(Color.parseColor("#F44336")); // 미완료: 빨간색
                }
            } else {
                tvTodoCount.setVisibility(View.GONE);
            }
        }

        private void setClickListener(CalendarDay day, OnDateClickListener listener) {
            itemView.setOnClickListener(v -> {
                if (listener != null && day.isCurrentMonth) {
                    listener.onDateClick(day);
                }
            });
        }
    }
}